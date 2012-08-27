package com.boan.crm.sellrecord.action;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.boan.crm.customer.model.CustomerInfo;
import com.boan.crm.customer.service.ICustomerInfoService;
import com.boan.crm.groupmanage.common.UserSession;
import com.boan.crm.sellrecord.model.GoodsInfo;
import com.boan.crm.sellrecord.model.SellRecord;
import com.boan.crm.sellrecord.service.ISellRecordService;
import com.boan.crm.sms.model.SMSInfo;
import com.boan.crm.utils.action.BaseActionSupport;
import com.boan.crm.utils.page.Pagination;

@Controller("sellRecordAction")
@Scope("prototype")
public class SellRecordAction extends BaseActionSupport{

	/**
	 * 客户信息
	 */
	private CustomerInfo customer;
	
	@Autowired
	@Qualifier("customerInfoService")
	//客户状态接口类
	private ICustomerInfoService customerInfoService;
	
	/**
	 * 商品明细
	 */
	private List<String> detials = new ArrayList<String>();
	
	/**
	 * 销售记录信息
	 */
	private SellRecord sellRecord;
	
	@Autowired
	@Qualifier("sellRecordService")
	private ISellRecordService sellRecordService;
	/**
	 * 销售员所有的客户
	 */
	private List<CustomerInfo> customerInfos = new ArrayList<CustomerInfo>();
	
	/**
	 * 提示信息
	 */
	private String message;
	
	/**
	 * 显示分页
	 */
	private Pagination<SellRecord> pagination = new Pagination<SellRecord>();
	
	public String openSellRecordList(){
		return SUCCESS;
	}
	
	public String openAddSellRecord(){
		CustomerInfo obj  =   new CustomerInfo();
		obj.setId("11");
		obj.setCustomerName("张三");
		customerInfos.add(obj);
		return SUCCESS;
	}
	public String openModifySellRecord(){
		return SUCCESS;
	}
	
	public String addSellRecord(){
		//查找客户信息
//		customer = customerInfoService.get(customer.getId());
		sellRecord.setCustomer(customer);
//		sellRecord.setCustomerId(customer.getId());//设置客户Id
//		sellRecord.setCustomerName(customer.getCustomerName());
		UserSession userSession = this.getSession();
		sellRecord.setSalesmanId(userSession.getUserId());//设置销售员Id
		sellRecord.setSalesmanName(userSession.getUserCName());
		Set<GoodsInfo> goodsDetials = new HashSet<GoodsInfo>();
		for(String str  : detials){
			String[] array = str.split("☆");
			System.out.println(array[0]);
			GoodsInfo goods = new GoodsInfo();
			goods.setGoodsName(array[0]);
			goods.setStandard(array[1]);
			goods.setWeight(new BigDecimal(array[2]));
			goods.setPrice(new BigDecimal(array[3]));
			goods.setNumber(Integer.parseInt(array[4]));
			goods.setAllPrice(new BigDecimal(array[5]));
			goodsDetials.add(goods );
		}
		sellRecord.setGoodsDetials(goodsDetials );
		
		try {
			//保存或更新销售记录
			sellRecordService.saveOrUpdate(sellRecord);
			message="保存成功！";
		} catch (Exception e) {
			message="保存失败！";
			e.printStackTrace();
		}
		return "message";
	}
	
	public String modifySellRecord(){
		return SUCCESS;
	}
	
	public String deleteSellRecord(){
		return NONE;
	}
	
	
	public String openAddSellRecordDetial(){
		return SUCCESS;
	}
	public String openModifySellRecordDetial(){
		return SUCCESS;
	}
	
	public String addSellRecordDetial(){
		return SUCCESS;
	}
	
	public String modifySellRecordDetial(){
		return SUCCESS;
	}

	public List<String> getDetials() {
		return detials;
	}

	public void setDetials(List<String> detials) {
		this.detials = detials;
	}

	public List<CustomerInfo> getCustomerInfos() {
		return customerInfos;
	}

	public void setCustomerInfos(List<CustomerInfo> customerInfos) {
		this.customerInfos = customerInfos;
	}

	public CustomerInfo getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerInfo customer) {
		this.customer = customer;
	}

	public SellRecord getSellRecord() {
		return sellRecord;
	}

	public void setSellRecord(SellRecord sellRecord) {
		this.sellRecord = sellRecord;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Pagination<SellRecord> getPagination() {
		return pagination;
	}

	public void setPagination(Pagination<SellRecord> pagination) {
		this.pagination = pagination;
	}
}

package com.boan.crm.sellrecord.action;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.boan.crm.customer.model.CustomerInfo;
import com.boan.crm.customer.service.ICustomerInfoService;
import com.boan.crm.groupmanage.common.UserSession;
import com.boan.crm.groupmanage.model.User;
import com.boan.crm.groupmanage.service.IUserService;
import com.boan.crm.sellrecord.model.GoodsInfo;
import com.boan.crm.sellrecord.model.SellRecord;
import com.boan.crm.sellrecord.service.IGoodsInfoService;
import com.boan.crm.sellrecord.service.ISellRecordService;
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
	
	@Autowired
	@Qualifier("goodsInfoService")
	private IGoodsInfoService goodsInfoService;
	
	@Autowired
	@Qualifier("userService")
	private IUserService userService = null;
	
	/**
	 * 销售员所有的客户
	 */
	private List<CustomerInfo> customerInfos = new ArrayList<CustomerInfo>();
	
	/**
	 * 员工数组
	 */
	private List<User> userList = null;
	
	/**
	 * 提示信息
	 */
	private String message;
	
	/**
	 * 显示分页
	 */
	private Pagination<SellRecord> pagination = new Pagination<SellRecord>();

	private String[] ids;
	
	//--------------查询条件-------------------------//
	private String queryCustomerName;
	
	private String queryLinkman;
	
	private String querySalesman;
	
	private String queryReturnedMoney;
	
	private String queryBargainTimeBegin;
	
	private String queryBargainTimeEnd;
	//--------------查询条件-------------------------//
	
	public String openSellRecordList() throws Exception{
		userList =userService.queryUserList( sessionCompanyId, sessionDeptId, new Pagination<User>()).getData();
		Map<String, String> params = new HashMap<String, String>();
		if(queryCustomerName!=null  && !queryCustomerName.trim().equals("")){
			params.put("queryCustomerName", queryCustomerName);
		}
		if(querySalesman!=null && !querySalesman.trim().equals("")){
			params.put("querySalesman", querySalesman);
		}
		if(queryBargainTimeBegin!=null && !queryBargainTimeBegin.trim().equals("")){
			params.put("queryBargainTimeBegin", queryBargainTimeBegin);
		}
		if(queryBargainTimeBegin!=null  && !queryBargainTimeBegin.trim().equals("")){
			params.put("queryBargainTimeEnd", queryBargainTimeEnd);
		}
		pagination = sellRecordService.findSellRecordForPage(params ,pagination);
		return SUCCESS;
	}
	
	public String openAddSellRecord(){
		customerInfos= customerInfoService.findAllCustomerInfo();
		return SUCCESS;
	}
	public String openModifySellRecord(){
		customerInfos= customerInfoService.findAllCustomerInfo();
		sellRecord = sellRecordService.getSellRecordById(sellRecord.getId());
		return SUCCESS;
	}
	
	public String addSellRecord(){
		customerInfos= customerInfoService.findAllCustomerInfo();
		//查找客户信息
		customer = customerInfoService.get(sellRecord.getCustomerId());
		sellRecord.setCustomer(customer);
		sellRecord.setCustomerId(customer.getId());//设置客户Id
		sellRecord.setCustomerName(customer.getCustomerName());
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
		sellRecord = sellRecordService.getSellRecordById(sellRecord.getId());
//		return "message";
		return SUCCESS;
	}
	
	public String modifySellRecord(){
		return SUCCESS;
	}
	
	public String deleteSellRecord(){
		sellRecordService.deleteSellRecordByIds(ids);
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
	
	public String deleteSellRecordDetials(){
		goodsInfoService.deleteGoodsInfoByIds(ids);
		return NONE;
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

	public String[] getIds() {
		return ids;
	}

	public void setIds(String[] ids) {
		this.ids = ids;
	}

	public String getQueryCustomerName() {
		return queryCustomerName;
	}

	public void setQueryCustomerName(String queryCustomerName) {
		this.queryCustomerName = queryCustomerName;
	}

	public String getQueryLinkman() {
		return queryLinkman;
	}

	public void setQueryLinkman(String queryLinkman) {
		this.queryLinkman = queryLinkman;
	}

	public String getQuerySalesman() {
		return querySalesman;
	}

	public void setQuerySalesman(String querySalesman) {
		this.querySalesman = querySalesman;
	}

	public String getQueryReturnedMoney() {
		return queryReturnedMoney;
	}

	public void setQueryReturnedMoney(String queryReturnedMoney) {
		this.queryReturnedMoney = queryReturnedMoney;
	}

	public String getQueryBargainTimeBegin() {
		return queryBargainTimeBegin;
	}

	public void setQueryBargainTimeBegin(String queryBargainTimeBegin) {
		this.queryBargainTimeBegin = queryBargainTimeBegin;
	}

	public String getQueryBargainTimeEnd() {
		return queryBargainTimeEnd;
	}

	public void setQueryBargainTimeEnd(String queryBargainTimeEnd) {
		this.queryBargainTimeEnd = queryBargainTimeEnd;
	}

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}
}

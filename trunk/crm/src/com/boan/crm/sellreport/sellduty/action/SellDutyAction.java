package com.boan.crm.sellreport.sellduty.action;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.boan.crm.sellreport.sellduty.model.SellDuty;
import com.boan.crm.sellreport.sellduty.service.ISellDutyService;
import com.boan.crm.utils.action.BaseActionSupport;
import com.boan.crm.utils.page.Pagination;

/**销售职责Action
 * @author YF
 *
 */
@Controller("sellDutyAction")
@Scope("prototype")
public class SellDutyAction extends BaseActionSupport{

	private static final long serialVersionUID = -9032000064877492164L;

	@Autowired
	@Qualifier("sellDutyService")
	private ISellDutyService sellDutyService = null;
	
	/**
	 * 销售职责实体
	 */
	private SellDuty sellDuty;
	/**
	 * 显示分页
	 */
	private Pagination<SellDuty> pagination = new Pagination<SellDuty>();
	
	/**
	 * 提示信息
	 */
	private String message;
	
	/**
	 * 选择的时间计划Id
	 */
	private String[] ids;
	
	/**
	 * @return
	 */
	public String openSellDutyList(){
		Map<String, String> param = new HashMap<String, String>();
		param.put("companyId", this.sessionCompanyId);
		pagination = sellDutyService.findSellDutyForPage(param , pagination);
		return SUCCESS;
	}
	
	/**
	 * @return
	 */
	public String openAddSellDuty(){
		sellDuty=new SellDuty();
		return SUCCESS;
	}
	
	/**
	 * @return
	 */
	public String openModifySellDuty(){
		sellDuty =  sellDutyService.getSellDutyById(sellDuty.getId());
		return SUCCESS;
	}
	
	/**
	 * @return
	 */
	public String addSellDuty(){
		sellDuty.setCompanyId(this.sessionCompanyId);
		sellDuty.setCompanyName(this.sessionCompanyName);
		//（0：周报，周计划职责类型  1： 月报，月计划职责类型）
		sellDuty.setCreateTime(Calendar.getInstance());
		if(sellDuty.getId().equals("")){
			sellDuty.setId(null);
		}
		sellDutyService.saveOrUpdateSellDuty(sellDuty);
		message="保存成功！";
		return SUCCESS;
	}
	
	/**
	 * 保存前验证
	 */
	public void validateAddSellDuty(){
		boolean flag = sellDutyService.isExistSameName(sellDuty.getName(),sellDuty.getId(),this.sessionCompanyId,sellDuty.getDutyType());
		if(flag){
			this.addFieldError("", "相同职责类型下已经存在该职责名称，请重新输入！");
		}
//		if(sellDuty.isNumberType()){
//			String name = sellDuty.getName().trim();
//			try {
//				Double temp = Double.parseDouble(name);
//			} catch (NumberFormatException e) {
//				this.addFieldError("", "如果您数值型，请保证职责名称输入的是数字类型！");
//			}
//		}
	}
	
	/**
	 * @return
	 */
	public String modifySellDuty(){
		sellDutyService.saveOrUpdateSellDuty(sellDuty);
		message="保存成功！";
		return SUCCESS;
	}
	
	/**
	 * 修改前验证
	 */
	public void validateModifySellDuty(){
		boolean flag = sellDutyService.isExistSameName(sellDuty.getName(),sellDuty.getId(),this.sessionCompanyId,sellDuty.getDutyType());
		if(flag){
			this.addFieldError("", "相同职责类型下已经存在该职责名称，请重新输入！");
		}
//		if(sellDuty.isNumberType()){
//			String name = sellDuty.getName().trim();
//			try {
//				Double temp = Double.parseDouble(name);
//			} catch (NumberFormatException e) {
//				this.addFieldError("", "如果您数值型，请保证职责名称输入的是数字类型！");
//			}
//		}
	}
	
	/**
	 * @return
	 */
	public String deleteSellDuty(){
		if(ids!=null){
			sellDutyService.deleteSellDuty(ids);
		}
		return NONE;
	}

	public SellDuty getSellDuty() {
		return sellDuty;
	}

	public void setSellDuty(SellDuty sellDuty) {
		this.sellDuty = sellDuty;
	}

	public Pagination<SellDuty> getPagination() {
		return pagination;
	}

	public void setPagination(Pagination<SellDuty> pagination) {
		this.pagination = pagination;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String[] getIds() {
		return ids;
	}

	public void setIds(String[] ids) {
		this.ids = ids;
	}
}

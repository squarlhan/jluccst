package com.boan.crm.sellreport.monthly.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.boan.crm.sellreport.monthly.model.MonthlyItemInfo;
import com.boan.crm.sellreport.monthly.service.IMonthlyItemInfoService;
import com.boan.crm.sellreport.sellduty.model.SellDuty;
import com.boan.crm.sellreport.sellduty.service.ISellDutyService;
import com.boan.crm.utils.action.BaseActionSupport;
import com.boan.crm.utils.page.Pagination;

@Controller("monthlyItemInfoAction")
@Scope("prototype")
public class MonthlyItemInfoAction extends BaseActionSupport{


	@Autowired
	@Qualifier("sellDutyService")
	private ISellDutyService sellDutyService = null;
	
	@Autowired
	@Qualifier("monthlyItemInfoService")
	private IMonthlyItemInfoService monthlyItemInfoService = null;
	
	/**
	 * 职责类型
	 */
	private List<SellDuty> sellDutyList = new ArrayList<SellDuty>();
	
	/**
	 * 月计划子信息
	 */
	private MonthlyItemInfo monthlyItemInfo;
	
	/**
	 * 分页对象
	 */
	private Pagination<MonthlyItemInfo> pagination = new Pagination<MonthlyItemInfo>();
	
	/**
	 * 主信息Id
	 */
	private String mainInfoId;
	
	/**
	 * 选择的Id
	 */
	private String[] ids;
	
	/**
	 * 提示信息
	 */
	private String message;
	
	public String openMonthlyItemList(){
		Map param = new HashMap();
		if(mainInfoId!=null && !mainInfoId.equals("")){
			param.put("mainInfoId",mainInfoId);
		}
		monthlyItemInfoService.findMonthlyItemInfoForPage(param,pagination);
		pagination.setTotalPages(100);
		return this.SUCCESS;
	}
	public String openMonthlyItemListView(){
		Map param = new HashMap();
		if(mainInfoId!=null && !mainInfoId.equals("")){
			param.put("mainInfoId",mainInfoId);
		}
		monthlyItemInfoService.findMonthlyItemInfoForPage(param,pagination);
		pagination.setTotalPages(100);
		return this.SUCCESS;
	}

	public String openAddMonthlyItem(){
		sellDutyList = sellDutyService.findAllSellDutyByCompanyIdAndDutyType(this.sessionCompanyId,1);
		return this.SUCCESS;
	}
	
	public String openModifyMonthlyItem(){
		monthlyItemInfo= monthlyItemInfoService.getMonthlyItemInfoById(monthlyItemInfo.getId());
		
		sellDutyList = sellDutyService.findAllSellDutyByCompanyIdAndDutyType(this.sessionCompanyId,1);
		return this.SUCCESS;
	}
	public String openViewMonthlyItem(){
		monthlyItemInfo= monthlyItemInfoService.getMonthlyItemInfoById(monthlyItemInfo.getId());
		
		sellDutyList = sellDutyService.findAllSellDutyByCompanyIdAndDutyType(this.sessionCompanyId,1);
		return this.SUCCESS;
	}
	
	public String addMonthlyItem(){
		
		if(monthlyItemInfo.getId()!=null && monthlyItemInfo.getId().equals("")){
			monthlyItemInfo.setId(null);
		}
		monthlyItemInfoService.saveOrUpdateMonthlyItemInfo(monthlyItemInfo);
		sellDutyList = sellDutyService.findAllSellDutyByCompanyIdAndDutyType(this.sessionCompanyId,1);
		message="保存成功！";
		return this.SUCCESS;
	}
	
	public String modifyMonthlyItem(){
		monthlyItemInfoService.saveOrUpdateMonthlyItemInfo(monthlyItemInfo);
		sellDutyList = sellDutyService.findAllSellDutyByCompanyIdAndDutyType(this.sessionCompanyId,1);
		message="保存成功！";
		return this.SUCCESS;
	}
	public String deleteMonthlyItem(){
		monthlyItemInfoService.deleteMonthlyItemInfoByIds(ids);
		return this.NONE;
	}
	
	public MonthlyItemInfo getMonthlyItemInfo() {
		return monthlyItemInfo;
	}

	public void setMonthlyItemInfo(MonthlyItemInfo monthlyItemInfo) {
		this.monthlyItemInfo = monthlyItemInfo;
	}

	public List<SellDuty> getSellDutyList() {
		return sellDutyList;
	}

	public void setSellDutyList(List<SellDuty> sellDutyList) {
		this.sellDutyList = sellDutyList;
	}

	public String getMainInfoId() {
		return mainInfoId;
	}

	public void setMainInfoId(String mainInfoId) {
		this.mainInfoId = mainInfoId;
	}

	public String[] getIds() {
		return ids;
	}

	public void setIds(String[] ids) {
		this.ids = ids;
	}

	public Pagination<MonthlyItemInfo> getPagination() {
		return pagination;
	}

	public void setPagination(Pagination<MonthlyItemInfo> pagination) {
		this.pagination = pagination;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}

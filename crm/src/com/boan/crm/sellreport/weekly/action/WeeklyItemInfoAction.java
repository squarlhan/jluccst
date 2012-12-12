package com.boan.crm.sellreport.weekly.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.boan.crm.sellreport.weekly.model.WeeklyItemInfo;
import com.boan.crm.sellreport.weekly.service.IWeeklyItemInfoService;
import com.boan.crm.sellreport.sellduty.model.SellDuty;
import com.boan.crm.sellreport.sellduty.service.ISellDutyService;
import com.boan.crm.utils.action.BaseActionSupport;
import com.boan.crm.utils.page.Pagination;

@Controller("weeklyItemInfoAction")
@Scope("prototype")
public class WeeklyItemInfoAction extends BaseActionSupport{


	@Autowired
	@Qualifier("sellDutyService")
	private ISellDutyService sellDutyService = null;
	
	@Autowired
	@Qualifier("weeklyItemInfoService")
	private IWeeklyItemInfoService weeklyItemInfoService = null;
	
	/**
	 * 职责类型
	 */
	private List<SellDuty> sellDutyList = new ArrayList<SellDuty>();
	
	/**
	 * 周计划子信息
	 */
	private WeeklyItemInfo weeklyItemInfo;
	
	/**
	 * 分页对象
	 */
	private Pagination<WeeklyItemInfo> pagination = new Pagination<WeeklyItemInfo>();
	
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
	
	public String openWeeklyItemList(){
		Map param = new HashMap();
		if(mainInfoId!=null && !mainInfoId.equals("")){
			param.put("mainInfoId",mainInfoId);
		}
		weeklyItemInfoService.findWeeklyItemInfoForPage(param,pagination);
		pagination.setTotalPages(100);
		return this.SUCCESS;
	}

	public String openAddWeeklyItem(){
		sellDutyList = sellDutyService.findAllSellDutyByCompanyId(this.sessionCompanyId);
		return this.SUCCESS;
	}
	
	public String openModifyWeeklyItem(){
		weeklyItemInfo= weeklyItemInfoService.getWeeklyItemInfoById(weeklyItemInfo.getId());
		
		sellDutyList = sellDutyService.findAllSellDutyByCompanyId(this.sessionCompanyId);
		return this.SUCCESS;
	}
	
	public String addWeeklyItem(){
		
		if(weeklyItemInfo.getId()!=null && weeklyItemInfo.getId().equals("")){
			weeklyItemInfo.setId(null);
		}
		weeklyItemInfoService.saveOrUpdateWeeklyItemInfo(weeklyItemInfo);
		sellDutyList = sellDutyService.findAllSellDutyByCompanyId(this.sessionCompanyId);
		message="保存成功！";
		return this.SUCCESS;
	}
	
	public String modifyWeeklyItem(){
		weeklyItemInfoService.saveOrUpdateWeeklyItemInfo(weeklyItemInfo);
		sellDutyList = sellDutyService.findAllSellDutyByCompanyId(this.sessionCompanyId);
		message="保存成功！";
		return this.SUCCESS;
	}
	public String deleteWeeklyItem(){
		weeklyItemInfoService.deleteWeeklyItemInfoByIds(ids);
		return this.NONE;
	}
	
	public WeeklyItemInfo getWeeklyItemInfo() {
		return weeklyItemInfo;
	}

	public void setWeeklyItemInfo(WeeklyItemInfo weeklyItemInfo) {
		this.weeklyItemInfo = weeklyItemInfo;
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

	public Pagination<WeeklyItemInfo> getPagination() {
		return pagination;
	}

	public void setPagination(Pagination<WeeklyItemInfo> pagination) {
		this.pagination = pagination;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}

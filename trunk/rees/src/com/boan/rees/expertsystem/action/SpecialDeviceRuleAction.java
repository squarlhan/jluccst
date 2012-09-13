/*
 * @(#)SpecialDeviceRuleAction.java 1.1 2012-9-13
 */

package com.boan.rees.expertsystem.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import com.boan.rees.device.model.DeviceInfo;
import com.boan.rees.device.service.IDeviceInfoService;
import com.boan.rees.device.type.model.DeviceType;
import com.boan.rees.device.type.service.IDeviceTypeService;
import com.boan.rees.expertsystem.model.RuleAdviceInfo;
import com.boan.rees.expertsystem.model.RuleReasonInfo;
import com.boan.rees.expertsystem.model.RuleResultInfo;
import com.boan.rees.utils.action.BaseActionSupport;
import com.boan.rees.utils.page.Pagination;

/**
 * XXX 类
 * @author jiangmeidi
 * @version 1.0.0
 */
@Controller( "specialDeviceRuleAction" )
public class SpecialDeviceRuleAction extends BaseActionSupport{

	/**
	 * 树传过来的公司id
	 */
	private String companyId;
	
	/**
	 * 树传过来的工厂Id
	 */
	private String factoryId;
	
	/**
	 * 树传过来的车间Id
	 */
	private String workshopId;
	
	/**
	 * 分页列表
	 */
	private Pagination<DeviceInfo> pagination = new Pagination<DeviceInfo>();
	
	private List<DeviceType> deviceTypeList;
	private List<RuleAdviceInfo> adviceList;
	private List<RuleReasonInfo> reasonList;
	private List<RuleResultInfo> resultList;
	private Map<String,String> resultMap;
	private Map<String,String> newResultMap = new HashMap<String,String>();
	/**
	 * 用于调用数据库相关操作
	 */
	@Autowired
	@Qualifier("deviceInfoService")
	private IDeviceInfoService deviceInfoService;
	
	/**
	 * 用于调用数据库相关操作
	 */
	@Autowired
	@Qualifier("deviceTypeService")
	private IDeviceTypeService deviceTypeService;
	
	/**
	 * 打开设备规则列表
	 * @return
	 */
	public String openDeviceRuleList(){
		Map<String,String> param = new HashMap<String,String>();
		param.put("companyId", companyId);
		param.put("factoryId", factoryId);
		param.put("workshopId", workshopId);
		pagination = deviceInfoService.findDeviceInfoForPage(param, pagination);
		return this.SUCCESS;
	}
	
	/**
	 * 打开添加新设备页
	 * @return
	 */
	
	public String openAddDeviceRule (){
//		if(device==null){
//			device = new DeviceInfo();
//		}
//		device.setCompanyId( companyId );
//		device.setFactoryId(factoryId);
//		device.setWorkshopId(workshopId);
		
		deviceTypeList=deviceTypeService.findAllDeviceType();
		adviceList=new ArrayList<RuleAdviceInfo>();
		reasonList=new ArrayList<RuleReasonInfo>();
		resultList=new ArrayList<RuleResultInfo>();
		resultList=new ArrayList<RuleResultInfo>();
		resultList.add(new RuleResultInfo());
		return SUCCESS;
	}

	public List<DeviceType> getDeviceTypeList() {
		return deviceTypeList;
	}

	public void setDeviceTypeList(List<DeviceType> deviceTypeList) {
		this.deviceTypeList = deviceTypeList;
	}

	public List<RuleAdviceInfo> getAdviceList() {
		return adviceList;
	}

	public void setAdviceList(List<RuleAdviceInfo> adviceList) {
		this.adviceList = adviceList;
	}

	public List<RuleReasonInfo> getReasonList() {
		return reasonList;
	}

	public void setReasonList(List<RuleReasonInfo> reasonList) {
		this.reasonList = reasonList;
	}

	public List<RuleResultInfo> getResultList() {
		return resultList;
	}

	public void setResultList(List<RuleResultInfo> resultList) {
		this.resultList = resultList;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public String getFactoryId() {
		return factoryId;
	}

	public void setFactoryId(String factoryId) {
		this.factoryId = factoryId;
	}

	public String getWorkshopId() {
		return workshopId;
	}

	public void setWorkshopId(String workshopId) {
		this.workshopId = workshopId;
	}

	public Pagination<DeviceInfo> getPagination() {
		return pagination;
	}

	public void setPagination(Pagination<DeviceInfo> pagination) {
		this.pagination = pagination;
	}

	public IDeviceInfoService getDeviceInfoService() {
		return deviceInfoService;
	}

	public void setDeviceInfoService(IDeviceInfoService deviceInfoService) {
		this.deviceInfoService = deviceInfoService;
	}

	public Map<String, String> getResultMap() {
		return resultMap;
	}

	public void setResultMap(Map<String, String> resultMap) {
		this.resultMap = resultMap;
	}

	public Map<String, String> getNewResultMap() {
		return newResultMap;
	}

	public void setNewResultMap(Map<String, String> newResultMap) {
		this.newResultMap = newResultMap;
	}
}


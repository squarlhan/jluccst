/*
 * @(#)DeviceRuleAction.java 1.1 2012-5-1
 */

package com.boan.rees.expertsystem.devicerule.action;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.boan.rees.device.type.model.DeviceType;
import com.boan.rees.device.type.service.IDeviceTypeService;
import com.boan.rees.expertsystem.devicerule.model.DeviceRuleInfo;
import com.boan.rees.expertsystem.devicerule.service.IDeviceRuleService;
import com.boan.rees.expertsystem.model.RuleResultInfo;
import com.boan.rees.expertsystem.service.IRuleResultInfoService;
import com.boan.rees.expertsystem.threshold.model.Threshold;
import com.boan.rees.expertsystem.threshold.model.ThresholdCategory;
import com.boan.rees.expertsystem.threshold.model.ThresholdItem;
import com.boan.rees.expertsystem.threshold.service.IThresholdCategoryService;
import com.boan.rees.expertsystem.threshold.service.IThresholdItemService;
import com.boan.rees.expertsystem.threshold.service.IThresholdService;
import com.boan.rees.utils.page.Pagination;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 设备规则处理Action
 * @author ZhuYF
 * @version 1.0.0
 */
@Controller("deviceRuleAction")
@Scope("prototype")
public class DeviceRuleAction extends ActionSupport {
	
	/**
	 * 设备类别服务接口
	 */
	@Autowired
	@Qualifier("deviceTypeService")
	private IDeviceTypeService deviceTypeService;
	
	/**
	 * 阈值类别服务接口
	 */
	@Autowired
	@Qualifier("thresholdCategoryService")
	private IThresholdCategoryService thresholdCategoryService;
	
	/**
	 * 阈值服务接口
	 */
	@Autowired
	@Qualifier("thresholdService")
	private IThresholdService thresholdService;
	
	/**
	 * 阈值项服务接口
	 */
	@Autowired
	@Qualifier("thresholdItemService")
	private IThresholdItemService thresholdItemService;
	
	/**
	 * 阈值项服务接口
	 */
	@Autowired
	@Qualifier("ruleResultInfoService")
	private IRuleResultInfoService ruleResultInfoService;
	
	/**
	 * 设备规则服务接口
	 */
	@Autowired
	@Qualifier("deviceRuleService")
	private IDeviceRuleService deviceRuleService;
	
	/**
	 * 设备类型
	 */
	private List<DeviceType> deviceTypeList;
	
	/**
	 * 设备类型
	 */
	private List<ThresholdCategory> thresholdCategoryList;
	
	/**
	 * 阈值
	 */
	private List<Threshold> thresholdList;
	
	/**
	 * 阈值项
	 */
	private List<ThresholdItem> thresholdItemList;
	
	/**
	 * 故障
	 */
	private List<RuleResultInfo> ruleResultInfoList;

	/**
	 * 设备类型Id
	 */
	private String deviceTypeId;
	
	/**
	 * 阈值类别Id
	 */
	private String thresholdCategoryId;
	
	/**
	 * 阈值Id
	 */
	private String thresholdId;
	
	/**
	 * 设备规则对象
	 */
	private DeviceRuleInfo deviceRuleInfo;
	
	/**
	 * 设备规则对象数组
	 */
	private List<DeviceRuleInfo> deviceRuleInfoList;
	
	/**
	 * 分页列表
	 */
	Pagination<DeviceRuleInfo> pagination = new Pagination<DeviceRuleInfo>();
	
	/**
	 * 页面所选行的id
	 */
	private String[] ids;
	
	/**
	 * 故障Id
	 */
	private String[] troubleIds;
	
	/**
	 * 操作提示
	 */
	private String message;
	
	/**
	 * ajax根据设备类型查询设备故障
	 * @return
	 */
	public String toGetRuleResultInfo(){
		ruleResultInfoList = ruleResultInfoService.findRuleResultInfoByDeviceTypeId(deviceTypeId);
		return "ruleResultInfoList";
	}
	
	/**
	 * ajax根据阈值类别获取阈值
	 * @return
	 */
	public String toGetThreshold(){
		thresholdList = thresholdCategoryService.getThresholdCategoryById(thresholdCategoryId).getThresholds();
		return "thresholdList";
	}
	
	/**
	 * ajax根据阈值类别获取阈值
	 * @return
	 */
	public String toGetThresholdItem(){
		thresholdItemList = thresholdService.getThresholdById(thresholdId).getThresholdItems();
		return "thresholdItemList";
	}

	/**
	 * 分页显示设备类型列表
	 * @return
	 */
	public String openDeviceRule(){
		pagination = deviceRuleService.findDeviceRuleInfoForPage(new HashMap(), pagination);
		
		deviceTypeList = deviceTypeService.findAllDeviceType();
		thresholdCategoryList = thresholdCategoryService.queryAllThresholdCategory();
		ruleResultInfoList = ruleResultInfoService.findAllRuleResultInfo();
		thresholdList = thresholdService.queryAllThreshold();
		thresholdItemList =thresholdItemService.queryAllThresholdItem();
		return this.SUCCESS;
	}
	
	/**
	 * 打开添加设备规则页面
	 * @return
	 */
	
	public String openAddDeviceRule(){
		deviceTypeList = deviceTypeService.findAllDeviceType();
		thresholdCategoryList = thresholdCategoryService.queryAllThresholdCategory();
		
//		ruleResultInfoList = ruleResultInfoService.findRuleResultInfoByDeviceTypeId("402880e4366ecb1701366ecd38f90001");
		return SUCCESS;
	}
	
    /**
	 * 添加新设备规则
	 * @return
	 */
	public String toAddDeviceRule(){
		try {
			//保存设备规则对象
			for(String troubleId :troubleIds){
				DeviceRuleInfo obj = new DeviceRuleInfo();
				obj.setDeviceTypeId(deviceRuleInfo.getDeviceTypeId());
				obj.setRuleResultInfoId(Integer.parseInt(troubleId.trim()));
				obj.setThresholdCategoryId(deviceRuleInfo.getThresholdCategoryId());
				obj.setThresholdItemId(deviceRuleInfo.getThresholdItemId());
				obj.setThresholdId(deviceRuleInfo.getThresholdId());
				deviceRuleService.save(obj);
			}
			
			message="保存成功！";
			deviceTypeList = deviceTypeService.findAllDeviceType();
			thresholdCategoryList = thresholdCategoryService.queryAllThresholdCategory();
//			deviceTypeId =deviceRuleInfo.getDeviceTypeId();
//			thresholdCategoryId =deviceRuleInfo.getThresholdCategoryId();
//			thresholdId = deviceRuleInfo.getThresholdId();
//			ruleResultInfoList = ruleResultInfoService.findRuleResultInfoByDeviceTypeId(deviceTypeId);
//			thresholdList = thresholdCategoryService.getThresholdCategoryById(thresholdCategoryId).getThresholds();
//			thresholdItemList = thresholdService.getThresholdById(thresholdId).getThresholdItems();
			
		} catch (Exception e) {
			e.printStackTrace();
			message="保存失败！";
		}
		return SUCCESS;
	}
	/**
	 * 保存前验证
	 */
	public void validateToAddDeviceRule(){
		System.out.println(troubleIds);
		deviceTypeList = deviceTypeService.findAllDeviceType();
		thresholdCategoryList = thresholdCategoryService.queryAllThresholdCategory();
	}

	/**
	 * 删除设备规则数据
	 * @return
	 */
	public String deleteDeviceRule(){
		deviceRuleService.deleteDeviceRuleInfo(ids);
		return NONE;
	}
	
	/**
	 * 为修改设备规则页面做准备
	 * @return
	 */
	public String openModifyDeviceRule(){
		deviceTypeList = deviceTypeService.findAllDeviceType();
		thresholdCategoryList = thresholdCategoryService.queryAllThresholdCategory();
		deviceRuleInfo=deviceRuleService.get(""+deviceRuleInfo.getId());
		deviceTypeId =deviceRuleInfo.getDeviceTypeId();
		thresholdCategoryId =deviceRuleInfo.getThresholdCategoryId();
		thresholdId = deviceRuleInfo.getThresholdId();
		ruleResultInfoList = ruleResultInfoService.findRuleResultInfoByDeviceTypeId(deviceTypeId);
		thresholdList = thresholdCategoryService.getThresholdCategoryById(thresholdCategoryId).getThresholds();
		thresholdItemList = thresholdService.getThresholdById(thresholdId).getThresholdItems();
		return SUCCESS;
	}
	
	/**
	 * 修改设备规则信息
	 * @return 
	 */
	public String toModifyDeviceRule(){
		try {
			deviceRuleService.update(deviceRuleInfo);
			message="保存成功！";
		} catch (Exception e) {
			e.printStackTrace();
			message="保存失败！";
		}
		return SUCCESS;
	}
	/**
	 * 保存前验证
	 */
	public void validateToModifyDeviceRule(){
	}
	
	public List<DeviceType> getDeviceTypeList() {
		return deviceTypeList;
	}

	public void setDeviceTypeList(List<DeviceType> deviceTypeList) {
		this.deviceTypeList = deviceTypeList;
	}

	public List<ThresholdCategory> getThresholdCategoryList() {
		return thresholdCategoryList;
	}

	public void setThresholdCategoryList(
			List<ThresholdCategory> thresholdCategoryList) {
		this.thresholdCategoryList = thresholdCategoryList;
	}

	public List<Threshold> getThresholdList() {
		return thresholdList;
	}

	public void setThresholdList(List<Threshold> thresholdList) {
		this.thresholdList = thresholdList;
	}

	public List<ThresholdItem> getThresholdItemList() {
		return thresholdItemList;
	}

	public void setThresholdItemList(List<ThresholdItem> thresholdItemList) {
		this.thresholdItemList = thresholdItemList;
	}

	public List<RuleResultInfo> getRuleResultInfoList() {
		return ruleResultInfoList;
	}

	public void setRuleResultInfoList(List<RuleResultInfo> ruleResultInfoList) {
		this.ruleResultInfoList = ruleResultInfoList;
	}

	public String getDeviceTypeId() {
		return deviceTypeId;
	}

	public void setDeviceTypeId(String deviceTypeId) {
		this.deviceTypeId = deviceTypeId;
	}

	public String getThresholdCategoryId() {
		return thresholdCategoryId;
	}

	public void setThresholdCategoryId(String thresholdCategoryId) {
		this.thresholdCategoryId = thresholdCategoryId;
	}

	public String getThresholdId() {
		return thresholdId;
	}

	public void setThresholdId(String thresholdId) {
		this.thresholdId = thresholdId;
	}

	public DeviceRuleInfo getDeviceRuleInfo() {
		return deviceRuleInfo;
	}

	public void setDeviceRuleInfo(DeviceRuleInfo deviceRuleInfo) {
		this.deviceRuleInfo = deviceRuleInfo;
	}

	public List<DeviceRuleInfo> getDeviceRuleInfoList() {
		return deviceRuleInfoList;
	}

	public void setDeviceRuleInfoList(List<DeviceRuleInfo> deviceRuleInfoList) {
		this.deviceRuleInfoList = deviceRuleInfoList;
	}

	public Pagination<DeviceRuleInfo> getPagination() {
		return pagination;
	}

	public void setPagination(Pagination<DeviceRuleInfo> pagination) {
		this.pagination = pagination;
	}

	public String[] getIds() {
		return ids;
	}

	public void setIds(String[] ids) {
		this.ids = ids;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String[] getTroubleIds() {
		return troubleIds;
	}

	public void setTroubleIds(String[] troubleIds) {
		this.troubleIds = troubleIds;
	}
}


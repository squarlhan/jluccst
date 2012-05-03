/*
 * @(#)IDeviceRuleService.java 1.1 2012-5-2
 */

package com.boan.rees.expertsystem.devicerule.service;

import java.util.List;
import java.util.Map;

import com.boan.rees.expertsystem.devicerule.model.DeviceRuleInfo;
import com.boan.rees.utils.page.Pagination;

/**
 * XXX 类
 * 
 * @author ZhuYF
 * @version 1.0.0
 */
public interface IDeviceRuleService {

	/**
	 * 查询设备规则列表
	 * @return
	 */
	public List<DeviceRuleInfo> findAllDeviceRuleInfo();

	/**
	 * 根据id获取设备规则
	 */
	public DeviceRuleInfo get(String id);
	
	/**
	 * 根据阈值项id获取设备规则
	 */
	public List<Integer> getRuleResultInfoIdByThresholdItemId(String thresholdItemId);
	
	/**
	 * 根据阈值项id和故障Id获取设备规则Id
	 */
	public List<Integer> getRuleIdByThresholdItemIdAndTroubleId(String thresholdItemId,int troubleId);

	/**
	 * 删除设备规则
	 */
	public void deleteDeviceRuleInfo(String... ids);

	/**
	 * 保存设备规则
	 */
	public void save(DeviceRuleInfo table1);

	/**
	 * 修改设备规则信息
	 * @param deviceInfo 设备对象
	 */
	public void update(DeviceRuleInfo deviceInfo);

	/**
	 * 按分页查找设备规则
	 */
	public Pagination<DeviceRuleInfo> findDeviceRuleInfoForPage(Map<String, ?> values, Pagination<DeviceRuleInfo> pagination);

	/**
	 * 判断指定Id的设备规则是否存在指定属性和属性值的记录
	 * 
	 * @param id Id
	 * @param propertyName 属性
	 * @param propertyValue 属性值
	 * @return true：存在 false：不存在
	 */
	public boolean isExistDeviceRuleInfoProperty(String id, String propertyName, String propertyValue);

}

/*
 * @(#)ISpecialDeviceRuleService.java 1.1 2012-9-17
 */

package com.boan.rees.expertsystem.service;

import java.util.List;
import java.util.Map;

import com.boan.rees.expertsystem.model.SpecialDeviceRuleInfo;
import com.boan.rees.utils.page.Pagination;

/**
 * XXX 类
 * @author jiangmeidi
 * @version 1.0.0
 */
public interface ISpecialDeviceRuleService {

	public List<SpecialDeviceRuleInfo> findAllRuleInfo();
	
	public SpecialDeviceRuleInfo get(String id);
	public void deleteRuleInfo(String... ids );
	public void save(SpecialDeviceRuleInfo table1);
	public void update(SpecialDeviceRuleInfo ruleInfo);
	public Pagination<SpecialDeviceRuleInfo> findRuleInfoForPage(Map<String, ?> values,Pagination<SpecialDeviceRuleInfo> pagination);
	/**
	 * 通过设备id查询设备对应的规则串
	 * @param deviceId
	 * @return
	 */
	public List<String> findSpecialDeviceRuleStrByDeviceId(String deviceId);
}


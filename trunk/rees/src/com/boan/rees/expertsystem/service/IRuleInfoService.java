/*
 * @(#)IRuleInfoDao.java 1.1 2012-4-23
 */

package com.boan.rees.expertsystem.service;

import java.util.List;
import java.util.Map;

import com.boan.rees.expertsystem.model.RuleInfo;
import com.boan.rees.utils.page.Pagination;

/**
 * 规则Service类接口
 * @author jiangmeidi
 * @version 1.0.0
 */
public interface IRuleInfoService {
	/**
	 * 查询全部规则
	 */
	public List<RuleInfo> findAllRuleInfo();
	/**
	 * 根据id查找规则
	 */
	public RuleInfo get(int id);
	/**
	 * 根据id删除规则
	 */
	public void deleteRuleInfo(Integer... ids );
	
	/**
	 * 保存规则
	 */
	public void save(RuleInfo table1);

	/**
	 * 修改规则信息
	 * @param reportInfo 报表对象
	 */
	public void update(RuleInfo ruleInfo);
	
	/**
	 * 按分页查询
	 */
	public Pagination<RuleInfo> findRuleInfoForPage(Map<String, ?> values,Pagination<RuleInfo> pagination);
	
	/**
	 * 根据设备类型id查找规则
	 */
	//public RuleInfo findbyDeviceTypeId(String id);
	/**
	 * 查找规则表中有关属性值
	 * @param propertyName 属性名字，value 属性值
	 * @return 查找到的规则列表
	 */
	public List<RuleInfo> findbyProperties(String propertyName,String value);
	public List<RuleInfo> findbyProperties(String propertyName,int value);
}





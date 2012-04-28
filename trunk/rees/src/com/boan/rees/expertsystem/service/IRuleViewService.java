/*
 * @(#)IRuleRuleInfoDao.java 1.1 2012-4-23
 */

package com.boan.rees.expertsystem.service;

import java.util.List;
import java.util.Map;

import com.boan.rees.expertsystem.model.RuleView;
import com.boan.rees.utils.page.Pagination;

/**
 * 建议视图Service类接口
 * @author jiangmeidi
 * @version 1.0.0
 */
public interface IRuleViewService {
	/**
	 * 查询全部建议
	 */
	public List<RuleView> findAllRuleView();
	/**
	 * 根据id查找建议
	 */
	public RuleView get(int id);
	
	/**
	 * 按分页查询
	 */
	public Pagination<RuleView> findRuleViewForPage(Map<String, ?> values,Pagination<RuleView> pagination);
	
	/**
	 * 根据设备类型id查找建议
	 */
	//public RuleRuleInfo findbyDeviceTypeId(String id);
}





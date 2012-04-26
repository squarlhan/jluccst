/*
 * @(#)IRuleAdviceInfoDao.java 1.1 2012-4-23
 */

package com.boan.rees.expertsystem.service;

import java.util.List;
import java.util.Map;

import com.boan.rees.expertsystem.model.AdviceView;
import com.boan.rees.utils.page.Pagination;

/**
 * 建议视图Service类接口
 * @author jiangmeidi
 * @version 1.0.0
 */
public interface IAdviceViewService {
	/**
	 * 查询全部建议
	 */
	public List<AdviceView> findAllAdviceView();
	/**
	 * 根据id查找建议
	 */
	public AdviceView get(int id);
	
	/**
	 * 按分页查询
	 */
	public Pagination<AdviceView> findAdviceViewForPage(Map<String, ?> values,Pagination<AdviceView> pagination);
	
	/**
	 * 根据设备类型id查找建议
	 */
	//public RuleAdviceInfo findbyDeviceTypeId(String id);
}





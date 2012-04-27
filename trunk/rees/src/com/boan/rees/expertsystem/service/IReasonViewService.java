/*
 * @(#)IRuleAdviceInfoDao.java 1.1 2012-4-23
 */

package com.boan.rees.expertsystem.service;

import java.util.List;
import java.util.Map;

import com.boan.rees.expertsystem.model.ReasonView;
import com.boan.rees.utils.page.Pagination;

/**
 * 原因视图Service类接口
 * @author jiangmeidi
 * @version 1.0.0
 */
public interface IReasonViewService {
	/**
	 * 查询全部原因
	 */
	public List<ReasonView> findAllReasonView();
	/**
	 * 根据id查找原因
	 */
	public ReasonView get(int id);
	
	/**
	 * 按分页查询
	 */
	public Pagination<ReasonView> findReasonViewForPage(Map<String, ?> values,Pagination<ReasonView> pagination);
	
	/**
	 * 根据设备类型id查找原因
	 */
	//public RuleAdviceInfo findbyDeviceTypeId(String id);
}





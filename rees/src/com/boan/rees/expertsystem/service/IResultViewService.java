/*
 * @(#)IRuleAdviceInfoDao.java 1.1 2012-4-23
 */

package com.boan.rees.expertsystem.service;

import java.util.List;
import java.util.Map;

import com.boan.rees.expertsystem.model.ResultView;
import com.boan.rees.utils.page.Pagination;

/**
 * 现象视图Service类接口
 * @author jiangmeidi
 * @version 1.0.0
 */
public interface IResultViewService {
	/**
	 * 查询全部现象
	 */
	public List<ResultView> findAllResultView();
	/**
	 * 根据id查找现象
	 */
	public ResultView get(int id);
	
	/**
	 * 按分页查询
	 */
	public Pagination<ResultView> findResultViewForPage(Map<String, ?> values,Pagination<ResultView> pagination);
	
	/**
	 * 根据设备类型id查找现象
	 */
	//public RuleAdviceInfo findbyDeviceTypeId(String id);
}





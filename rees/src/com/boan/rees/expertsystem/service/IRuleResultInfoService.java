/*
 * @(#)IRuleResultInfoDao.java 1.1 2012-4-23
 */

package com.boan.rees.expertsystem.service;

import java.util.List;
import java.util.Map;

import com.boan.rees.expertsystem.model.RuleResultInfo;
import com.boan.rees.utils.page.Pagination;

/**
 * 现象Service类接口
 * @author jiangmeidi
 * @version 1.0.0
 */
public interface IRuleResultInfoService {
	/**
	 * 查询全部现象
	 */
	public List<RuleResultInfo> findAllRuleResultInfo();
	/**
	 * 根据id查找现象
	 */
	public RuleResultInfo get(int id);
	/**
	 * 根据id删除现象
	 */
	public void deleteRuleResultInfo(Integer... ids );
	
	/**
	 * 保存现象
	 */
	public void save(RuleResultInfo table1);

	/**
	 * 修改现象信息
	 * @param reportInfo 报表对象
	 */
	public void update(RuleResultInfo RuleResultInfo);
	
	/**
	 * 按分页查询
	 */
	public Pagination<RuleResultInfo> findRuleResultInfoForPage(Map<String, ?> values,Pagination<RuleResultInfo> pagination);
	
	/**
	 * 根据设备类型id查找现象
	 */
	//public RuleInfo findbyDeviceTypeId(String id);
	
	/**
	 * 根据设备类型Id查询所包含的故障信息
	 */
	public List<RuleResultInfo> findRuleResultInfoByDeviceTypeId(String deviceTypeId);
}





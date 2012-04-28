/*
 * @(#)IRuleAdviceInfoDao.java 1.1 2012-4-23
 */

package com.boan.rees.expertsystem.service;

import java.util.List;
import java.util.Map;

import com.boan.rees.expertsystem.model.RuleAdviceInfo;
import com.boan.rees.report.model.PersonReport;
import com.boan.rees.utils.page.Pagination;

/**
 * 建议Service类接口
 * @author jiangmeidi
 * @version 1.0.0
 */
public interface IRuleAdviceInfoService {
	/**
	 * 查询全部建议
	 */
	public List<RuleAdviceInfo> findAllRuleAdviceInfo();
	/**
	 * 根据id查找建议
	 */
	public RuleAdviceInfo get(int id);
	/**
	 * 根据id删除建议
	 */
	public void deleteRuleAdviceInfo(Integer... ids );
	
	/**
	 * 保存建议
	 */
	public void save(RuleAdviceInfo table1);

	/**
	 * 修改建议信息
	 * @param reportInfo 报表对象
	 */
	public void update(RuleAdviceInfo ruleAdviceInfo);
	
	/**
	 * 按分页查询
	 */
	public Pagination<RuleAdviceInfo> findRuleAdviceInfoForPage(Map<String, ?> values,Pagination<RuleAdviceInfo> pagination);
	
	/**
	 * 根据设备类型id查找建议
	 */
	//public RuleAdviceInfo findbyDeviceTypeId(String id);
}





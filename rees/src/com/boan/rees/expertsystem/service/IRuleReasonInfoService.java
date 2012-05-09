/*
 * @(#)IRuleReasonInfoDao.java 1.1 2012-4-23
 */

package com.boan.rees.expertsystem.service;

import java.util.List;
import java.util.Map;

import com.boan.rees.expertsystem.model.RuleReasonInfo;
import com.boan.rees.utils.page.Pagination;

/**
 * 原因Service类接口
 * @author jiangmeidi
 * @version 1.0.0
 */
public interface IRuleReasonInfoService {
	/**
	 * 查询全部原因
	 */
	public List<RuleReasonInfo> findAllRuleReasonInfo();
	/**
	 * 根据id查找原因
	 */
	public RuleReasonInfo get(int id);
	/**
	 * 根据id删除原因
	 */
	public void deleteRuleReasonInfo(Integer... ids );
	
	/**
	 * 保存原因
	 */
	public void save(RuleReasonInfo table1);

	/**
	 * 修改原因信息
	 * @param reportInfo 报表对象
	 */
	public void update(RuleReasonInfo RuleReasonInfo);
	
	/**
	 * 按分页查询
	 */
	public Pagination<RuleReasonInfo> findRuleReasonInfoForPage(Map<String, ?> values,Pagination<RuleReasonInfo> pagination);
	
	/**
	 * 根据id查找原因(HQL)
	 */
	public RuleReasonInfo getbyId(int id);
}





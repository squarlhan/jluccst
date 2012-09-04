/**
 * 
 */
package com.boan.crm.customer.analysis.service;

import java.util.List;
import java.util.Map;

import com.boan.crm.customer.analysis.model.IdCaption;
import com.boan.crm.customer.analysis.model.RuleInfo;
import com.boan.crm.utils.page.Pagination;

/**
 * @author luojx
 *
 */
public interface IFuzzyRuleInfoService {
	/**
	 * 根据分类获取规则
	 */
	public List<IdCaption> findAllFuzzyRuleInfo();
	/**
	 * 根据分类获取规则
	 */
	public List<RuleInfo> findAllFuzzyRuleInfoByResultId(int resultId);
	/**
	 * 根据分类获取规则
	 */
	public Pagination<IdCaption> findAllFuzzyRuleResultInfo(Map<String, ?> values,Pagination<IdCaption> pagination);

	/**
	 * 根据id获取规则
	 */
	public RuleInfo get(int id);

	/**
	 * 根据id删除规则
	 */
	public void deleteFuzzyRuleInfo(Integer... ids);
	
	/**
	 * 根据resultId删除规则
	 */
	public void deleteFuzzyRuleInfoByResultId(int resultId);

	/**
	 * 保存规则
	 */
	public void save(RuleInfo table1);
	/**
	 * 按分页查询信息
	 */
	public Pagination<RuleInfo> findFuzzyRuleInfoInfoForPage(
			Map<String, ?> values, Pagination<RuleInfo> pagination);
}

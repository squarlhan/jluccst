/**
 * 
 */
package com.boan.crm.customer.analysis.service;

import java.util.List;

import com.boan.crm.customer.analysis.model.AnalysisResult;
import com.boan.crm.customer.analysis.model.FuzzyInfo;

/**
 * @author luojx
 *
 */
public interface IAnalysisResultService {
	/**
	 * 根据分类获取分析结论
	 */
	public List<AnalysisResult> findAllAnalysisResult();
	/**
	 * 根据值获取分析结论
	 */
	public AnalysisResult findAnalysisResult(double result);

	/**
	 * 根据id获取分析结论
	 */
	public AnalysisResult get(int id);

	/**
	 * 根据id删除分析结论
	 */
	public void deleteAnalysisResult(Integer... ids);

	/**
	 * 保存分析结论
	 */
	public void save(AnalysisResult table1);

}

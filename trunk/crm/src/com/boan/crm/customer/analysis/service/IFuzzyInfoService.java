/**
 * 
 */
package com.boan.crm.customer.analysis.service;

import java.util.List;

import com.boan.crm.customer.analysis.model.FuzzyInfo;

/**
 * @author luojx
 *
 */
public interface IFuzzyInfoService {
	/**
	 * 根据分类获取模糊项
	 */
	public List<FuzzyInfo> findAllFuzzyInfoByCategory(String category);

	/**
	 * 根据id获取模糊项
	 */
	public FuzzyInfo get(int id);

	/**
	 * 根据id删除模糊项
	 */
	public void deleteFuzzyInfo(Integer... ids);

	/**
	 * 保存模糊项
	 */
	public void save(FuzzyInfo table1);

}

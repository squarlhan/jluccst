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
	public List<FuzzyInfo> findAllFuzzyInfoByCategory(String category,String companyId);

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
	/**
	 * 从总记录中拷贝生成公司记录
	 * @param companyId
	 */
	public void saveMainFuzzyInfoToCompany(String companyId);

}

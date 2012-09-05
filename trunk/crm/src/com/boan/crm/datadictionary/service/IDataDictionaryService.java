package com.boan.crm.datadictionary.service;

import java.util.List;
import java.util.Map;

import com.boan.crm.datadictionary.model.DataDictionary;
import com.boan.crm.utils.page.Pagination;


/**
 * 数据字典服务类接口
 * 
 * @author leon
 * @version 1.0.0
 */
public interface IDataDictionaryService {
	/**
	 * 根据客户ID查找全部数据字典
	 */
	public List<DataDictionary> findAllDataDictionaryByCompanyId(String companyId);
	
	/**
	 * 根据客户ID查找类别查找数据字典
	 */
	public List<DataDictionary> findDataDictionaryByType(String companyId, Integer typeFlag);

	/**
	 * 根据id获取数据字典
	 */
	public DataDictionary get(String id);

	/**
	 * 根据id删除数据字典
	 */
	public void deleteDataDictionary(String... ids);

	/**
	 * 保存数据字典
	 */
	public void save(DataDictionary table1);

	/**
	 * 按分页查询数据字典
	 */
	public Pagination<DataDictionary> findDataDictionaryForPage(
			Map<String, ?> values, Pagination<DataDictionary> pagination);
}

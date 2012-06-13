package com.boan.crm.datadictionary.service;

import java.util.List;
import java.util.Map;

import com.boan.crm.datadictionary.model.CustomerType;
import com.boan.crm.utils.page.Pagination;


/**
 * 客户类别服务类接口
 * 
 * @author leon
 * @version 1.0.0
 */
public interface ICustomerTypeService {
	/**
	 * 查找全部客户类别
	 */
	public List<CustomerType> findAllCustomerType();

	/**
	 * 根据id获取客户类别
	 */
	public CustomerType get(String id);

	/**
	 * 根据id删除客户类别
	 */
	public void deleteCustomerType(String... ids);

	/**
	 * 保存客户类别
	 */
	public void save(CustomerType table1);

	/**
	 * 按分页查询客户类别
	 */
	public Pagination<CustomerType> findCustomerTypeForPage(
			Map<String, ?> values, Pagination<CustomerType> pagination);
}

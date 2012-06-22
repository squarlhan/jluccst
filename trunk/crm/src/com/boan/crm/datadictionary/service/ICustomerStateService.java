package com.boan.crm.datadictionary.service;

import java.util.List;
import java.util.Map;

import com.boan.crm.datadictionary.model.CustomerState;
import com.boan.crm.utils.page.Pagination;


/**
 * 客户状态服务类接口
 * 
 * @author leon
 * @version 1.0.0
 */
public interface ICustomerStateService {
	/**
	 * 查找全部客户状态
	 */
	public List<CustomerState> findAllCustomerState();

	/**
	 * 根据id获取客户状态
	 */
	public CustomerState get(String id);

	/**
	 * 根据id删除客户状态
	 */
	public void deleteCustomerState(String... ids);

	/**
	 * 保存客户状态
	 */
	public void save(CustomerState table1);

	/**
	 * 按分页查询客户状态
	 */
	public Pagination<CustomerState> findCustomerStateForPage(
			Map<String, ?> values, Pagination<CustomerState> pagination);
}

/**
 * 
 */
package com.boan.crm.customersearch.service;

import java.util.List;
import java.util.Map;

import com.boan.crm.customersearch.model.CustomerLibInfo;
import com.boan.crm.utils.page.Pagination;

/**
 * @author luojx
 *　客户服务接口
 */
public interface ICustomerLibInfoService {
	/**
	 * 查找全部客户
	 */
	public List<CustomerLibInfo> findAllCustomerLibInfo();

	/**
	 * 根据id获取客户
	 */
	public CustomerLibInfo get(String id);

	/**
	 * 根据id删除客户
	 */
	public void deleteCustomerLibInfo(String... ids);

	/**
	 * 保存客户
	 */
	public void save(CustomerLibInfo table1);

	/**
	 * 按分页查询客户
	 */
	public Pagination<CustomerLibInfo> findCustomerLibInfoForPage(
			Map<String, ?> values, Pagination<CustomerLibInfo> pagination);
}
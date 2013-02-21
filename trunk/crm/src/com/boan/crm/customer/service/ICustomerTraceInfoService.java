/**
 * 
 */
package com.boan.crm.customer.service;

import java.util.List;
import java.util.Map;

import com.boan.crm.customer.model.CustomerTraceInfo;
import com.boan.crm.utils.page.Pagination;

/**
 * @author luojx
 *　客户跟进服务接口
 */
public interface ICustomerTraceInfoService {
	/**
	 * 查找全部客户跟进信息
	 */
	public List<CustomerTraceInfo> findAllCustomerTraceInfoByCustomerId(String customerId);

	/**
	 * 查找全部客户跟进信息
	 */
	public List<CustomerTraceInfo> findAllCustomerTraceInfo();
	
	/**
	 * 根据id获取客户跟进信息
	 */
	public CustomerTraceInfo get(String id);

	/**
	 * 根据id删除客户跟进信息
	 */
	public void deleteCustomerTraceInfo(String... ids);
	/**
	 * 根据客户Id删除跟进信息
	 * @param customerId
	 */
	public void deleteAllCustomerTraceInfoByCustomerId(String customerId);
	/**
	 * 保存客户跟进信息
	 */
	public void save(CustomerTraceInfo table1);

	/**
	 * 按分页查询客户跟进信息
	 */
	public Pagination<CustomerTraceInfo> findCustomerTraceInfoForPage(
			Map<String, ?> values, Pagination<CustomerTraceInfo> pagination);
}

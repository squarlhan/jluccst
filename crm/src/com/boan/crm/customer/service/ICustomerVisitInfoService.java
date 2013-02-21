/**
 * 
 */
package com.boan.crm.customer.service;

import java.util.List;
import java.util.Map;

import com.boan.crm.customer.model.CustomerVisitInfo;
import com.boan.crm.utils.page.Pagination;

/**
 * @author luojx
 *　客户回访服务接口
 */
public interface ICustomerVisitInfoService {
	/**
	 * 查找全部客户回访信息
	 */
	public List<CustomerVisitInfo> findAllCustomerVisitInfoByCustomerId(String customerId);

	/**
	 * 查找全部客户回访信息
	 */
	public List<CustomerVisitInfo> findAllCustomerVisitInfo();
	
	/**
	 * 根据id获取客户回访信息
	 */
	public CustomerVisitInfo get(String id);

	/**
	 * 根据id删除客户回访信息
	 */
	public void deleteCustomerVisitInfo(String... ids);
	/**
	 * 根据客户Id删除回访信息
	 * @param customerId
	 */
	public void deleteAllCustomerVisitInfoByCustomerId(String customerId);
	/**
	 * 保存客户回访信息
	 */
	public void save(CustomerVisitInfo table1);

	/**
	 * 按分页查询客户回访信息
	 */
	public Pagination<CustomerVisitInfo> findCustomerVisitInfoForPage(
			Map<String, ?> values, Pagination<CustomerVisitInfo> pagination);
}

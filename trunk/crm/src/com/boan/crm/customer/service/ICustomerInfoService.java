/**
 * 
 */
package com.boan.crm.customer.service;

import java.util.List;
import java.util.Map;

import com.boan.crm.customer.model.CustomerInfo;
import com.boan.crm.utils.page.Pagination;

/**
 * @author luojx
 *　客户服务接口
 */
public interface ICustomerInfoService {
	/**
	 * 查找全部客户
	 */
	public List<CustomerInfo> findAllCustomerInfo();
	/**
	 * 查找全部客户个数
	 */
	public int findAllCustomerInfoCount(String companyId);
	/**
	 * 查找全部客户个数
	 */
	public int findAllCustomerInfoCount(String companyId,String deptId,String userId);
	/**
	 * 查找全部客户
	 */
	public List<CustomerInfo> findAllCustomerInfoByCompanyId( String companyId );
	
	/**
	 * 查找销售员自己的客户
	 */
	public List<CustomerInfo> findAllCustomerInfoBySalesmanId( String salesmanId );

	/**
	 * 根据id获取客户
	 */
	public CustomerInfo get(String id);

	/**
	 * 根据id删除客户
	 */
	public void deleteCustomerInfo(String... ids);

	/**
	 * 保存客户
	 */
	public void save(CustomerInfo table1);

	/**
	 * 按分页查询客户
	 */
	public Pagination<CustomerInfo> findCustomerInfoForPage( Map<String, ?> values, Pagination<CustomerInfo> pagination);
	
	public Pagination<CustomerInfo> findCustomerInfoAndSellAmountForPage( Map<String, ?> values, Pagination<CustomerInfo> pagination) ;
}

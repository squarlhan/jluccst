/**
 * 
 */
package com.boan.crm.customer.service;

import java.util.List;

import com.boan.crm.customer.model.CustomerStaticInfo;

/**
 * @author luojx
 *　客户统计服务接口
 */
public interface ICustomerStaticInfoService {
	/**
	 * 查找全部客户
	 */
	public List<CustomerStaticInfo> findAllCustomerStaticInfo(String companyId,int key);
	/**
	 * 查找全部客户
	 */
	public List<CustomerStaticInfo> findAllCustomerStaticInfo(String companyId,String deptId,String userId,int key);
}

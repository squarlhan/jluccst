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
	 * 根据id获取客户
	 */
	public CustomerLibInfo getCustomerLibInfoView(String id);


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
	public Pagination<CustomerLibInfo> findCustomerLibInfoForPage( Map<String, ?> values, Pagination<CustomerLibInfo> pagination);
	
	public Pagination<CustomerLibInfo> findCustomerLibInfoForPage( Map<String, ?> values, Pagination<CustomerLibInfo> pagination,String sellerId) ;
	/**
	 * 查找全部客户
	 * @param province 省份
	 * @return
	 */
	public List<CustomerLibInfo> findAllCustomerLibInfo(String province );
	
	/**
	 * 查找指定省份中有无客户
	 * @param province 省份中文名
	  @param province 客户名称（公司名称）
	 * @return true：指定省份中已经存在该公司
	 */
	public boolean existCustomerInLib(String province,String customerName );

	/**
	 * 根据id获取客户
	 * @param province 省份
	 */
	public CustomerLibInfo get(String province , String id);

	/**
	 * 根据id删除客户
	 * @param province 省份
	 */
	public void deleteCustomerLibInfo(String province ,String... ids);

	/**
	 * 保存客户
	 * @param province 省份
	 */
	public void save(String province ,CustomerLibInfo table1);
	
	/**
	 * 修改不查询列
	 * @param province 省份
	 * @param customerId 客户Id
	 * @param flag 0：查询 1：不查询
	 */
	public void updateNoSearchColumn(String province,String customerId,int flag);
	
	/**
	 * 修改重要客户标识
	 * @param customerId 客户Id
	 * @param flag 0：一般客户 1：重要客户
	 */
	public void updateImportantFlag(String customerId,int flag);

	/**
	 * 按分页查询客户
	 * @param province 省份
	 */
	public Pagination<CustomerLibInfo> findCustomerLibInfoForPage(String province ,
			Map<String, ?> values, Pagination<CustomerLibInfo> pagination,String company_Id ,String salesmanId);
}

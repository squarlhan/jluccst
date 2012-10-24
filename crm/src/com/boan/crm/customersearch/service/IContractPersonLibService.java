/**
 * 
 */
package com.boan.crm.customersearch.service;

import java.util.List;
import java.util.Map;

import com.boan.crm.customersearch.model.ContractPersonLibInfo;
import com.boan.crm.utils.page.Pagination;

/**
 * @author luojx
 * 联系人服务接口
 */
public interface IContractPersonLibService {
	/**
	 * 根据客户Id查找全部联系人
	 * @param customerId
	 * @return List<ContractPersonLibInfo>
	 */
	public List<ContractPersonLibInfo> findAllContractPersonLibInfoByCustomerId(String customerId);

	/**
	 * 根据id获取联系人
	 * @param id
	 * @return ContractPersonLibInfo
	 */
	public ContractPersonLibInfo get(String id);

	/**
	 * 根据id删除联系人
	 * @param ids
	 */
	public void deleteContractPersonLibInfo(String... ids);
	
	/**
	 * 根据客户id删除联系人
	 * @param ids
	 */
	public void deleteContractPersonLibInfoByCustomerIds(String... ids);
	/**
	 * 保存联系人
	 * @param ContractPersonLibInfo
	 */
	public void save(ContractPersonLibInfo ContractPersonLibInfo);

	/**
	 * 按分页查询联系人
	 * @param values
	 * @param pagination
	 * @return Pagination<ContractPersonLibInfo>
	 */
	public Pagination<ContractPersonLibInfo> findContractPersonLibInfoForPage(
			Map<String, ?> values, Pagination<ContractPersonLibInfo> pagination);
	
	
	
	/**
	 * 根据客户Id查找全部联系人
	 * @param customerId
	 * @return List<ContractPersonLibInfo>
	 */
	public List<ContractPersonLibInfo> findAllContractPersonLibInfoByCustomerId(String province , String customerId);

	/**
	 * 根据id获取联系人
	 * @param id
	 * @return ContractPersonLibInfo
	 */
	public ContractPersonLibInfo get(String province , String id);

	/**
	 * 根据id删除联系人
	 * @param ids
	 */
	public void deleteContractPersonLibInfo(String province , String... ids);
	
	/**
	 * 根据客户id删除联系人
	 * @param ids
	 */
	public void deleteContractPersonLibInfoByCustomerIds(String province , String... ids);
	/**
	 * 保存联系人
	 * @param ContractPersonLibInfo
	 */
	public void save(String province , ContractPersonLibInfo ContractPersonLibInfo);

	/**
	 * 按分页查询联系人
	 * @param values
	 * @param pagination
	 * @return Pagination<ContractPersonLibInfo>
	 */
	public Pagination<ContractPersonLibInfo> findContractPersonLibInfoForPage(String province , 
			Map<String, ?> values, Pagination<ContractPersonLibInfo> pagination);
}

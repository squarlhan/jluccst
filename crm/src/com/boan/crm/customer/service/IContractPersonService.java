/**
 * 
 */
package com.boan.crm.customer.service;

import java.util.List;
import java.util.Map;

import com.boan.crm.customer.model.ContractPersonInfo;
import com.boan.crm.utils.page.Pagination;

/**
 * @author luojx
 * 联系人服务接口
 */
public interface IContractPersonService {
	/**
	 * 根据客户Id查找全部联系人
	 * @param customerId
	 * @return List<ContractPersonInfo>
	 */
	public List<ContractPersonInfo> findAllContractPersonInfoByCustomerId(String customerId);

	/**
	 * 根据id获取联系人
	 * @param id
	 * @return ContractPersonInfo
	 */
	public ContractPersonInfo get(String id);

	/**
	 * 根据id删除联系人
	 * @param ids
	 */
	public void deleteContractPersonInfo(String... ids);
	
	/**
	 * 根据客户id删除联系人
	 * @param ids
	 */
	public void deleteContractPersonInfoByCustomerIds(String... ids);
	/**
	 * 保存联系人
	 * @param contractPersonInfo
	 */
	public void save(ContractPersonInfo contractPersonInfo);

	/**
	 * 按分页查询联系人
	 * @param values
	 * @param pagination
	 * @return Pagination<ContractPersonInfo>
	 */
	public Pagination<ContractPersonInfo> findContractPersonInfoForPage(
			Map<String, ?> values, Pagination<ContractPersonInfo> pagination);
	/**
	 * 根据电话号或手机号，取客户信息Id
	 * @param phone
	 * @return　String
	 */
	public String getCustomerIdByPhone(String phone);
}

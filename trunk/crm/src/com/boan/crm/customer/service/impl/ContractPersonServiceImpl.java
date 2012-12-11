/**
 * 
 */
package com.boan.crm.customer.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.boan.crm.customer.dao.IContractPersonDAO;
import com.boan.crm.customer.dao.ICustomerInfoDAO;
import com.boan.crm.customer.model.ContractPersonInfo;
import com.boan.crm.customer.model.CustomerInfo;
import com.boan.crm.customer.service.IContractPersonService;
import com.boan.crm.sms.service.ISMSCustomerInfoService;
import com.boan.crm.utils.page.Pagination;

/**
 * @author luojx
 *　联系人服务接口实现类
 */
@Service("contractPersonService")
public class ContractPersonServiceImpl implements IContractPersonService {
	@Autowired
	@Qualifier("contractPersonDao")
	private IContractPersonDAO contractPersonDao;
	@Autowired
	@Qualifier("SMSCustomerInfoService")
	private ISMSCustomerInfoService  smsCustomerService ;
	
	@Override
	public void deleteContractPersonInfo(String... ids) {
		contractPersonDao.delete(ids);
	}
	/**
	 * 根据客户id删除联系人
	 * @param ids
	 */
	@Override
	public void deleteContractPersonInfoByCustomerIds(String... ids)
	{	
		for(int i=0;i<ids.length;i++)
		{
			Map<String,String> idMap = new HashMap<String,String>();
			idMap.put("customerId", ids[i]);
			contractPersonDao.executeHql("delete from ContractPersonInfo where customerId = :customerId",idMap);
		}
	}
	@Override
	public List<ContractPersonInfo> findAllContractPersonInfoByCustomerId(String customerId) {
		Map<String,String> idMap = new HashMap<String,String>();
		idMap.put("customerId", customerId);
		return contractPersonDao.find("from ContractPersonInfo where customerId = :customerId order by sort_index asc", idMap);
	}

	@Override
	public Pagination<ContractPersonInfo> findContractPersonInfoForPage(
			Map<String, ?> values, Pagination<ContractPersonInfo> pagination) {
		String hql = "from ContractPersonInfo order by sortIndex asc";
		List<ContractPersonInfo> data = contractPersonDao.findForPage(hql, values, pagination.getStartIndex(), pagination.getPageSize());
		hql = "select count(*) from ContractPersonInfo order by sortIndex asc";
		int totalRows = contractPersonDao.findCountForPage(hql, values);
		pagination.setTotalRows(totalRows);
		pagination.setData(data);
		return pagination;
	}
	/**
	 * 根据电话号或手机号，取客户信息Id
	 * @param phone
	 * @return　String
	 */
	public String getCustomerIdByPhone(String phone)
	{
		String hql = "select customerId from ContractPersonInfo where phone = :phone or tel = :phone";
		Map<String, String> values = new HashMap<String, String>();
		values.put("phone", phone);
		List<String> list = contractPersonDao.find(hql, values);
		if(list != null && list.size() > 0)
		{
			return list.get(0);
		}else
		{
			return "";
		}
		
	}
	@Override
	public ContractPersonInfo get(String id) {
		return contractPersonDao.get(id);
	}

	@Override
	public void save(ContractPersonInfo person) {
		contractPersonDao.saveOrUpdate(person);
	}
}

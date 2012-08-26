/**
 * 
 */
package com.boan.crm.customer.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.boan.crm.customer.dao.ICustomerInfoDAO;
import com.boan.crm.customer.model.CustomerInfo;
import com.boan.crm.customer.service.IContractPersonService;
import com.boan.crm.customer.service.ICustomerInfoService;
import com.boan.crm.datadictionary.model.DataDictionary;
import com.boan.crm.datadictionary.service.IAreaService;
import com.boan.crm.datadictionary.service.IDataDictionaryService;
import com.boan.crm.groupmanage.model.User;
import com.boan.crm.groupmanage.service.IUserService;
import com.boan.crm.utils.page.Pagination;

/**
 * @author luojx
 * 客户信息服务接口实现类
 */
@Service("customerInfoService")
public class CustomerInfoServiceImpl implements ICustomerInfoService{
	@Autowired
	@Qualifier("customerInfoDao")
	private ICustomerInfoDAO customerInfoDao;
	/**
	 * 权限接口
	 */
	@Autowired
	@Qualifier("dataDictionaryService")
	private IDataDictionaryService dataDictionaryService = null;
	
	/**
	 * 权限接口
	 */
	@Autowired
	@Qualifier("contractPersonService")
	private IContractPersonService contractPersonService = null;
	
	@Autowired
	@Qualifier("userService")
	private IUserService userService;
	
	@Override
	public void deleteCustomerInfo(String... ids) {
		customerInfoDao.delete(ids);
	}

	@Override
	public List<CustomerInfo> findAllCustomerInfo() {
		return customerInfoDao.find("from CustomerInfo order by registerTime asc", new Object[0]);
	}

	@Override
	public Pagination<CustomerInfo> findCustomerInfoForPage(
			Map<String, ?> values, Pagination<CustomerInfo> pagination) {
		StringBuilder hql = new StringBuilder();
		hql.append( "from CustomerInfo where 1=1");
		if(values.get("companyId") != null)
		{
			hql.append(" and companyId = :companyId ");
		}
		if(values.get("salesmanId") != null)
		{
			hql.append(" and salesmanId = :salesmanId ");
		}
		if(values.get("customerName") != null)
		{
			hql.append(" and customerName like :customerName ");
		}
		if(values.get("contractorName") != null)
		{
			hql.append(" and id in ( select customerId from ContractPersonInfo where personName like :contractorName) ");
		}
		if(values.get("customerCategory") != null)
		{
			hql.append(" and categoryId = :customerCategory ");
		}
		
		hql.append(" order by registerTime asc");
		List<CustomerInfo> data = customerInfoDao.findForPage(hql.toString(), values, pagination.getStartIndex(), pagination.getPageSize());
		hql.delete(0, hql.length());
		hql.append(" select count(*) from CustomerInfo where 1=1 " );
		if(values.get("companyId") != null)
		{
			hql.append(" and companyId = :companyId ");
		}
		if(values.get("salesmanId") != null)
		{
			hql.append(" and salesmanId = :salesmanId ");
		}
		if(values.get("customerName") != null)
		{
			hql.append(" and customerName like :customerName ");
		}
		if(values.get("contractorName") != null)
		{
			hql.append(" and id in ( select customerId from ContractPersonInfo where personName like :contractorName) ");
		}
		if(values.get("customerCategory") != null)
		{
			hql.append(" and categoryId = :customerCategory ");
		}
		
		int totalRows = customerInfoDao.findCountForPage(hql.toString(), values);
		pagination.setTotalRows(totalRows);
		pagination.setData(data);
		
		List<CustomerInfo> list = pagination.getData();
		if(list != null && list.size() > 0)
		{
			for(int i=0;i< list.size();i++)
			{
				CustomerInfo customerInfo = list.get(i);
				DataDictionary d1 = dataDictionaryService.get(customerInfo.getCategoryId());
				if(d1 != null)
				{
					customerInfo.setCategory(d1.getName());
				}
				
				d1 = dataDictionaryService.get(customerInfo.getMaturityId());
				if(d1 != null)
				{
					customerInfo.setMaturity(d1.getName());
				}
				d1 = dataDictionaryService.get(customerInfo.getSourceId());
				if(d1 != null)
				{
					customerInfo.setSource(d1.getName());
				}
				
				try
				{
					User salesman = userService.getUserById(customerInfo.getSalesmanId());
					if(salesman != null)
					{
						customerInfo.setSalesman(salesman.getUserCName());
					}
				}catch(Exception e)
				{
					e.printStackTrace();
				}
				customerInfo.setContractPersonList(contractPersonService.findAllContractPersonInfoByCustomerId(customerInfo.getId()));
				
			}
		}
		return pagination;
	}

	@Override
	public CustomerInfo get(String id) {
		return customerInfoDao.get(id);
	}

	@Override
	public void save(CustomerInfo customerInfo) {
		customerInfoDao.saveOrUpdate(customerInfo);
	}
}

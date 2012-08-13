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
import com.boan.crm.customer.service.ICustomerInfoService;
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
			hql.append(" and id in ( select customerId from ContractPersonInfo where personName like :contractorName) ");
		}
		if(values.get("customerCategory") != null)
		{
			hql.append(" and categoryId = :customerCategory ");
		}
		
		int totalRows = customerInfoDao.findCountForPage(hql.toString(), values);
		pagination.setTotalRows(totalRows);
		pagination.setData(data);
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

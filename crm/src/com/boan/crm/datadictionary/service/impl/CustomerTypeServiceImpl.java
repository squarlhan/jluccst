package com.boan.crm.datadictionary.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.boan.crm.datadictionary.dao.ICustomerTypeDao;
import com.boan.crm.datadictionary.model.CustomerType;
import com.boan.crm.datadictionary.service.ICustomerTypeService;
import com.boan.crm.utils.page.Pagination;

@Service("customerTypeService")
public class CustomerTypeServiceImpl implements ICustomerTypeService{
	
	@Autowired
	@Qualifier("customerTypeDao")
	private ICustomerTypeDao customerTypeDao;

	@Override
	public void deleteCustomerType(String... ids) {
		customerTypeDao.delete(ids);
	}

	@Override
	public List<CustomerType> findAllCustomerType() {
		return customerTypeDao.findAll();
	}

	@Override
	public Pagination<CustomerType> findCustomerTypeForPage(
			Map<String, ?> values, Pagination<CustomerType> pagination) {
		String hql = "from CustomerType";
		List<CustomerType> data = customerTypeDao.findForPage(hql, values, pagination.getStartIndex(), pagination.getPageSize());
		hql = "select count(*) from CustomerType";
		int totalRows = customerTypeDao.findCountForPage(hql, values);
		pagination.setTotalRows(totalRows);
		pagination.setData(data);
		return pagination;
	}

	@Override
	public CustomerType get(String id) {
		return customerTypeDao.get(id);
	}

	@Override
	public void save(CustomerType table1) {
		customerTypeDao.saveOrUpdate(table1);
	}
	
}

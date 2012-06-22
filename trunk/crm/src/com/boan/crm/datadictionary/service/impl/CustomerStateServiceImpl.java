package com.boan.crm.datadictionary.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.boan.crm.datadictionary.dao.ICustomerStateDao;
import com.boan.crm.datadictionary.model.CustomerState;
import com.boan.crm.datadictionary.service.ICustomerStateService;
import com.boan.crm.utils.page.Pagination;

@Service("customerStateService")
public class CustomerStateServiceImpl implements ICustomerStateService{
	
	@Autowired
	@Qualifier("customerStateDao")
	private ICustomerStateDao customerStateDao;

	@Override
	public void deleteCustomerState(String... ids) {
		customerStateDao.delete(ids);
	}

	@Override
	public List<CustomerState> findAllCustomerState() {
		return customerStateDao.find("from CustomerState order by sortIndex asc", new Object[0]);
	}

	@Override
	public Pagination<CustomerState> findCustomerStateForPage(
			Map<String, ?> values, Pagination<CustomerState> pagination) {
		String hql = "from CustomerState order by sortIndex asc";
		List<CustomerState> data = customerStateDao.findForPage(hql, values, pagination.getStartIndex(), pagination.getPageSize());
		hql = "select count(*) from CustomerState order by sortIndex asc";
		int totalRows = customerStateDao.findCountForPage(hql, values);
		pagination.setTotalRows(totalRows);
		pagination.setData(data);
		return pagination;
	}

	@Override
	public CustomerState get(String id) {
		return customerStateDao.get(id);
	}

	@Override
	public void save(CustomerState table1) {
		customerStateDao.saveOrUpdate(table1);
	}
	
}

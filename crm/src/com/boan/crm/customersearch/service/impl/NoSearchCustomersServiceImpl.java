package com.boan.crm.customersearch.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.boan.crm.customersearch.dao.INoSearchCustomersDao;
import com.boan.crm.customersearch.model.NoSearchCustomers;
import com.boan.crm.customersearch.service.INoSearchCustomersService;

@Service("noSearchCustomersService")
public class NoSearchCustomersServiceImpl implements INoSearchCustomersService {

	@Autowired
	@Qualifier("noSearchCustomersDao")
	private INoSearchCustomersDao noSearchCustomersDao;
	
	public void save(NoSearchCustomers obj){
		noSearchCustomersDao.save(obj);
	}
	
	public List<String> findCustomerLibIds(String salesmanId){
		Map values = new HashMap();
		values.put("salesmanId", salesmanId);
		String hql = "Select customerLibId from NoSearchCustomers where salesmanId=:salesmanId ";
		return noSearchCustomersDao.find(hql , values);
	}
	
	public List<String> findCustomerLibIds(String company_Id ,String salesmanId){
		Map values = new HashMap();
		values.put("salesmanId", salesmanId);
		values.put("company_Id", company_Id);
		String hql = "Select customerLibId from NoSearchCustomers where salesmanId=:salesmanId and company_Id=:company_Id";
		return noSearchCustomersDao.find(hql , values);
	}
}

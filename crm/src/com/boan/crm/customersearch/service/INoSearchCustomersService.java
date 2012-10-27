package com.boan.crm.customersearch.service;

import java.util.List;

import com.boan.crm.customersearch.model.NoSearchCustomers;

public interface INoSearchCustomersService {

	public void save(NoSearchCustomers obj);
	
	public List<String> findCustomerLibIds(String salesmanId);
	
	public List<String> findCustomerLibIds(String company_Id ,String salesmanId);
}

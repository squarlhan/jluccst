package com.boan.crm.customersearch.dao.impl;

import org.springframework.stereotype.Repository;

import com.boan.crm.customersearch.dao.INoSearchCustomersDao;
import com.boan.crm.customersearch.model.NoSearchCustomers;
import com.boan.crm.utils.dao.impl.BaseDao;

@Repository("noSearchCustomersDao")
public class NoSearchCustomersDaoImpl extends BaseDao<NoSearchCustomers, String> implements INoSearchCustomersDao {

}

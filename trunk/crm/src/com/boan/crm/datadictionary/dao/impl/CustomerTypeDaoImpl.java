package com.boan.crm.datadictionary.dao.impl;

import org.springframework.stereotype.Repository;

import com.boan.crm.datadictionary.dao.ICustomerTypeDao;
import com.boan.crm.datadictionary.model.CustomerType;
import com.boan.crm.utils.dao.impl.BaseDao;

/**
 * @author leon
 * @version 1.0.0
 */
@Repository("customerTypeDao")
public class CustomerTypeDaoImpl extends BaseDao<CustomerType, String>
		implements ICustomerTypeDao {
}

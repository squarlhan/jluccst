package com.boan.crm.datadictionary.dao.impl;

import org.springframework.stereotype.Repository;

import com.boan.crm.datadictionary.dao.ICustomerStateDao;
import com.boan.crm.datadictionary.model.CustomerState;
import com.boan.crm.utils.dao.impl.BaseDao;

/**
 * @author leon
 * @version 1.0.0
 */
@Repository("customerStateDao")
public class CustomerStateDaoImpl extends BaseDao<CustomerState, String>
		implements ICustomerStateDao {
}

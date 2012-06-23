/**
 * 
 */
package com.boan.crm.customer.dao.impl;

import org.springframework.stereotype.Repository;

import com.boan.crm.customer.dao.ICustomerInfoDAO;
import com.boan.crm.customer.model.CustomerInfo;
import com.boan.crm.utils.dao.impl.BaseDao;

/**
 * @author luojx
 *　客户信息DAO实现类
 */
@Repository("customerInfoDao")
public class CustomerInfoDAOImpl extends BaseDao<CustomerInfo, String> implements ICustomerInfoDAO{

}

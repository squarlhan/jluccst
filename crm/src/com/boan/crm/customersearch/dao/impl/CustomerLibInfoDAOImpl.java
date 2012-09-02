/**
 * 
 */
package com.boan.crm.customersearch.dao.impl;

import org.springframework.stereotype.Repository;

import com.boan.crm.customersearch.dao.ICustomerLibInfoDAO;
import com.boan.crm.customersearch.model.CustomerLibInfo;
import com.boan.crm.utils.dao.impl.BaseDao;

/**
 * @author luojx
 *　客户信息DAO实现类
 */
@Repository("customerLibInfoDao")
public class CustomerLibInfoDAOImpl extends BaseDao<CustomerLibInfo, String> implements ICustomerLibInfoDAO{

}

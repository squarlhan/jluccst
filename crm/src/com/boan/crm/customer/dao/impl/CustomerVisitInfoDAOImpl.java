/**
 * 
 */
package com.boan.crm.customer.dao.impl;

import org.springframework.stereotype.Repository;

import com.boan.crm.customer.dao.ICustomerVisitInfoDAO;
import com.boan.crm.customer.model.CustomerVisitInfo;
import com.boan.crm.utils.dao.impl.BaseDao;

/**
 * @author luojx
 *　客户跟进信息DAO实现类
 */
@Repository("customerVisitInfoDao")
public class CustomerVisitInfoDAOImpl extends BaseDao<CustomerVisitInfo, String> implements ICustomerVisitInfoDAO{

}

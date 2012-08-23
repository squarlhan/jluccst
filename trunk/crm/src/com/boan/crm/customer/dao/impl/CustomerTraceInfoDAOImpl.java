/**
 * 
 */
package com.boan.crm.customer.dao.impl;

import org.springframework.stereotype.Repository;

import com.boan.crm.customer.dao.ICustomerTraceInfoDAO;
import com.boan.crm.customer.model.CustomerTraceInfo;
import com.boan.crm.utils.dao.impl.BaseDao;

/**
 * @author luojx
 *　客户跟进信息DAO实现类
 */
@Repository("customerTraceInfoDao")
public class CustomerTraceInfoDAOImpl extends BaseDao<CustomerTraceInfo, String> implements ICustomerTraceInfoDAO{

}

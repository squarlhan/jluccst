/**
 * 
 */
package com.boan.crm.customer.dao.impl;

import org.springframework.stereotype.Repository;

import com.boan.crm.customer.dao.ICustomerStaticInfoDAO;
import com.boan.crm.customer.model.CustomerStaticInfo;
import com.boan.crm.utils.dao.impl.BaseDao;

/**
 * @author luojx
 *　客户统计信息DAO实现类
 */
@Repository("customerStaticInfoDao")
public class CustomerStaticInfoDAOImpl extends BaseDao<CustomerStaticInfo, String> implements ICustomerStaticInfoDAO{

}

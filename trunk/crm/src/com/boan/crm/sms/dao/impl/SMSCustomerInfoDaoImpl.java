package com.boan.crm.sms.dao.impl;

import org.springframework.stereotype.Repository;

import com.boan.crm.sms.dao.ISMSCustomerInfoDao;
import com.boan.crm.sms.model.SMSCustomerInfo;
import com.boan.crm.utils.dao.impl.BaseDao;

/**
 * 短信管理Dao接口实现
 * @author Administrator
 *
 */
@Repository("SMSCustomerInfoDao")
public class SMSCustomerInfoDaoImpl extends BaseDao<SMSCustomerInfo, String> implements ISMSCustomerInfoDao{

}

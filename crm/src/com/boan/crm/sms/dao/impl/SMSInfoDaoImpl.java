package com.boan.crm.sms.dao.impl;

import org.springframework.stereotype.Repository;

import com.boan.crm.sms.dao.ISMSInfoDao;
import com.boan.crm.sms.model.SMSInfo;
import com.boan.crm.utils.dao.impl.BaseDao;

/**
 * 短信管理Dao接口实现
 * @author Administrator
 *
 */
@Repository("SMSInfoDao")
public class SMSInfoDaoImpl extends BaseDao<SMSInfo, String> implements ISMSInfoDao{

}

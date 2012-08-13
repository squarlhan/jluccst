package com.boan.crm.servicemanage.dao.impl;

import org.springframework.stereotype.Repository;

import com.boan.crm.servicemanage.dao.IServiceLogDao;
import com.boan.crm.servicemanage.model.ServiceLog;
import com.boan.crm.utils.dao.impl.BaseDao;

/**
* 服务管理Dao接口实现
* @author XXX
* @version 1.0.0
*/

@Repository("serviceLogDao")
public class ServiceLogDaoImpl extends BaseDao<ServiceLog,String> implements IServiceLogDao{
}

/*
 * @(#)ErrorLogDaoImpl.java 1.1 2012-4-24
 */

package com.boan.rees.error.dao.impl;

import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.boan.rees.error.dao.IErrorLogDao;
import com.boan.rees.error.model.ErrorLog;
import com.boan.rees.utils.dao.impl.BaseDao;

/**
 * 故障日志Dao接口实现 类
 * @author zhaomengxue
 * @version 1.0.0
 */
@Repository("errorLogDao")
public class ErrorLogDaoImpl extends BaseDao<ErrorLog, String> implements IErrorLogDao{

}


/**
 * Copyright (c) 2011 Changchun Boan Co. Ltd.
 * All right reserved.
 * History
 */
/*
 * @(#)LogServiceImpl.java 1.1 2011-1-11
 */

package com.boan.crm.backstagemanage.service.impl;

import java.io.File;
import java.util.Calendar;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Property;

import com.boan.crm.backstagemanage.dao.ILogDao;
import com.boan.crm.backstagemanage.model.Log;
import com.boan.crm.backstagemanage.service.ILogService;

/**
 * 日志ServiceImpl类
 * 
 * @author XXX
 * @version 1.0.0
 */
public class LogServiceImpl implements ILogService
{

	private ILogDao dao = null;

	public void deleteLog( Calendar beginTime, Calendar endTime )
			throws Exception
	{
		dao.deleteLog( beginTime, endTime );
	}

	public List<Log> queryLogList( Calendar beginTime, Calendar endTime )
			throws Exception
	{
		return dao.queryLogList( beginTime, endTime );
	}

	public List<Log> queryLogListByPage( Log log,Calendar beginTime, Calendar endTime, int begin, int maxResult ) throws Exception
	{
		return dao.queryLogListByPage( log, beginTime, endTime, begin, maxResult );
	}

	public int queryLogListCount( Calendar beginTime, Calendar endTime ) throws Exception
	{
		return dao.queryLogListCount( beginTime, endTime );
	}

	public int queryLogListCountByPage( Log log, Calendar beginTime, Calendar endTime ) throws Exception
	{
		return dao.queryLogListCountByPage( log, beginTime, endTime );
	}

	public void saveLog( Log log ) throws Exception
	{
		dao.saveLog( log );
	}

	public ILogDao getDao()
	{
		return dao;
	}

	public void setDao( ILogDao dao )
	{
		this.dao = dao;
	}


	private List<Log> queryLogDateList( Calendar endTime ) throws Exception
	{
		return dao.queryLogDateList( endTime );
	}
	/**
	 * 创建日志目录
	 * @param logDir
	 */
	private void createLogDir( String logDir )
	{
		File file = new File(logDir);
		if (!file.exists()) 
		{
			file.mkdirs();
		}
	}
}

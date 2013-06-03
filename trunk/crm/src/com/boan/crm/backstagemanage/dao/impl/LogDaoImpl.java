/**
 * Copyright (c) 2011 Changchun Boan Co. Ltd.
 * All right reserved.
 * History
 */
/*
 * @(#)LogDao.java 1.1 2011-1-11
 */

package com.boan.crm.backstagemanage.dao.impl;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import com.boan.crm.backstagemanage.dao.ILogDao;
import com.boan.crm.backstagemanage.model.Log;
import com.boan.crm.utils.calendar.CurrentDateTime;
import com.boan.crm.utils.dao.impl.BaseDao;

/**
 * 日志DaoImpl类
 * 
 * @author XXX
 * @version 1.0.0
 */
@Repository("logDao")
public class LogDaoImpl  extends BaseDao<Log,String> implements ILogDao 
{
	public void saveLog( Log log ) throws Exception
	{
		//将LogDate由CreateTime转为int型
		String currentTime = CurrentDateTime.getCurrentDate( log.getCreateTime() );
		log.setLogDate( Integer.parseInt( currentTime.replace( "-", "" ) ) );
		super.save( log );
	}
	public List<Log> queryLogList( Calendar beginTime, Calendar endTime )
			throws Exception
	{
		List<Log> list = null;
		if( beginTime != null && endTime != null )
		{
			try
			{
				String hql = "from Log where createTime>=:beginTime and createTime<=:endTime order by createTime desc";
				Map<String, Object> map = new HashMap<String, Object>();
				map.put( "beginTime", beginTime );
				map.put( "endTime", endTime );
				list = super.find( hql, map );
			}
			catch( Exception ex )
			{
				ex.printStackTrace();
				throw ex;
			}
		}
		return list;
	}
	public int queryLogListCount( Calendar beginTime, Calendar endTime )
			throws Exception
	{
		int rowCount = 0;
		try
		{
			String hql = "select count(id) from Log where createTime>=:beginTime and createTime<=:endTime";
			Map<String, Object> map = new HashMap<String, Object>();
			map.put( "beginTime", beginTime );
			map.put( "endTime", endTime );
			rowCount  = Integer.parseInt(super.find(hql,map).get(0).toString());
		}
		catch( Exception ex )
		{
			ex.printStackTrace();
			throw ex;
		}
		return rowCount;
	}


	public List<Log> queryLogListByPage( Log log,Calendar beginTime, Calendar endTime, int begin, int maxResult ) throws Exception
	{
		List<Log> list = null;
		try
		{
			StringBuffer sb = new StringBuffer();
			sb.append( " from Log where 1=1 " );
			if( log != null )
			{
				if( log.getLogType() != -1)
				{
					sb.append( " and logType = " + log.getLogType() );
				}
				if( StringUtils.isNotBlank( log.getLogContent() ) ) 
				{
					sb.append( " and logContent like '" + "%"+ log.getLogContent() +"%'" );
				}
				if( StringUtils.isNotBlank( log.getUserName() ) )
				{
					sb.append( " and userName like '" + "%"+ log.getUserName() +"%'");
				}
			}
			if( beginTime != null && endTime != null )
			{
				sb.append( " and createTime between  :beginTime and :endTime ");
			}
			sb.append( " order by createTime desc" );
			
			if( beginTime != null && endTime != null )
			{
				Map<String, Object> map = new HashMap<String, Object>();
				map.put( "beginTime", beginTime );
				map.put( "endTime", endTime );
				list = super.find( sb.toString(),map);
			}
			else
			{
				list = super.find( sb.toString());
			}
		}
		catch( Exception ex )
		{
			ex.printStackTrace();
			throw ex;
		}
		return list;
	}
	public int queryLogListCountByPage( Log log, Calendar beginTime, Calendar endTime ) throws Exception
	{
		int rowCount = 0;
		try
		{
			StringBuffer sb = new StringBuffer();
			sb.append( " select count(id) from Log where 1=1 " );
			if( log != null )
			{
				if( log.getLogType() != -1)
				{
					sb.append( " and logType = " + log.getLogType() );
				}
				if( StringUtils.isNotBlank( log.getLogContent() ) ) 
				{
					sb.append( " and logContent like '" + "%"+ log.getLogContent() +"%'" );
				}
				if( StringUtils.isNotBlank( log.getUserName() ) )
				{
					sb.append( " and userName like '" + "%"+ log.getUserName() +"%'");
				}
			}
			if( beginTime != null && endTime != null )
			{
				sb.append( " and createTime between  :beginTime and :endTime ");
				
				Map<String, Object> map = new HashMap<String, Object>();
				map.put( "beginTime", beginTime );
				map.put( "endTime", endTime );
				rowCount  = Integer.parseInt(super.find(sb.toString(),map).get(0).toString());
			}
			else
			{
				rowCount  = Integer.parseInt(super.find(sb.toString()).get(0).toString());
			}
		}
		catch( Exception ex )
		{
			ex.printStackTrace();
			throw ex;
		}
		return rowCount;
	}
	public void deleteLog( Calendar beginTime, Calendar endTime ) throws Exception
	{
		try
		{
			String hql = "delete from Log where createTime>=:beginTime and createTime<=:endTime";
			Map<String, Object> map = new HashMap<String, Object>();
			map.put( "beginTime", beginTime );
			super.executeHql(hql, map);
		}
		catch( Exception ex )
		{
			ex.printStackTrace();
			throw ex;
		}
	}
	public List<Log> queryLogDateList( Calendar endTime )
			throws Exception
	{
		List<Log> list = null;
		if( endTime != null )
		{
			try
			{
				String hql = "select distinct new Log(logDate) from Log where createTime<=:endTime order by logDate";
				Map<String, Object> map = new HashMap<String, Object>();
				map.put( "endTime", endTime );
				list = super.find(hql,map);
			}
			catch( Exception ex )
			{
				ex.printStackTrace();
				throw ex;
			}
		}
		return list;
	}
	@Override
	public void deleteAllLog() throws Exception {
		try
		{
			String hql = "delete from Log";
			super.executeHql(hql,null);
		}
		catch( Exception ex )
		{
			ex.printStackTrace();
			throw ex;
		}
	}
	
}

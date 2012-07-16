/**
 * Copyright (c) 2011 Changchun Boan Co. Ltd.
 * All right reserved.
 * History
 */
/*
 * @(#)Log.java 1.1 2011-1-10
 */

package com.boan.crm.backstagemanage.model;

import java.util.Calendar;

import org.apache.commons.lang.StringUtils;

import com.boan.crm.backstagemanage.common.LogType;
import com.boan.crm.utils.calendar.CurrentDateTime;

/**
 * 系统日志Pojo类
 * 
 * @author XXX
 * @version 1.0.0
 */
public class Log implements java.io.Serializable
{

	public Log()
	{
	}

	public Log( int logDate )
	{
		this.logDate = logDate;
	}

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -6861248835930396584L;

	/**
	 * 主键ID
	 */
	private String id = null;

	/**
	 * 日志类别0表示信息；1表示警告；2表示错误
	 */
	private int logType = 0;

	/**
	 * 日志内容
	 */
	private String logContent = null;

	/**
	 * 创建时间
	 */
	private Calendar createTime = Calendar.getInstance();
	
	/**
	 * 集团名称
	 */
	private String unitName = null;
	
	/**
	 * 集团id
	 */
	private String unitId = null;

	/**
	 * 组id 
	 */
	private String deptId = null;
	
	/**
	 * 所在组名
	 */
	private String deptName = null;
	
	/**
	 * 用户id
	 */
	private String userId = null;
	/**
	 * 用户姓名
	 */
	private String userName = null;

	/**
	 * 用户IP
	 */
	private String userIp = null;

	/**
	 * 日期格式如20090115，用于过滤某一天的日志，便于日志归档
	 */
	private int logDate = 0;
	
	public String getId()
	{
		return id;
	}

	public void setId( String id )
	{
		this.id = id;
	}

	public int getLogType()
	{
		return logType;
	}
	public String getLogTypeMean()
	{
		return LogType.getMean( logType );
	}
	public void setLogType( int logType )
	{
		this.logType = logType;
	}

	public String getLogContent()
	{
		return logContent;
	}

	public void setLogContent( String logContent )
	{
		this.logContent = logContent;
	}

	public Calendar getCreateTime()
	{
		return createTime;
	}

	public String getCreateTimeEn()
	{
		return CurrentDateTime.getCurrentDateTime( createTime );
	}
	public void setCreateTime( Calendar createTime )
	{
		this.createTime = createTime;
	}

	public String getUserName()
	{
		return userName;
	}

	public void setUserName( String userName )
	{
		this.userName = userName;
	}

	public String getUserIp()
	{
		return userIp;
	}

	public void setUserIp( String userIp )
	{
		this.userIp = userIp;
	}

	public static long getSerialversionuid()
	{
		return serialVersionUID;
	}


	public int getLogDate()
	{
		return logDate;
	}

	public void setLogDate( int logDate )
	{
		this.logDate = logDate;
	}

	public String getDeptId()
	{
		return deptId;
	}

	public void setDeptId( String deptId )
	{
		this.deptId = deptId;
	}

	public String getDeptName()
	{
		return deptName;
	}

	public void setDeptName( String deptName )
	{
		this.deptName = deptName;
	}

	public String getUserId()
	{
		return userId;
	}

	public void setUserId( String userId )
	{
		this.userId = userId;
	}

	public String getUnitName()
	{
		return unitName;
	}

	public void setUnitName( String unitName )
	{
		this.unitName = unitName;
	}

	public String getUnitId()
	{
		return unitId;
	}

	public void setUnitId( String unitId )
	{
		this.unitId = unitId;
	}
	/**
	 * 包括集团在内的组的全名
	 */
	public String getDeptFullName()
	{
		String fullName = this.unitName;
		
		if( StringUtils.isNotBlank( this.deptName ) )
		{
			fullName +=  "→" + this.deptName;
		}
		return fullName;
	}
}

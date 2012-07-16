/**
 * Copyright (c) 2011 Changchun Boan Co. Ltd.
 * All right reserved.
 * History
 */
/*
 * @(#)S.java 1.1 2011-1-25
 */

package com.boan.crm.backstagemanage.action;

import java.util.Calendar;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.boan.crm.backstagemanage.common.LogConfig;
import com.boan.crm.backstagemanage.common.LogType;
import com.boan.crm.backstagemanage.model.Log;
import com.boan.crm.backstagemanage.service.ILogService;
import com.boan.crm.common.Message;
import com.boan.crm.utils.action.BaseActionSupport;
import com.boan.crm.utils.calendar.CurrentDateTime;
import com.boan.crm.utils.calendar.MySimpleDateFormat;
import com.boan.crm.utils.page.Pagination;


/**
 * 日志Action类
 * @author XXX
 * @version 1.0.0
 */
public class LogAction extends BaseActionSupport
{
	private ILogService logService = null;
	
	private Pagination<Log> pagination = null;
	
	private List<Log> logList = null;

	private String beginTime = null;
	
	private String endTime = null;
	
	private String logKeepDate = null;
	
	private Log log = null;
	
	private List<LogType> logTypeList = null;
	
	private String divShowFlag = "none";
	
	private Message message = null;

	/**
	 * 显示数据库中的日志列表
	 * @return
	 * @throws Exception
	 */
	public String showLogList() throws Exception
	{
		logKeepDate = CurrentDateTime.getCurrentDate(MySimpleDateFormat.parseToDateTime( Calendar.getInstance(), -LogConfig.logKeepDays ) );
		logTypeList = LogType.getLogTypeList();
	//	pagination.excute( logService.queryLogListCountByPage( log,MySimpleDateFormat.parseToBeginTime( beginTime ),  MySimpleDateFormat.parseToEndTime( endTime ) ) );
		logList = logService.queryLogListByPage( log, MySimpleDateFormat.parseToBeginTime( beginTime ),  MySimpleDateFormat.parseToEndTime( endTime ) , pagination.getStartIndex(), pagination.getPageSize() );
	//	pagination.setUrl( "./logAction!showLogList.action" );
		return  "log-list";
	}

	public List<Log> getLogList()
	{
		return logList;
	}

	public void setLogList( List<Log> logList )
	{
		this.logList = logList;
	}
	public ILogService getLogService()
	{
		return logService;
	}

	public void setLogService( ILogService logService )
	{
		this.logService = logService;
	}
	public List<LogType> getLogTypeList()
	{
		return logTypeList;
	}
	public void setLogTypeList( List<LogType> logTypeList )
	{
		this.logTypeList = logTypeList;
	}
	public String getBeginTime()
	{
		return beginTime;
	}
	public void setBeginTime( String beginTime )
	{
		this.beginTime = beginTime;
	}
	public String getEndTime()
	{
		return endTime;
	}
	public void setEndTime( String endTime )
	{
		this.endTime = endTime;
	}
	public Log getLog()
	{
		return log;
	}
	public void setLog( Log log )
	{
		this.log = log;
	}

	public String getDivShowFlag()
	{
		return divShowFlag;
	}
	public void setDivShowFlag( String divShowFlag )
	{
		this.divShowFlag = divShowFlag;
	}
	public String getLogKeepDate()
	{
		return logKeepDate;
	}
	public void setLogKeepDate( String logKeepDate )
	{
		this.logKeepDate = logKeepDate;
	}
	public Message getMessage()
	{
		return message;
	}
	public void setMessage( Message message )
	{
		this.message = message;
	}

	public Pagination<Log> getPagination() {
		return pagination;
	}

	public void setPagination(Pagination<Log> pagination) {
		this.pagination = pagination;
	}

}

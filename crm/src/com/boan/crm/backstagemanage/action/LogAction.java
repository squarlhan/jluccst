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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

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
 * 
 * @author XXX
 * @version 1.0.0
 */
@Controller("logAction")
@Scope("prototype")
public class LogAction extends BaseActionSupport {
	private static final long serialVersionUID = -4716066844752664441L;

	@Autowired
	@Qualifier("logService")
	private ILogService logService = null;

	private Pagination<Log> pagination = new Pagination<Log>();

	private String beginTime = null;

	private String endTime = null;

	private String logKeepDate = null;

	private Log log = null;

	private List<LogType> logTypeList = null;

	private String divShowFlag = "none";

	private Message message = null;

	/**
	 * 显示数据库中的日志列表
	 * 
	 * @return
	 * @throws Exception
	 */
	public String showLogList() throws Exception {
		logKeepDate = CurrentDateTime.getCurrentDate(MySimpleDateFormat.parseToDateTime(Calendar.getInstance(), -LogConfig.logKeepDays));
		logTypeList = LogType.getLogTypeList();
		// pagination.excute( logService.queryLogListCountByPage(
		// log,MySimpleDateFormat.parseToBeginTime( beginTime ),
		// MySimpleDateFormat.parseToEndTime( endTime ) ) );
		pagination = logService.queryLogListByPage(log, MySimpleDateFormat.parseToBeginTime(beginTime), MySimpleDateFormat.parseToEndTime(endTime), pagination);
		// pagination.setUrl( "./logAction!showLogList.action" );
		return "log-list";
	}

	/**
	 * 清空日志
	 * 
	 * @return
	 * @throws Exception
	 */
	public String clearAllLog() throws Exception {
		logService.deleteAllLog();
		return this.showLogList();
	}

	public List<LogType> getLogTypeList() {
		return logTypeList;
	}

	public void setLogTypeList(List<LogType> logTypeList) {
		this.logTypeList = logTypeList;
	}

	public String getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public Log getLog() {
		return log;
	}

	public void setLog(Log log) {
		this.log = log;
	}

	public String getDivShowFlag() {
		return divShowFlag;
	}

	public void setDivShowFlag(String divShowFlag) {
		this.divShowFlag = divShowFlag;
	}

	public String getLogKeepDate() {
		return logKeepDate;
	}

	public void setLogKeepDate(String logKeepDate) {
		this.logKeepDate = logKeepDate;
	}

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}

	public Pagination<Log> getPagination() {
		return pagination;
	}

	public void setPagination(Pagination<Log> pagination) {
		this.pagination = pagination;
	}

}

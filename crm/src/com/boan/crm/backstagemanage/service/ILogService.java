/**
 * Copyright (c) 2011 Changchun Boan Co. Ltd.
 * All right reserved.
 * History
 */
/*
 * @(#)ILogService.java 1.1 2011-1-11
 */

package com.boan.crm.backstagemanage.service;

import java.util.Calendar;
import java.util.List;

import com.boan.crm.backstagemanage.model.Log;


/**
 * 日志Service类
 * @author JiangHY
 * @version 1.0.0
 */
public interface ILogService {
	/**
	 * 保存日志对象
	 * 
	 * @param log
	 * @return
	 * @throws Exception
	 */
	public void saveLog( Log log ) throws Exception;

	/**
	 * 查询指定时间段的日志
	 * 
	 * @param beginTime
	 * @param endTime
	 * @return
	 * @throws Exception
	 */
	public List<Log> queryLogList( Calendar beginTime, Calendar endTime )
			throws Exception;

	/**
	 * 查询指定时间段的日志列表数
	 * 
	 * @param beginTime
	 * @param endTime
	 * @return
	 * @throws Exception
	 */
	public int queryLogListCount( Calendar beginTime, Calendar endTime )
			throws Exception;

	/**
	 * 分页获取日志列表
	 * 
	 * @param beginTime
	 * @param endTime
	 * @param begin
	 * @param maxResult
	 * @return
	 * @throws Exception
	 */
	public List<Log> queryLogListByPage( Log log, Calendar beginTime, Calendar endTime, int begin, int maxResult ) throws Exception;
	/**
	 * 用于显示指定时间段内的日志列表总数
	 * 
	 * @param beginTime
	 * @param endTime
	 * @return
	 * @throws Exception
	 */
	public int queryLogListCountByPage( Log log, Calendar beginTime, Calendar endTime) throws Exception;
	
	/**
	 * 删除指定时间段的日志
	 * 
	 * @param beginTime
	 * @param endTime
	 * @throws Exception
	 */
	public void deleteLog( Calendar beginTime, Calendar endTime ) throws Exception;
}

/**
 * Copyright (c) 2011 Changchun Boan Co. Ltd.
 * All right reserved.
 * History
 */
/*
 * @(#)ILogDao.java 1.1 2011-1-11
 */

package com.boan.crm.backstagemanage.dao;

import java.util.Calendar;
import java.util.List;

import com.boan.crm.backstagemanage.model.Log;
import com.boan.crm.utils.dao.IBaseDao;


/**
 * 日志Dao类
 * 
 * @author XXX
 * @version 1.0.0
 */
public interface ILogDao extends IBaseDao<Log,String>
{

	/**
	 * 保存日志
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
	 * 取得指定时间段内容的日志总数
	 * 
	 * @param beginTime
	 * @param endTime
	 * @return
	 * @throws Exception
	 */
	public int queryLogListCount( Calendar beginTime, Calendar endTime )
			throws Exception;

	/**
	 * 分页显示指定时间段内的日志列表
	 * 
	 * @param beginTime
	 * @param endTime
	 * @param begin
	 * @param maxResult
	 * @return
	 * @throws Exception
	 */
	public List<Log> queryLogListByPage( Log log,Calendar beginTime, Calendar endTime, int begin, int maxResult ) throws Exception;
	/**
	 * 用于分页显示指定时间段内的日志总数
	 * 
	 * @param beginTime
	 * @param endTime
	 * @return
	 * @throws Exception
	 */
	public int queryLogListCountByPage( Log log, Calendar beginTime, Calendar endTime ) throws Exception;
	
	/**
	 * 删除指定时间段的日志
	 * 
	 * @param beginTime
	 * @param endTime
	 * @throws Exception
	 */
	public void deleteLog( Calendar beginTime, Calendar endTime ) throws Exception;

	/**
	 * 获取要归档的日志时间段列表
	 * @param endTime
	 * @return
	 * @throws Exception
	 */
	public List<Log> queryLogDateList( Calendar endTime ) throws Exception;
	/**
	 * 清空日志
	 * @throws Exception
	 */
	public void deleteAllLog() throws Exception;
}

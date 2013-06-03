/**
 * Copyright (c) 2011 Changchun Boan Co. Ltd.
 * All right reserved.
 * History
 */
/*
 * @(#)LogServiceImpl.java 1.1 2011-1-11
 */

package com.boan.crm.backstagemanage.service.impl;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.boan.crm.backstagemanage.dao.ILogDao;
import com.boan.crm.backstagemanage.model.Log;
import com.boan.crm.backstagemanage.service.ILogService;
import com.boan.crm.utils.page.Pagination;

/**
 * 日志ServiceImpl类
 * 
 * @author XXX
 * @version 1.0.0
 */
@Service("logService")
public class LogServiceImpl implements ILogService {
	@Autowired
	@Qualifier("logDao")
	private ILogDao dao = null;

	public void deleteLog(Calendar beginTime, Calendar endTime) throws Exception {
		dao.deleteLog(beginTime, endTime);
	}

	public List<Log> queryLogList(Calendar beginTime, Calendar endTime) throws Exception {
		return dao.queryLogList(beginTime, endTime);
	}

	public Pagination<Log> queryLogListByPage(Log log, Calendar beginTime, Calendar endTime, Pagination<Log> pagination) throws Exception {

		String hql = "from Log order by  createTime asc";
		List<Log> data = dao.findForPage(hql, null, pagination.getStartIndex(), pagination.getPageSize());
		hql = "select count(*) from Log";
		int totalRows = dao.findCountForPage(hql, null);
		pagination.setTotalRows(totalRows);
		pagination.setData(data);
		return pagination;

		// return dao.queryLogListByPage(log, beginTime, endTime, begin,
		// maxResult);

	}

	public int queryLogListCount(Calendar beginTime, Calendar endTime) throws Exception {
		return dao.queryLogListCount(beginTime, endTime);
	}

	public int queryLogListCountByPage(Log log, Calendar beginTime, Calendar endTime) throws Exception {
		return dao.queryLogListCountByPage(log, beginTime, endTime);
	}

	public void saveLog(Log log) throws Exception {
		dao.saveLog(log);
	}

	@Override
	public void deleteAllLog() throws Exception {
		dao.deleteAllLog();
	}
}

/*
 * @(#)ErrorLogService.java 1.1 2012-4-25
 */

package com.boan.rees.error.service.impl;

import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.boan.rees.error.dao.IErrorLogDao;
import com.boan.rees.error.model.ErrorLog;
import com.boan.rees.error.service.IErrorLogService;
import com.boan.rees.utils.page.Pagination;

/**
 * 故障日志服务实现 类
 * 
 * @author zhaomengxue
 * @version 1.0.0
 */
@Service("errorLogService")
public class ErrorLogServiceImpl implements IErrorLogService {

	@Autowired
	@Qualifier("errorLogDao")
	private IErrorLogDao errorLogDao;

	/**
	 * 查询全部故障对象
	 */
	@Override
	public List<ErrorLog> findAllErrorLog() {
		return errorLogDao.findAll();
	}

	/**
	 * 根据id查找对象
	 */
	@Override
	public ErrorLog get(String id) {
		return errorLogDao.get(id);
	}

	/**
	 * 保存报表
	 */
	@Override
	public void save(ErrorLog table1) {
		errorLogDao.save(table1);
	}

	/**
	 * 置位，是否解除
	 * 
	 * @param id
	 */
	@Override
	public void updateSetIsRemove(String id) {
		ErrorLog fault = errorLogDao.get(id);
		fault.setIsRemove(1);
		fault.setRemoveTime(Calendar.getInstance());
		
		errorLogDao.saveOrUpdate(fault);

	}

	public IErrorLogDao getErrorLogDao() {
		return errorLogDao;
	}

	public void setErrorLogDao(IErrorLogDao errorLogDao) {
		this.errorLogDao = errorLogDao;
	}

	/**
	 * 按分页查询
	 */
	@Override
	public Pagination<ErrorLog> findErrorLogForPage(Map<String, ?> values,
			Pagination<ErrorLog> pagination) {

		String hql = "from ErrorLog";
		if(values.get( "category" ).equals( "1" ))
		{
			hql = hql + " where isRemove = 0";
		}else if(values.get( "category" ).equals( "2" ))
		{
			
		}
		List<ErrorLog> data = errorLogDao.findForPage(hql, values,
				pagination.getStartIndex(), pagination.getPageSize());
		hql = "select count(*) from ErrorLog";
		if(values.get( "category" ).equals( "1" ))
		{
			hql = hql + " where isRemove = 0";
		}
		int totalRows = errorLogDao.findCountForPage(hql, values);
		pagination.setTotalRows(totalRows);
		pagination.setData(data);
		return pagination;
	}

}

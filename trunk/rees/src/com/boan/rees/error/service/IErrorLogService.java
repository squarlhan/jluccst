/*
 * @(#)IErrorLogService.java 1.1 2012-4-24
 */

package com.boan.rees.error.service;

import java.util.List;
import java.util.Map;

import com.boan.rees.error.model.ErrorLog;
import com.boan.rees.utils.page.Pagination;

/**
 * 故障日志服务接口 类
 * @author zhaomengxue
 * @version 1.0.0
 */
public interface IErrorLogService {
	
	/**
	 * 查询全部对象
	 */
	public List<ErrorLog> findAllErrorLog();
	
	/**
	 * 根据id查找
	 */
	public ErrorLog get(String id);
	
	/**
	 * 保存对象
	 * @param table1
	 */
	public void save(ErrorLog table1);
	
	/**
	 * 置位，是否解除
	 * @param id
	 */
	public void updateSetIsRemove(String id);
	
	/**
	 * 按分页查询
	 */
	public Pagination<ErrorLog> findErrorLogForPage(Map<String, ?> values,Pagination<ErrorLog> pagination);

}


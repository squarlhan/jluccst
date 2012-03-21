/*
 * @(#)IPersonReportService.java 1.1 2012-3-8
 */

package com.boan.rees.report.service;

import java.util.List;
import java.util.Map;

import com.boan.rees.report.model.PersonReport;
import com.boan.rees.utils.page.Pagination;

/**
 * 个人报表服务类接口
 * @author zhaomengxue
 * @version 1.0.0
 */
public interface IPersonReportService {
	
	/**
	 * 查询全部报表对象
	 */
	public List<PersonReport> findAllPersonReport();
	
	/**
	 * 根据id查找报表
	 */
	public PersonReport get(String id);
	
	/**
	 * 根据id删除报表
	 */
	public void deletePersonReport(String... ids );
	
	/**
	 * 保存报表
	 */
	public void save(PersonReport table1);

	/**
	 * 修改报表信息
	 * @param reportInfo 报表对象
	 */
	public void update(PersonReport reportInfo);
	
	/**
	 * 按分页查询
	 */
	public Pagination<PersonReport> findPersonReportForPage(Map<String, ?> values,Pagination<PersonReport> pagination);
}



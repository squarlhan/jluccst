/*
 * @(#)ITemplateReportService.java 1.1 2012-3-8
 */

package com.boan.rees.report.service;

import java.util.List;
import java.util.Map;

import com.boan.rees.report.model.PersonReport;
import com.boan.rees.report.model.TemplateReport;
import com.boan.rees.utils.page.Pagination;

/**
 * 报表模板服务类接口
 * @author zhaomengxue
 * @version 1.0.0
 */
public interface ITemplateReportService {
	
	/**
	 * 查询全部报表对象
	 */
	public List<TemplateReport> findAllTemplateReport();
	
	/**
	 * 获取
	 */
	public TemplateReport get(String id);
	
	/**
	 * 删除
	 */
	public void deleteTemplateReport(String... ids );
	
	/**
	 * 保存
	 */
	public void save(TemplateReport table1);
	
	/**
	 * 按分页查询
	 */
	public Pagination<TemplateReport> findTemplateReportForPage(Map<String, ?> values,Pagination<TemplateReport> pagination);	
}



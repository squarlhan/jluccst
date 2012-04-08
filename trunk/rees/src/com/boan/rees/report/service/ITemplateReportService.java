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
	 * 查询最后一个报表对象
	 */
	public TemplateReport findLastTemplateReport();
	
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
	 * 保存/更新
	 * @param obj
	 */
	public void saveOrUpdate(TemplateReport obj);
	
	/**
	 * 按分页查询
	 */
	public Pagination<TemplateReport> findTemplateReportForPage(Map<String, ?> values,Pagination<TemplateReport> pagination);	
	
	/**
	 * 删除个人报表模板文件
	 * @param templateReportId
	 */
	public void deleteTemplateReportTempleFile(String templateReportId);
}



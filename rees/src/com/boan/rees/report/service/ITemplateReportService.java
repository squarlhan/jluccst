/*
 * @(#)ITemplateReportService.java 1.1 2012-3-8
 */

package com.boan.rees.report.service;

import java.util.List;

import com.boan.rees.report.model.TemplateReport;

/**
 * 报表模板服务类接口
 * @author zhaomengxue
 * @version 1.0.0
 */
public interface ITemplateReportService {
	
	public List<TemplateReport> findAllTemplateReport();
	
	public TemplateReport get(String id);
	
	public void deleteTemplateReport(String... ids );
	
	public void save(TemplateReport table1);
}



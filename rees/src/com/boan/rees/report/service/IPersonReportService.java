/*
 * @(#)IPersonReportService.java 1.1 2012-3-8
 */

package com.boan.rees.report.service;

import java.util.List;

import com.boan.rees.report.model.PersonReport;

/**
 * 个人报表服务类接口
 * @author zhaomengxue
 * @version 1.0.0
 */
public interface IPersonReportService {
	
	public List<PersonReport> findAllPersonReport();
	
	public PersonReport get(String id);
	
	public void deletePersonReport(String... ids );
	
	public void save(PersonReport table1);
}



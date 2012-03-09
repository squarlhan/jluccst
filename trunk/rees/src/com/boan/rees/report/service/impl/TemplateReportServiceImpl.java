/*
 * @(#)TemplateReportServiceImpl.java 1.1 2012-3-8
 */

package com.boan.rees.report.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.boan.rees.report.dao.ITemplateReportDao;
import com.boan.rees.report.model.TemplateReport;
import com.boan.rees.report.service.ITemplateReportService;

/**
 * 报表模板服务类接口实现
 * @author zhaomengxue
 * @version 1.0.0
 */
@Service("templatereportService")
public class TemplateReportServiceImpl implements ITemplateReportService {
	
	@Autowired
	@Qualifier("templatereportDao")
	private ITemplateReportDao templatereportDao;
	
	@Override
	public List<TemplateReport> findAllTemplateReport(){
		return templatereportDao.findAll();
	}
	
	@Override
	public void deleteTemplateReport(String... ids ){
		templatereportDao.delete(ids);
	}

	@Override
	public void save(TemplateReport table1) {
		templatereportDao.save(table1);
	}

	@Override
	public TemplateReport get(String id) {
		return templatereportDao.get(id);
	}
}


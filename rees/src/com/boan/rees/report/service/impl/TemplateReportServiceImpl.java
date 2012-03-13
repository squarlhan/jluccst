/*
 * @(#)TemplateReportServiceImpl.java 1.1 2012-3-8
 */

package com.boan.rees.report.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.boan.rees.report.dao.ITemplateReportDao;
import com.boan.rees.report.model.TemplateReport;
import com.boan.rees.report.service.ITemplateReportService;
import com.boan.rees.utils.page.Pagination;

/**
 * 报表模板服务类接口实现
 * @author zhaomengxue
 * @version 1.0.0
 */
@Service("templateReportService")
public class TemplateReportServiceImpl implements ITemplateReportService {
	
	@Autowired
	@Qualifier("templateReportDao")
	private ITemplateReportDao templateReportDao;

	/**
	 * 查询全部报表对象
	 */
	@Override
	public List<TemplateReport> findAllTemplateReport() {
		return templateReportDao.findAll();
	}

	/**
	 * 获取
	 */
	@Override
	public TemplateReport get(String id) {
		return templateReportDao.get(id);
	}

	/**
	 * 删除
	 */
	@Override
	public void deleteTemplateReport(String... ids) {
		templateReportDao.delete(ids);
	}

	/**
	 * 保存
	 */
	@Override
	public void save(TemplateReport table1) {
		templateReportDao.save(table1);
	}
	
	/**
	 * 按分页查询
	 */
	@Override
	public Pagination<TemplateReport> findTemplateReportForPage(Map<String, ?> values, Pagination<TemplateReport> pagination) {
		
		String hql = "from TemplateReport";
		List<TemplateReport> data = templateReportDao.findForPage(hql, values, pagination.getStartIndex(), pagination.getPageSize());
		hql = "select count(*) from TemplateReport";
		int totalRows = templateReportDao.findCountForPage(hql, values);
		pagination.setTotalRows(totalRows);
		pagination.setData(data);
		return pagination;
	}
	

}


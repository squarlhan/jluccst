/*
 * @(#)TemplateReportDaoImpl.java 1.1 2012-3-8
 */

package com.boan.rees.report.dao.impl;

import org.springframework.stereotype.Repository;

import com.boan.rees.report.dao.ITemplateReportDao;
import com.boan.rees.report.model.TemplateReport;
import com.boan.rees.utils.dao.impl.BaseDao;

/**
 * 报表模板表Dao接口实现
 * @author zhaomengxue
 * @version 1.0.0
 */
@Repository("templateReportDao")
public class TemplateReportDaoImpl extends BaseDao<TemplateReport,String> implements ITemplateReportDao{

}



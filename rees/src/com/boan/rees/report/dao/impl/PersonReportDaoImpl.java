/*
 * @(#)PersonReportDaoImpl.java 1.1 2012-3-8
 */

package com.boan.rees.report.dao.impl;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.boan.rees.report.dao.IPersonReportDao;
import com.boan.rees.report.model.PersonReport;
import com.boan.rees.utils.dao.impl.BaseDao;

/**
 * 个人报表Dao接口实现
 * @author zhaomengxue
 * @version 1.0.0
 */
@Repository("personReportDao")
public class PersonReportDaoImpl extends BaseDao<PersonReport, String> implements IPersonReportDao{
}



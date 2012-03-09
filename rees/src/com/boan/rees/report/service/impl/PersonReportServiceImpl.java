/*
 * @(#)PersonReportServiceImpl.java 1.1 2012-3-8
 */

package com.boan.rees.report.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.boan.rees.report.dao.IPersonReportDao;
import com.boan.rees.report.model.PersonReport;
import com.boan.rees.report.service.IPersonReportService;

/**
 * 个人报表服务类接口实现
 * @author zhaomengxue
 * @version 1.0.0
 */
@Service("personreportService")
public class PersonReportServiceImpl implements IPersonReportService {
	
	@Autowired
	@Qualifier("personreportDao")
	private IPersonReportDao personreportDao;
	
	@Override
	public List<PersonReport> findAllPersonReport(){
		return personreportDao.findAll();
	}
	
	@Override
	public void deletePersonReport(String... ids ){
		personreportDao.delete(ids);
	}

	@Override
	public void save(PersonReport table1) {
		personreportDao.save(table1);
	}

	@Override
	public PersonReport get(String id) {
		return personreportDao.get(id);
	}
}


/*
 * @(#)PersonReportServiceImpl.java 1.1 2012-3-8
 */

package com.boan.rees.report.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.boan.rees.report.model.PersonReport;
import com.boan.rees.report.dao.IPersonReportDao;
import com.boan.rees.report.service.IPersonReportService;
import com.boan.rees.utils.page.Pagination;

/**
 * 个人报表服务类接口实现
 * @author zhaomengxue
 * @version 1.0.0
 */
@Service("personReportService")
public class PersonReportServiceImpl implements IPersonReportService {
	
	@Autowired
	@Qualifier("personReportDao")
	private IPersonReportDao personReportDao;

	/**
	 * 查询全部报表对象
	 */
	@Override
	public List<PersonReport> findAllPersonReport(){
		return personReportDao.findAll();
	}
	
	/**
	 * 删除
	 */
	@Override
	public void deletePersonReport(String... ids ){
		personReportDao.delete(ids);
	}

	/**
	 * 保存
	 */
	@Override
	public void save(PersonReport table1) {
		personReportDao.save(table1);
	}

	/**
	 * 获取主键
	 */
	@Override
	public PersonReport get(String id) {
		return personReportDao.get(id);
	}

	/**
	 * 按分页查询
	 */
	@Override
	public Pagination<PersonReport> findPersonReportForPage(Map<String, ?> values,Pagination<PersonReport> pagination){
		
		String hql = "from PersonReport";
		List<PersonReport> data = personReportDao.findForPage(hql, values, pagination.getStartIndex(), pagination.getPageSize());
		hql = "select count(*) from PersonReport";
		int totalRows = personReportDao.findCountForPage(hql, values);
		pagination.setTotalRows(totalRows);
		pagination.setData(data);
		return pagination;
	}
}

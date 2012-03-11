/**
 * Copyright (c) 2012 Changchun CBIT Co. Ltd.
 * All right reserved.
 * History
 */
/*
 * @(#)DemoServiceImpl.java 1.1 2012-3-5
 */

package com.boan.rees.demo.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.boan.rees.demo.dao.IDemoDao;
import com.boan.rees.demo.model.DemoModel;
import com.boan.rees.demo.service.IDemoService;
import com.boan.rees.utils.page.Pagination;

/**
 * 例子服务类接口实现
 * @author ZhuYF
 * @version 1.0.0
 */
@Service("demoService")
public class DemoServiceImpl implements IDemoService {
	
	@Autowired
	@Qualifier("demoDao")
	private IDemoDao demoDao;
	
	@Override
	public List<DemoModel> findAllDemoModel(){
		return demoDao.findAll();
	}
	
	@Override
	public void deleteDemoModel(String... ids ){
		demoDao.delete(ids);
	}

	@Override
	public void save(DemoModel table1) {
		demoDao.save(table1);
	}

	@Override
	public DemoModel get(String id) {
		return demoDao.get(id);
	}

	@Override
	public Pagination<DemoModel> findDemoModelForPage(Map<String, ?> values,Pagination<DemoModel> pagination){
		
		String hql = "from DemoModel";
		List<DemoModel> data = demoDao.findForPage(hql, values, pagination.getStartIndex(), pagination.getPageSize());
		hql = "select count(*) from DemoModel";
		int totalRows = demoDao.findCountForPage(hql, values);
		pagination.setTotalRows(totalRows);
		pagination.setData(data);
		return pagination;
	}
}


/*
 * @(#)RuleResultInfoServiceImpl.java 1.1 2012-4-23
 */

package com.boan.rees.expertsystem.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.boan.rees.expertsystem.dao.IResultViewDao;
import com.boan.rees.expertsystem.model.ResultView;
import com.boan.rees.expertsystem.service.IResultViewService;
import com.boan.rees.utils.page.Pagination;

/**
 * 现象Service视图接口实现 类
 * @author jiangmeidi
 * @version 1.0.0
 */
@Service("resultViewService")
public class ResultViewServiceImpl implements IResultViewService{
	@Autowired
	@Qualifier("resultViewDao")
	private IResultViewDao resultViewDao;

	
	@Override
	public List<ResultView> findAllResultView(){
		return resultViewDao.findAll();
	}
	
	@Override
	public ResultView get(int id){
		return resultViewDao.get(id);
	}

	
	@Override
	public Pagination<ResultView> findResultViewForPage(Map<String, ?> values,Pagination<ResultView> pagination){
		
		String hql = "from ResultView";
		List<ResultView> data = resultViewDao.findForPage(hql, values, pagination.getStartIndex(), pagination.getPageSize());
		hql = "select count(*) from ResultView";
		int totalRows = resultViewDao.findCountForPage(hql, values);
		pagination.setTotalRows(totalRows);
		pagination.setData(data);
		return pagination;
	}
	//public RuleAdviceInfo findbyDeviceTypeId(String id){
		
	//}

}


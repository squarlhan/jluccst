/*
 * @(#)RuleResultInfoServiceImpl.java 1.1 2012-4-23
 */

package com.boan.rees.expertsystem.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.boan.rees.expertsystem.dao.IReasonViewDao;
import com.boan.rees.expertsystem.model.ReasonView;
import com.boan.rees.expertsystem.service.IReasonViewService;
import com.boan.rees.utils.page.Pagination;

/**
 * 原因Service视图接口实现 类
 * @author jiangmeidi
 * @version 1.0.0
 */
@Service("reasonViewService")
public class ReasonViewServiceImpl implements IReasonViewService{
	@Autowired
	@Qualifier("reasonViewDao")
	private IReasonViewDao reasonViewDao;

	
	@Override
	public List<ReasonView> findAllReasonView(){
		return reasonViewDao.findAll();
	}
	
	@Override
	public ReasonView get(int id){
		return reasonViewDao.get(id);
	}

	
	@Override
	public Pagination<ReasonView> findReasonViewForPage(Map<String, ?> values,Pagination<ReasonView> pagination){
		
		String hql = "from ReasonView";
		List<ReasonView> data = reasonViewDao.findForPage(hql, values, pagination.getStartIndex(), pagination.getPageSize());
		hql = "select count(*) from ReasonView";
		int totalRows = reasonViewDao.findCountForPage(hql, values);
		pagination.setTotalRows(totalRows);
		pagination.setData(data);
		return pagination;
	}
	//public RuleAdviceInfo findbyDeviceTypeId(String id){
		
	//}

}


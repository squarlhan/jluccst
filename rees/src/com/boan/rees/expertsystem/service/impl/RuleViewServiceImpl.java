/*
 * @(#)RuleResultInfoServiceImpl.java 1.1 2012-4-23
 */

package com.boan.rees.expertsystem.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.boan.rees.expertsystem.dao.IRuleViewDao;
import com.boan.rees.expertsystem.model.RuleView;
import com.boan.rees.expertsystem.service.IRuleViewService;
import com.boan.rees.utils.page.Pagination;

/**
 * 规则Service视图接口实现 类
 * @author jiangmeidi
 * @version 1.0.0
 */
@Service("ruleViewService")
public class RuleViewServiceImpl implements IRuleViewService{
	@Autowired
	@Qualifier("ruleViewDao")
	private IRuleViewDao ruleViewDao;

	
	@Override
	public List<RuleView> findAllRuleView(){
		return ruleViewDao.findAll();
	}
	
	@Override
	public RuleView get(int id){
		return ruleViewDao.get(id);
	}

	
	@Override
	public Pagination<RuleView> findRuleViewForPage(Map<String, ?> values,Pagination<RuleView> pagination){
		
		String hql = "from RuleView";
		List<RuleView> data = ruleViewDao.findForPage(hql, values, pagination.getStartIndex(), pagination.getPageSize());
		hql = "select count(*) from RuleView";
		int totalRows = ruleViewDao.findCountForPage(hql, values);
		pagination.setTotalRows(totalRows);
		pagination.setData(data);
		return pagination;
	}
	//public RuleRuleInfo findbyDeviceTypeId(String id){
		
	//}

}


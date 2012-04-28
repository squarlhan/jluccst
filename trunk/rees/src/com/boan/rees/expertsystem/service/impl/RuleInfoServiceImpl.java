/*
 * @(#)RuleResultInfoServiceImpl.java 1.1 2012-4-23
 */

package com.boan.rees.expertsystem.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.boan.rees.expertsystem.dao.IRuleInfoDao;
import com.boan.rees.expertsystem.model.RuleInfo;
import com.boan.rees.expertsystem.service.IRuleInfoService;
import com.boan.rees.utils.page.Pagination;

/**
 * 规则Service接口实现 类
 * @author jiangmeidi
 * @version 1.0.0
 */
@Service("ruleInfoService")
public class RuleInfoServiceImpl implements IRuleInfoService{
	@Autowired
	@Qualifier("ruleInfoDao")
	private IRuleInfoDao ruleInfoDao;

	
	public IRuleInfoDao getRuleInfoDao() {
		return ruleInfoDao;
	}

	public void setRuleInfoDao(IRuleInfoDao ruleInfoDao) {
		this.ruleInfoDao = ruleInfoDao;
	}

	@Override
	public List<RuleInfo> findAllRuleInfo(){
		return ruleInfoDao.findAll();
	}
	
	@Override
	public RuleInfo get(int id){
		return ruleInfoDao.get(id);
	}

	@Override
	public void deleteRuleInfo(Integer... ids ){
		ruleInfoDao.delete(ids);
	}
	@Override
	public void save(RuleInfo table1){
		ruleInfoDao.save(table1);
	}
	@Override
	public void update(RuleInfo ruleInfo){
		ruleInfoDao.update(ruleInfo);
	}
	@Override
	public Pagination<RuleInfo> findRuleInfoForPage(Map<String, ?> values,Pagination<RuleInfo> pagination){
		
		String hql = "from RuleInfo";
		List<RuleInfo> data = ruleInfoDao.findForPage(hql, values, pagination.getStartIndex(), pagination.getPageSize());
		hql = "select count(*) from RuleInfo";
		int totalRows = ruleInfoDao.findCountForPage(hql, values);
		pagination.setTotalRows(totalRows);
		pagination.setData(data);
		return pagination;
	}
	//public RuleInfo findbyDeviceTypeId(String id){
		
	//}

}


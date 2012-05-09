/*
 * @(#)RuleResultInfoServiceImpl.java 1.1 2012-4-23
 */

package com.boan.rees.expertsystem.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.boan.rees.expertsystem.dao.IRuleReasonInfoDao;
import com.boan.rees.expertsystem.model.RuleReasonInfo;
import com.boan.rees.expertsystem.service.IRuleReasonInfoService;
import com.boan.rees.utils.page.Pagination;

/**
 * 原因Service接口实现 类
 * @author jiangmeidi
 * @version 1.0.0
 */
@Service("ruleReasonInfoService")
public class RuleReasonInfoServiceImpl implements IRuleReasonInfoService{
	@Autowired
	@Qualifier("ruleReasonInfoDao")
	private IRuleReasonInfoDao ruleReasonInfoDao;

	
	public IRuleReasonInfoDao getRuleReasonInfoDao() {
		return ruleReasonInfoDao;
	}

	public void setRuleReasonInfoDao(IRuleReasonInfoDao ruleReasonInfoDao) {
		this.ruleReasonInfoDao = ruleReasonInfoDao;
	}

	@Override
	public List<RuleReasonInfo> findAllRuleReasonInfo(){
		return ruleReasonInfoDao.findAll();
	}
	
	@Override
	public RuleReasonInfo get(int id){
		return ruleReasonInfoDao.get(id);
	}

	@Override
	public void deleteRuleReasonInfo(Integer... ids ){
		ruleReasonInfoDao.delete(ids);
	}
	@Override
	public void save(RuleReasonInfo table1){
		ruleReasonInfoDao.save(table1);
	}
	@Override
	public void update(RuleReasonInfo ruleReasonInfo){
		ruleReasonInfoDao.update(ruleReasonInfo);
	}
	@Override
	public Pagination<RuleReasonInfo> findRuleReasonInfoForPage(Map<String, ?> values,Pagination<RuleReasonInfo> pagination){
		
		String hql = "from RuleReasonInfo";
		List<RuleReasonInfo> data = ruleReasonInfoDao.findForPage(hql, values, pagination.getStartIndex(), pagination.getPageSize());
		hql = "select count(*) from RuleReasonInfo";
		int totalRows = ruleReasonInfoDao.findCountForPage(hql, values);
		pagination.setTotalRows(totalRows);
		pagination.setData(data);
		return pagination;
	}
	//public RuleReasonInfo findbyDeviceTypeId(String id){
	@Override
	public RuleReasonInfo getbyId(int id){
		return ruleReasonInfoDao.getbyid(id);
	}
	

}


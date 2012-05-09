/*
 * @(#)RuleResultInfoServiceImpl.java 1.1 2012-4-23
 */

package com.boan.rees.expertsystem.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.boan.rees.demo.model.DemoModel;
import com.boan.rees.device.model.PointDataInfo;
import com.boan.rees.expertsystem.dao.IRuleAdviceInfoDao;
import com.boan.rees.expertsystem.model.RuleAdviceInfo;
import com.boan.rees.expertsystem.model.RuleReasonInfo;
import com.boan.rees.expertsystem.service.IRuleAdviceInfoService;
import com.boan.rees.report.model.PersonReport;
import com.boan.rees.utils.page.Pagination;

/**
 * 建议Service接口实现 类
 * @author jiangmeidi
 * @version 1.0.0
 */
@Service("ruleAdviceInfoService")
public class RuleAdviceInfoServiceImpl implements IRuleAdviceInfoService{
	@Autowired
	@Qualifier("ruleAdviceInfoDao")
	private IRuleAdviceInfoDao ruleAdviceInfoDao;

	
	public IRuleAdviceInfoDao getRuleAdviceInfoDao() {
		return ruleAdviceInfoDao;
	}

	public void setRuleAdviceInfoDao(IRuleAdviceInfoDao ruleAdviceInfoDao) {
		this.ruleAdviceInfoDao = ruleAdviceInfoDao;
	}

	@Override
	public List<RuleAdviceInfo> findAllRuleAdviceInfo(){
		return ruleAdviceInfoDao.findAll();
	}
	
	@Override
	public RuleAdviceInfo get(int id){
		return ruleAdviceInfoDao.get(id);
	}

	@Override
	public void deleteRuleAdviceInfo(Integer... ids ){
		ruleAdviceInfoDao.delete(ids);
	}
	@Override
	public void save(RuleAdviceInfo table1){
		ruleAdviceInfoDao.save(table1);
	}
	@Override
	public void update(RuleAdviceInfo ruleAdviceInfo){
		ruleAdviceInfoDao.update(ruleAdviceInfo);
	}
	@Override
	public Pagination<RuleAdviceInfo> findRuleAdviceInfoForPage(Map<String, ?> values,Pagination<RuleAdviceInfo> pagination){
		
		String hql = "from RuleAdviceInfo";
		List<RuleAdviceInfo> data = ruleAdviceInfoDao.findForPage(hql, values, pagination.getStartIndex(), pagination.getPageSize());
		hql = "select count(*) from RuleAdviceInfo";
		int totalRows = ruleAdviceInfoDao.findCountForPage(hql, values);
		pagination.setTotalRows(totalRows);
		pagination.setData(data);
		return pagination;
	}
	//public RuleAdviceInfo findbyDeviceTypeId(String id){
		
	//}
	@Override
	public RuleAdviceInfo getbyId(int id){
		return ruleAdviceInfoDao.getbyid(id);
	}
}


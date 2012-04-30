/*
 * @(#)RuleResultInfoServiceImpl.java 1.1 2012-4-23
 */

package com.boan.rees.expertsystem.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.boan.rees.expertsystem.dao.IRuleResultInfoDao;
import com.boan.rees.expertsystem.model.RuleResultInfo;
import com.boan.rees.expertsystem.service.IRuleResultInfoService;
import com.boan.rees.utils.page.Pagination;

/**
 * 现象Service接口实现 类
 * @author jiangmeidi
 * @version 1.0.0
 */
@Service("ruleResultInfoService")
public class RuleResultInfoServiceImpl implements IRuleResultInfoService{
	@Autowired
	@Qualifier("ruleResultInfoDao")
	private IRuleResultInfoDao ruleResultInfoDao;

	
	@Override
	public List<RuleResultInfo> findAllRuleResultInfo(){
		return ruleResultInfoDao.findAll();
	}
	
	@Override
	public RuleResultInfo get(int id){
		return ruleResultInfoDao.get(id);
	}

	@Override
	public void deleteRuleResultInfo(Integer... ids ){
		ruleResultInfoDao.delete(ids);
	}
	@Override
	public void save(RuleResultInfo table1){
		ruleResultInfoDao.save(table1);
	}
	@Override
	public void update(RuleResultInfo ruleResultInfo){
		ruleResultInfoDao.update(ruleResultInfo);
	}
	@Override
	public Pagination<RuleResultInfo> findRuleResultInfoForPage(Map<String, ?> values,Pagination<RuleResultInfo> pagination){
		
		String hql = "from RuleResultInfo";
		List<RuleResultInfo> data = ruleResultInfoDao.findForPage(hql, values, pagination.getStartIndex(), pagination.getPageSize());
		hql = "select count(*) from RuleResultInfo";
		int totalRows = ruleResultInfoDao.findCountForPage(hql, values);
		pagination.setTotalRows(totalRows);
		pagination.setData(data);
		return pagination;
	}
	//public RuleResultInfo findbyDeviceTypeId(String id){
		
	//}
	
	/**
	 * 根据设备类型Id查询所包含的故障信息
	 */
	public List<RuleResultInfo> findRuleResultInfoByDeviceTypeId(String deviceTypeId){
		String hql = "from RuleResultInfo where deviceTypeId=:deviceTypeId";
		Map<String,String> params = new HashMap<String,String>();
		params.put("deviceTypeId", deviceTypeId);
		List<RuleResultInfo> list = ruleResultInfoDao.find( hql , params);
		return list;
	}

}


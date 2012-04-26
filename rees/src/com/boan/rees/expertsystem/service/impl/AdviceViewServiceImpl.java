/*
 * @(#)RuleResultInfoServiceImpl.java 1.1 2012-4-23
 */

package com.boan.rees.expertsystem.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.boan.rees.expertsystem.dao.IAdviceViewDao;
import com.boan.rees.expertsystem.model.AdviceView;
import com.boan.rees.expertsystem.service.IAdviceViewService;
import com.boan.rees.utils.page.Pagination;

/**
 * 建议Service视图接口实现 类
 * @author jiangmeidi
 * @version 1.0.0
 */
@Service("adviceViewService")
public class AdviceViewServiceImpl implements IAdviceViewService{
	@Autowired
	@Qualifier("adviceViewDao")
	private IAdviceViewDao adviceViewDao;

	
	@Override
	public List<AdviceView> findAllAdviceView(){
		return adviceViewDao.findAll();
	}
	
	@Override
	public AdviceView get(int id){
		return adviceViewDao.get(id);
	}

	
	@Override
	public Pagination<AdviceView> findAdviceViewForPage(Map<String, ?> values,Pagination<AdviceView> pagination){
		
		String hql = "from AdviceView";
		List<AdviceView> data = adviceViewDao.findForPage(hql, values, pagination.getStartIndex(), pagination.getPageSize());
		hql = "select count(*) from AdviceView";
		int totalRows = adviceViewDao.findCountForPage(hql, values);
		pagination.setTotalRows(totalRows);
		pagination.setData(data);
		return pagination;
	}
	//public RuleAdviceInfo findbyDeviceTypeId(String id){
		
	//}

}


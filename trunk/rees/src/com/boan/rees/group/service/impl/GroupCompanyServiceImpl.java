/*
 * @(#)GroupCompanyServiceImpl.java 1.1 2012-3-9
 */

package com.boan.rees.group.service.impl;

import com.boan.rees.group.dao.IGroupCompanyDao;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.boan.rees.group.dao.IGroupFactoryDao;
import com.boan.rees.group.model.GroupCompany;
import com.boan.rees.group.service.IGroupCompanyService;

/**
 * 公司服务类接口实现
 * @author Guiyun Yang
 * @version 1.0.0
 */

@Service("groupCompanyService")
public class GroupCompanyServiceImpl implements IGroupCompanyService{

	
	@Autowired
	@Qualifier("IGroupCompanyDao")
	private IGroupCompanyDao groupcompanydao;
	@Override
	public List<GroupCompany> findAllGroupCompany() {
		// TODO Auto-generated method stub
		return groupcompanydao.findAll();
	}

	@Override
	public GroupCompany get(String id) {
		// TODO Auto-generated method stub
		return groupcompanydao.get(id);
	}

	@Override
	public void deleteGroupCompany(String... ids) {
		// TODO Auto-generated method stub
		groupcompanydao.delete(ids);
	}

	@Override
	public void save(GroupCompany table1) {
		// TODO Auto-generated method stub
		groupcompanydao.save(table1);
	}

}


/*
 * @(#)GroupCompanyServiceImpl.java 1.1 2012-3-9
 */

package com.boan.rees.group.service.impl;

import com.boan.rees.group.dao.ICompanyDao;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.boan.rees.group.dao.IFactoryDao;
import com.boan.rees.group.model.Company;
import com.boan.rees.group.service.ICompanyService;

/**
 * 公司服务类接口实现
 * @author Guiyun Yang
 * @version 1.0.0
 */

@Service("groupCompanyService")
public class CompanyServiceImpl implements ICompanyService{

	
	@Autowired
	@Qualifier("groupCompanyDao")
	private ICompanyDao groupCompanyDao;
	@Override
	public List<Company> findAllGroupCompany() {
		// TODO Auto-generated method stub
		return groupCompanyDao.findAll();
	}

	@Override
	public Company get(String id) {
		// TODO Auto-generated method stub
		return groupCompanyDao.get(id);
	}

	@Override
	public void deleteGroupCompany(String... ids) {
		// TODO Auto-generated method stub
		groupCompanyDao.delete(ids);
	}

	@Override
	public void save(Company table1) {
		// TODO Auto-generated method stub
		groupCompanyDao.save(table1);
	}

}


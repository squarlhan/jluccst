/*
 * @(#)IGroupFactoryServiceImpl.java 1.1 2012-3-9
 */

package com.boan.rees.group.service.impl;

import com.boan.rees.group.dao.IFactoryDao;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.boan.rees.group.model.Factory;
import com.boan.rees.group.service.IFactoryService;
/**
 * 工厂服务类接口实现
 * @author Guiyun Yang
 * @version 1.0.0
 */

@Service("groupFactoryService")
public class FactoryServiceImpl implements IFactoryService{

	@Autowired
	@Qualifier("IGroupFactoryDao")
	private IFactoryDao groupfactorydao;
	@Override
	public List<Factory> findAllGroupFactory() {
		// TODO Auto-generated method stub
		return groupfactorydao.findAll();
	}

	@Override
	public Factory get(String id) {
		// TODO Auto-generated method stub
		return groupfactorydao.get(id);
	}

	@Override
	public void deleteGroupFactory(String... ids) {
		// TODO Auto-generated method stub
		
		groupfactorydao.delete(ids);
		
	}

	@Override
	public void save(Factory table1) {
		// TODO Auto-generated method stub
		
		groupfactorydao.save(table1);
		
	}

}


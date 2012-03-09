/*
 * @(#)IGroupFactoryServiceImpl.java 1.1 2012-3-9
 */

package com.boan.rees.group.service.impl;

import com.boan.rees.group.dao.IGroupFactoryDao;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.boan.rees.group.model.GroupFactory;
import com.boan.rees.group.service.IGroupFactoryService;
/**
 * 工厂服务类接口实现
 * @author Guiyun Yang
 * @version 1.0.0
 */

@Service("groupFactoryService")
public class GroupFactoryServiceImpl implements IGroupFactoryService{

	@Autowired
	@Qualifier("IGroupFactoryDao")
	private IGroupFactoryDao groupfactorydao;
	@Override
	public List<GroupFactory> findAllGroupFactory() {
		// TODO Auto-generated method stub
		return groupfactorydao.findAll();
	}

	@Override
	public GroupFactory get(String id) {
		// TODO Auto-generated method stub
		return groupfactorydao.get(id);
	}

	@Override
	public void deleteGroupFactory(String... ids) {
		// TODO Auto-generated method stub
		
		groupfactorydao.delete(ids);
		
	}

	@Override
	public void save(GroupFactory table1) {
		// TODO Auto-generated method stub
		
		groupfactorydao.save(table1);
		
	}

}


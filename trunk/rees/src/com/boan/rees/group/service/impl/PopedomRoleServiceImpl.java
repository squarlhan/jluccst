/*
 * @(#)GroupPopedomRoleServiceImpl.java 1.1 2012-3-9
 */

package com.boan.rees.group.service.impl;

import com.boan.rees.group.dao.IPopedomRoleDao;
import com.boan.rees.group.dao.IRoleDao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.boan.rees.group.model.PopedomRole;
import com.boan.rees.group.service.IPopedomRoleService;
/**
 * 权限服务类接口实现
 * @author Guiyun Yang
 * @version 1.0.0
 */

@Service("groupPopedomRoleService")
public class PopedomRoleServiceImpl implements IPopedomRoleService{

	@Autowired
	@Qualifier("groupPopedomRoleService")
	private IPopedomRoleDao groupPoperoleDao;
	@Override
	public List<PopedomRole> findAllGroupPopedomRole() {
		// TODO Auto-generated method stub
		return groupPoperoleDao.findAll();
	}

	@Override
	public PopedomRole get(String id) {
		// TODO Auto-generated method stub
		return groupPoperoleDao.get(id);
	}

	@Override
	public void deleteGroupPopedomRole(String... ids) {
		// TODO Auto-generated method stub
		groupPoperoleDao.delete(ids);
	}

	@Override
	public void save(PopedomRole table1) {
		// TODO Auto-generated method stub
		groupPoperoleDao.save(table1);
	}

}


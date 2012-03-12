/*
 * @(#)GroupRoleServiceImpl.java 1.1 2012-3-9
 */

package com.boan.rees.group.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.boan.rees.group.model.Role;
import com.boan.rees.group.service.IRoleService;
import com.boan.rees.group.dao.IRoleDao;
/**
 * 角色服务类接口实现
 * @author Guiyun Yang
 * @version 1.0.0
 */

@Service("groupRoleService")
public class RoleServiceImpl implements IRoleService{

	@Autowired
	@Qualifier("groupRoleService")
	private IRoleDao groupRoleDao;
	@Override
	public List<Role> findAllGroupRole() {
		// TODO Auto-generated method stub
		return groupRoleDao.findAll();
	}

	@Override
	public Role get(String id) {
		// TODO Auto-generated method stub
		return groupRoleDao.get(id);
	}

	@Override
	public void deleteGroupCompany(String... ids) {
		groupRoleDao.delete(ids);
		
	}

	@Override
	public void save(Role table1) {
		// TODO Auto-generated method stub
		
		groupRoleDao.save(table1);
		
	}

}


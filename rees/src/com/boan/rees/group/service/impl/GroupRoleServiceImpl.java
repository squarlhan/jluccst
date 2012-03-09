/*
 * @(#)GroupRoleServiceImpl.java 1.1 2012-3-9
 */

package com.boan.rees.group.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.boan.rees.group.model.GroupRole;
import com.boan.rees.group.service.IGroupRoleService;
import com.boan.rees.group.dao.IGroupRoleDao;
/**
 * 角色服务类接口实现
 * @author Guiyun Yang
 * @version 1.0.0
 */

@Service("groupRoleService")
public class GroupRoleServiceImpl implements IGroupRoleService{

	@Autowired
	@Qualifier("IGroupRoleDao")
	private IGroupRoleDao grouproledao;
	@Override
	public List<GroupRole> findAllGroupRole() {
		// TODO Auto-generated method stub
		return grouproledao.findAll();
	}

	@Override
	public GroupRole get(String id) {
		// TODO Auto-generated method stub
		return grouproledao.get(id);
	}

	@Override
	public void deleteGroupCompany(String... ids) {
		grouproledao.delete(ids);
		
	}

	@Override
	public void save(GroupRole table1) {
		// TODO Auto-generated method stub
		
		grouproledao.save(table1);
		
	}

}


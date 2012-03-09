/*
 * @(#)GroupPopedomRoleServiceImpl.java 1.1 2012-3-9
 */

package com.boan.rees.group.service.impl;

import com.boan.rees.group.dao.IGroupPopedomRoleDao;
import com.boan.rees.group.dao.IGroupRoleDao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.boan.rees.group.model.GroupPopedomRole;
import com.boan.rees.group.service.IGroupPopedomRoleService;
/**
 * 权限服务类接口实现
 * @author Guiyun Yang
 * @version 1.0.0
 */

@Service("groupPopedomRoleService")
public class GroupPopedomRoleServiceImpl implements IGroupPopedomRoleService{

	@Autowired
	@Qualifier("IGroupPopedomRoleDao")
	private IGroupPopedomRoleDao grouppoperoledao;
	@Override
	public List<GroupPopedomRole> findAllGroupPopedomRole() {
		// TODO Auto-generated method stub
		return grouppoperoledao.findAll();
	}

	@Override
	public GroupPopedomRole get(String id) {
		// TODO Auto-generated method stub
		return grouppoperoledao.get(id);
	}

	@Override
	public void deleteGroupPopedomRole(String... ids) {
		// TODO Auto-generated method stub
		grouppoperoledao.delete(ids);
	}

	@Override
	public void save(GroupPopedomRole table1) {
		// TODO Auto-generated method stub
		grouppoperoledao.save(table1);
	}

}


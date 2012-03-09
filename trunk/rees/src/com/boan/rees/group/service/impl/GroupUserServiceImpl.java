/*
 * @(#)GroupUserServiceImpl.java 1.1 2012-3-9
 */

package com.boan.rees.group.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.boan.rees.group.model.GroupUser;
import com.boan.rees.group.service.IGroupUserService;
import com.boan.rees.group.dao.IGroupUserDao;

/**
 * 用户服务类接口实现
 * @author Guiyun Yang
 * @version 1.0.0
 */

@Service("groupUserService")
public class GroupUserServiceImpl implements IGroupUserService {
	
	
	@Autowired
	@Qualifier("GroupUserDao")
	private IGroupUserDao groupuser;

	@Override
	public List<GroupUser> findAllGroupUser() {
		// TODO Auto-generated method stub
		return groupuser.findAll();
	}

	@Override
	public GroupUser get(String id) {
		// TODO Auto-generated method stub
		return groupuser.get(id);
	}

	@Override
	public void deleteGroupUser(String... ids) {
		// TODO Auto-generated method stub
		groupuser.delete(ids);

	}

	@Override
	public void save(GroupUser table1) {
		// TODO Auto-generated method stub
		groupuser.save(table1);

	}

}


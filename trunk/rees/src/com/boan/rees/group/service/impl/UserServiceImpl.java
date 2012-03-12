/*
 * @(#)GroupUserServiceImpl.java 1.1 2012-3-9
 */

package com.boan.rees.group.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.boan.rees.group.model.User;
import com.boan.rees.group.service.IUserService;
import com.boan.rees.group.dao.IUserDao;

/**
 * 用户服务类接口实现
 * @author Guiyun Yang
 * @version 1.0.0
 */

@Service("groupUserService")
public class UserServiceImpl implements IUserService {
	
	
	@Autowired
	@Qualifier("groupUserService")
	private IUserDao groupUser;

	@Override
	public List<User> findAllGroupUser() {
		// TODO Auto-generated method stub
		return groupUser.findAll();
	}

	@Override
	public User get(String id) {
		// TODO Auto-generated method stub
		return groupUser.get(id);
	}

	@Override
	public void deleteGroupUser(String... ids) {
		// TODO Auto-generated method stub
		groupUser.delete(ids);

	}

	@Override
	public void save(User table1) {
		// TODO Auto-generated method stub
		groupUser.save(table1);

	}

}


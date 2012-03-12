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
	@Qualifier("groupUserDao")
	private IUserDao groupUserDao;

	@Override
	public List<User> findAllGroupUser() {
		// TODO Auto-generated method stub
		return groupUserDao.findAll();
	}

	@Override
	public User get(String id) {
		// TODO Auto-generated method stub
		return groupUserDao.get(id);
	}

	@Override
	public void deleteGroupUser(String... ids) {
		// TODO Auto-generated method stub
		groupUserDao.delete(ids);

	}

	@Override
	public void save(User table1) {
		// TODO Auto-generated method stub
		groupUserDao.save(table1);

	}

}


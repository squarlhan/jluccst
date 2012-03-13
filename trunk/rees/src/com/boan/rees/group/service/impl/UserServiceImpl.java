/*
 * @(#)GroupUserServiceImpl.java 1.1 2012-3-9
 */

package com.boan.rees.group.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.boan.rees.demo.model.DemoModel;
import com.boan.rees.group.model.User;
import com.boan.rees.group.service.IUserService;
import com.boan.rees.group.dao.IUserDao;
import com.boan.rees.utils.page.Pagination;

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
	
		return groupUserDao.findAll();
	}

	@Override
	public User get(String id) {
		
		return groupUserDao.get(id);
	}

	@Override
	public void deleteGroupUser(String... ids) {
		
		groupUserDao.delete(ids);

	}

	@Override
	public void save(User table1) {
		
		groupUserDao.save(table1);

	}
	@Override
	public Pagination<User> findUserForPage(Map<String, ?> values,Pagination<User> pagination){
		
		String hql = "from DemoModel";
		List<User> data = groupUserDao.findForPage(hql, values, pagination.getStartIndex(), pagination.getPageSize());
		hql = "select count(*) from User";
		int totalRows = groupUserDao.findCountForPage(hql, values);
		pagination.setTotalRows(totalRows);
		pagination.setData(data);
		return pagination;
	}
}


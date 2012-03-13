/*
 * @(#)IGroupUserService.java 1.1 2012-3-8
 */

package com.boan.rees.group.service;

import java.util.List;
import java.util.Map;

import com.boan.rees.group.model.User;
import com.boan.rees.utils.page.Pagination;

/**
 * 用户服务类接口
 * @author Guiyun Yang
 * @version 1.0.0
 */
public interface IUserService {
	
public List<User> findAllGroupUser();
	
	public User get(String id);
	
	public void deleteGroupUser(String... ids );
	
	public void save(User table1);
	public Pagination<User> findUserForPage(Map<String, ?> values,Pagination<User> pagination);
}


/*
 * @(#)IGroupUserService.java 1.1 2012-3-8
 */

package com.boan.rees.group.service;

import java.util.List;

import com.boan.rees.group.model.GroupUser;

/**
 * 用户服务类接口
 * @author Guiyun Yang
 * @version 1.0.0
 */
public interface IGroupUserService {
	
public List<GroupUser> findAllGroupUser();
	
	public GroupUser get(String id);
	
	public void deleteGroupUser(String... ids );
	
	public void save(GroupUser table1);

}


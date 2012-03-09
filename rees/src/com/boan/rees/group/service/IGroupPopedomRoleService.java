/*
 * @(#)IGroupPopedomRoleService.java 1.1 2012-3-8
 */

package com.boan.rees.group.service;

import java.util.List;

import com.boan.rees.group.model.GroupPopedomRole;

/**
 * 权限服务类接口
 * @author Guiyun Yang
 * @version 1.0.0
 */
public interface IGroupPopedomRoleService {
	
public List<GroupPopedomRole> findAllGroupPopedomRole();
	
	public GroupPopedomRole get(String id);
	
	public void deleteGroupPopedomRole(String... ids );
	
	public void save(GroupPopedomRole table1);

}


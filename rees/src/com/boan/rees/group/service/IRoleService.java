/*
 * @(#)IGroupRoleService.java 1.1 2012-3-8
 */

package com.boan.rees.group.service;

import java.util.List;

import com.boan.rees.group.model.Role;

/**
 * 角色服务类接口
 * @author Guiyun Yang
 * @version 1.0.0
 */
public interface IRoleService {
	
public List<Role> findAllGroupRole();
	
	public Role get(String id);
	
	public void deleteGroupCompany(String... ids );
	
	public void save(Role table1);

}


/*
 * @(#)IGroupRoleService.java 1.1 2012-3-8
 */

package com.boan.rees.group.service;

import java.util.List;
import java.util.Map;

import com.boan.rees.group.model.Role;
import com.boan.rees.utils.page.Pagination;

/**
 * 角色服务类接口
 * @author Guiyun Yang
 * @version 1.0.0
 */
public interface IRoleService {
	
	/**
	 * 查找所有角色对象
	 */
	public List<Role> findAllGroupRole();
	
	/**
	 * 获取角色
	 */
	public Role get(String id);
	
	/**
	 * 删除角色
	 */
	public void deleteGroupCompany(String... ids );
	
	/**
	 * 保存角色
	 */
	public void save(Role table1);
	
	/**
	 * 按分页查找角色
	 */
	public Pagination<Role> findRoleForPage(Map<String, ?> values,Pagination<Role> pagination);

}


/*
 * @(#)IGroupRoleService.java 1.1 2012-3-8
 */

package com.boan.crm.groupmanage.service;

import java.util.List;
import java.util.Map;

import com.boan.crm.groupmanage.model.Role;
import com.boan.crm.utils.page.Pagination;

/**
 * 角色服务类接口
 * 
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
	public void deleteGroupRole(String... ids);

	/**
	 * 保存角色
	 */
	public void save(Role table1);

	/**
	 * 按分页查找角色
	 */
	public Pagination<Role> findRoleForPage(Map<String, ?> values, Pagination<Role> pagination);

	/**
	 * 同名判断
	 * 
	 * @param id
	 * @param roleName
	 * @param companyId
	 * @return
	 */
	public boolean isExistSameName(String id, String roleName, String companyId);

	/**
	 * 修改
	 * 
	 * @param role
	 */
	public void update(Role role);

	/**
	 * 取得所有角色列表
	 * 
	 * @return 角色列表
	 * @throws Exception
	 */
	public List<Role> queryAllRoleList(String companyId ) throws Exception;
}

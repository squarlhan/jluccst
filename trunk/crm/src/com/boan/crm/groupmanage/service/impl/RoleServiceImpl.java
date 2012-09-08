/*
 * @(#)GroupRoleServiceImpl.java 1.1 2012-3-9
 */

package com.boan.crm.groupmanage.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.support.DaoSupport;
import org.springframework.stereotype.Service;

import com.boan.crm.groupmanage.dao.IRoleDao;
import com.boan.crm.groupmanage.model.Role;
import com.boan.crm.groupmanage.service.IRoleService;
import com.boan.crm.utils.page.Pagination;

/**
 * 角色服务类接口实现
 * @author Guiyun Yang
 * @version 1.0.0
 */

@Service("roleService")
public class RoleServiceImpl implements IRoleService{

	@Autowired
	@Qualifier("roleDao")
	private IRoleDao groupRoleDao;

	/**
	 * 查找所有角色对象
	 */
	@Override
	public List<Role> findAllGroupRole() {
		return groupRoleDao.findAll();
	}

	/**
	 * 获取角色
	 */
	@Override
	public Role get(String id) {
		return groupRoleDao.get(id);
	}

	/**
	 * 删除角色
	 */
	@Override
	public void deleteGroupRole(String... ids) {
		groupRoleDao.delete(ids);
		
	}

	/**
	 * 保存角色
	 */
	@Override
	public void save(Role table1) {
		groupRoleDao.save(table1);		
	}

	/**
	 * 按分页查找角色
	 */
	@Override
	public Pagination<Role> findRoleForPage(Map<String, ?> values,Pagination<Role> pagination) {
		
		String hql = "from Role";
		List<Role> data = groupRoleDao.findForPage(hql, values, pagination.getStartIndex(), pagination.getPageSize());
		hql = "select count(*) from Role ";
		int totalRows = groupRoleDao.findCountForPage(hql, values);
		pagination.setTotalRows(totalRows);
		pagination.setData(data);
		return pagination;
	}

	@Override
	public boolean isExistSameName(String id, String roleName) {
		return groupRoleDao.isExistSameName( id, roleName );
	}

	@Override
	public void update(Role role) {
		groupRoleDao.update(role);
		
	}

	@Override
	public List<Role> queryAllRoleList() throws Exception
	{
		return groupRoleDao.queryAllRoleList();
	}

	

}


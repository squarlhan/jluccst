/*
 * @(#)GoupRoleDaoImpl.java 1.1 2012-3-8
 */

package com.boan.crm.groupmanage.dao.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.boan.crm.groupmanage.dao.IRoleDao;
import com.boan.crm.groupmanage.model.Role;
import com.boan.crm.utils.dao.impl.BaseDao;

/**
 * 角色Dao接口实现
 * @author Guiyun Yang
 * @version 1.0.0
 */
@Repository("roleDao")
public class RoleDaoImpl extends BaseDao<Role,String> implements IRoleDao{

	@Override
	public boolean isExistSameName(String id, String roleName, String companyId) {
		id = StringUtils.trimToEmpty( id );
		roleName = StringUtils.trimToEmpty( roleName );
		boolean b = false;
		int rowCount = 0;
		String hql = null;
		Map<String, Object> map = new HashMap<String, Object>();
		map.put( "roleName", roleName );
		map.put( "companyId", companyId );
		if( StringUtils.isNotBlank( id ) )
		{
			hql = "select count(id) from Role where id <> :roleId and roleName= :roleName and companyId = :companyId";
			map.put( "roleId", id );
		}
		else
		{
			hql = "select count(id) from Role where roleName = :roleName and companyId = :companyId";
		}
		
		rowCount = super.findCountForPage( hql, map );			
		if( rowCount > 0 )
		{
			b = true;
		}
		return b;
	}
	public List<Role> queryAllRoleList(String companyId) throws Exception
	{
		String hql = "from Role where companyId = :companyId order by createTime";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put( "companyId", companyId );
		List<Role> list = super.find( hql ,map);
		return list;
	}}


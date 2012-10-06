/*
 * @(#)GroupPopedomRoleDaoImpl.java 1.1 2012-3-8
 */

package com.boan.crm.groupmanage.dao.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.boan.crm.groupmanage.dao.IPopedomDao;
import com.boan.crm.groupmanage.model.Popedom;
import com.boan.crm.groupmanage.model.Role;
import com.boan.crm.utils.dao.impl.BaseDao;

/**
 * 权限dao接口实现
 * 
 * @author Guiyun Yang
 * @version 1.0.0
 */

@Repository( "popedomDao" )
public class PopedomDaoImpl extends BaseDao<Popedom, String> implements IPopedomDao
{

	public void deletePopedomByIds( String keyword, String[] roleIds ) throws Exception
	{
		String hql = "delete Popedom where keyword = :keyword and roleId in ( :roleIds )";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put( "keyword", keyword );
		map.put( "roleIds", roleIds );
		super.executeHql( hql, map );
	}

	public List<Role> queryPopedomRoleList( String keyword, String companyId ) throws Exception
	{
		String hql = "select r from Role r,Popedom p where p.keyword = :keyword and r.id = p.roleId and r.companyId = :companyId";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put( "keyword", keyword );
		map.put( "companyId", companyId );
		List<Role> list = super.find( hql, map );
		return list;
	}

	public void saveOrUpdatePopedom( String keyword, String[] roleIds, String companyId ) throws Exception
	{
		if( roleIds != null && roleIds.length > 0 )
		{
			// （1）先删除权限
			String hql = "delete Popedom where keyword = :keyword and companyId = :companyId ";
			Map<String, Object> map = new HashMap<String, Object>();
			map.put( "keyword", keyword );
			map.put( "companyId", companyId );
			super.executeHql( hql, map );
			// （2）再保存权限
			Popedom popedom = null;
			for( String s : roleIds )
			{
				popedom = new Popedom();
				popedom.setKeyword( keyword );
				popedom.setRoleId( s );
				super.save( popedom );
			}
		}
	}

	/**
	 * 判断指定key和指定角色在数据库是否存在记录
	 * 
	 * @param keyword
	 *            权限关键字
	 * @param roleId
	 *            角色id
	 * @return 如果存在返回true，否则返回fasle
	 * @throws Exception
	 */
	private boolean isExistSamePopedom( String keyword, String roleId ) throws Exception
	{
		boolean b = false;
		String hql = "select count(id) from Popedom where keyword = :keyword and roleId = :roleId";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put( "keyword", keyword );
		map.put( "roleId", roleId );
		List<String> list = find( hql, map );
		int rowCount = Integer.parseInt( list.get( 0 ).toString() );
		if( rowCount > 0 )
		{
			b = true;
		}
		return b;
	}

	public void deletePopedomByRoleIds( String[] roleIds ) throws Exception
	{
		String hql = "delete Popedom where roleId in ( :roleIds )";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put( "roleIds", roleIds );
		super.executeHql( hql, map );
	}

	public String[] queryPopedomsByRoleId( String roleId ) throws Exception
	{
		String[] popedoms = null;
		String hql = null;
		if( StringUtils.isNotBlank( roleId ) )
		{
			hql = "from Popedom where roleId = :roleId";
		}
		else
		{
			hql = "from Popedom ";
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put( "roleId", roleId );
		List<Popedom> list = super.find( hql, map );
		if( list != null && list.size() > 0 )
		{
			popedoms = new String[list.size()];
			for( int i = 0; i < list.size(); i++ )
			{
				popedoms[i] = list.get( i ).getKeyword();
			}
		}
		return popedoms;
	}

}

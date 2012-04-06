/**
 * Copyright (c) 2010 Changchun Boan Co. Ltd.
 * All right reserved.
 * History
 */
/*
 * @(#)UserDaoImpl 1.1 June 7, 2010
 */

package com.boan.rees.group.dao.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.boan.rees.utils.dao.impl.BaseDao;
import com.boan.rees.group.model.User;
import com.boan.rees.group.dao.IUserDao;
/**
 * 用户dao接口实现
 * @author Guiyun Yang
 * @version 1.0.0
 */

@Repository("userDao")
public class UserDaoImpl extends BaseDao<User,String> implements IUserDao{

	public void deleteUserById( String id ) throws Exception
	{
		super.delete( id );
	}

	public User getUserById( String id ) throws Exception
	{
		return super.get( id );
	}
	public User queryUserByUsername( String username ) throws Exception
	{
		
		String hql = "from User where username = :username order by createTime";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put( "username", username );
		List<User> userList  = super.find( hql, map );
		User user = null; 
		if( userList != null && userList.size() > 0 )
		{
			user = userList.get( 0 );
		}
		return user;
	}
	public List<User> queryUserList(String companyId, String factoryId, String workshopId, int startIndex, int maxResults ) throws Exception
	{
		String hql = null;
		Map<String, Object> map = new HashMap<String, Object>();
		if( StringUtils.isNotBlank( companyId ) )
		{
			hql = "from User where companyId = :companyId order by createTime";
			map.put( "companyId", companyId );
		}
		else if( StringUtils.isNotBlank( factoryId ) )
		{
			hql = "from User where factoryId = :factoryId order by createTime";
			map.put( "factoryId", factoryId );

		}
		else if( StringUtils.isNotBlank( workshopId ) )
		{
			hql = "from User where workshopId = :workshopId order by createTime";
			map.put( "workshopId", workshopId );

		}
		return super.findForPage( hql, map, startIndex, maxResults );
	}

	public int queryUserListCount(String companyId, String factoryId, String workshopId) throws Exception
	{
		String hql = null;
		Map<String, Object> map = new HashMap<String, Object>();
		if( StringUtils.isNotBlank( companyId ) )
		{
			hql = "select count(id) from User where companyId = :companyId";
			map.put( "companyId", companyId );
		}
		else if( StringUtils.isNotBlank( factoryId ) )
		{
			hql = "select count(id) from User where factoryId = :factoryId";
			map.put( "factoryId", factoryId );

		}
		else if( StringUtils.isNotBlank( workshopId ) )
		{
			hql = "select count(id) from User where workshopId = :workshopId";
			map.put( "workshopId", workshopId );

		}
		return super.findCountForPage( hql, map );
	}

	public void saveOrUpdateUser( User user ) throws Exception
	{
		if( StringUtils.isNotBlank( user.getId() ) )
		{
			super.update( user );
		}
		else
		{
			super.save( user );
		}
	}

	public void saveOrUpdateUserPassword( String userId, String password ) throws Exception
	{
		String hql = "update User set password = :password where id = :userId";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put( "userId", userId );
		map.put( "password", password );
		super.executeHql( hql, map );
	}
	public boolean logonValid( String username, String userPassword ) throws Exception
	{
		boolean b = false;
		String hql = "from User where username = :username order by createTime";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put( "username", username );
		List<User> list = super.find( hql, map );
		if( list != null && list.size() > 0 )
		{
			if( list.size() == 1 )
			{
				User user = list.get( 0 );
				if( user != null )
				{
					if( user.getPassword().equals( userPassword ) )
					{
						b = true;
					}
				}
			}
		}
		return b;
	}

	public boolean isExistSameUsername( String userId, String username ) throws Exception
	{
		userId = StringUtils.trimToEmpty( userId );
		username = StringUtils.trimToEmpty( username );
		boolean b = false;
		int rowCount = 0;
		String hql = null;
		Map<String, Object> map = new HashMap<String, Object>();
		map.put( "username", username );
		if( StringUtils.isNotBlank( userId ) )
		{
			hql = "select count(id) from User where id <> :userId and username = :username";
			map.put( "userId", userId );
		}
		else
		{
			hql = "select count(id) from User where username = :username";
		}
		rowCount = super.findCountForPage( hql, map );			
		if( rowCount > 0 )
		{
			b = true;
		}
		return b;
	}

	public List<User> queryAllUserListByUnitId( String unitId ) throws Exception
	{
		String hql = "from User where unitId = :unitId order by createTime";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put( "unitId", unitId );
		return super.find( hql, map );
	}	
}


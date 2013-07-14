/**
 * Copyright (c) 2010 Changchun Boan Co. Ltd.
 * All right reserved.
 * History
 */
/*
 * @(#)UserDaoImpl 1.1 June 7, 2010
 */

package com.boan.crm.groupmanage.dao.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.boan.crm.groupmanage.dao.IUserDao;
import com.boan.crm.groupmanage.model.User;
import com.boan.crm.utils.dao.impl.BaseDao;

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
	public List<User> queryUserList(String companyId,String deptId , int startIndex, int maxResults ) throws Exception
	{
		String hql = null;
		Map<String, Object> map = new HashMap<String, Object>();
		//表示公司用户
		if( StringUtils.isNotBlank( deptId )  )
		{
			hql = "from User where companyId = :companyId and deptId = :deptId  order by createTime";
			map.put( "deptId", deptId );
		}
		else{
			hql = "from User where companyId = :companyId and deptId = '' order by createTime";
		}
		map.put( "companyId", companyId );
		return super.findForPage( hql, map, startIndex, maxResults );
	}

	public int queryUserListCount(String companyId, String deptId ) throws Exception
	{
		String hql = null;
		Map<String, Object> map = new HashMap<String, Object>();
		//表示公司用户
		if( StringUtils.isNotBlank( deptId )   )
		{
			hql = " select count(id) from User where  companyId = :companyId  and deptId = :deptId  ";
			map.put( "deptId", deptId );
		}
		else
		{
			hql = " select count(id) from User where  companyId = :companyId  and deptId =''  ";
		}
		map.put( "companyId", companyId );
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

	public List<User> queryAllUserListByCompanyId( String companyId ) throws Exception
	{
		String hql = "from User where companyId = :companyId order by createTime";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put( "companyId", companyId );
		return super.find( hql, map );
	}

	@Override
	public List<User> queryUserListByCompanyIdRoleKey(String companyId, String roleKey) throws Exception {
		String hql = "from User where companyId = :companyId and roleId in ( select id from Role where roleKey = :roleKey ) order by createTime";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put( "companyId", companyId );
		map.put( "roleKey", roleKey );
		return super.find( hql, map );
	}

	@Override
	public List<User> queryUserList(String companyId, String deptId) throws Exception {
		String hql = "from User where companyId = :companyId and deptId = :deptId order by createTime";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put( "companyId", companyId );
		map.put( "deptId", deptId );
		return super.find( hql, map );
	}

	@Override
	public List<User> queryUserListByCompanyIdRoleKey(String companyId, String deptId, String roleKey) throws Exception {
		String hql = "from User where companyId = :companyId and deptId = :deptId and roleId in ( select id from Role where roleKey = :roleKey ) order by createTime";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put( "companyId", companyId );
		map.put( "deptId", deptId );
		map.put( "roleKey", roleKey );
		return super.find( hql, map );
	}	
	
	/**
	 * 根据组织机构id和用户名称模糊查询客户信息
	 * @param companyId 公司id （为空表示只查询同部门的用户）
	 * @param deptId 部门id （为空表示只查询同公司的用户）
	 * @param userCName 用户名称
	 * @return 用户信息
	 * @throws Exception
	 */
	public List<User> queryUserListByUserName(String companyId, String deptId,String userCName ) throws Exception {
		String hql = "from User where 1=1 ";
		if(companyId!=null && !companyId.equals("")){
			hql = hql+" and companyId = :companyId ";
		}
		if(deptId!=null && !deptId.equals("")){
			hql = hql+" and deptId = :deptId ";
		}
		if(deptId!=null && !deptId.equals("")){
			hql = hql+" and userCName like :userCName ";
		}
		hql = hql+" order by createTime";
		
		Map<String, String> map = new HashMap<String, String>();
		map.put( "companyId", companyId );
		map.put( "deptId", deptId );
		map.put( "userCName", "%" + userCName + "%" );
		return super.find( hql, map );
	}

	@Override
	public List<User> queryUserListByDeptId(String deptId) throws Exception {
		String hql = "from User where  deptId = :deptId order by createTime";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put( "deptId", deptId );
		return super.find( hql, map );
	}
}


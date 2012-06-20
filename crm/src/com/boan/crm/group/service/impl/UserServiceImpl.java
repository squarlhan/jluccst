/*
 * @(#)GroupUserServiceImpl.java 1.1 2012-3-9
 */

package com.boan.crm.group.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.boan.crm.group.dao.IUserDao;
import com.boan.crm.group.model.User;
import com.boan.crm.group.service.IUserService;
import com.boan.crm.utils.page.Pagination;

/**
 * 用户服务类接口实现
 * @author Guiyun Yang
 * @version 1.0.0
 */

@Service("userService")
public class UserServiceImpl implements IUserService {
	
	
	@Autowired
	@Qualifier("userDao")
	private IUserDao userDao;

	@Override
	public void saveOrUpdateUser( User user ) throws Exception
	{
		userDao.saveOrUpdateUser( user );
	}

	@Override
	public void saveOrUpdateUserPassword( String userId, String password )
			throws Exception
	{
		userDao.saveOrUpdateUserPassword( userId, password );
	}

	@Override
	public User getUserById( String id ) throws Exception
	{
		return userDao.getUserById( id );
	}

	@Override
	public User queryUserByUsername( String username ) throws Exception
	{
		return userDao.queryUserByUsername( username );
	}

	@Override
	public void deleteUserById( String id ) throws Exception
	{
		userDao.deleteUserById( id );
	}

	@Override
	public Pagination<User> queryUserList( String companyId, String factoryId, String workshopId, Pagination<User> pagination ) throws Exception
	{
		List<User> list = userDao.queryUserList( companyId,factoryId, workshopId, pagination.getStartIndex(), pagination.getPageSize() );
		int totalRows = userDao.queryUserListCount(  companyId,factoryId, workshopId );
		pagination.setTotalRows(totalRows);
		pagination.setData(list);
		return pagination;
	}

	@Override
	public List<User> queryAllUserListByUnitId( String unitId )
			throws Exception
	{
		return userDao.queryAllUserListByUnitId( unitId );
	}

	@Override
	public int queryUserListCount( String companyId, String factoryId, String workshopId ) throws Exception
	{
		return userDao.queryUserListCount(  companyId,factoryId, workshopId );
	}

	@Override
	public boolean logonValid( String username, String userPassword )
			throws Exception
	{
		return userDao.logonValid( username, userPassword );
	}

	@Override
	public boolean isExistSameUsername( String userId, String username )
			throws Exception
	{
		return userDao.isExistSameUsername( userId, username );
	}
	
	/*
	@Override
	public Pagination<User> findUserForPage(Map<String, ?> values,Pagination<User> pagination){
		
		String hql = "from DemoModel";
		List<User> data = userDao.findForPage(hql, values, pagination.getStartIndex(), pagination.getPageSize());
		hql = "select count(*) from User";
		int totalRows = userDao.findCountForPage(hql, values);
		pagination.setTotalRows(totalRows);
		pagination.setData(data);
		return pagination;
	}
	*/
}


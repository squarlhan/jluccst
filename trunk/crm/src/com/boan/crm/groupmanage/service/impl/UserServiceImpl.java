/*
 * @(#)GroupUserServiceImpl.java 1.1 2012-3-9
 */

package com.boan.crm.groupmanage.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.boan.crm.groupmanage.dao.IUserDao;
import com.boan.crm.groupmanage.model.User;
import com.boan.crm.groupmanage.service.IUserService;
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
	public Pagination<User> queryUserList(String companyId, String deptId , Pagination<User> pagination ) throws Exception
	{
		List<User> list = userDao.queryUserList(companyId, deptId, pagination.getStartIndex(), pagination.getPageSize() );
		int totalRows = userDao.queryUserListCount( companyId, deptId );
		pagination.setTotalRows(totalRows);
		pagination.setData(list);
		return pagination;
	}

	@Override
	public List<User> queryAllUserListByCompanyId(String companyId)
			throws Exception
	{
		return userDao.queryAllUserListByCompanyId( companyId );
	}

	@Override
	public int queryUserListCount( String companyId, String deptId ) throws Exception
	{
		return userDao.queryUserListCount( companyId, deptId );
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

	@Override
	public List<User> queryUserListByCompanyIdRoleKey(String companyId, String roleKey) throws Exception {
		return userDao.queryUserListByCompanyIdRoleKey( companyId,  roleKey);
	}

	@Override
	public List<User> queryUserList(String companyId, String deptId) throws Exception {
		return userDao.queryUserList( companyId,  deptId);
	}

	@Override
	public List<User> queryUserListByCompanyIdRoleKey(String companyId, String deptId, String roleKey) throws Exception {
		return userDao.queryUserListByCompanyIdRoleKey( companyId,deptId,  roleKey);
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
	
	/**
	 * 根据组织机构id和用户名称模糊查询客户信息
	 * @param companyId 公司id （为空表示只查询同部门的用户）
	 * @param deptId 部门id （为空表示只查询同公司的用户）
	 * @param userName 用户名称
	 * @return 用户信息
	 * @throws Exception
	 */
	public List<User> queryUserListByUserName(String companyId, String deptId,String userName ) throws Exception {
		return userDao.queryUserListByUserName(companyId, deptId, userName);
	}
}


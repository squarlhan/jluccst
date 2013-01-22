/**
 * Copyright (c) 2010 Changchun Boan Co. Ltd.
 * All right reserved.
 * History
 */
/*
 * @(#)IUserDao.java 1.1 June 7, 2012
 */
package com.boan.crm.groupmanage.dao;

import java.util.List;

import com.boan.crm.groupmanage.model.User;
import com.boan.crm.utils.dao.IBaseDao;

/**
 * 用户Dao接口
 * 
 * @author Guiyun Yang
 * @version 1.0.0
 */

public interface IUserDao extends IBaseDao<User, String> {
	/**
	 * 保存用户信息
	 * 
	 * @param role
	 * @throws Exception
	 */
	public void saveOrUpdateUser(User user) throws Exception;

	/**
	 * 更新用户密码
	 * 
	 * @param userId
	 *            要更新密码的用户id
	 * @param password
	 *            加密后的新密码
	 * @throws Exception
	 */
	public void saveOrUpdateUserPassword(String userId, String password) throws Exception;

	/**
	 * 根据主键获取用户对象
	 * 
	 * @param id
	 *            主键
	 * @return 用户对象
	 * @throws Exception
	 */
	public User getUserById(String id) throws Exception;

	/**
	 * 根据用户名获取用户对象
	 * 
	 * @param username
	 *            用户名
	 * @return
	 * @throws Exception
	 */
	public User queryUserByUsername(String username) throws Exception;

	/**
	 * 根据ids删除用户信息
	 * 
	 * @param ids
	 * @throws Exception
	 */
	public void deleteUserById(String id) throws Exception;

	/**
	 * 获取用户列表
	 * 
	 * @param deptId
	 * @param startIndex
	 *            页标
	 * @param maxResults
	 *            每页最大记录数
	 * @return 用户列表
	 * @throws Exception
	 */
	public List<User> queryUserList(String companyId, String deptId, int startIndex, int maxResults) throws Exception;

	/**
	 * 根据集团id，取得集团下可以登录的用户，用于登录时显示
	 * 
	 * @param unitId
	 * @return
	 * @throws Exception
	 */
	public List<User> queryAllUserListByUnitId(String unitId) throws Exception;

	/**
	 * 获取用户列表数
	 * 
	 * @param
	 * @return 列表总数
	 * @throws Exception
	 */
	public int queryUserListCount(String companyId, String deptId) throws Exception;

	/**
	 * 判断用户及密码是否正确
	 * 
	 * @param username
	 *            用户名
	 * @param userPassword
	 *            密码
	 * @return boolean 成功返回true ,否则返回false
	 * @throws Exception
	 */
	public boolean logonValid(String username, String userPassword) throws Exception;

	/**
	 * 判断是否录入了相同的用户名
	 * 
	 * @param userId
	 *            用户id
	 * @param username
	 *            用户名
	 * @return 如果存在则返回true,否则返回false
	 * @throws Exception
	 */
	public boolean isExistSameUsername(String userId, String username) throws Exception;

	/**
	 * 根据公司id和rolekey取用户列表
	 * 
	 * @param companyId
	 * @param roleKey
	 * @return
	 * @throws Exception
	 */
	public List<User> queryUserListByCompanyIdRoleKey(String companyId, String roleKey) throws Exception;

	/**
	 * 取用户列表
	 * 
	 * @param companyId
	 * @param deptId
	 * @return
	 * @throws Exception
	 */
	public List<User> queryUserList(String companyId, String deptId) throws Exception;
	/**
	 * 取公司部门下指定角色的用户列表
	 * @param companyId
	 * @param deptId
	 * @param roleKey
	 * @return
	 * @throws Exception
	 */
	public List<User> queryUserListByCompanyIdRoleKey(  String companyId, String deptId, String roleKey ) throws Exception;
	
	/**
	 * 根据组织机构id和用户名称模糊查询客户信息
	 * @param companyId 公司id （为空表示只查询同部门的用户）
	 * @param deptId 部门id （为空表示只查询同公司的用户）
	 * @param userName 用户名称
	 * @return 用户信息
	 * @throws Exception
	 */
	public List<User> queryUserListByUserName(String companyId, String deptId,String userName ) throws Exception ;
}

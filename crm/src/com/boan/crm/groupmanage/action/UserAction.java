/**
 * Copyright (c) 2011 Changchun Boan Co. Ltd.
 * All right reserved.
 * History
 */
/*
 * @(#)UserAction.java 1.1 2012-3-20
 */
package com.boan.crm.groupmanage.action;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.boan.crm.common.Message;
import com.boan.crm.common.UserConfig;
import com.boan.crm.common.UserType;
import com.boan.crm.groupmanage.common.UserSession;
import com.boan.crm.groupmanage.model.Role;
import com.boan.crm.groupmanage.model.User;
import com.boan.crm.groupmanage.service.IRoleService;
import com.boan.crm.groupmanage.service.IUserService;
import com.boan.crm.utils.action.BaseActionSupport;
import com.boan.crm.utils.md5.MakeMd5;
import com.boan.crm.utils.page.Pagination;

/**
 * XXX 类
 * @author XXX
 * @version 1.0.0
 */
@Controller("userAction")
@Scope("prototype")
public class UserAction extends BaseActionSupport
{
	@Autowired
	@Qualifier("userService")
	private IUserService userService = null;

	private IRoleService roleService = null;

	private List<Role> roleList = null;

	private Pagination<User> pagination = new Pagination<User>();

	private Message message = new Message();

	private User user = null;

	private String[] userIds = null;

	private List<User> userList = null;

	private String deptId = null;

	private String jsonData = null;

	private String newPassword = null;
	
	private String deleteId = null;
	
	private String companyId = null;

	private List<UserType> userTypeList = UserType.getUserTypeList();

	/**
	 * 保存更新用户信息
	 * 
	 * @return
	 * @throws Exception
	 */
	public String saveOrUpdateUser() throws Exception
	{
		User oldUser = null;
		if( StringUtils.isBlank( user.getId() ) )
		{
			user.setCreateTime( Calendar.getInstance() );
		}
		else
		{
			oldUser = userService.getUserById( user.getId() );
			user.setCreateTime( oldUser.getCreateTime() );
			user.setDeptId( oldUser.getDeptId() );
			// 如果修改时，登录密码为空，则不修改原密码
			if( StringUtils.isBlank( user.getPassword() ) )
			{
				user.setPassword( oldUser.getPassword() );
			}
			else
			{
				// 密码md5加密
				String md5 = MakeMd5.MD5( user.getPassword() );
				user.setPassword( md5 );
			}
			Role role = roleService.get( user.getRoleId() );
			user.setRoleName( role.getRoleName() );
			//转换
			User.convertToUser(oldUser, user);
		}
		// 验证用户名是否重复
		boolean b = userService.isExistSameUsername( user.getId(), user.getUsername() );
		// 如果存在，则提示
		if( b )
		{
			message.setContent( "相同用户名已存在，请重新输入！" );
			return ERROR;
		}
		else
		{
			Role role = roleService.get( user.getRoleId() );
			user.setRoleName( role.getRoleName() );
			user.setDeptId( deptId );
			if( StringUtils.isBlank( user.getId() ) )
			{
				// 密码md5加密
				String md5 = MakeMd5.MD5( user.getPassword() );
				user.setPassword( md5 );
			}
			user.setCompanyId(companyId);
			if( StringUtils.isBlank( user.getId() ) )
			{
				userService.saveOrUpdateUser( user );
			}
			else
			{
				userService.saveOrUpdateUser( oldUser );
			}
			message.setContent( "用户信息保存成功！" );
			return SUCCESS;
		}
	}

	/**
	 * 删除用户信息
	 * 
	 * @return
	 * @throws Exception
	 */
	public String deleteUser() throws Exception
	{
		if( userIds != null && userIds.length > 0 )
		{
			for( int i = 0; i < userIds.length; i++ )
			{
				userService.deleteUserById( userIds[i]);
			}
		}
		return this.showUserList();
	}
	
	/**
	 * 删除用户信息
	 * 
	 * @return
	 * @throws Exception
	 */
	public String delete() throws Exception
	{
		if( StringUtils.isNotBlank( deleteId ) )
		{
			userService.deleteUserById( deleteId );
		}
		return this.showUserList();
	}

	/**
	 * 显示用户录入界面
	 * 
	 * @return
	 * @throws Exception
	 */
	public String showUser() throws Exception
	{
		if( StringUtils.isNotBlank( user.getId() ) )
		{
			user = userService.getUserById( user.getId() );
			companyId = user.getCompanyId();
			HttpSession session = ServletActionContext.getRequest().getSession();
			UserSession userSession = ( UserSession ) session.getAttribute( "userSession" );
			if( userSession != null )
			{
				String curUserId = userSession.getUserId();
				if( curUserId.equals( user.getId() ) )
				{
					user.setDeleteFlag( 1 );
				}
			}
		}
		roleList = roleService.queryAllRoleList();
		if( roleList == null )
		{
			roleList = new ArrayList<Role>();
		}
		return "show-user";
	}

	/**
	 * 显示用户列表
	 * 
	 * @return
	 * @throws Exception
	 */
	public String showUserList() throws Exception
	{
		pagination = userService.queryUserList( companyId, deptId,pagination );
		if( pagination != null && pagination.getData().size() > 0 )
		{
			HttpSession session = ServletActionContext.getRequest().getSession();
			UserSession userSession = ( UserSession ) session.getAttribute( "userSession" );
			String curUserId = null;
			if( userSession != null )
			{
				curUserId = userSession.getUserId();
			}
			for( int i = 0; i < pagination.getData().size(); i++ )
			{
				if( curUserId.equals( pagination.getData().get( i ).getId() ) )
				{
					pagination.getData().get( i ).setDeleteFlag( 1 );
				}
			}
		}
		return "show-list";
	}

	/**
	 * 初始化用户密码
	 * 
	 * @return
	 * @throws Exception
	 */
	public String initUserPassword() throws Exception
	{
		if( StringUtils.isNotBlank( user.getId() ) )
		{
			String md5Password = MakeMd5.MD5( UserConfig.DEFAULT_PASSWORD );
			userService.saveOrUpdateUserPassword( user.getId(), md5Password );
			this.jsonData = "{jsonData:\"success\"}";
		}
		else
		{
			this.jsonData = "{jsonData:\"error\"}";
		}
		return SUCCESS;
	}

	/**
	 * 显示个人信息
	 * 
	 * @return
	 */
	public String showMyInfo() throws Exception
	{
		HttpSession session = ServletActionContext.getRequest().getSession();
		UserSession userSession = ( UserSession ) session.getAttribute( "userSession" );
		if(userSession != null)
		{
			String myUserId = userSession.getUserId();
			if( StringUtils.isNotBlank( myUserId ) )
			{
				user = userService.getUserById( sessionUserId );
				deptId = user.getDeptId();
			}
			roleList = roleService.queryAllRoleList();
			if( roleList == null )
			{
				roleList = new ArrayList<Role>();
			}
		}
		return SUCCESS;
	}

	/**
	 * 更新个人资料
	 * 
	 * @return
	 * @throws Excetion
	 */
	public String saveOrUpdateMyInfo() throws Exception
	{
		HttpSession session = ServletActionContext.getRequest().getSession();
		UserSession userSession = ( UserSession ) session.getAttribute( "userSession" );
		if( userSession == null )
		{
			message.setContent( "请重新登录！" );
			return SUCCESS;
		}
		String myUserId = userSession.getUserId();
		user.setId( myUserId );
		if( StringUtils.isNotBlank( myUserId ) )
		{
			User oldUser = userService.getUserById( myUserId );
			// 判断原密码是否正确
			if( !MakeMd5.MD5( user.getPassword() ).equals( oldUser.getPassword() ) )
			{
				message.setContent( "您输入的登录密码不正确，请重新填写！" );
			}
			else
			{
				user.setCreateTime( oldUser.getCreateTime() );
				user.setDeptId( oldUser.getDeptId() );
				user.setUserType( oldUser.getUserType() );
				user.setRoleId( oldUser.getRoleId() );
				user.setRoleName( oldUser.getRoleName() );
				if( StringUtils.isBlank( newPassword ) )
				{
					user.setPassword( oldUser.getPassword() );
				}
				else
				{
					String md5 = MakeMd5.MD5( newPassword );
					user.setPassword( md5 );
				}
				
				//复制
				User.convertToUser( oldUser, user );
				userService.saveOrUpdateUser( oldUser );
				message.setContent( "个人资料保存成功！" );
			}
			
		}
		return SUCCESS;
	}

	public IUserService getUserService()
	{
		return userService;
	}

	public void setUserService( IUserService userService )
	{
		this.userService = userService;
	}

	public Message getMessage()
	{
		return message;
	}

	public void setMessage( Message message )
	{
		this.message = message;
	}

	public User getUser()
	{
		return user;
	}

	public void setUser( User user )
	{
		this.user = user;
	}

	public String[] getUserIds()
	{
		return userIds;
	}

	public void setUserIds( String[] userIds )
	{
		this.userIds = userIds;
	}

	public List<User> getUserList()
	{
		return userList;
	}

	public void setUserList( List<User> userList )
	{
		this.userList = userList;
	}

	public IRoleService getRoleService()
	{
		return roleService;
	}

	public void setRoleService( IRoleService roleService )
	{
		this.roleService = roleService;
	}

	public List<Role> getRoleList()
	{
		return roleList;
	}

	public void setRoleList( List<Role> roleList )
	{
		this.roleList = roleList;
	}

	public String getJsonData()
	{
		return jsonData;
	}

	public void setJsonData( String jsonData )
	{
		this.jsonData = jsonData;
	}

	public String getNewPassword()
	{
		return newPassword;
	}

	public void setNewPassword( String newPassword )
	{
		this.newPassword = newPassword;
	}

	public List<UserType> getUserTypeList()
	{
		return userTypeList;
	}

	public void setUserTypeList( List<UserType> userTypeList )
	{
		this.userTypeList = userTypeList;
	}

	public Pagination<User> getPagination()
	{
		return pagination;
	}

	public void setPagination( Pagination<User> pagination )
	{
		this.pagination = pagination;
	}

	public String getDeleteId()
	{
		return deleteId;
	}

	public void setDeleteId( String deleteId )
	{
		this.deleteId = deleteId;
	}

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
}
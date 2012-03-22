/**
 * Copyright (c) 2011 Changchun Boan Co. Ltd.
 * All right reserved.
 * History
 */
/*
 * @(#)UserAction.java 1.1 2012-3-20
 */
package com.boan.rees.group.action;

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

import com.boan.rees.common.Message;
import com.boan.rees.common.UserConfig;
import com.boan.rees.common.UserType;
import com.boan.rees.group.common.UserSession;
import com.boan.rees.group.model.Role;
import com.boan.rees.group.model.User;
import com.boan.rees.group.service.IRoleService;
import com.boan.rees.group.service.IUserService;
import com.boan.rees.utils.action.BaseActionSupport;
import com.boan.rees.utils.md5.MakeMd5;
import com.boan.rees.utils.page.Pagination;
import com.opensymphony.xwork2.ActionSupport;

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

	private Message message = null;

	private User user = null;

	private String[] userIds = null;

	private List<User> userList = null;

	private String deptId = null;

	private String delId = null;

	private String userId = null;

	private String unitId = null;

	private String jsonData = null;

	private String jumpUrl = null;
	
	private String newPassword = null;

	private List<UserType> userTypeList = UserType.getUserTypeList();

	/**
	 * 保存更新用户信息
	 * 
	 * @return
	 * @throws Exception
	 */
	public String saveOrUpdateUser() throws Exception
	{
		if( StringUtils.isBlank( user.getId() ) )
		{
			user.setCreateTime( Calendar.getInstance() );
		}
		else
		{
			User oldUser = userService.getUserById( user.getId() );
			user.setCreateTime( oldUser.getCreateTime() );
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
		}
		// 验证用户名是否重复
		boolean b = userService.isExistSameUsername( user.getId(), user.getUsername() );
		// 如果存在，则提示
		if( b )
		{
			message.setContent( "相同用户名已存在，请重新输入！" );
			jumpUrl = "./showUserListAction.action?deptId=" + deptId;
			return ERROR;
		}
		else
		{
			//TODO
			//Role role = roleService.getRoleById( user.getRoleId() );
			//user.setRoleName( role.getRoleName() );
			//user.setDeptId( deptId );
			//user.setUnitId( unitId );
			if( StringUtils.isBlank( user.getId() ) )
			{
				// 密码md5加密
				String md5 = MakeMd5.MD5( user.getPassword() );
				user.setPassword( md5 );
			}
			userService.saveOrUpdateUser( user );
			message.setContent( "用户信息保存成功！" );
			jumpUrl = "./showUserListAction.action?deptId=" + deptId;
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
		userService.deleteUserById( delId );
		showUserList();
		return SUCCESS;
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
			//unitId = user.getUnitId();
			//deptId = user.getDeptId();
			HttpSession session = ServletActionContext.getRequest().getSession();
			UserSession userSession = ( UserSession ) session.getAttribute( "userSession" );
			String curUserId = userSession.getUserId();
			if( curUserId.equals( user.getId() ) )
			{
				user.setDeleteFlag( 1 );
			}
		}
		//TODO
		//roleList = roleService.queryAllRoleList();
		//if( roleList == null )
		//{
		//	roleList = new ArrayList<Role>();
		//}
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
		pagination = userService.queryUserList( companyId,pagination );
		if( pagination != null && pagination.getData().size() > 0 )
		{
			HttpSession session = ServletActionContext.getRequest().getSession();
			UserSession userSession = ( UserSession ) session.getAttribute( "userSession" );
			//TODO
			String curUserId = "myUserId";//userSession.getUserId();
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
		if( StringUtils.isNotBlank( userId ) )
		{
			String md5Password = MakeMd5.MD5( UserConfig.DEFAULT_PASSWORD );
			userService.saveOrUpdateUserPassword( userId, md5Password );
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
		userId = userSession.getUserId();
		if( StringUtils.isNotBlank( userId ) )
		{
			//TODO
			//user = userService.getUserById( userId );
			//unitId = user.getUnitId();
			//deptId = user.getDeptId();
		}
		//TODO
		//roleList = roleService.queryAllRoleList();
		//if( roleList == null )
		//{
		//	roleList = new ArrayList<Role>();
		//}
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
		userId = userSession.getUserId();
		user.setId( userId );
		if( StringUtils.isNotBlank( userId ) )
		{
			User oldUser = userService.getUserById( userId );
			// 判断原密码是否正确
			if( !MakeMd5.MD5( user.getPassword() ).equals( oldUser.getPassword() ) )
			{
				message.setContent( "您输入的登录密码不正确，请重新填写！" );
			}
			else
			{
				user.setCreateTime( oldUser.getCreateTime() );
				//user.setDeptId( oldUser.getDeptId() );
				//user.setUnitId( oldUser.getUnitId() );
				user.setUserType( oldUser.getUserType() );
				if( StringUtils.isBlank( newPassword ) )
				{
					user.setPassword( oldUser.getPassword() );
				}
				else
				{
					String md5 = MakeMd5.MD5( newPassword );
					user.setPassword( md5 );
				}
				userService.saveOrUpdateUser( user );
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

	public String getDeptId()
	{
		return deptId;
	}

	public void setDeptId( String deptId )
	{
		this.deptId = deptId;
	}

	public String getDelId()
	{
		return delId;
	}

	public void setDelId( String delId )
	{
		this.delId = delId;
	}

	public String getJumpUrl()
	{
		return jumpUrl;
	}

	public void setJumpUrl( String jumpUrl )
	{
		this.jumpUrl = jumpUrl;
	}

	public String getUnitId()
	{
		return unitId;
	}

	public void setUnitId( String unitId )
	{
		this.unitId = unitId;
	}

	public String getUserId()
	{
		return userId;
	}

	public void setUserId( String userId )
	{
		this.userId = userId;
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
}
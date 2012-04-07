/**
 * Copyright (c) 2010 Changchun Boan Co. Ltd.
 * All right reserved.
 * History
 */
/*
 * @(#)LogonAction.java 1.1 Jun 8, 2010
 */

package com.boan.rees.group.action;

import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.ws.Response;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.boan.rees.common.Message;
import com.boan.rees.group.common.UserSession;
import com.boan.rees.group.model.Company;
import com.boan.rees.group.model.Factory;
import com.boan.rees.group.model.User;
import com.boan.rees.group.model.Workshop;
import com.boan.rees.group.service.ICompanyService;
import com.boan.rees.group.service.IFactoryService;
import com.boan.rees.group.service.IPopedomService;
import com.boan.rees.group.service.IUserService;
import com.boan.rees.group.service.IWorkshopService;
import com.boan.rees.utils.md5.MakeMd5;
import com.opensymphony.xwork2.ActionSupport;

/**
 * XXX 类
 * 
 * @author XXX
 * @version 1.0.0
 */
@Controller("userLogonAction")
@Scope("prototype")
public class UserLogonAction extends ActionSupport
{
	/**
	 * 用户接口
	 */
	@Autowired
	@Qualifier("userService")
	private IUserService userService = null;
	/**
	 * 权限接口
	 */
	@Autowired
	@Qualifier("popedomService")
	private IPopedomService popedomService = null;
	
	/**
	 * 获取公司名称
	 */
	@Autowired
	@Qualifier("companyService")
	private ICompanyService companyService = null;

	/**
	 * 获取工厂名称
	 */
	@Autowired
	@Qualifier("factoryService")
	private IFactoryService factoryService = null;
	
	/**
	 * 获取车间名称
	 */
	@Autowired
	@Qualifier("workshopService")
	private IWorkshopService workshopService = null;
	
	private Message message = new Message();

	private String username = null;

	private String password = null;

	private String userCName = null;

	private String oldPassword = null;

	private String newPassword = null;
	
	private String companyName = null;
	
	private String factoryName = null;

	private String workshopName = null;
	/**
	 * 验证密码
	 * 
	 * @return
	 * @throws Exception
	 */
	public String logonValid() throws Exception
	{
		String md5 = MakeMd5.MD5( password );
		boolean b = userService.logonValid( username, md5 );
		if( b )
		{
			HttpSession session = ServletActionContext.getRequest().getSession();
			User user = userService.queryUserByUsername( username );
			ServletContext servletContext = session.getServletContext();
			WebApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext);
			if( user != null )
			{
				// 获取权限串
				String roleId = user.getRoleId();
				//TODO
				String[] popedomKeys = null;// popedomService.queryPopedomsByRoleId( roleId );
				// 创建userSession对象
				UserSession userSession = new UserSession();
				userSession.setUserId( user.getId() );
				userSession.setUsername( user.getUsername() );
				userSession.setUserCName( user.getUserCName() );
				userSession.setCompanyId( user.getCompanyId() );
				userSession.setFactoryId( user.getFactoryId() );
				userSession.setWorkshopId( user.getWorkshopId());
				userSession.setUserType( user.getUserType() );
				userSession.setPopedomKeys( popedomKeys );
				
				if( companyService != null )
				{
					if( StringUtils.isNotBlank(user.getCompanyId() ))
					{
						Company company = companyService.get( user.getCompanyId() );
						if( company != null )
						{
							userSession.setCompanyName( company.getCompanyName() );
						}
					}
				}
				
				if( factoryService != null )
				{
					if( StringUtils.isNotBlank(user.getFactoryId() ) )
					{
						Factory factory = factoryService.get( user.getFactoryId() );
						if( factory != null )
						{
							userSession.setFactoryName( user.getFactoryId());
						}
					}
				}
				
				if( workshopService != null )
				{
					if( StringUtils.isNotBlank(user.getWorkshopId() ) )
					{
						Workshop workshop = workshopService.get( user.getWorkshopId() );
						if( workshop != null )
						{
							userSession.setWorkshopName( user.getWorkshopId() );
						}
					}
				}
				// 创建Session
				session.setAttribute( "userSession", userSession );
				// 单位为秒,设置为一天
				session.setMaxInactiveInterval( 60 * 60 * 1 );
				// 创建Cookies
				//Cookie myCookie = new Cookie( "loginUserName", user.getUsername());
				//myCookie.setMaxAge(60 * 60 * 24 * 30);   //设置Cookie有效期为30天
				//ServletActionContext.getResponse().addCookie(myCookie);
				return SUCCESS;
			}
			else
			{
				message.setContent( "登录失败，请检查用户名及密码！" );

				return ERROR;
			}
		}
		else
		{
			message.setContent( "登录失败，请检查用户名及密码！" );
			return ERROR;
		}
	}

	/**
	 * 身份验证成功后，转入桌面
	 * 
	 * @return
	 * @throws Exception
	 */
	public String logonMain() throws Exception
	{
		return SUCCESS;
	}
	/**
	 * 身份验证成功后，转入桌面的top页
	 * 
	 * @return
	 * @throws Exception
	 */
	public String logonTop() throws Exception
	{
		HttpSession session = ServletActionContext.getRequest().getSession();
		if( session != null && session.getAttribute( "userSession" ) != null )
		{

			if( StringUtils.isNotBlank( ( ( UserSession ) session.getAttribute( "userSession" ) ).getUserCName() ) )
			{
				userCName = ( ( UserSession ) session.getAttribute( "userSession" ) ).getUserCName();
			}
			if( StringUtils.isNotBlank( ( ( UserSession ) session.getAttribute( "userSession" ) ).getCompanyName() ) )
			{
				companyName = ( ( UserSession ) session.getAttribute( "userSession" ) ).getCompanyName();
			}
			if( StringUtils.isNotBlank( ( ( UserSession ) session.getAttribute( "userSession" ) ).getFactoryName() ) )
			{
				factoryName = ( ( UserSession ) session.getAttribute( "userSession" ) ).getFactoryName();
			}
			if( StringUtils.isNotBlank( ( ( UserSession ) session.getAttribute( "userSession" ) ).getWorkshopName() ) )
			{
				workshopName = ( ( UserSession ) session.getAttribute( "userSession" ) ).getWorkshopName();
			}
			
		}
		return SUCCESS;
	}
	/**
	 * 退出登录,释放session资源
	 * 
	 * @return
	 * @throws Exception
	 */
	public String logout() throws Exception
	{
		HttpSession session = ServletActionContext.getRequest().getSession();
		UserSession userSession = (UserSession )session.getAttribute( "userSession" );
		session.invalidate();
		return SUCCESS;
	}

	/**
	 * 显示修改个人资料的页面
	 * 
	 * @return
	 * @throws Exception
	 */
	public String showModify() throws Exception
	{
		return SUCCESS;
	}

	/**
	 * 修改个人资料
	 * 
	 * @return
	 * @throws Exception
	 */
	public String modify() throws Exception
	{
		HttpSession session = ServletActionContext.getRequest().getSession();
		if( session != null && session.getAttribute( "userSession" ) != null )
		{

			UserSession userSession = ( UserSession ) session.getAttribute( "userSession" );
			User user = userService.getUserById( userSession.getUserId() );
			String md5 = MakeMd5.MD5( oldPassword );
			String newMd5 = MakeMd5.MD5( newPassword );
			if( md5.equals( user.getPassword() ) )
			{
				user.setPassword( newMd5 );
				userService.saveOrUpdateUser( user );
				message.setContent( "密码修改成功，下次登录时请使用新密码！" );
			}
			else
			{
				message.setContent( "原密码不正确，请重新输入！" );
				return ERROR;
			}
		}
		return SUCCESS;
	}

	public Message getMessage()
	{
		return message;
	}

	public void setMessage( Message message )
	{
		this.message = message;
	}

	public String getUsername()
	{
		return username;
	}

	public void setUsername( String username )
	{
		this.username = username;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword( String password )
	{
		this.password = password;
	}

	public String getUserCName()
	{
		return userCName;
	}

	public void setUserCName( String userCName )
	{
		this.userCName = userCName;
	}

	public String getOldPassword()
	{
		return oldPassword;
	}

	public void setOldPassword( String oldPassword )
	{
		this.oldPassword = oldPassword;
	}

	public String getNewPassword()
	{
		return newPassword;
	}

	public void setNewPassword( String newPassword )
	{
		this.newPassword = newPassword;
	}

	public IUserService getUserService()
	{
		return userService;
	}

	public void setUserService( IUserService userService )
	{
		this.userService = userService;
	}

	public IPopedomService getPopedomService()
	{
		return popedomService;
	}

	public void setPopedomService( IPopedomService popedomService )
	{
		this.popedomService = popedomService;
	}

	public String getCompanyName()
	{
		return companyName;
	}

	public void setCompanyName( String companyName )
	{
		this.companyName = companyName;
	}

	public String getFactoryName()
	{
		return factoryName;
	}

	public void setFactoryName( String factoryName )
	{
		this.factoryName = factoryName;
	}

	public String getWorkshopName()
	{
		return workshopName;
	}

	public void setWorkshopName( String workshopName )
	{
		this.workshopName = workshopName;
	}

	public ICompanyService getCompanyService()
	{
		return companyService;
	}

	public void setCompanyService( ICompanyService companyService )
	{
		this.companyService = companyService;
	}

	public IFactoryService getFactoryService()
	{
		return factoryService;
	}

	public void setFactoryService( IFactoryService factoryService )
	{
		this.factoryService = factoryService;
	}

	public IWorkshopService getWorkshopService()
	{
		return workshopService;
	}

	public void setWorkshopService( IWorkshopService workshopService )
	{
		this.workshopService = workshopService;
	}

}

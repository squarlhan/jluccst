/*
 * @(#)UserAction.java 1.1 Mar 18, 2012
 */

package com.boan.rees.group.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.boan.rees.group.model.User;
import com.boan.rees.group.service.IUserService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * XXX 类
 * @author XXX
 * @version 1.0.0
 */
@Controller("userAction")
@Scope("prototype")
public class UserAction extends ActionSupport
{
	@Autowired
	@Qualifier("userService")
	private IUserService userService = null;
	private User user = null;
	/**
	 * 显示用户信息
	 * @return
	 */
	public String showUser()
	{
		return "show-info";
	}
	
	public String showList()
	{
		return "show-list";
	}
	
	public String save()
	{
		return NONE;
	}

	public User getUser()
	{
		return user;
	}

	public void setUser( User user )
	{
		this.user = user;
	}

}


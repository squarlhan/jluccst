/**
 * Copyright (c) 2012 Changchun Boan Co. Ltd.
 * All right reserved.
 * History
 */
/*
 * @(#)ReActionSupport.java 1.1 Mar 21, 2012
 */

package com.boan.rees.utils.action;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;

import com.boan.rees.group.common.UserSession;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 基本ActionSupport 类
 * 
 * @author XXX
 * @version 1.0.0
 */
public class BaseActionSupport extends ActionSupport
{

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -2675305291334757631L;

	/**
	 * 公司ID
	 */
	protected String sessionCompanyId = "companyId";

	/**
	 * 公司名称
	 */
	protected String sessionCompanyName = "companyName";

	/**
	 * 工厂ID
	 */
	protected String sessionFactoryId = "factoryId";

	/**
	 * 工厂名称
	 */
	protected String sessionFactoryName = "factoryName";

	/**
	 * 车间ID
	 */
	protected String sessionWorkshopId = "workshopId";

	/**
	 * 车间名称
	 */
	protected String sessionWorkshopName = "workshopName";

	/**
	 * 用户ID
	 */
	protected String sessionUserId = "userId";

	/**
	 * 用户姓名
	 */
	protected String sessionUserCName = "userCName";

	@Override
	public void validate()
	{
		HttpSession session = ServletActionContext.getRequest().getSession();
		UserSession userSession = ( UserSession ) session.getAttribute( "userSession" );
		sessionUserId = StringUtils.trimToEmpty( userSession.getUserId() );
		sessionUserCName = StringUtils.trimToEmpty( userSession.getUserCName() );
		sessionCompanyId = StringUtils.trimToEmpty( userSession.getCompanyId() );
		sessionFactoryId = StringUtils.trimToEmpty( userSession.getFactoryId() );
		sessionWorkshopId = StringUtils.trimToEmpty( userSession.getWorkshopId() );
		sessionCompanyName = StringUtils.trimToEmpty( userSession.getCompanyName() );
		sessionFactoryName = StringUtils.trimToEmpty( userSession.getFactoryName() );
		sessionWorkshopName = StringUtils.trimToEmpty( userSession.getWorkshopName() );
	}
}

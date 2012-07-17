/**
 * Copyright (c) 2012 Changchun Boan Co. Ltd.
 * All right reserved.
 * History
 */
/*
 * @(#)ReActionSupport.java 1.1 Mar 21, 2012
 */

package com.boan.crm.utils.action;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.boan.crm.backstagemanage.common.IPUtil;
import com.boan.crm.backstagemanage.model.Log;
import com.boan.crm.backstagemanage.service.ILogService;
import com.boan.crm.groupmanage.common.UserSession;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 基本ActionSupport 类
 * 
 * @author XXX
 * @version 1.0.0
 */
public class BaseActionSupport extends ActionSupport {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -2675305291334757631L;
	
	/**
	 * 部门ID
	 */
	protected String sessionCompanyId = null;

	/**
	 * 部门名称
	 */
	protected String sessionCompanyName = null;
	/**
	 * 部门ID
	 */
	protected String sessionDeptId = null;

	/**
	 * 部门名称
	 */
	protected String sessionDeptName = null;

	/**
	 * 用户ID
	 */
	protected String sessionUserId = null;

	/**
	 * 用户姓名
	 */
	protected String sessionUserCName = null;

	@Override
	public void validate() {
		HttpSession session = ServletActionContext.getRequest().getSession();
		UserSession userSession = (UserSession) session.getAttribute("userSession");
		if (userSession != null) {
			sessionUserId = StringUtils.trimToEmpty(userSession.getUserId());
			sessionUserCName = StringUtils.trimToEmpty(userSession.getUserCName());
			sessionDeptId = StringUtils.trimToEmpty(userSession.getDeptId());
			sessionDeptName = StringUtils.trimToEmpty(userSession.getDeptName());
			sessionCompanyId = StringUtils.trimToEmpty(userSession.getCompanyId());
			sessionCompanyName = StringUtils.trimToEmpty(userSession.getCompanyName());
		}
	}
	/**
	 * 存储日志
	 * 
	 * @param log
	 */
	protected void saveLog( Log log )
	{
		HttpSession session = ServletActionContext.getRequest().getSession();
		ServletContext servletContext = session.getServletContext();
		WebApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext);
		ILogService ls = (ILogService)context.getBean( "logService" );
		try
		{
			if( ls != null )
			{
				HttpServletRequest req = ServletActionContext.getRequest();
				log.setUserIp( IPUtil.getIpAddr( req ) );
				log.setCompanyId( sessionCompanyId );
				log.setCompanyName( sessionCompanyName );
				log.setDeptId( sessionDeptId );
				log.setDeptName( sessionDeptName);
				log.setUserId( sessionUserId );
				log.setUserName( sessionUserCName );
				ls.saveLog( log );
			}
		}
		catch( Exception e )
		{
			e.printStackTrace();
		}
	}
}

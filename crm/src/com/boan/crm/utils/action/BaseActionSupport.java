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

	/**
	 * 用户手机号
	 */
	protected String sessionUserPhone = null;

	/**
	 * JSON通用列表
	 */
	protected static final String COMMON_LIST = "show-common-list";
	/**
	 * JSON通用Map
	 */
	protected static final String COMMON_MAP = "show-common-map";
	/**
	 * JSON通用对象
	 */
	protected static final String COMMON_OBJECT = "show-common-object";

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
			sessionUserPhone = StringUtils.trimToEmpty(userSession.getUserPhone());
		}
	}

	/**
	 * 返回UserSession
	 * 
	 * @return
	 */
	public UserSession getSession() {
		HttpSession session = ServletActionContext.getRequest().getSession();
		UserSession userSession = (UserSession) session.getAttribute("userSession");
		return userSession;
	}

	/**
	 * 存储日志
	 * 
	 * @param log
	 */
	protected void saveLog(Log log) {
		HttpSession session = ServletActionContext.getRequest().getSession();
		ServletContext servletContext = session.getServletContext();
		WebApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext);
		ILogService ls = (ILogService) context.getBean("logService");
		try {
			if (ls != null) {
				HttpServletRequest req = ServletActionContext.getRequest();
				log.setUserIp(IPUtil.getIpAddr(req));
				log.setCompanyId(sessionCompanyId);
				log.setCompanyName(sessionCompanyName);
				log.setDeptId(sessionDeptId);
				log.setDeptName(sessionDeptName);
				log.setUserId(sessionUserId);
				log.setUserName(sessionUserCName);
				ls.saveLog(log);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getSessionCompanyId() {
		return sessionCompanyId;
	}

	public void setSessionCompanyId(String sessionCompanyId) {
		this.sessionCompanyId = sessionCompanyId;
	}

	public String getSessionCompanyName() {
		return sessionCompanyName;
	}

	public void setSessionCompanyName(String sessionCompanyName) {
		this.sessionCompanyName = sessionCompanyName;
	}

	public String getSessionDeptId() {
		return sessionDeptId;
	}

	public void setSessionDeptId(String sessionDeptId) {
		this.sessionDeptId = sessionDeptId;
	}

	public String getSessionDeptName() {
		return sessionDeptName;
	}

	public void setSessionDeptName(String sessionDeptName) {
		this.sessionDeptName = sessionDeptName;
	}

	public String getSessionUserId() {
		return sessionUserId;
	}

	public void setSessionUserId(String sessionUserId) {
		this.sessionUserId = sessionUserId;
	}

	public String getSessionUserCName() {
		return sessionUserCName;
	}

	public void setSessionUserCName(String sessionUserCName) {
		this.sessionUserCName = sessionUserCName;
	}

	public String getSessionUserPhone() {
		return sessionUserPhone;
	}

	public void setSessionUserPhone(String sessionUserPhone) {
		this.sessionUserPhone = sessionUserPhone;
	}
}

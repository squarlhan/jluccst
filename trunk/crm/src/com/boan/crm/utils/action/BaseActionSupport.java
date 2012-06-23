/**
 * Copyright (c) 2012 Changchun Boan Co. Ltd.
 * All right reserved.
 * History
 */
/*
 * @(#)ReActionSupport.java 1.1 Mar 21, 2012
 */

package com.boan.crm.utils.action;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;

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
		}
	}
}

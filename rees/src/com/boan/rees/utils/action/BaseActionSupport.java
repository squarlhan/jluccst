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
	 * 公司ID
	 */
	protected String companyId = "companyId";

	/**
	 * 公司名称
	 */
	protected String companyName = "companyName";

	/**
	 * 工厂ID
	 */
	protected String factoryId = "factoryId";

	/**
	 * 工厂名称
	 */
	protected String factoryName = "factoryName";

	/**
	 * 车间ID
	 */
	protected String workshopId = "workshopId";

	/**
	 * 车间名称
	 */
	protected String workshopName = "workshopName";

	/**
	 * 用户ID
	 */
	protected String userId = null;

	/**
	 * 用户姓名
	 */
	protected String userName = null;

	@Override
	public void validate() {
		HttpSession session = ServletActionContext.getRequest().getSession();
		/*
		 * UserSession userSession = ( UserSession )session.getAttribute(
		 * "userSession" ); unitId = StringUtils.trimToEmpty(
		 * userSession.getUnitId() ); unitName = StringUtils.trimToEmpty(
		 * userSession.getUnitName() ); deptId = StringUtils.trimToEmpty(
		 * userSession.getDeptId() ); deptName = StringUtils.trimToEmpty(
		 * userSession.getDeptName() ); userId = StringUtils.trimToEmpty(
		 * userSession.getUserId() ); userName = StringUtils.trimToEmpty(
		 * userSession.getUserCName() );
		 */
	}
}

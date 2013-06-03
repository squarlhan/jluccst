/**
 * Copyright (c) 2011 Changchun Boan Co. Ltd.
 * All right reserved.
 * History
 */
/*
 * @(#)Log.java 1.1 2011-1-10
 */

package com.boan.crm.backstagemanage.model;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang.StringUtils;
import org.hibernate.annotations.GenericGenerator;

import com.boan.crm.backstagemanage.common.LogType;
import com.boan.crm.utils.calendar.CurrentDateTime;

/**
 * 系统日志Pojo类
 * 
 * @author XXX
 * @version 1.0.0
 */
@Entity
@Table(name = "SYS_LOG")
public class Log implements java.io.Serializable {

	public Log() {
	}

	public Log(int logDate) {
		this.logDate = logDate;
	}

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -6861248835930396584L;

	/**
	 * 主键ID
	 */
	@Id
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@GeneratedValue(generator = "system-uuid")
	private String id = null;

	/**
	 * 日志类别0表示信息；1表示警告；2表示错误
	 */
	@Column(name = "LOG_TYPE")
	private int logType = 0;

	/**
	 * 日志内容
	 */
	@Column(name = "LOG_CONTENT")
	private String logContent = null;

	/**
	 * 创建时间
	 */
	@Column(name = "CREATE_TIME")
	private Calendar createTime = Calendar.getInstance();

	/**
	 * 公司名称
	 */
	@Column(name = "COMPANY_NAME")
	private String companyName = null;

	/**
	 * 公司id
	 */
	@Column(name = "COMPANY_ID")
	private String companyId = null;

	/**
	 * 组id
	 */
	@Column(name = "DEPT_ID")
	private String deptId = null;

	/**
	 * 所在组名
	 */
	@Column(name = "DEPT_NAME")
	private String deptName = null;

	/**
	 * 用户id
	 */
	@Column(name = "USER_ID")
	private String userId = null;
	/**
	 * 用户姓名
	 */
	@Column(name = "USER_NAME")
	private String userName = null;

	/**
	 * 用户IP
	 */
	@Column(name = "USER_IP")
	private String userIp = null;

	/**
	 * 日期格式如20090115，用于过滤某一天的日志，便于日志归档
	 */
	@Column(name = "LOG_DATE")
	private int logDate = 0;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getLogType() {
		return logType;
	}

	public String getLogTypeMean() {
		return LogType.getMean(logType);
	}

	public void setLogType(int logType) {
		this.logType = logType;
	}

	public String getLogContent() {
		return logContent;
	}

	public void setLogContent(String logContent) {
		this.logContent = logContent;
	}

	public Calendar getCreateTime() {
		return createTime;
	}

	public String getCreateTimeEn() {
		return CurrentDateTime.getCurrentDateTime(createTime);
	}

	public void setCreateTime(Calendar createTime) {
		this.createTime = createTime;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserIp() {
		return userIp;
	}

	public void setUserIp(String userIp) {
		this.userIp = userIp;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getLogDate() {
		return logDate;
	}

	public void setLogDate(int logDate) {
		this.logDate = logDate;
	}

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}


	/**
	 * 包括集团在内的组的全名
	 */
	public String getDeptFullName() {
		String fullName = this.companyName;

		if (StringUtils.isNotBlank(this.deptName)) {
			fullName += "→" + this.deptName;
		}
		return fullName;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
}

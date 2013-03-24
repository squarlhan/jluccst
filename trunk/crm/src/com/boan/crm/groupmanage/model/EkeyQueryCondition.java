/**
 * Copyright (c) 2011 Changchun Boan Co. Ltd.
 * All right reserved.
 * History
 */
/*
 * @(#)EkeyQueryCondition.java 1.1 2011-9-1
 */
package com.boan.crm.groupmanage.model;

/**
 * 用户锁查询条件
 * 
 * @author XXX
 * @version 1.0.0
 */
public class EkeyQueryCondition {
	/**
	 * 有无锁标识（0：无锁，1：有锁）
	 */
	private Integer ekeyFlag;
	/**
	 * 机构名称
	 */
	private String deptName;
	/**
	 * 机构ID
	 */
	private String deptId;
	/**
	 * 公司id
	 */
	private String companyId;

	/**
	 * 用户登录名/用户姓名
	 */
	private String userName;

	/**
	 * @return 返回 ekeyFlag
	 */
	public Integer getEkeyFlag() {
		return ekeyFlag;
	}

	/**
	 * 设置 ekeyFlag
	 * 
	 * @param ekeyFlag
	 */
	public void setEkeyFlag(Integer ekeyFlag) {
		this.ekeyFlag = ekeyFlag;
	}

	/**
	 * @return 返回 userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * 设置 userName
	 * 
	 * @param userName
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
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

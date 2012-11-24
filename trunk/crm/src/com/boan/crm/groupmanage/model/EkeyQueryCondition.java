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
 * @author XXX
 * @version 1.0.0
 */
public class EkeyQueryCondition {
	/**
	 * 有无锁标识（0：无锁，1：有锁）
	 */
	private Integer ekeyFlag;
	/**
	 * 组织机构名称
	 */
	private String organName;
	/**
	 * 组织机构ID
	 */
	private String organId;
	/**
	 * 组织机构标识
	 */
	private Long organMark;
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
	 * @param ekeyFlag 
	 */
	public void setEkeyFlag(Integer ekeyFlag) {
		this.ekeyFlag = ekeyFlag;
	}
	/**
	 * @return 返回 organName
	 */
	public String getOrganName() {
		return organName;
	}
	/**
	 * 设置 organName
	 * @param organName 
	 */
	public void setOrganName(String organName) {
		this.organName = organName;
	}
	/**
	 * @return 返回 organId
	 */
	public String getOrganId() {
		return organId;
	}
	/**
	 * 设置 organId
	 * @param organId 
	 */
	public void setOrganId(String organId) {
		this.organId = organId;
	}
	/**
	 * @return 返回 organMark
	 */
	public Long getOrganMark() {
		return organMark;
	}
	/**
	 * 设置 organMark
	 * @param organMark 
	 */
	public void setOrganMark(Long organMark) {
		this.organMark = organMark;
	}
	/**
	 * @return 返回 userName
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * 设置 userName
	 * @param userName 
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
}

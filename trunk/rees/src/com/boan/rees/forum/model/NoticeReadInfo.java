/**
 * Copyright (c) 2012 Changchun CBIT Co. Ltd.
 * All right reserved.
 * History
 */
/*
 * @(#)DemoModel.java 1.1 2012-3-5
 */

package com.boan.rees.forum.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * 已读通知实体类
 * @author YangYJ
 * @version 1.0.0
 */
@Entity
@Table(name = "Notice_Read_Info")
public class NoticeReadInfo implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GenericGenerator(name="system-uuid", strategy="uuid")
	@GeneratedValue(generator="system-uuid")
	/**
	 * 已读通知实体主键
	 */
	private String id;
	/**
	 * 用户编号
	 */
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNoticeId() {
		return noticeId;
	}

	public void setNoticeId(String noticeId) {
		this.noticeId = noticeId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Column(name = "NOTICE_ID")
	private String noticeId;

	@Column(name = "USER_ID")
	private Integer userId;
}
	
	
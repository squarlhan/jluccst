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

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * 通知Model实体
 * @author YangYJ
 * @version 1.0.0
 */
@Entity
@Table(name = "Table1")
public class NoticeInfo implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GenericGenerator(name="system-uuid", strategy="uuid")
	@GeneratedValue(generator="system-uuid")
	private String id;

	@Column(name = "NOTICE_TITLE")
	private String noticeTitle;

	@Column(name = "NOTICE_CONTENT")
	private Integer noticeContent;
	
	@Column(name = "NOTICE_PUBLISHTIME")
	private String noticePublishtime;
	
	@Column(name = "NOTICE_EXPIREDTIME")
	private String noticeExpiredtime;
	
	@Column(name = "PUBLISHER")
	private String publisher;
	
	@Column(name = "PUBLISHER_DEPT")
	private String publisherDept;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNoticeTitle() {
		return noticeTitle;
	}

	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}

	public Integer getNoticeContent() {
		return noticeContent;
	}

	public void setNoticeContent(Integer noticeContent) {
		this.noticeContent = noticeContent;
	}

	public String getNoticePublishtime() {
		return noticePublishtime;
	}

	public void setNoticePublishtime(String noticePublishtime) {
		this.noticePublishtime = noticePublishtime;
	}

	public String getNoticeExpiredtime() {
		return noticeExpiredtime;
	}

	public void setNoticeExpiredtime(String noticeExpiredtime) {
		this.noticeExpiredtime = noticeExpiredtime;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getPublisherDept() {
		return publisherDept;
	}

	public void setPublisherDept(String publisherDept) {
		this.publisherDept = publisherDept;
	}
	
}
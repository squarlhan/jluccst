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
import java.util.Calendar;

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
@Table(name = "Notice_Info")
public class NoticeInfo implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GenericGenerator(name="system-uuid", strategy="uuid")
	@GeneratedValue(generator="system-uuid")
	/**
	 * 通知表实体主键
	 */
	private String id;
	/**
	 * 通知标题
	 */
	@Column(name = "NOTICE_TITLE")
	private String noticeTitle;
	/**
	 * 通知内容
	 */
	@Column(name = "NOTICE_CONTENT")
	private String noticeContent;
	/**
	 * 通知发布时间
	 */
	@Column(name = "NOTICE_PUBLISHTIME")
	private Calendar noticePublishtime;
	/**
	 * 通知过期时间
	 */
	@Column(name = "NOTICE_EXPIREDTIME")
	private String noticeExpiredtime;
	/**
	 * 通知发布人姓名
	 */
	@Column(name = "PUBLISHER")
	private String publisher;
	/**
	 * 通知发布人所在组织名称
	 */
	@Column(name = "PUBLISHER_DEPT")
	private String publisherDept;
	@Column(name = "FORUMISSUEID")
	private String forumIssueId = "";
	public String getForumIssueId()
	{
		return forumIssueId;
	}

	public void setForumIssueId( String forumIssueId )
	{
		this.forumIssueId = forumIssueId;
	}

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

	public String getNoticeContent() {
		return noticeContent;
	}

	public void setNoticeContent(String noticeContent) {
		this.noticeContent = noticeContent;
	}

	public Calendar getNoticePublishtime() {
		return noticePublishtime;
	}

	public void setNoticePublishtime(Calendar noticePublishtime) {
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
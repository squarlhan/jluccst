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
 * 论坛交流信息实体类
 * @author YangYJ
 * @version 1.0.0
 */
@Entity
@Table(name = "forum_issue_info")
public class ForumMessageInfo implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GenericGenerator(name="system-uuid", strategy="uuid")
	@GeneratedValue(generator="system-uuid")
	/**
	 * 论坛交流消息实体主键
	 */
	private String id;
	/**
	 * 议题编号
	 */
	@Column(name = "ISSUE_ID")
	private String issueId;
	/**
	 * 交流内容
	 */
	@Column(name = "MESSAGE_CONTENT")
	private String messageContent;
	/**
	 * 消息发布人所在组织名称
	 */
	@Column(name = "PUBLISHER_DEPT")
	private String publisherDept;
	/**
	 * 消息发布人姓名
	 */
	@Column(name = "PUBLISHER")
	private String publisher;
	/**
	 * 消息发出时间
	 */
	@Column(name = "MESSAGE_TIME")
	private String 	messageTime;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getIssueId() {
		return issueId;
	}
	public void setIssueId(String issueId) {
		this.issueId = issueId;
	}
	public String getMessageContent() {
		return messageContent;
	}
	public void setMessageContent(String messageContent) {
		this.messageContent = messageContent;
	}
	public String getPublisherDept() {
		return publisherDept;
	}
	public void setPublisherDept(String publisherDept) {
		this.publisherDept = publisherDept;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getMessageTime() {
		return messageTime;
	}
	public void setMessageTime(String messageTime) {
		this.messageTime = messageTime;
	}
}
	
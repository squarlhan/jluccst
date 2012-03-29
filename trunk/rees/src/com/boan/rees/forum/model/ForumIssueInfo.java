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
 * 论坛议题实体类
 * @author YangYJ
 * @version 1.0.0
 */
@Entity
@Table(name = "forum_issue_info")
public class ForumIssueInfo implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GenericGenerator(name="system-uuid", strategy="uuid")
	@GeneratedValue(generator="system-uuid")
	
	/**
	 * 论坛议题实体主键
	 */
	private String id;

	/**
	 * 议题名称
	 */
	@Column(name = "ISSUE_NAME")
	private String issueName;
	/**
	 * 议题内容
	 */
	@Column(name = "ISSUE_CONTEIT")
	private String issueConteit;
	/**
	 * 议题状态
	 */
	@Column(name = "ISSUE_Status")
	private int issueStatus;
	/**
	 * 议题创建人
	 */
	@Column(name = "CREATOR")
	private String creator;
	/**
	 * 议题创建时间     
	 */
	@Column(name = "CREATE_TIME")
	private String 	createTime;
	public String getId() {
		return id;
	}
	public  void setId(String id) {
		this.id = id;
	}
	public String getIssueName() {
		return issueName;
	}
	public void setIssueName(String issueName) {
		this.issueName = issueName;
	}
	public String getIssueConteit() {
		return issueConteit;
	}
	public void setIssueConteit(String issueConteit) {
		this.issueConteit = issueConteit;
	}
	public int getIssueStatus() {
		return issueStatus;
	}
	public void setIssueStatus(int issueStatus) {
		this.issueStatus = issueStatus;
	}
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	public String getCreateTIME() {
		return createTime;
	}
	public void setCreateTIME(String createTIME) {
		this.createTime = createTIME;
	
	}
	public void update(ForumIssueInfo forumIssueInfo) {
		
	}

}



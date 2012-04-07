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
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

import com.boan.rees.utils.calendar.CalendarUtils;

/**
 * 论坛议题实体类
 * @author YangYJ
 * @version 1.0.0
 */
@Entity
@Table(name = "forum_issue_info")
public class ForumIssueInfo implements Serializable {

	private static final long serialVersionUID = 1L;
	public ForumIssueInfo(){}
	public ForumIssueInfo(String id,String issueName ,String issueContent,int issueStatus,String creator,Calendar createTime,int joinPersonCount)
	{
		this.id = id;
		this.issueName = issueName;
		this.issueContent = issueContent;
		this.issueStatus = issueStatus;
		this.creator = creator;
		this.createTime = createTime;
		this.joinPersonCount = joinPersonCount;
		this.createTimeStr = CalendarUtils.toString( createTime );
	}
	
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
	@Column(name = "ISSUE_CONTENT")
	private String issueContent;
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
	private Calendar createTime = Calendar.getInstance();
	/**
	 * 议题创建时间 字符串   
	 */
	@Transient
	private String createTimeStr ;
	/**
	 * 话题参与人数
	 */
	@Transient
	private int joinPersonCount = 0;
	
	public String getCreateTimeStr()
	{
		return createTimeStr;
	}
	public void setCreateTimeStr( String createTimeStr )
	{
		this.createTimeStr = createTimeStr;
	}
	
	public int getJoinPersonCount()
	{
		return joinPersonCount;
	}
	public void setJoinPersonCount( int joinPersonCount )
	{
		this.joinPersonCount = joinPersonCount;
	}
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
	public String getIssueContent() {
		return issueContent;
	}
	public void setIssueContent(String issueContent) {
		this.issueContent = issueContent;
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
	
	public Calendar getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Calendar createTime) {
		this.createTime = createTime;
		this.createTimeStr = CalendarUtils.toString( this.createTime );
	}
	public void update(ForumIssueInfo forumIssueInfo) {
		
	}

}



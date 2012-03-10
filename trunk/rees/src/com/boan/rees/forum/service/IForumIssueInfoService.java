/**
 * Copyright (c) 2012 Changchun CBIT Co. Ltd.
 * All right reserved.
 * History
 */
/*
 * @(#)IDemoService.java 1.1 2012-3-5
 */

package com.boan.rees.forum.service;

import java.util.List;

import com.boan.rees.forum.model.ForumIssueInfo;

/**
 * 论坛议题服务类接口
 * @author YangYJ
 * @version 1.0.0
 */
public interface IForumIssueInfoService {
	
	public List<ForumIssueInfo> findAllForumIssueInfo();
	
	public ForumIssueInfo get(String id);
	
	public void deleteForumIssueInfo(String... ids );
	
	public void save(ForumIssueInfo table1);
}

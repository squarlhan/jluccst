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
import java.util.Map;

import com.boan.rees.forum.model.ForumIssueInfo;
import com.boan.rees.utils.page.Pagination;

/**
 * 论坛议题服务类接口
 * @author YangYJ
 * @version 1.0.0
 */
public interface IForumIssueInfoService {

	/**
	 * 查询全部报表对象
	 */
	
	public List<ForumIssueInfo> findAllForumIssueInfo();

	/**
	 * 获取
	 */
	
	public ForumIssueInfo get(String id);

	/**
	 * 删除
	 */
	
	public void deleteForumIssueInfo(String... ids );
	/**
	 * 删除
	 */
	public void deleteForumIssueInfoByAutoTask();
	/**
	 * 保存
	 */
	
	public void save(ForumIssueInfo table1);
	/**
	 * 修改话题信息
	 * @param forumIssueInfo 话题对象
	 */
	public void update(ForumIssueInfo forumIssueInfo);
	/**
	 * 按分页查询
	 */
	public Pagination<ForumIssueInfo> findForumIssueInfoForPage(Map<String, ?> values,Pagination<ForumIssueInfo> pagination);
}

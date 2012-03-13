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

import com.boan.rees.forum.model.ForumMessageInfo;
import com.boan.rees.utils.page.Pagination;

/**
 * 论坛交流信息服务类接口
 * @author YangYJ
 * @version 1.0.0
 */
public interface IForumMessageInfoService {

	/**
	 * 查询全部报表对象
	 */
	public List<ForumMessageInfo> findAllDemoModel();

	/**
	 * 获取
	 */
	public ForumMessageInfo get(String id);

	/**
	 * 删除
	 */
	public void deleteForumMessageInfo(String... ids );

	/**
	 * 保存
	 */
	public void save(ForumMessageInfo table1);

	/**
	 * 按分页查询
	 */
	public Pagination<ForumMessageInfo> findForumMessageInfoForPage(Map<String, ?> values,Pagination<ForumMessageInfo> pagination);

}

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

import com.boan.rees.forum.model.ForumMessageInfo;

/**
 * 论坛交流信息服务类接口
 * @author YangYJ
 * @version 1.0.0
 */
public interface IForumMessageInfoService {
	
	public List<ForumMessageInfo> findAllDemoModel();
	
	public ForumMessageInfo get(String id);
	
	public void deleteForumMessageInfo(String... ids );
	
	public void save(ForumMessageInfo table1);
}

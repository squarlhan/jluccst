/**
 * Copyright (c) 2012 Changchun CBIT Co. Ltd.
 * All right reserved.
 * History
 */
/*
 * @(#)DemoServiceImpl.java 1.1 2012-3-5
 */

package com.boan.rees.forum.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.boan.rees.forum.dao.IForumMessageInfoDao;
import com.boan.rees.forum.model.ForumMessageInfo;
import com.boan.rees.forum.service.IForumMessageInfoService;

/**
 *论坛交流信息服务类接口实现
 * @author YangYJ
 * @version 1.0.0
 */
@Service("forumMessageInfoService")
public class ForumMessageInfoServiceImpl implements IForumMessageInfoService {
	
	@Autowired
	@Qualifier("forumMessageInfoDao")
	private IForumMessageInfoDao forumMessageInfoDao;

	@Override
	public List<ForumMessageInfo> findAllDemoModel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ForumMessageInfo get(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteForumMessageInfo(String... ids) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void save(ForumMessageInfo table1) {
		// TODO Auto-generated method stub
		
	}
}
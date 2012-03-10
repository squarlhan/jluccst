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

import com.boan.rees.forum.dao.INoticeReadInfoDao;
import com.boan.rees.forum.model.NoticeReadInfo;
import com.boan.rees.forum.service.INoticeReadInfoService;

/**
 * 已读通知服务类接口实现
 * @author YangYJ
 * @version 1.0.0
 */
@Service("demoService")
public class NoticeReadInfoServiceImpl implements INoticeReadInfoService {
	
	@Override
	public List<NoticeReadInfo> findAllDemoModel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NoticeReadInfo get(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteNoticeReadInfo(String... ids) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void save(NoticeReadInfo table1) {
		// TODO Auto-generated method stub
		
	}

	@Autowired
	@Qualifier("demoDao")
	private INoticeReadInfoDao NoticeReadInfoDao;
}
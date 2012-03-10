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

import com.boan.rees.forum.model.NoticeReadInfo;

/**
 * 已读通知服务类接口
 * @author YangYJ
 * @version 1.0.0
 */
public interface INoticeReadInfoService {
	
	public List<NoticeReadInfo> findAllDemoModel();
	
	public NoticeReadInfo get(String id);
	
	public void deleteNoticeReadInfo(String... ids );
	
	public void save(NoticeReadInfo table1);
}


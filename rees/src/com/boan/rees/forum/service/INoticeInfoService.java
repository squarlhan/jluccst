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

import com.boan.rees.forum.model.NoticeInfo;

/**
 * 通知服务类接口
 * @author YangYJ
 * @version 1.0.0
 */
public interface INoticeInfoService {
	
	public List<NoticeInfo> findAllDemoModel();
	
	public NoticeInfo get(String id);
	
	public void deleteNoticeInfo(String... ids );
	
	public void save(NoticeInfo table1);
}

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

import com.boan.rees.forum.model.NoticeReadInfo;
import com.boan.rees.utils.page.Pagination;

/**
 * 通知服务类接口
 * @author YangYJ
 * @version 1.0.0
 */
public interface INoticeReadInfoService {

	/**
	 * 查询全部报表对象
	 */
	public List<NoticeReadInfo> findAllDemoModel();

	/**
	 * 获取
	 */
	public NoticeReadInfo get(String id);

	/**
	 * 删除
	 */
	public void deleteNoticeInfo(String... ids );

	/**
	 * 保存
	 */
	public void save(NoticeReadInfo table1);
	
	/**
	 * 按分页查询
	 */
	public Pagination<NoticeReadInfo> findNoticeReadInfoForPage(Map<String, ?> values,Pagination<NoticeReadInfo> pagination);


}

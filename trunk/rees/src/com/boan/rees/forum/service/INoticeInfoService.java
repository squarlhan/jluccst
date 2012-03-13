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

import com.boan.rees.forum.model.NoticeInfo;
import com.boan.rees.utils.page.Pagination;

/**
 * 通知服务类接口
 * @author YangYJ
 * @version 1.0.0
 */
public interface INoticeInfoService {

	/**
	 * 查询全部报表对象
	 */
	public List<NoticeInfo> findAllDemoModel();

	/**
	 * 获取
	 */
	public NoticeInfo get(String id);

	/**
	 * 删除
	 */
	public void deleteNoticeInfo(String... ids );

	/**
	 * 保存
	 */
	public void save(NoticeInfo table1);

	/**
	 * 按分页查询
	 */
	public Pagination<NoticeInfo> findNoticeInfoForPage(Map<String, ?> values,Pagination<NoticeInfo> pagination);
}

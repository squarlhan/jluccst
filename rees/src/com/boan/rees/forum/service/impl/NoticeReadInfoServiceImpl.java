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
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.boan.rees.forum.dao.INoticeReadInfoDao;
import com.boan.rees.forum.model.NoticeReadInfo;
import com.boan.rees.forum.service.INoticeReadInfoService;
import com.boan.rees.utils.page.Pagination;

/**
 * 已读通知服务类接口实现
 * @author yangyj
 * @version 1.0.0
 */
@Service("NoticeReadInfoService")
public abstract class NoticeReadInfoServiceImpl implements INoticeReadInfoService {
	

	@Qualifier("noticeReadInfoDao")
	private INoticeReadInfoDao noticeReadInfoDao;

	/**
	 * 查询全部论坛议题表对象
	 */
	
	@Autowired
	public List<NoticeReadInfo> findAllNoticeReadInfo(){
		return noticeReadInfoDao.findAll();
	}

	/**
	 * 删除
	 */
	
	public void deleteNoticeReadInfo(String... ids ){
		noticeReadInfoDao.delete(ids);
	}

	/**
	 * 保存
	 */
	
	@Override
	public void save(NoticeReadInfo table1) {
		noticeReadInfoDao.save(table1);
	}
	
	/**
	 * 获取主键
	 */
	
	@Override
	public NoticeReadInfo get(String id) {
		return noticeReadInfoDao.get(id);
	}
	
	/**
	 * 按分页查询
	 */
	
	public Pagination<NoticeReadInfo> findNoticeReadInfoForPage(Map<String, ?> values,Pagination<NoticeReadInfo> pagination){
		
		String hql = "from DemoModel";
		List<NoticeReadInfo> data = noticeReadInfoDao.findForPage(hql, values, pagination.getStartIndex(), pagination.getPageSize());
		hql = "select count(*) from DemoModel";
		int totalRows = noticeReadInfoDao.findCountForPage(hql, values);
		pagination.setTotalRows(totalRows);
		pagination.setData(data);
		return pagination;
	}
}


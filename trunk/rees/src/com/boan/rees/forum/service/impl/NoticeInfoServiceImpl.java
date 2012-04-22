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

import com.boan.rees.forum.dao.INoticeInfoDao;
import com.boan.rees.forum.model.NoticeInfo;
import com.boan.rees.forum.service.INoticeInfoService;
import com.boan.rees.utils.page.Pagination;

/**
 * 通知服务类接口实现
 * @author yangyj
 * @version 1.0.0
 */
@Service("noticeInfoService")
public class NoticeInfoServiceImpl implements INoticeInfoService {
	@Autowired
	@Qualifier("noticeInfoDao")
	private INoticeInfoDao noticeInfoDao;
	/**
	 * 查询全部报表对象
	 */
	public List<NoticeInfo> findAllDemoModel()
	{
		return null;
	}
	/**
	 * 查询全部通知表对象
	 */
	
	@Override
	public List<NoticeInfo> findAllNoticeInfo(){
		return noticeInfoDao.findAll();
	}
	
	/**
	 * 删除
	 */
	
	@Override
	public void deleteNoticeInfo(String... ids ){
		noticeInfoDao.delete(ids);
	}

	/**
	 * 保存
	 */
	
	@Override
	public void save(NoticeInfo table1) {
		noticeInfoDao.save(table1);
	}

	/**
	 * 获取主键
	 */
	
	@Override
	public NoticeInfo get(String id) {
		return noticeInfoDao.get(id);
	}
	
	/**
	 * 按分页查询
	 */
	
	@Override
	public Pagination<NoticeInfo> findNoticeInfoForPage(Map<String, ?> values,Pagination<NoticeInfo> pagination){
		
		String hql = "from NoticeInfo";
		List<NoticeInfo> data = noticeInfoDao.findForPage(hql, values, pagination.getStartIndex(), pagination.getPageSize());
		hql = "select count(*) from NoticeInfo";
		int totalRows = noticeInfoDao.findCountForPage(hql, values);
		pagination.setTotalRows(totalRows);
		pagination.setData(data);
		return pagination;
	}
}


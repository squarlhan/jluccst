/**
 * Copyright (c) 2012 Changchun CBIT Co. Ltd.
 * All right reserved.
 * History
 */
/*
 * @(#)ForumIssueInfoServiceImpl.java 1.1 2012-3-5
 */

package com.boan.rees.forum.service.impl;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.boan.rees.forum.dao.IForumIssueInfoDao;
import com.boan.rees.forum.model.ForumIssueInfo;
import com.boan.rees.forum.service.IForumIssueInfoService;
import com.boan.rees.utils.page.Pagination;

/**
 * 论坛议题服务类接口实现
 * @author yangyj
 * @version 1.0.0
 */
@Service("forumIssueInfoService")
public class ForumIssueInfoServiceImpl implements IForumIssueInfoService {
	
	@Autowired
	@Qualifier("forumIssueInfoDao")
	private IForumIssueInfoDao forumIssueInfoDao;
	
	/**
	 * 查询全部论坛议题表对象
	 */
	
	@Override
	public List<ForumIssueInfo> findAllForumIssueInfo(){
		return forumIssueInfoDao.findAll();
	}
	
	/**
	 * 删除
	 */
	
	@Override
	public void deleteForumIssueInfo(String... ids ){
		forumIssueInfoDao.delete(ids);
	}
	
	/**
	 * 保存
	 */
	
	@Override
	public void save(ForumIssueInfo table1) {
		forumIssueInfoDao.save(table1);
	}
	
	/**
	 * 获取主键
	 */
	
	@Override
	public ForumIssueInfo get(String id) {
		return forumIssueInfoDao.get(id);
	}
	
	
	/**
	 * 修改设备信息
	 * @param forumIssueInfo 设备对象
	 */
	public void update(ForumIssueInfo forumIssueInfo){
		forumIssueInfoDao.update(forumIssueInfo);
	}
	/**
	 * 按分页查询
	 */
	
	@Override
	public Pagination<ForumIssueInfo> findForumIssueInfoForPage(Map<String, ?> values,Pagination<ForumIssueInfo> pagination){
		
		String hql = "from ForumIssueInfo";
		List<ForumIssueInfo> data = forumIssueInfoDao.findForPage(hql, values, pagination.getStartIndex(), pagination.getPageSize());
		hql = "select count(*) from ForumIssueInfo";
		int totalRows = forumIssueInfoDao.findCountForPage(hql, values);
		pagination.setTotalRows(totalRows);
		pagination.setData(data);
		return pagination;
	}
}


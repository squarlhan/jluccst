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

import com.boan.rees.forum.dao.IForumMessageInfoDao;
import com.boan.rees.forum.model.ForumMessageInfo;
import com.boan.rees.forum.service.IForumMessageInfoService;
import com.boan.rees.utils.page.Pagination;

/**
 * 论坛议题服务类接口实现
 * @author yangyj
 * @version 1.0.0
 */
@Service("forumMessageInfoService")
public abstract class ForumMessageInfoServiceImpl implements IForumMessageInfoService {
	

	@Qualifier("forumMessageInfoDao")
	private IForumMessageInfoDao forumMessageInfoDao;

	/**
	 * 查询全部论坛交流信息表对象
	 */
	
	@Autowired
	public List<ForumMessageInfo> findAllForumMessageInfo(){
		return forumMessageInfoDao.findAll();
	}

	/**
	 * 删除
	 */
	
	@Override
	public void deleteForumMessageInfo(String... ids ){
		forumMessageInfoDao.delete(ids);
	}

	/**
	 * 保存
	 */
	
	@Override
	public void save(ForumMessageInfo table1) {
		forumMessageInfoDao.save(table1);
	}

	/**
	 * 获取主键
	 */
	
	@Override
	public ForumMessageInfo get(String id) {
		return forumMessageInfoDao.get(id);
	}
	
	/**
	 * 按分页查询
	 */
	
	@Override
	public Pagination<ForumMessageInfo> findForumMessageInfoForPage(Map<String, ?> values,Pagination<ForumMessageInfo> pagination){
		
		String hql = "from ForumIssueInfo";
		List<ForumMessageInfo> data = forumMessageInfoDao.findForPage(hql, values, pagination.getStartIndex(), pagination.getPageSize());
		hql = "select count(*) from forumMessageInfo";
		int totalRows = forumMessageInfoDao.findCountForPage(hql, values);
		pagination.setTotalRows(totalRows);
		pagination.setData(data);
		return pagination;
	}


}

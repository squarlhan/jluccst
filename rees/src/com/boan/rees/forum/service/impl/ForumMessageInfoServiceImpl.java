/**
 * Copyright (c) 2012 Changchun CBIT Co. Ltd.
 * All right reserved.
 * History
 */
/*
 * @(#)DemoServiceImpl.java 1.1 2012-3-5
 */

package com.boan.rees.forum.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.boan.rees.forum.dao.IForumMessageInfoDao;
import com.boan.rees.forum.model.ForumMessageInfo;
import com.boan.rees.forum.service.IForumMessageInfoService;
import com.boan.rees.utils.calendar.CalendarUtils;
import com.boan.rees.utils.page.Pagination;

/**
 * 论坛议题服务类接口实现
 * @author yangyj
 * @version 1.0.0
 */
@Service("forumMessageInfoService")
public class ForumMessageInfoServiceImpl implements IForumMessageInfoService {
	

	@Resource
	@Qualifier("forumMessageInfoDao")
	private IForumMessageInfoDao forumMessageInfoDao;

	/**
	 * 查询全部论坛交流信息表对象
	 */
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
		
		StringBuilder hql = new StringBuilder();
		hql.append( " from ForumMessageInfo where issueId = :issueId ");
		hql.append( " order by messageTime asc" );
		
		List<ForumMessageInfo> data = forumMessageInfoDao.findForPage(hql.toString(), values, pagination.getStartIndex(), pagination.getPageSize());
		for(int i = 0;i<data.size() ;i++)
		{
			data.get( i ).setMessageTimeStr( CalendarUtils.toLongString( data.get( i ).getMessageTime() ));
		}
		hql.delete( 0, hql.length() );
		hql.append( "select count(*) from ForumMessageInfo where issueId = :issueId ");
		int totalRows = forumMessageInfoDao.findCountForPage(hql.toString(), values);
		pagination.setTotalRows(totalRows);
		pagination.setData(data);
		return pagination;
	}

	@Override
	public List<ForumMessageInfo> findAllDemoModel() {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * 根据话题取参与人
	 */
	public List<Object[]> joinPerson( String issueId )
	{
		List<Object[]> list = new ArrayList<Object[]>();
		StringBuilder hql = new StringBuilder();
		hql.append( "select distinct publisherDept , publisher  from ForumMessageInfo where issueId = :issueId order by messageTime asc");
		Map<String,String> values = new HashMap<String,String>();
		values.put( "issueId", issueId );
		list = forumMessageInfoDao.find(hql.toString(),values);
		return list;
	}

}

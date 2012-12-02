/**
 * Copyright (c) 2012 Changchun CBIT Co. Ltd.
 * All right reserved.
 * History
 */
/*
 * @(#)ForumIssueInfoServiceImpl.java 1.1 2012-3-5
 */

package com.boan.rees.forum.service.impl;


import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.boan.rees.forum.dao.IForumIssueInfoDao;
import com.boan.rees.forum.model.ForumIssueInfo;
import com.boan.rees.forum.service.IForumIssueInfoService;
import com.boan.rees.utils.calendar.CalendarUtils;
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
	 * 自动删除>６０天的话题
	 */
	public void deleteForumIssueInfoByAutoTask()
	{
		Calendar time = Calendar.getInstance();
		time.add( Calendar.DATE, -60 );
		
		StringBuffer hql = new StringBuffer();
		Map<String,Calendar> values = new HashMap<String,Calendar>();

		hql.append( "delete from ForumMessageInfo where messageTime < :deleteTime)" );
		values.put( "deleteTime", time );
		forumIssueInfoDao.executeHql( hql.toString(), values );
		
		hql.delete( 0, hql.length() );
		hql.append( "delete from ForumIssueInfo where createTime < :deleteTime" );
		values.put( "deleteTime", time );
		forumIssueInfoDao.executeHql( hql.toString(), values );
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
		String hql = " from ForumIssueInfo a order by a.createTime desc";
		List<ForumIssueInfo> data = forumIssueInfoDao.findForPage( hql, values, pagination.getStartIndex(), pagination.getPageSize());
		hql = "select count(*) from ForumIssueInfo";
		int totalRows = forumIssueInfoDao.findCountForPage(hql, values);
		int joinPersonCount = 0;
		if (totalRows > 0)
		{
			//取参与人数
			Map<String,String> params = new HashMap<String,String>();
			for(ForumIssueInfo obj :  data)
			{
				hql = "select count(distinct publisher) from ForumMessageInfo where issueId = :issueId";
				params.put( "issueId", obj.getId() );
				joinPersonCount = forumIssueInfoDao.findCountForPage(hql,params);
				obj.setJoinPersonCount( joinPersonCount );
				obj.setCreateTimeStr( CalendarUtils.toString( obj.getCreateTime() ) );
			}
		}
		
		pagination.setTotalRows(totalRows);
		pagination.setData(data);
		return pagination;
	}
}


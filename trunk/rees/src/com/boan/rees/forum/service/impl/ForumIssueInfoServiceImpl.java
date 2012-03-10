package com.boan.rees.forum.service.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.boan.rees.forum.dao.IForumIssueInfoDao;
import com.boan.rees.forum.model.ForumIssueInfo;
import com.boan.rees.forum.service.IForumIssueInfoService;

/**
 * 论坛议题服务类接口实现
 * @author YangYJ
 * @version 1.0.0
 */
@Service("demoService")
public class ForumIssueInfoServiceImpl implements IForumIssueInfoService {
	
	@Override
	public List<ForumIssueInfo> findAllForumIssueInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ForumIssueInfo get(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteForumIssueInfo(String... ids) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void save(ForumIssueInfo table1) {
		// TODO Auto-generated method stub
		
	}

	@Autowired
	@Qualifier("demoDao")
	private IForumIssueInfoDao ForumIssueInfo;
}
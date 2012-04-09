/**
 * Copyright (c) 2012 Changchun CBIT Co. Ltd.
 * All right reserved.
 * History
 */
/*
 * @(#)DemoDaoImpl.java 1.1 2012-3-5
 */

package com.boan.rees.forum.dao.impl;

import org.springframework.stereotype.Repository;

import com.boan.rees.forum.dao.IForumMessageInfoDao;
import com.boan.rees.forum.model.ForumMessageInfo;
import com.boan.rees.utils.dao.impl.BaseDao;

/**
 * 论坛交流消息Dao接口实现
 * @author YangYJ
 * @version 1.0.0
 */
@Repository("forumMessageInfoDao")
public class ForumMessageInfoDaoImpl extends BaseDao<ForumMessageInfo, String> implements IForumMessageInfoDao{
	
}

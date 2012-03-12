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

import com.boan.rees.forum.dao.INoticeReadInfoDao;
import com.boan.rees.forum.model.NoticeReadInfo;
import com.boan.rees.utils.dao.impl.BaseDao;

/**
 *已读通知Dao接口实现
 * @author YangYJ
 * @version 1.0.0
 */
@Repository("noticeReadInfoDao")
public class NoticeReadInfoDaoImpl extends BaseDao<NoticeReadInfo, String> implements INoticeReadInfoDao{

}



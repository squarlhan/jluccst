/**
 * Copyright (c) 2011 Changchun Boan Co. Ltd.
 * All right reserved.
 * History
 */
/*
 * @(#)EkeyUserServiceImpl.java 1.1 2011-1-25
 */
package com.boan.crm.groupmanage.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.boan.crm.groupmanage.dao.IEkeyUserDao;
import com.boan.crm.groupmanage.model.EkeyQueryCondition;
import com.boan.crm.groupmanage.model.EkeyUser;
import com.boan.crm.groupmanage.service.IEkeyUserService;


/**
 * USB锁的身份信息Service实现类
 * @author XXX
 * @version 1.0.0
 */
@Service("ekeyUserService")
public class EkeyUserServiceImpl implements IEkeyUserService {
	
	/**
	 * USB锁的身份信息Dao接口
	 */
	@Autowired
	@Qualifier("ekeyUserDao")
	private IEkeyUserDao dao;
	
	/**
	 * 根据SN删除USB锁的身份信息
	 * @param sn USB锁的SN值
	 * @return 删除行数
	 * @throws Exception 
	 */
	public int deleteEkeyUserByIds(String sn) throws Exception{
		return dao.deleteEkeyUserByIds(sn);
	}
	/**
	 * 根据用户ID删除USB锁的身份信息
	 * @param userId 用户ID
	 * @return 删除行数
	 * @throws Exception 
	 */
	public int deleteEkeyUserByUserId(String userId) throws Exception{
		return dao.deleteEkeyUserByUserId(userId);
	}
	/**
	 * 保存USB锁的身份信息
	 * @param ekeyUser USB锁的身份信息
	 * @return 是否保存成功
	 * @throws Exception 
	 */
	public int saveOrUpdateEkeyUser(EkeyUser ekeyUser) throws Exception{
		return dao.saveOrUpdateEkeyUser(ekeyUser);
	}
	/**
	 * 根据SN获取USB锁的身份信息
	 * @param sn USB锁的SN值
	 * @return USB锁的身份信息
	 * @throws Exception 
	 */
	public EkeyUser getEkeyUserById(String sn) throws Exception{
		return dao.getEkeyUserById(sn);
	}
	/**
	 * 根据用户锁查询条件查询用户锁列表
	 * @param condition 用户锁查询条件
	 * @param startIndex 分页起始位置
	 * @param maxResults 每页最大显示数量
	 * @return 用户锁列表
	 * @throws Exception
	 */
	public List<EkeyUser> queryEkeyUserListByCondition(EkeyQueryCondition condition, int startIndex, int maxResults) throws Exception{
		return dao.queryEkeyUserListByCondition(condition, startIndex, maxResults);
	}
	/**
	 * 根据用户锁查询条件查询用户锁总数
	 * @param condition 用户锁查询条件
	 * @return 用户锁总数
	 * @throws Exception
	 */
	public int queryEkeyUserCountByCondition(EkeyQueryCondition condition) throws Exception{
		return dao.queryEkeyUserCountByCondition(condition);
	}
	
	/**
	 * @return 返回 USB锁的身份信息Dao接口
	 */
	public IEkeyUserDao getDao() {
		return dao;
	}
	/**
	 * 设置 USB锁的身份信息Dao接口
	 * @param dao USB锁的身份信息Dao接口
	 */
	public void setDao(IEkeyUserDao dao) {
		this.dao = dao;
	}
}

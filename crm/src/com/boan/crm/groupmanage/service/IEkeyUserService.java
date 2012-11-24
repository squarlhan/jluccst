/**
 * Copyright (c) 2011 Changchun Boan Co. Ltd.
 * All right reserved.
 * History
 */
/*
 * @(#)IEkeyUserService.java 1.1 2011-1-25
 */
package com.boan.crm.groupmanage.service;

import java.util.List;

import com.boan.crm.groupmanage.model.EkeyQueryCondition;
import com.boan.crm.groupmanage.model.EkeyUser;


/**
 * USB锁的身份信息Service接口
 * @author XXXX
 * @version 1.0.0
 */
public interface IEkeyUserService{
	/**
	 * 根据SN删除USB锁的身份信息
	 * @param sn USB锁的SN值
	 * @return 删除行数
	 * @throws Exception 
	 */
	public int deleteEkeyUserByIds(String sn) throws Exception;
	/**
	 * 根据用户ID删除USB锁的身份信息
	 * @param userId 用户ID
	 * @return 删除行数
	 * @throws Exception 
	 */
	public int deleteEkeyUserByUserId(String userId) throws Exception;
	/**
	 * 保存USB锁的身份信息
	 * @param ekeyUser USB锁的身份信息
	 * @return 是否保存成功
	 * @throws Exception 
	 */
	public int saveOrUpdateEkeyUser(EkeyUser ekeyUser) throws Exception;
	/**
	 * 根据SN获取USB锁的身份信息
	 * @param sn USB锁的SN值
	 * @return USB锁的身份信息
	 * @throws Exception 
	 */
	public EkeyUser getEkeyUserById(String sn) throws Exception;
	/**
	 * 根据用户锁查询条件查询用户锁列表
	 * @param condition 用户锁查询条件
	 * @param startIndex 分页起始位置
	 * @param maxResults 每页最大显示数量
	 * @return 用户锁列表
	 * @throws Exception
	 */
	public List<EkeyUser> queryEkeyUserListByCondition(EkeyQueryCondition condition, int startIndex, int maxResults) throws Exception;
	/**
	 * 根据用户锁查询条件查询用户锁总数
	 * @param condition 用户锁查询条件
	 * @return 用户锁总数
	 * @throws Exception
	 */
	public int queryEkeyUserCountByCondition(EkeyQueryCondition condition) throws Exception;
}

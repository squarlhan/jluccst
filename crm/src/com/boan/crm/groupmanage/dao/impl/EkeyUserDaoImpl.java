/**
 * Copyright (c) 2011 Changchun Boan Co. Ltd.
 * All right reserved.
 * History
 */
/*
 * @(#)EkeyUserDaoImpl.java 1.1 2011-1-25
 */
package com.boan.crm.groupmanage.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.boan.crm.groupmanage.dao.IEkeyUserDao;
import com.boan.crm.groupmanage.model.EkeyQueryCondition;
import com.boan.crm.groupmanage.model.EkeyUser;
import com.boan.crm.groupmanage.model.User;
import com.boan.crm.utils.dao.impl.BaseDao;
import com.sun.org.apache.xml.internal.security.encryption.EncryptedKey;

/**
 * USB锁的身份信息Dao实现类
 * 
 * @author XXX
 * @version 1.0.0
 */
@Repository("ekeyUserDao")
public class EkeyUserDaoImpl extends BaseDao<EkeyUser, Serializable> implements IEkeyUserDao {

	/**
	 * @throws Exception
	 */
	public EkeyUserDaoImpl() throws Exception {
		super();
	}

	/**
	 * 根据SN删除USB锁的身份信息
	 * 
	 * @param sn
	 *            USB锁的SN值
	 * @return 删除行数
	 * @throws Exception
	 */
	public int deleteEkeyUserByIds(String sn) throws Exception {
		// //this.deleteEntityById(sn);
		return 0;
	}

	/**
	 * 根据用户ID删除USB锁的身份信息
	 * 
	 * @param userId
	 *            用户ID
	 * @return 删除行数
	 * @throws Exception
	 */
	public int deleteEkeyUserByUserId(String userId) throws Exception {
		int count = 0;
		if (userId != null && !"".equals(userId)) {
			DetachedCriteria criteria = DetachedCriteria.forClass(EkeyUser.class);
			criteria.add(Property.forName("userId").eq(userId));
			List<EkeyUser> list = null;// // this.queryByCriteria(criteria);
			if (list != null && list.size() > 0) {
				for (EkeyUser ekeyUser : list) {
					// //this.deleteEntity(ekeyUser);
					count++;
				}
			}
		}
		return count;
	}

	/**
	 * 保存USB锁的身份信息
	 * 
	 * @param ekeyUser
	 *            USB锁的身份信息
	 * @return 是否保存成功
	 * @throws Exception
	 */
	public int saveOrUpdateEkeyUser(EkeyUser ekeyUser) throws Exception {
		try {
			this.saveOrUpdate(ekeyUser);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	/**
	 * 根据SN获取USB锁的身份信息
	 * 
	 * @param sn
	 *            USB锁的SN值
	 * @return USB锁的身份信息
	 * @throws Exception
	 */
	public EkeyUser getEkeyUserById(String sn) throws Exception {
		String hql = " from EkeyUser where sn = :sn";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("sn", sn);
		List<EkeyUser> list = super.find(hql, map);
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	/**
	 * 根据用户锁查询条件查询用户锁列表
	 * 
	 * @param condition
	 *            用户锁查询条件
	 * @param startIndex
	 *            分页起始位置
	 * @param maxResults
	 *            每页最大显示数量
	 * @return 用户锁列表
	 * @throws Exception
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<User> queryEkeyUserListByCondition(EkeyQueryCondition condition, int startIndex, int maxResults) throws Exception {
		String hql = null;
		Map<String, Object> map = new HashMap<String, Object>();
		// 表示公司用户
		if (StringUtils.isNotBlank(condition.getDeptId())) {
			hql = "from User where companyId = :companyId and deptId = :deptId  order by createTime";
			map.put("deptId", condition.getDeptId());
		} else {
			hql = "from User where companyId = :companyId  order by createTime";
		}
		map.put("companyId", condition.getCompanyId());
		return super.findForPage(hql, map, startIndex, maxResults);
	}

	/**
	 * 根据用户锁查询条件查询用户锁总数
	 * 
	 * @param condition
	 *            用户锁查询条件
	 * @return 用户锁总数
	 * @throws Exception
	 */
	@SuppressWarnings("rawtypes")
	public int queryEkeyUserCountByCondition(EkeyQueryCondition condition) throws Exception {
		String hql = null;
		Map<String, Object> map = new HashMap<String, Object>();
		// 表示公司用户
		if (StringUtils.isNotBlank(condition.getDeptId())) {
			hql = " select count(id) from User where  companyId = :companyId  and deptId = :deptId  ";
			map.put("deptId", condition.getDeptId());
		} else {
			hql = " select count(id) from User where  companyId = :companyId ";
		}
		map.put("companyId", condition.getCompanyId());
		return super.findCountForPage(hql, map);
	}

	@Override
	public EkeyUser getEkeyUserByUserId(String userId) throws Exception {
		String hql = "  from EkeyUser where  userId = :userId";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userId", userId);
		List<EncryptedKey> userList = super.find(hql, map);
		if (userList != null && userList.size() > 0) {
			return (EkeyUser) userList.get(0);
		} else {
			return null;
		}
	}

	@Override
	public void deleteUserEkeyData(String userId) {
		String hql = " delete EkeyUser where  userId = :userId";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userId", userId);
		this.executeHql(hql, map);
	}
}

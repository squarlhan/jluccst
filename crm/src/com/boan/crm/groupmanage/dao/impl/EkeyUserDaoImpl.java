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
		// //this.saveOrUpdateEntity(ekeyUser);
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
	public List<EkeyUser> queryEkeyUserListByCondition(EkeyQueryCondition condition, int startIndex, int maxResults) throws Exception {
		List userIdList = queryUserIdList(condition);
		if (userIdList != null && userIdList.size() > 0) {
			DetachedCriteria criteria = DetachedCriteria.forClass(EkeyUser.class);
			criteria.createAlias("user", "user", DetachedCriteria.FULL_JOIN);
			criteria.setResultTransformer(DetachedCriteria.PROJECTION);
			criteria.add(Property.forName("user.id").in(queryUserIdList(condition)));
			if (condition.getEkeyFlag() != null) {
				if (0 == condition.getEkeyFlag()) {
					criteria.add(Property.forName("sn").isNull());
				} else if (1 == condition.getEkeyFlag()) {
					criteria.add(Property.forName("sn").isNotNull());
				}
			}
			List list = null;
			if (maxResults != 0) {
				// //list = this.queryByCriteria(criteria, startIndex,
				// maxResults);
			} else {
				// //list = this.queryByCriteria(criteria);
			}

			if (list != null && list.size() > 0) {
				List<EkeyUser> resultList = new ArrayList<EkeyUser>();
				for (Object objs : list) {
					Object[] objects = (Object[]) objs;
					if (objects.length == 2 && objects[0] instanceof User) {
						User user = (User) objects[0];
						EkeyUser ekeyUser;
						if (objects[1] == null) {
							ekeyUser = new EkeyUser();
							ekeyUser.setUserId(user.getId());
						} else {
							ekeyUser = (EkeyUser) objects[1];
						}
						ekeyUser.setUser(user);
						resultList.add(ekeyUser);
					}
				}
				return resultList;
			}
			return list;
		} else {
			return new ArrayList<EkeyUser>();
		}
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
		List userIdList = queryUserIdList(condition);
		if (userIdList != null && userIdList.size() > 0) {
			DetachedCriteria criteria = DetachedCriteria.forClass(EkeyUser.class);
			criteria.createAlias("user", "user", DetachedCriteria.FULL_JOIN);
			criteria.setResultTransformer(DetachedCriteria.PROJECTION);
			criteria.add(Property.forName("user.id").in(queryUserIdList(condition)));
			if (condition.getEkeyFlag() != null) {
				if (0 == condition.getEkeyFlag()) {
					criteria.add(Property.forName("sn").isNull());
				} else if (1 == condition.getEkeyFlag()) {
					criteria.add(Property.forName("sn").isNotNull());
				}
			}
			return 0;// //this.getRowCount(criteria);
		} else {
			return 0;
		}
	}

	/**
	 * 根据用户锁查询条件查询用户ID数组
	 * 
	 * @param condition
	 *            用户锁查询条件
	 * @return 用户ID数组
	 * @throws Exception
	 */
	@SuppressWarnings("rawtypes")
	private List queryUserIdList(EkeyQueryCondition condition) throws Exception {

		DetachedCriteria criteria = null;// //DetachedCriteria.forClass(UserDept.class);
		criteria.createAlias("user", "user");
		criteria.createAlias("dept", "dept");

		ProjectionList projectionList = Projections.projectionList();
		projectionList.add(Projections.distinct(Projections.property("userId")));

		criteria.setProjection(projectionList);

		if (condition.getOrganId() != null && !"".equals(condition.getOrganId())) {
			criteria.add(Property.forName("dept.id").eq(condition.getOrganId()));
		}
		if (condition.getOrganMark() != null && condition.getOrganMark() != 0) {
			// /criteria.add(this.queryByMark("dept.mark",
			// condition.getOrganMark()));
		}
		if (condition.getOrganName() != null && !"".equals(condition.getOrganName())) {
			criteria.add(Property.forName("dept.name").like(condition.getOrganName(), MatchMode.ANYWHERE));
		}
		if (condition.getUserName() != null && !"".equals(condition.getUserName())) {
			criteria.add(Restrictions.or(Property.forName("user.name").like(condition.getUserName(), MatchMode.ANYWHERE), Property.forName("user.username").like(condition.getUserName(), MatchMode.ANYWHERE)));
		}
		return null;// this.queryByCriteria(criteria);
	}
}

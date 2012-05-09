/*
 * @(#)RuleAdviceInfoDaoImpl.java 1.1 2012-4-23
 */

package com.boan.rees.expertsystem.dao.impl;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.boan.rees.expertsystem.dao.IRuleAdviceInfoDao;
import com.boan.rees.expertsystem.model.RuleAdviceInfo;
import com.boan.rees.expertsystem.model.RuleReasonInfo;
import com.boan.rees.utils.dao.impl.BaseDao;

/**
 * 现象Dao实现 类
 * @author jiangmeidi
 * @version 1.0.0
 */
@Repository("ruleAdviceInfoDao")
public class RuleAdviceInfoDaoImpl extends BaseDao<RuleAdviceInfo, Integer> implements IRuleAdviceInfoDao {
	@SuppressWarnings("unchecked")
	@Override
	public RuleAdviceInfo get(int id) {
		return (RuleAdviceInfo) getSession().load(entityClass, id);
	}
	/**
	 * 根据id查找建议
	 * @param id id号
	 * @return 建议实体
	 */
	@SuppressWarnings("unchecked")
	@Override
	public RuleAdviceInfo getbyid(int id) {
	Query query = getSession().createQuery("from  RuleAdviceInfo  where id =:id");
	query.setParameter("id", id);
	return (RuleAdviceInfo)query.uniqueResult();
}
	
}


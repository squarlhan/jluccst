/*
 * @(#)RuleReasonInfoDaoImpl.java 1.1 2012-4-23
 */

package com.boan.rees.expertsystem.dao.impl;

import org.springframework.stereotype.Repository;

import com.boan.rees.expertsystem.dao.IRuleReasonInfoDao;
import com.boan.rees.expertsystem.model.RuleAdviceInfo;
import com.boan.rees.expertsystem.model.RuleReasonInfo;
import com.boan.rees.utils.dao.impl.BaseDao;

/**
 * 原因Dao实现 类
 * @author jiangmeidi
 * @version 1.0.0
 */
@Repository("ruleReasonInfoDao")
public class RuleReasonInfoDaoImpl extends BaseDao<RuleReasonInfo,Integer> implements IRuleReasonInfoDao {
	@SuppressWarnings("unchecked")
	@Override
	public RuleReasonInfo get(int id) {
		return (RuleReasonInfo) getSession().load(entityClass, id);
	}
}


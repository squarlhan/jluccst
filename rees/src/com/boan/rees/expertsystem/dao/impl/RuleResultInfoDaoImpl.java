/*
 * @(#)RuleRsultInfoDaoImpl.java 1.1 2012-4-23
 */

package com.boan.rees.expertsystem.dao.impl;

import org.springframework.stereotype.Repository;

import com.boan.rees.expertsystem.dao.IRuleResultInfoDao;
import com.boan.rees.expertsystem.model.RuleAdviceInfo;
import com.boan.rees.expertsystem.model.RuleResultInfo;
import com.boan.rees.utils.dao.impl.BaseDao;

/**
 * 现象Dao实现 类
 * @author jiangmeidi
 * @version 1.0.0
 */
@Repository("ruleResultInfoDao")
public class RuleResultInfoDaoImpl extends BaseDao<RuleResultInfo, Integer> implements IRuleResultInfoDao {
	@SuppressWarnings("unchecked")
	@Override
	public RuleResultInfo get(int id) {
		return (RuleResultInfo) getSession().load(entityClass, id);
	}
}


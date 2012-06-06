/*
 * @(#)RuleInfoDaoImpl.java 1.1 2012-4-23
 */

package com.boan.rees.expertsystem.dao.impl;

import org.springframework.stereotype.Repository;

import com.boan.rees.expertsystem.dao.IRuleInfoDao;
import com.boan.rees.expertsystem.model.RuleInfo;
import com.boan.rees.utils.dao.impl.BaseDao;

/**
 * 现象Dao实现 类
 * @author jiangmeidi
 * @version 1.0.0
 */
@Repository("ruleInfoDao")
public class RuleInfoDaoImpl extends BaseDao<RuleInfo, Integer> implements IRuleInfoDao {
	@SuppressWarnings("unchecked")
	@Override
	public RuleInfo get(int id) {
		return (RuleInfo) getSession().load(entityClass, id);
	}
	
	
}


/*
 * @(#)AdviceViewDaoImpl.java 1.1 2012-4-25
 */

package com.boan.rees.expertsystem.dao.impl;

import org.springframework.stereotype.Repository;

import com.boan.rees.expertsystem.dao.IRuleViewDao;
import com.boan.rees.expertsystem.model.RuleView;
import com.boan.rees.utils.dao.impl.BaseDao;

/**
 * RuleView 视图DAO接口类
 * @author jiangmeidi
 * @version 1.0.0
 */
@Repository("ruleViewDao")
public class RuleViewDaoImpl extends BaseDao<RuleView, Integer> implements IRuleViewDao {
	@SuppressWarnings("unchecked")
	@Override
	public RuleView get(int id) {
		return (RuleView) getSession().load(entityClass, id);
	}
}


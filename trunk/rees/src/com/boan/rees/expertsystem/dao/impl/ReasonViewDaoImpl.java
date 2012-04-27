/*
 * @(#)AdviceViewDaoImpl.java 1.1 2012-4-25
 */

package com.boan.rees.expertsystem.dao.impl;

import org.springframework.stereotype.Repository;

import com.boan.rees.expertsystem.dao.IReasonViewDao;
import com.boan.rees.expertsystem.model.ReasonView;
import com.boan.rees.utils.dao.impl.BaseDao;

/**
 * ReasonView 视图DAO接口类
 * @author jiangmeidi
 * @version 1.0.0
 */
@Repository("reasonViewDao")
public class ReasonViewDaoImpl extends BaseDao<ReasonView, Integer> implements IReasonViewDao {
	@SuppressWarnings("unchecked")
	@Override
	public ReasonView get(int id) {
		return (ReasonView) getSession().load(entityClass, id);
	}
}


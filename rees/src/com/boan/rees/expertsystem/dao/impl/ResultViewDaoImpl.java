/*
 * @(#)AdviceViewDaoImpl.java 1.1 2012-4-25
 */

package com.boan.rees.expertsystem.dao.impl;

import org.springframework.stereotype.Repository;

import com.boan.rees.expertsystem.dao.IResultViewDao;
import com.boan.rees.expertsystem.model.ResultView;
import com.boan.rees.utils.dao.impl.BaseDao;

/**
 * ResultView 视图DAO接口类
 * @author jiangmeidi
 * @version 1.0.0
 */
@Repository("resultViewDao")
public class ResultViewDaoImpl extends BaseDao<ResultView, Integer> implements IResultViewDao {
	@SuppressWarnings("unchecked")
	@Override
	public ResultView get(int id) {
		return (ResultView) getSession().load(entityClass, id);
	}
}


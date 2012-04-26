/*
 * @(#)AdviceViewDaoImpl.java 1.1 2012-4-25
 */

package com.boan.rees.expertsystem.dao.impl;

import org.springframework.stereotype.Repository;

import com.boan.rees.expertsystem.dao.IAdviceViewDao;
import com.boan.rees.expertsystem.model.AdviceView;
import com.boan.rees.utils.dao.impl.BaseDao;

/**
 * AdviceView 视图DAO接口类
 * @author jiangmeidi
 * @version 1.0.0
 */
@Repository("adviceViewDao")
public class AdviceViewDaoImpl extends BaseDao<AdviceView, String> implements IAdviceViewDao {
	@SuppressWarnings("unchecked")
	@Override
	public AdviceView get(int id) {
		return (AdviceView) getSession().load(entityClass, id);
	}
}


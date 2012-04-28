/*
 * @(#)IAdviceViewDao.java 1.1 2012-4-25
 */

package com.boan.rees.expertsystem.dao;

import com.boan.rees.expertsystem.model.RuleView;
import com.boan.rees.utils.dao.IBaseDao;

/**
 * 规则视图dao接口 类
 * @author jiangmeidi
 * @version 1.0.0
 */
public interface IRuleViewDao extends IBaseDao<RuleView, Integer>{
	public RuleView get(int id);
}


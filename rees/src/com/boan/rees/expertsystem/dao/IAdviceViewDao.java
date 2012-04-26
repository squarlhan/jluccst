/*
 * @(#)IAdviceViewDao.java 1.1 2012-4-25
 */

package com.boan.rees.expertsystem.dao;

import com.boan.rees.expertsystem.model.AdviceView;
import com.boan.rees.expertsystem.model.RuleAdviceInfo;
import com.boan.rees.utils.dao.IBaseDao;

/**
 * XXX 类
 * @author jiangmeidi
 * @version 1.0.0
 */
public interface IAdviceViewDao extends IBaseDao<AdviceView, String>{
	public AdviceView get(int id);
}


/*
 * @(#)IAdviceViewDao.java 1.1 2012-4-25
 */

package com.boan.rees.expertsystem.dao;

import com.boan.rees.expertsystem.model.AdviceView;
import com.boan.rees.expertsystem.model.RuleAdviceInfo;
import com.boan.rees.utils.dao.IBaseDao;

/**
 * 建议视图dao接口 类
 * @author jiangmeidi
 * @version 1.0.0
 */
public interface IAdviceViewDao extends IBaseDao<AdviceView, Integer>{
	public AdviceView get(int id);
}


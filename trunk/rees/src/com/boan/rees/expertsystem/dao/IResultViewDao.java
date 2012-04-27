/*
 * @(#)IAdviceViewDao.java 1.1 2012-4-25
 */

package com.boan.rees.expertsystem.dao;

import com.boan.rees.expertsystem.model.ResultView;
import com.boan.rees.utils.dao.IBaseDao;

/**
 * 现象视图dao接口 类
 * @author jiangmeidi
 * @version 1.0.0
 */
public interface IResultViewDao extends IBaseDao<ResultView, Integer>{
	public ResultView get(int id);
}


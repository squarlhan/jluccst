/*
 * @(#)IAdviceViewDao.java 1.1 2012-4-25
 */

package com.boan.rees.expertsystem.dao;

import com.boan.rees.expertsystem.model.ReasonView;
import com.boan.rees.utils.dao.IBaseDao;

/**
 * 原因视图DAO接口 类
 * @author jiangmeidi
 * @version 1.0.0
 */
public interface IReasonViewDao extends IBaseDao<ReasonView, Integer>{
	public ReasonView get(int id);
}


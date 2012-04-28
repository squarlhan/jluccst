/*
 * @(#)RuleAdviceInfoDao.java 1.1 2012-4-23
 */

package com.boan.rees.expertsystem.dao;

import com.boan.rees.expertsystem.model.RuleInfo;
import com.boan.rees.utils.dao.IBaseDao;

/**
 * 建议 类接口
 * @author jiangmeidi
 * @version 1.0.0
 */
public interface IRuleInfoDao extends IBaseDao<RuleInfo, Integer>{
	public RuleInfo get(int id);
}


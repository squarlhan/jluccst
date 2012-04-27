/*
 * @(#)RuleAdviceInfoDao.java 1.1 2012-4-23
 */

package com.boan.rees.expertsystem.dao;

import com.boan.rees.expertsystem.model.RuleAdviceInfo;
import com.boan.rees.utils.dao.IBaseDao;

/**
 * 建议 类接口
 * @author jiangmeidi
 * @version 1.0.0
 */
public interface IRuleAdviceInfoDao extends IBaseDao<RuleAdviceInfo, Integer>{
	public RuleAdviceInfo get(int id);
}


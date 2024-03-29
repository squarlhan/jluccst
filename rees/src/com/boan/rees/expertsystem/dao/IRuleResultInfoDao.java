/*
 * @(#)RuleRsultInfoDao.java 1.1 2012-4-23
 */

package com.boan.rees.expertsystem.dao;

import com.boan.rees.expertsystem.model.RuleAdviceInfo;
import com.boan.rees.expertsystem.model.RuleReasonInfo;
import com.boan.rees.expertsystem.model.RuleResultInfo;
import com.boan.rees.utils.dao.IBaseDao;

/**
 * 现象 类接口
 * @author jiangmeidi
 * @version 1.0.0
 */
public interface IRuleResultInfoDao extends IBaseDao<RuleResultInfo, Integer>{
	public RuleResultInfo get(int id);
	public RuleResultInfo getbyid(int id) ;
}


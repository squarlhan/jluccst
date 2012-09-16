/*
 * @(#)ISpecialDeviceRuleDao.java 1.1 2012-9-17
 */

package com.boan.rees.expertsystem.dao;

import com.boan.rees.expertsystem.model.RuleInfo;
import com.boan.rees.expertsystem.model.SpecialDeviceRuleInfo;
import com.boan.rees.utils.dao.IBaseDao;

/**
 * XXX 类
 * @author jiangmeidi
 * @version 1.0.0
 */
public interface ISpecialDeviceRuleDao extends IBaseDao<SpecialDeviceRuleInfo, String>{
	public SpecialDeviceRuleInfo get(String id);

}


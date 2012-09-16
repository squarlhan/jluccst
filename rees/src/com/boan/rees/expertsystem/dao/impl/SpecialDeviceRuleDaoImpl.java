/*
 * @(#)SpecialDeviceRuleDaoImpl.java 1.1 2012-9-17
 */

package com.boan.rees.expertsystem.dao.impl;

import org.springframework.stereotype.Repository;

import com.boan.rees.expertsystem.dao.ISpecialDeviceRuleDao;
import com.boan.rees.expertsystem.model.SpecialDeviceRuleInfo;
import com.boan.rees.utils.dao.impl.BaseDao;

/**
 * XXX 类
 * @author jiangmeidi
 * @version 1.0.0
 */
@Repository("specialDeviceRuleDao")
public class SpecialDeviceRuleDaoImpl extends BaseDao<SpecialDeviceRuleInfo, String>  implements ISpecialDeviceRuleDao {
	@SuppressWarnings("unchecked")
	@Override
	public SpecialDeviceRuleInfo get(String id) {
		return (SpecialDeviceRuleInfo) getSession().load(entityClass, id);
	}
}


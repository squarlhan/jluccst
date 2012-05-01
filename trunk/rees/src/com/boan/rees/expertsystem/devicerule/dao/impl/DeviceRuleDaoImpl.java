/*
 * @(#)DeviceRuleDaoImpl.java 1.1 2012-5-2
 */

package com.boan.rees.expertsystem.devicerule.dao.impl;

import org.springframework.stereotype.Repository;

import com.boan.rees.expertsystem.devicerule.dao.IDeviceRuleDao;
import com.boan.rees.expertsystem.devicerule.model.DeviceRuleInfo;
import com.boan.rees.utils.dao.impl.BaseDao;

/**
 * XXX 类
 * @author ZhuYF
 * @version 1.0.0
 */
@Repository("deviceRuleDao")
public class DeviceRuleDaoImpl extends BaseDao<DeviceRuleInfo,Integer> implements IDeviceRuleDao {

}


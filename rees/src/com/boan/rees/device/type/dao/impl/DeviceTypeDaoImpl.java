/*
 * @(#)DeviceTypeDaoImpl.java 1.1 2012-4-1
 */

package com.boan.rees.device.type.dao.impl;

import org.springframework.stereotype.Repository;

import com.boan.rees.device.type.dao.IDeviceTypeDao;
import com.boan.rees.device.type.model.DeviceType;
import com.boan.rees.utils.dao.impl.BaseDao;

/**
 * XXX 类
 * @author jiangmeidio
 * @version 1.0.0
 */
@Repository("deviceTypeDao")
public class DeviceTypeDaoImpl extends BaseDao<DeviceType, String> implements IDeviceTypeDao {

}


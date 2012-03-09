/**
 * Copyright (c) 2012 jluccst.
 * All right reserved.
 * History
 */
/*
 * @(#)DeviceInfoDaoImpl.java 1.1 2012-3-8
 */

package com.boan.rees.device.dao.impl;

import org.springframework.stereotype.Repository;

import com.boan.rees.device.dao.IDeviceInfoDao;

import com.boan.rees.device.model.DeviceInfo;

import com.boan.rees.utils.dao.impl.BaseDao;


/**
 * XXX 类
 * @author jiangmeidi
 * @version 1.0.0
 */
@Repository("deviceInfoDao")
public class DeviceInfoDaoImpl extends BaseDao<DeviceInfo, String> implements IDeviceInfoDao{
}


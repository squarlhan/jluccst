/**
 * Copyright (c) 2012 jluccst.
 * All right reserved.
 * History
 */
/*
 * @(#)PointInfoDaoImpl.java 1.1 2012-3-8
 */

package com.boan.rees.device.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.boan.rees.device.dao.IPointInfoDao;
import com.boan.rees.device.model.PointInfo;
import com.boan.rees.utils.dao.impl.BaseDao;

/**
 * XXX 类
 * 
 * @author jiangmeidi
 * @version 1.0.0
 */
@Repository("pointInfoDao")
public class PointInfoDaoImpl extends BaseDao<PointInfo, String> implements
		IPointInfoDao {
	@Override
	public List<PointInfo> findPointInfosByDeviceId(String deviceId) {
		String hql = "from PointInfo where deviceId=?";
		List<PointInfo> list = this.find(hql, new String[] { deviceId });
		return list;
	}
}
/**
 * Copyright (c) 2012 jluccst.
 * All right reserved.
 * History
 */
/*
 * @(#)PointInfoDao.java 1.1 2012-3-8
 */

package com.boan.rees.device.dao;
import java.util.List;

import com.boan.rees.device.model.PointInfo;
import com.boan.rees.utils.dao.IBaseDao;
/**
 * XXX 类
 * @author jiangmeidi
 * @version 1.0.0
 */
public interface IPointInfoDao extends IBaseDao<PointInfo, String>{
	public List<PointInfo> findPointInfosByDeviceId(String deviceId);
}


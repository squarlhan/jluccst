/**
 * Copyright (c) 2012 Boan Co. Ltd.
 * All right reserved.
 * History
 */
package com.boan.rees.device.dao;

import java.util.List;

import com.boan.rees.device.model.PointInfo;
import com.boan.rees.utils.dao.IBaseDao;

/**
 * 监测点DAO接口
 * 
 * @author leon
 * @version 1.0.0
 */
public interface IPointInfoDao extends IBaseDao<PointInfo, String> {
	public List<PointInfo> findPointInfosByDeviceId(String deviceId);
	public List<PointInfo> findPointInfosByDeviceId(String deviceId, int status);
}

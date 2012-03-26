/**
 * Copyright (c) 2012 Boan Co. Ltd.
 * All right reserved.
 * History
 */

package com.boan.rees.device.dao;

import com.boan.rees.device.model.PointDataInfo;
import com.boan.rees.utils.dao.IBaseDao;

/**
 * 监测点数据Dao接口
 * 
 * @author catherine
 * @version 1.0.0
 */
public interface IPointDataInfoDao extends IBaseDao<PointDataInfo, String> {
	/**
	 * 获得年度指定周日期的监测点数据
	 * @param year
	 * @param week
	 * @param paramId
	 * @return
	 */
	public PointDataInfo get(String year, String week, String paramId);
	
	/**
	 * 删除指定设备某年第X星期的数据
	 * @param deviceId
	 * @param year
	 * @param week
	 */
	public void delete(String deviceId, String year, String week);
}

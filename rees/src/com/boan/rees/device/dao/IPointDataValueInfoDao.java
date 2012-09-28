/**
 * Copyright (c) 2012 Boan Co. Ltd.
 * All right reserved.
 * History
 */

package com.boan.rees.device.dao;

import com.boan.rees.device.model.PointDataValueInfo;
import com.boan.rees.utils.dao.IBaseDao;

/**
 * 监测点数据Dao接口
 * 
 * @author catherine
 * @version 1.0.0
 */
public interface IPointDataValueInfoDao extends IBaseDao<PointDataValueInfo, String> {
	/**
	 * 根据监测点数据ID,监测点参数ID获得监测点数据
	 * @param pointDataId
	 * @param paramId
	 * @return
	 */
	public PointDataValueInfo get(String pointDataId, String paramId);
	/**
	 * 删除数据
	 * @param dataId
	 */
	public void deleteByDataId(String dataId);
}

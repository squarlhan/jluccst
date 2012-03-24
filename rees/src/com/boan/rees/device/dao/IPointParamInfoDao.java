package com.boan.rees.device.dao;

import java.util.List;

import com.boan.rees.device.model.PointParamInfo;
import com.boan.rees.utils.dao.IBaseDao;

/**
 * 监测点参数Dao接口
 * 
 * @author leon
 * @version 1.0.0
 */
public interface IPointParamInfoDao extends IBaseDao<PointParamInfo, String> {
	/**
	 * 根据监测点ID获得参数列表
	 * @param PointId 监测点ID
	 * @return
	 */
	public List<PointParamInfo> findPointParamInfoByPointId(String pointId);
}
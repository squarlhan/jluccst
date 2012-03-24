package com.boan.rees.device.service;

import java.util.List;

import com.boan.rees.device.model.PointParamInfo;

/**
 * 监控点参数接口
 * 
 * @author leon
 * @version 1.0.0
 */
public interface IPointParamInfoService {
	/**
	 * 根据监测点ID获得参数列表
	 * @param PointId 监测点ID
	 * @return
	 */
	public List<PointParamInfo> findPointParamInfoByPointId(String pointId);

	/**
	 * 根据参数ID获取监控点参数对象
	 * @param paramId
	 * @return
	 */
	public PointParamInfo get(String paramId);

	/**
	 * 根据id删除监控点参数
	 * @param ids 监测点ID
	 */
	public void delete(String... ids);

	/**
	 * 保存监控点参数对象
	 * @param pointParamInfo 监测点参数对象
	 */
	public void save(PointParamInfo pointParamInfo);
}

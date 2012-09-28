package com.boan.rees.device.service;

import java.util.List;
import java.util.Map;

import com.boan.rees.device.model.PointDataInfo;
import com.boan.rees.device.model.PointDataValueInfo;
import com.boan.rees.utils.page.Pagination;

/**
 * 监控点参数服务类接口
 * 
 * @author jiangmeidi
 * @version 1.0.0
 */
public interface IPointDataValueInfoService {
	/**
	 * 查找全部监控点参数
	 */
	public List<PointDataValueInfo> findAllPointDataValueInfo();

	/**
	 * 根据id获取监控点参数
	 */
	public PointDataValueInfo get(String id);

	/**
	 * 根据id删除监控点参数
	 */
	public void deletePointDataValueInfo(String... ids);

	/**
	 * 保存监控点参数
	 */
	public void save(PointDataValueInfo table1);

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

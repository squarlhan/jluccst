package com.boan.rees.device.service;

import java.util.List;
import java.util.Map;

import com.boan.rees.device.model.PointDataInfo;
import com.boan.rees.utils.page.Pagination;

/**
 * 监控点参数服务类接口
 * 
 * @author jiangmeidi
 * @version 1.0.0
 */
public interface IPointDataInfoService {
	/**
	 * 查找全部监控点参数
	 */
	public List<PointDataInfo> findAllPointDataInfo();

	/**
	 * 根据id获取监控点参数
	 */
	public PointDataInfo get(String id);

	/**
	 * 根据id删除监控点参数
	 */
	public void deletePointDataInfo(String... ids);

	/**
	 * 保存监控点参数
	 */
	public void save(PointDataInfo table1);

	/**
	 * 按分页查询监控点参数
	 */
	public Pagination<PointDataInfo> findPointDataInfoForPage(
			Map<String, ?> values, Pagination<PointDataInfo> pagination);
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
	
	/**
	 * 获得指定设备周日期的监测点数据
	 * @param year
	 * @param week
	 * @param deviceId
	 * @return
	 */
	public List<PointDataInfo> listByDeviceId(String year, String week, String deviceId);
	
	/**
	 * 获得指定设备周日期的监测点数据
	 * @param values
	 * @return
	 */
	public List<PointDataInfo> listByMap(Map<String, ?> values);
}

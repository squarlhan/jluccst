package com.boan.rees.device.service;

import java.util.List;
import java.util.Map;

import com.boan.rees.device.model.PointInfo;
import com.boan.rees.utils.page.Pagination;

/**
 * 监控点服务类接口
 * 
 * @author ZhuYF,leon
 * @version 1.0.0
 */
public interface IPointInfoService {
	/**
	 * 查找全部监控点
	 */
	public List<PointInfo> findAllPointInfo();

	/**
	 * 根据id查找监控点
	 */
	public PointInfo get(String id);

	/**
	 * 根据id删除监控点
	 */
	public void deletePointInfo(String... ids);

	/**
	 * 保存监控点
	 */
	public void save(PointInfo pointInfo);

	/**
	 * 分页查找监控点
	 */
	public Pagination<PointInfo> findPointInfoForPage(Map<String, ?> values,
			Pagination<PointInfo> pagination);

	/**
	 * 根据设备ID获得监测点数据对象列表
	 * 
	 * @param deviceId 设备ID
	 * @return
	 */
	public List<PointInfo> findPointInfosByDeviceId(String deviceId);
	
	/**
	 * 根据设备ID和监测点状态获得监测点数据对象列表
	 * 
	 * @param deviceId 设备ID
	 * @param status 监测点状态
	 * @return
	 */
	public List<PointInfo> findPointInfosByDeviceId(String deviceId, int status);
	
	/**
	 * 设置监测点状态
	 * @param deviceId 设备Id
	 * @param status 监测点状态，0表示未执行系统任务，1表示已执行
	 */
	public void changeStatus(String deviceId, int status);
}

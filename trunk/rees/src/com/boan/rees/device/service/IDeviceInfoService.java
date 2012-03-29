package com.boan.rees.device.service;

import java.util.List;
import java.util.Map;

import com.boan.rees.device.model.DeviceInfo;

import com.boan.rees.utils.page.Pagination;
/**
 * 设备服务类接口
 * @author jiangmeidi
 * @version 1.0.0
 */

public interface IDeviceInfoService {
	/**
	 * 查找全部设备
	 */
    public List<DeviceInfo> findAllDeviceInfo();
    /**
	 * 根据id获取设备
	 */
	public DeviceInfo get(String id);
	/**
	 * 删除设备
	 */
	public void deleteDeviceInfo(String... ids );
	/**
	 * 保存设备
	 */
	public void save(DeviceInfo table1);
	
	/**
	 * 修改设备信息
	 * @param deviceInfo 设备对象
	 */
	public void update(DeviceInfo deviceInfo);
	/**
	 * 按分页查找设备
	 */
	public Pagination<DeviceInfo> findDeviceInfoForPage(Map<String, ?> values,Pagination<DeviceInfo> pagination);
	
	/**
	 * 设备排序
	 * @param ids 有顺序的设备Id数组
	 */
	public void sortDeviceInfo(String... ids);
	
	/**
	 * 删除设备图片
	 * @param deviceId 设备Id
	 */
	public void deleteDeviceImage(String deviceId);
}

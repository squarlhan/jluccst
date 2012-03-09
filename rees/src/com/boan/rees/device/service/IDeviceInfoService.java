package com.boan.rees.device.service;

import java.util.List;

import com.boan.rees.device.model.DeviceInfo;
/**
 * 设备服务类接口
 * @author jiangmeidi
 * @version 1.0.0
 */

public interface IDeviceInfoService {
    public List<DeviceInfo> findAllDeviceInfo();
	
	public DeviceInfo get(String id);
	
	public void deleteDeviceInfo(String... ids );
	
	public void save(DeviceInfo table1);
}

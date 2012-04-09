/*
 * @(#)IDeviceTypeService.java 1.1 2012-4-1
 */

package com.boan.rees.device.type.service;

import java.util.List;
import java.util.Map;

import com.boan.rees.device.model.DeviceInfo;
import com.boan.rees.device.type.model.DeviceType;
import com.boan.rees.utils.page.Pagination;

/**
 * 设备类型Service类接口
 * @author jiangmeidi
 * @version 1.0.0
 */
public interface IDeviceTypeService {
	 public List<DeviceType> findAllDeviceType();
	    /**
		 * 根据id获取设备类型
		 */
		public DeviceType get(String id);
		/**
		 * 删除设备类型
		 */
		public void deleteDeviceType(String... ids );
		/**
		 * 保存设备类型
		 */
		public void save(DeviceType table1);
		
		/**
		 * 修改设备类型信息
		 * @param deviceInfo 设备对象
		 */
		public void update(DeviceType deviceInfo);
		/**
		 * 按分页查找设备类型
		 */
		public Pagination<DeviceType> findDeviceTypeForPage(Map<String, ?> values,Pagination<DeviceType> pagination);
		
		/**
		 * 判断指定Id的设备类型是否存在指定属性和属性值的记录
		 * @param id Id
		 * @param propertyName 属性
		 * @param propertyValue 属性值
		 * @return true：存在 false：不存在
		 */
	    public boolean isExistDeviceTypeProperty(String id, String propertyName,String propertyValue);

}


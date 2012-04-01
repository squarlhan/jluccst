/*
 * @(#)DeviceTypeServiceImpl.java 1.1 2012-4-1
 */

package com.boan.rees.device.type.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.boan.rees.device.model.DeviceInfo;
import com.boan.rees.device.type.dao.IDeviceTypeDao;
import com.boan.rees.device.type.model.DeviceType;
import com.boan.rees.device.type.service.IDeviceTypeService;
import com.boan.rees.utils.page.Pagination;

/**
 *设备类型Service实现类
 * @author jiangmeidi
 * @version 1.0.0
 */
@Service("deviceTypeService")
public class DeviceTypeServiceImpl implements IDeviceTypeService{
	@Autowired
	@Qualifier("deviceTypeDao")
	private IDeviceTypeDao deviceTypeDao;
	@Override
	 public List<DeviceType> findAllDeviceType(){
		return deviceTypeDao.findAll();
	}
	
	    /**
		 * 根据id获取设备类型
		 */
	   @Override
		public DeviceType get(String id){
			return deviceTypeDao.get(id);
		}
		/**
		 * 删除设备类型
		 */
	   @Override
		public void deleteDeviceType(String... ids ){
			deviceTypeDao.delete(ids);
		}
		/**
		 * 保存设备类型
		 */
	   @Override
		public void save(DeviceType table1){
			deviceTypeDao.save(table1);
		}
		
		/**
		 * 修改设备类型信息
		 * @param deviceInfo 设备对象
		 */
	   @Override
		public void update(DeviceType deviceType){
			deviceTypeDao.update(deviceType);
		}
		/**
		 * 按分页查找设备类型
		 */
	   @Override
		public Pagination<DeviceType> findDeviceTypeForPage(Map<String, ?> values,Pagination<DeviceType> pagination){
		String hql = "from DeviceType";
		List<DeviceType> data = deviceTypeDao.findForPage(hql, values, pagination.getStartIndex(), pagination.getPageSize());
		hql = "select count(*) from DeviceType";
		int totalRows = deviceTypeDao.findCountForPage(hql, values);
		pagination.setTotalRows(totalRows);
		pagination.setData(data);
		return pagination;
		}
}


package com.boan.rees.device.service.impl;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


import com.boan.rees.demo.dao.IDemoDao;
import com.boan.rees.demo.model.DemoModel;
import com.boan.rees.device.dao.IDeviceInfoDao;
import com.boan.rees.device.model.DeviceInfo;
import com.boan.rees.device.service.*;
import com.boan.rees.utils.page.Pagination;
@Service("deviceInfoService")
public class DeviceInfoServiceImpl  implements IDeviceInfoService {
	@Autowired
	@Qualifier("deviceInfoDao")
	private IDeviceInfoDao deviceInfoDao;
	
	@Override
	/**
	 * 查找全部设备
	 */
	public List<DeviceInfo> findAllDeviceInfo() {
		return deviceInfoDao.findAll();
		
	}
	/**
	 * 根据id查找设备
	 */
	@Override
	public DeviceInfo get(String id) {
		
		return deviceInfoDao.get(id);
	}
	/**
	 * 根据id删除设备
	 */

	@Override
	public void deleteDeviceInfo(String... ids) {
		deviceInfoDao.delete(ids);
		
		
	}
	/**
	 * 保存设备
	 */
	@Override
	public void save(DeviceInfo table1) {
		deviceInfoDao.save(table1);
		
	}
	
	/**
	 * 修改设备信息
	 * @param deviceInfo 设备对象
	 */
	public void update(DeviceInfo deviceInfo){
		deviceInfoDao.update(deviceInfo);
	}
	
	/**
	 * 按分页查询设备
	 */
	@Override

	public Pagination<DeviceInfo> findDeviceInfoForPage(Map<String, ?> values,Pagination<DeviceInfo> pagination){
		
		String hql = "from DeviceInfo";
		List<DeviceInfo> data = deviceInfoDao.findForPage(hql, values, pagination.getStartIndex(), pagination.getPageSize());
		hql = "select count(*) from DeviceInfo";
		int totalRows = deviceInfoDao.findCountForPage(hql, values);
		pagination.setTotalRows(totalRows);
		pagination.setData(data);
		return pagination;
	}

}

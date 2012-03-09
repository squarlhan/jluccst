package com.boan.rees.device.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


import com.boan.rees.demo.dao.IDemoDao;
import com.boan.rees.device.dao.IDeviceInfoDao;
import com.boan.rees.device.model.DeviceInfo;
import com.boan.rees.device.service.*;
@Service("deviceInfoService")
public class DeviceInfoServiceImpl  implements IDeviceInfoService {
	@Autowired
	@Qualifier("deviceInfoDao")
	private IDeviceInfoDao deviceInfoDao;
	
	@Override
	public List<DeviceInfo> findAllDeviceInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DeviceInfo get(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteDeviceInfo(String... ids) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void save(DeviceInfo table1) {
		// TODO Auto-generated method stub
		
	}

}

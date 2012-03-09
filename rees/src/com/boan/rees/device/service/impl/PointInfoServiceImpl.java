package com.boan.rees.device.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.boan.rees.demo.dao.IDemoDao;
import com.boan.rees.device.dao.IPointInfoDao;
import com.boan.rees.device.model.PointInfo;
import com.boan.rees.device.service.IPointInfoService;
@Service("pointInfoService")
public class PointInfoServiceImpl implements IPointInfoService{

	@Autowired
	@Qualifier("pointInfoDao")
	private IPointInfoDao pointInfoDao;
	
	@Override
	public List<PointInfo> findAllDeviceInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PointInfo get(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deletePointInfo(String... ids) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void save(PointInfo table1) {
		// TODO Auto-generated method stub
		
	}

}

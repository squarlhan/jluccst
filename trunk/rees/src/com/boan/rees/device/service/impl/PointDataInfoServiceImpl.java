package com.boan.rees.device.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.boan.rees.demo.dao.IDemoDao;
import com.boan.rees.device.dao.IPointDataInfoDao;
import com.boan.rees.device.model.PointDataInfo;
import com.boan.rees.device.service.IPointDataInfoService;
@Service("pointDataInfoService")
public class PointDataInfoServiceImpl implements IPointDataInfoService{
	
	@Autowired
	@Qualifier("pointDataInfoDao")
	private IPointDataInfoDao PointDataInfo;
	@Override
	public List<PointDataInfo> findAllDeviceInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PointDataInfo get(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deletePointDataInfo(String... ids) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void save(PointDataInfo table1) {
		// TODO Auto-generated method stub
		
	}

}

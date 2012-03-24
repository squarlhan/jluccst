package com.boan.rees.device.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.boan.rees.device.dao.IPointParamInfoDao;
import com.boan.rees.device.model.PointParamInfo;
import com.boan.rees.device.service.IPointParamInfoService;

/**
 * 监测点参数接口实现类
 * @author leon
 *
 */
@Service("pointParamInfoService")
public class PointParamInfoServiceImpl implements IPointParamInfoService{
	
	@Autowired
	@Qualifier("pointParamInfoDao")
	private IPointParamInfoDao pointParamInfoDao;

	@Override
	public List<PointParamInfo> findPointParamInfoByPointId(String pointId) {
		return pointParamInfoDao.findPointParamInfoByPointId(pointId);
	}

	@Override
	public PointParamInfo get(String paramId) {
		return pointParamInfoDao.get(paramId);
	}

	@Override
	public void delete(String... ids) {
		pointParamInfoDao.delete(ids);
	}

	@Override
	public void save(PointParamInfo pointParamInfo) {
		pointParamInfoDao.saveOrUpdate(pointParamInfo);
	}
	
}

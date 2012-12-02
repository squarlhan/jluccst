package com.boan.rees.device.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.boan.rees.device.dao.IPointDataInfoDao;
import com.boan.rees.device.model.PointDataInfo;
import com.boan.rees.utils.dao.impl.BaseDao;

/**
 * 监测点数据DAO 类
 * 
 * @author leon
 * @version 1.0.0
 */
@Repository("pointDataInfoDao")
public class PointDataInfoDaoImpl extends BaseDao<PointDataInfo, String>
		implements IPointDataInfoDao {

	@Override
	public PointDataInfo get(String year, String week, String paramId) {
		String hql = "from PointDataInfo where deviceId=? and dataYear=? and weekofYear=?";
		List<PointDataInfo> list = this.find(hql, new Object[] { paramId, Integer.parseInt(year), Integer.parseInt(week) });
		if(list!=null&&list.size()==1)
			return list.get(0);
		else
			return null;
	}

	@Override
	public void delete(String deviceId, String year, String week) {
		String hql = "delete PointDataInfo where deviceId=:deviceId and dataYear=:year and weekofYear=:week";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put( "deviceId", deviceId );
		map.put( "year", Integer.parseInt(year) );
		map.put( "week", Integer.parseInt(week) );
		this.executeHql(hql, map);
	}

	@Override
	public List<PointDataInfo> listByDeviceId(String year, String week, String deviceId) {
		String hql = "from PointDataInfo where deviceId=? and dataYear=? and weekofYear=? order by creatTime desc";
		List<PointDataInfo> list = this.find(hql, new Object[] { deviceId, Integer.parseInt(year), Integer.parseInt(week) });
		return list;
	}
}

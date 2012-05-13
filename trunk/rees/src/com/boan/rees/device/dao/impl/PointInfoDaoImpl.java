package com.boan.rees.device.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.boan.rees.device.dao.IPointInfoDao;
import com.boan.rees.device.model.PointInfo;
import com.boan.rees.utils.dao.impl.BaseDao;

/**
 * 监测点DAO 类
 * 
 * @author jiangmeidi,leon
 * @version 1.0.0
 */
@Repository("pointInfoDao")
public class PointInfoDaoImpl extends BaseDao<PointInfo, String> implements
		IPointInfoDao {
	@Override
	public List<PointInfo> findPointInfosByDeviceId(String deviceId) {
		String hql = "from PointInfo where deviceId=?";
		List<PointInfo> list = this.find(hql, new String[] { deviceId });
		return list;
	}

	@Override
	public List<PointInfo> findPointInfosByDeviceId(String deviceId, int status) {
		String hql = "from PointInfo where deviceId=? and status=?";
		List<PointInfo> list = this.find(hql, new Object[] { deviceId,status });
		return list;
	}

	@Override
	public void updateStatus(String deviceId, int status) {
		String hql = "update PointInfo set status=:status where deviceId=:deviceId";
		Map<String, Object> values = new HashMap<String,Object>();
		values.put("deviceId", deviceId);
		values.put("status", status);
		this.executeHql(hql, values);
	}
}
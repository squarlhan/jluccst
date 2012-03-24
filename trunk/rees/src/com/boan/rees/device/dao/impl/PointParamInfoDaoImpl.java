package com.boan.rees.device.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.boan.rees.device.dao.IPointParamInfoDao;
import com.boan.rees.device.model.PointParamInfo;
import com.boan.rees.utils.dao.impl.BaseDao;

/**
 * 监测点参数DAO 类
 * 
 * @author leon
 * @version 1.0.0
 */
@Repository("pointParamInfoDao")
public class PointParamInfoDaoImpl extends BaseDao<PointParamInfo, String>
		implements IPointParamInfoDao {

	@Override
	public List<PointParamInfo> findPointParamInfoByPointId(String pointId) {
		String hql = "from PointParamInfo where pointId=?";
		List<PointParamInfo> list = this.find(hql, new String[] { pointId });
		return list;
	}

}

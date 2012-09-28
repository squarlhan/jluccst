package com.boan.rees.device.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.boan.rees.device.dao.IPointDataValueInfoDao;
import com.boan.rees.device.model.PointDataValueInfo;
import com.boan.rees.utils.dao.impl.BaseDao;

/**
 * 监测点数据DAO 类
 * 
 * @author leon
 * @version 1.0.0
 */
@Repository("pointDataValueInfoDao")
public class PointDataValueInfoDaoImpl extends BaseDao<PointDataValueInfo, String> implements IPointDataValueInfoDao {

	@Override
	public PointDataValueInfo get(String pointDataId, String paramId) {
		String hql = "from PointDataValueInfo where paramId=? and pointDataId=?";
		List<PointDataValueInfo> list = this.find(hql, new Object[] { paramId, pointDataId });
		if(list!=null&&list.size()==1)
			return list.get(0);
		else
			return null;
	}

	@Override
	public void deleteByDataId(String dataId) {
		String hql = "delete PointDataValueInfo where pointDataId=:dataId";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put( "dataId", dataId );
		this.executeHql(hql, map);
	}
}

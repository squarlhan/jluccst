package com.boan.rees.device.dao.impl;

import java.util.List;

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
		String hql = "from PointDataInfo where paramId=? and dataYear=? and weekofYear=?";
		List<PointDataInfo> list = this.find(hql, new String[] { paramId, year, week });
		if(list!=null&&list.size()==1)
			return list.get(0);
		else
			return null;
	}

}

package com.boan.rees.device.dao.impl;

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

}

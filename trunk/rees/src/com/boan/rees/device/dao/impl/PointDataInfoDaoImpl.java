/**
 * Copyright (c) 2012 jluccst.
 * All right reserved.
 * History
 */
/*
 * @(#)PointDataInfoDaoImpl.java 1.1 2012-3-8
 */

package com.boan.rees.device.dao.impl;

import org.springframework.stereotype.Repository;


import com.boan.rees.device.dao.IPointDataInfoDao;
import com.boan.rees.device.model.PointDataInfo;
import com.boan.rees.utils.dao.impl.BaseDao;

/**
 * XXX 类
 * @author jiangmeidi
 * @version 1.0.0
 */
@Repository("pointDataInfoDao")
public class PointDataInfoDaoImpl extends BaseDao<PointDataInfo, String> implements IPointDataInfoDao{

}


package com.boan.crm.servicemanage.dao.impl;

import org.springframework.stereotype.Repository;

import com.boan.crm.servicemanage.dao.IPointInfoDao;
import com.boan.crm.servicemanage.model.PointInfo;
import com.boan.crm.utils.dao.impl.BaseDao;

/**
* 积分管理Dao接口实现
* @author XXX
* @version 1.0.0
*/

@Repository("pointInfoDao")
public class PointInfoDaoImpl extends BaseDao<PointInfo,String> implements IPointInfoDao{
}

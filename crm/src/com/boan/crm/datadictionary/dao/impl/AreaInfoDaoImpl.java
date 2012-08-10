package com.boan.crm.datadictionary.dao.impl;

import org.springframework.stereotype.Repository;

import com.boan.crm.datadictionary.dao.IAreaInfoDao;
import com.boan.crm.datadictionary.model.AreaInfo;
import com.boan.crm.utils.dao.impl.BaseDao;

/**
 * @author luojx
 * @version 1.0.0
 */
@Repository("areaInfoDao")
public class AreaInfoDaoImpl extends BaseDao<AreaInfo, String>
		implements IAreaInfoDao {
}

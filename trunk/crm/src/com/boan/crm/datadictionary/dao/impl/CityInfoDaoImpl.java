package com.boan.crm.datadictionary.dao.impl;

import org.springframework.stereotype.Repository;

import com.boan.crm.datadictionary.dao.ICityInfoDao;
import com.boan.crm.datadictionary.model.CityInfo;
import com.boan.crm.utils.dao.impl.BaseDao;

/**
 * @author luojx
 * @version 1.0.0
 */
@Repository("cityInfoDao")
public class CityInfoDaoImpl extends BaseDao<CityInfo, String>
		implements ICityInfoDao {
}

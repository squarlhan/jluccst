package com.boan.crm.datadictionary.dao.impl;

import org.springframework.stereotype.Repository;

import com.boan.crm.datadictionary.dao.IProvinceInfoDao;
import com.boan.crm.datadictionary.model.ProvinceInfo;
import com.boan.crm.utils.dao.impl.BaseDao;

/**
 * @author luojx
 * @version 1.0.0
 */
@Repository("provinceInfoDao")
public class ProvinceInfoDaoImpl extends BaseDao<ProvinceInfo, String>
		implements IProvinceInfoDao {
}

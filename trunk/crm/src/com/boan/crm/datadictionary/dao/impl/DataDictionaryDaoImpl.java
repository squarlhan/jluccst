package com.boan.crm.datadictionary.dao.impl;

import org.springframework.stereotype.Repository;

import com.boan.crm.datadictionary.dao.IDataDictionaryDao;
import com.boan.crm.datadictionary.model.DataDictionary;
import com.boan.crm.utils.dao.impl.BaseDao;

/**
 * @author leon
 * @version 1.0.0
 */
@Repository("dataDictionaryDao")
public class DataDictionaryDaoImpl extends BaseDao<DataDictionary, String>
		implements IDataDictionaryDao {
}

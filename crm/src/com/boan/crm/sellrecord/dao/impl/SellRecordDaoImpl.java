package com.boan.crm.sellrecord.dao.impl;

import org.springframework.stereotype.Repository;

import com.boan.crm.sellrecord.dao.ISellRecordDao;
import com.boan.crm.sellrecord.model.SellRecord;
import com.boan.crm.utils.dao.impl.BaseDao;

@Repository("sellRecordDao")
public class SellRecordDaoImpl extends BaseDao<SellRecord, String> implements ISellRecordDao {

}

package com.boan.crm.sellreport.monthly.dao.impl;

import org.springframework.stereotype.Repository;

import com.boan.crm.sellreport.monthly.dao.IMonthlyMainInfoDao;
import com.boan.crm.sellreport.monthly.model.MonthlyMainInfo;
import com.boan.crm.utils.dao.impl.BaseDao;

@Repository("monthlyMainInfoDao")
public class MonthlyMainInfoDaoImpl extends BaseDao<MonthlyMainInfo, String> implements IMonthlyMainInfoDao{

}

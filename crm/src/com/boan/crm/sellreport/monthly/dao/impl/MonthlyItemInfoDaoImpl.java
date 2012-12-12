package com.boan.crm.sellreport.monthly.dao.impl;

import org.springframework.stereotype.Repository;

import com.boan.crm.sellreport.monthly.dao.IMonthlyItemInfoDao;
import com.boan.crm.sellreport.monthly.model.MonthlyItemInfo;
import com.boan.crm.utils.dao.impl.BaseDao;

@Repository("monthlyItemInfoDao")
public class MonthlyItemInfoDaoImpl extends BaseDao<MonthlyItemInfo, String>  implements IMonthlyItemInfoDao{

}

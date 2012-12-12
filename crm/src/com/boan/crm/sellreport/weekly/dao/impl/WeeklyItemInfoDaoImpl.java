package com.boan.crm.sellreport.weekly.dao.impl;

import org.springframework.stereotype.Repository;

import com.boan.crm.sellreport.weekly.dao.IWeeklyItemInfoDao;
import com.boan.crm.sellreport.weekly.model.WeeklyItemInfo;
import com.boan.crm.utils.dao.impl.BaseDao;

@Repository("weeklyItemInfoDao")
public class WeeklyItemInfoDaoImpl extends BaseDao<WeeklyItemInfo, String>  implements IWeeklyItemInfoDao{

}

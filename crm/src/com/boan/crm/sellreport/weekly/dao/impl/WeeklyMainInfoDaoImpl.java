package com.boan.crm.sellreport.weekly.dao.impl;

import org.springframework.stereotype.Repository;

import com.boan.crm.sellreport.weekly.dao.IWeeklyMainInfoDao;
import com.boan.crm.sellreport.weekly.model.WeeklyMainInfo;
import com.boan.crm.utils.dao.impl.BaseDao;

@Repository("weeklyMainInfoDao")
public class WeeklyMainInfoDaoImpl extends BaseDao<WeeklyMainInfo, String> implements IWeeklyMainInfoDao{

}

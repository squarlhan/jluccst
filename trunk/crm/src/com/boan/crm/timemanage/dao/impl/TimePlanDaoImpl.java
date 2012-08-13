package com.boan.crm.timemanage.dao.impl;

import org.springframework.stereotype.Repository;

import com.boan.crm.timemanage.dao.ITimePlanDao;
import com.boan.crm.timemanage.model.TimePlan;
import com.boan.crm.utils.dao.impl.BaseDao;

/**
 * 时间管理数据库操作接口
 * @author YF
 *
 */
@Repository("timePlanDao")
public class TimePlanDaoImpl  extends BaseDao<TimePlan, String> implements ITimePlanDao {

}

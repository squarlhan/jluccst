package com.boan.crm.sellreport.sellduty.dao.impl;

import org.springframework.stereotype.Repository;

import com.boan.crm.sellreport.sellduty.dao.ISellDutyDao;
import com.boan.crm.sellreport.sellduty.model.SellDuty;
import com.boan.crm.utils.dao.impl.BaseDao;

/**
 * @author YF
 *
 */
@Repository("sellDutyDao")
public class SellDutyDaoImpl extends BaseDao<SellDuty, String> implements ISellDutyDao {

}

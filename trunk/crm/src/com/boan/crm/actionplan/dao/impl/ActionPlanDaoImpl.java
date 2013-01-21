package com.boan.crm.actionplan.dao.impl;

import org.springframework.stereotype.Repository;

import com.boan.crm.actionplan.dao.IActionPlanDao;
import com.boan.crm.actionplan.model.ActionPlan;
import com.boan.crm.utils.dao.impl.BaseDao;

@Repository("actionPlanDao")
public class ActionPlanDaoImpl  extends BaseDao<ActionPlan, String> implements IActionPlanDao {

}

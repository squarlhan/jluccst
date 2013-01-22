package com.boan.crm.actionplan.service;

import java.util.Map;

import com.boan.crm.actionplan.model.ActionPlan;
import com.boan.crm.utils.page.Pagination;

public interface IActionPlanService {
	/**
	 * 保存或修改行动计划
	 * @param ActionPlan
	 */
	public void saveOrUpdateActionPlan(ActionPlan actionPlan);
	
	 /**
	  * 通过Id删除行动计划
	  * @param id
	  */
	public void deleteActionPlan(String... id);
	
	/**
	 * 通过id查询行动计划
	 * @param id
	 */
	public ActionPlan getActionPlanById(String id);
	
	/**
	 * 按分页查询行动计划
	 */
	public Pagination<ActionPlan> findActionPlanForPage( Map<String, ?> values, Pagination<ActionPlan> pagination);
}

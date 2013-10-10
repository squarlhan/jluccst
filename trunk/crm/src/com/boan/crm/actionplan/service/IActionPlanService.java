package com.boan.crm.actionplan.service;

import java.util.Calendar;
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
	 * 保存或修改行动计划,用于跟进/回访信息的保存
	 * @param trackOrVisitId 跟进/回访Id
	 * @param planOrSummarizeInfo 要保存到行动计划中的计划或总结信息
	 * @param companyId 当前公司Id 
	 * @param employeeId 当前业务员Id 
	 * @param employeeName  当前业务员名称
	 * @param deptId 当前业务员部门Id
	 * @param deptName 当前业务员部门名称
	 * @param infoType 信息类型（3：跟进  4：回访）
	 * @param submitTime 提交时间
	 */
	public void saveOrUpdateActionPlan(String trackOrVisitId ,String planOrSummarizeInfo , String companyId ,String employeeId,String employeeName , String deptId, String deptName,String infoType ,Calendar submitTime);
	
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

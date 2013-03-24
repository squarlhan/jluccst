package com.boan.crm.timemanage.service;

import java.util.Map;

import com.boan.crm.timemanage.model.TimePlan;
import com.boan.crm.utils.page.Pagination;

public interface ITimePlanService {

	/**
	 * 保存或修改时间计划
	 * @param timePlan
	 */
	public void saveOrUpdateTimePlan(TimePlan timePlan);
	
	 /**
	  * 通过Id删除时间计划
	  * @param id
	  */
	public void deleteTimePlan(String... id);
	
	/**
	 * 通过id查询时间计划
	 * @param id
	 */
	public TimePlan getTimePlanById(String id);
	
	/**
	 * 按分页查询时间计划
	 */
	public Pagination<TimePlan> findTimePlanForPage( Map<String, ?> values, Pagination<TimePlan> pagination);
	
	
	/**
	 * 获取最近的时间计划
	 * @param id
	 */
	public TimePlan getLastTimePlan(Map<String, ?> params);
}

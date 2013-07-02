package com.boan.crm.timemanage.service;

import java.util.List;
import java.util.Map;

import com.boan.crm.timemanage.model.TimePlan;
import com.boan.crm.timemanage.model.TimePlanAndTrackOrVisitRelation;
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
	
	/**
	 * 按条件查询时间计划
	 */
	public List<TimePlan> findTimePlan( Map<String, ?> values);
	
	/**
	 * 判断根据计划的内容类型，将信息添加到对应属性中保存，flag：0,info保存到明日计划中， flag：1 info保存到今日总结中
	 * @param timePlan 时间计划对象
	 * @param flag 0:明日计划  1：今日总结
	 * @param info 存入的具体信息，要存入时间计划对象的那个planContent属性还是memo属性中以flag为准
	 * @param trackOrVisitId 跟踪或回访Id
	 */
	public void saveOrUpdateTimePlan(TimePlan timePlan , int flag ,String info,String trackOrVisitId);
	
	/**
	 * 根据跟踪或回访Id查询是否有对应的时间计划信息
	 * @param trackOrVisitId
	 * @return
	 */
	public boolean hasTimePlanForTrackOrVisit(String trackOrVisitId);
	/**
	 * 根据跟踪或回访Id查询是否有对应的时间计划信息
	 * @param trackOrVisitId
	 * @return
	 */
	public TimePlanAndTrackOrVisitRelation getTimePlanForTrackOrVisit(String trackOrVisitId);
}

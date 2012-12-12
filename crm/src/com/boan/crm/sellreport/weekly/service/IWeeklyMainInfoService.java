package com.boan.crm.sellreport.weekly.service;

import java.util.List;
import java.util.Map;

import com.boan.crm.sellreport.weekly.model.WeeklyMainInfo;
import com.boan.crm.utils.page.Pagination;

public interface IWeeklyMainInfoService {

	/**
	 * 保存或修改周计划信息
	 * @param obj
	 */
	public void saveOrUpdateWeeklyMainInfo(WeeklyMainInfo obj);
	
	/**
	 * 根据周计划Id查询周计划信息
	 * @param id
	 * @return
	 */
	public WeeklyMainInfo getWeeklyMainInfoById(String id);
	
	/**
	 * 根据计划人Id查询周计划信息
	 * @param personId
	 * @return
	 */
	public List<WeeklyMainInfo>  getWeeklyMainInfoListByPersonId(String personId);
	
	/**
	 * 按分页查询周计划信息
	 */
	public Pagination<WeeklyMainInfo> findWeeklyMainInfoForPage( Map<String, ?> values, Pagination<WeeklyMainInfo> pagination);
	
	 /**
	  * 通过Id删除周计划信息
	  * @param id
	  */
	public void deleteWeeklyMainInfoByIds(String... ids);
}

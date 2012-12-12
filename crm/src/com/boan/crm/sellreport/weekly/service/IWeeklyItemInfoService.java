package com.boan.crm.sellreport.weekly.service;

import java.util.List;
import java.util.Map;

import com.boan.crm.sellreport.weekly.model.WeeklyItemInfo;
import com.boan.crm.utils.page.Pagination;

public interface IWeeklyItemInfoService {

	/**
	 * 保存或修改周计划项信息
	 * @param obj
	 */
	public void saveOrUpdateWeeklyItemInfo(WeeklyItemInfo obj);
	
	/**
	 * 根据周计划项Id查询周计划项信息
	 * @param id
	 * @return
	 */
	public WeeklyItemInfo getWeeklyItemInfoById(String id);
	
	 /**
	  * 通过Id删除周计划项信息
	  * @param id
	  */
	public void deleteWeeklyItemInfoByIds(String... id);
	
	/**
	 * 根据计划人Id查询周计划项信息
	 * @param mainInfoId
	 * @return
	 */
	public List<WeeklyItemInfo>  getWeeklyItemInfoListByMainInfoId(String mainInfoId);
	
	/**
	 * 按分页查询周计划项信息
	 */
	public Pagination<WeeklyItemInfo> findWeeklyItemInfoForPage( Map<String, ?> values, Pagination<WeeklyItemInfo> pagination);
}

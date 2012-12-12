package com.boan.crm.sellreport.monthly.service;

import java.util.List;
import java.util.Map;

import com.boan.crm.sellreport.monthly.model.MonthlyItemInfo;
import com.boan.crm.sellreport.monthly.model.MonthlyMainInfo;
import com.boan.crm.utils.page.Pagination;

public interface IMonthlyMainInfoService {

	/**
	 * 保存或修改月计划信息
	 * @param obj
	 */
	public void saveOrUpdateMonthlyMainInfo(MonthlyMainInfo obj);
	
	/**
	 * 根据月计划Id查询月计划信息
	 * @param id
	 * @return
	 */
	public MonthlyMainInfo getMonthlyMainInfoById(String id);
	
	/**
	 * 根据计划人Id查询月计划信息
	 * @param personId
	 * @return
	 */
	public List<MonthlyMainInfo>  getMonthlyMainInfoListByPersonId(String personId);
	
	/**
	 * 按分页查询月计划信息
	 */
	public Pagination<MonthlyMainInfo> findMonthlyMainInfoForPage( Map<String, ?> values, Pagination<MonthlyMainInfo> pagination);
	
	 /**
	  * 通过Id删除月计划信息
	  * @param id
	  */
	public void deleteMonthlyMainInfoByIds(String... ids);
}

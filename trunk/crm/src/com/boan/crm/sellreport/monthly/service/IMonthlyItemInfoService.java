package com.boan.crm.sellreport.monthly.service;

import java.util.List;
import java.util.Map;

import com.boan.crm.sellreport.monthly.model.MonthlyItemInfo;
import com.boan.crm.utils.page.Pagination;

public interface IMonthlyItemInfoService {

	/**
	 * 保存或修改月计划项信息
	 * @param obj
	 */
	public void saveOrUpdateMonthlyItemInfo(MonthlyItemInfo obj);
	
	/**
	 * 根据月计划项Id查询月计划项信息
	 * @param id
	 * @return
	 */
	public MonthlyItemInfo getMonthlyItemInfoById(String id);
	
	 /**
	  * 通过Id删除月计划项信息
	  * @param id
	  */
	public void deleteMonthlyItemInfoByIds(String... id);
	
	/**
	 * 根据计划人Id查询月计划项信息
	 * @param mainInfoId
	 * @return
	 */
	public List<MonthlyItemInfo>  getMonthlyItemInfoListByMainInfoId(String mainInfoId);
	
	/**
	 * 按分页查询月计划项信息
	 */
	public Pagination<MonthlyItemInfo> findMonthlyItemInfoForPage( Map<String, ?> values, Pagination<MonthlyItemInfo> pagination);
	
	/**
	 * 根据月计划Id查询月计划项中销售额的信息
	 * @param mainInfoId
	 * @return
	 */
	public List<MonthlyItemInfo>  getMonthlyItemInfoListOfSellTargetByMainInfoId(String mainInfoId);
	
	/**
	 *查询最近月计划项信息
	 * @param 
	 * @return
	 */
	public MonthlyItemInfo getLastMonthlyItemInfo( Map<String, ?> params);
}

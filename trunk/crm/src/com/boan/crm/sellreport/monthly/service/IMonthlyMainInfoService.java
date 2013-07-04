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
	
	/**
	 *查询最近月计划项信息
	 * @param 
	 * @return
	 */
	public MonthlyMainInfo getLastMonthlyMainInfo(Map<String, ?> params);
	
	/**
	 * 查询指定年、月的最后填写的月计划信息
	 * @param companyId 所属单位
	 * @param deptId 所属部门
	 * @param personId 计划填写人
	 * @param year 年份
	 * @param month 月份
	 * @param roleKey 角色关键字
	 * @return
	 */
	public MonthlyMainInfo getMonthlyMainInfoByMonth(String companyId, String deptId,String personId ,  int year , int month , String roleKey);
}

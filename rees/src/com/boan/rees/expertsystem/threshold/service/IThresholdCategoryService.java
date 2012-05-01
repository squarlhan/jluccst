/*
 * @(#)IThresholdCategoryService.java 1.1 2012-4-29
 */

package com.boan.rees.expertsystem.threshold.service;

import java.util.List;
import java.util.Map;

import com.boan.rees.device.type.model.DeviceType;
import com.boan.rees.expertsystem.threshold.model.ThresholdCategory;
import com.boan.rees.utils.page.Pagination;

/**
 * 阈值类别服务接口
 * @author ZhuYF
 * @version 1.0.0
 */
public interface IThresholdCategoryService {
	/**
	 * 保存阈值项类别信息
	 * @param obj
	 * @return
	 */
	public boolean saveThresholdCategory(ThresholdCategory obj);
	
	/**
	 * 修改阈值项类别信息
	 * @param obj
	 * @return
	 */
	public boolean updateThresholdCategory(ThresholdCategory obj);
	
	/**
	 * 保存/修改 阈值项类别信息
	 * @param obj
	 * @return
	 */
	public boolean saveOrUpdateThresholdCategory(ThresholdCategory obj);
	
	/**
	 * 删除阈值项类别信息
	 * @param obj
	 * @return
	 */
	public boolean deleteThresholdCategory(ThresholdCategory obj);
	
	/**
	 * 删除阈值项类别信息
	 * @param obj
	 * @return
	 */
	public boolean deleteThresholdCategoryByIds(String... ids);
	
	/**
	 * 级联删除阈值类别及阈值信息
	 * @param obj
	 * @return
	 */
//	public boolean cascadeDeleteThresholdCategoryByIds(String... ids);
	
	/**
	 * 通过Id获取阈值项类别
	 * @param id
	 * @return
	 */
	public ThresholdCategory getThresholdCategoryById(String id);
	
	/**
	 * 获取所有阈值项类别
	 * @return
	 */
	public List<ThresholdCategory> queryAllThresholdCategory();
	
	/**
	 * 根据阈值项类别名称获取阈值项类别信息
	 * @param name
	 * @return
	 */
	public ThresholdCategory queryThresholdCategoryByName(String name);
	
	/**
	 * 分页查询阈值类别
	 * @param values 查询参数
	 * @param pagination 分页对象
	 * @return
	 */
	public Pagination<ThresholdCategory> findThresholdCategoryForPage(Map<String, ?> values,Pagination<ThresholdCategory> pagination);
	
	/**
	 * 判断指定Id的阈值类别是否存在指定属性和属性值的记录
	 * @param id Id
	 * @param propertyName 属性
	 * @param propertyValue 属性值
	 * @return true：存在 false：不存在
	 */
   public boolean isExistThresholdCategory(String id, String propertyName,String propertyValue);
}


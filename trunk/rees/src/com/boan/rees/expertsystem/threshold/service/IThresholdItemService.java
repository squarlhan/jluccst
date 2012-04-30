/*
 * @(#)IThresholdItemService.java 1.1 2012-4-29
 */

package com.boan.rees.expertsystem.threshold.service;

import java.util.List;
import java.util.Map;

import com.boan.rees.expertsystem.threshold.model.ThresholdItem;
import com.boan.rees.utils.page.Pagination;

/**
 * 阈值项服务接口
 * @author ZhuYF
 * @version 1.0.0
 */
public interface IThresholdItemService {
	/**
	 * 保存阈值项信息
	 * @param obj
	 * @return
	 */
	public boolean saveThresholdItem(ThresholdItem obj);
	
	/**
	 * 修改阈值项信息
	 * @param obj
	 * @return
	 */
	public boolean updateThresholdItem(ThresholdItem obj);
	
	/**
	 * 保存/修改 阈值项信息
	 * @param obj
	 * @return
	 */
	public boolean saveOrUpdateThresholdItem(ThresholdItem obj);
	
	/**
	 * 删除阈值项信息
	 * @param obj
	 * @return
	 */
	public boolean deleteThresholdItem(ThresholdItem obj);
	
	/**
	 * 删除阈值项信息
	 * @param obj
	 * @return
	 */
	public boolean deleteThresholdItemByIds(String... ids);
	
	/**
	 * 通过Id获取阈值项
	 * @param id
	 * @return
	 */
	public ThresholdItem getThresholdItemById(String id);
	
	/**
	 * 获取所有阈值项
	 * @return
	 */
	public List<ThresholdItem> queryAllThresholdItem();
	
	/**
	 * 根据阈值项名称获取阈值项信息
	 * @param name
	 * @return
	 */
	public ThresholdItem queryThresholdItemByName(String name);
	
	/**
	 * 分页查询阈值项
	 * @param values 查询参数
	 * @param pagination 分页对象
	 * @return
	 */
	public Pagination<ThresholdItem> findThresholdItemForPage(Map<String, ?> values,Pagination<ThresholdItem> pagination);
	
	/**
	 * 判断指定Id的阈值项是否存在指定属性和属性值的记录
	 * @param id Id
	 * @param propertyName 属性
	 * @param propertyValue 属性值
	 * @return true：存在 false：不存在
	 */
   public boolean isExistThresholdItem(String id, String propertyName,String propertyValue);
}


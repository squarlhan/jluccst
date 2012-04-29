/*
 * @(#)IThresholdService.java 1.1 2012-4-27
 */

package com.boan.rees.expertsystem.threshold.service;

import java.util.List;
import java.util.Map;

import com.boan.rees.expertsystem.threshold.model.Threshold;
import com.boan.rees.expertsystem.threshold.model.ThresholdCategory;
import com.boan.rees.expertsystem.threshold.model.ThresholdItem;
import com.boan.rees.utils.page.Pagination;


/**
 * 阈值服务接口
 * @author ZhuYF
 * @version 1.0.0
 */
public interface IThresholdService {

	/**
	 * 保存阈值信息
	 * @param obj
	 * @return
	 */
	public boolean saveThreshold(Threshold obj);
	
	/**
	 * 修改阈值信息
	 * @param obj
	 * @return
	 */
	public boolean updateThreshold(Threshold obj);
	
	/**
	 * 保存/修改 阈值信息
	 * @param obj
	 * @return
	 */
	public boolean saveOrUpdateThreshold(Threshold obj);
	
	/**
	 * 删除阈值信息
	 * @param obj
	 * @return
	 */
	public boolean deleteThreshold(Threshold obj);
	
	/**
	 * 删除阈值信息
	 * @param obj
	 * @return
	 */
	public boolean deleteThresholdByIds(String... ids);
	
	/**
	 * 级联删除阈值及阈值项信息
	 * @param obj
	 * @return
	 */
	public boolean cascadeDeleteThresholdByIds(String... ids);
	
	/**
	 * 通过Id获取阈值
	 * @param id
	 * @return
	 */
	public Threshold getThresholdById(String id);
	
	/**
	 * 获取所有阈值
	 * @return
	 */
	public List<Threshold> queryAllThreshold();
	
	/**
	 * 根据阈值名称获取阈值信息
	 * @param name
	 * @return
	 */
	public Threshold queryThresholdByName(String name);
	
	/**
	 * 分页查询阈值
	 * @param values 查询参数
	 * @param pagination 分页对象
	 * @return
	 */
	public Pagination<Threshold> findThresholdForPage(Map<String, ?> values,Pagination<Threshold> pagination);
	
	/**
	 * 判断指定Id的阈值是否存在指定属性和属性值的记录
	 * @param id Id
	 * @param propertyName 属性
	 * @param propertyValue 属性值
	 * @return true：存在 false：不存在
	 */
   public boolean isExistThreshold(String id, String propertyName,String propertyValue);
   
   /**
	 * 根据中心高和转速获取阈值
	 * @param centerHeight 中心高
	 * @param speed 转速
	 * @return 包含阈值项的阈值对象
	 */
	public Threshold getThresholdByCenterHeightAndSpeed(String centerHeight,String speed);
}


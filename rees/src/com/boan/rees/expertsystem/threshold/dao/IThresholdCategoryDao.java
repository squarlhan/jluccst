/*
 * @(#)IThresholdDao.java 1.1 2012-4-27
 */

package com.boan.rees.expertsystem.threshold.dao;

import java.util.List;

import com.boan.rees.expertsystem.threshold.model.ThresholdCategory;
import com.boan.rees.utils.dao.IBaseDao;


/**
 * 阈值类别数据库DAO操作接口
 * @author ZhuYF
 * @version 1.0.0
 */
public interface IThresholdCategoryDao extends IBaseDao<ThresholdCategory, Integer> {

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
	public boolean cascadeDeleteThresholdCategoryByIds(String... ids);
	
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
}


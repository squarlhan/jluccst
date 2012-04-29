/*
 * @(#)ThresholdCategoryServiceImpl.java 1.1 2012-4-29
 */

package com.boan.rees.expertsystem.threshold.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.boan.rees.expertsystem.threshold.dao.IThresholdCategoryDao;
import com.boan.rees.expertsystem.threshold.model.ThresholdCategory;

/**
 * 阈值类别服务接口实现
 * @author ZhuYF
 * @version 1.0.0
 */
public class ThresholdCategoryServiceImpl {
	
	@Autowired
	@Qualifier("thresholdCategoryDao")
	private IThresholdCategoryDao dao;
	
	/**
	 * 保存阈值项类别信息
	 * @param obj
	 * @return
	 */
	public boolean saveThresholdCategory(ThresholdCategory obj){
		return dao.saveThresholdCategory(obj);
	}
	
	/**
	 * 修改阈值项类别信息
	 * @param obj
	 * @return
	 */
	public boolean updateThresholdCategory(ThresholdCategory obj){
		return dao.updateThresholdCategory(obj);
	}
	
	/**
	 * 保存/修改 阈值项类别信息
	 * @param obj
	 * @return
	 */
	public boolean saveOrUpdateThresholdCategory(ThresholdCategory obj){
		return dao.saveOrUpdateThresholdCategory(obj);
	}
	
	/**
	 * 删除阈值项类别信息
	 * @param obj
	 * @return
	 */
	public boolean deleteThresholdCategory(ThresholdCategory obj){
		return dao.deleteThresholdCategory(obj);
	}
	
	/**
	 * 删除阈值项类别信息
	 * @param obj
	 * @return
	 */
	public boolean deleteThresholdCategoryByIds(String... ids){
		return dao.deleteThresholdCategoryByIds(ids);
	}
	
	/**
	 * 级联删除阈值类别及阈值信息
	 * @param obj
	 * @return
	 */
	public boolean cascadeDeleteThresholdCategoryByIds(String... ids){
		return dao.cascadeDeleteThresholdCategoryByIds(ids);
	}
	
	/**
	 * 通过Id获取阈值项类别
	 * @param id
	 * @return
	 */
	public ThresholdCategory getThresholdCategoryById(String id){
		return dao.getThresholdCategoryById(id);
	}
	
	/**
	 * 获取所有阈值项类别
	 * @return
	 */
	public List<ThresholdCategory> queryAllThresholdCategory(){
		return dao.queryAllThresholdCategory();
	}
	
	/**
	 * 根据阈值项类别名称获取阈值项类别信息
	 * @param name
	 * @return
	 */
	public ThresholdCategory queryThresholdCategoryByName(String name){
		return dao.queryThresholdCategoryByName(name);
	}
}


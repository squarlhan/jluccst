/*
 * @(#)IThresholdDao.java 1.1 2012-4-27
 */

package com.boan.rees.expertsystem.threshold.dao;

import java.util.List;

import com.boan.rees.expertsystem.threshold.Threshold;
import com.boan.rees.expertsystem.threshold.ThresholdItem;
import com.boan.rees.utils.dao.IBaseDao;


/**
 * 阈值数据库DAO操作接口
 * @author ZhuYF
 * @version 1.0.0
 */
public interface IThresholdDao extends IBaseDao<Threshold, Integer> {

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
}


/*
 * @(#)IThresholdDao.java 1.1 2012-4-27
 */

package com.boan.rees.expertsystem.threshold.dao;

import java.util.List;

import com.boan.rees.expertsystem.threshold.ThresholdItem;
import com.boan.rees.utils.dao.IBaseDao;


/**
 * 阈值项数据库DAO操作接口
 * @author ZhuYF
 * @version 1.0.0
 */
public interface IThresholdItemDao extends IBaseDao<ThresholdItem, Integer> {

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
}

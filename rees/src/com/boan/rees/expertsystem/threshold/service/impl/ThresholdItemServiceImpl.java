/*
 * @(#)ThresholdItemServiceImpl.java 1.1 2012-4-29
 */

package com.boan.rees.expertsystem.threshold.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.boan.rees.expertsystem.threshold.dao.IThresholdItemDao;
import com.boan.rees.expertsystem.threshold.model.ThresholdItem;
import com.boan.rees.expertsystem.threshold.service.IThresholdItemService;

/**
 * 阈值项服务接口实现
 * @author ZhuYF
 * @version 1.0.0
 */
public class ThresholdItemServiceImpl implements IThresholdItemService{
	
	@Autowired
	@Qualifier("thresholdItemDao")
	private IThresholdItemDao dao;
	
	/**
	 * 保存阈值项信息
	 * @param obj
	 * @return
	 */
	public boolean saveThresholdItem(ThresholdItem obj){
		return dao.saveThresholdItem(obj);
	}
	
	/**
	 * 修改阈值项信息
	 * @param obj
	 * @return
	 */
	public boolean updateThresholdItem(ThresholdItem obj){
		return dao.updateThresholdItem(obj);
	}
	
	/**
	 * 保存/修改 阈值项信息
	 * @param obj
	 * @return
	 */
	public boolean saveOrUpdateThresholdItem(ThresholdItem obj){
		return dao.saveOrUpdateThresholdItem(obj);
	}
	
	/**
	 * 删除阈值项信息
	 * @param obj
	 * @return
	 */
	public boolean deleteThresholdItem(ThresholdItem obj){
		return dao.deleteThresholdItem(obj);
	}
	
	/**
	 * 删除阈值项信息
	 * @param obj
	 * @return
	 */
	public boolean deleteThresholdItemByIds(String... ids){
		return dao.deleteThresholdItemByIds(ids);
	}
	
	/**
	 * 通过Id获取阈值项
	 * @param id
	 * @return
	 */
	public ThresholdItem getThresholdItemById(String id){
		return dao.getThresholdItemById(id);
	}
	
	/**
	 * 获取所有阈值项
	 * @return
	 */
	public List<ThresholdItem> queryAllThresholdItem(){
		return dao.queryAllThresholdItem();
	}
	
	/**
	 * 根据阈值项名称获取阈值项信息
	 * @param name
	 * @return
	 */
	public ThresholdItem queryThresholdItemByName(String name){
		return dao.queryThresholdItemByName(name);
	}
}


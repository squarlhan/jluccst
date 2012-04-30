/*
 * @(#)ThresholdItemDaoImpl.java 1.1 2012-4-27
 */

package com.boan.rees.expertsystem.threshold.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.boan.rees.expertsystem.threshold.dao.IThresholdItemDao;
import com.boan.rees.expertsystem.threshold.model.ThresholdItem;
import com.boan.rees.utils.dao.impl.BaseDao;

/**
 * 阈值项项数据库DAO操作接口实现
 * @author ZhuYF
 * @version 1.0.0
 */
@Repository("thresholdItemDao")
public class ThresholdItemDaoImpl  extends BaseDao<ThresholdItem, Integer> implements IThresholdItemDao{

	/**
	 * 保存阈值项信息
	 * @param obj
	 * @return
	 */
	public boolean saveThresholdItem(ThresholdItem obj){
		try {
			this.save(obj);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * 修改阈值项信息
	 * @param obj
	 * @return
	 */
	public boolean updateThresholdItem(ThresholdItem obj){
		try {
			this.update(obj);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * 保存/修改 阈值项信息
	 * @param obj
	 * @return
	 */
	public boolean saveOrUpdateThresholdItem(ThresholdItem obj){
		try {
			this.saveOrUpdate(obj);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * 删除阈值项信息
	 * @param obj
	 * @return
	 */
	public boolean deleteThresholdItem(ThresholdItem obj){
		try {
			if(obj!=null){
				this.delete(obj);
				return true;
			}else{
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * 删除阈值项信息
	 * @param obj
	 * @return
	 */
	public boolean deleteThresholdItemByIds(String... ids){
		try {
			Integer[] id = new Integer[ids.length];
			for(int i=0;i<ids.length;i++){
				id[i]=Integer.parseInt(ids[i]);
			}
			this.delete(id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	
	/**
	 * 通过Id获取阈值项
	 * @param id
	 * @return
	 */
	public ThresholdItem getThresholdItemById(String id){
		Integer i = new Integer(id);
		return this.get(i);
	}
	
	/**
	 * 获取所有阈值项
	 * @return
	 */
	public List<ThresholdItem> queryAllThresholdItem(){
		return this.findAll();
	}
	
	/**
	 * 根据阈值项名称获取阈值项信息
	 * @param name
	 * @return
	 */
	public ThresholdItem queryThresholdItemByName(String name){
		List<ThresholdItem> list = this.findByProperty("ThresholdItemName", name);
		return list!=null && list.size()>0 ? list.get(0) : null;
	}
}


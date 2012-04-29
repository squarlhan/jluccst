/*
 * @(#)ThresholdCategoryDaoImpl.java 1.1 2012-4-27
 */

package com.boan.rees.expertsystem.threshold.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.boan.rees.expertsystem.threshold.ThresholdCategory;
import com.boan.rees.expertsystem.threshold.dao.IThresholdCategoryDao;
import com.boan.rees.utils.dao.impl.BaseDao;

/**
 * 阈值项类别数据库DAO操作接口实现
 * @author ZhuYF
 * @version 1.0.0
 */
@Repository("thresholdCategoryDao")
public class ThresholdCategoryDaoImpl  extends BaseDao<ThresholdCategory, Integer> implements IThresholdCategoryDao{

	/**
	 * 保存阈值项类别信息
	 * @param obj
	 * @return
	 */
	public boolean saveThresholdCategory(ThresholdCategory obj){
		try {
			this.save(obj);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * 修改阈值项类别信息
	 * @param obj
	 * @return
	 */
	public boolean updateThresholdCategory(ThresholdCategory obj){
		try {
			this.update(obj);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * 保存/修改 阈值项类别信息
	 * @param obj
	 * @return
	 */
	public boolean saveOrUpdateThresholdCategory(ThresholdCategory obj){
		try {
			this.saveOrUpdate(obj);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * 删除阈值项类别信息
	 * @param obj
	 * @return
	 */
	public boolean deleteThresholdCategory(ThresholdCategory obj){
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
	 * 删除阈值项类别信息
	 * @param obj
	 * @return
	 */
	public boolean deleteThresholdCategoryByIds(String... ids){
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
	 * 级联删除阈值类别及阈值信息
	 * @param obj
	 * @return
	 */
	public boolean cascadeDeleteThresholdCategoryByIds(String... ids){
		try {
			for(String id : ids){
				ThresholdCategory obj = this.getThresholdCategoryById(id);
				this.deleteThresholdCategory(obj);
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * 通过Id获取阈值项类别
	 * @param id
	 * @return
	 */
	public ThresholdCategory getThresholdCategoryById(String id){
		Integer i = new Integer(id);
		return this.get(i);
	}
	
	/**
	 * 获取所有阈值项类别
	 * @return
	 */
	public List<ThresholdCategory> queryAllThresholdCategory(){
		return this.findAll();
	}
	
	/**
	 * 根据阈值项类别名称获取阈值项类别信息
	 * @param name
	 * @return
	 */
	public ThresholdCategory queryThresholdCategoryByName(String name){
		List<ThresholdCategory> list = this.findByProperty("categoryName", name);
		return list!=null && list.size()>0 ? list.get(0) : null;
	}
}


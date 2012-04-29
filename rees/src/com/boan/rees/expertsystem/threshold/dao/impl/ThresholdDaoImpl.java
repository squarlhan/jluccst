/*
 * @(#)ThresholdDaoImpl.java 1.1 2012-4-27
 */

package com.boan.rees.expertsystem.threshold.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.boan.rees.expertsystem.threshold.Threshold;
import com.boan.rees.expertsystem.threshold.dao.IThresholdDao;
import com.boan.rees.utils.dao.impl.BaseDao;

/**
 * 阈值项数据库DAO操作接口实现
 * @author ZhuYF
 * @version 1.0.0
 */
@Repository("thresholdDao")
public class ThresholdDaoImpl  extends BaseDao<Threshold, Integer> implements IThresholdDao{

	/**
	 * 保存阈值信息
	 * @param obj
	 * @return
	 */
	public boolean saveThreshold(Threshold obj){
		try {
			this.save(obj);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * 修改阈值信息
	 * @param obj
	 * @return
	 */
	public boolean updateThreshold(Threshold obj){
		try {
			this.update(obj);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * 保存/修改 阈值信息
	 * @param obj
	 * @return
	 */
	public boolean saveOrUpdateThreshold(Threshold obj){
		try {
			this.saveOrUpdate(obj);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * 删除阈值信息
	 * @param obj
	 * @return
	 */
	public boolean deleteThreshold(Threshold obj){
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
	 * 删除阈值信息
	 * @param obj
	 * @return
	 */
	public boolean deleteThresholdByIds(String... ids){
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
	 * 级联删除阈值及阈值项信息
	 * @param obj
	 * @return
	 */
	public boolean cascadeDeleteThresholdByIds(String... ids){
		try {
			for(String id : ids){
				Threshold obj = this.getThresholdById(id);
				this.deleteThreshold(obj);
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * 通过Id获取阈值
	 * @param id
	 * @return
	 */
	public Threshold getThresholdById(String id){
		Integer i = new Integer(id);
		return this.get(i);
	}
	
	/**
	 * 获取所有阈值
	 * @return
	 */
	public List<Threshold> queryAllThreshold(){
		return this.findAll();
	}
	
	/**
	 * 根据阈值名称获取阈值信息
	 * @param name
	 * @return
	 */
	public Threshold queryThresholdByName(String name){
		List<Threshold> list = this.findByProperty("thresholdName", name);
		return list!=null && list.size()>0 ? list.get(0) : null;
	}
}


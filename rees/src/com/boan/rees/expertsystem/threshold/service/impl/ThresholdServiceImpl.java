/*
 * @(#)ThresholdServiceImpl.java 1.1 2012-4-27
 */

package com.boan.rees.expertsystem.threshold.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.boan.rees.expertsystem.threshold.Threshold;
import com.boan.rees.expertsystem.threshold.ThresholdItem;
import com.boan.rees.expertsystem.threshold.dao.IThresholdDao;
import com.boan.rees.expertsystem.threshold.service.IThresholdService;

/**
 * 阈值服务接口实现
 * @author ZhuYF
 * @version 1.0.0
 */
@Service("thresholdService")
public class ThresholdServiceImpl implements IThresholdService {
	
	@Autowired
	@Qualifier("thresholdDao")
	private IThresholdDao dao;
	/**
	 * 保存阈值信息
	 * @param obj
	 * @return
	 */
	public boolean saveThreshold(Threshold obj){
		 return dao.saveThreshold(obj);
	}
	
	/**
	 * 修改阈值信息
	 * @param obj
	 * @return
	 */
	public boolean updateThreshold(Threshold obj){
		 return dao.updateThreshold(obj);
	}
	
	/**
	 * 保存/修改 阈值信息
	 * @param obj
	 * @return
	 */
	public boolean saveOrUpdateThreshold(Threshold obj){
		 return dao.saveOrUpdateThreshold(obj);
	}
	
	/**
	 * 删除阈值信息
	 * @param obj
	 * @return
	 */
	public boolean deleteThreshold(Threshold obj){
		return dao.deleteThreshold(obj);
	}
	
	/**
	 * 删除阈值信息
	 * @param obj
	 * @return
	 */
	public boolean deleteThresholdByIds(String... ids){
		return dao.deleteThresholdByIds(ids);
	}
	
	/**
	 * 级联删除阈值及阈值项信息
	 * @param obj
	 * @return
	 */
	public boolean cascadeDeleteThresholdByIds(String... ids){
		return dao.cascadeDeleteThresholdByIds(ids);
	}
	
	/**
	 * 通过Id获取阈值
	 * @param id
	 * @return
	 */
	public Threshold getThresholdById(String id){
		return dao.getThresholdById(id);
	}
	
	/**
	 * 获取所有阈值
	 * @return
	 */
	public List<Threshold> queryAllThreshold(){
		return dao.queryAllThreshold();
	}
	
	/**
	 * 根据阈值名称获取阈值信息
	 * @param name
	 * @return
	 */
	public Threshold queryThresholdByName(String name){
		return dao.queryThresholdByName(name);
	}
	
	/**
	 * 根据中心高和转速获取阈值
	 * @param centerHeight 中心高
	 * @param speed 转速
	 * @return 包含阈值项的阈值对象
	 */
	public Threshold getThresholdByCenterHeightAndSpeed(String centerHeight,String speed){
		return null;
	}
}


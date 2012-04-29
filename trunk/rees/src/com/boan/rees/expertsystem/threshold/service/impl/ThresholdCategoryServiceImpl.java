/*
 * @(#)ThresholdCategoryServiceImpl.java 1.1 2012-4-29
 */

package com.boan.rees.expertsystem.threshold.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.boan.rees.device.type.model.DeviceType;
import com.boan.rees.expertsystem.threshold.dao.IThresholdCategoryDao;
import com.boan.rees.expertsystem.threshold.model.ThresholdCategory;
import com.boan.rees.expertsystem.threshold.service.IThresholdCategoryService;
import com.boan.rees.utils.page.Pagination;

/**
 * 阈值类别服务接口实现
 * @author ZhuYF
 * @version 1.0.0
 */
@Service("thresholdCategoryService")
public class ThresholdCategoryServiceImpl implements IThresholdCategoryService{
	
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
	
	/**
	 * 分页查询阈值类别
	 * @param values 查询参数
	 * @param pagination 分页对象
	 * @return
	 */
	public Pagination<ThresholdCategory> findThresholdCategoryForPage(Map<String, ?> values,Pagination<ThresholdCategory> pagination){
		String hql = "from ThresholdCategory order by createTime desc";
		List<ThresholdCategory> data = dao.findForPage(hql, values, pagination.getStartIndex(), pagination.getPageSize());
		hql = "select count(*) from ThresholdCategory";
		int totalRows = dao.findCountForPage(hql, values);
		pagination.setTotalRows(totalRows);
		pagination.setData(data);
		return pagination;
	}
	
	/**
	 * 判断指定Id的阈值类别是否存在指定属性和属性值的记录
	 * @param id Id
	 * @param propertyName 属性
	 * @param propertyValue 属性值
	 * @return true：存在 false：不存在
	 */
   public boolean isExistThresholdCategory(String id, String propertyName,String propertyValue){
	   String hql = "from ThresholdCategory where "+propertyName+"=:"+propertyName+")";
		Map<String, Object> values = new HashMap<String,Object>();
		values.put(propertyName,propertyValue);
		List<ThresholdCategory> list = dao.find(hql,values);
		dao.clearSession();
		if(list!=null && list.size()>0){
			if(list.get(0).getId().toString().equals(id)){
				return false;
			}else{
				return true;
			}
		}else{
			return false;
		}
   }
}


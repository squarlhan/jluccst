/*
 * @(#)ThresholdItemServiceImpl.java 1.1 2012-4-29
 */

package com.boan.rees.expertsystem.threshold.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.boan.rees.expertsystem.threshold.dao.IThresholdItemDao;
import com.boan.rees.expertsystem.threshold.model.ThresholdItem;
import com.boan.rees.expertsystem.threshold.service.IThresholdItemService;
import com.boan.rees.utils.page.Pagination;

/**
 * 阈值项服务接口实现
 * @author ZhuYF
 * @version 1.0.0
 */
 @Service("thresholdItemService")
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
	
	/**
	 * 分页查询阈值项
	 * @param values 查询参数
	 * @param pagination 分页对象
	 * @return
	 */
	public Pagination<ThresholdItem> findThresholdItemForPage(Map<String, ?> values,Pagination<ThresholdItem> pagination){
		String hql = "from ThresholdItem order by createTime desc";
		List<ThresholdItem> data = dao.findForPage(hql, values, pagination.getStartIndex(), pagination.getPageSize());
		hql = "select count(*) from ThresholdItem";
		int totalRows = dao.findCountForPage(hql, values);
		pagination.setTotalRows(totalRows);
		pagination.setData(data);
		return pagination;
	}
	
	/**
	 * 判断指定Id的阈值项是否存在指定属性和属性值的记录
	 * @param id Id
	 * @param propertyName 属性
	 * @param propertyValue 属性值
	 * @return true：存在 false：不存在
	 */
   public boolean isExistThresholdItem(String id, String propertyName,String propertyValue){
	   String hql = "from ThresholdItem where "+propertyName+"=:"+propertyName+")";
		Map<String, Object> values = new HashMap<String,Object>();
		values.put(propertyName,propertyValue);
		List<ThresholdItem> list = dao.find(hql,values);
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

	@Override
	public List<ThresholdItem> queryThresholdItemByThresholdId(String thresholdId){
//		String hql = "from ThresholdItem order by createTime desc";
//		Map<String, Object> values = new HashMap<String,Object>();
//		values.put("thresholdId",thresholdId);
//		List<ThresholdItem> data = dao.find( hql, values );
		return null;
	}
}


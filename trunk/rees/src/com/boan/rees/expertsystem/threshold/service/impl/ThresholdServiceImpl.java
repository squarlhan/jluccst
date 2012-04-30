/*
 * @(#)ThresholdServiceImpl.java 1.1 2012-4-27
 */

package com.boan.rees.expertsystem.threshold.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.boan.rees.expertsystem.threshold.dao.IThresholdDao;
import com.boan.rees.expertsystem.threshold.model.Threshold;
import com.boan.rees.expertsystem.threshold.model.ThresholdCategory;
import com.boan.rees.expertsystem.threshold.model.ThresholdItem;
import com.boan.rees.expertsystem.threshold.service.IThresholdService;
import com.boan.rees.utils.page.Pagination;

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
	 * 分页查询阈值类别
	 * @param values 查询参数
	 * @param pagination 分页对象
	 * @return
	 */
	public Pagination<Threshold> findThresholdForPage(Map<String, ?> values,Pagination<Threshold> pagination){
		String hql = "from Threshold order by createTime desc";
		List<Threshold> data = dao.findForPage(hql, values, pagination.getStartIndex(), pagination.getPageSize());
		hql = "select count(*) from Threshold";
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
   public boolean isExistThreshold(String id, String propertyName,String propertyValue){
	   String hql = "from Threshold where "+propertyName+"=:"+propertyName+")";
		Map<String, Object> values = new HashMap<String,Object>();
		values.put(propertyName,propertyValue);
		List<Threshold> list = dao.find(hql,values);
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


package com.boan.rees.device.service;

import java.util.List;
import java.util.Map;


import com.boan.rees.device.model.PointDataInfo;
import com.boan.rees.utils.page.Pagination;
/**
 * 监控点参数服务类接口
 * @author jiangmeidi
 * @version 1.0.0
 */
public interface IPointDataInfoService {
	/**
	 * 查找全部监控点参数
	 */
   public List<PointDataInfo> findAllPointDataInfo();
   /**
	* 根据id获取监控点参数
    */
   public PointDataInfo get(String id);
   /**
	* 根据id删除监控点参数
   */		
   public void deletePointDataInfo(String... ids );
   /**
	* 保存监控点参数
   */		
	public void save(PointDataInfo table1);
	/**
	* 按分页查询监控点参数
    */
	public Pagination<PointDataInfo> findPointDataInfoForPage(Map<String, ?> values,Pagination<PointDataInfo> pagination);
}

package com.boan.rees.device.service;

import java.util.List;
import java.util.Map;


import com.boan.rees.device.model.PointInfo;
import com.boan.rees.utils.page.Pagination;
/**
 * 监控点服务类接口
 * @author ZhuYF
 * @version 1.0.0
 */
public interface IPointInfoService {
	/**
	 * 查找全部监控点
	 */
	 public List<PointInfo> findAllPointInfo();
	 /**
	  * 根据id查找监控点
	  */	
	 public PointInfo get(String id);
	 /**
		 * 根据id删除监控点
		 */
	
	 public void deletePointInfo(String... ids );
	 /**
		 * 保存监控点
		 */
	 public void save(PointInfo table1);
	 /**
		 * 分页查找监控点
		 */
	 public Pagination<PointInfo> findPointInfoForPage(Map<String, ?> values,Pagination<PointInfo> pagination);
}

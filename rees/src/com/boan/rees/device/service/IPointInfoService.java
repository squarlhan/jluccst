package com.boan.rees.device.service;

import java.util.List;

import com.boan.rees.device.model.PointDataInfo;
import com.boan.rees.device.model.PointInfo;
/**
 * 监控点服务类接口
 * @author ZhuYF
 * @version 1.0.0
 */
public interface IPointInfoService {
	 public List<PointInfo> findAllDeviceInfo();
		
		public PointInfo get(String id);
		
		public void deletePointInfo(String... ids );
		
		public void save(PointInfo table1);
}

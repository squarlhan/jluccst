package com.boan.rees.device.service;

import java.util.List;


import com.boan.rees.device.model.PointDataInfo;
/**
 * 参数服务类接口
 * @author jiangmeidi
 * @version 1.0.0
 */
public interface IPointDataInfoService {
	 public List<PointDataInfo> findAllDeviceInfo();
		
		public PointDataInfo get(String id);
		
		public void deletePointDataInfo(String... ids );
		
		public void save(PointDataInfo table1);
}

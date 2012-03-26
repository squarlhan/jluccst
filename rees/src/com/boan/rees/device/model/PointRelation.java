/**
 * Copyright (c) 2012 Boan Co. Ltd.
 * All right reserved.
 * History
 */
package com.boan.rees.device.model;

import java.util.List;

/**
 * 监测点与对应参数关系类
 * 
 * @author leon
 * 
 */
public class PointRelation {
	private static final long serialVersionUID = -4835759317940827366L;
	// 监测点对象
	private PointInfo pointInfo = null;
	// 监测点对应的参数对象数组
	private List<PointParamInfo> pointParamInfos = null;

	public PointInfo getPointInfo() {
		return pointInfo;
	}

	public void setPointInfo(PointInfo pointInfo) {
		this.pointInfo = pointInfo;
	}

	public List<PointParamInfo> getPointParamInfos() {
		return pointParamInfos;
	}

	public void setPointParamInfos(List<PointParamInfo> pointParamInfos) {
		this.pointParamInfos = pointParamInfos;
	}
}
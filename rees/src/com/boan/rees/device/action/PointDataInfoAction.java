package com.boan.rees.device.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.boan.rees.device.service.IPointDataInfoService;
import com.boan.rees.utils.action.BaseActionSupport;

/**
 * 设备监测点数据Action类
 * 
 * @author leon
 * @version 1.0.0
 */
@Controller("pointDataInfoAction")
@Scope("prototype")
public class PointDataInfoAction extends BaseActionSupport {
	private static final long serialVersionUID = -1656082155331774238L;
	@Resource
	// 监测点数据接口类
	private IPointDataInfoService pointDataInfoService;
}

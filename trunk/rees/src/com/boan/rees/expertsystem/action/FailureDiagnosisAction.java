/**
 * Copyright (c) 2012 Changchun Boan Co. Ltd.
 * All right reserved.
 * History
 */
/*
 * @(#)FailureDiagnosisAction.java 1.1 May 1, 2012
 */
package com.boan.rees.expertsystem.action;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import com.boan.rees.device.type.model.DeviceType;
import com.boan.rees.device.type.service.IDeviceTypeService;
import com.boan.rees.utils.action.BaseActionSupport;

/**
 * 故障诊断类
 * @author XXX
 * @version 1.1, May 1, 2012
 */
@Controller("failureDiagnosisAction")
public class FailureDiagnosisAction extends BaseActionSupport
{

	@Autowired
	@Qualifier("deviceTypeService")
	private IDeviceTypeService deviceTypeService = null;
	
	private List<DeviceType> deviceTypeList = null; 
	
	private String deviceTypeId = null;
	/**
	 * 显示故障诊断的查询页面
	 * @return
	 */
	public String showFailureDiagnosisInfo()
	{
		deviceTypeList = deviceTypeService.findAllDeviceType();
		
		if( StringUtils.isNotBlank( deviceTypeId ) )
		{
			//（1）根据设备类型id取设备
			//（2）根据设备类型id取现象
		}
		return "show-failure-diagnosis-info";
	}
	
	/**
	 * 显示故障诊断的结果建议页面
	 * @return
	 */
	public String showFailureDiagnosisResult()
	{
		return "show-failure-diagnosis-result";
	}

	public IDeviceTypeService getDeviceTypeService()
	{
		return deviceTypeService;
	}

	public void setDeviceTypeService( IDeviceTypeService deviceTypeService )
	{
		this.deviceTypeService = deviceTypeService;
	}

	public List<DeviceType> getDeviceTypeList()
	{
		return deviceTypeList;
	}

	public void setDeviceTypeList( List<DeviceType> deviceTypeList )
	{
		this.deviceTypeList = deviceTypeList;
	}

	public String getDeviceTypeId()
	{
		return deviceTypeId;
	}

	public void setDeviceTypeId( String deviceTypeId )
	{
		this.deviceTypeId = deviceTypeId;
	}
}


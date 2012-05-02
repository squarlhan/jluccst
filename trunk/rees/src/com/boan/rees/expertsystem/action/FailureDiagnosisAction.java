/**
 * Copyright (c) 2012 Changchun Boan Co. Ltd.
 * All right reserved.
 * History
 */
/*
 * @(#)FailureDiagnosisAction.java 1.1 May 1, 2012
 */
package com.boan.rees.expertsystem.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import com.boan.rees.device.model.DeviceInfo;
import com.boan.rees.device.service.IDeviceInfoService;
import com.boan.rees.device.type.model.DeviceType;
import com.boan.rees.device.type.service.IDeviceTypeService;
import com.boan.rees.expertsystem.model.RuleResultInfo;
import com.boan.rees.expertsystem.service.IRuleResultInfoService;
import com.boan.rees.utils.action.BaseActionSupport;

/**
 * 故障诊断类
 * 
 * @author XXX
 * @version 1.1, May 1, 2012
 */
@Controller( "failureDiagnosisAction" )
public class FailureDiagnosisAction extends BaseActionSupport
{

	//设备类型
	@Autowired
	@Qualifier( "deviceTypeService" )
	private IDeviceTypeService deviceTypeService = null;

	//设备信息
	@Autowired
	@Qualifier( "deviceInfoService" )
	private IDeviceInfoService deviceInfoService = null;

	//故障信息
	@Autowired
	@Qualifier( "ruleResultInfoService" )
	private IRuleResultInfoService ruleResultInfoService = null;

	private List<DeviceType> deviceTypeList = null;

	private List<DeviceInfo> deviceInfoList = null;

	private List<RuleResultInfo> ruleResultInfoList = null;

	private String deviceTypeId = null;
	
	private String deviceInfoId = null;
	
	private String ruleResultInfoId = null;
	
	private String vibrationDirection = null; 

	/**
	 * 显示故障诊断的查询页面
	 * 
	 * @return
	 */
	public String showFailureDiagnosisInfo()
	{
		deviceTypeList = deviceTypeService.findAllDeviceType();

		if( StringUtils.isNotBlank( deviceTypeId ) )
		{
			// （1）根据设备类型id取设备
			deviceInfoList = deviceInfoService.findDeviceInfoByDeviceTypeId( deviceTypeId );
			// （2）根据设备类型id取现象
			ruleResultInfoList = ruleResultInfoService.findRuleResultInfoByDeviceTypeId( deviceTypeId );
		}
		if(deviceTypeList == null || deviceTypeList.size() == 0)
		{
			deviceTypeList = new ArrayList<DeviceType>();
		}
		if(deviceInfoList == null || deviceInfoList.size() == 0)
		{
			deviceInfoList = new ArrayList<DeviceInfo>();
		}
		if(ruleResultInfoList == null || ruleResultInfoList.size() == 0)
		{
			ruleResultInfoList = new ArrayList<RuleResultInfo>();
		}
		return "show-failure-diagnosis-info";
	}

	/**
	 * 显示故障诊断的结果建议页面
	 * 
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

	public IDeviceInfoService getDeviceInfoService()
	{
		return deviceInfoService;
	}

	public void setDeviceInfoService( IDeviceInfoService deviceInfoService )
	{
		this.deviceInfoService = deviceInfoService;
	}

	public IRuleResultInfoService getRuleResultInfoService()
	{
		return ruleResultInfoService;
	}

	public void setRuleResultInfoService(
			IRuleResultInfoService ruleResultInfoService )
	{
		this.ruleResultInfoService = ruleResultInfoService;
	}

	public List<DeviceInfo> getDeviceInfoList()
	{
		return deviceInfoList;
	}

	public void setDeviceInfoList( List<DeviceInfo> deviceInfoList )
	{
		this.deviceInfoList = deviceInfoList;
	}

	public List<RuleResultInfo> getRuleResultInfoList()
	{
		return ruleResultInfoList;
	}

	public void setRuleResultInfoList( List<RuleResultInfo> ruleResultInfoList )
	{
		this.ruleResultInfoList = ruleResultInfoList;
	}

	public String getDeviceInfoId()
	{
		return deviceInfoId;
	}

	public void setDeviceInfoId( String deviceInfoId )
	{
		this.deviceInfoId = deviceInfoId;
	}

	public String getRuleResultInfoId()
	{
		return ruleResultInfoId;
	}

	public void setRuleResultInfoId( String ruleResultInfoId )
	{
		this.ruleResultInfoId = ruleResultInfoId;
	}

	public String getVibrationDirection()
	{
		return vibrationDirection;
	}

	public void setVibrationDirection( String vibrationDirection )
	{
		this.vibrationDirection = vibrationDirection;
	}
}

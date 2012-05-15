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
import com.boan.rees.expertsystem.model.Backward;
import com.boan.rees.expertsystem.model.BackwardandReason;
import com.boan.rees.expertsystem.model.BackwardandResult;
import com.boan.rees.expertsystem.model.BackwardandSuggestion;
import com.boan.rees.expertsystem.model.RuleAdviceInfo;
import com.boan.rees.expertsystem.model.RuleInfo;
import com.boan.rees.expertsystem.model.RuleReasonInfo;
import com.boan.rees.expertsystem.model.RuleResultInfo;
import com.boan.rees.expertsystem.service.IRuleAdviceInfoService;
import com.boan.rees.expertsystem.service.IRuleInfoService;
import com.boan.rees.expertsystem.service.IRuleReasonInfoService;
import com.boan.rees.expertsystem.service.IRuleResultInfoService;
import com.boan.rees.expertsystem.service.InferenceEngine;
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
	//规则服务接口
	@Autowired
	@Qualifier("ruleInfoService")
	private IRuleInfoService ruleInfoService;
	
	//规则原因服务接口
	@Autowired
	@Qualifier("ruleReasonInfoService")
	private IRuleReasonInfoService ruleReasonInfoService;
	
	
	//规则建议服务接口
	@Autowired
	@Qualifier("ruleAdviceInfoService")
	private IRuleAdviceInfoService ruleAdviceInfoService;
	
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
		//推理机服务接口
		InferenceEngine inferenceEngine = new InferenceEngine();
		List<RuleInfo> listRule = ruleInfoService.findAllRuleInfo();
		List<Backward> listBackward = new ArrayList<Backward>();
		List<BackwardandResult> listResult = new ArrayList<BackwardandResult>();
		for(int i=0;i < listRule.size();i++)
		{
			//封装推理机规则
			Backward backward = new Backward();
			backward.setBid( listRule.get( i ).getId() );
			
			//封装规则下的现象
			//推理机规则包括现象list属性
			for(int j= 0;j<listRule.get( i ).getResultId().split( "_" ).length; j++)
			{
				//解析现象数据串，分割符："_"，a+数字:表示原因+原因Id，b+数字:表示现象+现象Id，
				String sTemp = listRule.get( i ).getResultId().split( "_" )[j];
				if(sTemp.indexOf( "A" ) != -1)	//原因
				{
					RuleReasonInfo ruleReason = ruleReasonInfoService.getbyId( Integer.parseInt( sTemp.substring( 1, sTemp.length() )));
					if( ruleReason != null)
					{
						BackwardandResult backwardandResult = new BackwardandResult();
						backwardandResult.setId( "reason" + ruleReason.getId());
						backwardandResult.setResultName( ruleReason.getReason() );
						
						listResult.add( backwardandResult );
					}
				}else if(sTemp.indexOf( "B" ) != -1)  //现象
				{
					RuleResultInfo ruleResult = ruleResultInfoService.getbyId( Integer.parseInt( sTemp.substring( 1, sTemp.length() )));
					if( ruleResult != null)
					{
						BackwardandResult backwardandResult = new BackwardandResult();
						backwardandResult.setId( "result" + ruleResult.getId());
						backwardandResult.setResultName( ruleResult.getResult() );
						
						listResult.add( backwardandResult );
					}
				}else 
				{
					System.out.println("错误数据：规则表中，现象字段存储格式有误，不符合[a+数字]或[b+数字]，分隔符使用‘_’！");
				}
				
			}
			backward.setResults( listResult );
			
			//封装规则下的原因
			//推理机规则包括原因属性
			BackwardandReason backwardandReason = new BackwardandReason();
			String sTempReasonId = listRule.get( i ).getReasonId();
			RuleReasonInfo ruleReasonTemp  = ruleReasonInfoService.getbyId( Integer.parseInt( sTempReasonId.substring( 1, sTempReasonId.length() )));
			if(ruleReasonTemp != null)
			{
				backwardandReason.setId( ruleReasonTemp.getId() );
				backwardandReason.setReasonName( ruleReasonTemp.getReason() );
			}
			
			backward.setReason( backwardandReason );
			
			//封装规则下的建议
			//推理机规则包括建议属性
			BackwardandSuggestion backwardandSuggestion = new BackwardandSuggestion();
			RuleAdviceInfo ruleAdviceInfo  = ruleAdviceInfoService.getbyId( listRule.get( i ).getAdviceId() );
			if(ruleAdviceInfo != null)
			{
				backwardandSuggestion.setId( ruleAdviceInfo.getId() );
				backwardandSuggestion.setSuggName( ruleAdviceInfo.getAdvice() );
			}
			
			backward.setSuggestion( backwardandSuggestion );
			
			listBackward.add( backward );
			
			List<BackwardandResult> listEnters = new ArrayList<BackwardandResult>();
			BackwardandResult enter = new BackwardandResult();
			enter.setId( "result" + ruleResultInfoId );
			listEnters.add( enter );
			
			inferenceEngine.setEnter(listEnters);
			inferenceEngine.setProcess(listEnters);
			inferenceEngine.Inference("result to reason","fulfill");
			
			List<BackwardandReason> resultlist = inferenceEngine.getEnding();
			
			
			
		}
		
		//送入推理机
		inferenceEngine.setBackwardrule( listBackward );
		
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

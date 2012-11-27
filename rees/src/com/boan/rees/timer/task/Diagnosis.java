/*
 * @(#)Diagnosis.java 1.1 2012-4-24
 */

package com.boan.rees.timer.task;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.boan.rees.device.model.DeviceInfo;
import com.boan.rees.device.model.PointDataInfo;
import com.boan.rees.device.model.PointDataValueInfo;
import com.boan.rees.device.model.PointInfo;
import com.boan.rees.device.model.PointParamInfo;
import com.boan.rees.device.service.IDeviceInfoService;
import com.boan.rees.device.service.IPointDataInfoService;
import com.boan.rees.device.service.IPointDataValueInfoService;
import com.boan.rees.device.service.IPointInfoService;
import com.boan.rees.device.service.IPointParamInfoService;
import com.boan.rees.error.model.ErrorLog;
import com.boan.rees.error.service.IErrorLogService;
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
import com.boan.rees.expertsystem.threshold.model.Threshold;
import com.boan.rees.expertsystem.threshold.model.ThresholdItem;
import com.boan.rees.expertsystem.threshold.service.IThresholdService;
import com.boan.rees.forum.service.IForumIssueInfoService;
import com.boan.rees.group.service.IGroupService;
import com.boan.rees.utils.calendar.CalendarUtils;
import com.boan.rees.utils.expression.ExpressionCompare;


/**
 * 故障诊断服务类
 * @author Luojx
 * @version 1.0.0
 */
public class Diagnosis
{
	//设备服务接口
	@Autowired
	@Qualifier("deviceInfoService")
	private IDeviceInfoService deviceInfoService;
	//推理机服务接口
	private InferenceEngine inferenceEngine = new InferenceEngine();
	//规则服务接口
	@Autowired
	@Qualifier("ruleInfoService")
	private IRuleInfoService ruleInfoService;
	//阈值服务接口
	@Autowired
	@Qualifier("thresholdService")
	private IThresholdService thresholdService;
	
	// 监测点信息接口类
	@Autowired
	@Qualifier("pointInfoService")
	private IPointInfoService pointInfoService;
	@Autowired
	@Qualifier("pointParamInfoService")
	// 监测点参数接口类
	private IPointParamInfoService pointParamInfoService;
	// 监测点数据接口类
	@Autowired
	@Qualifier("pointDataInfoService")
	private IPointDataInfoService pointDataInfoService;
	//规则现象服务接口
	@Autowired
	@Qualifier("ruleResultInfoService")
	private IRuleResultInfoService ruleResultInfoService;
	//规则原因服务接口
	@Autowired
	@Qualifier("ruleReasonInfoService")
	private IRuleReasonInfoService ruleReasonInfoService;
	//规则建议服务接口
	@Autowired
	@Qualifier("ruleAdviceInfoService")
	private IRuleAdviceInfoService ruleAdviceInfoService;
	//故障日志服务接口
	@Autowired
	@Qualifier("errorLogService")
	private IErrorLogService errorLogService;
	
	//故障日志服务接口
	@Autowired
	@Qualifier("groupService")
	private IGroupService groupService;
	//故障日志服务接口
	@Autowired
	@Qualifier("forumIssueInfoService")
	private IForumIssueInfoService forumIssueInfoService;
	
	@Resource
	//监测点数据值接口类
	private IPointDataValueInfoService pointDataValueInfoService;
	/**
	 * 服务工作过程
	 * 1.封装所有规则
	 * 2.根据设备取录入的最后一条监测点数据
	 * 3.根据监测点数判断是否超标，如果超标返回故障现象list
	 * 3.1如果没超标，存日志
	 * 3.2回写监测数据
	 * 4.如果超标，送推理机进行推理，返回原因和建议list,存入故障日志表
	 */
	public void work()
	{
		System.out.println("＝＝＝＝＝执行服务任务开始＝＝＝＝＝！");
		forumIssueInfoService.autoDeleteForumIssueInfo();
		/*
		//执行具体操作
		//1.封装所有规则
		//推理机:
		//规则对象命名：Backward，现象对象命名：BackwardandResult，原因对象命名：BackwardandReason，建议对象命名：BackwardandSuggestion
		//旋转设备专家系统:
		//规则对象命名：RuleInfo，现象对象命名：RuleResultInfo，原因对象命名：RuleReasonInfo，建议对象命名：RuleAdviceInfo
		List<RuleInfo> listRule = ruleInfoService.findAllRuleInfo();
		List<Backward> listBackward = new ArrayList<Backward>();
		//System.out.println("＝＝＝＝＝1.封装所有规则 ....begin＝＝＝＝＝！");
		for(int i=0;i < listRule.size();i++)
		{
			//封装推理机规则
			Backward backward = new Backward();
			backward.setBid( listRule.get( i ).getId() );
			List<BackwardandResult> listResult = new ArrayList<BackwardandResult>(); 
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
		}
		
		//送入推理机
		inferenceEngine.setBackwardrule( listBackward );
		
		//System.out.println("＝＝＝＝＝1.封装所有规则 ....end＝＝＝＝＝！");
//		System.out.println("＝＝＝＝＝2.遍历设备....begin＝＝＝＝＝！");
		//获取当前是第多少周
		int year = Calendar.getInstance().get( Calendar.YEAR );
		int week = CalendarUtils.getWeekOfYear(Calendar.getInstance());
		
	    List<DeviceInfo> listDeviceInfo = deviceInfoService.findAllDeviceInfo();
	    for(int i=0;i<listDeviceInfo.size();i++)
	    {
			//获得设备对象
			DeviceInfo deviceInfo =	listDeviceInfo.get( i );
			//根据设备ID获得所有未执行任务的监测点对象数组
			List<PointInfo> pis = pointInfoService.findPointInfosByDeviceId(listDeviceInfo.get( i ).getId(), 1);
			//根据设备中心高和转速获得对应的阈值项实体类
			Threshold threshold = thresholdService.getThresholdByCenterHeightAndSpeed(deviceInfo.getCenterHeight().toString(), deviceInfo.getSpeed().toString());
			if(threshold == null)
			{
				System.out.println(deviceInfo.getDeviceName()+"["+deviceInfo.getDeviceNum()+"],根据设备中心高和转速未找到对应的阈值项实体类！");
				continue;
			}
			//System.out.println("＝＝＝＝＝2.取某个设备的阈值 ＝＝＝＝＝");
			if(pis!=null && pis.size()>0){
				boolean findAllItemFlag = false;
				//监测点参数
				List<PointParamInfo> ppis = null;
				//监测点参数对象
				List<PointDataInfo> pdis = null;
				PointDataValueInfo pdvi = null;
				for (PointInfo pointInfo : pis) {
					//获得监测点参数
					//System.out.println("＝＝＝＝＝2.取某个设备的监测点参数 ＝＝＝＝＝");
					ppis = pointParamInfoService.findPointParamInfoByPointId(pointInfo.getId());
					if(ppis!=null && ppis.size()>0){
						for(PointParamInfo ppi:ppis){
							if(StringUtils.trimToNull(String.valueOf( week ))!=null && StringUtils.trimToNull(String.valueOf( year ))!=null){
								pdis = pointDataInfoService.listByDeviceId(String.valueOf( year ), String.valueOf( week ), ppi.getDeviceId());
								if(pdis!=null&&pdis.size()>0){
									for(int mz=0; mz<pdis.size(); mz++){
										//获得监测点参数数据
										//System.out.println("＝＝＝＝＝2.取某个设备的监测点数据值 ＝＝＝＝＝");
										pdvi = pointDataValueInfoService.get(pdis.get(mz).getId(), ppi.getId());
										if(pdvi!=null){
											//判断监测点参数数据是否超出境界值
											//System.out.println("＝＝＝＝＝2.判断某个设备的监测点是否超出阈值 ＝＝＝＝＝");
											List<ThresholdItem> thresholdItem = threshold.getThresholdItems();
											String expression = null;
											
											for (ThresholdItem item : thresholdItem) {
												expression = item.getThresholdItemExpression();
												if(ExpressionCompare.compare(expression, item.getThresholdItemName(), pdvi.getDataInfo())){
													if(item.getSign()==1){
														findAllItemFlag = true;
														System.out.println("＝＝＝＝＝1.报警区间内，报警＝＝＝＝＝");
														
														if (item.getTroubleIds() != null && item.getTroubleIds().size() > 0)
														{
															//判断是否在报警区间
															List<BackwardandResult> listEnters = new ArrayList<BackwardandResult>();
															
															for(int kk = 0;kk<item.getTroubleIds().size();kk++)
															{
																if (item.getTroubles().get(kk).getDeviceTypeId().equals(deviceInfo.getDeviceTypeId()))
																{
																	BackwardandResult enter = new BackwardandResult();
																	enter.setId( "result" + item.getTroubleIds().get( kk ) );
																	listEnters.add( enter );
																	
																	inferenceEngine.setEnter(listEnters);
																	inferenceEngine.setProcess(listEnters);
																	inferenceEngine.Inference("result to reason","fulfill");
																	
																	List<BackwardandReason> resultlist = inferenceEngine.getEnding();
																	
																	String errorPhen = "";
																	String errorReason = "";
																	String opinion = "";
																	for(int m=0;m<item.getTroubles().size();m++)
																	{
																		if(errorPhen.length() == 0)
																		{
																			errorPhen = item.getTroubles().get( m ).getResult();
																		}else
																		{
																			errorPhen = errorPhen + ";" + item.getTroubles().get( m ).getResult();
																		}
																	}
																	for(int n=0;n<resultlist.size();n++)
																	{
																		if(errorReason.length() == 0)
																		{
																			errorReason = resultlist.get( n ).getReasonName();
																			opinion = resultlist.get( n ).getSuggestion().getSuggName();
																		}else
																		{
																			errorReason = errorReason + ";" + resultlist.get( n ).getReasonName();
																			opinion = opinion + ";" + resultlist.get( n ).getSuggestion().getSuggName();
																		}
																	}
																	
																	//返回结果，记录报警日志
																	ErrorLog errorLog = new ErrorLog();
																	String companyId = listDeviceInfo.get( i ).getCompanyId();
																	String factoryId =  listDeviceInfo.get( i ).getFactoryId();
																	String workshopId = listDeviceInfo.get( i ).getWorkshopId();
																	errorLog.setDeptName( groupService.getGroupFullName( companyId, factoryId, workshopId ) );
																	errorLog.setDeviceName( listDeviceInfo.get( i ).getDeviceName() + ":监测点[" + pointInfo.getControlPointName()+"]");
																	errorLog.setIsRemove( 0 );
																	errorLog.setDeviceNum( listDeviceInfo.get( i ).getDeviceNum() );
																	errorLog.setErrorTime( Calendar.getInstance() );
																	errorLog.setErrorData( Float.parseFloat( pdvi.getDataInfo() ) );
																	errorLog.setErrorThresh( expression );
																	errorLog.setErrorPhen( errorPhen );
																	errorLog.setErrorReason( errorReason );
																	errorLog.setOpinion( opinion );
																	errorLog.setIsAlarm( 1 );
																	
																	errorLogService.save( errorLog );
																	break;
																}
															}
														}
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
				if(!findAllItemFlag)
				{
					System.out.println("＝＝＝＝＝2.正常＝＝＝＝＝");
					//记录日志
					ErrorLog errorLog = new ErrorLog();
					String companyId = listDeviceInfo.get( i ).getCompanyId();
					String factoryId =  listDeviceInfo.get( i ).getFactoryId();
					String workshopId = listDeviceInfo.get( i ).getWorkshopId();
					
					errorLog.setDeptName( groupService.getGroupFullName( companyId, factoryId, workshopId ) );
					errorLog.setDeviceName( listDeviceInfo.get( i ).getDeviceName() );
					errorLog.setIsRemove( 1 );
					errorLog.setDeviceNum( listDeviceInfo.get( i ).getDeviceNum() );
					errorLog.setErrorTime( Calendar.getInstance() );
					errorLog.setIsAlarm( 0 );
					errorLogService.save( errorLog );
				}
				//处理完毕后，将设备监测点状态置为2
				pointInfoService.updateStatus(listDeviceInfo.get( i ).getId(),2);
			}
	    }*/
	    System.out.println("＝＝＝＝＝执行服务任务结束！＝＝＝＝＝！");
	}
}


/**
 * Copyright (c) 2012 Boan Co. Ltd.
 * All right reserved.
 * History
 */

package com.boan.rees.device.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.boan.rees.common.SelectList;
import com.boan.rees.device.model.DeviceInfo;
import com.boan.rees.device.model.PointDataInfo;
import com.boan.rees.device.model.PointInfo;
import com.boan.rees.device.model.PointParamInfo;
import com.boan.rees.device.model.PointRelation;
import com.boan.rees.device.service.IDeviceInfoService;
import com.boan.rees.device.service.IPointDataInfoService;
import com.boan.rees.device.service.IPointInfoService;
import com.boan.rees.device.service.IPointParamInfoService;
import com.boan.rees.error.model.ErrorLog;
import com.boan.rees.error.service.IErrorLogService;
import com.boan.rees.expertsystem.model.Backward;
import com.boan.rees.expertsystem.model.BackwardandReason;
import com.boan.rees.expertsystem.model.BackwardandResult;
import com.boan.rees.expertsystem.model.BackwardandSuggestion;
import com.boan.rees.expertsystem.model.RuleInfo;
import com.boan.rees.expertsystem.service.IRuleAdviceInfoService;
import com.boan.rees.expertsystem.service.IRuleInfoService;
import com.boan.rees.expertsystem.service.IRuleReasonInfoService;
import com.boan.rees.expertsystem.service.InferenceEngine;
import com.boan.rees.expertsystem.threshold.model.Threshold;
import com.boan.rees.expertsystem.threshold.model.ThresholdItem;
import com.boan.rees.expertsystem.threshold.service.IThresholdService;
import com.boan.rees.group.service.IGroupService;
import com.boan.rees.utils.action.BaseActionSupport;
import com.boan.rees.utils.calendar.CalendarUtils;
import com.boan.rees.utils.expression.ExpressionCompare;

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
	// 监测点信息接口类
	private IPointInfoService pointInfoService;
	
	@Resource
	// 监测点参数接口类
	private IPointParamInfoService pointParamInfoService;
	
	@Resource
	// 监测点数据接口类
	private IPointDataInfoService pointDataInfoService;
	
	@Resource
	//用于调用数据库相关操作
	private IDeviceInfoService deviceInfoService;
	
	@Resource
	//阈值服务接口
	private IThresholdService thresholdService;
	//规则服务接口
	@Resource
	private IRuleInfoService ruleInfoService;
	//规则原因服务接口
	@Resource
	private IRuleReasonInfoService ruleReasonInfoService;
	//规则建议服务接口
	@Resource
	private IRuleAdviceInfoService ruleAdviceInfoService;
	//故障日志服务接口
	@Resource
	private IErrorLogService errorLogService;
	//故障日志服务接口
	@Resource
	private IGroupService groupService;
	//设备ID
	private String deviceId = null;
	
	//年月，格式为201202
	private String yearMonth = null;
	
	//监测点对象数组
	private List<PointInfo> pointInfos = null;
	
	//监测点对象关系数组（用于列表，方便一次性取出监测点及参数数据）
	private List<PointRelation> pointRelations = null;
	
	//周下拉列表
	private List<SelectList> weekList = null;
	
	//年下拉列表
	private List<SelectList> yearList = null;
	
	//当前选择的年度
	private String selectYear = null;
	
	//当前选择的周日期
	private String selectWeek = null;
	
	//参数ID
	private String paramId = null;
	
	//监测数据对象
	private PointDataInfo pointDataInfo = null;
	
	//监测数据字符串
	private String datas;
	//监测点状态，0表示未录入完成，1表示已录入完成，2表示已执行任务
	private String status;
	
	//处理结果
	private String result;
	
	//设备对象
	private DeviceInfo deviceInfo = null;
	
	private InputStream xmlStream;
	private String caption;
	private String chart;
	
	/**
	 * 获得监测数据列表
	 * @return
	 */
	public String pointDataInfoList(){
		//初始化下拉列表
		int thisYear = Calendar.getInstance().get(Calendar.YEAR);
		int thisWeek = CalendarUtils.getWeekOfYear(Calendar.getInstance());
		if(StringUtils.trimToNull(selectYear)==null)
			selectYear = String.valueOf(thisYear);
		if(StringUtils.trimToNull(selectWeek)==null)
			selectWeek = String.valueOf(thisWeek);
		SelectList sl = null;
		yearList = new ArrayList<SelectList>();
		for(int i=2011; i<thisYear+1; i++){
			sl = new SelectList();
			sl.setText(String.valueOf(i));
			sl.setValue(String.valueOf(i));
			yearList.add(sl);
		}
		
		weekList = new ArrayList<SelectList>();
		sl = null;
		Calendar calBegin = null;
		Calendar calEnd = null;
		int maxWeek = CalendarUtils.getMaxWeekNumOfYear(thisYear);
		
		for(int i=0; i<maxWeek; i++){
			calBegin = CalendarUtils.getFirstDayOfWeek(thisYear, i+1);
			calEnd = CalendarUtils.getLastDayOfWeek(thisYear, i+1);
			sl = new SelectList();
			sl.setText(CalendarUtils.toString(calBegin) + "~" + CalendarUtils.toString(calEnd));
			sl.setValue(String.valueOf(i+1));
			weekList.add(sl);
			if(i==thisWeek-1)
				break;
		}
		
		
		//获得监测点信息
		if(StringUtils.trimToNull(deviceId)!=null){
			pointInfos = pointInfoService.findPointInfosByDeviceId(deviceId);
			if(pointInfos!=null && pointInfos.size()>0){
				PointRelation pr = null;
				pointRelations = new ArrayList<PointRelation>();
				for (PointInfo pointInfo : pointInfos) {
					pr = new PointRelation();
					pr.setPointInfo(pointInfo);
					pr.setPointParamInfos(pointParamInfoService.findPointParamInfoByPointId(pointInfo.getId()));
					pointRelations.add(pr);
				}
			}
			
		}
		return SUCCESS;
	}
	
	/**
	 * 显示监测点数据信息
	 * @return
	 */
	public String pointDataInfo(){
		//获得监测点信息
		if(StringUtils.trimToNull(deviceId)!=null){
			pointInfos = pointInfoService.findPointInfosByDeviceId(deviceId);
			if(pointInfos!=null && pointInfos.size()>0){
				PointRelation pr = null;
				pointRelations = new ArrayList<PointRelation>();
				for (PointInfo pointInfo : pointInfos) {
					pr = new PointRelation();
					pr.setPointInfo(pointInfo);
					pr.setPointParamInfos(pointParamInfoService.findPointParamInfoByPointId(pointInfo.getId()));
					pointRelations.add(pr);
				}
			}
			
		}
		return SUCCESS;
	}
	
	/**
	 * 根据年，取得周日期列表
	 * @return
	 */
	public String loadWeekList(){
		//初始化下拉列表
		weekList = new ArrayList<SelectList>();
		if(StringUtils.trimToNull(selectYear)!=null){
			SelectList sl = null;
			Calendar calBegin = null;
			Calendar calEnd = null;
			int thisYear = Integer.parseInt(selectYear);
			int maxWeek = CalendarUtils.getMaxWeekNumOfYear(thisYear);
			int thisWeek = CalendarUtils.getWeekOfYear(Calendar.getInstance());
			selectYear = String.valueOf(thisYear);
			for(int i=0; i<maxWeek; i++){
				calBegin = CalendarUtils.getFirstDayOfWeek(thisYear, i+1);
				calEnd = CalendarUtils.getLastDayOfWeek(thisYear, i+1);
				sl = new SelectList();
				sl.setText(CalendarUtils.toString(calBegin) + "~" + CalendarUtils.toString(calEnd));
				sl.setValue(String.valueOf(i+1));
				weekList.add(sl);
				if((i==thisWeek-1)&&(thisYear==Calendar.getInstance().get(Calendar.YEAR))){
					selectWeek = String.valueOf(thisWeek);
					break;
				}
			}
		}
		return SUCCESS;
	}

	/**
	 * 获得监测点数据
	 * @return
	 */
	public String loadDataInfo(){
		if(StringUtils.trimToNull(selectYear)!=null && StringUtils.trimToNull(selectWeek)!=null && StringUtils.trimToNull(paramId)!=null){
			pointDataInfo = pointDataInfoService.get(selectYear, selectWeek, paramId);
		}
		return SUCCESS;
	}
	
	/**
	 * 保存信息
	 * @return
	 */
	public String saveDataInfo(){
		PointDataInfo pdi = null;
		List<PointDataInfo> pointDataList = new ArrayList<PointDataInfo>();
		//解析字符串
		if (StringUtils.trimToNull(datas) != null) {
			//清除之前填写记录
			pointDataInfoService.delete(deviceId, selectYear, selectWeek);
			String[] tempDatas = datas.split(",");
			if (tempDatas.length > 0) {
				String[] tempDatas1 = null;
				PointInfo pi = null;
				for (int i = 0; i < tempDatas.length; i++) {
					tempDatas1 = tempDatas[i].split("\\|");
					if (tempDatas1.length > 0) {
						pdi = new PointDataInfo();
						pdi.setDeviceId(deviceId);
						pdi.setPointId(StringUtils.trimToNull(tempDatas1[0]));
						pdi.setParamId(StringUtils.trimToNull(tempDatas1[1]));
						if(tempDatas1.length==3)
							pdi.setDataInfo(StringUtils.trimToEmpty(tempDatas1[2]));
						else
							pdi.setDataInfo("");
						pdi.setDataYear(Integer.valueOf(selectYear));
						pdi.setWeekofYear(Integer.valueOf(selectWeek));
						pdi.setCreatTime(Calendar.getInstance());
						pdi.setUpdateTime(Calendar.getInstance());
						pointDataInfoService.save(pdi);
						
						pointDataList.add( pdi );
					}
				}
			}
		}
		if(StringUtils.trimToNull(status)!=null){
			//设置监测点参数
			List<PointInfo> pis = pointInfoService.findPointInfosByDeviceId(deviceId);
			if(pis!=null && pis.size()>0){
				for(PointInfo tempPi:pis){
					if(status.equals("0")){
						tempPi.setStatus(0);
					}
					if(status.equals("1")){
						tempPi.setStatus(1);
					}
					pointInfoService.save(tempPi);
				}
				//需要实时进行故障诊断
				if(status.equals("1")){
					DeviceInfo deviceInfo = deviceInfoService.get( deviceId );
					Threshold threshold = thresholdService.getThresholdByCenterHeightAndSpeed(deviceInfo.getCenterHeight().toString(), deviceInfo.getSpeed().toString());
					if(threshold == null)
					{
						//System.out.println(deviceInfo.getDeviceName()+"["+deviceInfo.getDeviceNum()+"],根据设备中心高和转速未找到对应的阈值项实体类！");
						result = deviceInfo.getDeviceName()+"["+deviceInfo.getDeviceNum()+"],根据设备中心高和转速未找到对应的阈值项实体类！";
						return SUCCESS;
					}
					
					List<RuleInfo> listRule = ruleInfoService.findAllRuleInfo();
					List<Backward> listBackward = new ArrayList<Backward>();
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
								BackwardandResult backwardandResult = new BackwardandResult();
								backwardandResult.setId( "reason" + Integer.parseInt( sTemp.substring( 1, sTemp.length() )));
								backwardandResult.setResultName( "" );
								
								listResult.add( backwardandResult );
							}else if(sTemp.indexOf( "B" ) != -1)  //现象
							{
								BackwardandResult backwardandResult = new BackwardandResult();
								backwardandResult.setId( "result" + Integer.parseInt( sTemp.substring( 1, sTemp.length() )));
								backwardandResult.setResultName( "" );
								
								listResult.add( backwardandResult );
							}else 
							{
								System.out.println("错误数据：规则表中，现象字段存储格式有误，不符合[A+数字]或[B+数字]，分隔符使用‘_’！");
							}
							
						}
						backward.setResults( listResult );
						
						//封装规则下的原因
						//推理机规则包括原因属性
						BackwardandReason backwardandReason = new BackwardandReason();
						String sTempReasonId = listRule.get( i ).getReasonId();
						backwardandReason.setId( Integer.parseInt( sTempReasonId.substring( 1, sTempReasonId.length() )) );
						backwardandReason.setReasonName( "" );
						
						backward.setReason( backwardandReason );
						
						//封装规则下的建议
						//推理机规则包括建议属性
						BackwardandSuggestion backwardandSuggestion = new BackwardandSuggestion();
						backwardandSuggestion.setId( listRule.get( i ).getAdviceId() );
						backwardandSuggestion.setSuggName( "" );
						backward.setSuggestion( backwardandSuggestion );
						listBackward.add( backward );
						
					}
					//推理机服务接口
					InferenceEngine inferenceEngine = new InferenceEngine();
					//送入推理机
					inferenceEngine.setBackwardrule( listBackward );
					
					if(pointDataList != null && pointDataList.size()>0)
					{
						boolean findAllItemFlag = false;
						for(int k=0;k<pointDataList.size();k++)
						{
							List<ThresholdItem> thresholdItem = threshold.getThresholdItems();
							String expression = null;
							
							for (ThresholdItem item : thresholdItem) {
								expression = item.getThresholdItemExpression();
								if(ExpressionCompare.compare(expression, item.getThresholdItemName(), pointDataList.get( k ).getDataInfo())){
									if(item.getSign()==1){
										findAllItemFlag = true;
										//System.out.println("＝＝＝＝＝1.报警区间内，报警＝＝＝＝＝");
										if (item.getTroubles() != null && item.getTroubles().size() > 0)
										{
											//判断是否在报警区间
											List<BackwardandResult> listEnters = new ArrayList<BackwardandResult>();
											
											for(int kk = 0;kk<item.getTroubles().size();kk++)
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
													
													
													for(int s = 0;s<resultlist.size();s++)
													{
														resultlist.get( s ).setReasonName(  ruleReasonInfoService.getbyId(resultlist.get( s ).getId()).getReason() );
														resultlist.get( s ).getSuggestion().setSuggName( ruleAdviceInfoService.getbyId(resultlist.get( s ).getSuggestion().getId()).getAdvice() );
													}
													
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
													if(result != null)
													{
														result = result + "\r\n故障报警：";
													}else
													{
														result = "故障报警：";
													}
													//返回结果，记录报警日志
													ErrorLog errorLog = new ErrorLog();
													String companyId = deviceInfo.getCompanyId();
													String factoryId =  deviceInfo.getFactoryId();
													String workshopId = deviceInfo.getWorkshopId();
													errorLog.setDeptName( groupService.getGroupFullName( companyId, factoryId, workshopId ) );
													String errMsg  = deviceInfo.getDeviceName() + ":监测点[" + pointInfoService.get( (pointDataList.get( k ).getPointId())).getControlPointName()+"]";
													errorLog.setDeviceName( errMsg );
													result = result + errMsg;
													
													errorLog.setIsRemove( 0 );
													errorLog.setDeviceNum( deviceInfo.getDeviceNum() );
													errorLog.setErrorTime( Calendar.getInstance() );
													result = result + ",报警数据：" + Float.parseFloat( pointDataList.get( k ).getDataInfo() );
													errorLog.setErrorData( Float.parseFloat( pointDataList.get( k ).getDataInfo() ) );
													errorLog.setErrorThresh( expression );
													result = result + ",\r\n故障现象：" + errorPhen;
													errorLog.setErrorPhen( errorPhen );
													result = result + ",\r\n故障原因：" + errorReason;
													errorLog.setErrorReason( errorReason );
													result = result + ",\r\n故障建议：" + opinion;
													errorLog.setOpinion( opinion );
													errorLog.setIsAlarm( 1 );
													
													errorLogService.save( errorLog );
												}
											}
										}
									}
								}
							}
						}
						if(!findAllItemFlag)
						{
							//System.out.println("＝＝＝＝＝2.正常＝＝＝＝＝");
							//记录日志
							ErrorLog errorLog = new ErrorLog();
							String companyId = deviceInfo.getCompanyId();
							String factoryId = deviceInfo.getFactoryId();
							String workshopId = deviceInfo.getWorkshopId();
							
							errorLog.setDeptName( groupService.getGroupFullName( companyId, factoryId, workshopId ) );
							errorLog.setDeviceName( deviceInfo.getDeviceName() );
							errorLog.setIsRemove( 1 );
							errorLog.setDeviceNum( deviceInfo.getDeviceNum() );
							errorLog.setErrorTime( Calendar.getInstance() );
							errorLog.setIsAlarm( 0 );
							errorLogService.save( errorLog );
							
							result = "诊断日志：设备["+deviceInfo.getDeviceName()+"]数据正常";
						}
						
						return SUCCESS;
					}
					
				}
			}
		}
		result = "OK";
		return SUCCESS;
	}
	
	/**
	 * 显示设备图片
	 * @return
	 */
	public String deviceImage(){
		//获得设备信息
		if(StringUtils.trimToNull(deviceId)!=null)
			deviceInfo = deviceInfoService.get(deviceId);
		else
			deviceInfo = new DeviceInfo();
		//获得监测点信息
		if(StringUtils.trimToNull(deviceId)!=null){
			pointInfos = pointInfoService.findPointInfosByDeviceId(deviceId);
			if(pointInfos!=null && pointInfos.size()>0){
				PointRelation pr = null;
				pointRelations = new ArrayList<PointRelation>();
				for (PointInfo pointInfo : pointInfos) {
					pr = new PointRelation();
					pr.setPointInfo(pointInfo);
					pr.setPointParamInfos(pointParamInfoService.findPointParamInfoByPointId(pointInfo.getId()));
					pointRelations.add(pr);
				}
			}
			
		}
		
		return SUCCESS;
	}
	
	/**
	 * 统计
	 * @return
	 */
	public String deviceStat(){
		//
		return SUCCESS;
	}
	
	/**
	 * 显示柱状图
	 * @return
	 */
	public String deviceColumnStat(){
		if(StringUtils.trimToNull(chart)!=null){
			deviceId = chart.split("\\|")[0];
			selectYear = chart.split("\\|")[1];
			selectWeek = chart.split("\\|")[2];
		}
		
		List<PointInfo> pis= null;
		Threshold threshold = null;
		if(StringUtils.trimToNull(deviceId)!=null){
			//获得监测点
			pis = pointInfoService.findPointInfosByDeviceId(deviceId);
			//获得设置对象
			DeviceInfo deviceInfo =	deviceInfoService.get(deviceId);
			//根据设备中心高和转速获得阈值区间列表
			threshold = thresholdService.getThresholdByCenterHeightAndSpeed(deviceInfo.getCenterHeight().toString(), deviceInfo.getSpeed().toString());
		}
		
		StringBuffer sb = new StringBuffer();
		StringBuffer tempSb = new StringBuffer();
		StringBuffer alarmSb = new StringBuffer();
		String alarm = "";
		if(pis!=null && pis.size()>0){
			List<PointParamInfo> ppis = null;
			PointDataInfo pdi = null;
			for (PointInfo pointInfo : pis) {
				//获得监测点参数
				ppis = pointParamInfoService.findPointParamInfoByPointId(pointInfo.getId());
				if(ppis!=null && ppis.size()>0){
					for(PointParamInfo ppi:ppis){
						if(StringUtils.trimToNull(selectYear)!=null && StringUtils.trimToNull(selectWeek)!=null){
							//获得监测点参数数据
							pdi = pointDataInfoService.get(selectYear, selectWeek, ppi.getId());
							if(pdi!=null){
								if(threshold!=null){
									//判断监测点参数数据是否超出境界值
									List<ThresholdItem> thresholdItem = threshold.getThresholdItems();
									String expression = null;
									for (ThresholdItem item : thresholdItem) {
										expression = item.getThresholdItemExpression();
										if(item.getSign()==1){
											if(ExpressionCompare.compare(expression, "V", pdi.getDataInfo())){
												alarmSb.append(pointInfo.getControlPointName() + ppi.getName() + ",");
												alarm = expression;
											}
										}
									}
								}
								tempSb.append("<set name='" + pointInfo.getControlPointName() + ppi.getName() + "' value='" + pdi.getDataInfo() + "' />");
							}else{
								tempSb.append("<set name='" + pointInfo.getControlPointName() + ppi.getName() + "' value='0' />");
							}
						}
					}
				}
			}
		}		
		sb.append("<?xml version='1.0' encoding='gb2312'?>");
		if(StringUtils.trimToNull(alarmSb.toString())!=null)
			sb.append("<graph xAxisName='" + alarmSb.toString() + "超出警报范围 ( " + alarm + " )' yAxisName='threshold' baseFontSize='12' subCaption='监测点运行数据'");
		else
			sb.append("<graph xAxisName='( 一切正常运行 )' yAxisName='threshold' baseFontSize='12' subCaption='监测点运行数据'");
		sb.append(" rotateNames='1' numDivLines='4'>");
		sb.append(tempSb);
		sb.append("</graph>");
		xmlStream = new ByteArrayInputStream(sb.toString().getBytes(Charset.forName("gb2312")));
		return SUCCESS;
	}
	
	/**
	 * 任务实现DEMO
	 * @return
	 */
	public String taskDemo(){
		if(StringUtils.trimToNull(deviceId)!=null){
			//获得设备对象
			DeviceInfo deviceInfo =	deviceInfoService.get(deviceId);
			//根据设备ID获得所有未执行任务的监测点对象数组
			List<PointInfo> pis = pointInfoService.findPointInfosByDeviceId(deviceId, 0);
			//根据设备中心高和转速获得对应的阈值项实体类
			Threshold threshold = thresholdService.getThresholdByCenterHeightAndSpeed(deviceInfo.getCenterHeight().toString(), deviceInfo.getSpeed().toString());
			if(pis!=null && pis.size()>0){
				//监测点参数
				List<PointParamInfo> ppis = null;
				//监测点参数对象
				PointDataInfo pdi = null;
				for (PointInfo pointInfo : pis) {
					//获得监测点参数
					ppis = pointParamInfoService.findPointParamInfoByPointId(pointInfo.getId());
					if(ppis!=null && ppis.size()>0){
						for(PointParamInfo ppi:ppis){
							if(StringUtils.trimToNull(selectYear)!=null && StringUtils.trimToNull(selectWeek)!=null){
								//获得监测点参数数据
								pdi = pointDataInfoService.get(selectYear, selectWeek, ppi.getId());
								if(pdi!=null){
									//判断监测点参数数据是否超出境界值
									List<ThresholdItem> thresholdItem = threshold.getThresholdItems();
									String expression = null;
									for (ThresholdItem item : thresholdItem) {
										expression = item.getThresholdItemExpression();
										if(item.getSign()==1){
											//判断是否在报警区间
											if(ExpressionCompare.compare(expression, "V", pdi.getDataInfo())){
												//LUOJX TO DO
												//送推理机
												//问题ID朱好像说是item.getTroubleIds(),你再确定一下
												
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
		return SUCCESS;
	}
	
	public InputStream getXmlStream() {		
		return xmlStream;
	}

	public void setXmlStream(InputStream xmlStream) {
		this.xmlStream = xmlStream;
	}
	
	public void setCaption(String caption) {
		this.caption = caption;
	}
	
	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public String getYearMonth() {
		return yearMonth;
	}

	public void setYearMonth(String yearMonth) {
		this.yearMonth = yearMonth;
	}

	public List<PointInfo> getPointInfos() {
		return pointInfos;
	}

	public void setPointInfos(List<PointInfo> pointInfos) {
		this.pointInfos = pointInfos;
	}

	public List<SelectList> getWeekList() {
		return weekList;
	}

	public void setWeekList(List<SelectList> weekList) {
		this.weekList = weekList;
	}

	public List<SelectList> getYearList() {
		return yearList;
	}

	public void setYearList(List<SelectList> yearList) {
		this.yearList = yearList;
	}

	public String getSelectYear() {
		return selectYear;
	}

	public void setSelectYear(String selectYear) {
		this.selectYear = selectYear;
	}

	public String getSelectWeek() {
		return selectWeek;
	}

	public void setSelectWeek(String selectWeek) {
		this.selectWeek = selectWeek;
	}

	public List<PointRelation> getPointRelations() {
		return pointRelations;
	}

	public void setPointRelations(List<PointRelation> pointRelations) {
		this.pointRelations = pointRelations;
	}

	public String getParamId() {
		return paramId;
	}

	public void setParamId(String paramId) {
		this.paramId = paramId;
	}

	public PointDataInfo getPointDataInfo() {
		return pointDataInfo;
	}

	public void setPointDataInfo(PointDataInfo pointDataInfo) {
		this.pointDataInfo = pointDataInfo;
	}

	public String getDatas() {
		return datas;
	}

	public void setDatas(String datas) {
		this.datas = datas;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public DeviceInfo getDeviceInfo() {
		return deviceInfo;
	}

	public void setDeviceInfo(DeviceInfo deviceInfo) {
		this.deviceInfo = deviceInfo;
	}

	public String getChart() {
		return chart;
	}

	public void setChart(String chart) {
		this.chart = chart;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}

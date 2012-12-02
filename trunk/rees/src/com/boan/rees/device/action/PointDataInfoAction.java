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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.boan.rees.common.SelectList;
import com.boan.rees.device.model.DeviceInfo;
import com.boan.rees.device.model.PointDataInfo;
import com.boan.rees.device.model.PointDataValueInfo;
import com.boan.rees.device.model.PointInfo;
import com.boan.rees.device.model.PointParamInfo;
import com.boan.rees.device.model.PointRelation;
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
import com.boan.rees.expertsystem.model.RuleInfo;
import com.boan.rees.expertsystem.model.SpecialDeviceRuleInfo;
import com.boan.rees.expertsystem.service.IRuleAdviceInfoService;
import com.boan.rees.expertsystem.service.IRuleInfoService;
import com.boan.rees.expertsystem.service.IRuleReasonInfoService;
import com.boan.rees.expertsystem.service.IRuleResultInfoService;
import com.boan.rees.expertsystem.service.ISpecialDeviceRuleService;
import com.boan.rees.expertsystem.service.InferenceEngine;
import com.boan.rees.expertsystem.threshold.model.Threshold;
import com.boan.rees.expertsystem.threshold.model.ThresholdItem;
import com.boan.rees.expertsystem.threshold.service.IThresholdService;
import com.boan.rees.group.common.UserSession;
import com.boan.rees.group.service.IGroupService;
import com.boan.rees.group.service.IPopedomService;
import com.boan.rees.utils.action.BaseActionSupport;
import com.boan.rees.utils.calendar.CalendarUtils;
import com.boan.rees.utils.expression.ExpressionCompare;
import com.boan.rees.utils.page.Pagination;

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
	//监测点数据值接口类
	private IPointDataValueInfoService pointDataValueInfoService;
	
	@Resource
	//用于调用数据库相关操作
	private IDeviceInfoService deviceInfoService;
	
	@Resource
	//阈值服务接口
	private IThresholdService thresholdService;
	//规则服务接口
	@Resource
	private IRuleInfoService ruleInfoService;
	@Resource
	private IRuleResultInfoService ruleResultInfoService;
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
	
	//设备特殊规则
	@Resource
	private ISpecialDeviceRuleService specialDeviceRuleService;
	
	@Resource
	private IPopedomService popedomService;
	
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
	
	//开始时间
	private String beginTime = null;
	
	//结束时间
	private String endTime = null;
	
	//当前选择的年度
	private String selectYear = null;
	
	//当前选择的周日期
	private String selectWeek = null;
	
	//当前选择的开始周日期
	private String selectFromWeek = null;
	
	//监测点ID
	private String pointId = null;
	
	//参数ID
	private String paramId = null;
	
	//监测数据对象
	private PointDataInfo pointDataInfo = null;
	//监测数据对象
	private List<PointDataInfo> pointDataInfos = null;
	private PointDataValueInfo pointDataValueInfo = null;
	private String pointDataId = null;
	private String pointDataValueId = null;
	
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
	
	private String dataTypeString;
	
	private boolean admin = false;
	
	
	private Pagination<PointDataInfo> pagePointDataInfos = new Pagination<PointDataInfo>();
	
	/**
	 * 获得监测数据列表
	 * @return
	 * @throws Exception 
	 */
	public String pointDataInfoList() throws Exception{
		HttpSession session = ServletActionContext.getRequest().getSession();
		UserSession userSession = ( UserSession ) session.getAttribute( "userSession" );
		if(userSession!=null){
			if(popedomService.isSuperAdministrator(userSession.getUserId(),String.valueOf(userSession.getUserType()) )){
				//当前用户是管理员
				admin = true;
			}
		}else{
			admin = false;
		}
		DeviceInfo deviceInfo = deviceInfoService.get( deviceId );
		String dataType = deviceInfo.getDataType();
		if("S".equalsIgnoreCase(dataType))
			dataTypeString = "速度 mm/s";
		if("D".equalsIgnoreCase(dataType))
			dataTypeString = "位移 mm";
		if("A".equalsIgnoreCase(dataType))
			dataTypeString = "加速度 mm/s2";
		
		int thisYear = Calendar.getInstance().get(Calendar.YEAR);
		int thisWeek = CalendarUtils.getWeekOfYear(Calendar.getInstance());
		Calendar calBegin = null;
		Calendar calEnd = null;
		
		if(StringUtils.trimToNull(beginTime)==null){
			calBegin = CalendarUtils.getFirstDayOfWeek(thisYear, thisWeek);
			beginTime = CalendarUtils.toString(calBegin);
		}
		if(StringUtils.trimToNull(endTime)==null){
			calEnd = CalendarUtils.getLastDayOfWeek(thisYear, thisWeek);
			endTime = CalendarUtils.toString(calEnd);
		}
		
		//获得监测点信息
		if(StringUtils.trimToNull(deviceId)!=null){
			Map<String,Object> values = new HashMap<String,Object>();
			values.put( "deviceId", deviceId );
			values.put( "beginTime", CalendarUtils.toLongCalendar(beginTime + " 0:0:1") );
			values.put( "endTime", CalendarUtils.toLongCalendar(endTime + " 23:59:59") );
			pagePointDataInfos.setPageSize(5);
			pagePointDataInfos = pointDataInfoService.findPointDataInfoForPage(values, pagePointDataInfos);
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
			DeviceInfo deviceInfo = deviceInfoService.get( deviceId );
			String dataType = deviceInfo.getDataType();
			if("S".equalsIgnoreCase(dataType))
				dataTypeString = "速度 mm/s";
			if("D".equalsIgnoreCase(dataType))
				dataTypeString = "位移 mm";
			if("A".equalsIgnoreCase(dataType))
				dataTypeString = "加速度 mm/s2";
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
		if(StringUtils.trimToNull(pointDataId)!=null && StringUtils.trimToNull(paramId)!=null){
			pointDataValueInfo = pointDataValueInfoService.get(pointDataId, paramId);
		}
		return SUCCESS;
	}
	
	/**
	 * 删除数据
	 * @return
	 */
	public String deleteDataInfo(){
		pointDataInfoService.deletePointDataInfo(pointDataId);
		pointDataValueInfoService.deleteByDataId(pointDataId);
		return SUCCESS;
	}
	
	/**
	 * 保存信息
	 * @return
	 */
	public String saveDataInfo(){
		PointDataInfo pdi = null;
		List<PointDataValueInfo> pointDataList = new ArrayList<PointDataValueInfo>();
		//解析字符串
		if (StringUtils.trimToNull(datas) != null) {
			PointDataInfo pdiTemp = null;
			if(StringUtils.trimToNull(pointDataId)!=null){
				pdiTemp = pointDataInfoService.get(pointDataId);
				pointDataValueInfoService.deleteByDataId(pointDataId);
			}else{
				pdiTemp = new PointDataInfo();
				pdiTemp.setDeviceId(deviceId);
				if(StringUtils.trimToNull(selectYear)!=null)
					pdiTemp.setDataYear(Integer.valueOf(selectYear));
				if(StringUtils.trimToNull(selectWeek)!=null)
					pdiTemp.setWeekofYear(Integer.valueOf(selectWeek));
				pdiTemp.setUserId(sessionUserId);
				pdiTemp.setUserName(sessionUserCName);
				pdiTemp.setCreatTime(Calendar.getInstance());
			}
			pdiTemp.setUpdateTime(Calendar.getInstance());
			pointDataInfoService.save(pdiTemp);
						
			String[] tempDatas = datas.split(",");
			PointDataValueInfo pdvi = null;
			if (tempDatas.length > 0) {
				String[] tempDatas1 = null;
				PointInfo pi = null;
				for (int i = 0; i < tempDatas.length; i++) {
					tempDatas1 = tempDatas[i].split("\\|");
					if (tempDatas1.length > 0) {
						pdvi = new PointDataValueInfo();
						pdvi.setPointDataId(pdiTemp.getId());
						pdvi.setPointId(StringUtils.trimToNull(tempDatas1[0]));
						pdvi.setParamId(StringUtils.trimToNull(tempDatas1[1]));
						if(tempDatas1.length==3)
							pdvi.setDataInfo(StringUtils.trimToEmpty(tempDatas1[2]));
						else
							pdvi.setDataInfo("");
						
						pointDataValueInfoService.save(pdvi);
						
						pointDataList.add(pdvi);
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
					String dataType = deviceInfo.getDataType();
					Threshold threshold = thresholdService.getThresholdByCenterHeightAndSpeed(deviceInfo.getCenterHeight().toString(), deviceInfo.getSpeed().toString());
					if(threshold == null)
					{
						//System.out.println(deviceInfo.getDeviceName()+"["+deviceInfo.getDeviceNum()+"],根据设备中心高和转速未找到对应的阈值项实体类！");
						result = deviceInfo.getDeviceName()+"["+deviceInfo.getDeviceNum()+"],根据设备中心高和转速未找到对应的阈值项实体类！";
						return SUCCESS;
					}
					
					//判断是否有设备特殊规则
					List<SpecialDeviceRuleInfo> listSpecialRule= specialDeviceRuleService.findSpecialDeviceRuleByDeviceId( deviceId );
					if(listSpecialRule != null && listSpecialRule.size() > 0)
					{
						boolean bSpecialRuleError = false;
						boolean bSpecialRuleMatch = false;
						List<String> listErrorId = new ArrayList<String>();
						if(pointDataList != null && pointDataList.size()>0)
						{
							boolean findAllItemFlag = false;
							for(int k=0;k<pointDataList.size();k++)
							{
								List<ThresholdItem> thresholdItem = threshold.getThresholdItems();
								String expression = null;
								for (ThresholdItem item : thresholdItem) {
									if(dataType == null || !item.getDataType().equals( dataType ))
									{
										continue;
									}
									expression = item.getThresholdItemExpression();
									if(ExpressionCompare.compare(expression, item.getThresholdItemName(), pointDataList.get( k ).getDataInfo()))
									{
										if(item.getSign()==1){
											//将报警的监测点和监测点参数提取出来
											if(!listErrorId.contains( pointDataList.get( k ).getPointId() + ";" + pointDataList.get( k ).getParamId() + ";" + pointDataList.get( k ).getDataInfo() ))
												listErrorId.add( pointDataList.get( k ).getPointId() + ";" + pointDataList.get( k ).getParamId() + ";" + pointDataList.get( k ).getDataInfo());
											
											bSpecialRuleError = true;
										}
									}
								}
							}
							if (listErrorId != null && listErrorId.size()> 0 )
							{
								String strPoint = "";
								String strTemp = "";
								int category = 0;
								String pointName = "";
								String paramName = "";
								String resultId = "";
								String reasonId = "";
								String adviceId = "";
								String strErrPointData = "";
								for(int i =0;i<listSpecialRule.size();i++)
								{
									strPoint = listSpecialRule.get( i ).getPointStr();
									strTemp = strPoint;
									category = listSpecialRule.get( i ).getFactorType();
									resultId = listSpecialRule.get( i ).getResultId();
									reasonId = listSpecialRule.get( i ).getReasonId();
									adviceId = listSpecialRule.get( i ).getAdviceId();
									strErrPointData = "";
									for(int m=0;m<listErrorId.size();m++)
									{
										//如果是按监测点设置特殊规则
										pointName = pointInfoService.get( listErrorId.get( m ).split( ";" )[0] ).getControlPointName();
										paramName = pointParamInfoService.get( listErrorId.get( m ).split( ";" )[1] ).getName();
										strTemp = strTemp.replaceAll( pointName, "" );
										if(strErrPointData == "")
										{
											strErrPointData = "监测点["+pointName + "]中的[" + paramName + "]" +listErrorId.get( m ).split( ";" )[2];
										}else
										{
											strErrPointData = strErrPointData + ";\r\n监测点["+pointName + "]中的[" + paramName + "]" +listErrorId.get( m ).split( ";" )[2];
										}
										if(category == 0)
										{
										}else
										{
											strTemp = strTemp.replaceAll( paramName, "" );
										}
										
									}
									
									strTemp = strTemp.replaceAll( "_", "" );
									
									//全匹配上
									if(strTemp.equals( "" ))
									{
										bSpecialRuleMatch = true;
										findAllItemFlag = true;
										
										if(result != null)
										{
											result = result + "\r\n故障报警：";
										}else
										{
											result = "故障报警：";
										}
										String errorPhen = "";
										String errorReason = "";
										String opinion = "";
										for(int s=0;s<resultId.split( "_" ).length;s++)
										{
											String sTempResultId = resultId.split( "_" )[s];
											
											if(sTempResultId.indexOf( "A" ) != -1)	//原因
											{
												if(errorPhen == "")
												{
													errorPhen = ruleReasonInfoService.get( Integer.parseInt( sTempResultId.substring( 1 ) )).getReason();
												}else
												{
													errorPhen = errorPhen + "," + ruleReasonInfoService.get( Integer.parseInt( sTempResultId.substring( 1 ) )).getReason();
												}
											}else if(sTempResultId.indexOf( "B" ) != -1)  //现象
											{
												if(errorPhen == "")
												{
													errorPhen = ruleResultInfoService.get( Integer.parseInt( sTempResultId.substring( 1 ) )).getResult();
												}else
												{
													errorPhen = errorPhen + "," + ruleResultInfoService.get( Integer.parseInt( sTempResultId.substring( 1 ) )).getResult();
												}
											}
										}
										
										errorReason = ruleReasonInfoService.get( Integer.parseInt(reasonId.substring( 1 )) ).getReason();
										opinion = ruleAdviceInfoService.get( Integer.parseInt( adviceId )).getAdvice();
										
										//返回结果，记录报警日志
										ErrorLog errorLog = new ErrorLog();
										String companyId = deviceInfo.getCompanyId();
										String factoryId =  deviceInfo.getFactoryId();
										String workshopId = deviceInfo.getWorkshopId();
										errorLog.setDeptName( groupService.getGroupFullName( companyId, factoryId, workshopId ) );
										String errMsg  = deviceInfo.getDeviceName() + ":监测点[" + strPoint.replaceAll( "_", "和" ) +"]";
										errorLog.setDeviceName( errMsg );
										result = result + errMsg;
										errorLog.setIsRemove( 0 );
										errorLog.setDeviceNum( deviceInfo.getDeviceNum() );
										errorLog.setErrorTime( Calendar.getInstance() );
										result = result + ",\r\n报警数据：" + strErrPointData;
										errorLog.setErrorData( new Float(0) );
										
										errorLog.setErrorThresh( "" );
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
							//如果特殊规则未匹配上，但还是有报警数据，则需要走通用规则库
							if(!bSpecialRuleMatch && bSpecialRuleError)
							{
								Inference(pointDataList,threshold,dataType,deviceInfo);
							}else
							{
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
							}
							
							return SUCCESS;
						}
						
						return SUCCESS;
					}else
					{
						Inference(pointDataList,threshold,dataType,deviceInfo);
						return SUCCESS;
					}
				}
			}
		}
		result = "OK";
		return SUCCESS;
	}
	/**
	 * 推理
	 * @param pointDataList
	 * @param threshold
	 * @param dataType
	 * @param device
	 * @return　String
	 */
	private String Inference(List<PointDataValueInfo> pointDataList, Threshold threshold,String dataType,DeviceInfo device)
	{
		String returnStr = "";
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
					if(!item.getDataType().equals( dataType ))
					{
						continue;
					}
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
									if (item.getTroubles().get(kk).getDeviceTypeId().equals(device.getDeviceTypeId()))
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
										String companyId = device.getCompanyId();
										String factoryId =  device.getFactoryId();
										String workshopId = device.getWorkshopId();
										errorLog.setDeptName( groupService.getGroupFullName( companyId, factoryId, workshopId ) );
										String errMsg  = device.getDeviceName() + ":监测点[" + pointInfoService.get( (pointDataList.get( k ).getPointId())).getControlPointName()+"]中的["+ pointParamInfoService.get( pointDataList.get( k ).getParamId()).getName() + "]";
										errorLog.setDeviceName( errMsg );
										result = result + errMsg;
										
										errorLog.setIsRemove( 0 );
										errorLog.setDeviceNum( device.getDeviceNum() );
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
				String companyId = device.getCompanyId();
				String factoryId = device.getFactoryId();
				String workshopId = device.getWorkshopId();
				
				errorLog.setDeptName( groupService.getGroupFullName( companyId, factoryId, workshopId ) );
				errorLog.setDeviceName( device.getDeviceName() );
				errorLog.setIsRemove( 1 );
				errorLog.setDeviceNum( device.getDeviceNum() );
				errorLog.setErrorTime( Calendar.getInstance() );
				errorLog.setIsAlarm( 0 );
				errorLogService.save( errorLog );
				
				result = "诊断日志：设备["+device.getDeviceName()+"]数据正常";
			}
			
			returnStr = SUCCESS;
		}
		return returnStr;
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
			pointDataId = chart.split("\\|")[1];
		}
		
		List<PointInfo> pis= null;
		Threshold threshold = null;
		String dataType=null;
		if(StringUtils.trimToNull(deviceId)!=null){
			//获得监测点
			pis = pointInfoService.findPointInfosByDeviceId(deviceId);
			//获得设置对象
			DeviceInfo deviceInfo =	deviceInfoService.get(deviceId);
			dataType = deviceInfo.getDataType();
			//根据设备中心高和转速获得阈值区间列表
			threshold = thresholdService.getThresholdByCenterHeightAndSpeed(deviceInfo.getCenterHeight().toString(), deviceInfo.getSpeed().toString());
		}
		
		StringBuffer sb = new StringBuffer();
		StringBuffer tempSb = new StringBuffer();
		StringBuffer alarmSb = new StringBuffer();
		String alarm = "";
		if(pis!=null && pis.size()>0){
			List<PointParamInfo> ppis = null;
			PointDataValueInfo pdvi = null;
			for (PointInfo pointInfo : pis) {
				//获得监测点参数
				ppis = pointParamInfoService.findPointParamInfoByPointId(pointInfo.getId());
				if(ppis!=null && ppis.size()>0){
					for(PointParamInfo ppi:ppis){
						//获得监测点参数数据
						pdvi = pointDataValueInfoService.get(pointDataId, ppi.getId());
						if(pdvi!=null){
							boolean isAlarm = false;
							if(threshold!=null){
								//判断监测点参数数据是否超出境界值
								List<ThresholdItem> thresholdItem = threshold.getThresholdItems();
								String expression = null;
								for (ThresholdItem item : thresholdItem) {
									if(dataType == null || !item.getDataType().equals( dataType )){
										continue;
									}
									expression = item.getThresholdItemExpression();
									if(item.getSign()==1){
										if(ExpressionCompare.compare(expression, item.getThresholdItemName(),pdvi.getDataInfo())){
											isAlarm = true;
											break;
										}
									}
								}
							}
							if(isAlarm)
								tempSb.append("<set name='" + pointInfo.getControlPointName() + ppi.getName() + "' value='" + pdvi.getDataInfo() + "' color='ff0000' />");
							else
								tempSb.append("<set name='" + pointInfo.getControlPointName() + ppi.getName() + "' value='" + pdvi.getDataInfo() + "' color='8BBA00' />");
						}else{
							tempSb.append("<set name='" + pointInfo.getControlPointName() + ppi.getName() + "' value='0' color='8BBA00' />");
						}
					}
				}
			}
		}		
		sb.append("<?xml version='1.0' encoding='gb2312'?>");
	
		sb.append("<graph xAxisName='绿色正常，红色预警' yAxisName='threshold' baseFontSize='12' subCaption='监测点运行数据'");
		
		sb.append(" rotateNames='1' numDivLines='4'>");
		sb.append(tempSb);
		sb.append("</graph>");
		xmlStream = new ByteArrayInputStream(sb.toString().getBytes(Charset.forName("gb2312")));
		return SUCCESS;
	}
	
	/**
	 * 线状图
	 * @return
	 */
	public String deviceStatLine(){
		int thisYear = Calendar.getInstance().get(Calendar.YEAR);
		int thisWeek = CalendarUtils.getWeekOfYear(Calendar.getInstance());
		Calendar calBegin = null;
		Calendar calEnd = null;
		
		if(StringUtils.trimToNull(beginTime)==null){
			calBegin = CalendarUtils.getFirstDayOfWeek(thisYear, thisWeek);
			beginTime = CalendarUtils.toString(calBegin);
		}
		if(StringUtils.trimToNull(endTime)==null){
			calEnd = CalendarUtils.getLastDayOfWeek(thisYear, thisWeek);
			endTime = CalendarUtils.toString(calEnd);
		}
		
		
		//获得监测点信息
		if(StringUtils.trimToNull(deviceId)!=null){
			pointInfos = pointInfoService.findPointInfosByDeviceId(deviceId);
			if(StringUtils.trimToNull(pointId)==null){
				if(pointInfos!=null && pointInfos.size()>0){
					pointId = pointInfos.get(0).getId();
				}
			}
		}
		return SUCCESS;
	}
	
	/**
	 * 显示线状图
	 * @return
	 */
	public String deviceColumnStatLine(){				
		if(StringUtils.trimToNull(chart)!=null){
			pointId = chart.split("\\|")[0];
			beginTime = chart.split("\\|")[1];
			endTime = chart.split("\\|")[2];
			deviceId = chart.split("\\|")[3];
		}
		StringBuffer sb = new StringBuffer();
		StringBuffer tempSb = new StringBuffer();
		List<PointParamInfo> ppis = null;
		PointDataInfo pdi = null;
		List<PointDataInfo> pdis = null;
		PointDataValueInfo pdvi = null;
		//获得监测点参数
		ppis = pointParamInfoService.findPointParamInfoByPointId(pointId);
		
		Map<String,Object> values = new HashMap<String,Object>();
		values.put( "deviceId", deviceId );
		values.put( "beginTime", CalendarUtils.toLongCalendar(beginTime + " 0:0:1") );
		values.put( "endTime", CalendarUtils.toLongCalendar(endTime + " 23:59:59") );
		
		pdis= pointDataInfoService.listByMap(values);

		tempSb.append("<categories >");
		if(pdis!=null&&pdis.size()>0){
			for(int j=0; j<pdis.size(); j++){
				tempSb.append("<category name='" + pdis.get(j).getCreatTimeString() + "' />");
			}
		}
		tempSb.append("</categories>");
		
		if(ppis!=null && ppis.size()>0){
			int count = 1;
			String color = "1D8BD1";
			for(PointParamInfo ppi:ppis){
				if(count==2)
					color = "F1683C";
				if(count==3)
					color = "2AD62A";
				if(count==4)
					color = "DBDC25";
				
				tempSb.append("<dataset seriesName='参数" + ppi.getName() + "' color='" + color + "' anchorBorderColor='" + color + "' anchorBgColor='" + color + "'>");
				
				if(pdis!=null&&pdis.size()>0){
					for(int j=0; j<pdis.size(); j++){
						pdvi = pointDataValueInfoService.get(pdis.get(j).getId(), ppi.getId());
						if(pdvi!=null)
							tempSb.append("<set value='" + pdvi.getDataInfo() + "' />");
						else
							tempSb.append("<set value='0' />");
					}
				}else{
					tempSb.append("<set value='0' />");
				}
				tempSb.append("</dataset>");
				count++;
			}
		}
		
		sb.append("<?xml version='1.0' encoding='gb2312'?>");
		sb.append("<graph caption='监测点参数运行曲线图' subcaption='(从" + beginTime + "到" + endTime + ")' hovercapbg='FFECAA' hovercapborder='F47E00' formatNumberScale='0' decimalPrecision='0' showvalues='0' numVdivlines='0' rotateNames='1' baseFontSize='12'>");
		sb.append(tempSb);
		sb.append("</graph>");
		xmlStream = new ByteArrayInputStream(sb.toString().getBytes(Charset.forName("gb2312")));
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

	/**
	 * @return the selectFromWeek
	 */
	public String getSelectFromWeek() {
		return selectFromWeek;
	}

	/**
	 * @param selectFromWeek the selectFromWeek to set
	 */
	public void setSelectFromWeek(String selectFromWeek) {
		this.selectFromWeek = selectFromWeek;
	}

	/**
	 * @return the pointId
	 */
	public String getPointId() {
		return pointId;
	}

	/**
	 * @param pointId the pointId to set
	 */
	public void setPointId(String pointId) {
		this.pointId = pointId;
	}

	/**
	 * @return the dataTypeString
	 */
	public String getDataTypeString() {
		return dataTypeString;
	}

	/**
	 * @param dataTypeString the dataTypeString to set
	 */
	public void setDataTypeString(String dataTypeString) {
		this.dataTypeString = dataTypeString;
	}

	/**
	 * @return the pointDataInfos
	 */
	public List<PointDataInfo> getPointDataInfos() {
		return pointDataInfos;
	}

	/**
	 * @param pointDataInfos the pointDataInfos to set
	 */
	public void setPointDataInfos(List<PointDataInfo> pointDataInfos) {
		this.pointDataInfos = pointDataInfos;
	}

	/**
	 * @return the pointDataValueInfo
	 */
	public PointDataValueInfo getPointDataValueInfo() {
		return pointDataValueInfo;
	}

	/**
	 * @param pointDataValueInfo the pointDataValueInfo to set
	 */
	public void setPointDataValueInfo(PointDataValueInfo pointDataValueInfo) {
		this.pointDataValueInfo = pointDataValueInfo;
	}

	/**
	 * @return the pointDataId
	 */
	public String getPointDataId() {
		return pointDataId;
	}

	/**
	 * @param pointDataId the pointDataId to set
	 */
	public void setPointDataId(String pointDataId) {
		this.pointDataId = pointDataId;
	}

	/**
	 * @return the pointDataValueId
	 */
	public String getPointDataValueId() {
		return pointDataValueId;
	}

	/**
	 * @param pointDataValueId the pointDataValueId to set
	 */
	public void setPointDataValueId(String pointDataValueId) {
		this.pointDataValueId = pointDataValueId;
	}

	/**
	 * @return the admin
	 */
	public boolean isAdmin() {
		return admin;
	}

	/**
	 * @param admin the admin to set
	 */
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	/**
	 * @return the beginTime
	 */
	public String getBeginTime() {
		return beginTime;
	}

	/**
	 * @param beginTime the beginTime to set
	 */
	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}

	/**
	 * @return the endTime
	 */
	public String getEndTime() {
		return endTime;
	}

	/**
	 * @param endTime the endTime to set
	 */
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	/**
	 * @return the pagePointDataInfos
	 */
	public Pagination<PointDataInfo> getPagePointDataInfos() {
		return pagePointDataInfos;
	}

	/**
	 * @param pagePointDataInfos the pagePointDataInfos to set
	 */
	public void setPagePointDataInfos(Pagination<PointDataInfo> pagePointDataInfos) {
		this.pagePointDataInfos = pagePointDataInfos;
	}
}
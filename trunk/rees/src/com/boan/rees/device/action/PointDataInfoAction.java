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
import com.boan.rees.expertsystem.threshold.model.Threshold;
import com.boan.rees.expertsystem.threshold.model.ThresholdItem;
import com.boan.rees.expertsystem.threshold.service.IThresholdJudgeService;
import com.boan.rees.expertsystem.threshold.service.IThresholdService;
import com.boan.rees.utils.action.BaseActionSupport;
import com.boan.rees.utils.calendar.CalendarUtils;

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
	@Resource
	//阈值范围判断接口
	private IThresholdJudgeService thresholdJudgeService;
	
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
								//判断监测点参数数据是否超出境界值
								if(judgeIfAlarm(threshold, Double.parseDouble(pdi.getDataInfo())))
									alarmSb.append(pointInfo.getControlPointName() + ppi.getName() + ",");
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
			sb.append("<graph xAxisName='( " + alarmSb.toString() + "超出警报范围 )' yAxisName='threshold' baseFontSize='12' subCaption='监测点运行数据'");
		else
			sb.append("<graph xAxisName='( 一切正常运行 )' yAxisName='threshold' baseFontSize='12' subCaption='监测点运行数据'");
		sb.append(" rotateNames='1' numDivLines='4'>");
		sb.append(tempSb);
		sb.append("</graph>");
		xmlStream = new ByteArrayInputStream(sb.toString().getBytes(Charset.forName("gb2312")));
		return SUCCESS;
	}
	
	/**
	 * 根据数据判断是报警
	 * @param threshold
	 * @param paramValue
	 * @return
	 */
	private boolean judgeIfAlarm(Threshold threshold, double paramValue){
		boolean result = false;
		if(threshold!=null){
			List<ThresholdItem> thresholdItem = threshold.getThresholdItems();
			String expression = null;
			for (ThresholdItem item : thresholdItem) {
				expression = item.getThresholdItemExpression();
				if(item.getSign()==1){
					result = thresholdJudgeService.judgeInAlarmArea(expression, paramValue);
				}
			}
		}
		return result;
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
}

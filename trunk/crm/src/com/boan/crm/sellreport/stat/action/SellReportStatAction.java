/**
 * Copyright (c) 2013 Changchun CBIT Co. Ltd.
 * All right reserved.
 * History
 */
/*
 * @(#)SellReportStatAction.java 1.1 2013-6-16
 */

package com.boan.crm.sellreport.stat.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.boan.crm.groupmanage.common.UserSession;
import com.boan.crm.groupmanage.model.Deptment;
import com.boan.crm.groupmanage.model.User;
import com.boan.crm.groupmanage.service.IDeptmentService;
import com.boan.crm.groupmanage.service.IPopedomService;
import com.boan.crm.groupmanage.service.IUserService;
import com.boan.crm.sellrecord.service.ISellRecordService;
import com.boan.crm.sellreport.monthly.model.MonthlyItemInfo;
import com.boan.crm.sellreport.monthly.model.MonthlyMainInfo;
import com.boan.crm.sellreport.monthly.service.IMonthlyItemInfoService;
import com.boan.crm.sellreport.monthly.service.IMonthlyMainInfoService;
import com.boan.crm.sellreport.sellduty.service.ISellDutyService;
import com.boan.crm.sellreport.stat.model.SalesPerformanceRank;
import com.boan.crm.sellreport.stat.service.ISellReportStatService;
import com.boan.crm.utils.action.BaseActionSupport;
import com.boan.crm.utils.calendar.CalendarUtils;
@Controller("sellReportStatAction")
@Scope("prototype")
public class SellReportStatAction extends BaseActionSupport{
	
	@Autowired
	@Qualifier("sellDutyService")
	private ISellDutyService sellDutyService = null;
	
	@Autowired
	@Qualifier("monthlyItemInfoService")
	private IMonthlyItemInfoService monthlyItemInfoService = null;
	
	@Autowired
	@Qualifier("monthlyMainInfoService")
	private IMonthlyMainInfoService monthlyMainInfoService;
	
	@Autowired
	@Qualifier("popedomService")
	private IPopedomService popedomService = null;
	
	@Autowired
	@Qualifier("userService")
	private IUserService userService = null;
	
	@Autowired
	@Qualifier("deptService")
	private IDeptmentService deptService = null;
	
	@Autowired
	@Qualifier("sellRecordService")
	private ISellRecordService sellRecordService;
	
	@Autowired
	@Qualifier("sellReportStatService")
	private ISellReportStatService sellReportStatService;
	/**
	 * 公司Id
	 */
	private String companyId = null;

	/**
	 * 公司名称
	 */
	private String companyName = null;
	/**
	 * 选择的部门
	 */
	private String deptId;
	/**
	 * 选择的人员Id
	 */
	private String personId ;
	/**
	 * 统计年分
	 */
	private String statYear;
	/**
	 * 统计月份
	 */
	private String statMonth;
	/**
	 * 统计开始时间
	 */
	private  String statBeginDate;
	/**
	 * 统计结束时间
	 */
	private  String statEndDate;
	/**
	 * 选择的快捷类型
	 */
	private  String shortcutType;
	
	private InputStream xmlStream;
	
	/**
	 * 部门列表
	 */
	private List<Deptment> deptList = null;
	
	/**
	 * 员工数组
	 */
	private List<User> userList = null;
	
	/**
	 * 销售员业绩信息数组
	 */
	private List<SalesPerformanceRank> salesPerformanceRankList;
	/**
	 * 显示组织机构树用于销售目标统计
	 * 
	 * @return
	 */
	public String showGroupTreeForSellTargetStat() throws Exception {
		companyId = sessionCompanyId;
		companyName = sessionCompanyName;
		userList = new ArrayList<User>();
		deptList = new ArrayList<Deptment>();
		UserSession us = this.getSession();
		//判断是否是公司管理员或公司级用户
		boolean popodomFlag = popedomService.isCompanyAdministrator(us.getUserId(), String.valueOf(us.getUserType()) ) 
				||popedomService.isHasCompanyPopedom(us.getRoleKey());
		if( popodomFlag ){
			deptList = deptService.queryAllDeptmentsByCompanyId(sessionCompanyId);
		}else{
			deptList.add(deptService.get(sessionDeptId));
		}
		// 获取用户列表
		if (deptList != null && deptList.size() > 0) {
			List<User> tempUserList = new ArrayList<User>();
			for (int i = 0; i < deptList.size(); i++) {
				if(deptList.get(i)!=null){
					List<User> tempList = userService.queryUserList(sessionCompanyId, deptList.get(i).getId());
					if (tempList != null && tempList.size() > 0) {
						tempUserList.addAll(tempList);
					}
				}
			}
			if (tempUserList != null && tempUserList.size() > 0) {
				userList.addAll(tempUserList);
			}
		}
		return "group-tree-for-sell-target-stat";
	}
	/**
	 * 显示组织机构树用于销售趋势
	 * 
	 * @return
	 */
	public String showGroupTreeForSellTrendStat() throws Exception {
		companyId = sessionCompanyId;
		companyName = sessionCompanyName;
		userList = new ArrayList<User>();
		deptList = new ArrayList<Deptment>();
		UserSession us = this.getSession();
		//判断是否是公司管理员或公司级用户
		boolean popodomFlag = popedomService.isCompanyAdministrator(us.getUserId(), String.valueOf(us.getUserType()) ) 
				||popedomService.isHasCompanyPopedom(us.getRoleKey());
		if( popodomFlag ){
			deptList = deptService.queryAllDeptmentsByCompanyId(sessionCompanyId);
		}else{
			deptList.add(deptService.get(sessionDeptId));
		}
		// 获取用户列表
		if (deptList != null && deptList.size() > 0) {
			List<User> tempUserList = new ArrayList<User>();
			for (int i = 0; i < deptList.size(); i++) {
				if(deptList.get(i)!=null){
					List<User> tempList = userService.queryUserList(sessionCompanyId, deptList.get(i).getId());
					if (tempList != null && tempList.size() > 0) {
						tempUserList.addAll(tempList);
					}
				}
			}
			if (tempUserList != null && tempUserList.size() > 0) {
				userList.addAll(tempUserList);
			}
		}
		return "group-tree-for-sell-trend-stat";
	}
	
	/**
	 * 显示组织机构树用于业绩排名统计
	 * 
	 * @return
	 */
	public String showGroupTreeForSalesPerformanceRankStat() throws Exception {
		companyId = sessionCompanyId;
		companyName = sessionCompanyName;
		deptList = new ArrayList<Deptment>();
		UserSession us = this.getSession();
		//判断是否是公司管理员或公司级用户
		boolean popodomFlag = popedomService.isCompanyAdministrator(us.getUserId(), String.valueOf(us.getUserType()) ) 
				||popedomService.isHasCompanyPopedom(us.getRoleKey());
		if( popodomFlag ){
			deptList = deptService.queryAllDeptmentsByCompanyId(sessionCompanyId);
		}else{
			deptList.add(deptService.get(sessionDeptId));
		}
		return "group-tree-for-sell-target-stat";
	}

	
	/**
	 * 显示销售目标页面
	 * @return
	 */
	public String openSellReportStatTarget(){
		return this.SUCCESS;
	}
	
	
	public String getStatDataForTarget(){
		if(statYear!=null && statYear.equals("")){
			statYear =""+ Calendar.getInstance().get(Calendar.YEAR);
		}
		if(statYear!=null && !statYear.equals("") && (statMonth==null || statMonth.equals(""))){
			//按年统计（统计十二个月的）
			String str="<chart palette='2' " +
					"caption='年销售计划对比统计' " +
					"btnSwitchtoZoomModeTitle='选择缩放模式' " +
					"btnSwitchToPinModeTitle='选择锁定模式' " +
					"btnResetChartTitle='重置图表' " +
					"btnZoomOutTitle='缩小图表' " +
					"zoomOutMenuItemLabel='缩小图表' " +
					"resetChartMenuItemLabel='重置图表	' " +
					"zoomModeMenuItemLabel='选择缩放模式	' " +
					"pinModeMenuItemLabel='选择锁定模式	' " +
					"drawToolbarButtons='1' " +
					"numberPrefix='' " +
					"numberSuffix='元' " +
					"formatNumberScale='0'  " +
//					"divIntervalHints='150000' "+//纵坐标间隔
//					"displayStartIndex='1'"+       //默认显示从第一列开始
//					"displayEndIndex='7'" +        //默认显示到第七列
					"showNames='1'  " +
					"showValues='0' " +
					"yAxisMinValue='20000' " +
					"numVDivLines='10' " +
					"drawAnchors='0' " +
					"divLineAlpha='30' " +
					"alternateHGridAlpha='20'  " +
					"setAdaptiveYMin='1' >";
			str=str+"<categories>";
			str=str+"<category label='一月' /> ";
			str=str+"<category label='二月' /> ";
			str=str+"<category label='三月' /> ";
			str=str+"<category label='四月' /> ";
			str=str+"<category label='五月' /> ";
			str=str+"<category label='六月' /> ";
			str=str+"<category label='七月' /> ";
			str=str+"<category label='八月' /> ";
			str=str+"<category label='九月' /> ";
			str=str+"<category label='十月' /> ";
			str=str+"<category label='十一月' /> ";
			str=str+"<category label='十二月' /> ";
			str=str+"</categories>";
			str=str+"<dataset seriesName='实际结果' color='FA0F1A'>";
			//每月实际销售额xml字符串儿
			String monthSellAmountStr="";
			//每月计划销售额xml字符串儿
			String monthPlanAmountStr="";
			String mainInfoId="";
			for(int i=1;i<=12;i++){
				MonthlyMainInfo mainInfo = monthlyMainInfoService.getMonthlyMainInfoByMonth(sessionCompanyId,deptId, personId , Integer.parseInt(statYear),i);
				List<MonthlyItemInfo>  sellTargerList = null;
				if(mainInfo!=null){
					mainInfoId = mainInfo.getId();
					sellTargerList = monthlyItemInfoService.getMonthlyItemInfoListOfSellTargetByMainInfoId(mainInfoId);
					//获取周计划开始和结束时间
					Calendar planInterzoneBegin = mainInfo.getPlanInterzoneBegin();
					Calendar planInterzoneEnd = mainInfo.getPlanInterzoneEnd();
					System.out.println(CalendarUtils.toString(planInterzoneBegin));
					System.out.println(CalendarUtils.toString(planInterzoneEnd));
					
					//月报表开始时间记录的年月日
					
					int year = planInterzoneBegin.get(Calendar.YEAR);
					int month = planInterzoneBegin.get(Calendar.MONTH);
		
					Calendar monthBegin = Calendar.getInstance();
					monthBegin.set(Calendar.YEAR, year);
					monthBegin.set(Calendar.MONTH, month-1);
					monthBegin.set(Calendar.DAY_OF_MONTH, monthBegin.getMinimum(Calendar.DATE));
					
					Calendar monthkEnd = Calendar.getInstance();
					monthkEnd.set(Calendar.YEAR, year);
					monthkEnd.set(Calendar.MONTH, month-1);
					monthkEnd.set(Calendar.DAY_OF_MONTH, 1);
					int value = monthkEnd.getActualMaximum(Calendar.DAY_OF_MONTH);
					monthkEnd.set(Calendar.DAY_OF_MONTH, value);
					//指定月的实际销售额
					BigDecimal sellAmount = sellRecordService.getSalesmanRealCollectionByBargainTime(sessionCompanyId, deptId,personId, monthBegin, monthkEnd);
					monthSellAmountStr=monthSellAmountStr+"<set value='"+sellAmount+"' /> ";
				}
				boolean flag=false;
				if(sellTargerList!=null && sellTargerList.size()>0){
					MonthlyItemInfo temp = null;
					//如果添加了多个销售额类型的子项信息，则计算和各项的和
					boolean noAdd=false;//不累加标示
					for(MonthlyItemInfo item : sellTargerList){
						if(temp==null){
							temp = item;
							noAdd=true;//不累加
						}
						if(temp!=null){
							if(!noAdd){
								temp.setFirstWeek(compute(temp.getFirstWeek(), item.getFirstWeek()));
								temp.setSecondWeek(compute(temp.getSecondWeek(), item.getSecondWeek()));
								temp.setThirdWeek(compute(temp.getThirdWeek(), item.getThirdWeek()));
								temp.setFourthWeek(compute(temp.getFourthWeek(), item.getFourthWeek()));
							}
							noAdd=false;
							flag = true;
						}
					}
					
					if(flag){//计算的实际值显示
						//按每月中的各周中填写的数值计算运算后做计划值
//						monthPlanAmountStr=monthPlanAmountStr+"<set value='"+compute(compute(temp.getFirstWeek(),temp.getSecondWeek()),compute(temp.getThirdWeek(),temp.getFourthWeek()))+"' /> ";
						//直接使用销售目标中填写的数值作为月计划值
						monthPlanAmountStr=monthPlanAmountStr+"<set value='"+temp.getSellTarget().replace("￥", "").replace(",", "")+"' /> ";
					}
				}
				if(!flag){//使用默认值
					monthPlanAmountStr=monthPlanAmountStr+"<set value='0' /> ";
				}
			}
			str=str+monthSellAmountStr+ "</dataset>";
			str=str+"<dataset seriesName='计划结果' color='65FA0F'>";
			str=str+monthPlanAmountStr;
			str=str+"</dataset>";

			str=str+"<styles>";
			str=str+"<definition>";
			str=str+"<style name='XScaleAnim' type='ANIMATION' duration='0.5' start='0' param='_xScale' />";
			str=str+"<style name='YScaleAnim' type='ANIMATION' duration='0.5' start='0' param='_yscale' />";
			str=str+"<style name='XAnim' type='ANIMATION' duration='0.5' start='0' param='_yscale' />";
			str=str+"<style name='AlphaAnim' type='ANIMATION' duration='0.5' start='0' param='_alpha' />";
			str=str+"</definition>";
			str=str+"<application>";
			str=str+"<apply toObject='CANVAS' styles='XScaleAnim, YScaleAnim,AlphaAnim' />";
	    	str=str+"<apply toObject='DIVLINES' styles='XScaleAnim,AlphaAnim' />";
	    	str=str+"<apply toObject='VDIVLINES' styles='YScaleAnim,AlphaAnim' />";
	        str=str+"<apply toObject='HGRID' styles='YScaleAnim,AlphaAnim' />";
			str=str+"</application>";
			str=str+"</styles>";
			str=str+"</chart>";
		
			xmlStream = new ByteArrayInputStream(str.getBytes(Charset.forName("GB2312")));
			
		}else if(statYear!=null && !statYear.equals("") && statMonth!=null && !statMonth.equals("")){
			//按月统计（统计四周的）
			String str="<chart palette='2' " +
					"caption='月销售计划对比统计' " +
					"btnSwitchtoZoomModeTitle='选择缩放模式' " +
					"btnSwitchToPinModeTitle='选择锁定模式' " +
					"btnResetChartTitle='重置图表' " +
					"btnZoomOutTitle='缩小图表' " +
					"zoomOutMenuItemLabel='缩小图表' " +
					"resetChartMenuItemLabel='重置图表	' " +
					"zoomModeMenuItemLabel='选择缩放模式	' " +
					"pinModeMenuItemLabel='选择锁定模式	' " +
					"drawToolbarButtons='1' " +
					"numberPrefix='' " +
					"numberSuffix='元' " +
					"formatNumberScale='0'  " +
//					"divIntervalHints='150000' "+//纵坐标间隔
//					"displayStartIndex='1'"+       //默认显示从第一列开始
//					"displayEndIndex='7'" +        //默认显示到第七列
					"showNames='1'  " +
					"showValues='0' " +
					"yAxisMinValue='20000' " +
					"numVDivLines='10' " +
					"drawAnchors='0' " +
					"divLineAlpha='30' " +
					"alternateHGridAlpha='20'  " +
					"setAdaptiveYMin='1' >";
			str=str+"<categories>";
			str=str+"<category label='第一周' /> ";
			str=str+"<category label='第二周' /> ";
			str=str+"<category label='第三周' /> ";
			str=str+"<category label='第四周' /> ";
			str=str+"</categories>";
			str=str+"<dataset seriesName='实际结果' color='FA0F1A'>";
			
			String mainInfoId="";
			MonthlyMainInfo mainInfo = monthlyMainInfoService.getMonthlyMainInfoByMonth(sessionCompanyId,deptId, personId ,Integer.parseInt(statYear),Integer.parseInt(statMonth));
			List<MonthlyItemInfo>  sellTargerList = null;
			if(mainInfo!=null){
				mainInfoId = mainInfo.getId();
				sellTargerList = monthlyItemInfoService.getMonthlyItemInfoListOfSellTargetByMainInfoId(mainInfoId);
				//获取周计划开始和结束时间
				Calendar planInterzoneBegin = mainInfo.getPlanInterzoneBegin();
				Calendar planInterzoneEnd = mainInfo.getPlanInterzoneEnd();
				
				System.out.println(CalendarUtils.toString(planInterzoneBegin));
				System.out.println(CalendarUtils.toString(planInterzoneEnd));
				
				//月报表开始时间记录的年月日
				
				int year = planInterzoneBegin.get(Calendar.YEAR);
				int month = planInterzoneBegin.get(Calendar.MONTH);
				
				Calendar firstWeekBegin = Calendar.getInstance();
				Calendar firstWeekEnd = Calendar.getInstance();
				//第一周开始时间
				firstWeekBegin.set(Calendar.YEAR, year);
				firstWeekBegin.set(Calendar.MONTH, month);
				firstWeekBegin.set(Calendar.DAY_OF_MONTH, 1);
				firstWeekBegin.set(Calendar.HOUR_OF_DAY, 0);
				firstWeekBegin.set(Calendar.MINUTE , 0 );
				firstWeekBegin.set(Calendar.SECOND, 0);
				//第一周结束时间
				firstWeekEnd.set(Calendar.YEAR, year);
				firstWeekEnd.set(Calendar.MONTH, month);
				firstWeekEnd.set(Calendar.DAY_OF_MONTH, 7);
				firstWeekEnd.set(Calendar.HOUR_OF_DAY, 23);
				firstWeekEnd.set(Calendar.MINUTE , 59 );
				firstWeekEnd.set(Calendar.SECOND, 59);
				
				System.out.println(CalendarUtils.toLongString(firstWeekBegin));
				System.out.println(CalendarUtils.toLongString(firstWeekEnd));
				//----------------------------------------------
				Calendar secondWeekBegin = Calendar.getInstance();
				Calendar secondWeekEnd = Calendar.getInstance();
				//第二周开始时间
				secondWeekBegin.set(Calendar.YEAR, year);
				secondWeekBegin.set(Calendar.MONTH, month);
				secondWeekBegin.set(Calendar.DAY_OF_MONTH, 8);
				secondWeekBegin.set(Calendar.HOUR_OF_DAY, 0);
				secondWeekBegin.set(Calendar.MINUTE , 0 );
				secondWeekBegin.set(Calendar.SECOND, 0);
				//第二周结束时间
				secondWeekEnd.set(Calendar.YEAR, year);
				secondWeekEnd.set(Calendar.MONTH, month);
				secondWeekEnd.set(Calendar.DAY_OF_MONTH, 14);
				secondWeekEnd.set(Calendar.HOUR_OF_DAY, 23);
				secondWeekEnd.set(Calendar.MINUTE , 59 );
				secondWeekEnd.set(Calendar.SECOND, 59);
				
				System.out.println(CalendarUtils.toLongString(secondWeekBegin));
				System.out.println(CalendarUtils.toLongString(secondWeekEnd));
				//----------------------------------------------
				Calendar thirdWeekBegin = Calendar.getInstance();
				Calendar thirdWeekEnd = Calendar.getInstance();
				//第三周开始时间
				thirdWeekBegin.set(Calendar.YEAR, year);
				thirdWeekBegin.set(Calendar.MONTH, month);
				thirdWeekBegin.set(Calendar.DAY_OF_MONTH, 15);
				thirdWeekBegin.set(Calendar.HOUR_OF_DAY, 0);
				thirdWeekBegin.set(Calendar.MINUTE , 0 );
				thirdWeekBegin.set(Calendar.SECOND, 0);
				//第三周结束时间
				thirdWeekEnd.set(Calendar.YEAR, year);
				thirdWeekEnd.set(Calendar.MONTH, month);
				thirdWeekEnd.set(Calendar.DAY_OF_MONTH, 21);
				thirdWeekEnd.set(Calendar.HOUR_OF_DAY, 23);
				thirdWeekEnd.set(Calendar.MINUTE , 59 );
				thirdWeekEnd.set(Calendar.SECOND, 59);
				
				System.out.println(CalendarUtils.toLongString(thirdWeekBegin));
				System.out.println(CalendarUtils.toLongString(thirdWeekEnd));
				
				//----------------------------------------------
				Calendar fourthWeekBegin = Calendar.getInstance();
				Calendar fourthWeekEnd = Calendar.getInstance();
				//第四周开始时间
				fourthWeekBegin.set(Calendar.YEAR, year);
				fourthWeekBegin.set(Calendar.MONTH, month);
				fourthWeekBegin.set(Calendar.DAY_OF_MONTH, 22);
				fourthWeekBegin.set(Calendar.HOUR_OF_DAY, 0);
				fourthWeekBegin.set(Calendar.MINUTE , 0 );
				fourthWeekBegin.set(Calendar.SECOND, 0);
				//第四周结束时间
				fourthWeekEnd.set(Calendar.YEAR, year);
				fourthWeekEnd.set(Calendar.MONTH, month);
				fourthWeekEnd.set(Calendar.DAY_OF_MONTH, fourthWeekEnd.getActualMaximum(Calendar.DAY_OF_MONTH));
				fourthWeekEnd.set(Calendar.HOUR_OF_DAY, 23);
				fourthWeekEnd.set(Calendar.MINUTE , 59 );
				fourthWeekEnd.set(Calendar.SECOND, 59);
				
				System.out.println(CalendarUtils.toLongString(fourthWeekBegin));
				System.out.println(CalendarUtils.toLongString(fourthWeekEnd));
	
				BigDecimal first = sellRecordService.getRealCollectionByBargainTime(sessionCompanyId, null, firstWeekBegin, firstWeekEnd);
				BigDecimal second = sellRecordService.getRealCollectionByBargainTime(sessionCompanyId, null, secondWeekBegin, secondWeekEnd);
				BigDecimal third = sellRecordService.getRealCollectionByBargainTime(sessionCompanyId, null, thirdWeekBegin, thirdWeekEnd);
				BigDecimal fourth = sellRecordService.getRealCollectionByBargainTime(sessionCompanyId, null, fourthWeekBegin, fourthWeekEnd);
				
				str=str+"<set value='"+first+"' /> ";
				str=str+"<set value='"+second+"' /> ";
				str=str+"<set value='"+third+"' /> ";
				str=str+"<set value='"+fourth+"' /> ";
				str=str+"</dataset>";
				str=str+"<dataset seriesName='计划结果' color='65FA0F'>";
			}else{
				str=str+"<set value='0' /> ";
				str=str+"<set value='0' /> ";
				str=str+"<set value='0' /> ";
				str=str+"<set value='0' /> ";
				str=str+"</dataset>";
				str=str+"<dataset seriesName='计划结果' color='65FA0F'>";
			}
			boolean flag=false;
			if(sellTargerList!=null && sellTargerList.size()>0){
				MonthlyItemInfo temp = null;
				//如果添加了多个销售额类型的子项信息，则计算和各项的和
				boolean noAdd=false;//不累加标示
				for(MonthlyItemInfo item : sellTargerList){
					if(temp==null){
						temp = item;
						noAdd=true;//不累加
					}
					if(temp!=null){
						if(!noAdd){
							temp.setFirstWeek(compute(temp.getFirstWeek(), item.getFirstWeek()));
							temp.setSecondWeek(compute(temp.getSecondWeek(), item.getSecondWeek()));
							temp.setThirdWeek(compute(temp.getThirdWeek(), item.getThirdWeek()));
							temp.setFourthWeek(compute(temp.getFourthWeek(), item.getFourthWeek()));
						}
						noAdd=false;
						flag = true;
					}
				}
				if(flag){//计算的实际值显示
					str=str+"<set value='"+temp.getFirstWeek()+"' /> ";
					str=str+"<set value='"+temp.getSecondWeek()+"' /> ";
					str=str+"<set value='"+temp.getThirdWeek()+"' /> ";
					str=str+"<set value='"+temp.getFourthWeek()+"' /> ";
				}
			}
			if(!flag){//使用默认值
				str=str+"<set value='0' /> ";
				str=str+"<set value='0' /> ";
				str=str+"<set value='0' /> ";
				str=str+"<set value='0' /> ";
			}
			str=str+"</dataset>";

			str=str+"<styles>";
			str=str+"<definition>";
			str=str+"<style name='XScaleAnim' type='ANIMATION' duration='0.5' start='0' param='_xScale' />";
			str=str+"<style name='YScaleAnim' type='ANIMATION' duration='0.5' start='0' param='_yscale' />";
			str=str+"<style name='XAnim' type='ANIMATION' duration='0.5' start='0' param='_yscale' />";
			str=str+"<style name='AlphaAnim' type='ANIMATION' duration='0.5' start='0' param='_alpha' />";
			str=str+"</definition>";
			str=str+"<application>";
			str=str+"<apply toObject='CANVAS' styles='XScaleAnim, YScaleAnim,AlphaAnim' />";
	    	str=str+"<apply toObject='DIVLINES' styles='XScaleAnim,AlphaAnim' />";
	    	str=str+"<apply toObject='VDIVLINES' styles='YScaleAnim,AlphaAnim' />";
	        str=str+"<apply toObject='HGRID' styles='YScaleAnim,AlphaAnim' />";
			str=str+"</application>";
			str=str+"</styles>";
			str=str+"</chart>";
		
			xmlStream = new ByteArrayInputStream(str.getBytes(Charset.forName("GB2312")));
		}
		
		return this.SUCCESS;
	}
	
	/**
	 * 显示销售业绩排名
	 * @return
	 */
	public String openSellSalesPerformanceRank(){
		salesPerformanceRankList = sellReportStatService.querySalesPerformanceRank(statBeginDate, statEndDate, companyId, deptId);
		return this.SUCCESS;
	}
	
	/**
	 * 显示销售趋势
	 * @return
	 */
	public String openSellTrend(){
		salesPerformanceRankList = sellReportStatService.querySalesPerformanceRank(statBeginDate, statEndDate, companyId, deptId);
		return this.SUCCESS;
	}
	
	/**
	 * 获取销售趋势统计数据
	 * @return
	 */
	public String getStatDataForSellTrend(){
		String str="<chart palette='2' " +
				"caption='#title#' " +
				"btnSwitchtoZoomModeTitle='选择缩放模式' " +
				"btnSwitchToPinModeTitle='选择锁定模式' " +
				"btnResetChartTitle='重置图表' " +
				"btnZoomOutTitle='缩小图表' " +
				"zoomOutMenuItemLabel='缩小图表' " +
				"resetChartMenuItemLabel='重置图表	' " +
				"zoomModeMenuItemLabel='选择缩放模式	' " +
				"pinModeMenuItemLabel='选择锁定模式	' " +
				"drawToolbarButtons='1' " +
				"numberPrefix='' " +
				"numberSuffix='元' " +
				"formatNumberScale='0'  " +
				"showNames='1'  " +
				"showValues='0' " +
				"yAxisMinValue='20000' " +
				"numVDivLines='10' " +
				"drawAnchors='0' " +
				"divLineAlpha='30' " +
				"alternateHGridAlpha='20'  " +
				"setAdaptiveYMin='1' >";
		if(shortcutType==null || shortcutType.equals("") || shortcutType.equals("year")){
			str = str.replace("#title#", "本年销售趋势统计");
			str=str+"<categories>";
			str=str+"<category label='一月' /> ";
			str=str+"<category label='二月' /> ";
			str=str+"<category label='三月' /> ";
			str=str+"<category label='四月' /> ";
			str=str+"<category label='五月' /> ";
			str=str+"<category label='六月' /> ";
			str=str+"<category label='七月' /> ";
			str=str+"<category label='八月' /> ";
			str=str+"<category label='九月' /> ";
			str=str+"<category label='十月' /> ";
			str=str+"<category label='十一月' /> ";
			str=str+"<category label='十二月' /> ";
			str=str+"</categories>";
			str=str+"<dataset seriesName='实际结果' color='FA0F1A'>";
			//计算每月销售额并拼接成字符串
			str = this.computeEveryMonthSellAmount(str);
			str=str+"</dataset>";
		}else	if(shortcutType!=null && shortcutType.equals("month")){
			str = str.replace("#title#", "本月销售趋势统计");
			//计算每周销售额并拼接成字符串
			str = this.computeEveryWeekSellAmount(str);
			str=str+"</dataset>";
		}else if(shortcutType!=null && shortcutType.equals("week")){
			str = str.replace("#title#", "本周销售趋势统计");
			str=str+"<categories>";
			str=str+"<category label='周一' /> ";
			str=str+"<category label='周二' /> ";
			str=str+"<category label='周三' /> ";
			str=str+"<category label='周四' /> ";
			str=str+"<category label='周五' /> ";
			str=str+"<category label='周六' /> ";
			str=str+"<category label='周日' /> ";
			str=str+"</categories>";
			str=str+"<dataset seriesName='实际结果' color='FA0F1A'>";
			//计算每天销售额并拼接成字符串
			str =this. computeEveryDaySellAmount(str);
			str=str+"</dataset>";
		}else	if(shortcutType!=null && shortcutType.equals("my")){
			str = str.replace("#title#", statBeginDate + "至"+ statEndDate+"销售趋势统计");
			str=str+"<categories>";
			String category="";
			String value="";
			Calendar dayBeginDate = CalendarUtils.toCalendar(statBeginDate);
			Calendar dayEndDate = CalendarUtils.toCalendar(statEndDate);
			dayEndDate.set(Calendar.HOUR_OF_DAY, 23);
			dayEndDate.set(Calendar.MINUTE , 59 );
			dayEndDate.set(Calendar.SECOND, 59);
			List list = sellRecordService.getSalesmanRealCollectionAndTimeByBargainTime(sessionCompanyId, deptId,personId, dayBeginDate, dayEndDate);
			if(list.size()>0){
				for(int i =0 ;i<list.size();i++){
					 Iterator it = ( (Map)list.get(i)).keySet().iterator();   
					  while (it.hasNext()){   
						   Calendar key;   
					       key= (Calendar)it.next();   
					       SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					       if(i==0 && !sdf.format(((Calendar)key).getTime()).equals(statBeginDate)){
					    	   category= category+ "<category label='"+statBeginDate+"' />";
					    	   value=value+"<set value='0' /> ";
					       }
					       category= category+ "<category label='"+sdf.format(((Calendar)key).getTime())+"' />";
					       value=value+"<set value='"+ ((Map)list.get(i)).get(key)+"' /> ";
					       if(i==( list.size()-1)&& !sdf.format(((Calendar)key).getTime()).equals(statEndDate)){
					    	   category= category+ "<category label='"+statEndDate+"' />";
					    	   value=value+"<set value='0' /> ";
					       }
					   }  
				}
			}else{
				category=category+"<category label='"+statBeginDate+"' />";
				category=category+"<category label='"+statEndDate+"' />";
				value=value+"<set value='0' /> ";
				value=value+"<set value='0' /> ";
			}

			str=str+category ;
			str=str+"</categories>";
			str=str+"<dataset seriesName='实际结果' color='FA0F1A'>";
			str=str+value;
			str=str+"</dataset>";
		}
		str=str+"<styles>";
		str=str+"<definition>";
		str=str+"<style name='XScaleAnim' type='ANIMATION' duration='0.5' start='0' param='_xScale' />";
		str=str+"<style name='YScaleAnim' type='ANIMATION' duration='0.5' start='0' param='_yscale' />";
		str=str+"<style name='XAnim' type='ANIMATION' duration='0.5' start='0' param='_yscale' />";
		str=str+"<style name='AlphaAnim' type='ANIMATION' duration='0.5' start='0' param='_alpha' />";
		str=str+"</definition>";
		str=str+"<application>";
		str=str+"<apply toObject='CANVAS' styles='XScaleAnim, YScaleAnim,AlphaAnim' />";
    	str=str+"<apply toObject='DIVLINES' styles='XScaleAnim,AlphaAnim' />";
    	str=str+"<apply toObject='VDIVLINES' styles='YScaleAnim,AlphaAnim' />";
        str=str+"<apply toObject='HGRID' styles='YScaleAnim,AlphaAnim' />";
		str=str+"</application>";
		str=str+"</styles>";
		str=str+"</chart>";
	
		xmlStream = new ByteArrayInputStream(str.getBytes(Charset.forName("GB2312")));
		
		return this.SUCCESS;
	}
	/**
	 * //计算每天销售额并拼接成字符串
	 * @param str
	 * @return
	 */
	private String computeEveryDaySellAmount(String str) {
		Calendar dayBeginDate = CalendarUtils.toCalendar(statBeginDate);
		Calendar dayEndDate = CalendarUtils.toCalendar(statBeginDate);
		dayEndDate.set(Calendar.HOUR_OF_DAY, 23);
		dayEndDate.set(Calendar.MINUTE , 59 );
		dayEndDate.set(Calendar.SECOND, 59);
		
		//周一
		BigDecimal day1 = sellRecordService.getSalesmanRealCollectionByBargainTime(sessionCompanyId, deptId,personId, dayBeginDate, dayEndDate);
		//周二
		dayBeginDate.add(Calendar.DAY_OF_MONTH, 1);
		dayEndDate.add(Calendar.DAY_OF_MONTH, 1);
		BigDecimal day2 =  sellRecordService.getSalesmanRealCollectionByBargainTime(sessionCompanyId, deptId,personId, dayBeginDate, dayEndDate);
		//周三
		dayBeginDate.add(Calendar.DAY_OF_MONTH, 1);
		dayEndDate.add(Calendar.DAY_OF_MONTH, 1);
		BigDecimal day3 =  sellRecordService.getSalesmanRealCollectionByBargainTime(sessionCompanyId, deptId,personId, dayBeginDate, dayEndDate);
		//周四
		dayBeginDate.add(Calendar.DAY_OF_MONTH, 1);
		dayEndDate.add(Calendar.DAY_OF_MONTH, 1);
		BigDecimal day4 = sellRecordService.getSalesmanRealCollectionByBargainTime(sessionCompanyId, deptId,personId, dayBeginDate, dayEndDate);
		//周五
		dayBeginDate.add(Calendar.DAY_OF_MONTH, 1);
		dayEndDate.add(Calendar.DAY_OF_MONTH, 1);
		BigDecimal day5 = sellRecordService.getSalesmanRealCollectionByBargainTime(sessionCompanyId, deptId,personId, dayBeginDate, dayEndDate);
		//周六
		dayBeginDate.add(Calendar.DAY_OF_MONTH, 1);
		dayEndDate.add(Calendar.DAY_OF_MONTH, 1);
		BigDecimal day6 = sellRecordService.getSalesmanRealCollectionByBargainTime(sessionCompanyId, deptId,personId, dayBeginDate, dayEndDate);
		//周日
		dayBeginDate.add(Calendar.DAY_OF_MONTH, 1);
		dayEndDate.add(Calendar.DAY_OF_MONTH, 1);
		
//			System.out.println(CalendarUtils.toLongString(dayBeginDate));
//			System.out.println(CalendarUtils.toLongString(dayEndDate));
		
		BigDecimal day7 = sellRecordService.getSalesmanRealCollectionByBargainTime(sessionCompanyId, deptId,personId, dayBeginDate, dayEndDate);
		
		str=str+"<set value='"+day1+"' /> ";
		str=str+"<set value='"+day2+"' /> ";
		str=str+"<set value='"+day3+"' /> ";
		str=str+"<set value='"+day4+"' /> ";
		str=str+"<set value='"+day5+"' /> ";
		str=str+"<set value='"+day6+"' /> ";
		str=str+"<set value='"+day7+"' /> ";
		return str;
	}
	
	/**
	 * 计算每周销售额并拼接成字符串
	 * @param str
	 * @return
	 */
	private String computeEveryWeekSellAmount(String str) {
		str=str+"<categories>";
		str=str+"<category label='第一周' /> ";
		str=str+"<category label='第二周' /> ";
		str=str+"<category label='第三周' /> ";
		str=str+"<category label='第四周' /> ";
		str=str+"</categories>";
		str=str+"<dataset seriesName='实际结果' color='FA0F1A'>";
		Calendar firstWeekBegin = Calendar.getInstance();
		Calendar firstWeekEnd = Calendar.getInstance();
		//第一周开始时间
		firstWeekBegin.set(Calendar.YEAR, CalendarUtils.toCalendar(statBeginDate).get(Calendar.YEAR));
		firstWeekBegin.set(Calendar.MONTH, CalendarUtils.toCalendar(statBeginDate).get(Calendar.MONTH));
		firstWeekBegin.set(Calendar.DAY_OF_MONTH, 1);
		firstWeekBegin.set(Calendar.HOUR_OF_DAY, 0);
		firstWeekBegin.set(Calendar.MINUTE , 0 );
		firstWeekBegin.set(Calendar.SECOND, 0);
		//第一周结束时间
		firstWeekEnd.set(Calendar.YEAR, CalendarUtils.toCalendar(statBeginDate).get(Calendar.YEAR));
		firstWeekEnd.set(Calendar.MONTH, CalendarUtils.toCalendar(statBeginDate).get(Calendar.MONTH));
		firstWeekEnd.set(Calendar.DAY_OF_MONTH, 7);
		firstWeekEnd.set(Calendar.HOUR_OF_DAY, 23);
		firstWeekEnd.set(Calendar.MINUTE , 59 );
		firstWeekEnd.set(Calendar.SECOND, 59);
		
		System.out.println(CalendarUtils.toLongString(firstWeekBegin));
		System.out.println(CalendarUtils.toLongString(firstWeekEnd));
		//----------------------------------------------
		Calendar secondWeekBegin = Calendar.getInstance();
		Calendar secondWeekEnd = Calendar.getInstance();
		//第二周开始时间
		secondWeekBegin.set(Calendar.YEAR, CalendarUtils.toCalendar(statBeginDate).get(Calendar.YEAR));
		secondWeekBegin.set(Calendar.MONTH, CalendarUtils.toCalendar(statBeginDate).get(Calendar.MONTH));
		secondWeekBegin.set(Calendar.DAY_OF_MONTH, 8);
		secondWeekBegin.set(Calendar.HOUR_OF_DAY, 0);
		secondWeekBegin.set(Calendar.MINUTE , 0 );
		secondWeekBegin.set(Calendar.SECOND, 0);
		//第二周结束时间
		secondWeekEnd.set(Calendar.YEAR, CalendarUtils.toCalendar(statBeginDate).get(Calendar.YEAR));
		secondWeekEnd.set(Calendar.MONTH, CalendarUtils.toCalendar(statBeginDate).get(Calendar.MONTH));
		secondWeekEnd.set(Calendar.DAY_OF_MONTH, 14);
		secondWeekEnd.set(Calendar.HOUR_OF_DAY, 23);
		secondWeekEnd.set(Calendar.MINUTE , 59 );
		secondWeekEnd.set(Calendar.SECOND, 59);
		
		System.out.println(CalendarUtils.toLongString(secondWeekBegin));
		System.out.println(CalendarUtils.toLongString(secondWeekEnd));
		//----------------------------------------------
		Calendar thirdWeekBegin = Calendar.getInstance();
		Calendar thirdWeekEnd = Calendar.getInstance();
		//第三周开始时间
		thirdWeekBegin.set(Calendar.YEAR, CalendarUtils.toCalendar(statBeginDate).get(Calendar.YEAR));
		thirdWeekBegin.set(Calendar.MONTH, CalendarUtils.toCalendar(statBeginDate).get(Calendar.MONTH));
		thirdWeekBegin.set(Calendar.DAY_OF_MONTH, 15);
		thirdWeekBegin.set(Calendar.HOUR_OF_DAY, 0);
		thirdWeekBegin.set(Calendar.MINUTE , 0 );
		thirdWeekBegin.set(Calendar.SECOND, 0);
		//第三周结束时间
		thirdWeekEnd.set(Calendar.YEAR, CalendarUtils.toCalendar(statBeginDate).get(Calendar.YEAR));
		thirdWeekEnd.set(Calendar.MONTH, CalendarUtils.toCalendar(statBeginDate).get(Calendar.MONTH));
		thirdWeekEnd.set(Calendar.DAY_OF_MONTH, 21);
		thirdWeekEnd.set(Calendar.HOUR_OF_DAY, 23);
		thirdWeekEnd.set(Calendar.MINUTE , 59 );
		thirdWeekEnd.set(Calendar.SECOND, 59);
		
		System.out.println(CalendarUtils.toLongString(thirdWeekBegin));
		System.out.println(CalendarUtils.toLongString(thirdWeekEnd));
		
		//----------------------------------------------
		Calendar fourthWeekBegin = Calendar.getInstance();
		Calendar fourthWeekEnd = Calendar.getInstance();
		//第四周开始时间
		fourthWeekBegin.set(Calendar.YEAR, CalendarUtils.toCalendar(statBeginDate).get(Calendar.YEAR));
		fourthWeekBegin.set(Calendar.MONTH, CalendarUtils.toCalendar(statBeginDate).get(Calendar.MONTH));
		fourthWeekBegin.set(Calendar.DAY_OF_MONTH, 22);
		fourthWeekBegin.set(Calendar.HOUR_OF_DAY, 0);
		fourthWeekBegin.set(Calendar.MINUTE , 0 );
		fourthWeekBegin.set(Calendar.SECOND, 0);
		//第四周结束时间
		fourthWeekEnd.set(Calendar.YEAR, CalendarUtils.toCalendar(statBeginDate).get(Calendar.YEAR));
		fourthWeekEnd.set(Calendar.MONTH, CalendarUtils.toCalendar(statBeginDate).get(Calendar.MONTH));
		fourthWeekEnd.set(Calendar.DAY_OF_MONTH, fourthWeekEnd.getActualMaximum(Calendar.DAY_OF_MONTH));
		fourthWeekEnd.set(Calendar.HOUR_OF_DAY, 23);
		fourthWeekEnd.set(Calendar.MINUTE , 59 );
		fourthWeekEnd.set(Calendar.SECOND, 59);
		
		System.out.println(CalendarUtils.toLongString(fourthWeekBegin));
		System.out.println(CalendarUtils.toLongString(fourthWeekEnd));

		BigDecimal first = sellRecordService.getSalesmanRealCollectionByBargainTime(sessionCompanyId, deptId,personId, firstWeekBegin, firstWeekEnd);
		BigDecimal second = sellRecordService.getSalesmanRealCollectionByBargainTime(sessionCompanyId, deptId,personId, secondWeekBegin, secondWeekEnd);
		BigDecimal third = sellRecordService.getSalesmanRealCollectionByBargainTime(sessionCompanyId, deptId,personId, thirdWeekBegin, thirdWeekEnd);
		BigDecimal fourth = sellRecordService.getSalesmanRealCollectionByBargainTime(sessionCompanyId, deptId,personId, fourthWeekBegin, fourthWeekEnd);
		
		str=str+"<set value='"+first+"' /> ";
		str=str+"<set value='"+second+"' /> ";
		str=str+"<set value='"+third+"' /> ";
		str=str+"<set value='"+fourth+"' /> ";
		return str;
	}
	
	/**
	 * 计算每月销售额并拼接成字符串
	 * @param str
	 * @return
	 */
	private String computeEveryMonthSellAmount(String str) {
		for(int i =1;i<=12;i++){
			Calendar monthBegin = Calendar.getInstance();
			monthBegin.set(Calendar.MONTH, i -1);
			monthBegin.set(Calendar.DAY_OF_MONTH, monthBegin.getMinimum(Calendar.DATE));
			Calendar monthkEnd = Calendar.getInstance();
			monthkEnd.set(Calendar.MONTH, i-1);
			monthkEnd.set(Calendar.DAY_OF_MONTH, 1);
			int value = monthkEnd.getActualMaximum(Calendar.DAY_OF_MONTH);
			monthkEnd.set(Calendar.DAY_OF_MONTH, value);
			
			System.out.println(CalendarUtils.toString(monthBegin));
			System.out.println(CalendarUtils.toString(monthkEnd));
			
			BigDecimal sellAmount = sellRecordService.getSalesmanRealCollectionByBargainTime(sessionCompanyId, deptId,personId, monthBegin, monthkEnd);
			str=str + "<set value='"+sellAmount+"' /> ";
		}
		return str;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	/**
	 * @return the deptList
	 */
	public List<Deptment> getDeptList() {
		return deptList;
	}

	/**
	 * @param deptList the deptList to set
	 */
	public void setDeptList(List<Deptment> deptList) {
		this.deptList = deptList;
	}

	/**
	 * @return the userList
	 */
	public List<User> getUserList() {
		return userList;
	}

	/**
	 * @param userList the userList to set
	 */
	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	/**
	 * @return the companyId
	 */
	public String getCompanyId() {
		return companyId;
	}

	/**
	 * @param companyId the companyId to set
	 */
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	/**
	 * @return the companyName
	 */
	public String getCompanyName() {
		return companyName;
	}

	/**
	 * @param companyName the companyName to set
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	/**
	 * @return the statYear
	 */
	public String getStatYear() {
		return statYear;
	}

	/**
	 * @param statYear the statYear to set
	 */
	public void setStatYear(String statYear) {
		this.statYear = statYear;
	}

	/**
	 * @return the statMonth
	 */
	public String getStatMonth() {
		return statMonth;
	}

	/**
	 * @param statMonth the statMonth to set
	 */
	public void setStatMonth(String statMonth) {
		this.statMonth = statMonth;
	}

	/**
	 * @return the xmlStream
	 */
	public InputStream getXmlStream() {
		return xmlStream;
	}

	/**
	 * @param xmlStream the xmlStream to set
	 */
	public void setXmlStream(InputStream xmlStream) {
		this.xmlStream = xmlStream;
	}

	/**
	 * @return the statBeginDate
	 */
	public String getStatBeginDate() {
		return statBeginDate;
	}

	/**
	 * @param statBeginDate the statBeginDate to set
	 */
	public void setStatBeginDate(String statBeginDate) {
		this.statBeginDate = statBeginDate;
	}

	/**
	 * @return the statEndDate
	 */
	public String getStatEndDate() {
		return statEndDate;
	}

	/**
	 * @param statEndDate the statEndDate to set
	 */
	public void setStatEndDate(String statEndDate) {
		this.statEndDate = statEndDate;
	}

	/**
	 * @return the deptId
	 */
	public String getDeptId() {
		return deptId;
	}

	/**
	 * @param deptId the deptId to set
	 */
	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	/**
	 * @return the personId
	 */
	public String getPersonId() {
		return personId;
	}

	/**
	 * @param personId the personId to set
	 */
	public void setPersonId(String personId) {
		this.personId = personId;
	}

	private String compute(String old, String young) {
		Double a= new Double(0);
		Double b= new Double(0);
		try {
			Double.parseDouble(old);
		} catch (NumberFormatException e) {
			old="0";
		}
		try {
			Double.parseDouble(young);
		} catch (NumberFormatException e) {
			young="0";
		}
		a= (old!=null && !old.trim().equals("")) ? Double.parseDouble(old) : Double.parseDouble("0") ;
		b= (young!=null && !young.trim().equals("")) ? Double.parseDouble(young) : Double.parseDouble("0") ;
		return ""+(a+b);
	}
	/**
	 * @return the shortcutType
	 */
	public String getShortcutType() {
		return shortcutType;
	}
	/**
	 * @param shortcutType the shortcutType to set
	 */
	public void setShortcutType(String shortcutType) {
		this.shortcutType = shortcutType;
	}
	/**
	 * @return the salesPerformanceRankList
	 */
	public List<SalesPerformanceRank> getSalesPerformanceRankList() {
		return salesPerformanceRankList;
	}
	/**
	 * @param salesPerformanceRankList the salesPerformanceRankList to set
	 */
	public void setSalesPerformanceRankList(
			List<SalesPerformanceRank> salesPerformanceRankList) {
		this.salesPerformanceRankList = salesPerformanceRankList;
	}
}


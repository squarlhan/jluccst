package com.boan.crm.sellreport.monthly.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
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
import com.boan.crm.sellreport.weekly.model.WeeklyItemInfo;
import com.boan.crm.sellreport.weekly.model.WeeklyMainInfo;
import com.boan.crm.utils.action.BaseActionSupport;
import com.boan.crm.utils.calendar.CalendarUtils;
import com.boan.crm.utils.page.Pagination;

@Controller("monthlyMainInfoAction")
@Scope("prototype")
public class MonthlyMainInfoAction  extends BaseActionSupport{

	/**
	 * 月计划主信息
	 */
	private MonthlyMainInfo monthlyMainInfo;
	
	/**
	 * 部门列表
	 */
	private List<Deptment> deptList = null;
	
	/**
	 * 员工数组
	 */
	private List<User> userList = null;
	
	private String mainInfoId;
	
	private InputStream xmlStream;
	
	private String caption;
	
	private List<MonthlyItemInfo> monthlyItemInfoList = new ArrayList<MonthlyItemInfo>();
	
	/**
	 * 分页对象
	 */
	private Pagination<MonthlyMainInfo> pagination = new  Pagination<MonthlyMainInfo>() ;
	
	@Autowired
	@Qualifier("userService")
	private IUserService userService = null;
	
	@Autowired
	@Qualifier("deptService")
	private IDeptmentService deptService = null;
	
	@Autowired
	@Qualifier("monthlyMainInfoService")
	private IMonthlyMainInfoService monthlyMainInfoService;
	
	@Autowired
	@Qualifier("monthlyItemInfoService")
	private IMonthlyItemInfoService monthlyItemInfoService;
	
	@Autowired
	@Qualifier("sellRecordService")
	private ISellRecordService sellRecordService;
	
	@Autowired
	@Qualifier("popedomService")
	private IPopedomService popedomService = null;
	
	/**
	 * 提示信息
	 */
	private String message;
	
	/**
	 * 选择的时间计划Id
	 */
	private String[] ids;
	
	private String companyId = null;

	private String companyName = null;

	private String  personId;
	
	private String deptId;
	
	private String personName;
	
	private String queryTime;
	
	private String reference="";

	private String postName;
	
	/**
	 * 显示组织机构树
	 * 
	 * @return
	 */
	public String showGroupTreeForMonthlyMainInfo() throws Exception {
		companyId = sessionCompanyId;
		companyName = sessionCompanyName;
		userList = new ArrayList<User>();
		deptList = new ArrayList<Deptment>();
		boolean flag=true;
		if(sessionDeptId.equals("")){ //总经理
			flag=false;
		}
		
		if(flag){ //部门经理
			deptList.add(deptService.get(sessionDeptId));
		}else{    //总经理
			deptList = deptService.queryAllDeptmentsByCompanyId(sessionCompanyId);
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
		return "group-tree-for-monthly-main-info";
	}
	/**
	 * 显示组织机构树
	 * 
	 * @return
	 */
	public String showGroupTreeForMonthlyMainInfoView() throws Exception {
		companyId = sessionCompanyId;
		companyName = sessionCompanyName;
		userList = new ArrayList<User>();
		deptList = new ArrayList<Deptment>();
		boolean flag=true;
		if(sessionDeptId.equals("")){ //总经理
			flag=false;
		}
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
		return "group-tree-for-monthly-main-info-view";
	}
	
	/**
	 * 打开月计划列表页
	 * @return
	 * @throws Exception 
	 */
	public String openMonthlyMainInfoList() throws Exception{
		deptList = deptService.queryAllDeptmentsByCompanyId( sessionCompanyId );
		Map param = new HashMap();
		personId = sessionUserId;
		if(personId!=null && !personId.equals("")){
			param.put("personId", personId);
			personName =sessionUserCName;
		}
		if(queryTime!=null && !queryTime.equals("")){
			param.put("planInterzoneBegin", queryTime);
		}
		monthlyMainInfoService.findMonthlyMainInfoForPage(param, pagination);
		return this.SUCCESS;
	}
	/**
	 * 打开月计划列表页
	 * @return
	 * @throws Exception 
	 */
	public String openMonthlyMainInfoListView() throws Exception{
		deptList = deptService.queryAllDeptmentsByCompanyId( sessionCompanyId );
		Map param = new HashMap();
		if(personId!=null && !personId.equals("")){
			param.put("personId", personId);
			personName = userService.getUserById(personId).getUserCName();
		}else{
			param.put("deptId", deptId);
			if(personName!=null && !personName.equals("")){
				param.put("personName", personName);
			}
		}
		if(queryTime!=null && !queryTime.equals("")){
			param.put("planInterzoneBegin", queryTime);
		}
		monthlyMainInfoService.findMonthlyMainInfoForPage(param, pagination);
		return this.SUCCESS;
	}
	
	/**
	 * 打开月计划Tab页
	 * @return
	 */
	public String openTabPage(){
		return this.SUCCESS;
	}
	/**
	 * 打开月计划Tab页
	 * @return
	 */
	public String openTabPageView(){
		return this.SUCCESS;
	}
	
	public String openAddMonthlyMainInfo() throws Exception{
		deptList = deptService.queryAllDeptmentsByCompanyId( sessionCompanyId );
		userList =userService.queryUserList( sessionCompanyId, sessionDeptId, new Pagination<User>()).getData();
		
		System.out.println(reference);
		if(reference!=null && reference.equals("true")){
			Map<String,Object> params = new HashMap<String, Object>();
			personId = sessionUserId;
			if(personId!=null && !personId.equals("")){
				params.put("personId", personId);
			}
			monthlyMainInfo= monthlyMainInfoService.getLastMonthlyMainInfo(params);
		}
		if(monthlyMainInfo!=null){
			monthlyMainInfo.setId(null);
		}else{
			monthlyMainInfo = new MonthlyMainInfo();
		}
		
		monthlyMainInfo.setCompanyId(sessionCompanyId);
		monthlyMainInfo.setCompanyName(sessionCompanyName);
		
		monthlyMainInfo.setDeptId(sessionDeptId);
		monthlyMainInfo.setDeptName(sessionDeptName);
		
		monthlyMainInfo.setPersonId(sessionUserId);
		User user = userService.getUserById(sessionUserId);
		if(user!=null){
			postName = user.getRoleName();
			monthlyMainInfo.setPosition(postName);
		}
		
		monthlyMainInfo.setPersonId(sessionUserId);
		monthlyMainInfo.setPersonName(sessionUserCName);
		
		Calendar begin  = Calendar.getInstance();
		begin.set(Calendar.DAY_OF_MONTH,1);
		Calendar end  = Calendar.getInstance();
		end.set(Calendar.DAY_OF_MONTH,Calendar.getInstance().getActualMaximum(Calendar.DAY_OF_MONTH));
		
		monthlyMainInfo.setPlanInterzoneBegin(begin);
		monthlyMainInfo.setPlanInterzoneEnd(end);
		
		monthlyMainInfo.setCreateTime(Calendar.getInstance());
		return this.SUCCESS;
	}
	
	public String openModifyMonthlyMainInfo() throws Exception{
		deptList = deptService.queryAllDeptmentsByCompanyId( sessionCompanyId );
		userList =userService.queryUserList( sessionCompanyId, sessionDeptId, new Pagination<User>()).getData();
		monthlyMainInfo = monthlyMainInfoService.getMonthlyMainInfoById(mainInfoId);
		return this.SUCCESS;
	}
	public String openViewMonthlyMainInfo() throws Exception{
		deptList = deptService.queryAllDeptmentsByCompanyId( sessionCompanyId );
		userList =userService.queryUserList( sessionCompanyId, sessionDeptId, new Pagination<User>()).getData();
		monthlyMainInfo = monthlyMainInfoService.getMonthlyMainInfoById(mainInfoId);
		return this.SUCCESS;
	}
	
	public String addMonthlyMainInfo() throws Exception{
		if(monthlyMainInfo.getId().equals("")){
			monthlyMainInfo.setId(null);
		}
		
		String deptName =deptService.get(monthlyMainInfo.getDeptId()).getDeptName();
		monthlyMainInfo.setDeptName(deptName);
		
		String userName = userService.getUserById(monthlyMainInfo.getPersonId()).getUserCName();
		monthlyMainInfo.setPersonName(userName);
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy年-MM月-dd日");
		String planInterzone =  format.format(monthlyMainInfo.getPlanInterzoneBegin().getTime());
		planInterzone=planInterzone+"--"+ format.format(monthlyMainInfo.getPlanInterzoneEnd().getTime());
		monthlyMainInfo.setPlanInterzone(planInterzone );
		monthlyMainInfoService.saveOrUpdateMonthlyMainInfo(monthlyMainInfo);
		
		message="保存成功！";
		deptList = deptService.queryAllDeptmentsByCompanyId( sessionCompanyId );
		userList =userService.queryUserList( sessionCompanyId, sessionDeptId, new Pagination<User>()).getData();
		return this.SUCCESS;
	}
	
	public String modifyMonthlyMainInfo() throws Exception{
		deptList = deptService.queryAllDeptmentsByCompanyId( sessionCompanyId );
		userList =userService.queryUserList( sessionCompanyId, sessionDeptId, new Pagination<User>()).getData();
		
		String deptName =deptService.get(monthlyMainInfo.getDeptId()).getDeptName();
		monthlyMainInfo.setDeptName(deptName);
		
		String userName = userService.getUserById(monthlyMainInfo.getPersonId()).getUserCName();
		monthlyMainInfo.setPersonName(userName);
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy年-MM月-dd日");
		String planInterzone =  format.format(monthlyMainInfo.getPlanInterzoneBegin().getTime());
		planInterzone=planInterzone+"--"+ format.format(monthlyMainInfo.getPlanInterzoneEnd().getTime());
		monthlyMainInfo.setPlanInterzone(planInterzone );
		
		monthlyMainInfo.setCreateTime(Calendar.getInstance());
		monthlyMainInfoService.saveOrUpdateMonthlyMainInfo(monthlyMainInfo);
		message="保存成功！";
		return this.SUCCESS;
	}
	
	public String deleteMonthlyMainInfo() throws Exception{
		monthlyMainInfoService.deleteMonthlyMainInfoByIds(ids);
		return this.NONE;
	}

	public String showMonthlyStatInfo() {
		return this.SUCCESS;
	}
	
	public String openMonthlyReport(){
		monthlyMainInfo = monthlyMainInfoService.getMonthlyMainInfoById(mainInfoId);
		monthlyItemInfoList = monthlyItemInfoService.getMonthlyItemInfoListByMainInfoId(mainInfoId);
		return this.SUCCESS;
	}
	
	public String getMonthlyStatData(){
		List<MonthlyItemInfo>  sellTargerList = monthlyItemInfoService.getMonthlyItemInfoListOfSellTargetByMainInfoId(mainInfoId);
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
//				"divIntervalHints='150000' "+//纵坐标间隔
//				"displayStartIndex='1'"+       //默认显示从第一列开始
//				"displayEndIndex='7'" +        //默认显示到第七列
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
		MonthlyMainInfo mainInfo = monthlyMainInfoService.getMonthlyMainInfoById(mainInfoId);
		
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
		return this.SUCCESS;
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
	
	public InputStream getXmlStream() {
		return xmlStream;
	}
	
	public Pagination<MonthlyMainInfo> getPagination() {
		return pagination;
	}

	public void setPagination(Pagination<MonthlyMainInfo> pagination) {
		this.pagination = pagination;
	}

	public MonthlyMainInfo getMonthlyMainInfo() {
		return monthlyMainInfo;
	}

	public void setMonthlyMainInfo(MonthlyMainInfo monthlyMainInfo) {
		this.monthlyMainInfo = monthlyMainInfo;
	}

	public List<Deptment> getDeptList() {
		return deptList;
	}

	public void setDeptList(List<Deptment> deptList) {
		this.deptList = deptList;
	}

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String[] getIds() {
		return ids;
	}

	public void setIds(String[] ids) {
		this.ids = ids;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getPersonId() {
		return personId;
	}

	public void setPersonId(String personId) {
		this.personId = personId;
	}

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public String getMainInfoId() {
		return mainInfoId;
	}

	public void setMainInfoId(String mainInfoId) {
		this.mainInfoId = mainInfoId;
	}

	public void setXmlStream(InputStream xmlStream) {
		xmlStream = xmlStream;
	}

	public String getCaption() {
		return caption;
	}

	public void setCaption(String caption) {
		this.caption = caption;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public String getQueryTime() {
		return queryTime;
	}

	public void setQueryTime(String queryTime) {
		this.queryTime = queryTime;
	}
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	public List<MonthlyItemInfo> getMonthlyItemInfoList() {
		return monthlyItemInfoList;
	}
	public void setMonthlyItemInfoList(List<MonthlyItemInfo> monthlyItemInfoList) {
		this.monthlyItemInfoList = monthlyItemInfoList;
	}
	public String getPostName() {
		return postName;
	}
	public void setPostName(String postName) {
		this.postName = postName;
	}
}

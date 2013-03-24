package com.boan.crm.sellreport.weekly.action;

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
import com.boan.crm.sellreport.weekly.model.WeeklyItemInfo;
import com.boan.crm.sellreport.weekly.model.WeeklyMainInfo;
import com.boan.crm.sellreport.weekly.service.IWeeklyItemInfoService;
import com.boan.crm.sellreport.weekly.service.IWeeklyMainInfoService;
import com.boan.crm.utils.action.BaseActionSupport;
import com.boan.crm.utils.calendar.CalendarUtils;
import com.boan.crm.utils.page.Pagination;

@Controller("weeklyMainInfoAction")
@Scope("prototype")
public class WeeklyMainInfoAction  extends BaseActionSupport{

	/**
	 * 周计划主信息
	 */
	private WeeklyMainInfo weeklyMainInfo;
	
	private List<WeeklyItemInfo> weeklyItemInfoList = new ArrayList<WeeklyItemInfo>();
	
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
	
	private String personName;
	
	private String queryTime;
	
	private String reference="";
	
	
	/**
	 * 分页对象
	 */
	private Pagination<WeeklyMainInfo> pagination = new  Pagination<WeeklyMainInfo>() ;
	
	@Autowired
	@Qualifier("userService")
	private IUserService userService = null;
	
	@Autowired
	@Qualifier("deptService")
	private IDeptmentService deptService = null;
	
	@Autowired
	@Qualifier("weeklyMainInfoService")
	private IWeeklyMainInfoService weeklyMainInfoService;
	
	@Autowired
	@Qualifier("weeklyItemInfoService")
	private IWeeklyItemInfoService weeklyItemInfoService;
	
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
	
	/**
	 * 显示组织机构树
	 * 
	 * @return
	 */
	public String showGroupTreeForWeeklyMainInfo() throws Exception {
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
		return "group-tree-for-weekly-main-info";
	}
	/**
	 * 显示组织机构树
	 * 
	 * @return
	 */
	public String showGroupTreeForWeeklyMainInfoView() throws Exception {
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
		return "group-tree-for-weekly-main-info-view";
	}
	
	/**
	 * 打开周计划列表页
	 * @return
	 * @throws Exception 
	 */
	public String openWeeklyMainInfoList() throws Exception{
		deptList = deptService.queryAllDeptmentsByCompanyId( sessionCompanyId );
		Map param = new HashMap();
		personId = sessionUserId;
		if(personId!=null && !personId.equals("")){
			param.put("personId", personId);
			personName = sessionUserCName;
		}
		if(queryTime!=null && !queryTime.equals("")){
			param.put("planInterzoneBegin", queryTime);
		}
		
		weeklyMainInfoService.findWeeklyMainInfoForPage(param, pagination);
		return this.SUCCESS;
	}
	/**
	 * 打开周计划列表页
	 * @return
	 * @throws Exception 
	 */
	public String openWeeklyMainInfoListView() throws Exception{
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
		
		weeklyMainInfoService.findWeeklyMainInfoForPage(param, pagination);
		return this.SUCCESS;
	}
	
	/**
	 * 打开周计划Tab页
	 * @return
	 */
	public String openTabPage(){
		return this.SUCCESS;
	}
	/**
	 * 打开周计划Tab页
	 * @return
	 */
	public String openTabPageView(){
		return this.SUCCESS;
	}
	
	public String openAddWeeklyMainInfo() throws Exception{
		deptList = deptService.queryAllDeptmentsByCompanyId( sessionCompanyId );
		userList =userService.queryUserList( sessionCompanyId, sessionDeptId, new Pagination<User>()).getData();
		System.out.println(reference);
		if(reference!=null && reference.equals("true")){
			Map<String,Object> params = new HashMap<String, Object>();
			personId = sessionUserId;
			if(personId!=null && !personId.equals("")){
				params.put("personId", personId);
			}
			weeklyMainInfo= weeklyMainInfoService.getLastWeeklyMainInfo(params);
		}
		if(weeklyMainInfo!=null){
			weeklyMainInfo.setId(null);
		}else{
			weeklyMainInfo = new WeeklyMainInfo();
		}
		weeklyMainInfo.setCompanyId(sessionCompanyId);
		weeklyMainInfo.setCompanyName(sessionCompanyName);
		
		weeklyMainInfo.setDeptId(sessionDeptId);
		weeklyMainInfo.setDeptName(sessionDeptName);
		
		weeklyMainInfo.setPersonId(sessionUserId);
		weeklyMainInfo.setPersonName(sessionUserCName);
		
		Calendar begin  = CalendarUtils.getFirstDayOfWeek( Calendar.getInstance());
		Calendar end  = CalendarUtils.getLastDayOfWeek( Calendar.getInstance());
		weeklyMainInfo.setPlanInterzoneBegin(begin);
		weeklyMainInfo.setPlanInterzoneEnd(end);
		
		weeklyMainInfo.setCreateTime(Calendar.getInstance());
		return this.SUCCESS;
	}
	
	public String openModifyWeeklyMainInfo() throws Exception{
		deptList = deptService.queryAllDeptmentsByCompanyId( sessionCompanyId );
		userList =userService.queryUserList( sessionCompanyId, sessionDeptId, new Pagination<User>()).getData();
		weeklyMainInfo = weeklyMainInfoService.getWeeklyMainInfoById(mainInfoId);
		return this.SUCCESS;
	}
	public String openViewWeeklyMainInfo() throws Exception{
		deptList = deptService.queryAllDeptmentsByCompanyId( sessionCompanyId );
		userList =userService.queryUserList( sessionCompanyId, sessionDeptId, new Pagination<User>()).getData();
		weeklyMainInfo = weeklyMainInfoService.getWeeklyMainInfoById(mainInfoId);
		return this.SUCCESS;
	}
	
	public String addWeeklyMainInfo() throws Exception{
		if(weeklyMainInfo.getId().equals("")){
			weeklyMainInfo.setId(null);
		}
		
		String deptName =deptService.get(weeklyMainInfo.getDeptId()).getDeptName();
		weeklyMainInfo.setDeptName(deptName);
		
		String userName = userService.getUserById(weeklyMainInfo.getPersonId()).getUserCName();
		weeklyMainInfo.setPersonName(userName);
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy年-MM月-dd日");
		String planInterzone =  format.format(weeklyMainInfo.getPlanInterzoneBegin().getTime());
		planInterzone=planInterzone+"--"+ format.format(weeklyMainInfo.getPlanInterzoneEnd().getTime());
		weeklyMainInfo.setPlanInterzone(planInterzone );
		weeklyMainInfoService.saveOrUpdateWeeklyMainInfo(weeklyMainInfo);
		
		message="保存成功！";
		deptList = deptService.queryAllDeptmentsByCompanyId( sessionCompanyId );
		userList =userService.queryUserList( sessionCompanyId, sessionDeptId, new Pagination<User>()).getData();
		return this.SUCCESS;
	}
	
	public String modifyWeeklyMainInfo() throws Exception{
		deptList = deptService.queryAllDeptmentsByCompanyId( sessionCompanyId );
		userList =userService.queryUserList( sessionCompanyId, sessionDeptId, new Pagination<User>()).getData();
		
		String deptName =deptService.get(weeklyMainInfo.getDeptId()).getDeptName();
		weeklyMainInfo.setDeptName(deptName);
		
		String userName = userService.getUserById(weeklyMainInfo.getPersonId()).getUserCName();
		weeklyMainInfo.setPersonName(userName);
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy年-MM月-dd日");
		String planInterzone =  format.format(weeklyMainInfo.getPlanInterzoneBegin().getTime());
		planInterzone=planInterzone+"--"+ format.format(weeklyMainInfo.getPlanInterzoneEnd().getTime());
		weeklyMainInfo.setPlanInterzone(planInterzone );
		
		weeklyMainInfo.setCreateTime(Calendar.getInstance());
		weeklyMainInfoService.saveOrUpdateWeeklyMainInfo(weeklyMainInfo);
		message="保存成功！";
		return this.SUCCESS;
	}
	
	public String deleteWeeklyMainInfo() throws Exception{
		weeklyMainInfoService.deleteWeeklyMainInfoByIds(ids);
		return this.NONE;
	}
	
	public String showWeeklyStatInfo() {
		System.out.print(mainInfoId);
		return this.SUCCESS;
	}
	
	public String openWeeklyReport(){
		weeklyMainInfo = weeklyMainInfoService.getWeeklyMainInfoById(mainInfoId);
		weeklyItemInfoList =  weeklyItemInfoService.getWeeklyItemInfoListByMainInfoId(mainInfoId);
		return this.SUCCESS;
	}
	
	public String getWeeklyStatData(){
		List<WeeklyItemInfo>  sellTargerList = weeklyItemInfoService.getWeeklyItemInfoListOfSellTargetByMainInfoId(mainInfoId);
		String str="<chart palette='2' " +
				"caption='周销售计划对比统计' " +
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
		str=str+"<category label='周一' /> ";
		str=str+"<category label='周二' /> ";
		str=str+"<category label='周三' /> ";
		str=str+"<category label='周四' /> ";
		str=str+"<category label='周五' /> ";
		str=str+"<category label='周六' /> ";
		str=str+"<category label='周日' /> ";
		str=str+"</categories>";
		str=str+"<dataset seriesName='实际结果' color='FA0F1A'>";
		
		WeeklyMainInfo mainInfo = weeklyMainInfoService.getWeeklyMainInfoById(mainInfoId);
		
		//获取周计划开始和结束时间
		Calendar planInterzoneBegin = mainInfo.getPlanInterzoneBegin();
		Calendar planInterzoneEnd = mainInfo.getPlanInterzoneEnd();
		//获取填写的周计划是从周几到周几
		int dayOfWeekBegin = planInterzoneBegin.get(Calendar.DAY_OF_WEEK) -1 ;
		int dayOfWeekEnd = planInterzoneEnd.get(Calendar.DAY_OF_WEEK ) - 1 ;
		String dayNames[] ={"星期日","星期一","星期二","星期三","星期四","星期五","星期六"}; 
		System.out.println( dayNames[dayOfWeekBegin] +" 至 " + dayNames[dayOfWeekEnd]);

		if(dayOfWeekBegin>1){//说明不是周一也不是周日
			for(int i=1;i<dayOfWeekBegin;i++){
				//输出开始日期之前的空数据如 开始时间是 周三，则输出 周一到周二的数据
				str=str+"<set value='0' /> ";
			}
			Calendar tempVar =  planInterzoneBegin;
			for(int i=dayOfWeekBegin;i<=7;i++){
				//输出开始时间到周六的数据
				if(i!=7){
					System.out.println(CalendarUtils.toString(tempVar));
					BigDecimal dd = sellRecordService.getRealCollectionByBargainTime(sessionCompanyId, null, tempVar, tempVar);
					str=str+"<set value='"+ dd +"' /> ";
					tempVar.add(Calendar.DAY_OF_MONTH, 1);
				}else{
					//周日的数据
					System.out.println(CalendarUtils.toString(tempVar));
					BigDecimal dd = sellRecordService.getRealCollectionByBargainTime(sessionCompanyId, null, tempVar, tempVar);
					str=str+"<set value='"+ dd +"' /> ";
				}
			}
		}else if (dayOfWeekBegin==1){//说明是周一
			//输出周一到周日的数据
			Calendar tempVar =  planInterzoneBegin;
			for(int i=dayOfWeekBegin;i<=7;i++){
				//输出开始时间到周六的数据
				if(i!=7){
					System.out.println(CalendarUtils.toString(tempVar));
					BigDecimal dd = sellRecordService.getRealCollectionByBargainTime(sessionCompanyId, null, tempVar, tempVar);
					str=str+"<set value='"+ dd +"' /> ";
					tempVar.add(Calendar.DAY_OF_MONTH, 1);
				}else{
					//周日的数据
					System.out.println(CalendarUtils.toString(tempVar));
					BigDecimal dd = sellRecordService.getRealCollectionByBargainTime(sessionCompanyId, null, tempVar, tempVar);
					str=str+"<set value='"+ dd +"' /> ";
				}
			}
		}else if(dayOfWeekBegin==0){//说明是周日
			//输出6条空数据
			str=str+"<set value='0' /> ";
			str=str+"<set value='0' /> ";
			str=str+"<set value='0' /> ";
			str=str+"<set value='0' /> ";
			str=str+"<set value='0' /> ";
			str=str+"<set value='0' /> ";
			//输出周日的数据
			BigDecimal dd = sellRecordService.getRealCollectionByBargainTime(sessionCompanyId, null, planInterzoneBegin, planInterzoneBegin);
			str=str+"<set value='"+ dd +"' /> ";
		}
		str=str+"</dataset>";
		str=str+"<dataset seriesName='计划结果' color='65FA0F'>";
		boolean flag=false;
		if(sellTargerList!=null && sellTargerList.size()>0){
			WeeklyItemInfo temp = null;
			//如果添加了多个销售额类型的子项信息，则计算和各项的和
			boolean noAdd=false;//不累加标示
			for(WeeklyItemInfo item : sellTargerList){
				if(temp==null){
					temp = item;
					noAdd=true;//不累加
				}
				if(temp!=null ){
					if(!noAdd){
						temp.setMonday(compute(temp.getMonday(), item.getMonday()));
						temp.setTuesday(compute(temp.getTuesday(), item.getTuesday()));
						temp.setWednesday(compute(temp.getWednesday(), item.getWednesday()));
						temp.setThursday(compute(temp.getThursday(), item.getThursday()));
						temp.setFriday(compute(temp.getFriday(), item.getFriday()));
						temp.setSaturday(compute(temp.getSaturday(), item.getSaturday()));
						temp.setSunday(compute(temp.getSunday(), item.getSunday()));
					}
					noAdd=false;
					flag = true;
				}
			}
			if(flag){//计算的实际值显示
				str=str+"<set value='"+temp.getMonday()+"' /> ";
				str=str+"<set value='"+temp.getTuesday()+"' /> ";
				str=str+"<set value='"+temp.getWednesday()+"' /> ";
				str=str+"<set value='"+temp.getThursday()+"' /> ";
				str=str+"<set value='"+temp.getFriday()+"' /> ";
				str=str+"<set value='"+temp.getSaturday()+"' /> ";
				str=str+"<set value='"+temp.getSunday()+"' /> ";
			}
		}
		if(!flag){//使用默认值
			str=str+"<set value='0' /> ";
			str=str+"<set value='0' /> ";
			str=str+"<set value='0' /> ";
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

	public Pagination<WeeklyMainInfo> getPagination() {
		return pagination;
	}

	public void setPagination(Pagination<WeeklyMainInfo> pagination) {
		this.pagination = pagination;
	}

	public WeeklyMainInfo getWeeklyMainInfo() {
		return weeklyMainInfo;
	}

	public void setWeeklyMainInfo(WeeklyMainInfo weeklyMainInfo) {
		this.weeklyMainInfo = weeklyMainInfo;
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

	public InputStream getXmlStream() {
		return xmlStream;
	}

	public void setXmlStream(InputStream xmlStream) {
		this.xmlStream = xmlStream;
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
	public List<WeeklyItemInfo> getWeeklyItemInfoList() {
		return weeklyItemInfoList;
	}
	public void setWeeklyItemInfoList(List<WeeklyItemInfo> weeklyItemInfoList) {
		this.weeklyItemInfoList = weeklyItemInfoList;
	}
}

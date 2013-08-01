package com.boan.crm.timemanage.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;
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
import com.boan.crm.timemanage.model.TimePlan;
import com.boan.crm.timemanage.model.TimePlanDeptInfo;
import com.boan.crm.timemanage.model.TimePlanForJson;
import com.boan.crm.timemanage.model.TimePlanInfoForJson;
import com.boan.crm.timemanage.model.TimePlanStaffPersonInfo;
import com.boan.crm.timemanage.service.ITimePlanService;
import com.boan.crm.utils.action.BaseActionSupport;
import com.boan.crm.utils.calendar.CalendarUtils;
import com.boan.crm.utils.page.Pagination;

/**
 * 时间管理Action
 * @author YF
 *
 */
@Controller("timePlanAction")
@Scope("prototype")
public class TimePlanAction extends BaseActionSupport{

	@Autowired
	@Qualifier("userService")
	private IUserService userService = null;
	
	@Autowired
	@Qualifier("deptService")
	private IDeptmentService deptService = null;
	
	@Autowired
	@Qualifier("timePlanService")
	private ITimePlanService timePlanService = null;
	
	@Autowired
	@Qualifier("popedomService")
	private IPopedomService popedomService = null;
	
	/**
	 * 时间计划实体
	 */
	private TimePlan timePlan;
	
	/**
	 * 部门列表
	 */
	private List<Deptment> deptList = null;
	
	/**
	 * 员工数组
	 */
	private List<User> userList = null;
	
	/**
	 * 显示分页
	 */
	private Pagination<TimePlan> pagination = new Pagination<TimePlan>();
	
	/**
	 * 提示信息
	 */
	private String message;
	
	/**
	 * 选择的时间计划Id
	 */
	private String[] ids;
	/**
	 * 查询条件 员工名
	 */
	private String employeeName;
	
	/**
	 * 查询条件 计划类型
	 */
	private String planType;
	
	/**
	 * 查询条件 提交开始时间
	 */
	private Calendar beginTime;
	
	/**
	 * 查询条件 提交结束时间
	 */
	private Calendar endTime;
	
	private String deptId=null;
	
	private String userId=null;
	
	private String reference="";
    //日报Id
	private String dailyId;
	
	/**
	 * 显示组织机构树,带公司、工厂、车间
	 * 
	 * @return
	 */
	public String showGroupTreeForTimePlan() throws Exception {
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
		/*
		 * JHY 注
		if(flag){ //部门经理
			deptList.add(deptService.get(sessionDeptId));
		}else{    //总经理
			deptList = deptService.queryAllDeptmentsByCompanyId(sessionCompanyId);
		}
		*/
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
		return "group-tree-for-sell-record";
	}

	/**
	 * 显示计划列表
	 * @return
	 */
	public String openTimePlanListForView() {
		if(beginTime==null && endTime==null){
			Calendar temp = Calendar.getInstance();
			temp.set(Calendar.DATE, -15);
			beginTime =temp;
			endTime = Calendar.getInstance();
		}
		Map<String,Object> params = new HashMap<String, Object>();
//		params.put("personId", this.sessionUserId);
		params.put("organId", this.sessionCompanyId);
		params.put("employeeName", employeeName);
		params.put("planType", planType);
		params.put("beginTime", beginTime);
		params.put("endTime", endTime); 
		if(!deptId.equals("")){
			params.put("deptId", deptId);
		}
		if(userId!=null && !userId.equals("")){
			params.put("employeeId", userId);
		}
		pagination = timePlanService.findTimePlanForPage(params,pagination);
		
		return SUCCESS;
	}
	
	/**
	 * 显示计划列表
	 * @return
	 */
	public String openTimePlanList() {
		if(beginTime==null && endTime==null){
			Calendar temp = Calendar.getInstance();
			temp.set(Calendar.DATE, -15);
			beginTime =temp;
			endTime = Calendar.getInstance();
		}
		Map<String,Object> params = new HashMap<String, Object>();
		params.put("personId", this.sessionUserId);
		params.put("organId", this.sessionCompanyId);
		params.put("employeeName", employeeName);
		params.put("planType", planType);
		params.put("beginTime", beginTime);
		params.put("endTime", endTime); 
		pagination = timePlanService.findTimePlanForPage(params,pagination);
		
		return SUCCESS;
	}
	/**
	 * 打开添加页
	 * @return
	 * @throws Exception 
	 */
	public String openAddTimePlan() throws Exception {
		deptList = deptService.queryAllDeptmentsByCompanyId( sessionCompanyId );
		userList =userService.queryUserList( sessionCompanyId, sessionDeptId, new Pagination<User>()).getData();
		if(reference!=null && reference.equals("true")){
			Map<String,Object> params = new HashMap<String, Object>();
			params.put("personId", this.sessionUserId);
			params.put("organId", this.sessionCompanyId);
			params.put("planType", timePlan.getPlanType());
			TimePlan  temp  = timePlanService.getLastTimePlan(params);
			timePlan.setId(null);
			if(temp!=null){
				timePlan.setPlanContent(temp.getPlanContent());//明日计划
				timePlan.setMemo(temp.getMemo());//今日总结
			}else{
				timePlan.setPlanContent("");//明日计划
				timePlan.setMemo("");//今日总结
				timePlan.setCreateTime(Calendar.getInstance());
			}
		}else{
			timePlan = new TimePlan();
			timePlan.setDeptId(sessionDeptId);
			timePlan.setEmployeeId(sessionUserId);
			timePlan.setCreateTime(Calendar.getInstance());
		}
		return SUCCESS;
	}
	/**
	 * 添加计划
	 * @return
	 * @throws Exception 
	 */
	public String addTimePlan() throws Exception {
		deptList = deptService.queryAllDeptmentsByCompanyId( sessionCompanyId );
		userList =userService.queryUserList( sessionCompanyId, sessionDeptId, new Pagination<User>()).getData();
		if(timePlan!=null){
//			String deptName= deptService.get(timePlan.getDeptId()).getDeptName();
//			String userName =userService.getUserById(timePlan.getEmployeeId()).getUserCName();
//			timePlan.setDeptName(deptName);
//			timePlan.setEmployeeName(userName);
			for(Deptment dept : deptList){
				if(dept.getId().equals(timePlan.getDeptId())){
					timePlan.setDeptName(dept.getDeptName());
				}
			}
			for(User user : userList){
				if(user.getId().equals(timePlan.getEmployeeId())){
					timePlan.setEmployeeName(user.getUserCName());
				}
			}
			timePlan.setCreateTime(Calendar.getInstance());
			//保存
			timePlan.setId(null);
			timePlan.setPersonId(sessionUserId);
			timePlan.setOrganId(sessionCompanyId);
			timePlanService.saveOrUpdateTimePlan(timePlan);
			message="保存成功！";
		}
		
		return SUCCESS;
	}
	
	/**
	 * 打开修改页
	 * @return
	 * @throws Exception 
	 */
	public String openModifyTimePlanForView() throws Exception {
		deptList = deptService.queryAllDeptmentsByCompanyId( sessionCompanyId );
		userList =userService.queryUserList( sessionCompanyId, sessionDeptId, new Pagination<User>()).getData();
		if(timePlan!=null){
			timePlan = timePlanService.getTimePlanById(timePlan.getId());
		}
		return SUCCESS;
	}
	
	/**
	 * 打开修改页
	 * @return
	 * @throws Exception 
	 */
	public String openModifyTimePlan() throws Exception {
		deptList = deptService.queryAllDeptmentsByCompanyId( sessionCompanyId );
		userList =userService.queryUserList( sessionCompanyId, sessionDeptId, new Pagination<User>()).getData();
		if(timePlan!=null){
			timePlan = timePlanService.getTimePlanById(timePlan.getId());
		}
		return SUCCESS;
	}
	/**
	 * 修改计划
	 * @return
	 * @throws Exception 
	 */
	public String modifyTimePlan() throws Exception {
		deptList = deptService.queryAllDeptmentsByCompanyId( sessionCompanyId );
		userList =userService.queryUserList( sessionCompanyId, sessionDeptId, new Pagination<User>()).getData();
		if(timePlan!=null){
			for(Deptment dept : deptList){
				if(dept.getId().equals(timePlan.getDeptId())){
					timePlan.setDeptName(dept.getDeptName());
				}
			}
			for(User user : userList){
				if(user.getId().equals(timePlan.getEmployeeId())){
					timePlan.setEmployeeName(user.getUserCName());
				}
			}
			//修改
			timePlanService.saveOrUpdateTimePlan(timePlan);
			message="保存成功！";
		}
		return SUCCESS;
	}

	/**
	 * 删除时间计划
	 * @return
	 */
	public String deleteTimePlan(){
		timePlanService.deleteTimePlan(ids);
		return NONE;
	}
	
	
	/**
	 * 获取日程返回Json串给手机客户端
	 * @return
	 */
	public String getDailyInfoForPhone()
	{
		HttpServletRequest request = ServletActionContext.getRequest();
		Map<String,Object> map = new HashMap<String,Object>();
		if(StringUtils.trimToNull(userId)!=null)
		{
			beginTime.set(Calendar.HOUR_OF_DAY, 0);
			beginTime.set(Calendar.MINUTE , 0 );
			beginTime.set(Calendar.SECOND, 0);
			
			endTime.set(Calendar.HOUR_OF_DAY, 23);
			endTime.set(Calendar.MINUTE , 59 );
			endTime.set(Calendar.SECOND, 59);
			Map<String,Object> params = new HashMap<String, Object>();
//			params.put("personId", this.sessionUserId);
			 
			params.put("beginTime", beginTime);
			params.put("endTime", endTime); 
			params.put("employeeId", userId);
			List<TimePlan> listTimePlan =timePlanService.findTimePlan(params);
			List<TimePlanForJson> listTim = new ArrayList<TimePlanForJson>();
			if(listTimePlan != null && listTimePlan.size() > 0)
			{
				for(int i = 0;i<listTimePlan.size();i++)
				{
					TimePlanForJson obj = new TimePlanForJson();
					//0:'日报',1:'周报',2:'月报'
//					if(listTimePlan.get(i).getPlanType().equals("0")){
//						obj.setType("日报");
//					}
//					if(listTimePlan.get(i).getPlanType().equals("1")){
//						obj.setType("周报");
//					}
//					if(listTimePlan.get(i).getPlanType().equals("2")){
//						obj.setType("月报");
//					}
					obj.setId(listTimePlan.get(i).getId());
					obj.setType("2");
					obj.setDate(CalendarUtils.toLongStringNoSecond(listTimePlan.get(i).getSubmitTime()));
					obj.setSummary(listTimePlan.get(i).getMemo());
					obj.setPlan(listTimePlan.get(i).getPlanContent());
					listTim.add(obj);
				}
			}
			
			map.put("dialy", listTim);
		}
		request.setAttribute("map", map);
		return COMMON_MAP;
	}
	
	/**
	 * 获取部门人员日程返回Json串给手机客户端
	 * @return
	 */
	public String getDeptDailyInfoForPhone()
	{
		try {
			HttpServletRequest request = ServletActionContext.getRequest();
			Map<String,Object> map = new HashMap<String,Object>();
			if(StringUtils.trimToNull(deptId)==null)
			{
				deptId = userService.getUserById(userId).getDeptId();
			}
			beginTime.set(Calendar.HOUR_OF_DAY, 0);
			beginTime.set(Calendar.MINUTE , 0 );
			beginTime.set(Calendar.SECOND, 0);
			
			endTime.set(Calendar.HOUR_OF_DAY, 23);
			endTime.set(Calendar.MINUTE , 59 );
			endTime.set(Calendar.SECOND, 59);
			
			Map<String,Object> params = new HashMap<String, Object>();
			params.put("beginTime", beginTime);
			params.put("endTime", endTime); 
			params.put("deptId", deptId);
			List<TimePlan> listTimePlan =timePlanService.findTimePlan(params);
			List<TimePlanInfoForJson> listTim = new ArrayList<TimePlanInfoForJson>();
			List<TimePlanStaffPersonInfo> listPerson = new ArrayList<TimePlanStaffPersonInfo>();
			if(listTimePlan != null && listTimePlan.size() > 0)
			{
				for(int i = 0;i<listTimePlan.size();i++)
				{
					TimePlanInfoForJson obj = new TimePlanInfoForJson();
					TimePlanStaffPersonInfo person = new TimePlanStaffPersonInfo();
					obj.setId(listTimePlan.get(i).getId());
					obj.setName(listTimePlan.get(i).getEmployeeName());
					obj.setType("2");
					obj.setDate(CalendarUtils.toLongStringNoSecond(listTimePlan.get(i).getSubmitTime()));
					obj.setSummary(listTimePlan.get(i).getMemo());
					obj.setPlan(listTimePlan.get(i).getPlanContent());
					listTim.add(obj);
					
					person.setId(listTimePlan.get(i).getEmployeeId());
					person.setName(listTimePlan.get(i).getEmployeeName());
					
					listPerson.add(person);
				}
			}
			
			map.put("dialy", listTim);
			map.put("staff", listPerson);
			request.setAttribute("map", map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return COMMON_MAP;
	}
	
	
	/**
	 * 获取公司人员日程返回Json串给手机客户端
	 * @return
	 */
	public String getLeadDailyInfoForPhone()
	{
		try {
			HttpServletRequest request = ServletActionContext.getRequest();
			Map<String,Object> map = new HashMap<String,Object>();
			
			//当前登录人
			User currentUser = userService.getUserById(userId);
			String companyId =currentUser.getCompanyId();
			List<Deptment>  deptList = deptService.queryAllDeptmentsByCompanyId(companyId);
			List<TimePlanDeptInfo> listDept = new ArrayList<TimePlanDeptInfo>();
			List<TimePlanInfoForJson> listTim = new ArrayList<TimePlanInfoForJson>();
			List<TimePlanStaffPersonInfo> listPerson = new ArrayList<TimePlanStaffPersonInfo>();
			for(Deptment dept : deptList){
				deptId = dept.getId();
				TimePlanDeptInfo tempDetp = new TimePlanDeptInfo();
				tempDetp.setId(dailyId);
				tempDetp.setName(dept.getDeptName());
				listDept.add(tempDetp);
				
				beginTime.set(Calendar.HOUR_OF_DAY, 0);
				beginTime.set(Calendar.MINUTE , 0 );
				beginTime.set(Calendar.SECOND, 0);
				
				endTime.set(Calendar.HOUR_OF_DAY, 23);
				endTime.set(Calendar.MINUTE , 59 );
				endTime.set(Calendar.SECOND, 59);
				Map<String,Object> params = new HashMap<String, Object>();
				 
				params.put("beginTime", beginTime);
				params.put("endTime", endTime); 
				params.put("deptId", deptId);
				List<TimePlan> listTimePlan =timePlanService.findTimePlan(params);
				
				if(listTimePlan != null && listTimePlan.size() > 0)
				{
					for(int i = 0;i<listTimePlan.size();i++)
					{
						TimePlanInfoForJson obj = new TimePlanInfoForJson();
						TimePlanStaffPersonInfo person = new TimePlanStaffPersonInfo();
						obj.setId(listTimePlan.get(i).getId());
						obj.setName(listTimePlan.get(i).getEmployeeName());
						obj.setType("2");
						obj.setDate(CalendarUtils.toLongStringNoSecond(listTimePlan.get(i).getSubmitTime()));
						obj.setSummary(listTimePlan.get(i).getMemo());
						obj.setPlan(listTimePlan.get(i).getPlanContent());
						listTim.add(obj);
						
						person.setId(listTimePlan.get(i).getEmployeeId());
						person.setName(listTimePlan.get(i).getEmployeeName());
						
						listPerson.add(person);
					}
				}
				
				map.put("department", listDept);
				map.put("dialy", listTim);
				map.put("staff", listPerson);
			}
			request.setAttribute("map", map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return COMMON_MAP;
	}
	
	/**
	 * 获取日程返回Json串给手机客户端
	 * @return
	 */
	public String getDailyInfoByIdForPhone()
	{
		HttpServletRequest request = ServletActionContext.getRequest();
		if(StringUtils.trimToNull(dailyId)!=null)
		{
			Map<String,Object> params = new HashMap<String, Object>();
			params.put("id", dailyId);
			TimePlan timePlan =timePlanService.getTimePlanById(dailyId);
			if(timePlan!=null){
				String str= "{";
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
				String dateString = formatter.format(timePlan.getSubmitTime().getTime());
				str = str +"'date':'" + dateString+"'";
				String summary = timePlan.getMemo();
				str = str +",'summary':'" +( summary==null ? "" : summary )+"'";
				String plan = timePlan.getPlanContent();
				str = str +",'plan': '" + (plan==null ? "" : plan)+"'";
				str = str +"}" ;
				request.setAttribute("info", str);
			}
		}
		
		return this.SUCCESS;
	}
	
	
	/**
	 * 维护时间计划给手机客户端
	 * @return
	 * @throws Exception 
	 */
	public String saveOrUpdateTimePlanForPhone() {
		Map<String,Object> map = new HashMap<String,Object>();
		try{
			if(timePlan!=null && userId!=null &&  !userId.trim().equals("")){
				//保存
				if(timePlan.getId()==null || timePlan.getId().trim().equals("")){
					User user = userService.getUserById(userId);
					String companyId = user.getCompanyId();
					String deptId = user.getDeptId();
					deptList = deptService.queryAllDeptmentsByCompanyId( companyId );
					for(Deptment dept : deptList){
						if(dept.getId().equals(deptId)){
							timePlan.setDeptName(dept.getDeptName());
							break;
						}
					}
					timePlan.setId(null);
					timePlan.setOrganId(companyId);
					timePlan.setDeptId(deptId);
					timePlan.setEmployeeId(userId);
					timePlan.setEmployeeName(user.getUserCName());
					timePlan.setPersonId(userId);
					timePlan.setPlanType("0");//默认为日报
					timePlan.setCreateTime(Calendar.getInstance());
					timePlanService.saveOrUpdateTimePlan(timePlan);
				}else if(timePlan.getId()!=null && !timePlan.getId().trim().equals("")) {
					//修改
					TimePlan temp = timePlanService.getTimePlanById(timePlan.getId());
					if(temp!=null){
						temp.setPlanContent(timePlan.getPlanContent());
						temp.setSubmitTime(timePlan.getSubmitTime());
						temp.setMemo(timePlan.getMemo());
						timePlanService.saveOrUpdateTimePlan(temp);
					}else{
						map.put("status", "failure");
					}
				}
				map.put("status", "success");
			}
		}catch(Exception e){
			map.put("status", "failure");
			//e.printStackTrace();
		}
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("map", map);
		return COMMON_MAP;
	}
	
	public Pagination<TimePlan> getPagination() {
		return pagination;
	}

	public void setPagination(Pagination<TimePlan> pagination) {
		this.pagination = pagination;
	}
	public TimePlan getTimePlan() {
		return timePlan;
	}
	public void setTimePlan(TimePlan timePlan) {
		this.timePlan = timePlan;
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
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getPlanType() {
		return planType;
	}
	public void setPlanType(String planType) {
		this.planType = planType;
	}
	public Calendar getBeginTime() {
		return beginTime;
	}
	public void setBeginTime(Calendar beginTime) {
		this.beginTime = beginTime;
	}
	public Calendar getEndTime() {
		return endTime;
	}
	public void setEndTime(Calendar endTime) {
		this.endTime = endTime;
	}

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	/**
	 * @return the dailyId
	 */
	public String getDailyId() {
		return dailyId;
	}

	/**
	 * @param dailyId the dailyId to set
	 */
	public void setDailyId(String dailyId) {
		this.dailyId = dailyId;
	}
}

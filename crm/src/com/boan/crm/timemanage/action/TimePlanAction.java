package com.boan.crm.timemanage.action;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.boan.crm.groupmanage.model.Deptment;
import com.boan.crm.groupmanage.model.User;
import com.boan.crm.groupmanage.service.IDeptmentService;
import com.boan.crm.groupmanage.service.IUserService;
import com.boan.crm.timemanage.model.TimePlan;
import com.boan.crm.timemanage.service.ITimePlanService;
import com.boan.crm.utils.action.BaseActionSupport;
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
	
	/**
	 * 显示组织机构树,带公司、工厂、车间
	 * 
	 * @return
	 */
	public String showGroupTreeForTimePlan() throws Exception {
		deptList = deptService.queryAllDeptmentsByCompanyId(sessionCompanyId);
		userList = new ArrayList<User>();
		// 获取用户列表
		if (deptList != null && deptList.size() > 0) {
			List<User> tempUserList = new ArrayList<User>();
			for (int i = 0; i < deptList.size(); i++) {
				List<User> tempList = userService.queryUserList(sessionCompanyId, deptList.get(i).getId());
				if (tempList != null && tempList.size() > 0) {
					tempUserList.addAll(tempList);
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
		params.put("personId", this.sessionUserId);
		params.put("organId", this.sessionCompanyId);
		params.put("employeeName", employeeName);
		params.put("planType", planType);
		params.put("beginTime", beginTime);
		params.put("endTime", endTime); 
		params.put("deptId", deptId);
		params.put("employeeId", userId);
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
}

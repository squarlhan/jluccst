package com.boan.crm.actionplan.action;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.boan.crm.actionplan.model.ActionPlan;
import com.boan.crm.actionplan.service.IActionPlanService;
import com.boan.crm.groupmanage.common.UserSession;
import com.boan.crm.groupmanage.model.Deptment;
import com.boan.crm.groupmanage.model.User;
import com.boan.crm.groupmanage.service.IDeptmentService;
import com.boan.crm.groupmanage.service.IPopedomService;
import com.boan.crm.groupmanage.service.IUserService;
import com.boan.crm.utils.action.BaseActionSupport;
import com.boan.crm.utils.page.Pagination;

/**
 * 行动计划管理Action
 * @author YF
 *
 */
@Controller("actionPlanAction")
@Scope("prototype")
public class ActionPlanAction extends BaseActionSupport{

	private static final long serialVersionUID = 9047907731349699587L;

	@Autowired
	@Qualifier("userService")
	private IUserService userService = null;
	
	@Autowired
	@Qualifier("deptService")
	private IDeptmentService deptService = null;
	
	@Autowired
	@Qualifier("actionPlanService")
	private IActionPlanService actionPlanService = null;
	
	@Autowired
	@Qualifier("popedomService")
	private IPopedomService popedomService = null;
	
	/**
	 * 行动计划实体
	 */
	private ActionPlan actionPlan;
	
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
	private Pagination<ActionPlan> pagination = new Pagination<ActionPlan>();
	
	/**
	 * 提示信息
	 */
	private String message;
	
	/**
	 * 选择的行动计划Id
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
	 * 查询条件 提交开始行动
	 */
	private Calendar beginTime;
	
	/**
	 * 查询条件 提交结束行动
	 */
	private Calendar endTime;
	
	private String deptId=null;
	
	private String userId=null;
	
	/**
	 * 显示组织机构树,带公司、工厂、车间
	 * 
	 * @return
	 */
	public String showGroupTreeForActionPlan() throws Exception {
		userList = new ArrayList<User>();
		deptList = new ArrayList<Deptment>();
//		boolean flag=true;
//		if(sessionDeptId.equals("")){ //总经理
//			flag=false;
//		}
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
	public String openActionPlanListForView() {
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
		if(beginTime!=null){
			params.put("beginTime", beginTime);
		}
		if(endTime!=null){
			params.put("endTime", endTime); 
		}
		params.put("deptId", deptId);
		if(userId!=null && !userId.equals("")){
			params.put("employeeId", userId);
		}
		
		pagination = actionPlanService.findActionPlanForPage(params,pagination);
		
		return SUCCESS;
	}
	
	/**
	 * 显示计划列表
	 * @return
	 */
	public String openActionPlanList() {
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
		if(beginTime!=null){
			params.put("beginTime", beginTime);
		}
		if(endTime!=null){
			params.put("endTime", endTime); 
		}
		pagination = actionPlanService.findActionPlanForPage(params,pagination);
		
		return SUCCESS;
	}
	/**
	 * 打开添加页
	 * @return
	 * @throws Exception 
	 */
	public String openAddActionPlan() throws Exception {
		deptList = deptService.queryAllDeptmentsByCompanyId( sessionCompanyId );
		userList =userService.queryUserList( sessionCompanyId, sessionDeptId, new Pagination<User>()).getData();
		actionPlan = new ActionPlan();
		actionPlan.setDeptId(sessionDeptId);
		actionPlan.setEmployeeId(sessionUserId);
		return SUCCESS;
	}
	/**
	 * 添加计划
	 * @return
	 * @throws Exception 
	 */
	public String addActionPlan() throws Exception {
		deptList = deptService.queryAllDeptmentsByCompanyId( sessionCompanyId );
		userList =userService.queryUserList( sessionCompanyId, sessionDeptId, new Pagination<User>()).getData();
		if(actionPlan!=null){
//			String deptName= deptService.get(ActionPlan.getDeptId()).getDeptName();
//			String userName =userService.getUserById(ActionPlan.getEmployeeId()).getUserCName();
//			ActionPlan.setDeptName(deptName);
//			ActionPlan.setEmployeeName(userName);
			for(Deptment dept : deptList){
				if(dept.getId().equals(actionPlan.getDeptId())){
					actionPlan.setDeptName(dept.getDeptName());
				}
			}
			for(User user : userList){
				if(user.getId().equals(actionPlan.getEmployeeId())){
					actionPlan.setEmployeeName(user.getUserCName());
				}
			}
			actionPlan.setCreateTime(Calendar.getInstance());
			//保存
			actionPlan.setId(null);
			actionPlan.setPersonId(sessionUserId);
			actionPlan.setOrganId(sessionCompanyId);
			actionPlanService.saveOrUpdateActionPlan(actionPlan);
			message="保存成功！";
		}
		
		return SUCCESS;
	}
	
	/**
	 * 打开修改页
	 * @return
	 * @throws Exception 
	 */
	public String openModifyActionPlanForView() throws Exception {
		deptList = deptService.queryAllDeptmentsByCompanyId( sessionCompanyId );
		userList =userService.queryUserList( sessionCompanyId, sessionDeptId, new Pagination<User>()).getData();
		if(actionPlan!=null){
			actionPlan = actionPlanService.getActionPlanById(actionPlan.getId());
		}
		return SUCCESS;
	}
	
	/**
	 * 打开修改页
	 * @return
	 * @throws Exception 
	 */
	public String openModifyActionPlan() throws Exception {
		deptList = deptService.queryAllDeptmentsByCompanyId( sessionCompanyId );
		userList =userService.queryUserList( sessionCompanyId, sessionDeptId, new Pagination<User>()).getData();
		if(actionPlan!=null){
			actionPlan = actionPlanService.getActionPlanById(actionPlan.getId());
		}
		return SUCCESS;
	}
	/**
	 * 修改计划
	 * @return
	 * @throws Exception 
	 */
	public String modifyActionPlan() throws Exception {
		deptList = deptService.queryAllDeptmentsByCompanyId( sessionCompanyId );
		userList =userService.queryUserList( sessionCompanyId, sessionDeptId, new Pagination<User>()).getData();
		if(actionPlan!=null){
			for(Deptment dept : deptList){
				if(dept.getId().equals(actionPlan.getDeptId())){
					actionPlan.setDeptName(dept.getDeptName());
				}
			}
			for(User user : userList){
				if(user.getId().equals(actionPlan.getEmployeeId())){
					actionPlan.setEmployeeName(user.getUserCName());
				}
			}
			//修改
			actionPlanService.saveOrUpdateActionPlan(actionPlan);
			message="保存成功！";
		}
		return SUCCESS;
	}

	/**
	 * 删除行动计划
	 * @return
	 */
	public String deleteActionPlan(){
		actionPlanService.deleteActionPlan(ids);
		return NONE;
	}
	public Pagination<ActionPlan> getPagination() {
		return pagination;
	}

	public void setPagination(Pagination<ActionPlan> pagination) {
		this.pagination = pagination;
	}
	public ActionPlan getActionPlan() {
		return actionPlan;
	}
	public void setActionPlan(ActionPlan actionPlan) {
		this.actionPlan = actionPlan;
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

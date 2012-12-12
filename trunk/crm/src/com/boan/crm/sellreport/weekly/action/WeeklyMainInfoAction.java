package com.boan.crm.sellreport.weekly.action;

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

import com.boan.crm.groupmanage.model.Deptment;
import com.boan.crm.groupmanage.model.User;
import com.boan.crm.groupmanage.service.IDeptmentService;
import com.boan.crm.groupmanage.service.IUserService;
import com.boan.crm.sellreport.weekly.model.WeeklyMainInfo;
import com.boan.crm.sellreport.weekly.service.IWeeklyMainInfoService;
import com.boan.crm.utils.action.BaseActionSupport;
import com.boan.crm.utils.page.Pagination;

@Controller("weeklyMainInfoAction")
@Scope("prototype")
public class WeeklyMainInfoAction  extends BaseActionSupport{

	/**
	 * 周计划主信息
	 */
	private WeeklyMainInfo weeklyMainInfo;
	
	/**
	 * 部门列表
	 */
	private List<Deptment> deptList = null;
	
	/**
	 * 员工数组
	 */
	private List<User> userList = null;
	
	private String mainInfoId;
	
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
			//flag=false;
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
	 * 打开周计划列表页
	 * @return
	 */
	public String openWeeklyMainInfoList(){
		deptList = deptService.queryAllDeptmentsByCompanyId( sessionCompanyId );
		Map param = new HashMap();
		if(personId!=null && !personId.equals("")){
			param.put("personId", personId);
		}else{
			param.put("deptId", deptId);
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
	
	public String openAddWeeklyMainInfo() throws Exception{
		deptList = deptService.queryAllDeptmentsByCompanyId( sessionCompanyId );
		userList =userService.queryUserList( sessionCompanyId, sessionDeptId, new Pagination<User>()).getData();
		weeklyMainInfo = new WeeklyMainInfo();
		
		weeklyMainInfo.setCompanyId(sessionCompanyId);
		weeklyMainInfo.setCompanyName(sessionCompanyName);
		
		weeklyMainInfo.setDeptId(sessionDeptId);
		weeklyMainInfo.setDeptName(sessionDeptName);
		
		weeklyMainInfo.setPersonId(sessionUserId);
		weeklyMainInfo.setPersonName(sessionUserCName);
		
		Calendar begin  = Calendar.getInstance();
		begin.set(Calendar.DAY_OF_MONTH,1);
		Calendar end  = Calendar.getInstance();
		end.set(Calendar.DAY_OF_MONTH,Calendar.getInstance().getActualMaximum(Calendar.DAY_OF_MONTH));
		
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
}

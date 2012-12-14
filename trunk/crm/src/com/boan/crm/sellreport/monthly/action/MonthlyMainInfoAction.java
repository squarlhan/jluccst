package com.boan.crm.sellreport.monthly.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
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

import com.boan.crm.groupmanage.model.Deptment;
import com.boan.crm.groupmanage.model.User;
import com.boan.crm.groupmanage.service.IDeptmentService;
import com.boan.crm.groupmanage.service.IUserService;
import com.boan.crm.sellreport.monthly.model.MonthlyMainInfo;
import com.boan.crm.sellreport.monthly.service.IMonthlyMainInfoService;
import com.boan.crm.utils.action.BaseActionSupport;
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
	public String showGroupTreeForMonthlyMainInfo() throws Exception {
		companyId = sessionCompanyId;
		companyName = sessionCompanyName;
		userList = new ArrayList<User>();
		deptList = new ArrayList<Deptment>();
		boolean flag=true;
		if(sessionDeptId.equals("")){ //总经理
			flag=false;
		}
		flag=false;
		
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
	 * 打开月计划列表页
	 * @return
	 */
	public String openMonthlyMainInfoList(){
		deptList = deptService.queryAllDeptmentsByCompanyId( sessionCompanyId );
		Map param = new HashMap();
		if(personId!=null && !personId.equals("")){
			param.put("personId", personId);
		}else{
			param.put("deptId", deptId);
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
	
	public String openAddMonthlyMainInfo() throws Exception{
		deptList = deptService.queryAllDeptmentsByCompanyId( sessionCompanyId );
		userList =userService.queryUserList( sessionCompanyId, sessionDeptId, new Pagination<User>()).getData();
		monthlyMainInfo = new MonthlyMainInfo();
		
		monthlyMainInfo.setCompanyId(sessionCompanyId);
		monthlyMainInfo.setCompanyName(sessionCompanyName);
		
		monthlyMainInfo.setDeptId(sessionDeptId);
		monthlyMainInfo.setDeptName(sessionDeptName);
		
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
	
	public String getMonthlyStatData(){
		String str="<chart palette='2' caption='月销售计划对比统计' showValues='0' numVDivLines='10' drawAnchors='0' numberPrefix='$' divLineAlpha='30' alternateHGridAlpha='20'  setAdaptiveYMin='1' >";
		str=str+"<categories>";
		str=str+"<category label='第一周' /> ";
		str=str+"<category label='第二周' /> ";
		str=str+"<category label='第三周' /> ";
		str=str+"<category label='第四周' /> ";
		str=str+"</categories>";
		str=str+"<dataset seriesName='实际结果' color='FA0F1A'>";
		str=str+"<set value='1127654' /> ";
		str=str+"<set value='1226234' /> ";
		str=str+"<set value='1299456' /> ";
		str=str+"<set value='1311565' /> ";
		str=str+"</dataset>";
		str=str+"<dataset seriesName='计划结果' color='65FA0F'>";
		str=str+"<set value='927654' /> ";
		str=str+"<set value='1126234' /> ";
		str=str+"<set value='999456' /> ";
		str=str+"<set value='1111565' /> ";
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
}

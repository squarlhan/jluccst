package com.boan.crm.marketinquiry.action;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.boan.crm.groupmanage.model.User;
import com.boan.crm.groupmanage.service.IDeptmentService;
import com.boan.crm.groupmanage.service.IUserService;
import com.boan.crm.marketinquiry.model.MarketInquiry;
import com.boan.crm.marketinquiry.service.IMarketInquiryService;
import com.boan.crm.utils.action.BaseActionSupport;
import com.boan.crm.utils.page.Pagination;

/**
 * 时间管理Action
 * @author YF
 *
 */
@Controller("marketInquiryAction")
@Scope("prototype")
public class MarketInquiryAction extends BaseActionSupport{

	@Autowired
	@Qualifier("userService")
	private IUserService userService = null;
	
	@Autowired
	@Qualifier("deptService")
	private IDeptmentService deptService = null;
	
	@Autowired
	@Qualifier("marketInquiryService")
	private IMarketInquiryService marketInquiryService = null;
	
	/**
	 * 市场调查实体
	 */
	private MarketInquiry marketInquiry;
	
	/**
	 * 员工数组
	 */
	private List<User> userList = null;
	
	/**
	 * 显示分页
	 */
	private Pagination<MarketInquiry> pagination = new Pagination<MarketInquiry>();
	
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
	/**
	 * 显示计划列表
	 * @return
	 */
	public String openMarketInquiryList() {
		if(beginTime==null && endTime==null){
			Calendar temp = Calendar.getInstance();
			temp.set(Calendar.DATE, -15);
			beginTime =temp;
			endTime = Calendar.getInstance();
		}
		Map<String,Object> params = new HashMap<String, Object>();
		params.put("employeeName", employeeName);
		params.put("planType", planType);
		params.put("beginTime", beginTime);
		params.put("endTime", endTime); 
		pagination = marketInquiryService.findMarketInquiryForPage(params,pagination);
		
		return SUCCESS;
	}
	/**
	 * 打开添加页
	 * @return
	 * @throws Exception 
	 */
	public String openAddMarketInquiry() throws Exception {
		userList =userService.queryUserList( sessionCompanyId, sessionDeptId, new Pagination<User>()).getData();
		return SUCCESS;
	}
	/**
	 * 添加计划
	 * @return
	 * @throws Exception 
	 */
	public String addMarketInquiry() throws Exception {
		//修改
		marketInquiryService.saveOrUpdateMarketInquiry(marketInquiry);
		message="保存成功！";
		return SUCCESS;
	}

	/**
	 * 删除时间计划
	 * @return
	 */
	public String deleteMarketInquiry(){
		marketInquiryService.deleteMarketInquiry(ids);
		return NONE;
	}
	public MarketInquiry getMarketInquiry() {
		return marketInquiry;
	}
	public void setMarketInquiry(MarketInquiry marketInquiry) {
		this.marketInquiry = marketInquiry;
	}
	public List<User> getUserList() {
		return userList;
	}
	public void setUserList(List<User> userList) {
		this.userList = userList;
	}
	public Pagination<MarketInquiry> getPagination() {
		return pagination;
	}
	public void setPagination(Pagination<MarketInquiry> pagination) {
		this.pagination = pagination;
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
}

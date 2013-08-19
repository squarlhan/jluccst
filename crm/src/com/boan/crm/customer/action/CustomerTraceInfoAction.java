/**
 * 
 */
package com.boan.crm.customer.action;

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

import com.boan.crm.actionplan.service.IActionPlanService;
import com.boan.crm.customer.model.BusinessProgressKey;
import com.boan.crm.customer.model.ContractPersonInfo;
import com.boan.crm.customer.model.CustomerInfo;
import com.boan.crm.customer.model.CustomerTraceInfo;
import com.boan.crm.customer.service.IContractPersonService;
import com.boan.crm.customer.service.ICustomerInfoService;
import com.boan.crm.customer.service.ICustomerTraceInfoService;
import com.boan.crm.datadictionary.model.DataDictionary;
import com.boan.crm.datadictionary.service.IDataDictionaryService;
import com.boan.crm.groupmanage.common.RoleFlag;
import com.boan.crm.groupmanage.common.UserSession;
import com.boan.crm.groupmanage.model.User;
import com.boan.crm.groupmanage.service.IPopedomService;
import com.boan.crm.groupmanage.service.IUserService;
import com.boan.crm.sms.model.SMSCustomerInfo;
import com.boan.crm.sms.model.SMSInfo;
import com.boan.crm.sms.service.ISMSCustomerInfoService;
import com.boan.crm.sms.service.ISMSInfoService;
import com.boan.crm.timemanage.service.ITimePlanService;
import com.boan.crm.utils.action.BaseActionSupport;
import com.boan.crm.utils.calendar.CalendarUtils;
import com.boan.crm.utils.calendar.MySimpleDateFormat;
import com.boan.crm.utils.page.Pagination;

/**
 * @author luojx
 * 客户跟进信息action
 */
@Controller("customerTraceInfoAction")
@Scope("prototype")
public class CustomerTraceInfoAction extends BaseActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4140371188076904836L;
	
	@Autowired
	@Qualifier("customerTraceInfoService")
	//客户状态接口类
	private ICustomerTraceInfoService customerTraceInfoService;
	
	@Autowired
	@Qualifier("customerInfoService")
	//客户状态接口类
	private ICustomerInfoService customerInfoService;
	
	@Autowired
	@Qualifier("contractPersonService")
	//客户状态接口类
	private IContractPersonService contractPersonService;
	
	@Autowired
	@Qualifier("userService")
	private IUserService userService;
	@Autowired
	@Qualifier("dataDictionaryService")
	private IDataDictionaryService dataDictionaryService = null;
	@Autowired
	@Qualifier("SMSInfoService")
	private ISMSInfoService smsInfoService;
	@Autowired
	@Qualifier("SMSCustomerInfoService")
	private ISMSCustomerInfoService sMSCustomerInfoService;
	
	@Autowired
	@Qualifier("actionPlanService")
	private IActionPlanService actionPlanService = null;
	
	@Autowired
	@Qualifier("timePlanService")
	private ITimePlanService  timePlanService = null;
	
	@Autowired
	@Qualifier("popedomService")
	private IPopedomService popedomService = null;
	//客户跟进信息类
	private CustomerTraceInfo customerTraceInfo ;
	private String id = "";
	private String customerId = "";
	private String[] ids = null;
	private Pagination<CustomerTraceInfo> pagination = new Pagination<CustomerTraceInfo>();
	private List<DataDictionary> listTraceOption = null;
	private List<ContractPersonInfo> listPerson = null;
	private List<DataDictionary> listTraceFlag = new ArrayList<DataDictionary>();
	private String salesmanId = "";
	private List<User> userList = null;
	private String customerName = "";
	private Calendar beginDate;
	private Calendar endDate;
	private String traceOption = "";
	private CustomerInfo customerInfo = null;
	private String contractPerson = "";
	private String contractTel  = "";
	private String traceTime = "";
	private String chkSMS = "";
	private String message = null;
	private String deptId ="";
	private String traceFlag = "";
	private String actualTraceTime = "";
	private String dealingFlag = "";
	
	
	/**
	 * 客户跟进信息列表
	 * @return String
	 */
	public String myCustomerTraceList()
	{
		//跟进方式： 传6
		listTraceOption = dataDictionaryService.findDataDictionaryByType(sessionCompanyId, 6);
		DataDictionary d = new DataDictionary();
		d.setId("0");
		d.setName("未完成跟进");
		listTraceFlag.add(d);
		DataDictionary d1 = new DataDictionary();
		d1.setId("1");
		d1.setName("已完成跟进");
		listTraceFlag.add(d1);
		try
		{
			//userList = userService.queryUserListByCompanyIdRoleKey(sessionCompanyId,RoleFlag.YE_WU_YUAN);
			if(deptId != null && deptId.length() > 0)
			{
				userList = userService.queryUserListByCompanyIdRoleKey(sessionCompanyId,deptId,RoleFlag.YE_WU_YUAN);
			}else
			{
				userList = userService.queryUserListByCompanyIdRoleKey(sessionCompanyId,RoleFlag.YE_WU_YUAN);
			}
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		Map<String,Object> values = new HashMap<String,Object>();
		
		if(customerName != null && customerName.length() > 0)
		{
			values.put("customerName", "%"+customerName+"%");
		}
		if(salesmanId != null && salesmanId.length() > 0)
		{
			values.put("salesmanId", salesmanId);
		}
		if(customerId != null && customerId.length() > 0)
		{
			values.put("customerId", customerId);
		}
		if(traceOption != null && traceOption.length() > 0)
		{
			values.put("traceOption", traceOption);
		}
		if(beginDate != null)
		{
			values.put("beginDate", beginDate);
		}
		if(endDate != null)
		{
			values.put("endDate", endDate);
		}
		if(traceFlag != null && traceFlag.length() > 0)
		{
			values.put("traceFlag", traceFlag);
		}
		values.put( "companyId", sessionCompanyId );
		values.put( "salesmanId", sessionUserId );
		pagination = customerTraceInfoService.findCustomerTraceInfoForPage(values, pagination);
		return SUCCESS;
	}
	public List<DataDictionary> getListTraceFlag() {
		return listTraceFlag;
	}

	public void setListTraceFlag(List<DataDictionary> listTraceFlag) {
		this.listTraceFlag = listTraceFlag;
	}

	/**
	 * 客户跟进信息列表
	 * @return String
	 */
	public String customerTraceList()
	{
		//跟进方式： 传6
		listTraceOption = dataDictionaryService.findDataDictionaryByType(sessionCompanyId, 6);
		UserSession us = this.getSession();
		boolean ywyFlag = false;
		boolean leaderFlag = false;
		try
		{
			ywyFlag = popedomService.isHasPopedomByRoleKey(us,RoleFlag.YE_WU_YUAN);
			leaderFlag = popedomService.isHasPopedomByRoleKey(us,RoleFlag.BU_MEN_LING_DAO);
			if(ywyFlag)
			{
				User user = userService.getUserById(sessionUserId);
				userList = new ArrayList<User>();
				userList.add(user);
			}else
			{
				if(leaderFlag)
				{
					userList = userService.queryUserListByCompanyIdRoleKey(sessionCompanyId,sessionDeptId,RoleFlag.YE_WU_YUAN);
				}else
				{
					if(deptId != null && deptId.length() > 0)
					{
						userList = userService.queryUserListByCompanyIdRoleKey(sessionCompanyId,deptId,RoleFlag.YE_WU_YUAN);
					}else
					{
						userList = userService.queryUserListByCompanyIdRoleKey(sessionCompanyId,RoleFlag.YE_WU_YUAN);
					}
				}
			}
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		Map<String,Object> values = new HashMap<String,Object>();
		
		if(customerName != null && customerName.length() > 0)
		{
			values.put("customerName", "%"+customerName+"%");
		}
		if(salesmanId != null && salesmanId.length() > 0)
		{
			values.put("salesmanId", salesmanId);
		}
		if(ywyFlag)
		{
			values.put("salesmanId", sessionUserId);
		}
		if(customerId != null && customerId.length() > 0)
		{
			values.put("customerId", customerId);
		}
		if(traceOption != null && traceOption.length() > 0)
		{
			values.put("traceOption", traceOption);
		}
		if(beginDate != null)
		{
			values.put("beginDate", beginDate);
		}
		if(endDate != null)
		{
			values.put("endDate", endDate);
		}
		values.put( "companyId", sessionCompanyId );
		if(deptId != null && deptId.length() > 0)
		{
			values.put("deptId", deptId);
		}
		if(leaderFlag)
		{
			values.put("deptId", sessionDeptId);
		}
		values.put("showAllFlag", "1");
		pagination = customerTraceInfoService.findCustomerTraceInfoForPage(values, pagination);
		return SUCCESS;
	}
	
	/**
	 * 客户跟进信息
	 * @return String
	 */
	public String customerTraceInfo()
	{
		if(StringUtils.trimToNull(id)!=null)
		{
			customerTraceInfo = customerTraceInfoService.get(id);
			customerId = customerTraceInfo.getCustomerId();
			customerInfo = customerInfoService.get(customerId);
			if(customerTraceInfo.getActualTraceTime() != null)
			{
				actualTraceTime = CalendarUtils.toLongStringNoSecond(customerTraceInfo.getActualTraceTime());
			}
			traceTime = CalendarUtils.toLongStringNoSecond(customerTraceInfo.getTraceTime());
			try
			{
				customerTraceInfo.setCustomerName(customerInfo.getCustomerName());
				customerInfo.setSalesman(userService.getUserById(customerInfo.getSalesmanId()).getUserCName());
			}catch(Exception ex){}
			DataDictionary d = dataDictionaryService.get(customerInfo.getCategoryId());
			if(d != null)
				customerInfo.setCategory(d.getName());
			
			if(customerInfo.getProgressId() != null)
				customerInfo.setProgress(BusinessProgressKey.getBusinessProgressNameByKey(customerInfo.getProgressId()));
			else
				customerInfo.setProgress("新建");
			
			List<ContractPersonInfo> listPerson = contractPersonService.findAllContractPersonInfoByCustomerId(customerId);
			if(listPerson != null)
			{
				for(int i=0;i<listPerson.size();i++)
				{
					if(contractPerson.length() == 0)
					{
						contractPerson = listPerson.get(i).getPersonName();
					}else
					{
						contractPerson = contractPerson + "," +listPerson.get(i).getPersonName();
					}
					
					if(listPerson.get(i).getPhone() != null && listPerson.get(i).getPhone().length() > 0)
					{
						if(contractTel.length() == 0)
						{
							contractTel = listPerson.get(i).getPhone();
						}else
						{
							contractTel = contractTel + "," +listPerson.get(i).getPhone();
						}
					}
					
					if(listPerson.get(i).getTel() != null && listPerson.get(i).getTel().length() > 0)
					{
						if(contractTel.length() == 0)
						{
							contractTel = listPerson.get(i).getTel();
						}else
						{
							contractTel = contractTel + "," +listPerson.get(i).getTel();
						}
					}
					
				}
			}
		}
		else
		{
			customerTraceInfo = new CustomerTraceInfo();
			Calendar time = Calendar.getInstance();
			time.add(Calendar.HOUR, 1);
			traceTime = CalendarUtils.toLongStringNoSecond(time);
		}
		
		listTraceOption = dataDictionaryService.findDataDictionaryByType(sessionCompanyId, 6);
		
		listPerson = contractPersonService.findAllContractPersonInfoByCustomerId(customerId);
		
		try
		{
			//userList = userService.queryUserListByCompanyIdRoleKey(sessionCompanyId,RoleFlag.YE_WU_YUAN);
			if(deptId != null && deptId.length() > 0)
			{
				userList = userService.queryUserListByCompanyIdRoleKey(sessionCompanyId,deptId,RoleFlag.YE_WU_YUAN);
			}else
			{
				userList = userService.queryUserListByCompanyIdRoleKey(sessionCompanyId,RoleFlag.YE_WU_YUAN);
			}
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
		return SUCCESS;
	}
	/**
	 * 手机端客户跟进信息
	 * @return String
	 */
	public String customerTraceInfoForPhone()
	{
		Map<String,Object> map = new HashMap<String,Object>();
		if(StringUtils.trimToNull(id)!=null)
		{
			customerTraceInfo = customerTraceInfoService.get(id);
			
			ContractPersonInfo personObj = contractPersonService.get(customerTraceInfo.getTracePersonId());
			if(personObj!= null)
				map.put("object_name", contractPersonService.get(customerTraceInfo.getTracePersonId()).getPersonName());
			else
				map.put("object_name", "");
			
			map.put("object_id", customerTraceInfo.getTracePersonId());
			
			
			traceTime = CalendarUtils.toLongStringNoSecond(customerTraceInfo.getTraceTime());
			map.put("date", traceTime);
			
			traceOption = dataDictionaryService.get(customerTraceInfo.getTraceOption()).getName();
			map.put("connect_way", traceOption);
			map.put("QQ", customerTraceInfo.getQq());
			map.put("email", customerTraceInfo.getEmail());
			map.put("phone", customerTraceInfo.getTel());
			map.put("task", customerTraceInfo.getTask());
			if(customerTraceInfo.getActualTraceTime() != null)
			{
				map.put("realy_time", CalendarUtils.toLongStringNoSecond(customerTraceInfo.getActualTraceTime()));
			}else
			{
				map.put("realy_time", "");
			}
			
			map.put("intrest_point", customerTraceInfo.getInterest());
			map.put("diffrent_point", customerTraceInfo.getObjection());
			
		}
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("map", map);
		return COMMON_MAP;
	}
	/**
	 * 手机端删除任务
	 * @return String
	 */
	public String deleteTraceInfoForPhone()
	{
		CustomerTraceInfo obj = customerTraceInfoService.get(id);
		if(obj != null)
		{
			obj.setDeleteFlag(1);
			customerTraceInfoService.save(obj);
			message = "success";
		}else
		{
			message = "failure";
		}
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("message", message);
		return COMMON_RESULT;
	}
	/**
	 * 手机端完成任务，保存客户跟进信息
	 * @return String
	 */
	public String saveTraceInfoForPhone()
	{
		CustomerTraceInfo obj = customerTraceInfoService.get(id);
		if(obj != null)
		{
			if(customerTraceInfo != null && customerTraceInfo.getTraceFlag().length() > 0)
			{
				obj.setTraceFlag(customerTraceInfo.getTraceFlag());
				if(customerTraceInfo.getActualTraceTimeStr() != null && customerTraceInfo.getActualTraceTimeStr().length() > 0 )
				{
					obj.setActualTraceTime(MySimpleDateFormat.parse(customerTraceInfo.getActualTraceTimeStr(),"yyyy-MM-dd"));
				}
				obj.setDealingFlag(customerTraceInfo.getDealingFlag());
				obj.setInterest(customerTraceInfo.getInterest());
				obj.setObjection(customerTraceInfo.getObjection());
			}else
			{
				obj.setTraceFlag("1");
				obj.setActualTraceTime(Calendar.getInstance());
			}
			customerTraceInfoService.save(obj);
			message = "success";
		}else
		{
			message = "failure";
		}
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("message", message);
		return COMMON_RESULT;
	}
	/**
	 * 保存客户跟进信息
	 * @return String
	 */
	public String saveTraceInfo()
	{
		if(customerTraceInfo.getSalesmanId() != null && customerTraceInfo.getSalesmanId().length() > 0)
		{
			
		}else
		{
			customerTraceInfo.setSalesmanId(sessionUserId);
			customerTraceInfo.setSalesman(sessionUserCName);	
		}
		
		CustomerTraceInfo obj = null;
		boolean inserFLag = true;
		if(customerTraceInfo.getId() != null && customerTraceInfo.getId().length() > 0)
		{
			inserFLag = false;
			obj =  customerTraceInfoService.get(customerTraceInfo.getId());
			CustomerInfo customer = customerInfoService.get(obj.getCustomerId());
			if(customer != null)
			{
				obj.setCustomerName(customer.getCustomerName());
				if (dealingFlag != null && dealingFlag.equals("1"))
				{
					customer.setProgressId(BusinessProgressKey.DEALING);
					customer.setProgress(BusinessProgressKey.getBusinessProgressNameByKey(BusinessProgressKey.DEALING));
					customerInfoService.save(customer);
				}else
				{
					customer.setProgressId(BusinessProgressKey.TRACE);
					customer.setProgress(BusinessProgressKey.getBusinessProgressNameByKey(BusinessProgressKey.TRACE));
					customerInfoService.save(customer);
				}
			}
		}else
		{
			obj = new CustomerTraceInfo();
			obj.setCustomerId(customerId);
			
			CustomerInfo customer = customerInfoService.get(customerId);
			if(customer != null)
			{
				obj.setCustomerName(customer.getCustomerName());
				if (dealingFlag != null && dealingFlag.equals("1"))
				{
					customer.setProgressId(BusinessProgressKey.DEALING);
					customer.setProgress(BusinessProgressKey.getBusinessProgressNameByKey(BusinessProgressKey.DEALING));
					customerInfoService.save(customer);
				}else
				{
					customer.setProgressId(BusinessProgressKey.TRACE);
					customer.setProgress(BusinessProgressKey.getBusinessProgressNameByKey(BusinessProgressKey.TRACE));
					customerInfoService.save(customer);
				}
			}
		}
		
		obj.setTracePersonId(customerTraceInfo.getTracePersonId());
		
		obj.setSalesman(customerTraceInfo.getSalesman());
		obj.setSalesmanId(customerTraceInfo.getSalesmanId());
		obj.setTask(customerTraceInfo.getTask());
		obj.setTraceOption(customerTraceInfo.getTraceOption());
		Calendar time = CalendarUtils.toLongCalendarNoSecond( traceTime );
		obj.setTraceTime(time);
		
		if (traceFlag != null && traceFlag.equals("1"))
		{
			obj.setTraceFlag("1");
			
			Calendar time2 = CalendarUtils.toLongCalendarNoSecond( actualTraceTime );
			obj.setActualTraceTime(time2);
			obj.setInterest(customerTraceInfo.getInterest());
			obj.setObjection(customerTraceInfo.getObjection());
			
		}else
		{
			obj.setTraceFlag("0");
			obj.setActualTraceTime(null);
			obj.setInterest("");
			obj.setObjection("");
		}
		
		if (dealingFlag != null && dealingFlag.equals("1"))
		{
			obj.setDealingFlag("1");
		}else
		{
			obj.setDealingFlag("0");
		}
		
		obj.setEmail(customerTraceInfo.getEmail());
		obj.setQq(customerTraceInfo.getQq());
		obj.setTel(customerTraceInfo.getTel());
		obj.setCompanyId( sessionCompanyId );
		obj.setDeleteFlag(0);
		customerTraceInfoService.save(obj);
		
		
		if(inserFLag)
		{
			//暂时屏蔽2013-8-18
//			ActionPlan actionPlan = new ActionPlan();
//			actionPlan.setDeptId(sessionDeptId);
//			actionPlan.setCreateTime(Calendar.getInstance());
//			actionPlan.setDeptName(sessionDeptName);
//			actionPlan.setEmployeeId(obj.getSalesmanId());
//			actionPlan.setEmployeeName(obj.getSalesman());
//			actionPlan.setOrganId(sessionCompanyId);
//			actionPlan.setPersonId(obj.getSalesmanId());
//			actionPlan.setPlanType("3");
//			StringBuilder sb = new StringBuilder();
//			sb.append("跟进计划：");
//			sb.append(CalendarUtils.toLongStringNoSecond(obj.getTraceTime()));
//			sb.append(",对客户[");
//			sb.append(obj.getCustomerName());
//			sb.append("]进行["+dataDictionaryService.get(obj.getTraceOption()).getName()+"]方式跟进");
//			sb.append(",跟进任务：[");
//			sb.append(obj.getTask());
//			sb.append("]。");
//			actionPlan.setPlanContent(sb.toString());
//			actionPlan.setSubmitTime(Calendar.getInstance());
//			
//			actionPlanService.saveOrUpdateActionPlan(actionPlan);
//			
//			TimePlan timePlan = new TimePlan();
//			timePlan.setCreateTime(Calendar.getInstance());
//			timePlan.setDeptId(sessionDeptId);
//			timePlan.setDeptName(sessionDeptName);
//			timePlan.setEmployeeId(sessionUserId);
//			timePlan.setEmployeeName(sessionUserCName);
//			timePlan.setPersonId(sessionUserId);
//			timePlan.setOrganId(sessionCompanyId);
//			timePlan.setPlanType("0");
//			timePlan.setSubmitTime(Calendar.getInstance());
//			timePlanService.saveOrUpdateTimePlan(timePlan, 0, sb.toString(), obj.getId());
		}else
		{
			if (traceFlag != null && traceFlag.equals("1"))
			{
//				//暂时屏蔽2013-8-18
//				if(!timePlanService.hasTimePlanForTrackOrVisit(obj.getId()))
//				{
//					TimePlan timePlan = new TimePlan();
//					timePlan.setCreateTime(Calendar.getInstance());
//					timePlan.setDeptId(sessionDeptId);
//					timePlan.setDeptName(sessionDeptName);
//					timePlan.setEmployeeId(sessionUserId);
//					timePlan.setEmployeeName(sessionUserCName);
//					timePlan.setPersonId(sessionUserId);
//					timePlan.setOrganId(sessionCompanyId);
//					timePlan.setPlanType("0");
//					timePlan.setSubmitTime(Calendar.getInstance());
//					StringBuilder sb = new StringBuilder();
//					sb.append("跟进完成：");
//					sb.append(CalendarUtils.toLongStringNoSecond(obj.getTraceTime()));
//					sb.append(",对客户[");
//					sb.append(obj.getCustomerName());
//					sb.append("]进行["+dataDictionaryService.get(obj.getTraceOption()).getName()+"]方式跟进");
//					sb.append(",跟进任务：[");
//					sb.append(obj.getTask());
//					sb.append("]。");
//					
//					timePlanService.saveOrUpdateTimePlan(timePlan, 1, sb.toString(), obj.getId());
//				}else
//				{
//					TimePlanAndTrackOrVisitRelation timePlanAndTrackOrVisitRelation = timePlanService.getTimePlanForTrackOrVisit(obj.getId());
//					TimePlan objTemp = timePlanService.getTimePlanById(timePlanAndTrackOrVisitRelation.getTime_Planand());
//					StringBuilder sb = new StringBuilder();
//					sb.append("跟进完成：");
//					sb.append(CalendarUtils.toLongStringNoSecond(obj.getActualTraceTime()));
//					sb.append(",对客户[");
//					sb.append(obj.getCustomerName());
//					sb.append("]进行["+dataDictionaryService.get(obj.getTraceOption()).getName()+"]方式跟进");
//					sb.append(",跟进任务：[");
//					sb.append(obj.getTask());
//					sb.append("]。");
//					objTemp.setMemo(sb.toString());
//					timePlanService.saveOrUpdateTimePlan(objTemp);
//				}
			}
		}
		
		if(chkSMS != null && chkSMS.equals("true"))
		{
			SMSInfo sms = new SMSInfo();
			SMSCustomerInfo smsUser = sMSCustomerInfoService.getSMSCustomerInfoByCustomerId(obj.getSalesmanId());

			if(smsUser != null)
			{
				sms.setCustomerInfo(smsUser);
				
				sms.setIsImmediately(1);
				sms.setOrganId(sessionCompanyId);
				sms.setPersonCompany(sessionCompanyName);
				sms.setPersonName( obj.getSalesman() );
				sms.setSendTime(time);
				
				StringBuilder sb2 = new StringBuilder();
				sb2.append("提醒：对客户[");
				sb2.append(obj.getCustomerName());
				sb2.append("]进行["+dataDictionaryService.get(obj.getTraceOption()).getName()+"]方式跟进");
				sb2.append(",跟进任务：[");
				sb2.append(obj.getTask());
				sb2.append("]。");
				
				sms.setInfo(sb2.toString());
				try
				{
					String phone = userService.getUserById( obj.getSalesmanId() ).getPhone();
					if(phone != null && phone.length() > 0 && phone.length() == 11)
					{
						sms.setPhone(phone);
						smsInfoService.saveSMSInfo(sms); 
					}else
					{
						message = "保存跟进任务成功！手机短信提醒失败：跟进人手机号有误！";
						id = obj.getId();
						return SUCCESS;
					}
				}catch(Exception ex)
				{
					message = "保存跟进任务成功！手机短信提醒失败：获取跟进人信息有误！";
					id = obj.getId();
					return SUCCESS;
				}
			}else
			{
				message = "保存跟进任务成功！手机短信提醒失败：获取跟进人信息有误！";
				id = obj.getId();
				return SUCCESS;
			}
			
		}
		id = obj.getId();
		message = "保存成功！";
		return SUCCESS;
	}
	/**
	 * 删除客户跟进信息
	 * @return String
	 */
	public String deleteCustomerTrace()
	{
		customerTraceInfoService.deleteCustomerTraceInfo(ids);
		return NONE;
	}
	public List<User> getUserList() {
		return userList;
	}
	public void setUserList(List<User> userList) {
		this.userList = userList;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String[] getIds() {
		return ids;
	}
	public void setIds(String[] ids) {
		this.ids = ids;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getSalesmanId() {
		return salesmanId;
	}
	public void setSalesmanId(String salesmanId) {
		this.salesmanId = salesmanId;
	}
	public CustomerTraceInfo getCustomerTraceInfo() {
		return customerTraceInfo;
	}
	public void setCustomerTraceInfo(CustomerTraceInfo customerTraceInfo) {
		this.customerTraceInfo = customerTraceInfo;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public List<DataDictionary> getListTraceOption() {
		return listTraceOption;
	}
	public void setListTraceOption(List<DataDictionary> listTraceOption) {
		this.listTraceOption = listTraceOption;
	}
	
	
	public Calendar getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(Calendar beginDate) {
		this.beginDate = beginDate;
	}

	public Calendar getEndDate() {
		return endDate;
	}

	public void setEndDate(Calendar endDate) {
		this.endDate = endDate;
	}

	public Pagination<CustomerTraceInfo> getPagination() {
		return pagination;
	}

	public String getTraceOption() {
		return traceOption;
	}
	public void setTraceOption(String traceOption) {
		this.traceOption = traceOption;
	}
	public void setPagination(Pagination<CustomerTraceInfo> pagination) {
		this.pagination = pagination;
	}
	public List<ContractPersonInfo> getListPerson() {
		return listPerson;
	}

	public void setListPerson(List<ContractPersonInfo> listPerson) {
		this.listPerson = listPerson;
	}
	public CustomerInfo getCustomerInfo() {
		return customerInfo;
	}

	public void setCustomerInfo(CustomerInfo customerInfo) {
		this.customerInfo = customerInfo;
	}
	public String getTraceFlag() {
		return traceFlag;
	}

	public void setTraceFlag(String traceFlag) {
		this.traceFlag = traceFlag;
	}

	public String getActualTraceTime() {
		return actualTraceTime;
	}

	public void setActualTraceTime(String actualTraceTime) {
		this.actualTraceTime = actualTraceTime;
	}

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getChkSMS() {
		return chkSMS;
	}

	public void setChkSMS(String chkSMS) {
		this.chkSMS = chkSMS;
	}

	public String getTraceTime() {
		return traceTime;
	}

	public void setTraceTime(String traceTime) {
		this.traceTime = traceTime;
	}

	public String getContractTel() {
		return contractTel;
	}

	public void setContractTel(String contractTel) {
		this.contractTel = contractTel;
	}

	public String getContractPerson() {
		return contractPerson;
	}

	public void setContractPerson(String contractPerson) {
		this.contractPerson = contractPerson;
	}
	public String getDealingFlag() {
		return dealingFlag;
	}
	public void setDealingFlag(String dealingFlag) {
		this.dealingFlag = dealingFlag;
	}
}

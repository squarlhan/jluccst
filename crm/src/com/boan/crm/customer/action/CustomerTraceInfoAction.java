/**
 * 
 */
package com.boan.crm.customer.action;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.boan.crm.actionplan.model.ActionPlan;
import com.boan.crm.actionplan.service.IActionPlanService;
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
import com.boan.crm.utils.action.BaseActionSupport;
import com.boan.crm.utils.calendar.CalendarUtils;
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
			DataDictionary d1 = dataDictionaryService.get(customerInfo.getProgressId());
			if(d1 != null)
				customerInfo.setProgress(d1.getName());
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
			}
		}else
		{
			obj = new CustomerTraceInfo();
			obj.setCustomerId(customerId);
			
			CustomerInfo customer = customerInfoService.get(customerId);
			if(customer != null)
			{
				obj.setCustomerName(customer.getCustomerName());
			}
		}
		
		obj.setTracePersonId(customerTraceInfo.getTracePersonId());
		
		obj.setSalesman(customerTraceInfo.getSalesman());
		obj.setSalesmanId(customerTraceInfo.getSalesmanId());
		obj.setTask(customerTraceInfo.getTask());
		obj.setTraceOption(customerTraceInfo.getTraceOption());
		Calendar time = CalendarUtils.toLongCalendarNoSecond( traceTime );
//		if(traceTime.indexOf(" ") != -1)
//		{
//			String[] timeArray = traceTime.split(" ")[1].split(":");
//			String[] dayArray = traceTime.split(" ")[0].split("-");
//			if(dayArray.length>0 && timeArray.length>0){
//				time.set(Calendar.YEAR, Integer.parseInt(dayArray[0]));
//				time.set(Calendar.MONTH, Integer.parseInt(dayArray[1]) - 1);
//				time.set(Calendar.DAY_OF_MONTH, Integer.parseInt(dayArray[2]) - 1);
//				time.set(Calendar.HOUR, Integer.parseInt(timeArray[0]));
//				time.set(Calendar.MINUTE, Integer.parseInt(timeArray[1]));
//				time.set(Calendar.SECOND, 0);
//			}
//		}else
//		{
//			String[] dayArray1 = traceTime.split("-");
//			time.set(Calendar.YEAR, Integer.parseInt(dayArray1[0]));
//			time.set(Calendar.MONTH, Integer.parseInt(dayArray1[1]) - 1);
//			time.set(Calendar.DAY_OF_MONTH, Integer.parseInt(dayArray1[2]) - 1);
//			time.set(Calendar.HOUR, 0);
//			time.set(Calendar.MINUTE, 0);
//			time.set(Calendar.SECOND, 0);
//		}
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
		obj.setEmail(customerTraceInfo.getEmail());
		obj.setQq(customerTraceInfo.getQq());
		obj.setTel(customerTraceInfo.getTel());
		obj.setCompanyId( sessionCompanyId );
		obj.setDeleteFlag(0);
		customerTraceInfoService.save(obj);
		
		if(inserFLag)
		{
			/*TimePlan timePlan = new TimePlan();
			timePlan.setDeptId(sessionDeptId);
			timePlan.setCreateTime(Calendar.getInstance());
			timePlan.setDeptName(sessionDeptName);
			timePlan.setEmployeeId(obj.getSalesmanId());
			timePlan.setEmployeeName(obj.getSalesman());
			timePlan.setOrganId(sessionCompanyId);
			timePlan.setPersonId(obj.getSalesmanId());
			timePlan.setPlanType("0");
			StringBuilder sb = new StringBuilder();
			sb.append("跟进计划：");
			sb.append(CalendarUtils.toLongStringNoSecond(obj.getTraceTime()));
			sb.append(",对客户[");
			sb.append(obj.getCustomerName());
			sb.append("]进行["+dataDictionaryService.get(obj.getTraceOption()).getName()+"]方式跟进");
			sb.append(",跟进任务：[");
			sb.append(obj.getTask());
			sb.append("]。");
			timePlan.setPlanContent(sb.toString());
			timePlan.setSubmitTime(Calendar.getInstance());
			
			timePlanService.saveOrUpdateTimePlan(timePlan);*/
			
			ActionPlan actionPlan = new ActionPlan();
			actionPlan.setDeptId(sessionDeptId);
			actionPlan.setCreateTime(Calendar.getInstance());
			actionPlan.setDeptName(sessionDeptName);
			actionPlan.setEmployeeId(obj.getSalesmanId());
			actionPlan.setEmployeeName(obj.getSalesman());
			actionPlan.setOrganId(sessionCompanyId);
			actionPlan.setPersonId(obj.getSalesmanId());
			actionPlan.setPlanType("3");
			StringBuilder sb = new StringBuilder();
			sb.append("跟进计划：");
			sb.append(CalendarUtils.toLongStringNoSecond(obj.getTraceTime()));
			sb.append(",对客户[");
			sb.append(obj.getCustomerName());
			sb.append("]进行["+dataDictionaryService.get(obj.getTraceOption()).getName()+"]方式跟进");
			sb.append(",跟进任务：[");
			sb.append(obj.getTask());
			sb.append("]。");
			actionPlan.setPlanContent(sb.toString());
			actionPlan.setSubmitTime(Calendar.getInstance());
			
			actionPlanService.saveOrUpdateActionPlan(actionPlan);
		}
		
		if(chkSMS != null && chkSMS.equals("true"))
		{
			SMSInfo sms = new SMSInfo();
			
			//CustomerInfo customer = customerInfoService.get(customerId);
			
			SMSCustomerInfo smsUser = sMSCustomerInfoService.getSMSCustomerInfoByCustomerId(obj.getSalesmanId());

//			smsCustomer.setCustomerId(customerId);
//			//smsCustomer.setBirthday(customer.getContractPersonList().get)
//			smsCustomer.setName(customer.getCustomerName());
//			smsCustomer.setOrganId(customer.getCompanyId());
//			smsCustomer.setOrganName(customer.getCompanyFullName());
//			smsCustomer.setSalesmanId(customer.getSalesmanId());
//			smsCustomer.setCategoryId(customer.getCategoryId());
//			
//			sMSCustomerInfoService.saveSMSCustomerInfo(smsCustomer);
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
}

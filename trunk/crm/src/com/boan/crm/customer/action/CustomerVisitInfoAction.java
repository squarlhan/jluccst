/**
 * 
 */
package com.boan.crm.customer.action;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.boan.crm.customer.model.ContractPersonInfo;
import com.boan.crm.customer.model.CustomerInfo;
import com.boan.crm.customer.model.CustomerVisitInfo;
import com.boan.crm.customer.service.IContractPersonService;
import com.boan.crm.customer.service.ICustomerInfoService;
import com.boan.crm.customer.service.ICustomerVisitInfoService;
import com.boan.crm.datadictionary.model.DataDictionary;
import com.boan.crm.datadictionary.service.IDataDictionaryService;
import com.boan.crm.groupmanage.common.RoleFlag;
import com.boan.crm.groupmanage.model.User;
import com.boan.crm.groupmanage.service.IUserService;
import com.boan.crm.sms.model.SMSCustomerInfo;
import com.boan.crm.sms.model.SMSInfo;
import com.boan.crm.sms.service.ISMSCustomerInfoService;
import com.boan.crm.sms.service.ISMSInfoService;
import com.boan.crm.timemanage.model.TimePlan;
import com.boan.crm.timemanage.service.ITimePlanService;
import com.boan.crm.utils.action.BaseActionSupport;
import com.boan.crm.utils.calendar.CalendarUtils;
import com.boan.crm.utils.page.Pagination;

/**
 * @author luojx
 * 客户回访信息action
 */
@Controller("customerVisitInfoAction")
@Scope("prototype")
public class CustomerVisitInfoAction extends BaseActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4140371188076904836L;
	
	@Autowired
	@Qualifier("customerVisitInfoService")
	//客户状态接口类
	private ICustomerVisitInfoService customerVisitInfoService;
	
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
	@Qualifier("timePlanService")
	private ITimePlanService timePlanService = null;
	//客户回访信息类
	private CustomerVisitInfo customerVisitInfo ;
	private String id = "";
	private String customerId = "";
	private String[] ids = null;
	private Pagination<CustomerVisitInfo> pagination = new Pagination<CustomerVisitInfo>();
	private List<DataDictionary> listVisitOption = null;
	
	private List<ContractPersonInfo> listPerson = null;
	
	private String salesmanId = "";
	private List<User> userList = null;
	private String customerName = "";
	private Calendar beginDate;
	private Calendar endDate;
	private String visitOption = "";
	private CustomerInfo customerInfo = null;
	private String contractPerson = "";
	private String contractTel  = "";
	private String visitTime = "";
	private String chkSMS = "";
	private String message = null;
	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	private String deptId = "";
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

	public String getVisitTime() {
		return visitTime;
	}

	public void setVisitTime(String visitTime) {
		this.visitTime = visitTime;
	}

	/**
	 * 我的客户回访信息列表
	 * @return String
	 */
	public String myCustomerVisitList()
	{
		//回访方式： 传5
		listVisitOption = dataDictionaryService.findDataDictionaryByType(sessionCompanyId, 5);
		
		try
		{
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
		if(customerId != null && customerId.length() > 0)
		{
			values.put("customerId", customerId);
		}
		if(salesmanId != null && salesmanId.length() > 0)
		{
			values.put("salesmanId", salesmanId);
		}
		if(visitOption != null && visitOption.length() > 0)
		{
			values.put("visitOption", visitOption);
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
		values.put( "salesmanId", sessionUserId );
		pagination = customerVisitInfoService.findCustomerVisitInfoForPage(values, pagination);
		return SUCCESS;
	}
	/**
	 * 客户回访信息列表
	 * @return String
	 */
	public String customerVisitList()
	{
		//回访方式： 传5
		listVisitOption = dataDictionaryService.findDataDictionaryByType(sessionCompanyId, 5);
		
		try
		{
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
		if(customerId != null && customerId.length() > 0)
		{
			values.put("customerId", customerId);
		}
		if(salesmanId != null && salesmanId.length() > 0)
		{
			values.put("salesmanId", salesmanId);
		}
		if(visitOption != null && visitOption.length() > 0)
		{
			values.put("visitOption", visitOption);
		}
		if(beginDate != null)
		{
			values.put("beginDate", beginDate);
		}
		if(endDate != null)
		{
			values.put("endDate", endDate);
		}
		if(deptId != null && deptId.length() > 0)
		{
			values.put("deptId", deptId);
		}
		values.put( "companyId", sessionCompanyId );
		pagination = customerVisitInfoService.findCustomerVisitInfoForPage(values, pagination);
		return SUCCESS;
	}
	
	/**
	 * 客户回访信息
	 * @return String
	 */
	public String customerVisitInfo()
	{
		if(StringUtils.trimToNull(id)!=null)
		{
			customerVisitInfo = customerVisitInfoService.get(id);
			customerId = customerVisitInfo.getCustomerId();
			customerInfo = customerInfoService.get(customerId);
			visitTime = CalendarUtils.toLongStringNoSecond(customerVisitInfo.getVisitTime());
			try
			{
				customerVisitInfo.setCustomerName(customerInfo.getCustomerName());
				customerInfo.setSalesman(userService.getUserById(customerInfo.getSalesmanId()).getUserCName());
			}catch(Exception ex){}
			DataDictionary d = dataDictionaryService.get(customerInfo.getCategoryId());
			if(d != null)
				customerInfo.setCategory(d.getName());
			
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
			customerVisitInfo = new CustomerVisitInfo();
			Calendar time = Calendar.getInstance();
			time.add(Calendar.HOUR, 1);
			visitTime = CalendarUtils.toLongStringNoSecond(time);
		}
		
		listVisitOption = dataDictionaryService.findDataDictionaryByType(sessionCompanyId, 5);
		
		listPerson = contractPersonService.findAllContractPersonInfoByCustomerId(customerId);
		
		try
		{
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
	 * 保存客户回访信息
	 * @return String
	 */
	public String saveVisitInfo()
	{
		if(customerVisitInfo.getSalesmanId() != null && customerVisitInfo.getSalesmanId().length() > 0)
		{
			
		}else
		{
			customerVisitInfo.setSalesmanId(sessionUserId);
			customerVisitInfo.setSalesman(sessionUserCName);
		}
		
		CustomerVisitInfo obj = null;
		boolean inserFLag = true;
		if(customerVisitInfo.getId() != null && customerVisitInfo.getId().length() > 0)
		{
			inserFLag = false;
			obj =  customerVisitInfoService.get(customerVisitInfo.getId());
		}else
		{
			obj = new CustomerVisitInfo();
			obj.setCustomerId(customerId);
			CustomerInfo customer = customerInfoService.get(customerId);
			if(customer != null)
			{
				obj.setCustomerName(customer.getCustomerName());
			}
		}
		obj.setVisitPersonId(customerVisitInfo.getVisitPersonId());
		obj.setContentResult(customerVisitInfo.getContentResult());
		obj.setRemark(customerVisitInfo.getRemark());
		obj.setSalesman(customerVisitInfo.getSalesman());
		obj.setSalesmanId(customerVisitInfo.getSalesmanId());
		obj.setTask(customerVisitInfo.getTask());
		obj.setVisitOption(customerVisitInfo.getVisitOption());
		Calendar time = CalendarUtils.toLongCalendarNoSecond( visitTime );
//		if(visitTime.indexOf(" ") != -1)
//		{
//			String[] timeArray = visitTime.split(" ")[1].split(":");
//			String[] dayArray = visitTime.split(" ")[0].split("-");
//			if(dayArray.length>0 && timeArray.length>0){
//				time.set(Calendar.YEAR, Integer.parseInt(dayArray[0]));
//				time.set(Calendar.MONTH, Integer.parseInt(dayArray[1]) - 1);
//				time.set(Calendar.DATE, Integer.parseInt(dayArray[2]));
//				time.set(Calendar.HOUR_OF_DAY, Integer.parseInt(timeArray[0]));
//				time.set(Calendar.MINUTE, Integer.parseInt(timeArray[1]));
//				time.set(Calendar.SECOND, 0);
//			}
//			
//		}else
//		{
//			String[] dayArray1 = visitTime.split("-");
//			time.set(Calendar.YEAR, Integer.parseInt(dayArray1[0]));
//			time.set(Calendar.MONTH, Integer.parseInt(dayArray1[1]) - 1);
//			time.set(Calendar.DATE, Integer.parseInt(dayArray1[2]));
//			time.set(Calendar.HOUR_OF_DAY, 0);
//			time.set(Calendar.MINUTE, 0);
//			time.set(Calendar.SECOND, 0);
//		}
		obj.setVisitTime(time);
		obj.setEmail(customerVisitInfo.getEmail());
		obj.setQq(customerVisitInfo.getQq());
		obj.setTel(customerVisitInfo.getTel());
		obj.setCompanyId( sessionCompanyId );
		customerVisitInfoService.save(obj);
		
		if(inserFLag)
		{
			TimePlan timePlan = new TimePlan();
			timePlan.setDeptId(sessionDeptId);
			timePlan.setCreateTime(Calendar.getInstance());
			timePlan.setDeptName(sessionDeptName);
			timePlan.setEmployeeId(obj.getSalesmanId());
			timePlan.setEmployeeName(obj.getSalesman());
			timePlan.setOrganId(sessionCompanyId);
			timePlan.setPersonId(obj.getSalesmanId());
			timePlan.setPlanType("0");
			StringBuilder sb = new StringBuilder();
			sb.append("回访计划：");
			sb.append(CalendarUtils.toLongStringNoSecond(obj.getVisitTime()));
			sb.append(",对客户[");
			sb.append(obj.getCustomerName());
			sb.append("]进行["+dataDictionaryService.get(obj.getVisitOption()).getName()+"]方式回访");
			sb.append(",回访任务：[");
			sb.append(obj.getTask());
			sb.append("]。");
			timePlan.setPlanContent(sb.toString());
			timePlan.setSubmitTime(Calendar.getInstance());
			
			timePlanService.saveOrUpdateTimePlan(timePlan);
		}
		
		if(chkSMS != null && chkSMS.equals("true"))
		{
			SMSInfo sms = new SMSInfo();
			
//			CustomerInfo customer = customerInfoService.get(customerId);
//			
//			SMSCustomerInfo smsCustomer = new SMSCustomerInfo();
//			smsCustomer.setCustomerId(customerId);
//			smsCustomer.setName(customer.getCustomerName());
//			smsCustomer.setOrganId(customer.getCompanyId());
//			smsCustomer.setOrganName(customer.getCompanyFullName());
//			smsCustomer.setSalesmanId(customer.getSalesmanId());
//			smsCustomer.setCategoryId(customer.getCategoryId());
//			
//			sMSCustomerInfoService.saveSMSCustomerInfo(smsCustomer);
			SMSCustomerInfo smsUser = sMSCustomerInfoService.getSMSCustomerInfoByCustomerId(obj.getSalesmanId());
			if(smsUser != null)
			{
				sms.setCustomerInfo(smsUser);
				sms.setIsImmediately(1);
				sms.setOrganId(sessionCompanyId);
				sms.setPersonCompany(sessionCompanyName);
				sms.setPersonName( sessionUserCName );
				sms.setSendTime(time);
	
				StringBuilder sb2 = new StringBuilder();
				sb2.append("提醒：对客户[");
				sb2.append(obj.getCustomerName());
				sb2.append("]进行["+dataDictionaryService.get(obj.getVisitOption()).getName()+"]方式回访");
				sb2.append(",回访任务：[");
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
						message = "保存回访任务成功！手机短信提醒失败：回访人手机信息有误！";
						id = obj.getId();
						return SUCCESS;
					}
					
					
				}catch(Exception ex)
				{
					message = "保存回访任务成功！手机短信提醒失败：获取回访人信息有误！";
					id = obj.getId();
					return SUCCESS;
				}
			}else
			{
				message = "保存跟进任务成功！手机短信提醒失败：获取回访人手机信息有误！";
				id = obj.getId();
				return SUCCESS;
			}
		}
		
		id = obj.getId();
		message = "保存成功！";
		return SUCCESS;
	}
	/**
	 * 删除客户回访信息
	 * @return String
	 */
	public String deleteCustomerVisit()
	{
		customerVisitInfoService.deleteCustomerVisitInfo(ids);
		return NONE;
	}
	public CustomerVisitInfo getCustomerVisitInfo() {
		return customerVisitInfo;
	}

	public void setCustomerVisitInfo(CustomerVisitInfo customerVisitInfo) {
		this.customerVisitInfo = customerVisitInfo;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String[] getIds() {
		return ids;
	}

	public void setIds(String[] ids) {
		this.ids = ids;
	}

	public Pagination<CustomerVisitInfo> getPagination() {
		return pagination;
	}

	public void setPagination(Pagination<CustomerVisitInfo> pagination) {
		this.pagination = pagination;
	}

	public List<DataDictionary> getListVisitOption() {
		return listVisitOption;
	}

	public void setListVisitOption(List<DataDictionary> listVisitOption) {
		this.listVisitOption = listVisitOption;
	}

	public List<ContractPersonInfo> getListPerson() {
		return listPerson;
	}

	public void setListPerson(List<ContractPersonInfo> listPerson) {
		this.listPerson = listPerson;
	}

	public String getSalesmanId() {
		return salesmanId;
	}

	public void setSalesmanId(String salesmanId) {
		this.salesmanId = salesmanId;
	}

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
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

	public String getVisitOption() {
		return visitOption;
	}

	public void setVisitOption(String visitOption) {
		this.visitOption = visitOption;
	}
	public CustomerInfo getCustomerInfo() {
		return customerInfo;
	}

	public void setCustomerInfo(CustomerInfo customerInfo) {
		this.customerInfo = customerInfo;
	}

	public String getContractPerson() {
		return contractPerson;
	}

	public void setContractPerson(String contractPerson) {
		this.contractPerson = contractPerson;
	}

	public String getContractTel() {
		return contractTel;
	}

	public void setContractTel(String contractTel) {
		this.contractTel = contractTel;
	}
}

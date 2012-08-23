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

import com.boan.crm.customer.model.ContractPersonInfo;
import com.boan.crm.customer.model.CustomerTraceInfo;
import com.boan.crm.customer.service.IContractPersonService;
import com.boan.crm.customer.service.ICustomerTraceInfoService;
import com.boan.crm.datadictionary.model.DataDictionary;
import com.boan.crm.groupmanage.common.RoleFlag;
import com.boan.crm.groupmanage.model.User;
import com.boan.crm.groupmanage.service.IUserService;
import com.boan.crm.utils.action.BaseActionSupport;
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
	@Qualifier("contractPersonService")
	//客户状态接口类
	private IContractPersonService contractPersonService;
	
	@Autowired
	@Qualifier("userService")
	private IUserService userService;
	
	//客户跟进信息类
	private CustomerTraceInfo customerTraceInfo ;
	private String id = "";
	private String customerId = "";
	private String[] ids = null;
	private Pagination<CustomerTraceInfo> pagination = new Pagination<CustomerTraceInfo>();
	private List<DataDictionary> listTraceOption = null;
	private List<ContractPersonInfo> listPerson = null;
	
	private String salesmanId = "";
	private List<User> userList = null;
	private String customerName = "";
	private Calendar beginDate;
	private Calendar endDate;
	private String traceOption = "";
	
	/**
	 * 客户跟进信息列表
	 * @return String
	 */
	public String customerTraceList()
	{
		//客户分类： 传0
		//listCategory = dataDictionaryService.findDataDictionaryByType(0);
		listTraceOption = new ArrayList<DataDictionary>();
		DataDictionary d = new DataDictionary();
		d.setId("登门拜访");
		d.setName("登门拜访");
		listTraceOption.add(d);
		DataDictionary d1 = new DataDictionary();
		d1.setId("电话跟进");
		d1.setName("电话跟进");
		listTraceOption.add(d1);
		
		DataDictionary d2 = new DataDictionary();
		d2.setId("QQ聊天");
		d2.setName("QQ聊天");
		listTraceOption.add(d2);
		
		DataDictionary d3 = new DataDictionary();
		d3.setId("邮件沟通");
		d3.setName("邮件沟通");
		listTraceOption.add(d2);
		
		try
		{
			userList = userService.queryUserListByCompanyIdRoleKey(sessionCompanyId,RoleFlag.YE_WU_YUAN);
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
		}
		else
			customerTraceInfo = new CustomerTraceInfo();
		
		listTraceOption = new ArrayList<DataDictionary>();
		DataDictionary d = new DataDictionary();
		d.setId("登门拜访");
		d.setName("登门拜访");
		listTraceOption.add(d);
		DataDictionary d1 = new DataDictionary();
		d1.setId("电话跟进");
		d1.setName("电话跟进");
		listTraceOption.add(d1);
		
		DataDictionary d2 = new DataDictionary();
		d2.setId("QQ聊天");
		d2.setName("QQ聊天");
		listTraceOption.add(d2);
		
		DataDictionary d3 = new DataDictionary();
		d3.setId("邮件沟通");
		d3.setName("邮件沟通");
		listTraceOption.add(d2);
		
		listPerson = contractPersonService.findAllContractPersonInfoByCustomerId(customerId);
		
		try
		{
			userList = userService.queryUserListByCompanyIdRoleKey(sessionCompanyId,RoleFlag.YE_WU_YUAN);
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
		customerTraceInfo.setSalesmanId(sessionUserId);
		customerTraceInfo.setSalesman(sessionUserCName);
		CustomerTraceInfo obj = null;
		if(customerTraceInfo.getId() != null && customerTraceInfo.getId().length() > 0)
		{
			obj =  customerTraceInfoService.get(customerTraceInfo.getId());
		}else
		{
			obj = new CustomerTraceInfo();
			obj.setCustomerId(customerId);
		}
		
		obj.setTracePersonId(customerTraceInfo.getTracePersonId());
		obj.setCustomerName(customerTraceInfo.getCustomerName());
		obj.setInterest(customerTraceInfo.getInterest());
		obj.setObjection(customerTraceInfo.getObjection());
		obj.setSalesman(customerTraceInfo.getSalesman());
		obj.setSalesmanId(customerTraceInfo.getSalesmanId());
		obj.setTask(customerTraceInfo.getTask());
		obj.setTraceOption(customerTraceInfo.getTraceOption());
		obj.setTraceTime(customerTraceInfo.getTraceTime());
		obj.setEmail(customerTraceInfo.getEmail());
		obj.setQq(customerTraceInfo.getQq());
		obj.setTel(customerTraceInfo.getTel());
		
		customerTraceInfoService.save(obj);
		id = obj.getId();
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
}

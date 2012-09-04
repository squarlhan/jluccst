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
import com.boan.crm.utils.action.BaseActionSupport;
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
	

	/**
	 * 客户回访信息列表
	 * @return String
	 */
	public String customerVisitList()
	{
		//回访方式： 传5
		listVisitOption = dataDictionaryService.findDataDictionaryByType(5);
		
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
			try
			{
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
			customerVisitInfo = new CustomerVisitInfo();
		
		listVisitOption = dataDictionaryService.findDataDictionaryByType(5);
		
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
	 * 保存客户回访信息
	 * @return String
	 */
	public String saveVisitInfo()
	{
		customerVisitInfo.setSalesmanId(sessionUserId);
		customerVisitInfo.setSalesman(sessionUserCName);
		CustomerVisitInfo obj = null;
		if(customerVisitInfo.getId() != null && customerVisitInfo.getId().length() > 0)
		{
			obj =  customerVisitInfoService.get(customerVisitInfo.getId());
		}else
		{
			obj = new CustomerVisitInfo();
			obj.setCustomerId(customerId);
		}
		
		obj.setVisitPersonId(customerVisitInfo.getVisitPersonId());
		obj.setCustomerName(customerVisitInfo.getCustomerName());
		obj.setContentResult(customerVisitInfo.getContentResult());
		obj.setRemark(customerVisitInfo.getRemark());
		obj.setSalesman(customerVisitInfo.getSalesman());
		obj.setSalesmanId(customerVisitInfo.getSalesmanId());
		obj.setTask(customerVisitInfo.getTask());
		obj.setVisitOption(customerVisitInfo.getVisitOption());
		obj.setVisitTime(customerVisitInfo.getVisitTime());
		obj.setEmail(customerVisitInfo.getEmail());
		obj.setQq(customerVisitInfo.getQq());
		obj.setTel(customerVisitInfo.getTel());
		obj.setCompanyId( sessionCompanyId );
		customerVisitInfoService.save(obj);
		id = obj.getId();
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

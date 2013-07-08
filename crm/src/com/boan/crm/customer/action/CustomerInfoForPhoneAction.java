/**
 * 
 */
package com.boan.crm.customer.action;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.boan.crm.customer.model.BusinessProgressKey;
import com.boan.crm.customer.model.CustomerInfo;
import com.boan.crm.customer.service.IContractPersonService;
import com.boan.crm.customer.service.ICustomerInfoService;
import com.boan.crm.customer.service.ICustomerTraceInfoService;
import com.boan.crm.customer.service.ICustomerVisitInfoService;
import com.boan.crm.datadictionary.service.IDataDictionaryService;
import com.boan.crm.utils.action.BaseActionSupport;

/**
 * @author luojx
 * 客户信息action
 */
@Controller("customerInfoForPhoneAction")
@Scope("prototype")
public class CustomerInfoForPhoneAction extends BaseActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4140371188076904836L;
	@Autowired
	@Qualifier("customerInfoService")
	//客户状态接口类
	private ICustomerInfoService customerInfoService;
	@Autowired
	@Qualifier("dataDictionaryService")
	private IDataDictionaryService dataDictionaryService = null;
	// 客户状态接口类
	@Autowired
	@Qualifier("contractPersonService")
	private IContractPersonService contractpersonInfoService;
	@Autowired
	@Qualifier("customerTraceInfoService")
	private ICustomerTraceInfoService customerTraceInfoService = null;
	@Autowired
	@Qualifier("customerVisitInfoService")
	private ICustomerVisitInfoService customerVisitInfoService = null;
	
	private String userId = "";
	private String clientName = "";
	private String clientComeWay = "";
	private String clientType = "";
	private String developProcess = "" ;
	private String clientMature = "";
	private String clientProgress = "";
	private String companyFullName = "";
	private String companyFax = "";
	private String industry = "";
	private String detailAddress = "";
	private String id = "";
	private String message = "";
	/**
	 * 保存客户信息
	 * @return String
	 */
	public String saveCustomerForPhone()
	{
		CustomerInfo customerInfo = new CustomerInfo();
		
		//customerInfo.setCompanyId(sessionCompanyId);
		
		customerInfo.setCreatorId(userId);
		customerInfo.setSalesmanId(userId);
		
		customerInfo.setCreateTime(Calendar.getInstance());
		
		customerInfo.setProgress("新建");
		customerInfo.setProgressId(BusinessProgressKey.NEW);
		
		customerInfo.setAddress(detailAddress);
		//customerInfo.setCategoryId(customerInfo.getCategoryId());
		//customerInfo.setSourceId(clientComeWay);
		//customerInfo.setCity(customerInfo.getCity());
		//customerInfo.setDistrict(customerInfo.getDistrict());
//		customerInfo.setLevelId(customerInfo.getLevelId());
//		customerInfo.setProvince(customerInfo.getProvince());
		
		customerInfo.setRegisterTime(Calendar.getInstance());
		customerInfo.setMainIndustry(industry);
		customerInfo.setCompanyFullName(companyFullName);
		customerInfo.setCustomerName(clientName);
		
		customerInfoService.save(customerInfo);
		id = customerInfo.getId();
		message = "success";
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("message", message);
		request.setAttribute("id", id);
		return COMMON_RESULT;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public String getClientComeWay() {
		return clientComeWay;
	}
	public void setClientComeWay(String clientComeWay) {
		this.clientComeWay = clientComeWay;
	}
	public String getClientType() {
		return clientType;
	}
	public void setClientType(String clientType) {
		this.clientType = clientType;
	}
	public String getDevelopProcess() {
		return developProcess;
	}
	public void setDevelopProcess(String developProcess) {
		this.developProcess = developProcess;
	}
	public String getClientMature() {
		return clientMature;
	}
	public void setClientMature(String clientMature) {
		this.clientMature = clientMature;
	}
	public String getClientProgress() {
		return clientProgress;
	}
	public void setClientProgress(String clientProgress) {
		this.clientProgress = clientProgress;
	}
	public String getCompanyFullName() {
		return companyFullName;
	}
	public void setCompanyFullName(String companyFullName) {
		this.companyFullName = companyFullName;
	}
	public String getCompanyFax() {
		return companyFax;
	}
	public void setCompanyFax(String companyFax) {
		this.companyFax = companyFax;
	}
	public String getIndustry() {
		return industry;
	}
	public void setIndustry(String industry) {
		this.industry = industry;
	}
	public String getDetailAddress() {
		return detailAddress;
	}
	public void setDetailAddress(String detailAddress) {
		this.detailAddress = detailAddress;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}

/**
 * 
 */
package com.boan.crm.customer.action;

import java.util.Calendar;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.boan.crm.customer.model.ContractPersonInfo;
import com.boan.crm.customer.model.CustomerInfo;
import com.boan.crm.customer.service.IContractPersonService;
import com.boan.crm.customer.service.ICustomerInfoService;
import com.boan.crm.sms.model.SMSCustomerInfo;
import com.boan.crm.sms.service.ISMSCustomerInfoService;
import com.boan.crm.utils.action.BaseActionSupport;

/**
 * @author luojx
 *
 */
@Controller("contractPersonInfoAction")
@Scope("prototype")
public class ContractPersonInfoAction extends BaseActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5321204850710250609L;
	// 客户状态接口类
	@Resource
	private IContractPersonService contractpersonInfoService;
	@Autowired
	@Qualifier("SMSCustomerInfoService")
	private ISMSCustomerInfoService sMSCustomerInfoService;
	@Autowired
	@Qualifier("customerInfoService")
	//客户状态接口类
	private ICustomerInfoService customerInfoService;
	
	private ContractPersonInfo contractPersonInfo = null;
	
	private String customerId = null;
	private String personId = null;
	private String message = null;
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String contractPerson()
	{
		if(personId != null && personId.length() > 0)
		{
			contractPersonInfo = contractpersonInfoService.get(personId);
		}else
		{
			contractPersonInfo = new ContractPersonInfo();
		}
		return SUCCESS ;
	}
	
	public String saveContractPerson()
	{
		ContractPersonInfo obj = null;
		if(personId != null && personId.length() > 0)
		{
			obj = contractpersonInfoService.get(personId);
		}else
		{
			obj = new ContractPersonInfo();
		}
		
		obj.setBirthday(contractPersonInfo.getBirthday());
		obj.setCreateTime(Calendar.getInstance());
		obj.setCustomerId(contractPersonInfo.getCustomerId());
		obj.setDeptOrDuty(contractPersonInfo.getDeptOrDuty());
		obj.setEmail(contractPersonInfo.getEmail());
		obj.setNickName(contractPersonInfo.getNickName());
		obj.setPersonName(contractPersonInfo.getPersonName());
		obj.setPhone(contractPersonInfo.getPhone());
		obj.setQq(contractPersonInfo.getQq());
		obj.setTel(contractPersonInfo.getTel());
		
		contractpersonInfoService.save(contractPersonInfo);
		
		if(personId != null && personId.length() > 0)
		{
			
		}else
		{
			//需保存到短信用户处
			SMSCustomerInfo smsCustomer = new SMSCustomerInfo();
			smsCustomer.setCustomerId(contractPersonInfo.getCustomerId());
			//smsCustomer.setBirthday(birthday)
			CustomerInfo customer = customerInfoService.get(contractPersonInfo.getCustomerId());
			if(customer != null)
			{
				smsCustomer.setName(customer.getCustomerName());
				smsCustomer.setOrganId(customer.getCompanyId());
				smsCustomer.setOrganName(customer.getCompanyFullName());
				smsCustomer.setSalesmanId(customer.getSalesmanId());
				smsCustomer.setCategoryId(customer.getCategoryId());
				smsCustomer.setBirthday(contractPersonInfo.getBirthday());
				smsCustomer.setCreateTime(Calendar.getInstance());
				smsCustomer.setEmail(contractPersonInfo.getEmail());
				smsCustomer.setPhone(contractPersonInfo.getTel());
				smsCustomer.setQq(contractPersonInfo.getQq());
				smsCustomer.setPostalcode(customer.getPostCode());
				smsCustomer.setNickname(contractPersonInfo.getNickName());
				sMSCustomerInfoService.saveSMSCustomerInfo(smsCustomer);
			}
		}
		
		message = "保存成功！";
		
		return SUCCESS;
	}
	public String personService()
	{
		contractPersonInfo = contractpersonInfoService.get(personId);
		return SUCCESS;
	}
	public String deletePersonInfo()
	{
		contractpersonInfoService.deleteContractPersonInfo(personId);
		return NONE;
	}
	
	public ContractPersonInfo getContractPersonInfo() {
		return contractPersonInfo;
	}

	public void setContractPersonInfo(ContractPersonInfo contractPersonInfo) {
		this.contractPersonInfo = contractPersonInfo;
	}

	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getPersonId() {
		return personId;
	}
	public void setPersonId(String personId) {
		this.personId = personId;
	}
	
	
}

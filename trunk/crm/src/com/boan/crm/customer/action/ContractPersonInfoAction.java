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
		if(contractPersonInfo.getId() != null && contractPersonInfo.getId().length() > 0)
		{
			obj = contractpersonInfoService.get(contractPersonInfo.getId());
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
		
		contractpersonInfoService.save(obj);
		if(contractPersonInfo.getId() == null || contractPersonInfo.getId().equals(""))
		{
			contractPersonInfo.setId(obj.getId());
		}
		
		//需保存到短信用户处
		boolean newUserFlag = false;
		
		CustomerInfo customer = customerInfoService.get(contractPersonInfo.getCustomerId());
		if(customer != null)
		{
			SMSCustomerInfo smsCustomer = sMSCustomerInfoService.getSMSCustomerInfoByCustomerId( contractPersonInfo.getId() );
			if(smsCustomer == null)
			{
				newUserFlag = true;
				smsCustomer = new SMSCustomerInfo();
			}
			
			smsCustomer.setCustomerId(contractPersonInfo.getId());
			smsCustomer.setCategoryId("1");
			smsCustomer.setName(obj.getPersonName());
			smsCustomer.setOrganId( sessionCompanyId );
			smsCustomer.setOrganName( sessionCompanyName );
			smsCustomer.setSalesmanId(customer.getSalesmanId());
			smsCustomer.setBirthday(obj.getBirthday());
			smsCustomer.setCreateTime(Calendar.getInstance());
			smsCustomer.setEmail(obj.getEmail());
			smsCustomer.setPhone(obj.getPhone());
			smsCustomer.setQq(obj.getQq());
			smsCustomer.setPost(obj.getDeptOrDuty());
			smsCustomer.setUnitAddress(customer.getAddress());
			smsCustomer.setPostalcode(customer.getPostCode());
			smsCustomer.setNickname(obj.getNickName());
			smsCustomer.setUnit(customer.getCustomerName());
			if(newUserFlag)
			{
				sMSCustomerInfoService.saveSMSCustomerInfo(smsCustomer);
			}else
			{
				sMSCustomerInfoService.updateSMSCustomerInfoForCustomer(contractPersonInfo.getId(), smsCustomer);
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
		sMSCustomerInfoService.deleteSMSCustomerInfoFoCustomer(personId);
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

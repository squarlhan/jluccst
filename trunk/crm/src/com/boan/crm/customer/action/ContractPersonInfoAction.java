/**
 * 
 */
package com.boan.crm.customer.action;

import java.util.Calendar;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.boan.crm.customer.model.ContractPersonInfo;
import com.boan.crm.customer.service.IContractPersonService;
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
	private ContractPersonInfo contractPersonInfo = null;
	
	private String customerId = null;
	private String personId = null;
	
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

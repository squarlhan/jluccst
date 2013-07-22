/**
 * 
 */
package com.boan.crm.customer.action;

import java.util.Calendar;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.boan.crm.customer.model.ContractPersonInfo;
import com.boan.crm.customer.service.IContractPersonService;
import com.boan.crm.utils.action.BaseActionSupport;
import com.boan.crm.utils.calendar.MySimpleDateFormat;

/**
 * @author luojx
 * 客户信息action
 */
@Controller("contractPersonInfoForPhoneAction")
@Scope("prototype")
public class ContractPersonInfoForPhoneAction extends BaseActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4140371188076904836L;
	// 客户状态接口类
	@Resource
	private IContractPersonService contractpersonInfoService;
	
	private String name = "";
	private String position = "";
	private String mobile = "";
	private String telephone = "";
	private String nickName = "" ;
	private String birthDay = "";
	private String QQ = "";
	private String email = "";
	private String birtyType = "";
	private String customerId = "";
	private String id = "";
	private String message = "";
	/**
	 * 保存联系人信息
	 * @return String
	 */
	public String saveContactPersonForPhone()
	{
		ContractPersonInfo obj = new ContractPersonInfo();
		if(birthDay != null && birthDay.length() > 0)
			obj.setBirthday(MySimpleDateFormat.parse(birthDay,"yyyy-MM-dd"));
		
		obj.setCreateTime(Calendar.getInstance());
		obj.setCustomerId(customerId);
		obj.setDeptOrDuty(position);
		obj.setEmail(email);
		if(birtyType == null)
			obj.setLunar(0);
		else
			obj.setLunar(Integer.parseInt(birtyType));
		
		obj.setNickName(nickName);
		obj.setPersonName(name);
		obj.setPhone(mobile);
		obj.setQq(QQ);
		obj.setTel(telephone);
		
		contractpersonInfoService.save(obj);
		id = obj.getId();
		message = "success";
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("message", message);
		request.setAttribute("id", id);
		return COMMON_RESULT;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getBirthDay() {
		return birthDay;
	}
	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}
	public String getQQ() {
		return QQ;
	}
	public void setQQ(String qQ) {
		QQ = qQ;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getBirtyType() {
		return birtyType;
	}
	public void setBirtyType(String birtyType) {
		this.birtyType = birtyType;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
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

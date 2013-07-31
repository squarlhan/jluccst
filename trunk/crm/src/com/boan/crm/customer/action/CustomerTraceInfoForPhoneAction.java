/**
 * 为手机端跟进任务Action
 */
package com.boan.crm.customer.action;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.boan.crm.customer.model.CustomerTraceInfo;
import com.boan.crm.customer.service.ICustomerTraceInfoService;
import com.boan.crm.utils.action.BaseActionSupport;
import com.boan.crm.utils.calendar.MySimpleDateFormat;

/**
 * @author luojx
 * 客户跟进信息action
 */
@Controller("customerTraceInfoForPhoneAction")
@Scope("prototype")
public class CustomerTraceInfoForPhoneAction extends BaseActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4140371188076904836L;
	@Autowired
	@Qualifier("customerTraceInfoService")
	private ICustomerTraceInfoService customerTraceInfoService;
	
	private String id = "";
	private String followPeople = null;
	private String followDate = "";
	private String connectWay = "";
	private String QQ = "";
	private String email  = "";
	private String telphone  = "";
	private String followTask = "";
	private String followRealDate = "";
	private String message = null;
	private String followIntrester  ="";
	private String followUnagreePoint = "";
	
	private String userId = "";
	private String contactId  = ""; 
	private String vistPeople = "";  
	private String time   = "";
	private String type   = "";
	private String qq   = "";
	private String emial   = "";
	private String realTime   = "";
	private String intrester  = ""; 
	private String unAgree  = "";
	/**
	 * 手机端完成任务，保存客户跟进信息
	 * @return String
	 */
	public String saveTraceInfoForPhone()
	{
		CustomerTraceInfo obj = customerTraceInfoService.get(id);
		if(obj != null)
		{
			if(followDate != null &&followDate.length() > 0)
			{
				obj.setTraceTime(MySimpleDateFormat.parse(followDate, "yyyy-MM-dd HH:mm"));
			}else
			{
				obj.setTraceTime(Calendar.getInstance());
			}
			if(followRealDate != null &&followRealDate.length() > 0)
			{
				obj.setActualTraceTime(MySimpleDateFormat.parse(followRealDate, "yyyy-MM-dd HH:mm"));
			}
			obj.setTraceFlag("1");
			obj.setQq(QQ);
			obj.setTel(telphone);
			obj.setTask(followTask);
			obj.setInterest(followIntrester);
			obj.setObjection(followUnagreePoint);
			obj.setEmail(email);
			obj.setTraceOption(connectWay);
			//obj.setTracePerson
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
	 * 手机端新建客户跟进信息
	 * @return String
	 */
	public String saveNewTraceInfoForPhone()
	{
		CustomerTraceInfo obj = new CustomerTraceInfo();
		
		obj.setCustomerId(contactId);
		obj.setEmail(email);
		obj.setTask(followTask);
		obj.setInterest(intrester);
		obj.setObjection(unAgree);
		obj.setQq(qq);
		obj.setTraceOption(type);
		obj.setSalesmanId(userId);
		obj.setTracePersonId(vistPeople);
		
		if(realTime != null && realTime.length() > 0)
			obj.setActualTraceTime(MySimpleDateFormat.parse( realTime,"yyyy-MM-dd HH:mm:ss"));
		if(time != null && time.length() > 0)
			obj.setTraceTime(MySimpleDateFormat.parse( time,"yyyy-MM-dd HH:mm:ss"));
		
		customerTraceInfoService.save(obj);
		id = obj.getId();
		message = "success";
		
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("message", message);
		request.setAttribute("id", id);
		return COMMON_RESULT;
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFollowPeople() {
		return followPeople;
	}
	public void setFollowPeople(String followPeople) {
		this.followPeople = followPeople;
	}
	public String getFollowDate() {
		return followDate;
	}
	public void setFollowDate(String followDate) {
		this.followDate = followDate;
	}
	public String getConnectWay() {
		return connectWay;
	}
	public void setConnectWay(String connectWay) {
		this.connectWay = connectWay;
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
	public String getTelphone() {
		return telphone;
	}
	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}
	public String getFollowTask() {
		return followTask;
	}
	public void setFollowTask(String followTask) {
		this.followTask = followTask;
	}
	public String getFollowRealDate() {
		return followRealDate;
	}
	public void setFollowRealDate(String followRealDate) {
		this.followRealDate = followRealDate;
	}
	public String getFollowIntrester() {
		return followIntrester;
	}
	public void setFollowIntrester(String followIntrester) {
		this.followIntrester = followIntrester;
	}
	public String getFollowUnagreePoint() {
		return followUnagreePoint;
	}
	public void setFollowUnagreePoint(String followUnagreePoint) {
		this.followUnagreePoint = followUnagreePoint;
	}

	public ICustomerTraceInfoService getCustomerTraceInfoService() {
		return customerTraceInfoService;
	}

	public void setCustomerTraceInfoService(
			ICustomerTraceInfoService customerTraceInfoService) {
		this.customerTraceInfoService = customerTraceInfoService;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getContactId() {
		return contactId;
	}

	public void setContactId(String contactId) {
		this.contactId = contactId;
	}

	public String getVistPeople() {
		return vistPeople;
	}

	public void setVistPeople(String vistPeople) {
		this.vistPeople = vistPeople;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getEmial() {
		return emial;
	}

	public void setEmial(String emial) {
		this.emial = emial;
	}

	public String getRealTime() {
		return realTime;
	}

	public void setRealTime(String realTime) {
		this.realTime = realTime;
	}

	public String getIntrester() {
		return intrester;
	}

	public void setIntrester(String intrester) {
		this.intrester = intrester;
	}

	public String getUnAgree() {
		return unAgree;
	}

	public void setUnAgree(String unAgree) {
		this.unAgree = unAgree;
	}
}

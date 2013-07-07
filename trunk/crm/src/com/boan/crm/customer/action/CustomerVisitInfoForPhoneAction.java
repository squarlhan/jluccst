/**
 * 为手机端回访任务Action
 */
package com.boan.crm.customer.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.boan.crm.customer.model.CustomerVisitInfo;
import com.boan.crm.customer.service.ICustomerVisitInfoService;
import com.boan.crm.utils.action.BaseActionSupport;
import com.boan.crm.utils.calendar.MySimpleDateFormat;

/**
 * @author luojx
 * 客户回访信息action
 */
@Controller("customerVisitInfoForPhoneAction")
@Scope("prototype")
public class CustomerVisitInfoForPhoneAction extends BaseActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4140371188076904836L;
	@Autowired
	@Qualifier("customerVisitInfoService")
	private ICustomerVisitInfoService customerVisitInfoService;
	
	private String id = "";
	private String followPeople = null;
	private String vistDate = "";
	private String connectWay = "";
	private String QQ = "";
	private String email  = "";
	private String telphone  = "";
	private String task = "";
	private String vistRealDate = "";
	private String message = null;
	private String vistResult  ="";
	private String vistMark = "";
	private String isFinisehd = "";
	/**
	 * 手机端完成任务，保存客户回访信息
	 * @return String
	 */
	public String saveVisitInfoForPhone()
	{
		CustomerVisitInfo obj = customerVisitInfoService.get(id);
		if(obj != null)
		{
			if(vistDate != null &&vistDate.length() > 0)
			{
				obj.setVisitTime(MySimpleDateFormat.parse(vistDate, "yyyy-MM-dd HH:mm"));
			}
			if(vistRealDate != null &&vistRealDate.length() > 0)
			{
				obj.setActualVisitTime(MySimpleDateFormat.parse(vistRealDate, "yyyy-MM-dd HH:mm"));
			}
			obj.setVisitFlag(isFinisehd);
			obj.setQq(QQ);
			obj.setTel(telphone);
			obj.setTask(task);
			obj.setContentResult(vistResult);
			obj.setRemark(vistMark);
			obj.setEmail(email);
			obj.setVisitOption(connectWay);
			customerVisitInfoService.save(obj);
			
			message = "success";
		}else
		{
			message = "failure";
		}
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("message", message);
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
	public String getVistDate() {
		return vistDate;
	}
	public void setVistDate(String vistDate) {
		this.vistDate = vistDate;
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
	public String getTask() {
		return task;
	}
	public void setTask(String task) {
		this.task = task;
	}
	public String getVistRealDate() {
		return vistRealDate;
	}
	public void setVistRealDate(String vistRealDate) {
		this.vistRealDate = vistRealDate;
	}
	public String getVistResult() {
		return vistResult;
	}
	public void setVistResult(String vistResult) {
		this.vistResult = vistResult;
	}
	public String getVistMark() {
		return vistMark;
	}
	public void setVistMark(String vistMark) {
		this.vistMark = vistMark;
	}
	public String getIsFinisehd() {
		return isFinisehd;
	}
	public void setIsFinisehd(String isFinisehd) {
		this.isFinisehd = isFinisehd;
	}
}

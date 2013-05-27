package com.boan.crm.customer.model;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

/**
 * 客户跟进信息实体类
 * 
 * @author luojx
 * @version 1.0.0
 */
@Entity
@Table(name = "CUSTOMER_TRACE_INFO")
public class CustomerTraceInfo implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6407278513107210750L;

	public CustomerTraceInfo(){ this.id = ""; }
	@Id
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@GeneratedValue(generator = "system-uuid")
	private String id;
	@Transient
	private String customerName = "";
	@Column(name = "CUSTOMER_ID" , length = 50)
	private String customerId = "";
	@Column(name = "TRACEPERSONID" , length = 50)
	private String tracePersonId = "";
	@Transient
	private ContractPersonInfo person = new ContractPersonInfo();
	@Column(name = "tel" , length = 50)
	private String tel = "";
	@Column(name = "qq" , length = 50)
	private String qq = "";
	@Column(name = "email" , length = 50)
	private String email = "";
	@Transient
	private String progress = "";
	@Column(name = "COMPANY_ID" , length = 50)
	private String companyId = "";
	@Transient
	private String salesman = "";
	@Column(name = "SALESMANID" , length = 50)
	private String salesmanId = "";
	@Column(name = "TRACEOPTION" , length = 50)
	private String traceOption = "";
	@Column(name = "TRACEFLAG")
	private String traceFlag = "";
	@Column(name = "TRACE_TIME")
	private Calendar traceTime = Calendar.getInstance();
	@Column(name = "DELETEFLAG")
	private int deleteFlag = 0;
	@Column(name = "ACTUALTRACE_TIME")
	private Calendar actualTraceTime = Calendar.getInstance();
	@Transient
	private String traceTimeStr = "";
	@Transient
	private String actualTraceTimeStr = "";
	@Column(name = "TASK" , length = 255)
	private String task = "";
	@Column(name = "INTERREST" , length = 255)
	private String interest = "";
	@Column(name = "OBJECTION" , length = 255)
	private String objection = "";
	@Transient
	private int sms = 0;
	@Column(name = "DEALING_FLAG")
	private String dealingFlag = "";
	/**
	 * 编号
	 * @return String
	 */
	public String getId()
	{
		return id;
	}
	/**
	 * 编号
	 * @param id
	 */
	public void setId( String id )
	{
		this.id = id;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getSalesman() {
		return salesman;
	}
	public void setSalesman(String salesman) {
		this.salesman = salesman;
	}
	public String getSalesmanId() {
		return salesmanId;
	}
	public void setSalesmanId(String salesmanId) {
		this.salesmanId = salesmanId;
	}
	public String getTraceOption() {
		return traceOption;
	}
	public void setTraceOption(String traceOption) {
		this.traceOption = traceOption;
	}
	public Calendar getTraceTime() {
		return traceTime;
	}
	public void setTraceTime(Calendar traceTime) {
		this.traceTime = traceTime;
	}
	public String getTask() {
		return task;
	}
	public void setTask(String task) {
		this.task = task;
	}
	public String getInterest() {
		return interest;
	}
	public void setInterest(String interest) {
		this.interest = interest;
	}
	public String getObjection() {
		return objection;
	}
	public void setObjection(String objection) {
		this.objection = objection;
	}
	
	public String getTracePersonId() {
		return tracePersonId;
	}
	public void setTracePersonId(String tracePersonId) {
		this.tracePersonId = tracePersonId;
	}
	public ContractPersonInfo getPerson() {
		return person;
	}
	public void setPerson(ContractPersonInfo person) {
		this.person = person;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getProgress() {
		return progress;
	}
	public void setProgress(String progress) {
		this.progress = progress;
	}
	public int getDeleteFlag() {
		return deleteFlag;
	}
	public void setDeleteFlag(int deleteFlag) {
		this.deleteFlag = deleteFlag;
	}
	public String getCompanyId() {
		return companyId;
	}
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	public String getTraceFlag() {
		return traceFlag;
	}
	public void setTraceFlag(String traceFlag) {
		this.traceFlag = traceFlag;
	}
	public int getSms() {
		return sms;
	}
	public void setSms(int sms) {
		this.sms = sms;
	}
	public String getActualTraceTimeStr() {
		return actualTraceTimeStr;
	}
	public void setActualTraceTimeStr(String actualTraceTimeStr) {
		this.actualTraceTimeStr = actualTraceTimeStr;
	}
	public Calendar getActualTraceTime() {
		return actualTraceTime;
	}
	public void setActualTraceTime(Calendar actualTraceTime) {
		this.actualTraceTime = actualTraceTime;
	}
	public String getTraceTimeStr() {
		return traceTimeStr;
	}
	public void setTraceTimeStr(String traceTimeStr) {
		this.traceTimeStr = traceTimeStr;
	}
	/**
	 * 要成交标记
	 * @return　String
	 */
	public String getDealingFlag() {
		return dealingFlag;
	}
	/**
	 * 要成交标记
	 * @param dealingFlag
	 */
	public void setDealingFlag(String dealingFlag) {
		this.dealingFlag = dealingFlag;
	}
}

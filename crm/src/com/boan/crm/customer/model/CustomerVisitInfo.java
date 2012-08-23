package com.boan.crm.customer.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

/**
 * 客户回访信息实体类
 * 
 * @author luojx
 * @version 1.0.0
 */
@Entity
@Table(name = "CUSTOMER_VISIT_INFO")
public class CustomerVisitInfo implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6407278513107210750L;

	public CustomerVisitInfo(){ this.id = ""; }
	@Id
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@GeneratedValue(generator = "system-uuid")
	private String id;
	@Transient
	private String customerName = "";
	@Column(name = "CUSTOMER_ID" , length = 50)
	private String customerId = "";
	@Transient
	private String salesman = "";
	@Column(name = "SALESMANID" , length = 50)
	private String salesmanId = "";
	@Column(name = "VISITPERSONID" , length = 50)
	private String visitPersonId = "";
	
	@Transient
	private ContractPersonInfo person = new ContractPersonInfo();
	@Column(name = "tel" , length = 50)
	private String tel = "";
	@Column(name = "qq" , length = 50)
	private String qq = "";
	@Column(name = "email" , length = 50)
	private String email = "";
	@Column(name = "VISITOPTION" , length = 50)
	private String visitOption = "";
	@Column(name = "VISIT_TIME")
	private Calendar visitTime = Calendar.getInstance();
	@Column(name = "TASK" , length = 255)
	private String task = "";
	@Column(name = "CONTENTRESULT" , length = 255)
	private String contentResult = "";
	@Column(name = "REMARK" , length = 255)
	private String remark = "";
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
	public String getTask() {
		return task;
	}
	public void setTask(String task) {
		this.task = task;
	}
	public String getVisitOption() {
		return visitOption;
	}
	public void setVisitOption(String visitOption) {
		this.visitOption = visitOption;
	}
	public Calendar getVisitTime() {
		return visitTime;
	}
	public void setVisitTime(Calendar visitTime) {
		this.visitTime = visitTime;
	}
	public String getContentResult() {
		return contentResult;
	}
	public void setContentResult(String contentResult) {
		this.contentResult = contentResult;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getVisitPersonId() {
		return visitPersonId;
	}
	public void setVisitPersonId(String visitPersonId) {
		this.visitPersonId = visitPersonId;
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
}

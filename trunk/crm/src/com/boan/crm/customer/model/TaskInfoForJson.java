package com.boan.crm.customer.model;
/**
 * 任务对象json
 * @author Luojx
 *
 */
public class TaskInfoForJson {
	private String id = "";
	private String type = "";
	private String task_staus = "";
	private String company = "";
	private String object_name = "";
	private String phone = "";
	private String date = "";
	private String operator = "";
	private String customerId = "";
	public TaskInfoForJson(String id,String type,String task_staus,String company,String object_name,String phone,String date,String customerId)
	{
		this.id = id;
		this.type = type;
		this.task_staus = task_staus;
		this.company = company;
		this.object_name = object_name;
		this.phone = phone;
		this.date = date;
		this.customerId = customerId;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getTask_staus() {
		return task_staus;
	}
	public void setTask_staus(String task_staus) {
		this.task_staus = task_staus;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getObject_name() {
		return object_name;
	}
	public void setObject_name(String object_name) {
		this.object_name = object_name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	
}

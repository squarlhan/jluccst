package com.boan.crm.customer.model;
/**
 * 任务对象json
 * @author Luojx
 *
 */
public class CustomerTaskInfoForJson {
	private String id = "";
	private String company = "";
	private String name = "";
	private String phone = "";
	private String date = "";
	public CustomerTaskInfoForJson(String id,String company,String name,String phone,String date)
	{
		this.id = id;
		this.name = name;
		this.company = company;
		this.phone = phone;
		this.date = date;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
}

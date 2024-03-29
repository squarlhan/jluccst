package com.boan.crm.customer.model;


/**
 * 客户联系人信息实体类Json
 * 
 * @author luojx
 * @version 1.0.0
 */
public class ContractPersonInfoForJson
{

	private String contact_id = "";
	private String name = "";
	private String phone = "";
	private String QQ = "";
	private String email = "";
	
	public String getContact_id() {
		return contact_id;
	}
	public void setContact_id(String contact_id) {
		this.contact_id = contact_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
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
}

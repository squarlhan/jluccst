package com.boan.crm.customer.model;

import java.util.List;

/**
 * 客户信息实体Json类
 * 
 * @author luojx
 * @version 1.0.0
 */
public class CustomerInfoForJson
{
	private String id;
	private String industry = "";
	private String company = "";
	private String company_full_name = "";
	private String fax = "";
	private List<ContractPersonInfoForJson> contact = null; 
	private List<CustomerTaskInfoForJson> follow = null;
	private List<CustomerTaskInfoForJson> visit = null;
	private String type = "";
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getIndustry() {
		return industry;
	}
	public void setIndustry(String industry) {
		this.industry = industry;
	}
	public String getCompany_full_name() {
		return company_full_name;
	}
	public void setCompany_full_name(String company_full_name) {
		this.company_full_name = company_full_name;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public List<ContractPersonInfoForJson> getContact() {
		return contact;
	}
	public void setContact(List<ContractPersonInfoForJson> contact) {
		this.contact = contact;
	}
	public List<CustomerTaskInfoForJson> getFollow() {
		return follow;
	}
	public void setFollow(List<CustomerTaskInfoForJson> follow) {
		this.follow = follow;
	}
	public List<CustomerTaskInfoForJson> getVisit() {
		return visit;
	}
	public void setVisit(List<CustomerTaskInfoForJson> visit) {
		this.visit = visit;
	}
	
}

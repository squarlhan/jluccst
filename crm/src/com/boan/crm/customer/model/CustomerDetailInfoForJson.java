package com.boan.crm.customer.model;

import java.util.List;

/**
 * 客户信息实体Json类
 * 
 * @author luojx
 * @version 1.0.0
 */
public class CustomerDetailInfoForJson
{
	private String id;
	private String industry = "";
	private String company = "";
	private String company_full_name = "";
	private String fax = "";
	private String type = "";
	private String come_from = "";
	private String progress = "";
	private String maturity = "";
	private String develope = "";
	private String address = "";
	
	private List<ContractPersonDetailInfoForJson> contact = null; 
	
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
	public List<ContractPersonDetailInfoForJson> getContact() {
		return contact;
	}
	public void setContact(List<ContractPersonDetailInfoForJson> contact) {
		this.contact = contact;
	}
	public String getCome_from() {
		return come_from;
	}
	public void setCome_from(String come_from) {
		this.come_from = come_from;
	}
	public String getProgress() {
		return progress;
	}
	public void setProgress(String progress) {
		this.progress = progress;
	}
	public String getMaturity() {
		return maturity;
	}
	public void setMaturity(String maturity) {
		this.maturity = maturity;
	}
	public String getDevelope() {
		return develope;
	}
	public void setDevelope(String develope) {
		this.develope = develope;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
}

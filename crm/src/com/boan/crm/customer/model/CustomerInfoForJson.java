package com.boan.crm.customer.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

/**
 * 客户信息实体Json类
 * 
 * @author luojx
 * @version 1.0.0
 */
public class CustomerInfoForJson
{
	public CustomerInfoForJson(){ this.id = ""; }
	public CustomerInfoForJson(String id,String name,String company,String type)
	{
		this.id = id ;
		this.name = name;
		this.company = company;
		this.type = type;
	}
	private String id;
	private String name = "";
	private String company = "";
	private String type = "";
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	
}

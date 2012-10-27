package com.boan.crm.customersearch.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * @author YF
 * 客户查询是不再被查询的客户
 */
@Entity
@Table(name = "No_Search_Customers")
public class NoSearchCustomers {

	@Id
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@GeneratedValue(generator = "system-uuid")
	private String id ;
	
	/**
	 * 客户库中的Id
	 */
	@Column(name = "CUSTOMER_LIB_ID")
	private String customerLibId;
	/**
	 * 登陆人Id
	 */
	@Column(name = "SALESMAN_ID")
	private String salesmanId;
	/*
	 * 登陆人名称
	 */
	@Column(name = "SALESMAN")
	private String salesman;
	/**
	 * 登陆人公司Id
	 */
	@Column(name = "COMPANY_ID")
	private String company_Id;
	/**
	 * 登陆人公司名称
	 */
	@Column(name = "Company_Full_Name")
	private String companyFullName;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCustomerLibId() {
		return customerLibId;
	}
	public void setCustomerLibId(String customerLibId) {
		this.customerLibId = customerLibId;
	}
	public String getSalesmanId() {
		return salesmanId;
	}
	public void setSalesmanId(String salesmanId) {
		this.salesmanId = salesmanId;
	}
	public String getSalesman() {
		return salesman;
	}
	public void setSalesman(String salesman) {
		this.salesman = salesman;
	}
	public String getCompany_Id() {
		return company_Id;
	}
	public void setCompany_Id(String company_Id) {
		this.company_Id = company_Id;
	}
	public String getCompanyFullName() {
		return companyFullName;
	}
	public void setCompanyFullName(String companyFullName) {
		this.companyFullName = companyFullName;
	}
	
}

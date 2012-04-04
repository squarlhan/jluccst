package com.boan.rees.group.model;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * 工厂实体类
 * @author Guiyun Yang
 * @version 1.0.0
 */
@Entity
@Table(name = "GROUP_FACTORY")
public class Factory {

	@Id
	@GenericGenerator(name="system-uuid", strategy="uuid")
	@GeneratedValue(generator="system-uuid")
	
	/**
	 * 工厂实体主键
	 */
	private String id;
	
	/**
	 * 工厂所属公司编号，外键
	 */
	@Column(name = "COMPANY_ID")
	private String companyId;
	
	/**
	 * 工厂名称
	 */
	@Column(name = "FACTORY_NAME")
	private String factoryName;
	
	/**
	 * 工厂电话
	 */
	@Column(name = "PHONE")
	private String phone;
	
	/**
	 * 工厂负责人
	 */
	@Column(name = "PRINCIPAL")
	private String principal;
	
	/**
	 * 创建时间
	 */
	@Column(name = "CREATE_TIME")
	private Calendar createTime = Calendar.getInstance();
	
	/**
	 * 工厂排序号
	 */
	@Column(name = "SORT_INDEX")
	private int sortIndex;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public String getFactoryName() {
		return factoryName;
	}

	public void setFactoryName(String factoryName) {
		this.factoryName = factoryName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPricipal() {
		return principal;
	}

	public void setPricipal(String principal) {
		this.principal = principal;
	}

	public Calendar getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Calendar createTime) {
		this.createTime = createTime;
	}

	public int getSortIndex() {
		return sortIndex;
	}

	public void setSortIndex(int sortIndex) {
		this.sortIndex = sortIndex;
	}

	public String getPrincipal()
	{
		return principal;
	}

	public void setPrincipal( String principal )
	{
		this.principal = principal;
	}

	
}

package com.boan.rees.group.model;

import java.util.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * 公司实体类
 * @author Guiyun Yang
 * @version 1.0.0
 */
@Entity
@Table(name = "GROUP_COMPANY")
public class Company {
	
	
	@Id
	@GenericGenerator(name="system-uuid", strategy="uuid")
	@GeneratedValue(generator="system-uuid")
	
	/**
	 * 公司实体主键
	 */
	private String id;
	
	public Company()
	{
		this.id = "";
	}

	/**
	 * 公司电话
	 */
	@Column(name = "PHONE")
	private String phone;
	
	/**
	 * 公司地址
	 */
	@Column(name = "ADDRESS")
	private String address;
	
	/**
	 * 根节点标示
	 */
	@Column(name = "ROOT_ID")
	private String rootId;
	
	/**
	 * 公司名称
	 */
	@Column(name = "COMPANY_NAME")
	private String companyName;
	
	/**
	 * 公司排序号
	 */
	@Column(name = "SORT_INDEX")
	private int sortIndex = 99;
	
	
	/**
	 * 创建时间
	 */
	@Column(name = "CREATE_TIME")
	private Calendar createTime = Calendar.getInstance();

	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

    public void setAddress(String address) {
		this.address = address;
	}

	public String getRootId() {
		return rootId;
	}

	public void setRootId(String rootId) {
		this.rootId = rootId;
	}


	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public int getSortIndex() {
		return sortIndex;
	}

	public void setSortIndex(int sortIndex) {
		this.sortIndex = sortIndex;
	}

	public Calendar getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Calendar createTime) {
		this.createTime = createTime;
	}
}

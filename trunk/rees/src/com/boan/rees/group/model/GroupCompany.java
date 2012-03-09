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
public class GroupCompany {
	
	
	@Id
	@GenericGenerator(name="system-uuid", strategy="uuid")
	@GeneratedValue(generator="system-uuid")
	
	/**
	 * 公司实体主键
	 */
	private String ID;
	
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
	private String root_id;
	
	/**
	 * 公司名称
	 */
	@Column(name = "COMPANY_NAME")
	private String company_name;
	
	/**
	 * 公司排序号
	 */
	@Column(name = "SORT_INDEX")
	private int sort_index;
	
	
	/**
	 * 创建时间
	 */
	@Column(name = "CREATE_TIME")
	private Calendar create_time;

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
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

	public String getRoot_id() {
		return root_id;
	}

	public void setRoot_id(String root_id) {
		this.root_id = root_id;
	}

	public String getCompany_name() {
		return company_name;
	}

	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}

	public int getSort_index() {
		return sort_index;
	}

	public void setSort_index(int sort_index) {
		this.sort_index = sort_index;
	}

	public Calendar getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Calendar create_time) {
		this.create_time = create_time;
	}

}

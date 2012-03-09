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
public class GroupFactory {

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
	private String company_id;
	
	/**
	 * 工厂名称
	 */
	@Column(name = "FACTORY_NAME")
	private String name;
	
	/**
	 * 工厂电话
	 */
	@Column(name = "PHONE")
	private String phone;
	
	/**
	 * 工厂负责人
	 */
	@Column(name = "PRICIPAL")
	private String pricipal;
	
	/**
	 * 创建时间
	 */
	@Column(name = "CREATE_TIME")
	private Calendar create_time;
	
	/**
	 * 工厂排序号
	 */
	@Column(name = "SORT_INDEX")
	private int sort_index;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCompany_id() {
		return company_id;
	}

	public void setCompany_id(String company_id) {
		this.company_id = company_id;
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

	public String getPricipal() {
		return pricipal;
	}

	public void setPricipal(String pricipal) {
		this.pricipal = pricipal;
	}

	public Calendar getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Calendar create_time) {
		this.create_time = create_time;
	}

	public int getSort_index() {
		return sort_index;
	}

	public void setSort_index(int sort_index) {
		this.sort_index = sort_index;
	}
	
	
	
}

package com.boan.rees.group.model;

import java.util.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * 车间实体类
 * @author Guiyun Yang
 * @version 1.0.0
 */
@Entity
@Table(name = "GROUP_FACTORY")
public class GroupWorkshop {
	
	@Id
	@GenericGenerator(name="system-uuid", strategy="uuid")
	@GeneratedValue(generator="system-uuid")
	
	/**
	 * 车间实体主键
	 */
	private String id;
	
	/**
	 * 工厂编号
	 */
	@Column(name = "FACTORY_ID")
	private String factory_id;
	
	/**
	 * 车间名称
	 */
	@Column(name="WORKSHOP_NAME")
	private String workshop_name;
	
	/**
	 * 车间电话
	 */
	@Column(name="PHONE")
	private String phone;
	
	/**
	 * 车间负责人
	 */
	@Column(name="PRICIPAL")
	private String pricipal;
	
	/**
	 * 排序号
	 */
	@Column(name = "SORT_INDEX")
	private int sort_index;
	
	/**
	 * 创建时间
	 */
	@Column(name="CREATE_TIME")
	private Calendar create_time;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFactory_id() {
		return factory_id;
	}

	public void setFactory_id(String factory_id) {
		this.factory_id = factory_id;
	}

	public String getWorkshop_name() {
		return workshop_name;
	}

	public void setWorkshop_name(String workshop_name) {
		this.workshop_name = workshop_name;
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

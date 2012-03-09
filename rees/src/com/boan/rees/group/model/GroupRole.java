package com.boan.rees.group.model;

import java.util.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * 角色实体类
 * @author Guiyun Yang
 * @version 1.0.0
 */
@Entity
@Table(name = "GROUP_FACTORY")
public class GroupRole {

	@Id
	@GenericGenerator(name="system-uuid", strategy="uuid")
	@GeneratedValue(generator="system-uuid")
	
	/**
	 * 角色实体主键
	 */
	private String id;
	
	/**
	 * 角色名称
	 */
	@Column(name = "ROLE_NAME")
	private String role_name;
	
	/**
	 * 角色创建时间
	 */
	@Column(name = "CREATE_TIME")
	private Calendar create_time;
	
	/**
	 * 角色排序号
	 */
	@Column(name = "SORT_INDEX")
	private int sort_index;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRole_name() {
		return role_name;
	}

	public void setRole_name(String role_name) {
		this.role_name = role_name;
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

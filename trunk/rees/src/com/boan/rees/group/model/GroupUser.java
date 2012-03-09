package com.boan.rees.group.model;

import java.util.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


/**
 * 用户实体类
 * @author Guiyun Yang
 * @version 1.0.0
 */
@Entity
@Table(name = "GROUP_USER")
public class GroupUser {

	@Id
	@GenericGenerator(name="system-uuid", strategy="uuid")
	@GeneratedValue(generator="system-uuid")
	
	/**
	 * 用户实体主键
	 */
	private String id;
	
	/**
	 * 公司编号
	 */
	@Column(name = "COMPANY_ID")
	private String company_id;
	
	/**
	 * 工厂编号
	 */
	@Column(name = "FACTORY_ID")
	private String factory_id;
	
	/**
	 * 车间编号
	 */
	@Column(name = "WORKSHOP_ID")
	private String workshop_id;
	
	/**
	 * 角色编号
	 */
	@Column(name = "ROLE_ID")
	private String role_id;
	
	/**
	 * 用户名
	 */
	@Column(name = "USERNAME")
	private String name;
	
	/**
	 * 用户密码
	 */
	@Column(name = "PASSWORD")
	private String password;
	
	/**
	 * 用户姓名
	 */
	@Column(name = "USECNAME")
	private String usercname;
	
	/**
	 * 办公室电话
	 */
	@Column(name = "OFFICE_PHONE")
	private String office_phone;
	
	/**
	 * 电话
	 */
	@Column(name = "PHONE")
	private String phone;
	
	/**
	 * 邮箱
	 */
	@Column(name = "EMAIL")
	private String email;
	
	/**
	 * 用户类别，普通用户0，超级管理员9，0-9以内的作为备用
	 */
	@Column(name = "USER_TYPE")
	private int user_type;
	
	/**
	 * 创建时间
	 */
	@Column(name = "CREATE_TIME")
	private Calendar create_time;
	
	/**
	 * 排序号
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
	
	public String getFactory_id() {
		return factory_id;
	}
	
	public void setFactory_id(String factory_id) {
		this.factory_id = factory_id;
	}
	
	public String getWorkshop_id() {
		return workshop_id;
	}
	
	public void setWorkshop_id(String workshop_id) {
		this.workshop_id = workshop_id;
	}
	
	public String getRole_id() {
		return role_id;
	}
	
	public void setRole_id(String role_id) {
		this.role_id = role_id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getUsercname() {
		return usercname;
	}
	
	public void setUsercname(String usercname) {
		this.usercname = usercname;
	}
	
	public String getOffice_phone() {
		return office_phone;
	}
	
	public void setOffice_phone(String office_phone) {
		this.office_phone = office_phone;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public int getUser_type() {
		return user_type;
	}
	
	public void setUser_type(int user_type) {
		this.user_type = user_type;
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

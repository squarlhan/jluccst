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
public class User {

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
	private String companyId;
	
	/**
	 * 工厂编号
	 */
	@Column(name = "FACTORY_ID")
	private String factoryId;
	
	/**
	 * 车间编号
	 */
	@Column(name = "WORKSHOP_ID")
	private String workshopId;
	
	/**
	 * 角色编号
	 */
	@Column(name = "ROLE_ID")
	private String roleId;
	
	/**
	 * 角色名称
	 */
	@Column(name = "ROLE_NAME")
	private String roleName;
	
	/**
	 * 用户名
	 */
	@Column(name = "USERNAME")
	private String username;
	
	/**
	 * 用户密码
	 */
	@Column(name = "PASSWORD")
	private String password;
	
	/**
	 * 用户姓名
	 */
	@Column(name = "USERCNAME")
	private String userCName;
	
	/**
	 * 办公室电话
	 */
	@Column(name = "OFFICE_PHONE")
	private String officePhone;
	
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
	private int userType;
	
	/**
	 * 创建时间
	 */
	@Column(name = "CREATE_TIME")
	private Calendar createTime;
	
	/**
	 * 排序号
	 */
	@Column(name = "SORT_INDEX")
	private int sortIndex;
	
	/**
	 * 如果是本人，则本人不能删除本人，不能删除状态置为1
	 */
	private int deleteFlag;

	public User()
	{
		this.id="";
	}

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

	public String getFactoryId() {
		return factoryId;
	}

	public void setFactoryId(String factoryId) {
		this.factoryId = factoryId;
	}

	public String getWorkshopId() {
		return workshopId;
	}

	public void setWorkshopId(String workshopId) {
		this.workshopId = workshopId;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public String getOfficePhone() {
		return officePhone;
	}

	public void setOfficePhone(String officePhone) {
		this.officePhone = officePhone;
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

	public int getUserType() {
		return userType;
	}

	public void setUserType(int userType) {
		this.userType = userType;
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

	public String getUserCName()
	{
		return userCName;
	}

	public void setUserCName( String userCName )
	{
		this.userCName = userCName;
	}

	public int getDeleteFlag()
	{
		return deleteFlag;
	}

	public void setDeleteFlag( int deleteFlag )
	{
		this.deleteFlag = deleteFlag;
	}

	public String getRoleName()
	{
		return roleName;
	}

	public void setRoleName( String roleName )
	{
		this.roleName = roleName;
	}
	
	public static void convertToUser( User oldUser, User newUser )
	{
		oldUser.id = newUser.id;
		oldUser.companyId = newUser.companyId;
		oldUser.factoryId = newUser.factoryId;
		oldUser.workshopId = newUser.workshopId;
		oldUser.roleId = newUser.roleId;
		oldUser.roleName = newUser.roleName;
		oldUser.username = newUser.username;
		oldUser.password = newUser.password;
		oldUser.userCName = newUser.userCName;
		oldUser.officePhone = newUser.officePhone;
		oldUser.phone = newUser.phone;
		oldUser.email = newUser.email;
		oldUser.userType = newUser.userType;
		oldUser.createTime = newUser.createTime;
		oldUser.sortIndex = newUser.sortIndex;
		oldUser.deleteFlag = newUser.deleteFlag;
	}

	public User( String id, String companyId, String factoryId,
			String workshopId, String roleId, String roleName, String username,
			String password, String userCName, String officePhone,
			String phone, String email, int userType, Calendar createTime,
			int sortIndex, int deleteFlag )
	{
		super();
		this.id = id;
		this.companyId = companyId;
		this.factoryId = factoryId;
		this.workshopId = workshopId;
		this.roleId = roleId;
		this.roleName = roleName;
		this.username = username;
		this.password = password;
		this.userCName = userCName;
		this.officePhone = officePhone;
		this.phone = phone;
		this.email = email;
		this.userType = userType;
		this.createTime = createTime;
		this.sortIndex = sortIndex;
		this.deleteFlag = deleteFlag;
	}
	
	
}

package com.boan.crm.groupmanage.model;

import java.util.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

import com.boan.crm.common.UserType;

/**
 * 用户实体类
 * 
 * @author XXX
 * @version 1.0.0
 */
@Entity
@Table(name = "GROUP_USER")
public class User {

	@Id
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@GeneratedValue(generator = "system-uuid")
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
	 * 部门编号
	 */
	@Column(name = "DEPT_ID")
	private String deptId;

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
	 * 阳历生日
	 */
	@Column(name = "BIRTHDAY")
	private String birthday;

	/**
	 * 农历生日
	 */
	@Column(name = "LUNAR_BIRTHDAY")
	private String lunarBirthday;

	/**
	 * 阳历农历标识，0表示过阳历，1表示过农历
	 */
	@Column(name = "LUNAR_SOLAR_FLAG", nullable=false)
	private int lunarSolarFlag;

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
	@Transient
	private int deleteFlag;

	public User() {
		this.id = "";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getUserCName() {
		return userCName;
	}

	public void setUserCName(String userCName) {
		this.userCName = userCName;
	}

	public int getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(int deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public static void convertToUser(User oldUser, User newUser) {
		oldUser.id = newUser.id;
		oldUser.deptId = newUser.deptId;
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
		oldUser.birthday = newUser.birthday;
		oldUser.lunarSolarFlag = newUser.lunarSolarFlag;
		oldUser.deleteFlag = newUser.deleteFlag;
	}

	public User(String id, String deptId, String roleId, String roleName, String username, String password, String userCName, String officePhone, String phone, String email, int userType, Calendar createTime, int sortIndex, int deleteFlag) {
		super();
		this.id = id;
		this.deptId = deptId;
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

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public String getUserTypeName() {
		return UserType.getUserTypeName(this.userType);
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getLunarBirthday() {
		return lunarBirthday;
	}

	public void setLunarBirthday(String lunarBirthday) {
		this.lunarBirthday = lunarBirthday;
	}

	public int getLunarSolarFlag() {
		return lunarSolarFlag;
	}

	public void setLunarSolarFlag(int lunarSolarFlag) {
		this.lunarSolarFlag = lunarSolarFlag;
	}
}

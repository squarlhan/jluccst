/**
 * Copyright (c) 2010 Changchun Boan Co. Ltd.
 * All right reserved.
 * History
 */
/*
 * @(#)UserSession.java 1.1 Jun 12, 2010
 */

package com.boan.crm.groupmanage.common;

import org.apache.commons.lang.StringUtils;

/**
 * XXX 类
 * 
 * @author XXX
 * @version 1.0.0
 */
public class UserSession implements java.io.Serializable
{

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 用户主键
	 */
	private String userId;

	/**
	 * 用户登录名
	 */
	private String username;

	/**
	 * 用户姓名
	 */
	private String userCName;

	/**
	 * 部门id
	 */
	private String deptId;
	
	/**
	 * 部门名称
	 */
	private String deptName;
	
	/**
	 * 公司id
	 */
	private String companyId;
	
	/**
	 * 公司名称
	 */
	private String companyName;
	
	/**
	 * 用户手机号
	 */
	private String userPhone;

	/**
	 * 用户类型
	 */
	private int userType;
	
	/**
	 * 角色关键字
	 */
	private String roleKey;
	
	/**
	 * 产品试用标识，如果正式版，则为空，否则为试用版
	 */
	private String productSuffix;
	
	/**
	 * 用户登录时，所拥有的所有权限key值
	 */
	private String[] popedomKeys;
	
	/**
	 * 公司试用限制标识，1表示有限制，0表示没有
	 */
	private int companyTrialFlag;
	/**
	 * 产品类型
	 */
	private int productType;

	public String getUserId()
	{
		return userId;
	}

	public void setUserId( String userId )
	{
		this.userId = userId;
	}

	public String getUsername()
	{
		return username;
	}

	public void setUsername( String username )
	{
		this.username = username;
	}

	public String getUserCName()
	{
		return userCName;
	}

	public void setUserCName( String userCName )
	{
		this.userCName = userCName;
	}

	public String[] getPopedomKeys()
	{
		return popedomKeys;
	}

	public void setPopedomKeys( String[] popedomKeys )
	{
		this.popedomKeys = popedomKeys;
	}

	public static long getSerialVersionUID()
	{
		return serialVersionUID;
	}

	public String getDeptFullName()
	{
		/*
		String fullName = this.companyName;
		
		if( StringUtils.isNotBlank( this.factoryName ) )
		{
			fullName +=  "→" + this.factoryName;
		}
		if( StringUtils.isNotBlank( this.workshopName ) )
		{
			fullName +=  "→" + this.workshopName;
		}*/
		
		return this.deptName;
	}

	public static long getSerialversionuid()
	{
		return serialVersionUID;
	}

	public int getUserType()
	{
		return userType;
	}

	public void setUserType( int userType )
	{
		this.userType = userType;
	}

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getProductSuffix() {
		return productSuffix;
	}

	public void setProductSuffix(String productSuffix) {
		this.productSuffix = productSuffix;
	}

	public int getCompanyTrialFlag() {
		return companyTrialFlag;
	}

	public void setCompanyTrialFlag(int companyTrialFlag) {
		this.companyTrialFlag = companyTrialFlag;
	}

	public int getProductType() {
		return productType;
	}

	public void setProductType(int productType) {
		this.productType = productType;
	}

	public String getRoleKey() {
		return roleKey;
	}

	public void setRoleKey(String roleKey) {
		this.roleKey = roleKey;
	}

}

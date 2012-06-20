/**
 * Copyright (c) 2010 Changchun Boan Co. Ltd.
 * All right reserved.
 * History
 */
/*
 * @(#)UserSession.java 1.1 Jun 12, 2010
 */

package com.boan.crm.group.common;

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
	 * 公司id
	 */
	private String companyId;
	
	/**
	 * 公司名称
	 */
	private String companyName;

	/**
	 * 工厂id
	 */
	private String factoryId;
	
	/**
	 * 工厂名称
	 */
	private String factoryName;
	
	/**
	 * 车间id
	 */
	private String workshopId;
	
	/**
	 * 车间名称
	 */
	private String workshopName;
	
	/**
	 * 用户类型
	 */
	private int userType;
	
	/**
	 * 用户登录时，所拥有的所有权限key值
	 */
	private String[] popedomKeys;

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
		String fullName = this.companyName;
		
		if( StringUtils.isNotBlank( this.factoryName ) )
		{
			fullName +=  "→" + this.factoryName;
		}
		if( StringUtils.isNotBlank( this.workshopName ) )
		{
			fullName +=  "→" + this.workshopName;
		}
		return fullName;
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

	public String getCompanyId()
	{
		return companyId;
	}

	public void setCompanyId( String companyId )
	{
		this.companyId = companyId;
	}

	public String getCompanyName()
	{
		return companyName;
	}

	public void setCompanyName( String companyName )
	{
		this.companyName = companyName;
	}

	public String getFactoryId()
	{
		return factoryId;
	}

	public void setFactoryId( String factoryId )
	{
		this.factoryId = factoryId;
	}

	public String getFactoryName()
	{
		return factoryName;
	}

	public void setFactoryName( String factoryName )
	{
		this.factoryName = factoryName;
	}

	public String getWorkshopId()
	{
		return workshopId;
	}

	public void setWorkshopId( String workshopId )
	{
		this.workshopId = workshopId;
	}

	public String getWorkshopName()
	{
		return workshopName;
	}

	public void setWorkshopName( String workshopName )
	{
		this.workshopName = workshopName;
	}

}

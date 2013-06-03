/**
 * Copyright (c) 2011 Changchun Boan Co. Ltd.
 * All right reserved.
 * History
 */
/*
 * @(#)UserType.java 1.1 2011-8-27
 */

package com.boan.crm.common;

import java.util.ArrayList;
import java.util.List;

/**
 * XXX 类
 * 
 * @author XXX
 * @version 1.0.0
 */
public class UserType
{
	/**
	 * 用户类型值
	 */
	private int key;

	/**
	 * 用户类型说明
	 */
	private String value;

	/**
	 * 超级管理员
	 */
	public static int ADMINISTRATOR = 9;
	
	/**
	 * 公司管理员
	 */
	public static int COMPANY_ADMINISTRATOR = 8;


	/**
	 * 业务用户
	 */
	public static int COMMON_USER = 0;

	/**
	 * key值字典
	 */
	private static int[] keys = { COMMON_USER,COMPANY_ADMINISTRATOR, ADMINISTRATOR };

	/**
	 * value值字典
	 */
	private static String[] values = { "业务用户", " 公司管理员", "超级管理员" };

	/**
	 * 返回用户类别列表
	 */

	public static List<UserType> getUserTypeList()
	{
		List<UserType> list = new ArrayList<UserType>();
		UserType type = null;
		for( int i = 0; i < keys.length; i++ )
		{
			type = new UserType();
			type.setKey( keys[i] );
			type.setValue( values[i] );
			list.add( type );
		}

		return list;
	}
	/**
	 * 返回公司用户类别列表
	 */

	public static List<UserType> getCompanyUserTypeList()
	{
		List<UserType> list = new ArrayList<UserType>();
		UserType type = null;
		for( int i = 0; i < keys.length-1; i++ )
		{
			type = new UserType();
			type.setKey( keys[i] );
			type.setValue( values[i] );
			list.add( type );
		}

		return list;
	}

	/**
	 * 根据传入的值，获取对应的名称
	 */
	public static String getUserTypeName( int userType )
	{
		String userTypeName = null;
		for( int i = 0; i < keys.length; i++ )
		{
			if( keys[i] == userType )
			{
				userTypeName = values[i];
				break;
			}
		}
		return userTypeName;
	}

	public int getKey()
	{
		return key;
	}

	public void setKey( int key )
	{
		this.key = key;
	}

	public String getValue()
	{
		return value;
	}

	public void setValue( String value )
	{
		this.value = value;
	}
}

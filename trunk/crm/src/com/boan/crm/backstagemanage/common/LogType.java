/**
 * Copyright (c) 2011 Changchun Boan Co. Ltd.
 * All right reserved.
 * History
 */
/*
 * @(#)LogType.java 1.1 2011-1-10
 */

package com.boan.crm.backstagemanage.common;

import java.util.ArrayList;
import java.util.List;

/**
 * 日志类型
 * 
 * @author XXX
 * @version 1.0.0
 */
public class LogType
{
	/**
	 * 信息
	 */
	public static int INFO = 0;

	/**
	 * 警告
	 */
	public static int WARN = 1;

	/**
	 * 错误
	 */
	public static int ERROR = 2;

	/**
	 * 登录
	 */
	public static int LOGIN = 3;
	/**
	 * 退出
	 */
	public static int LOGOUT = 4;

	/**
	 * 静态整型字符的意思
	 */
	private static String[] means = { "信息", "警告", "错误", "登录", "退出" };

	/**
	 * 日志类别标识，主要用于封闭成一个日志对象
	 */
	private int flag;

	/**
	 * 日志类别对应的名称
	 */
	private String name;

	/**
	 * 根据日志标识取得中文意思
	 * 
	 * @param logType
	 * @return
	 */
	public static String getMean( int logType )
	{
		return means[logType];
	}

	/**
	 * 返回日志类型列表
	 * 
	 * @return
	 */
	public static List<LogType> getLogTypeList()
	{
		List<LogType> logTypeList = new ArrayList<LogType>();
		LogType type = null;
		for( int i = 0; i < means.length; i++ )
		{
			type = new LogType();
			type.setFlag( i );
			type.setName( means[i] );
			logTypeList.add( type );
		}
		return logTypeList;
	}

	public int getFlag()
	{
		return flag;
	}

	public void setFlag( int flag )
	{
		this.flag = flag;
	}

	public String getName()
	{
		return name;
	}

	public void setName( String name )
	{
		this.name = name;
	}
}

/**
 * Copyright (c) 2011 Changchun Boan Co. Ltd.
 * All right reserved.
 * History
 */
/*
 * @(#)PathUtil.java 1.1 2011-2-11
 */

package com.boan.crm.utils.path;

/**
 * 获取工程目录类
 * 
 * @author XXX
 * @version 1.0.0
 */
public class PathUtil
{
	private static PathUtil instance = null;

	private PathUtil()
	{

	}

	public static PathUtil getInstance()
	{
		if( instance == null )
		{
			instance = new PathUtil();
		}
		return instance;
	}

	/**
	 * 获取当前文件路径
	 * 
	 * @return
	 */
	public String getWebClassesPath()
	{
		String path = getClass().getProtectionDomain().getCodeSource().getLocation().getPath();
		return path;
	}

	/**
	 * 获取当前工程的web-inf路径
	 * 
	 * @return
	 * @throws IllegalAccessException
	 */
	public String getWebInfPath() throws IllegalAccessException
	{
		String path = getWebClassesPath();
		if( path.indexOf( "WEB-INF" ) > 0 )
		{
			path = path.substring( 0, path.indexOf( "WEB-INF" ) + 8 );
		}
		else
		{
			throw new IllegalAccessException( "路径获取错误" );
		}
		return path;
	}

	/**
	 * 获取当前工程路径
	 * 
	 * @return
	 * @throws IllegalAccessException
	 */
	public String getWebRoot() throws IllegalAccessException
	{
		String path = getWebClassesPath();
		if( path.indexOf( "WEB-INF" ) > 0 )
		{
			path = path.substring( 0, path.indexOf( "WEB-INF/" ) );
		}
		else
		{
			throw new IllegalAccessException( "路径获取错误" );
		}
		return path;
	}

	/**
	 * 获取调用该访问的jar包或类的名称
	 * 
	 * @return
	 * @throws IllegalAccessException
	 */
	public String getJarName(String classFilePath) throws IllegalAccessException
	{
		// "/D:/apache-tomcat-6.0.29/webapps/cbit-csms/WEB-INF/lib/cbit-bundle-csms-utils_1.0.0.jar"
		//String path = getWebClassesPath();
		String path = classFilePath;
		if( path.indexOf( "WEB-INF/" ) > 0 )
		{
			// 可能是class
			if( path.indexOf( ".jar" ) > 0 )
			{
				path = path.substring( path.indexOf( "WEB-INF/" ) + 16, path.indexOf( ".jar" ) );
			}
			else if( path.indexOf( ".class" ) > 0 )
			{
				path = path.substring( path.lastIndexOf( "/" ) + 1, path.indexOf( ".class" ) + 6 );
			}
			// 可能是jar
		}
		else
		{
			throw new IllegalAccessException( "路径获取错误" );
		}
		return path;
	}

	/**
	 * 获取工程名称，如：/cbit-csms
	 * @return
	 * @throws IllegalAccessException
	 */
	public String getContextPath() throws IllegalAccessException
	{
		String path = getWebClassesPath();
		if( path.indexOf( "WEB-INF" ) > 0 )
		{
			path = path.substring( 0,path.indexOf( "WEB-INF/" ) -1 );
			path = path.substring( path.lastIndexOf( ( "/" ),path.length() ) );
		}
		else
		{
			throw new IllegalAccessException( "路径获取错误" );
		}
		return path;
	}

	public static void main( String[] args ) throws Exception
	{
		PathUtil p = new PathUtil();
		System.out.println( p.getWebClassesPath() );
		System.out.println( p.getWebInfPath() );
		System.out.println( p.getWebRoot() );
		//System.out.println( p.getJarName() );
	}
}
package com.boan.crm.groupmanage.security;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.lang.StringUtils;

/**
 * 登录方式
 * 
 * @author Administrator
 * 
 */
public class PropertiesUtil {

	private static PropertiesUtil instance = null;

	private static String loginMehtod = null;
	private static String daysOfExpired = null; 
	private static String daysOfFinished = null; 
	private static String daysOfRecent = null; 
	
	private PropertiesUtil() {
		InputStream in = PropertiesUtil.class.getClassLoader().getResourceAsStream("config.properties");
		Properties configFile = new Properties();
		try {
			configFile.load(in);
			loginMehtod = configFile.getProperty("login-method");
			daysOfExpired = configFile.getProperty("daysofexpired-forphone").toString();
			daysOfFinished = configFile.getProperty("daysoffinished-forphone").toString();
			daysOfRecent = configFile.getProperty("daysofrecent-forphone").toString();
			in.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static PropertiesUtil getInstance() {
		if (instance == null) {
			instance = new PropertiesUtil();
		}
		return instance;
	}

	public boolean isUsbKeyLogin() {
		boolean b = false;
		if (StringUtils.isNotBlank(loginMehtod)) {
			if ("key".equalsIgnoreCase(loginMehtod)) {
				b = true;
			}
		}
		return b;
	}
	
	public int getDaysOfExpired()
	{
		if(daysOfExpired != null)
		{
			return Integer.parseInt(daysOfExpired);
		}else
		{
			return 7;
		}
	}
	public int getDaysOfFinished()
	{
		if(daysOfFinished != null)
		{
			return Integer.parseInt(daysOfFinished);
		}else
		{
			return 7;
		}
	}
	public int getDaysOfRecent()
	{
		if(daysOfRecent != null)
		{
			return Integer.parseInt(daysOfRecent);
		}else
		{
			return 7;
		}
	}
	public static void main(String[] args) {
		System.out.println(PropertiesUtil.getInstance().isUsbKeyLogin());
	}
}

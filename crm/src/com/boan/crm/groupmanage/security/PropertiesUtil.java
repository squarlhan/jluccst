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

	private PropertiesUtil() {
		InputStream in = PropertiesUtil.class.getClassLoader().getResourceAsStream("config.properties");
		Properties configFile = new Properties();
		try {
			configFile.load(in);
			loginMehtod = configFile.getProperty("login-method");
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

	public static void main(String[] args) {
		System.out.println(PropertiesUtil.getInstance().isUsbKeyLogin());
	}
}

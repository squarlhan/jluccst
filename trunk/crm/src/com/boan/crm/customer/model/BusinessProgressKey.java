/**
 * Copyright (c) 2013 Changchun CBIT Co. Ltd.
 * All right reserved.
 * History
 */
/*
 * @(#)BusinessProgressKey.java 1.1 2013-5-26
 */

package com.boan.crm.customer.model;

import java.util.HashMap;
import java.util.Map;

/**
 * 业务进展关键字类
 * @author luojx
 * @version 1.0.0
 */
public class BusinessProgressKey {
	public static String NEW = "NEW";
	public static String TRACE = "TRACE";
	public static String DEALING = "DEALING";
	public static String DEALED = "DEALED";
	public static String VISIT = "VISIT";
	
	//private Map<String,String> mapKey = new HashMap<String,String>();
	
	
	public BusinessProgressKey()
	{
		
	}
	
	/**
	 * 根据关键字取名称
	 * @param key
	 * @return　String
	 */
	public static String getBusinessProgressNameByKey(String key)
	{
		Map<String,String> mapKey = new HashMap<String,String>();
		mapKey.put(NEW, "新建");
		mapKey.put(TRACE, "跟进");
		mapKey.put(DEALING, "要成交");
		mapKey.put(DEALED, "成交");
		
		return mapKey.get(key);
	}
}

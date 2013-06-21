/**
 * Copyright (c) 2012 Boan Co. Ltd.
 * All right reserved.
 * History
 */
package com.boan.crm.datadictionary.model;


/**
 * 数据字典实体类For json
 * 
 * @author Luojx
 * @version 1.0.0
 */
public class DataDictionaryForPhone {
	/**
	 * 编号
	 */
	private String id;
	
	private String value;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}

/**
 * Copyright (c) 2012 Boan Co. Ltd.
 * All right reserved.
 * History
 */
package com.boan.crm.datadictionary.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * 客户类别实体类
 * 
 * @author leon
 * @version 1.0.0
 */
@Entity
@Table(name = "CUSTOMER_TYPE")
public class CustomerType implements Serializable {
	private static final long serialVersionUID = 7197292703142337721L;

	@Id
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@GeneratedValue(generator = "system-uuid")
	/**
	 * 编号
	 */
	private String id;

	/**
	 * 类别名称
	 */
	@Column(name = "TYPE_NAME" , length = 50)
	private String typeName;

	/**
	 * 类别说明
	 */
	@Column(name = "REMARK", length = 200)
	private String remark;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}

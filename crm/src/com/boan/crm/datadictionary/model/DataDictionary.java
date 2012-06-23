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
 * 数据字典实体类
 * 
 * @author leon
 * @version 1.0.0
 */
@Entity
@Table(name = "DATA_DICTIONARY")
public class DataDictionary implements Serializable {
	private static final long serialVersionUID = 7414878704057469157L;

	@Id
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@GeneratedValue(generator = "system-uuid")
	/**
	 * 编号
	 */
	private String id;
	
	/**
	 * 类别
	 */
	@Column(name = "TYPE_FLAG")
	private Integer typeFlag = 0;

	/**
	 * 名称
	 */
	@Column(name = "NAME" , length = 50)
	private String name;
	
	/**
	 * 排序号
	 */
	@Column(name = "SORT_INDEX")
	private Integer sortIndex = 0;

	/**
	 * 状态说明
	 */
	@Column(name = "REMARK", length = 200)
	private String remark;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getTypeFlag() {
		return typeFlag;
	}

	public void setTypeFlag(Integer typeFlag) {
		this.typeFlag = typeFlag;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getSortIndex() {
		return sortIndex;
	}

	public void setSortIndex(Integer sortIndex) {
		this.sortIndex = sortIndex;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}

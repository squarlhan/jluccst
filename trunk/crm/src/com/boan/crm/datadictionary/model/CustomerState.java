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
 * 客户状态实体类
 * 
 * @author leon
 * @version 1.0.0
 */
@Entity
@Table(name = "CUSTOMER_STATE")
public class CustomerState implements Serializable {
	private static final long serialVersionUID = -7950782833308148559L;

	@Id
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@GeneratedValue(generator = "system-uuid")
	/**
	 * 编号
	 */
	private String id;

	/**
	 * 状态名称
	 */
	@Column(name = "STATE_NAME" , length = 50)
	private String stateName;
	
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

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getSortIndex() {
		return sortIndex;
	}

	public void setSortIndex(Integer sortIndex) {
		this.sortIndex = sortIndex;
	}
	
}

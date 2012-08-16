/**
 * Copyright (c) 2012 Boan Co. Ltd.
 * All right reserved.
 * History
 */
package com.boan.crm.servicemanage.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * 会员类别实体类
 * 
 * @author leon
 * @version 1.0.0
 */
@Entity
@Table(name = "MEMBER_TYPE")
public class MemberType implements Serializable {
	private static final long serialVersionUID = -2013752816374936252L;

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
	@Column(name = "TYPE_NAME", length = 50)
	private String typeName;
	
	/**
	 * 最低标准
	 */
	@Column(name = "MIN_STANDARD")
	private int minStandard = 0;
	
	/**
	 * 最高标准
	 */
	@Column(name = "MAX_STANDARD")
	private int maxStandard = 0;

	/**
	 * 排序号
	 */
	@Column(name = "SORT_INDEX")
	private int sortIndex = 0;

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the typeName
	 */
	public String getTypeName() {
		return typeName;
	}

	/**
	 * @param typeName the typeName to set
	 */
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	

	/**
	 * @return the minStandard
	 */
	public int getMinStandard() {
		return minStandard;
	}

	/**
	 * @param minStandard the minStandard to set
	 */
	public void setMinStandard(int minStandard) {
		this.minStandard = minStandard;
	}

	/**
	 * @return the maxStandard
	 */
	public int getMaxStandard() {
		return maxStandard;
	}

	/**
	 * @param maxStandard the maxStandard to set
	 */
	public void setMaxStandard(int maxStandard) {
		this.maxStandard = maxStandard;
	}

	/**
	 * @return the sortIndex
	 */
	public int getSortIndex() {
		return sortIndex;
	}

	/**
	 * @param sortIndex the sortIndex to set
	 */
	public void setSortIndex(int sortIndex) {
		this.sortIndex = sortIndex;
	}
}

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
	 * 积分标准
	 */
	@Column(name = "POINT_STANDARD")
	private float pointStandard = 0;

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
	 * @return the pointStandard
	 */
	public float getPointStandard() {
		return pointStandard;
	}

	/**
	 * @param pointStandard the pointStandard to set
	 */
	public void setPointStandard(float pointStandard) {
		this.pointStandard = pointStandard;
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

package com.boan.crm.sellreport.sellduty.model;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/** 销售职责类
 * @author YF
 *
 */
@Entity
@Table(name = "SELL_DUTY")
public class SellDuty implements Serializable {

	private static final long serialVersionUID = -5495429232674841691L;

	@Id
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@GeneratedValue(generator = "system-uuid")
	private String id;
	
	/**
	 * 所属单位ID
	 */
	@Column(name = "COMPANY_ID" , length = 50)
	private String companyId;
	
	/**
	 * 所属单位名称
	 */
	@Column(name = "COMPANY_NAME" , length = 50)
	private String companyName;
	
	/**
	 * 名称
	 */
	@Column(name = "NAME" , length = 50)
	private String name;

	/**
	 * 状态说明
	 */
	@Column(name = "REMARK", length = 200)
	private String remark;
	
	/**
	 * 职责类型（0：周报，周计划职责类型  1： 月报，月计划职责类型）
	 */
	@Column(name = "DUTY_TYPE")
	private int dutyType;
	
	/**
	 * 是否是数字类型，0：不是销售额类型  1：是销售额类型
	 */
	@Column(name = "NUMBER_TYPE" ,nullable=false,columnDefinition="int default 0")
	private boolean numberType=false;
	
	/**
	 * 创建时间
	 */
	@Column(name = "CREATE_TIME")
	private Calendar createTime;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public int getDutyType() {
		return dutyType;
	}

	public void setDutyType(int dutyType) {
		this.dutyType = dutyType;
	}

	public Calendar getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Calendar createTime) {
		this.createTime = createTime;
	}

	public boolean isNumberType() {
		return numberType;
	}

	public void setNumberType(boolean numberType) {
		this.numberType = numberType;
	}
}

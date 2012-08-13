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
 * 消费积分信息实体类
 * 
 * @author leon
 * @version 1.0.0
 */
@Entity
@Table(name = "POINT_INFO")
public class PointInfo implements Serializable {
	private static final long serialVersionUID = 5497838163430427742L;

	@Id
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@GeneratedValue(generator = "system-uuid")
	/**
	 * 编号
	 */
	private String id;
	
	/**
	 * 客户编号
	 */
	@Column(name = "COMPANY_ID", length = 50)
	private String companyId;

	/**
	 * 客户名称
	 */
	@Column(name = "COMPANY_NAME", length = 200)
	private String companyName;
	
	/**
	 * 会员类别
	 */
	@Column(name = "MEMBER_TYPE", length = 50)
	private String memberType;

	/**
	 * 消费总额
	 */
	@Column(name = "CONSUMPTION_AMOUNT")
	private float consumptionAmount = 0;
	
	/**
	 * 总积分 
	 */
	@Column(name = "TOTAL_INTEGRAL")
	private int totalIntegral = 0;
	
	/**
	 * 消费次数 
	 */
	@Column(name = "CONSUMPTION_COUNT")
	private int consumptionCount = 0;

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
	 * @return the companyId
	 */
	public String getCompanyId() {
		return companyId;
	}

	/**
	 * @param companyId the companyId to set
	 */
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	/**
	 * @return the companyName
	 */
	public String getCompanyName() {
		return companyName;
	}

	/**
	 * @param companyName the companyName to set
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	/**
	 * @return the memberType
	 */
	public String getMemberType() {
		return memberType;
	}

	/**
	 * @param memberType the memberType to set
	 */
	public void setMemberType(String memberType) {
		this.memberType = memberType;
	}

	/**
	 * @return the consumptionAmount
	 */
	public float getConsumptionAmount() {
		return consumptionAmount;
	}

	/**
	 * @param consumptionAmount the consumptionAmount to set
	 */
	public void setConsumptionAmount(float consumptionAmount) {
		this.consumptionAmount = consumptionAmount;
	}

	/**
	 * @return the totalIntegral
	 */
	public int getTotalIntegral() {
		return totalIntegral;
	}

	/**
	 * @param totalIntegral the totalIntegral to set
	 */
	public void setTotalIntegral(int totalIntegral) {
		this.totalIntegral = totalIntegral;
	}

	/**
	 * @return the consumptionCount
	 */
	public int getConsumptionCount() {
		return consumptionCount;
	}

	/**
	 * @param consumptionCount the consumptionCount to set
	 */
	public void setConsumptionCount(int consumptionCount) {
		this.consumptionCount = consumptionCount;
	}
}

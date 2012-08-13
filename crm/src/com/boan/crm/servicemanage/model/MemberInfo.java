/**
 * Copyright (c) 2012 Boan Co. Ltd.
 * All right reserved.
 * History
 */
package com.boan.crm.servicemanage.model;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * 会员信息实体类
 * 
 * @author leon
 * @version 1.0.0
 */
@Entity
@Table(name = "MEMBER_INFO")
public class MemberInfo implements Serializable {
	private static final long serialVersionUID = -88774420752752650L;

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
	 * 业务员 
	 */
	@Column(name = "SALESPEOPLE", length = 20)
	private String salespeople;
	
	/**
	 * 成为会员时间
	 */
	@Column(name = "CREATE_TIME")
	private Calendar createTime;
	
	/**
	 * 消费总额
	 */
	@Column(name = "CONSUMPTION_AMOUNT")
	private float consumptionAmount = 0;
	
	/**
	 * 总积分 
	 */
	@Column(name = "TOTAL_POINT")
	private int totalPoint = 0;
	
	/**
	 * 备注
	 */
	@Column(name = "REMARK", length = 50)
	private String remark;

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
	 * @return the salespeople
	 */
	public String getSalespeople() {
		return salespeople;
	}

	/**
	 * @param salespeople the salespeople to set
	 */
	public void setSalespeople(String salespeople) {
		this.salespeople = salespeople;
	}

	/**
	 * @return the createTime
	 */
	public Calendar getCreateTime() {
		return createTime;
	}

	/**
	 * @param createTime the createTime to set
	 */
	public void setCreateTime(Calendar createTime) {
		this.createTime = createTime;
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
	 * @return the totalPoint
	 */
	public int getTotalPoint() {
		return totalPoint;
	}

	/**
	 * @param totalPoint the totalPoint to set
	 */
	public void setTotalPoint(int totalPoint) {
		this.totalPoint = totalPoint;
	}

	/**
	 * @return the remark
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * @param remark the remark to set
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}

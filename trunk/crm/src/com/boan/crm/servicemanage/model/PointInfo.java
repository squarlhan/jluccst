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
	 * 销售记录ID
	 */
	@Column(name = "CONSUMPTION_ID")
	private String consumptionId;
	
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
	 * 消费金额
	 */
	@Column(name = "CONSUMPTION_MONEY")
	private float consumptionMoney = 0;
	
	/**
	 * 积分 
	 */
	@Column(name = "POINT")
	private int point = 0;
	
	/**
	 * 消费时间
	 */
	@Column(name = "CONSUMPTION_TIME")
	private Calendar consumptionTime;

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
	 * @return the consumptionMoney
	 */
	public float getConsumptionMoney() {
		return consumptionMoney;
	}

	/**
	 * @param consumptionMoney the consumptionMoney to set
	 */
	public void setConsumptionMoney(float consumptionMoney) {
		this.consumptionMoney = consumptionMoney;
	}

	/**
	 * @return the point
	 */
	public int getPoint() {
		return point;
	}

	/**
	 * @param point the point to set
	 */
	public void setPoint(int point) {
		this.point = point;
	}

	/**
	 * @return the consumptionTime
	 */
	public Calendar getConsumptionTime() {
		return consumptionTime;
	}

	/**
	 * @param consumptionTime the consumptionTime to set
	 */
	public void setConsumptionTime(Calendar consumptionTime) {
		this.consumptionTime = consumptionTime;
	}

	/**
	 * @return the consumptionId
	 */
	public String getConsumptionId() {
		return consumptionId;
	}

	/**
	 * @param consumptionId the consumptionId to set
	 */
	public void setConsumptionId(String consumptionId) {
		this.consumptionId = consumptionId;
	}

}

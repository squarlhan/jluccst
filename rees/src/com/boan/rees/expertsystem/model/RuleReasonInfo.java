/*
 * @(#)RuleReasonInfo.java 1.1 2012-4-21
 */

package com.boan.rees.expertsystem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * rule_reason_info实体model 类
 * @author jiangmeidi
 * @version 1.0.0
 */
@Entity
@Table(name = "RULE_REASON_INFO")
public class RuleReasonInfo {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "REASON_ID")
	/**
	 * 主键
	 */
	private int id;
	/**
	 * 原因描述
	 */
	@Column(name = "REASON")
	private String reason;
	/**
	 * 设备类型对应ID
	 */
	@Column(name = "DEVICE_TYPE_ID")
	private int deviceTypeId;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public int getDeviceTypeId() {
		return deviceTypeId;
	}
	public void setDeviceTypeId(int deviceTypeId) {
		this.deviceTypeId = deviceTypeId;
	}

	

}


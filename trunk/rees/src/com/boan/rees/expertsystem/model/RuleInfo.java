/*
 * @(#)RuleInfo.java 1.1 2012-4-21
 */

package com.boan.rees.expertsystem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Rule_Info实体model类
 * @author jiangmeidi
 * @version 1.0.0
 */
@Entity
@Table(name = "rule_info")

public class RuleInfo {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	
	/**
	 * 主键
	 */
	private int id;

	/**
	 * 设备特征对应ID
	 */
	@Column(name = "DEVICE_TYPE_ID")
	private int deviceTypeId;
	/**
	 * 现象ID,可以多个以分隔符“|”分隔
	 */
	@Column(name = "RESULT_ID")
	private int resultId;
	/**
	 * 原因ID
	 */
	@Column(name = "REASON_ID")
	private int reasonId;
	/**
	 * 对应建议ID
	 */
	@Column(name = "ADVICE_ID")
	private int adviceId;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getDeviceTypeId() {
		return deviceTypeId;
	}
	public void setDeviceTypeId(int deviceTypeId) {
		this.deviceTypeId = deviceTypeId;
	}
	public int getResultId() {
		return resultId;
	}
	public void setResultId(int resultId) {
		this.resultId = resultId;
	}
	public int getReasonId() {
		return reasonId;
	}
	public void setReasonId(int reasonId) {
		this.reasonId = reasonId;
	}
	public int getAdviceId() {
		return adviceId;
	}
	public void setAdviceId(int adviceId) {
		this.adviceId = adviceId;
	}
	

	

    
}


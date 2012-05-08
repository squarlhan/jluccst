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
	private String deviceTypeId;
	/**
	 * 现象ID,可以多个以分隔符“_”分隔
	 */
	@Column(name = "RESULT_ID")
	private String resultId;
	/**
	 * 原因ID
	 */
	@Column(name = "REASON_ID")
	private String reasonId;
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
	
	public String getDeviceTypeId() {
		return deviceTypeId;
	}
	public void setDeviceTypeId(String deviceTypeId) {
		this.deviceTypeId = deviceTypeId;
	}
	
	public String getResultId() {
		return resultId;
	}
	public void setResultId(String resultId) {
		this.resultId = resultId;
	}
	public String getReasonId() {
		return reasonId;
	}
	public void setReasonId(String reasonId) {
		this.reasonId = reasonId;
	}
	public int getAdviceId() {
		return adviceId;
	}
	public void setAdviceId(int adviceId) {
		this.adviceId = adviceId;
	}
	

	

    
}


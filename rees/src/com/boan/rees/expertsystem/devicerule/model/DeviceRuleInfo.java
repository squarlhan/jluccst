/*
 * @(#)DeviceRuleInfo.java 1.1 2012-5-2
 */

package com.boan.rees.expertsystem.devicerule.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 设备规则
 * @author ZhuYF
 * @version 1.0.0
 */
@Entity
@Table(name = "rule_device_info")
public class DeviceRuleInfo {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	/**
	 * 主键
	 */
	@Column(name = "DEVICE_ID")
	private int id;
	
	/**
	 * 参考参数（阈值类型Id）
	 */
	@Column(name = "DEVICE_PARAM")
	private String thresholdCategoryId;
	
	
	/**
	 * 设备类型对应ID
	 */
	@Column(name = "DEVICE_TYPE_ID")
	private int deviceTypeId;
	
	
	/**
	 * 阈值项Id
	 */
	@Column(name = "DEVICE_VAR")
	private String thresholdItemId;
	
	/**
	 * 现象对应ID
	 */
	@Column(name = "RESULT_ID")
	private int ruleResultInfoId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getThresholdCategoryId() {
		return thresholdCategoryId;
	}

	public void setThresholdCategoryId(String thresholdCategoryId) {
		this.thresholdCategoryId = thresholdCategoryId;
	}

	public int getDeviceTypeId() {
		return deviceTypeId;
	}

	public void setDeviceTypeId(int deviceTypeId) {
		this.deviceTypeId = deviceTypeId;
	}

	public String getThresholdItemId() {
		return thresholdItemId;
	}

	public void setThresholdItemId(String thresholdItemId) {
		this.thresholdItemId = thresholdItemId;
	}

	public int getRuleResultInfoId() {
		return ruleResultInfoId;
	}

	public void setRuleResultInfoId(int ruleResultInfoId) {
		this.ruleResultInfoId = ruleResultInfoId;
	}
}


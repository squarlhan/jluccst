/*
 * @(#)RuleRsultInfo.java 1.1 2012-4-21
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
 * rule_result_info实体model 类
 * @author jiangmeidi
 * @version 1.0.0
 */
@Entity
@Table(name = "RULE_RESULT_INFO")
public class RuleResultInfo {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	/**
	 * 主键
	 */
	@Column(name = "RESULT_ID")
	private int id;
    
	 /**
     * 设备类型对应ID 
     */
	@Column(name = "RESULT")
	private String result;
	/**
     * 现象描述
     */
	@Column(name = "DEVICE_TYPE_ID")
	private int deviceTypeId;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public int getDeviceTypeId() {
		return deviceTypeId;
	}
	public void setDeviceTypeId(int deviceTypeId) {
		this.deviceTypeId = deviceTypeId;
	}
	
	
	
	

}


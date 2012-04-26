/*
 * @(#)RuleAdeviceInfo.java 1.1 2012-4-21
 */

package com.boan.rees.expertsystem.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * rule_advice实体model类
 * @author jiangmeidi
 * @version 1.0.0
 */
@Entity
@Table(name = "rule_advice_info")
public class RuleAdviceInfo  implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ADVICE_ID")
	/**
	 * 主键
	 */
	private int id;
	/**
	 * 建议描述
	 */
	@Column(name = "ADVICE")
	private String advice;
	/**
	 * 设备类型对应ID，
	 */
	@Column(name = "DEVICE_TYPE_ID")
	private String deviceTypeId;
	
	
	
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAdvice() {
		return advice;
	}
	public void setAdvice(String advice) {
		this.advice = advice;
	}
	public String getDeviceTypeId() {
		return deviceTypeId;
	}
	public void setDeviceTypeId(String deviceTypeId) {
		this.deviceTypeId = deviceTypeId;
	}
	

}


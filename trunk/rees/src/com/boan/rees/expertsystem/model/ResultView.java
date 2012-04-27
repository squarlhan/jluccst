/*
 * @(#)RuleRsultInfo.java 1.1 2012-4-21
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
 * rule_result_info实体model 类
 * @author jiangmeidi
 * @version 1.0.0
 */
@Entity
@Table(name = "result_view")
public class ResultView implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	/**
	 * 主键
	 */
	@Column(name = "RESULT_ID")
	private int id;
	/**
     * 现象描述
     */
	@Column(name = "RESULT")
	private String result;
	
	/**
	 * 设备类型对应ID
	 */
	@Column(name = "DEVICE_TYPE_ID")
	private String deviceTypeId;
	/**
	 * 设备类型
	 */
	@Column(name = "DEVICE_TYPE")
	private String typeName;
	
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
	public String getDeviceTypeId() {
		return deviceTypeId;
	}
	public void setDeviceTypeId(String deviceTypeId) {
		this.deviceTypeId = deviceTypeId;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	
	
	
	
	

}


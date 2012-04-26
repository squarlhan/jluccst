/*
 * @(#)RuleDeviceInfo.java 1.1 2012-4-21
 */

package com.boan.rees.expertsystem.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.boan.rees.device.type.model.DeviceType;

/**
 * rule_device_info实体model 类
 * @author jiangmeidi
 * @version 1.0.0
 */
@Entity
@Table(name = "rule_device_info")
public class RuleDeviceInfo {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	/**
	 * 主键
	 */
	@Column(name = "DEVICE_ID")
	private int id;
	/**
	 * 参考参数
	 */
	@Column(name = "DEVICE_PARAM")
	private String deviceParam;
	
	
	/**
	 * 设备类型对应ID
	 */
	@Column(name = "DEVICE_TYPE_ID")
	private int deviceTypeId;
	
	
	/**
	 * 阈值参数
	 */
	@Column(name = "DEVICE_VAR")
	private String deviceVar;
	
	/**
	 * 现象对应ID
	 */
	@Column(name = "RESULT_ID")
	private int resuleId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDeviceParam() {
		return deviceParam;
	}

	public void setDeviceParam(String deviceParam) {
		this.deviceParam = deviceParam;
	}

	public int getDeviceTypeId() {
		return deviceTypeId;
	}

	public void setDeviceTypeId(int deviceTypeId) {
		this.deviceTypeId = deviceTypeId;
	}

	public String getDeviceVar() {
		return deviceVar;
	}

	public void setDeviceVar(String deviceVar) {
		this.deviceVar = deviceVar;
	}

	public int getResuleId() {
		return resuleId;
	}

	public void setResuleId(int resuleId) {
		this.resuleId = resuleId;
	}
	
	

}


/**
 * Copyright (c) 2012 Changchun CBIT Co. Ltd.
 * All right reserved.
 * History
 */
/*
 * @(#)Point.java 1.1 2012-3-6
 */

package com.boan.rees.device.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * 监测点实体类
 * @author jiangmeidi
 * @version 1.0.0
 */
@Entity
@Table(name = "POINT_INFO")
public class PointInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GenericGenerator(name="system-uuid", strategy="uuid")
	@GeneratedValue(generator="system-uuid")
	
	/**
	 * 监测点实体主键
	 */
	private String id;
	@Column(name = "DEVICE_ID")
	private Integer deviceId;
	@Column(name = "CONTROL_POINT_NAME")
	private Integer controlPointName;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Integer getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(Integer deviceId) {
		this.deviceId = deviceId;
	}
	public Integer getControlPointName() {
		return controlPointName;
	}
	public void setControlPointName(Integer controlPointName) {
		this.controlPointName = controlPointName;
	}
	
}


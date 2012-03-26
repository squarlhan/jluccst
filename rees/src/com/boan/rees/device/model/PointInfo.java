/**
 * Copyright (c) 2012 Boan Co. Ltd.
 * All right reserved.
 * History
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
 * 
 * @author leon
 * @version 1.0.0
 */
@Entity
@Table(name = "DEVICE_POINT_INFO")
public class PointInfo implements Serializable {
	private static final long serialVersionUID = -2302949373438233876L;

	@Id
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@GeneratedValue(generator = "system-uuid")
	/**
	 * 监测点实体主键
	 */
	private String id;

	/**
	 * 设备编号，外键
	 */
	@Column(name = "DEVICE_ID")
	private String deviceId;

	/**
	 * 监测点名称
	 */
	@Column(name = "CONTROL_POINT_NAME")
	private String controlPointName;

	/**
	 * X轴坐标
	 */
	@Column(name = "POSITIONX")
	private int positionX;

	/**
	 * Y轴坐标
	 */
	@Column(name = "POSITIONY")
	private int positionY;

	public int getPositionX() {
		return positionX;
	}

	public void setPositionX(int positionX) {
		this.positionX = positionX;
	}

	public int getPositionY() {
		return positionY;
	}

	public void setPositionY(int positionY) {
		this.positionY = positionY;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public String getControlPointName() {
		return controlPointName;
	}

	public void setControlPointName(String controlPointName) {
		this.controlPointName = controlPointName;
	}

}

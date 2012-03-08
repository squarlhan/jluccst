/**
 * Copyright (c) 2012 Changchun CBIT Co. Ltd.
 * All right reserved.
 * History
 */
/*
 * @(#)Device.java 1.1 2012-3-6
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
 * 设备实体类
 * @author jiangmeidi
 * @version 1.0.0
 */
@Entity
@Table(name = "DEVICE_INFO")
public class DeviceInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GenericGenerator(name="system-uuid", strategy="uuid")
	@GeneratedValue(generator="system-uuid")
	
	/**
	 * 设备实体主键
	 */
	private String id;
	
	/**
	 * 设备编号
	 */
	@Column(name = "DEVICE _NUM")
	private String deviceNum;
	
	/**
	 * 设备类型
	 */
	@Column(name = "DEVICE_TYPE")
	private String deviceType;
	@Column(name = "DEVICE_NAME ")
	private String deviceName;
	@Column(name = "DEVICE_MODEL")
	private String deviceModel;

	@Column(name = "DEVICE_FACTORY")
	private String deviceFactory;
	@Column(name = "FILE_PATH")
	private String filePath;
	@Column(name = "CONTROL_POINT")
	private String contrlPoint;
	@Column(name = "SORT_INDEX")
	private String sortIndex;
	@Column(name = "CREATE_TIME")
	private String createTime;
	@Column(name = "ISDELETE")
	private String isDelete;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDeviceNum() {
		return deviceNum;
	}
	public void setDeviceNum(String deviceNum) {
		this.deviceNum = deviceNum;
	}
	public String getDeviceType() {
		return deviceType;
	}
	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}
	public String getDeviceName() {
		return deviceName;
	}
	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}
	public String getDeviceModel() {
		return deviceModel;
	}
	public void setDeviceModel(String deviceModel) {
		this.deviceModel = deviceModel;
	}
	public String getDeviceFactory() {
		return deviceFactory;
	}
	public void setDeviceFactory(String deviceFactory) {
		this.deviceFactory = deviceFactory;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public String getContrlPoint() {
		return contrlPoint;
	}
	public void setContrlPoint(String contrlPoint) {
		this.contrlPoint = contrlPoint;
	}
	public String getSortIndex() {
		return sortIndex;
	}
	public void setSortIndex(String sortIndex) {
		this.sortIndex = sortIndex;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(String isDelete) {
		this.isDelete = isDelete;
	}
	
}


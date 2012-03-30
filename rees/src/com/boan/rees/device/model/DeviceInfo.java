/**
 * Copyright (c) 2012 Boan Co. Ltd.
 * All right reserved.
 * History
 */
/*
 * @(#)PointDataInfo.java 1.1 2012-3-6
 */

package com.boan.rees.device.model;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * 监测点数据实体类
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
	 * 主键
	 */
	private String id;
	/**
	 * 设备编号
	 */
	@Column(name = "DEVICE_NUM")
	private String deviceNum;
	/**
	 * 设备类型
	 */
	@Column(name = "DEVICE_TYPE")
	private String deviceType;
	/**
	 * 设备名称
	 */
	@Column(name = "DEVICE_NAME")
	private String deviceName;
	/**
	 * 设备型号
	 */
	@Column(name = "DEVICE_MODEL")
	private String deviceModel;
	/**
	 *设备厂商
	 */
	@Column(name = "DEVICE_FACTORY")
	private String deviceFactory;
	/**
	 * 设备图片
	 */
	@Column(name = "FILE_PATH")
	private String filePath;
	/**
	 *监控点数量
	 */
	@Column(name = "CONTROL_POINT")
	private Integer controlPoint;
	
	/**
	 * 排序号
	 */
	@Column(name = "SORT_INDEX")
	private Integer sortIndex;
	/**
	 * 创建时间
	 */
	@Column(name = "CREATE_TIME")
	private Calendar creatTime;
	/**
	 * 删除标识0：正常 1：已删除
	 */
	@Column(name = "ISDELETE")
	private Integer isDelete;
	/**
	 * 所属部门Id
	 */
	@Column(name = "DEPT_ID")
	private String deptId;
	/**
	 *所属机组Id
	 */
	@Column(name = "GROUP_ID")
	private String groupId;
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

	public Integer getControlPoint() {
		return controlPoint;
	}
	public void setControlPoint(Integer controlPoint) {
		this.controlPoint = controlPoint;
	}
	public Integer getSortIndex() {
		return sortIndex;
	}
	public void setSortIndex(Integer sortIndex) {
		this.sortIndex = sortIndex;
	}
	public Calendar getCreatTime() {
		return creatTime;
	}
	public void setCreatTime(Calendar creatTime) {
		this.creatTime = creatTime;
	}
	public Integer getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}
	public String getDeptId() {
		return deptId;
	}
	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}
	public String getGroupId() {
		return groupId;
	}
	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}
	
	
	
	
	
	
	
	
	
}


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
import java.math.BigDecimal;
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
	 * 设备类型ID
	 */
	@Column(name = "DEVICE_TYPE_ID")
	private String deviceTypeId;
	
	/**
	 * 设备类型
	 */
	@Column(name = "DEVICE_TYPE_NAME")
	private String deviceTypeName;
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
	private Calendar createTime;
	/**
	 * 删除标识0：正常 1：已删除
	 */
	@Column(name = "ISDELETE")
	private Integer isDelete;
	/**
	 * 所属公司Id
	 */
	@Column(name = "COMPANY_ID")
	private String companyId;
	/**
	 * 所属工厂Id
	 */
	@Column(name = "FACTORY_ID")
	private String factoryId;
	/**
	 *所属车间Id
	 */
	@Column(name = "WORKSHOP_ID")
	private String workshopId;
	
	/**
	 * 中心高
	 */
	@Column(name = "CENTER_HEIGHT")
	private BigDecimal centerHeight;
	
	/**
	 * 转速
	 */
	@Column(name = "SPEED")
	private BigDecimal speed;
	
	/**
	 * 功率
	 */
	@Column(name = "POWER")
	private BigDecimal power;
	
//	/**
//	 * 监测点正常值 
//	 */
//	@Column(name = "POINT_NATURAL_VALUE")
//	private BigDecimal pointNaturalValue;
//	
//	/**
//	 * 监测点警告值
//	 */
//	@Column(name = "POINT_WARN_VALUE")
//	private BigDecimal pointWarnValue;
	
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
	
	public String getDeviceTypeName() {
		return deviceTypeName;
	}
	public void setDeviceTypeName(String deviceTypeName) {
		this.deviceTypeName = deviceTypeName;
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
	
	public Calendar getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Calendar createTime) {
		this.createTime = createTime;
	}
	public Integer getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

	public String getFactoryId() {
		return factoryId;
	}
	public void setFactoryId(String factoryId) {
		this.factoryId = factoryId;
	}
	public String getWorkshopId() {
		return workshopId;
	}
	public void setWorkshopId(String workshopId) {
		this.workshopId = workshopId;
	}
	public BigDecimal getCenterHeight() {
		return centerHeight;
	}
	public void setCenterHeight(BigDecimal centerHeight) {
		this.centerHeight = centerHeight;
	}
	public BigDecimal getSpeed() {
		return speed;
	}
	public void setSpeed(BigDecimal speed) {
		this.speed = speed;
	}
	public BigDecimal getPower() {
		return power;
	}
	public void setPower(BigDecimal power) {
		this.power = power;
	}
	public String getDeviceTypeId() {
		return deviceTypeId;
	}
	public void setDeviceTypeId(String deviceTypeId) {
		this.deviceTypeId = deviceTypeId;
	}
//	public BigDecimal getPointNaturalValue() {
//		return pointNaturalValue;
//	}
//	public void setPointNaturalValue(BigDecimal pointNaturalValue) {
//		this.pointNaturalValue = pointNaturalValue;
//	}
//	public BigDecimal getPointWarnValue() {
//		return pointWarnValue;
//	}
//	public void setPointWarnValue(BigDecimal pointWarnValue) {
//		this.pointWarnValue = pointWarnValue;
//	}
	public String getCompanyId()
	{
		return companyId;
	}
	public void setCompanyId( String companyId )
	{
		this.companyId = companyId;
	}
}


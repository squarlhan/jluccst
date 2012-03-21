/**
 * Copyright (c) 2012 Changchun CBIT Co. Ltd.
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
@Table(name = "DEVICE_POINT_PARAM")
public class PointDataInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GenericGenerator(name="system-uuid", strategy="uuid")
	@GeneratedValue(generator="system-uuid")
	/**
	 * 参数数据编号
	 */
	private String id;
	/**
	 * 所属监控点参数
	 */
	@Column(name = "POINT_ID")
	private String pointId;
	/**
	 * 参数ID
	 */
	@Column(name = "PAID")
	private String paid;
	/**
	 * 参数数据信息
	 */
	@Column(name = "DATA_INFO")
	private String dataInfo;
	/**
	 * 所属周期
	 */
	@Column(name = "WEEK_OF_YEAR")
	private Integer weekofYear;
	/**
	 * 录入人ID
	 */
	@Column(name = "USER_NAME")
	private String userName;
	/**
	 * 录入日期
	 */
	@Column(name = "CREATE_TIME")
	private Calendar creatTime;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getPointId() {
		return pointId;
	}
	public void setPointId(String pointId) {
		this.pointId = pointId;
	}
	public String getPaid() {
		return paid;
	}
	public void setPaid(String paid) {
		this.paid = paid;
	}
	
	public String getDataInfo() {
		return dataInfo;
	}
	public void setDataInfo(String dataInfo) {
		this.dataInfo = dataInfo;
	}
	public Integer getWeekofYear() {
		return weekofYear;
	}
	public void setWeekofYear(Integer weekofYear) {
		this.weekofYear = weekofYear;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Calendar getCreatTime() {
		return creatTime;
	}
	public void setCreatTime(Calendar creatTime) {
		this.creatTime = creatTime;
	}
	
}


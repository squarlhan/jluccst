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
@Table(name = "DATA_INFO")
public class PointDataInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GenericGenerator(name="system-uuid", strategy="uuid")
	@GeneratedValue(generator="system-uuid")
	/**
	 * 监测点数据实体主键
	 */
	private String id;
	
	@Column(name = "PAID")
	private Integer paid;
	@Column(name = "DATA_INFO")
	private Integer dataInfo;
	@Column(name = "WEEK_OF_YEAR")
	private Integer weekofYear;
	@Column(name = "USER_NAME")
	private Integer userName;
	@Column(name = "CREATE_TIME")
	private Integer creatTime;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Integer getPaid() {
		return paid;
	}
	public void setPaid(Integer paid) {
		this.paid = paid;
	}
	public Integer getDataInfo() {
		return dataInfo;
	}
	public void setDataInfo(Integer dataInfo) {
		this.dataInfo = dataInfo;
	}
	public Integer getWeekofYear() {
		return weekofYear;
	}
	public void setWeekofYear(Integer weekofYear) {
		this.weekofYear = weekofYear;
	}
	public Integer getUserName() {
		return userName;
	}
	public void setUserName(Integer userName) {
		this.userName = userName;
	}
	public Integer getCreatTime() {
		return creatTime;
	}
	public void setCreatTime(Integer creatTime) {
		this.creatTime = creatTime;
	}
	
}


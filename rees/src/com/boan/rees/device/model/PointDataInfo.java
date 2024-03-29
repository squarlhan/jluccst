/**
 * Copyright (c) 2012 Boan Co. Ltd.
 * All right reserved.
 * History
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

import com.boan.rees.utils.calendar.CalendarUtils;

/**
 * 监测点数据实体类
 * 
 * @author leon
 * @version 1.0.0
 */
@Entity
@Table(name = "DEVICE_POINT_DATA")
public class PointDataInfo implements Serializable {
	private static final long serialVersionUID = -1773368955047333494L;

	@Id
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@GeneratedValue(generator = "system-uuid")
	/**
	 * 参数数据编号
	 */
	private String id;

	/**
	 * 设备编号，外键
	 */
	@Column(name = "DEVICE_ID")
	private String deviceId;

	/**
	 * 所属年度
	 */
	@Column(name = "DATA_YEAR")
	private Integer dataYear;
	/**
	 * 所属周期
	 */
	@Column(name = "WEEK_OF_YEAR")
	private Integer weekofYear;

	/**
	 * 录入人ID
	 */
	@Column(name = "USER_ID")
	private String userId;

	/**
	 * 录入人姓名
	 */
	@Column(name = "USER_NAME")
	private String userName;

	/**
	 * 录入时间
	 */
	@Column(name = "CREATE_TIME")
	private Calendar creatTime;

	/**
	 * 修改时间
	 */
	@Column(name = "UPDATE_TIME")
	private Calendar updateTime;

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

	public Integer getDataYear() {
		return dataYear;
	}

	public void setDataYear(Integer dataYear) {
		this.dataYear = dataYear;
	}

	public Integer getWeekofYear() {
		return weekofYear;
	}

	public void setWeekofYear(Integer weekofYear) {
		this.weekofYear = weekofYear;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
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

	public Calendar getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Calendar updateTime) {
		this.updateTime = updateTime;
	}
	
	public String getCreatTimeString(){
		return CalendarUtils.toLongString(creatTime);
	}
}

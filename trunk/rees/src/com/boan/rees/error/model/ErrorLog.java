/*
 * @(#)Error.java 1.1 2012-4-24
 */

package com.boan.rees.error.model;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * 故障日志 实体类
 * @author zhaomengxue
 * @version 1.0.0
 */
@Entity
@Table(name="error_log")
public class ErrorLog implements Serializable{
	
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
	@Column(name="DEVICE_NUM")
	private String deviceNum;
	
	/**
	 * 设备名称
	 */
	@Column(name="DEVICE_NAME")
	private String deviceName;
	
	/**
	 * 所属部门名称
	 */
	@Column(name="DEPT_NAME")
	private String deptName;
	
	/**
	 * 故障时间
	 */
	@Column(name="ERROR_TIME")
	private Calendar errorTime;
	
	/**
	 * 故障解除时间
	 */
	@Column(name="REMOVE_TIME")
	private Calendar removeTime;
	
	/**
	 * 故障数据
	 */
	@Column(name="ERROR_DATA")
	private Float errorData;
	
	/**
	 * 故障阈值
	 */
	@Column(name="ERROR_THRESH")
	private Float errorThresh;
	
	/**
	 * 故障现象
	 */
	@Column(name="ERROR_PHEN")
	private String errorPhen;
	
	/**
	 * 故障原因
	 */
	@Column(name="ERROR_REASON")
	private String errorReason;
	
	/**
	 * 专家意见
	 */
	@Column(name="OPINION")
	private String opinion;
	
	 /**
	  * 解除标识 0：未解除1：已解除
	  */
	@Column(name="ISREMOVE")
	private Integer isRemove;

	public Integer getIsRemove() {
		return isRemove;
	}

	public void setIsRemove(Integer isRemove) {
		this.isRemove = isRemove;
	}

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

	public String getDeviceName() {
		return deviceName;
	}

	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public Calendar getErrorTime() {
		return errorTime;
	}

	public void setErrorTime(Calendar errorTime) {
		this.errorTime = errorTime;
	}

	public Calendar getRemoveTime() {
		return removeTime;
	}

	public void setRemoveTime(Calendar removeTime) {
		this.removeTime = removeTime;
	}

	public Float getErrorData() {
		return errorData;
	}

	public void setErrorData(Float errorData) {
		this.errorData = errorData;
	}

	public Float getErrorThresh() {
		return errorThresh;
	}

	public void setErrorThresh(Float errorThresh) {
		this.errorThresh = errorThresh;
	}

	public String getErrorPhen() {
		return errorPhen;
	}

	public void setErrorPhen(String errorPhen) {
		this.errorPhen = errorPhen;
	}

	public String getErrorReason() {
		return errorReason;
	}

	public void setErrorReason(String errorReason) {
		this.errorReason = errorReason;
	}

	public String getOpinion() {
		return opinion;
	}

	public void setOpinion(String opinion) {
		this.opinion = opinion;
	}
	
}


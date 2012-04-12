/*
 * @(#)DeviceType.java 1.1 2012-3-31
 */

package com.boan.rees.device.type.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * 设备分类实体
 * 
 * @author jiangmeidi
 * @version 1.0.0
 */
@Entity
@Table(name = "DEVICE_TYPE")
public class DeviceType implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	@Id
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@GeneratedValue(generator = "system-uuid")
	private String id;

	/**
	 * 设备类别名称
	 */
	@Column(name = "DEVICE_TYPE")
	private String typeName;
	
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
	 * 监测点正常值 
	 */
	@Column(name = "POINT_NATURAL_VALUE")
	private BigDecimal pointNaturalValue;
	/**
	 * 监测点警告值
	 */
	@Column(name = "POINT_WARN_VALUE")
	private BigDecimal pointWarnValue;
	
	/**
	 * 功率
	 */
	@Column(name = "POWER")
	private BigDecimal power;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
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

	public BigDecimal getPointNaturalValue() {
		return pointNaturalValue;
	}

	public void setPointNaturalValue(BigDecimal pointNaturalValue) {
		this.pointNaturalValue = pointNaturalValue;
	}

	public BigDecimal getPointWarnValue() {
		return pointWarnValue;
	}

	public void setPointWarnValue(BigDecimal pointWarnValue) {
		this.pointWarnValue = pointWarnValue;
	}
}

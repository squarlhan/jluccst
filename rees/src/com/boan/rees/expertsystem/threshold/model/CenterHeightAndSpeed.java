/*
 * @(#)CenterHeightAndSpeed.java 1.1 2012-5-1
 */

package com.boan.rees.expertsystem.threshold.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 中心高转速对象
 * @author ZhuYF
 * @version 1.0.0
 */
@Entity
@Table(name="CenterHeight_And_Speed")
public class CenterHeightAndSpeed implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * Id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Id")
	private Integer id;
	
	/**
	 * 中心高区间
	 */
	@Column(name = "Center_Height_Expression")
	private String centerHeightExpression;
	
	/**
	 * 转速取值区间
	 */
	@Column(name = "Speed_Expression")
	private String speedExpression;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCenterHeightExpression() {
		return centerHeightExpression;
	}

	public void setCenterHeightExpression(String centerHeightExpression) {
		this.centerHeightExpression = centerHeightExpression;
	}

	public String getSpeedExpression() {
		return speedExpression;
	}

	public void setSpeedExpression(String speedExpression) {
		this.speedExpression = speedExpression;
	}
}


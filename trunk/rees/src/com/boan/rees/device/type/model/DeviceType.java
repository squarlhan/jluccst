/*
 * @(#)DeviceType.java 1.1 2012-3-31
 */

package com.boan.rees.device.type.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * 设备分类实体
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
	@GenericGenerator(name="system-uuid", strategy="uuid")
	@GeneratedValue(generator="system-uuid")
	private String id;
	
	/**
	 * 设备名称
	 */
	@Column(name = "DEVICE_TYPE")
	private String typeName;
	/**
	 * 中心高
	 */
     @Column(name="CENTER_HEIGHT")
     private int centerHeight;
     /**
 	 * 转速
 	 */
      @Column(name="SPEED")
      private int speed;
      /**
  	 * 功率
  	 */
       @Column(name="POWER")
       private int power;
       
       
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
	public int getCenterHeight() {
		return centerHeight;
	}
	public void setCenterHeight(int centerHeight) {
		this.centerHeight = centerHeight;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public int getPower() {
		return power;
	}
	public void setPower(int power) {
		this.power = power;
	}
	
       
       
       
     
}


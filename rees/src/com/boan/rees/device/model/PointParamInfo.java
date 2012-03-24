package com.boan.rees.device.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * 监测点实体类
 * 
 * @author leon
 * @version 1.0.0
 */
@Entity
@Table(name = "DEVICE_POINT_PARAM")
public class PointParamInfo implements Serializable {
	private static final long serialVersionUID = -2114894885947174533L;

	@Id
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@GeneratedValue(generator = "system-uuid")
	/**
	 * 监测点参数实体主键
	 */
	private String id;

	/**
	 * 设备编号，外键
	 */
	@Column(name = "DEVICE_ID")
	private String deviceId;
	
	/**
	 * 监测点编号，外键
	 */
	@Column(name = "POINT_ID")
	private String pointId;

	/**
	 * 参数名称
	 */
	@Column(name = "NAME")
	private String name;

	/**
	 * 排序号
	 */
	@Column(name = "SORT_INDEX")
	private int sortIndex = 0;

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

	public String getPointId() {
		return pointId;
	}

	public void setPointId(String pointId) {
		this.pointId = pointId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSortIndex() {
		return sortIndex;
	}

	public void setSortIndex(int sortIndex) {
		this.sortIndex = sortIndex;
	}
}

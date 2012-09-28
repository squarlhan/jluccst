/**
 * Copyright (c) 2012 Boan Co. Ltd.
 * All right reserved.
 * History
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
 * 
 * @author leon
 * @version 1.0.0
 */
@Entity
@Table(name = "DEVICE_POINT_DATA_VALUE")
public class PointDataValueInfo implements Serializable {
	private static final long serialVersionUID = -8294524832662380430L;

	@Id
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@GeneratedValue(generator = "system-uuid")
	/**
	 * 参数数据编号
	 */
	private String id;
	
	/**
	 * 监测点编号，外键
	 */
	@Column(name = "POINT_ID")
	private String pointId;

	/**
	 * 监测点编号，外键
	 */
	@Column(name = "PARAM_ID")
	private String paramId;

	/**
	 * 监测点数据编号，外键
	 */
	@Column(name = "POINT_DATA_ID")
	private String pointDataId;

	/**
	 * 参数数据信息
	 */
	@Column(name = "DATA_INFO")
	private String dataInfo;

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the pointId
	 */
	public String getPointId() {
		return pointId;
	}

	/**
	 * @param pointId the pointId to set
	 */
	public void setPointId(String pointId) {
		this.pointId = pointId;
	}

	/**
	 * @return the paramId
	 */
	public String getParamId() {
		return paramId;
	}

	/**
	 * @param paramId the paramId to set
	 */
	public void setParamId(String paramId) {
		this.paramId = paramId;
	}

	/**
	 * @return the pointDataId
	 */
	public String getPointDataId() {
		return pointDataId;
	}

	/**
	 * @param pointDataId the pointDataId to set
	 */
	public void setPointDataId(String pointDataId) {
		this.pointDataId = pointDataId;
	}

	/**
	 * @return the dataInfo
	 */
	public String getDataInfo() {
		return dataInfo;
	}

	/**
	 * @param dataInfo the dataInfo to set
	 */
	public void setDataInfo(String dataInfo) {
		this.dataInfo = dataInfo;
	}

}

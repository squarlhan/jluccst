/**
 * Copyright (c) 2013 Changchun CBIT Co. Ltd.
 * All right reserved.
 * History
 */
/*
 * @(#)TimePlanAndTrackOrVisitRelation.java 1.1 2013-6-20
 */

package com.boan.crm.timemanage.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * 时间管理月跟踪计划或回访记录关系对象
 * @author XXX
 * @version 1.0.0
 */
@Entity
@Table(name = "TIME_PLANAND_TRACK_OR_VISITRELATION")
public class TimePlanAndTrackOrVisitRelation implements Serializable{
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
	 * @return the time_Planand
	 */
	public String getTime_Planand() {
		return time_Planand;
	}

	/**
	 * @param time_Planand the time_Planand to set
	 */
	public void setTime_Planand(String time_Planand) {
		this.time_Planand = time_Planand;
	}

	/**
	 * @return the trackOrVisitrelationId
	 */
	public String getTrackOrVisitrelationId() {
		return trackOrVisitrelationId;
	}

	/**
	 * @param trackOrVisitrelationId the trackOrVisitrelationId to set
	 */
	public void setTrackOrVisitrelationId(String trackOrVisitrelationId) {
		this.trackOrVisitrelationId = trackOrVisitrelationId;
	}

	@Id
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@GeneratedValue(generator = "system-uuid")
	private String id;
	
	@Column(name = "Time_Plan_Id" , length = 50)
	private String time_Planand;
	
	@Column(name = "TRACK_OR_VISITRELATION_ID" , length = 50)
	private String trackOrVisitrelationId;
}


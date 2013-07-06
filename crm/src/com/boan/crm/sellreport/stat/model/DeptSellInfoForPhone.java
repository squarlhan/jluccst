/**
 * Copyright (c) 2013 Changchun CBIT Co. Ltd.
 * All right reserved.
 * History
 */
/*
 * @(#)SellerMForPhone.java 1.1 2013-7-5
 */

package com.boan.crm.sellreport.stat.model;

/**
 * 部门销售金额信息用于手机端
 * @author XXX
 * @version 1.0.0
 */
public class DeptSellInfoForPhone {
	/**
	 * 部门Id
	 */
	private String id;
	/**
	 * 部门名称
	 */
	private String name;
	/**
	 * 部门计划销售值
	 */
	private String plane;
	/**
	 * 部门已完成销售值
	 */
	private String finished;
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
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the plane
	 */
	public String getPlane() {
		return plane;
	}
	/**
	 * @param plane the plane to set
	 */
	public void setPlane(String plane) {
		this.plane = plane;
	}
	/**
	 * @return the finished
	 */
	public String getFinished() {
		return finished;
	}
	/**
	 * @param finished the finished to set
	 */
	public void setFinished(String finished) {
		this.finished = finished;
	}
}


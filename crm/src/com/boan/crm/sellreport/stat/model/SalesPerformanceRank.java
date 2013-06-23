/**
 * Copyright (c) 2013 Changchun CBIT Co. Ltd.
 * All right reserved.
 * History
 */
/*
 * @(#)SalesPerformanceRank.java 1.1 2013-6-22
 */

package com.boan.crm.sellreport.stat.model;

import java.math.BigDecimal;

/**
 * XXX 类
 * @author XXX
 * @version 1.0.0
 */
public class SalesPerformanceRank {

	/**
	 * 序号
	 */
	private int sequenceNumber;

	/**
	 * 业务员id
	 */
	private String salesmanId;
	
	/**
	 * 业务员名称
	 */
	private String salesmanName;
	
	/**
	 * 业务员部门id
	 */
	private String deptId;
	
	/**
	 * 业务员部门名称
	 */
	private String deptName;
	
	/**
	 * 销售额
	 */
	private BigDecimal salesAmount;

	/**
	 * @return the sequenceNumber
	 */
	public int getSequenceNumber() {
		return sequenceNumber;
	}

	/**
	 * @param sequenceNumber the sequenceNumber to set
	 */
	public void setSequenceNumber(int sequenceNumber) {
		this.sequenceNumber = sequenceNumber;
	}

	/**
	 * @return the salesmanId
	 */
	public String getSalesmanId() {
		return salesmanId;
	}

	/**
	 * @param salesmanId the salesmanId to set
	 */
	public void setSalesmanId(String salesmanId) {
		this.salesmanId = salesmanId;
	}

	/**
	 * @return the salesmanName
	 */
	public String getSalesmanName() {
		return salesmanName;
	}

	/**
	 * @param salesmanName the salesmanName to set
	 */
	public void setSalesmanName(String salesmanName) {
		this.salesmanName = salesmanName;
	}

	/**
	 * @return the deptId
	 */
	public String getDeptId() {
		return deptId;
	}

	/**
	 * @param deptId the deptId to set
	 */
	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	/**
	 * @return the deptName
	 */
	public String getDeptName() {
		return deptName;
	}

	/**
	 * @param deptName the deptName to set
	 */
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	/**
	 * @return the salesAmount
	 */
	public BigDecimal getSalesAmount() {
		return salesAmount;
	}

	/**
	 * @param salesAmount the salesAmount to set
	 */
	public void setSalesAmount(BigDecimal salesAmount) {
		this.salesAmount = salesAmount;
	}
}


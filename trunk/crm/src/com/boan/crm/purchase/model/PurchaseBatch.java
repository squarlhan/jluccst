package com.boan.crm.purchase.model;

import java.util.Date;

/**
 * 购买批次
 * 
 * @author Administrator
 * 
 */
public class PurchaseBatch implements java.io.Serializable {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 5298238142121781175L;

	/**
	 * 批次名称
	 */
	private String batchName;
	/**
	 * 公司id
	 */
	private String companyId;
	/**
	 * 供应商ID
	 */
	private String supplierId;
	/**
	 * 供应商名称
	 */
	private String supplierName;
	/**
	 * 供应商编号
	 */
	private String supplierNumber;
	/**
	 * 成交日期
	 */
	private String transactionDate;
	/**
	 * 是否到货，1表示到货，0表示未到
	 */
	private int isArrive;

	/**
	 * 是否结账
	 */
	private int isSettleAccount;
	/**
	 * 用户id
	 */
	private String userId;

	/**
	 * 用户姓名
	 */
	private String userName;

	/**
	 * 创建时间
	 */
	private Date createTime;

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public String getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(String supplierId) {
		this.supplierId = supplierId;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public String getSupplierNumber() {
		return supplierNumber;
	}

	public void setSupplierNumber(String supplierNumber) {
		this.supplierNumber = supplierNumber;
	}

	public String getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
	}

	public int getIsArrive() {
		return isArrive;
	}

	public void setIsArrive(int isArrive) {
		this.isArrive = isArrive;
	}

	public int getIsSettleAccount() {
		return isSettleAccount;
	}

	public void setIsSettleAccount(int isSettleAccount) {
		this.isSettleAccount = isSettleAccount;
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

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getBatchName() {
		return batchName;
	}

	public void setBatchName(String batchName) {
		this.batchName = batchName;
	}

}

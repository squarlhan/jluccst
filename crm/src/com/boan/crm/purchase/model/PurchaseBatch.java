package com.boan.crm.purchase.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * 购买批次
 * 
 * @author Administrator
 * 
 */
@Entity
@Table(name = "PURCHASE_BATCH")
public class PurchaseBatch implements java.io.Serializable {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 5298238142121781175L;

	/**
	 * 主键
	 */
	@Id
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@GeneratedValue(generator = "system-uuid")
	private String id;
	/**
	 * 批次名称
	 */
	@Column(name = "BATCH_NAME", length=50)
	private String batchName;
	/**
	 * 公司id
	 */
	@Column(name = "COMPANY_ID", length=50)
	private String companyId;
	/**
	 * 公司名称
	 */
	@Column(name = "COMPANY_NAME", length=50)
	private String companyName;
	/**
	 * 供应商ID
	 */
	@Column(name = "SUPPLIER_ID", length=50)
	private String supplierId;
	/**
	 * 供应商名称
	 */
	@Column(name = "SUPPLIER_NAME", length=50)
	private String supplierName;
	/**
	 * 供应商编号
	 */
	@Column(name = "SUPPLIER_NUMBER", length=50)
	private String supplierNumber;
	/**
	 * 成交日期
	 */
	@Column(name = "TRANSACTION_DATE", length=50)
	private String transactionDate;
	/**
	 * 是否到货，1表示到货，0表示未到
	 */
	@Column(name = "IS_ARRIVE")
	private int isArrive;

	/**
	 * 是否结账
	 */
	@Column(name = "IS_SETTLE_ACCOUNT")
	private int isSettleAccount;
	/**
	 * 用户id
	 */
	@Column(name = "USER_ID", length=50)
	private String userId;

	/**
	 * 用户姓名
	 */
	@Column(name = "USER_NAME", length=50)
	private String userName;

	/**
	 * 创建时间
	 */
	@Column(name = "CREATE_TIME")
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

}

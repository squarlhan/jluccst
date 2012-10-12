package com.boan.crm.purchase.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 采购管理
 * 
 * @author Administrator
 * 
 */
@Entity
@Table(name = "PURCHASE_RECORD")
public class PurchaseRecord implements java.io.Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 4347756704763964758L;
	/**
	 * 主键
	 */
	private String id;
	/**
	 * 批次id
	 */
	private String batchId;
	/**
	 * 产品名称
	 */
	private String prductName;

	/**
	 * 规格
	 */
	private String specification;

	/**
	 * 克重
	 */
	private String gramWeight;
	/**
	 * 吨
	 */
	private String ton;
	/**
	 * 数量
	 */
	private String amount;
	/**
	 * 运费
	 */
	private String freight;
	/**
	 * 应付款
	 */
	private String accountPayable;
	/**
	 * 实付款
	 */
	private String actualPayment;
	/**
	 * 欠款
	 */
	private String amountInArrear;

	/**
	 * 创建时间
	 */
	private Date createTime;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBatchId() {
		return batchId;
	}

	public void setBatchId(String batchId) {
		this.batchId = batchId;
	}

	public String getPrductName() {
		return prductName;
	}

	public void setPrductName(String prductName) {
		this.prductName = prductName;
	}

	public String getSpecification() {
		return specification;
	}

	public void setSpecification(String specification) {
		this.specification = specification;
	}

	public String getGramWeight() {
		return gramWeight;
	}

	public void setGramWeight(String gramWeight) {
		this.gramWeight = gramWeight;
	}

	public String getTon() {
		return ton;
	}

	public void setTon(String ton) {
		this.ton = ton;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getFreight() {
		return freight;
	}

	public void setFreight(String freight) {
		this.freight = freight;
	}

	public String getAccountPayable() {
		return accountPayable;
	}

	public void setAccountPayable(String accountPayable) {
		this.accountPayable = accountPayable;
	}

	public String getActualPayment() {
		return actualPayment;
	}

	public void setActualPayment(String actualPayment) {
		this.actualPayment = actualPayment;
	}

	public String getAmountInArrear() {
		return amountInArrear;
	}

	public void setAmountInArrear(String amountInArrear) {
		this.amountInArrear = amountInArrear;
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

}

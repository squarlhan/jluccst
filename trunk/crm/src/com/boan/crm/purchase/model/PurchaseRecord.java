package com.boan.crm.purchase.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

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
	@Id
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@GeneratedValue(generator = "system-uuid")
	private String id;
	/**
	 * 公司id
	 */
	@Column(name = "COMPANY_ID", length = 50)
	private String companyId;
	/**
	 * 供应商id
	 */
	@Column(name = "SUPPLIER_ID", length = 50)
	private String supplierId;
	
	/**
	 * 供应商名称
	 */
	@Column(name = "SUPPLIER_NAME", length = 50)
	private String supplierName;
	/**
	 * 供应商编号
	 */
	@Column(name = "SUPPLIER_NUMBER", length = 50)
	private String supplierNumber;

	/**
	 * 批次id
	 */
	@Column(name = "BATCH_ID", length = 50)
	private String batchId;
	/**
	 * 产品分类
	 */
	@Column(name = "PRODUCT_TYPE", length = 50)
	private String productType;
	
	/**
	 * 产品id
	 */
	@Column(name = "PRODUCT_ID", length = 50)
	private String productId;
	/**
	 * 产品名称
	 */
	@Column(name = "PRODUCT_NAME", length = 50)
	private String productName;

	/**
	 * 规格
	 */
	@Column(name = "SPECIFICATION", length = 50)
	private String specification;

	/**
	 * 克重
	 */
	@Column(name = "GRAM_WEIGHT", length = 50)
	private String gramWeight;
	/**
	 * 吨
	 */
	@Column(name = "TON", length = 50)
	private String ton;
	/**
	 * 数量
	 */
	@Column(name = "AMOUNT")
	private int amount;
	/**
	 * 单价
	 */
	@Column(name = "UNIT_PRICE")
	private float  unitPrice;
	/**
	 * 运费
	 */
	@Column(name = "FREIGHT")
	private float freight;
	/**
	 * 应付款
	 */
	@Column(name = "ACCOUNT_PAYABLE")
	private float accountPayable;
	/**
	 * 实付款
	 */
	@Column(name = "ACTUAL_PAYMENT")
	private float actualPayment;
	/**
	 * 欠款
	 */
	@Column(name = "AMOUNT_IN_ARREAR")
	private float amountInArrear;

	/**
	 * 备注
	 */
	@Column(name = "MEMO", length = 1000)
	private String memo;
	/**
	 * 创建时间
	 */
	@Column(name = "CREATE_TIME")
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

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public float getFreight() {
		return freight;
	}

	public void setFreight(float freight) {
		this.freight = freight;
	}

	public float getAccountPayable() {
		return accountPayable;
	}

	public void setAccountPayable(float accountPayable) {
		this.accountPayable = accountPayable;
	}

	public float getActualPayment() {
		return actualPayment;
	}

	public void setActualPayment(float actualPayment) {
		this.actualPayment = actualPayment;
	}

	public float getAmountInArrear() {
		return amountInArrear;
	}

	public void setAmountInArrear(float amountInArrear) {
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

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

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

	public float getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(float unitPrice) {
		this.unitPrice = unitPrice;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

}

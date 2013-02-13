package com.boan.crm.purchase.model;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * 初始库存
 * 
 * @author Administrator
 * 
 */
@Entity
@Table(name = "PURCHASE_INIT_REPERTORY")
public class InitRepertory implements java.io.Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -4684302079675597220L;
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
	 * 产品类别
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
	 * 库存量
	 */
	@Column(name = "AMOUNT")
	private int amount;
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
	 * 总价值=单价*数量
	 */
	@Column(name = "TOTAL_VALUE")
	private float totalValue;

	/**
	 * 创建时间
	 */
	@Column(name = "CREATE_TIME")
	private Calendar createTime;

	/**
	 * 默认机构器
	 */
	public InitRepertory() {
		this.id = "";
	}

	/**
	 * 构造器
	 * 
	 * @param companyId
	 * @param productId
	 * @param productName
	 * @param amount
	 * @param freight
	 * @param accountPayable
	 * @param actualPayment
	 * @param amountInArrear
	 */

	public InitRepertory(String companyId, String productId, String productName, int amount, float freight, float accountPayable, float actualPayment, float amountInArrear) {
		this.companyId = companyId;
		this.productId = productId;
		this.productName = productName;
		this.amount = amount;
		this.freight = freight;
		this.accountPayable = accountPayable;
		this.actualPayment = actualPayment;
		this.amountInArrear = amountInArrear;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public float getTotalValue() {
		return totalValue;
	}

	public void setTotalValue(float totalValue) {
		this.totalValue = totalValue;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public Calendar getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Calendar createTime) {
		this.createTime = createTime;
	}

}

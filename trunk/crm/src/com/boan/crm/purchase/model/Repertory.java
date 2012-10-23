package com.boan.crm.purchase.model;

/**
 * 库存清单
 * 
 * @author Administrator
 * 
 */
public class Repertory implements java.io.Serializable {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 6195023513293227489L;
	/**
	 * 公司id
	 */
	private String companyId;
	/**
	 * 产品id
	 */
	private String productId;
	/**
	 * 产品名称
	 */
	private String productName;
	/**
	 * 数量
	 */
	private int amount;
	/**
	 * 运费
	 */
	private float freight;
	/**
	 * 应付款
	 */
	private float accountPayable;
	/**
	 * 实付款
	 */
	private float actualPayment;
	/**
	 * 欠款
	 */
	private float amountInArrear;
	
	/**
	 * 总价值=单价*数量
	 */
	private float totalValue;

	/**
	 * 默认机构器
	 */
	public Repertory() {
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

	public Repertory(String companyId, String productId, String productName, int amount, float freight, float accountPayable, float actualPayment, float amountInArrear) {
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

}

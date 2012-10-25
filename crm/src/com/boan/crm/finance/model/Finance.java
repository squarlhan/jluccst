package com.boan.crm.finance.model;

/**
 * 财务清单
 * 
 * @author Administrator
 * 
 */
public class Finance implements java.io.Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 546144684408502308L;

	/**
	 * 主键
	 */
	private String id;

	/**
	 * 日期,按日期控件进行查询，并保存
	 */
	private String queryDate;

	/**
	 * 销售总额,根据销售记录中，到查询日期止，所有用户产生的所有销售单中的交易总额和
	 */
	private float totalSellAmount;

	/**
	 * 应收款总额：根据销售记录中，到查询日期止，所有用户产生的所有销售单中的交易总额和
	 */
	private float totalAccountDue;

	/**
	 * 实际收入：根据销售记录中，到查询日期止，所有用户产生的所有销售单中的实收和
	 */
	private float totalActualReceipt;

	/**
	 * 欠款：根据销售记录中，到查询日期止，所有用户产生的所有销售单中的欠款和
	 */
	private float totalAmountInArrear;

	/**
	 * 进货总额：根据采购记录中，到查询日期止，所有用户产生的所有采购单中的（数量X单价）和
	 */
	private float totalAmountPurchase;

	/**
	 * 应付款总额：根据采购记录中，到查询日期止，所有用户产生的所有采购单中的（数量X单价）和
	 */
	private float totalAmountDue;
	/**
	 * 实际支出：根据采购记录中，到查询日期止，所有用户产生的所有采购单中的实际支出和
	 */
	private float totalActualOutlay;

	/**
	 * 库存总额： 根据库存记录中，到查询日期止，所有库存 总和
	 */
	private float totalInventory;
	/**
	 * 总利润：销售总额－ 进货总额
	 */
	private float totalProfit;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getQueryDate() {
		return queryDate;
	}
	public void setQueryDate(String queryDate) {
		this.queryDate = queryDate;
	}
	public float getTotalSellAmount() {
		return totalSellAmount;
	}
	public void setTotalSellAmount(float totalSellAmount) {
		this.totalSellAmount = totalSellAmount;
	}
	public float getTotalAccountDue() {
		return totalAccountDue;
	}
	public void setTotalAccountDue(float totalAccountDue) {
		this.totalAccountDue = totalAccountDue;
	}
	public float getTotalActualReceipt() {
		return totalActualReceipt;
	}
	public void setTotalActualReceipt(float totalActualReceipt) {
		this.totalActualReceipt = totalActualReceipt;
	}
	public float getTotalAmountInArrear() {
		return totalAmountInArrear;
	}
	public void setTotalAmountInArrear(float totalAmountInArrear) {
		this.totalAmountInArrear = totalAmountInArrear;
	}
	public float getTotalAmountPurchase() {
		return totalAmountPurchase;
	}
	public void setTotalAmountPurchase(float totalAmountPurchase) {
		this.totalAmountPurchase = totalAmountPurchase;
	}
	public float getTotalAmountDue() {
		return totalAmountDue;
	}
	public void setTotalAmountDue(float totalAmountDue) {
		this.totalAmountDue = totalAmountDue;
	}
	public float getTotalActualOutlay() {
		return totalActualOutlay;
	}
	public void setTotalActualOutlay(float totalActualOutlay) {
		this.totalActualOutlay = totalActualOutlay;
	}
	public float getTotalInventory() {
		return totalInventory;
	}
	public void setTotalInventory(float totalInventory) {
		this.totalInventory = totalInventory;
	}
	public float getTotalProfit() {
		return totalProfit;
	}
	public void setTotalProfit(float totalProfit) {
		this.totalProfit = totalProfit;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}

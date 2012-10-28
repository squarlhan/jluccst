package com.boan.crm.finance.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * 财务清单
 * 
 * @author Administrator
 * 
 */
@Entity
@Table(name = "FINANCE_LIST")
public class Finance implements java.io.Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 546144684408502308L;

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
	 * 日期,按日期控件进行查询，并保存，开始日期
	 */
	@Column(name = "BEGIN_DATE")
	private String beginDate;
	/**
	 * 日期,按日期控件进行查询，并保存,结束日期
	 */
	@Column(name = "END_DATE")
	private String endDate;

	/**
	 * 销售总额,根据销售记录中，到查询日期止，所有用户产生的所有销售单中的交易总额和
	 */
	@Column(name = "TOTAL_SELL_AMOUNT")
	private float totalSellAmount;

	/**
	 * 应收款总额：根据销售记录中，到查询日期止，所有用户产生的所有销售单中的交易总额和
	 */
	@Column(name = "TOTAL_ACCOUNT_DUE")
	private float totalAccountDue;

	/**
	 * 实际收入：根据销售记录中，到查询日期止，所有用户产生的所有销售单中的实收和
	 */
	@Column(name = "TOTAL_ACTUAL_RECEIPT")
	private float totalActualReceipt;

	/**
	 * 欠款：根据销售记录中，到查询日期止，所有用户产生的所有销售单中的欠款和
	 */
	@Column(name = "TOTAL_AMOUNT_IN_ARREAR")
	private float totalAmountInArrear;

	/**
	 * 进货总额：根据采购记录中，到查询日期止，所有用户产生的所有采购单中的（数量X单价）和
	 */
	@Column(name = "TOTAL_AMOUNT_PURCHASE")
	private float totalAmountPurchase;

	/**
	 * 应付款总额
	 */
	@Column(name = "TOTAL_AMOUNT_DUE")
	private float totalAmountDue;
	/**
	 * 实际支出：根据采购记录中，到查询日期止，所有用户产生的所有采购单中的实际支出和
	 */
	@Column(name = "TOTAL_ACTUAL_OUTLAY")
	private float totalActualOutlay;

	/**
	 * 库存总额： 根据库存记录中，到查询日期止，所有库存 总和
	 */
	@Column(name = "TOTAL_INVENTORY")
	private float totalInventory;
	/**
	 * 总利润：销售总额－ 进货总额
	 */
	@Column(name = "TOTAL_PROFIT")
	private float totalProfit;
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

	public String getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(String beginDate) {
		this.beginDate = beginDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}

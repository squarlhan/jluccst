package com.boan.crm.sellrecord.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

import com.boan.crm.customer.model.CustomerInfo;

/**
 * 销售记录
 * @author YF
 *
 */
@Entity
@Table(name = "SELL_RECORD")
public class SellRecord implements Serializable {

	private static final long serialVersionUID = 7500240948621330774L;
	
	@Id
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@GeneratedValue(generator = "system-uuid")
	@Column(name = "ID", length=50)
	private String id;
	
	/**
	 * 客户信息
	 */
	@Transient
	private CustomerInfo customer;
	
	/**
	 * 商品明细
	 */
	@Transient
	private Set goodsDetials;
	
	/**
	 * 客户Id
	 */
	@Column(name = "CUSTOMER_ID")
	private String customerId;
	
	/**
	 * 客户名称
	 */
	@Column(name = "CUSTOMER_NAME")
	private String customerName;
	
	/**
	 * 销售员id
	 */
	@Column(name = "SALESMAN_ID")
	private String salesmanId;
	
	/**
	 * 销售员id
	 */
	@Column(name = "SALESMAN_NAME")
	private String salesmanName;
	
	/**
	 * 订单号
	 */
	@Column(name = "ORDERID")
	private String orderID;
	/**
	 * 税率
	 */
	@Column(name = "RATE")
	private BigDecimal rate ;
	
	/**
	 * 应收金额
	 */
	@Column(name = "RECEIVABLE")
	private BigDecimal receivable;
	
	/**
	 * 实收
	 */
	@Column(name = "REAL_COLLECTION")
	private BigDecimal realCollection;
	
	/**
	 * 欠款
	 */
	@Column(name = "DEBT")
	private BigDecimal debt;
	/**
	 * 预付
	 */
	@Column(name = "ADVANCE")
	private BigDecimal advance;
	
	/**
	 * 是否已开发票 0:不开 1：开
	 */
	@Column(name = "INVOICE")
	private int invoice;
	
	/**
	 * 成交时间
	 */
	@Column(name = "BARGAIN_TIME")
	private Calendar  bargainTime;

	public CustomerInfo getCustomer() {
		return customer;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setCustomer(CustomerInfo customer) {
		this.customer = customer;
	}

	public Set getGoodsDetials() {
		return goodsDetials;
	}

	public void setGoodsDetials(Set goodsDetials) {
		this.goodsDetials = goodsDetials;
	}

	public BigDecimal getRate() {
		return rate;
	}

	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}

	public BigDecimal getReceivable() {
		return receivable;
	}

	public void setReceivable(BigDecimal receivable) {
		this.receivable = receivable;
	}

	public BigDecimal getRealCollection() {
		return realCollection;
	}

	public void setRealCollection(BigDecimal realCollection) {
		this.realCollection = realCollection;
	}

	public BigDecimal getDebt() {
		return debt;
	}

	public void setDebt(BigDecimal debt) {
		this.debt = debt;
	}

	public BigDecimal getAdvance() {
		return advance;
	}

	public void setAdvance(BigDecimal advance) {
		this.advance = advance;
	}

	public int getInvoice() {
		return invoice;
	}

	public void setInvoice(int invoice) {
		this.invoice = invoice;
	}

	public Calendar getBargainTime() {
		return bargainTime;
	}

	public void setBargainTime(Calendar bargainTime) {
		this.bargainTime = bargainTime;
	}

	public String getOrderID() {
		return orderID;
	}

	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getSalesmanId() {
		return salesmanId;
	}

	public void setSalesmanId(String salesmanId) {
		this.salesmanId = salesmanId;
	}

	public String getSalesmanName() {
		return salesmanName;
	}

	public void setSalesmanName(String salesmanName) {
		this.salesmanName = salesmanName;
	}
}

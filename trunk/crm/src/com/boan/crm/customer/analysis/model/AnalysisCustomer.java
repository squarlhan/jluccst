/**
 * 
 */
package com.boan.crm.customer.analysis.model;

import java.math.BigDecimal;

/**
 * @author luojx
 *
 */
public class AnalysisCustomer {
	private String id = "";
	private String customerName = "";
	private BigDecimal totalConsumption;
	private int consumptionTimes = 0;
	private int introduceCustomerTime = 0;
	private int paymentsTimes = 0;
	private BigDecimal payments;
	private double developDegree = 0;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public BigDecimal getTotalConsumption() {
		return totalConsumption;
	}
	public void setTotalConsumption(BigDecimal totalConsumption) {
		this.totalConsumption = totalConsumption;
	}
	public int getConsumptionTimes() {
		return consumptionTimes;
	}
	public void setConsumptionTimes(int consumptionTimes) {
		this.consumptionTimes = consumptionTimes;
	}
	public int getIntroduceCustomerTime() {
		return introduceCustomerTime;
	}
	public void setIntroduceCustomerTime(int introduceCustomerTime) {
		this.introduceCustomerTime = introduceCustomerTime;
	}
	public int getPaymentsTimes() {
		return paymentsTimes;
	}
	public void setPaymentsTimes(int paymentsTimes) {
		this.paymentsTimes = paymentsTimes;
	}
	public BigDecimal getPayments() {
		return payments;
	}
	public void setPayments(BigDecimal payments) {
		this.payments = payments;
	}
	public double getDevelopDegree() {
		return developDegree;
	}
	public void setDevelopDegree(double developDegree) {
		this.developDegree = developDegree;
	}
}

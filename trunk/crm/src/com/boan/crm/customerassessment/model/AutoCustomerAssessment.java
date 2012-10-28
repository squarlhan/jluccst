/**
 * 
 */
package com.boan.crm.customerassessment.model;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * @author luojx
 *
 */
@Entity
@Table(name = "AUTO_CUSTOMER_ASSESSMENT")
public class AutoCustomerAssessment {
	@Id
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@GeneratedValue(generator = "system-uuid")
	private String id;
	@Column(name = "COMPANY_ID" , length = 50)
	private String companyId = "";
	@Column(name = "CUSTOMER_ID" , length = 50)
	private String customerId = "";
	@Column(name = "CUSTOMER_NAME" , length = 50)
	private String customerName = "";
	@Column(name = "RESULT_VALUE")
	private double resultValue = 0;
	@Column(name = "RESULT", length = 500)
	private String result = "";
	@Column(name = "ASSESSMENT_TIME")
	private Calendar assessmentTime;
	@Column(name = "TOTAL_CONSUMPTION")
	private BigDecimal totalConsumption;
	@Column(name = "CONSUMPTION_TIMES")
	private int consumptionTimes = 0;
	@Column(name = "INTRODUCECUSTOMER_TIMES")
	private int introduceCustomerTime = 0;
	@Column(name = "PAYMENTS_TIMES")
	private int paymentsTimes = 0;
	private BigDecimal payments;
	@Column(name = "DEVELOP_DEGREE")
	private double developDegree = 0;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCompanyId() {
		return companyId;
	}
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	public Calendar getAssessmentTime() {
		return assessmentTime;
	}
	public void setAssessmentTime(Calendar assessmentTime) {
		this.assessmentTime = assessmentTime;
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
	public double getResultValue() {
		return resultValue;
	}
	public void setResultValue(double resultValue) {
		this.resultValue = resultValue;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
}

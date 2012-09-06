/**
 * 
 */
package com.boan.crm.customerassessment.model;

/**
 * @author luojx
 *
 */
public class CustomerAssessment {
	private String customerId = "";
	private String customerName = "";
	private double resultValue = 0;
	private String result = "";
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

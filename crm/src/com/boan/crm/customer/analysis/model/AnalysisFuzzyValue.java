/**
 * 
 */
package com.boan.crm.customer.analysis.model;

/**
 * @author luojx
 *
 */
public class AnalysisFuzzyValue {
	private String id = "";
	private int fuzzyId = 0;
	private double fuzzyValue = 0;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getFuzzyId() {
		return fuzzyId;
	}
	public void setFuzzyId(int fuzzyId) {
		this.fuzzyId = fuzzyId;
	}
	public double getFuzzyValue() {
		return fuzzyValue;
	}
	public void setFuzzyValue(double fuzzyValue) {
		this.fuzzyValue = fuzzyValue;
	}
	
	
}

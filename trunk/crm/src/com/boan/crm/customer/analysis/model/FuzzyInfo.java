/**
 * 
 */
package com.boan.crm.customer.analysis.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author luojx
 *
 */
@Entity
@Table(name = "FUZZY_INFO")
public class FuzzyInfo implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5221025304915390477L;
	public FuzzyInfo(){ }
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id = 0;
	@Column(name = "FUZZY_NAME" , length = 100)
	private String fuzzyName = "";
	@Column(name = "FUZZY_CATEGORYNAME" , length = 100)
	private String fuzzyCategoryName = "";
	@Column(name = "FUZZY_CATEGORY" , length = 100)
	private String fuzzyCategory = "";
	@Column(name = "FUNCTION_NAME" , length = 100)
	private String functionName = "";
	@Column(name = "FUNCTION_CNAME" , length = 100)
	private String functionCName = "";
	
	@Column(name = "FIRST_VALUE")
	private double firstValue = 0;
	@Column(name = "SECOND_VALUE")
	private double secondValue = 0;
	@Column(name = "THIRD_VALUE")
	private double thirdValue = 0;
	@Column(name = "FOURTH_VALUE")
	private double fourthValue = 0;
	@Column(name = "SUGENO")
	private double sugeno = 0;
	@Column(name = "COMPANY_ID")
	private String companyId = "";
	public String getCompanyId() {
		return companyId;
	}
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	public double getSugeno() {
		return sugeno;
	}
	public void setSugeno(double sugeno) {
		this.sugeno = sugeno;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFuzzyName() {
		return fuzzyName;
	}
	public void setFuzzyName(String fuzzyName) {
		this.fuzzyName = fuzzyName;
	}
	public String getFuzzyCategory() {
		return fuzzyCategory;
	}
	public void setFuzzyCategory(String fuzzyCategory) {
		this.fuzzyCategory = fuzzyCategory;
	}
	public String getFunctionName() {
		return functionName;
	}
	public void setFunctionName(String functionName) {
		this.functionName = functionName;
	}
	public double getFirstValue() {
		return firstValue;
	}
	public void setFirstValue(double firstValue) {
		this.firstValue = firstValue;
	}
	public double getSecondValue() {
		return secondValue;
	}
	public void setSecondValue(double secondValue) {
		this.secondValue = secondValue;
	}
	public double getThirdValue() {
		return thirdValue;
	}
	public void setThirdValue(double thirdValue) {
		this.thirdValue = thirdValue;
	}
	public double getFourthValue() {
		return fourthValue;
	}
	public void setFourthValue(double fourthValue) {
		this.fourthValue = fourthValue;
	}
	public String getFuzzyCategoryName() {
		return fuzzyCategoryName;
	}
	public void setFuzzyCategoryName(String fuzzyCategoryName) {
		this.fuzzyCategoryName = fuzzyCategoryName;
	}
	public String getFunctionCName() {
		return functionCName;
	}
	public void setFunctionCName(String functionCName) {
		this.functionCName = functionCName;
	}
}

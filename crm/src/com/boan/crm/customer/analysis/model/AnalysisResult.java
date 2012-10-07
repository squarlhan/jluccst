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
@Table(name = "ANALYSIS_RESULT")
public class AnalysisResult implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8642549267687415175L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id =0;
	@Column(name = "BEGIN_VALUE")
	private double beginValue = 0;
	@Column(name = "END_VALUE")
	private double endValue = 0;
	@Column(name = "RESULT" , length = 100)
	private String result = "";
	@Column(name = "COMPANY_ID")
	private String companyId = "";
	public String getCompanyId() {
		return companyId;
	}
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getBeginValue() {
		return beginValue;
	}
	public void setBeginValue(double beginValue) {
		this.beginValue = beginValue;
	}
	public double getEndValue() {
		return endValue;
	}
	public void setEndValue(double endValue) {
		this.endValue = endValue;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	
}

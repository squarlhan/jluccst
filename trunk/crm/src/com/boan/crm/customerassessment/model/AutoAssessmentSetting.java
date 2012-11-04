/**
 * 
 */
package com.boan.crm.customerassessment.model;

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
@Table(name = "AUTO_ASSESSMENT_SETTING")
public class AutoAssessmentSetting {
	@Id
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@GeneratedValue(generator = "system-uuid")
	private String id;
	@Column(name = "COMPANY_ID" , length = 50)
	private String companyId = "";
	@Column(name = "OPTIONS")
	private int options = 0;
	@Column(name = "BEGIN_TIME")
	private Calendar beginTime;
	@Column(name = "TIME_CLOCK")
	private int TIME_CLOCK = 0;
	@Column(name = "ITEM")
	private String item = "";
	@Column(name = "ALLCUSTOMER_FLAG")
	private int allCustomerFlag = 0;
	
	public int getAllCustomerFlag() {
		return allCustomerFlag;
	}
	public void setAllCustomerFlag(int allCustomerFlag) {
		this.allCustomerFlag = allCustomerFlag;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
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
	public int getOptions() {
		return options;
	}
	public void setOptions(int options) {
		this.options = options;
	}
	public Calendar getBeginTime() {
		return beginTime;
	}
	public void setBeginTime(Calendar beginTime) {
		this.beginTime = beginTime;
	}
	public int getTIME_CLOCK() {
		return TIME_CLOCK;
	}
	public void setTIME_CLOCK(int tIME_CLOCK) {
		TIME_CLOCK = tIME_CLOCK;
	}

}

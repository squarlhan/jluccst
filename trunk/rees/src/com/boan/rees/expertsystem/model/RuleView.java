/*
 * @(#)RuleInfo.java 1.1 2012-4-21
 */

package com.boan.rees.expertsystem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Rule_View实体model类
 * @author jiangmeidi
 * @version 1.0.0
 */
//@Entity
public class RuleView {
	
	
	/**
	 * 主键
	 */
	private int id;

	/**
	 * 设备特征对应ID
	 */
	
	private String deviceTypeId;
	/**
	 * 现象ID,可以多个以分隔符“|”分隔
	 */

	private String resultId;
	/**
	 * 原因ID
	 */

	private String reasonId;
	/**
	 * 对应建议ID
	 */

	private int adviceId;
	/**
	 * 建议描述
	 */
	
	private String advice;
	/**
	 * 原因描述
	 */

	private String reason;
	/**
     * 现象描述
     */

	private String result;
	/**
	 * 设备类型
	 */

	private String typeName;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	
	public String getResultId() {
		return resultId;
	}
	public void setResultId(String resultId) {
		this.resultId = resultId;
	}
	public String getReasonId() {
		return reasonId;
	}
	public void setReasonId(String reasonId) {
		this.reasonId = reasonId;
	}
	public int getAdviceId() {
		return adviceId;
	}
	public void setAdviceId(int adviceId) {
		this.adviceId = adviceId;
	}
	public String getDeviceTypeId() {
		return deviceTypeId;
	}
	public void setDeviceTypeId(String deviceTypeId) {
		this.deviceTypeId = deviceTypeId;
	}
	public String getAdvice() {
		return advice;
	}
	public void setAdvice(String advice) {
		this.advice = advice;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public RuleView(int id, String deviceTypeId, String resultId,
			String reasonId, int adviceId, String advice, String reason,
			String result, String typeName) {
		super();
		this.id = id;
		this.deviceTypeId = deviceTypeId;
		this.resultId = resultId;
		this.reasonId = reasonId;
		this.adviceId = adviceId;
		this.advice = advice;
		this.reason = reason;
		this.result = result;
		this.typeName = typeName;
	}
	public RuleView(){
		super();
	}


    
}


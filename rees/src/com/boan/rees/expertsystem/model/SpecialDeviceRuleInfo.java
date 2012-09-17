/*
 * @(#)SpecialDeviceRuleInfo.java 1.1 2012-9-16
 */

package com.boan.rees.expertsystem.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

/**
 * XXX 类
 * @author jiangmeidi
 * @version 1.0.0
 */
@Entity
@Table(name = "SPECIAL_DEVICE_RULE_INFO")
public class SpecialDeviceRuleInfo  implements Serializable {
	
	public SpecialDeviceRuleInfo(){
		
	}
	
	public SpecialDeviceRuleInfo(String deviceId){
		this.deviceId = deviceId;
	}
	private static final long serialVersionUID = 1L;
	@Id
	@GenericGenerator(name="system-uuid", strategy="uuid")
	@GeneratedValue(generator="system-uuid")
	/**
	 * 主键
	 */
	private String id;

	/**
	 * 设备Id
	 */
	@Column(name = "DEVICE_ID")
	private String deviceId;
	
	/**
	 * 设备名称
	 */
	@Column(name = "DEVICE_NAME")
	private String deviceName;
	
	/**
	 * 所属公司Id
	 */
	@Column(name = "COMPANY_ID", length=50)
	private String companyId;
	/**
	 * 所属工厂Id
	 */
	@Column(name = "FACTORY_ID")
	private String factoryId;
	/**
	 *所属车间Id
	 */
	@Column(name = "WORKSHOP_ID")
	private String workshopId;
	
	/**
	 * 监测点组合串格式（监测点名称+监测点参数名称_监测点名称+监测点参数名称  如：Aa_Av_Ah_Ba_Bh）
	 */
	@Column(name = "POINT_STR")
	private String pointStr;
	
	/**
	 * 设备特征对应ID
	 */
	@Column(name = "DEVICE_TYPE_ID")
	private String deviceTypeId;
	/**
	 * 现象ID,可以多个以分隔符“_”分隔
	 */
	@Column(name = "RESULT_ID")
	private String resultId;
	/**
	 * 原因ID
	 */
	@Column(name = "REASON_ID")
	private String reasonId;
	/**
	 * 对应建议ID
	 */
	@Column(name = "ADVICE_ID")
	private String adviceId;
	
	
	/**
	 * 因子类型（0：监测点 1：监测点参数）
	 */
	@Column(name = "factor_Type")
	private int factorType;
	
	/**
	 * 建议描述
	 */
	@Transient
	private String advice;
	/**
	 * 原因描述
	 */
	@Transient
	private String reason;
	/**
     * 现象描述
     */
	@Transient
	private String result;
	/**
	 * 设备类型名
	 */
	@Column(name = "DEVICE_TYPE_NAME")
	private String deviceTypeName;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDeviceTypeId() {
		return deviceTypeId;
	}
	public void setDeviceTypeId(String deviceTypeId) {
		this.deviceTypeId = deviceTypeId;
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
	public String getAdviceId() {
		return adviceId;
	}
	public void setAdviceId(String adviceId) {
		this.adviceId = adviceId;
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
	
	public String getDeviceTypeName() {
		return deviceTypeName;
	}

	public void setDeviceTypeName(String deviceTypeName) {
		this.deviceTypeName = deviceTypeName;
	}

	public String getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
	public String getDeviceName() {
		return deviceName;
	}
	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}
	public String getPointStr() {
		return pointStr;
	}
	public void setPointStr(String pointStr) {
		this.pointStr = pointStr;
	}
	public String getCompanyId() {
		return companyId;
	}
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	public String getFactoryId() {
		return factoryId;
	}
	public void setFactoryId(String factoryId) {
		this.factoryId = factoryId;
	}
	public String getWorkshopId() {
		return workshopId;
	}
	public void setWorkshopId(String workshopId) {
		this.workshopId = workshopId;
	}

	public int getFactorType() {
		return factorType;
	}

	public void setFactorType(int factorType) {
		this.factorType = factorType;
	}
}


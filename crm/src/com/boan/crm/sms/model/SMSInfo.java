package com.boan.crm.sms.model;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/***
 * 短信信息实体
 * @author Administrator
 *
 */
@Entity
@Table(name = "SMS_INFO")
public class SMSInfo {

	private static final long serialVersionUID = 7197292703142337721L;

	/**
	 * 编号
	 */
	@Id
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@GeneratedValue(generator = "system-uuid")
	private String id;
	
	/**
	 * 名片信息
	 */
	@ManyToOne(targetEntity=SMSCustomerInfo.class,fetch=FetchType.LAZY)
	@JoinColumn(name="CUSTOMER_ID")
	private SMSCustomerInfo customerInfo;
	
	/**
	 * 发短信的机构或公司Id
	 */
	@Column(name = "ORGAN_ID", length=50)
	private String organId;
	
	/**
	 * 接收人名称
	 */
	@Column(name = "PERSON_NAME" , length = 50)
	private String personName;
	
	/**
	 * 電話號
	 */
	@Column(name = "PHONE" , length = 50)
	private String phone;
	
	/**
	 * 接收人单位
	 */
	@Column(name = "PERSON_COMPANY" , length = 50)
	private String personCompany;
	
	/**
	 *  短信内容
	 */
	@Column(name = "INFO", length=2000)
	private String info;
	
	/**
	 * 发送时间
	 */
	@Column(name = "SEND_TIME", length=1)
	private Calendar sendTime;
	
	/**
	 * 是否是立即发送（0：立即  1：定时）
	 */
	@Column(name = "IS_IMMEDIATELY", length=1)
	private int isImmediately;
	/**
	 * 发送状态（0：准备    1：等待   2：成功 3：失败）
	 */
	@Column(name = "STATE", length=1)
	private int state;
	
	/**
	 * 销售记录Id
	 */
	@Column(name = "SELL_RECORD_ID")
	private String sellRecordId;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public SMSCustomerInfo getCustomerInfo() {
		return customerInfo;
	}
	public void setCustomerInfo(SMSCustomerInfo customerInfo) {
		this.customerInfo = customerInfo;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public Calendar getSendTime() {
		return sendTime;
	}
	public void setSendTime(Calendar sendTime) {
		this.sendTime = sendTime;
	}
	public int getIsImmediately() {
		return isImmediately;
	}
	public void setIsImmediately(int isImmediately) {
		this.isImmediately = isImmediately;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public String getOrganId() {
		return organId;
	}
	public void setOrganId(String organId) {
		this.organId = organId;
	}
	public String getPersonName() {
		return personName;
	}
	public void setPersonName(String personName) {
		this.personName = personName;
	}
	public String getPersonCompany() {
		return personCompany;
	}
	public void setPersonCompany(String personCompany) {
		this.personCompany = personCompany;
	}
	public String getSellRecordId() {
		return sellRecordId;
	}
	public void setSellRecordId(String sellRecordId) {
		this.sellRecordId = sellRecordId;
	}
}

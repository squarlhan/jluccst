package com.boan.crm.sms.model;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
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
	@ManyToOne(targetEntity=SMSCustomerInfo.class)
	@JoinColumn(name="CUSTOMER_ID")
	private SMSCustomerInfo customerInfo;
	
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
	 * 发送状态（0：等待    1：成功  2：失败）
	 */
	@Column(name = "STATE", length=1)
	private int state;
	
	
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
}

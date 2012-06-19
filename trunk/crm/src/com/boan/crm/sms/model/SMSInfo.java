package com.boan.crm.sms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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

	@Id
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@GeneratedValue(generator = "system-uuid")
	
	/**
	 * 编号
	 */
	private String id;

	/**
	 * 電話號
	 */
	@Column(name = "PHONE" , length = 50)
	private String phone;
}

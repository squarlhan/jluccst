/**
 * Copyright (c) 2011 Changchun Boan Co. Ltd.
 * All right reserved.
 * History
 */
/*
 * @(#)EkeyUser.java 1.1 2011-1-13
 */
package com.boan.crm.groupmanage.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

/**
 * USB锁的身份信息
 * 
 * @author XXX
 * @version 1.0.0
 */
@Entity
@Table(name = "GROUP_EKEY_USER")
public class EkeyUser implements Serializable {
	/**
	 * 用户实体主键
	 */
	@Id
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@GeneratedValue(generator = "system-uuid")
	private String id;
	/**
	 * 已生成的串行版本标识
	 */
	private static final long serialVersionUID = -7942547972908582447L;
	/**
	 * USB锁的SN值
	 */
	@Column(name = "EPASS_SN")
	private String sn;
	/**
	 * USB锁的Key值
	 */
	@Column(name = "EPASS_KEY")
	private String key;
	/**
	 * 对应的用户ID
	 */
	@Column(name = "USER_ID")
	private String userId;
	/**
	 * 对应的用户对象
	 */
	@Transient
	private User user;

	/**
	 * @return 返回 sn
	 */
	public String getSn() {
		return sn;
	}

	/**
	 * 设置 sn
	 * 
	 * @param sn
	 */
	public void setSn(String sn) {
		this.sn = sn;
	}

	/**
	 * @return 返回 key
	 */
	public String getKey() {
		return key;
	}

	/**
	 * 设置 key
	 * 
	 * @param key
	 */
	public void setKey(String key) {
		this.key = key;
	}

	/**
	 * @return 返回 userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * 设置 userId
	 * 
	 * @param userId
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * @return 返回 user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * 设置 user
	 * 
	 * @param user
	 */
	public void setUser(User user) {
		this.user = user;
	}

}

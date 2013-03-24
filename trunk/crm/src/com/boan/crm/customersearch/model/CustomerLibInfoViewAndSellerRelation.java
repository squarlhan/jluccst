/**
 * Copyright (c) 2013 Changchun CBIT Co. Ltd.
 * All right reserved.
 * History
 */
/*
 * @(#)CustomerLibInfoViewAndSellerRelation.java 1.1 2013-3-24
 */

package com.boan.crm.customersearch.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * XXX 类
 * @author XXX
 * @version 1.0.0
 */
@Entity
@Table(name = "CUSTOMER_LIB_INFO_VIEW_AND_SELLE_RELATION")
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class CustomerLibInfoViewAndSellerRelation {

	@Id
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@GeneratedValue(generator = "system-uuid")
	private String id;
	
	@Column(name = "CUSTOMER_LIB_INFO_VIEW_ID" )
	private String customerLibInfoViewId = "";
	
	@Column(name = "SELLER_ID")
	private String sellerId = "";
	
	//不在查询（0：查询  1：不查询）
	@Column(name = "NO_SEARCH"  ,nullable=false,columnDefinition="INT default 0")
	private int noSearch = 0;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCustomerLibInfoViewId() {
		return customerLibInfoViewId;
	}

	public void setCustomerLibInfoViewId(String customerLibInfoViewId) {
		this.customerLibInfoViewId = customerLibInfoViewId;
	}

	public String getSellerId() {
		return sellerId;
	}

	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}

	public int getNoSearch() {
		return noSearch;
	}

	public void setNoSearch(int noSearch) {
		this.noSearch = noSearch;
	}
}


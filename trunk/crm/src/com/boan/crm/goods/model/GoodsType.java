/**
 * Copyright (c) 2012 Boan Co. Ltd.
 * All right reserved.
 * History
 */
package com.boan.crm.goods.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

/**
 * 商品类别
 * @author leon
 * @version 1.0.0
 */
@Entity
@Table(name = "GOODS_TYPE")
public class GoodsType implements Serializable {
	private static final long serialVersionUID = -2058827779259344221L;

	@Id
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@GeneratedValue(generator = "system-uuid")
	/**
	 * 编号
	 */
	private String id;
	
	/**
	 * 单位ID
	 */
	@Column(name = "COMPANY_ID" , length = 50)
	private String companyId;
	
	/**
	 * 所属类别ID
	 */
	@Column(name = "FATHER_ID" , length = 50)
	private String fatherId;

	/**
	 * 名称
	 */
	@Column(name = "NAME" , length = 100)
	private String name;
	
	/**
	 * 排序号
	 */
	@Column(name = "SORT_INDEX")
	private Integer sortIndex = 0;

	/**
	 * 状态说明
	 */
	@Column(name = "REMARK", length = 200)
	private String remark;
	
	@Transient
	private List<GoodsInfoBase> goodsInfos = new ArrayList<GoodsInfoBase>();

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the companyId
	 */
	public String getCompanyId() {
		return companyId;
	}

	/**
	 * @param companyId the companyId to set
	 */
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	/**
	 * @return the fatherId
	 */
	public String getFatherId() {
		return fatherId;
	}

	/**
	 * @param fatherId the fatherId to set
	 */
	public void setFatherId(String fatherId) {
		this.fatherId = fatherId;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the sortIndex
	 */
	public Integer getSortIndex() {
		return sortIndex;
	}

	/**
	 * @param sortIndex the sortIndex to set
	 */
	public void setSortIndex(Integer sortIndex) {
		this.sortIndex = sortIndex;
	}

	/**
	 * @return the remark
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * @param remark the remark to set
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}

	public List<GoodsInfoBase> getGoodsInfos() {
		return goodsInfos;
	}

	public void setGoodsInfos(List<GoodsInfoBase> goodsInfos) {
		this.goodsInfos = goodsInfos;
	}
}

/**
 * Copyright (c) 2012 Boan Co. Ltd.
 * All right reserved.
 * History
 */
package com.boan.crm.goods.model;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * 商品信息
 * @author leon
 * @version 1.0.0
 */
@Entity
@Table(name = "GOODS_INFO_BASE")
public class GoodsInfoBase implements Serializable {
	private static final long serialVersionUID = 5198966337866949934L;

	@Id
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@GeneratedValue(generator = "system-uuid")
	/**
	 * 编号
	 */
	private String id;
	
	/**
	 * 所属类别ID
	 */
	@Column(name = "TYPE_ID" , length = 50)
	private String typeId;

	/**
	 * 名称
	 */
	@Column(name = "NAME" , length = 100)
	private String name;

	/**
	 * 规格
	 */
	@Column(name="GOODS_STANDARD")
	private String goodsStandard;
	
	/**
	 * 厂家
	 */
	@Column(name="FACTORY_NAME")
	private String factoryName;
	
	/**
	 * 商品价格
	 */
	@Column(name="GOODS_PRICE", length=50)
	private String goodsPrice;
	
	/**
	 * 创建时间
	 */
	@Column(name="CREATE_TIME")
	private Calendar createTime;

	/**
	 * 备注
	 */
	@Column(name = "REMARK", length = 200)
	private String remark;

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
	 * @return the typeId
	 */
	public String getTypeId() {
		return typeId;
	}

	/**
	 * @param typeId the typeId to set
	 */
	public void setTypeId(String typeId) {
		this.typeId = typeId;
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
	 * @return the goodsStandard
	 */
	public String getGoodsStandard() {
		return goodsStandard;
	}

	/**
	 * @param goodsStandard the goodsStandard to set
	 */
	public void setGoodsStandard(String goodsStandard) {
		this.goodsStandard = goodsStandard;
	}

	/**
	 * @return the factoryName
	 */
	public String getFactoryName() {
		return factoryName;
	}

	/**
	 * @param factoryName the factoryName to set
	 */
	public void setFactoryName(String factoryName) {
		this.factoryName = factoryName;
	}

	/**
	 * @return the goodsPrice
	 */
	public String getGoodsPrice() {
		return goodsPrice;
	}

	/**
	 * @param goodsPrice the goodsPrice to set
	 */
	public void setGoodsPrice(String goodsPrice) {
		this.goodsPrice = goodsPrice;
	}

	/**
	 * @return the createTime
	 */
	public Calendar getCreateTime() {
		return createTime;
	}

	/**
	 * @param createTime the createTime to set
	 */
	public void setCreateTime(Calendar createTime) {
		this.createTime = createTime;
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
}

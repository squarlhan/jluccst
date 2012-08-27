package com.boan.crm.sellrecord.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * 商品信息
 * @author YF
 *
 */
@Entity
@Table(name = "GOODS_INFO")
public class GoodsInfo implements Serializable {
	
	private static final long serialVersionUID = -4005415894135008642L;

	/**
	 * 编号
	 */
	@Id
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@GeneratedValue(generator = "system-uuid")
	@Column(name = "ID", length=50)
	private String id;
	
	/**
	 * 销售记录Id
	 */
	@Column(name = "SELL_RECORD_ID", length=200)
	private String sellRecordId;
	
	/**
	 * 商品名称
	 */
	@Column(name = "GOODS_NAME", length=200)
	private String goodsName;
	
	/**
	 * 规格
	 */
	@Column(name = "STANDARD", length=200)
	private String standard;
	
	/**
	 * 重量
	 */
	@Column(name = "WEIGHT")
	private BigDecimal weight;
	
	/**
	 * 数量
	 */
	@Column(name = "NUMBER")
	private int number;
	
	/**
	 * 价格
	 */
	@Column(name = "PRICE")
	private BigDecimal price; 
	
	/**
	 * 预付
	 */
	@Column(name = "ALL_PRICE")
	private BigDecimal allPrice;
	
	
	/**
	 * 进价
	 */
	@Column(name = "IMPORT_PRICE")
	private BigDecimal importPrice;
	
	/**
	 * 厂家
	 */
	@Column(name = "FACTORY")
	private String factory;

	/**
	 * 备注
	 */
	@Column(name = "MEMO")
	private String memo;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public String getStandard() {
		return standard;
	}

	public void setStandard(String standard) {
		this.standard = standard;
	}

	public BigDecimal getWeight() {
		return weight;
	}

	public void setWeight(BigDecimal weight) {
		this.weight = weight;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getImportPrice() {
		return importPrice;
	}

	public void setImportPrice(BigDecimal importPrice) {
		this.importPrice = importPrice;
	}

	public String getFactory() {
		return factory;
	}

	public void setFactory(String factory) {
		this.factory = factory;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public BigDecimal getAllPrice() {
		return allPrice;
	}

	public void setAllPrice(BigDecimal allPrice) {
		this.allPrice = allPrice;
	}

	public String getSellRecordId() {
		return sellRecordId;
	}

	public void setSellRecordId(String sellRecordId) {
		this.sellRecordId = sellRecordId;
	}
}

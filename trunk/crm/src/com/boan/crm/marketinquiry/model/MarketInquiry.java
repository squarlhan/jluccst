package com.boan.crm.marketinquiry.model;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * 市场调查实体
 * @author YF
 *
 */
@Entity
@Table(name = "MARKET_INQUIRY")
public class MarketInquiry implements Serializable{

	private static final long serialVersionUID = 1418268306796606554L;

	@Id
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@GeneratedValue(generator = "system-uuid")
	private String id;
	
	@Column(name = "INQUIRY_PERSON_NAME" , length = 50)
	private String inquiryPersonName;
	
	@Column(name = "INQUIRY_ADDRESS" , length = 50)
	private String inquiryAddress;
	
	@Column(name = "GOODS_NAME" , length = 50)
	private String goodsName;
	
	@Column(name = "GOODS_STANDARD" , length = 50)
	private String goodsStandard;
	
	@Column(name = "GOODS_WEIGHT" , length = 50)
	private String goodsWeight;
	
	@Column(name = "GOODS_PRICE" , length = 50)
	private String goodsPrice;
	
	@Column(name = "INQUIRY_TIME")
	private Calendar inquiryTime;
	
	@Column(name = "CREATE_TIME")
	private Calendar createTime;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getInquiryPersonName() {
		return inquiryPersonName;
	}

	public void setInquiryPersonName(String inquiryPersonName) {
		this.inquiryPersonName = inquiryPersonName;
	}

	public String getInquiryAddress() {
		return inquiryAddress;
	}

	public void setInquiryAddress(String inquiryAddress) {
		this.inquiryAddress = inquiryAddress;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public String getGoodsStandard() {
		return goodsStandard;
	}

	public void setGoodsStandard(String goodsStandard) {
		this.goodsStandard = goodsStandard;
	}

	public String getGoodsWeight() {
		return goodsWeight;
	}

	public void setGoodsWeight(String goodsWeight) {
		this.goodsWeight = goodsWeight;
	}

	public String getGoodsPrice() {
		return goodsPrice;
	}

	public void setGoodsPrice(String goodsPrice) {
		this.goodsPrice = goodsPrice;
	}

	public Calendar getInquiryTime() {
		return inquiryTime;
	}

	public void setInquiryTime(Calendar inquiryTime) {
		this.inquiryTime = inquiryTime;
	}

	public Calendar getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Calendar createTime) {
		this.createTime = createTime;
	}
}

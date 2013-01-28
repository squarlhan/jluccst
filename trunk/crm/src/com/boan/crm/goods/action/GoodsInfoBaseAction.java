/**
 * Copyright (c) 2012 Boan Co. Ltd.
 * All right reserved.
 * History
 */

package com.boan.crm.goods.action;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.boan.crm.goods.model.GoodsInfoBase;
import com.boan.crm.goods.service.IGoodsInfoBaseService;
import com.boan.crm.utils.action.BaseActionSupport;
import com.boan.crm.utils.page.Pagination;


/**
 * 商品类别Action类
 * 
 * @author leon
 * @version 1.0.0
 */
@Controller("goodsInfoBaseAction")
@Scope("prototype")
public class GoodsInfoBaseAction extends BaseActionSupport {
	private static final long serialVersionUID = 3303030334845311756L;

	@Resource
	// 商品类别接口类
	private IGoodsInfoBaseService goodsInfoBaseService;
	
	// 商品类别对象
	private GoodsInfoBase goodsInfoBase = null;
	
	private Pagination<GoodsInfoBase> pagination = new Pagination<GoodsInfoBase>();
	
	private String typeId = null;
	private String infoId = null;
	private String factoryName = null;
	private String goodsPrice = null;
	private String goodsStandard = null;
	private String name = null;
	private String remark = null;
	private String[] infoIds = null;
	
	private String message;
	
	/**
	 * 商品类别树集合
	 * @return
	 */
	public String goodsInfoBaseList(){
		Map<String,String> values = new HashMap<String,String>();
		values.put("typeId", typeId);
		pagination = goodsInfoBaseService.findGoodsInfoBaseForPage(values, pagination);
		return SUCCESS;
	}
	
	/**
	 * 获得商品类别信息
	 * @return
	 */
	public String goodsInfoBaseInfo(){
		if(StringUtils.trimToNull(infoId)!=null)
			goodsInfoBase = goodsInfoBaseService.get(infoId);
		else
			goodsInfoBase = new GoodsInfoBase();
		return SUCCESS;
	}
	
	/**
	 * 保存信息
	 * @return
	 */
	public String saveGoodsInfoBase(){
		if(StringUtils.trimToNull(infoId)!=null){
			goodsInfoBase = goodsInfoBaseService.get(infoId);
			this.message = "保存成功！";
		}else{
			goodsInfoBase = new GoodsInfoBase();
			this.message = "添加成功！";
			goodsInfoBase.setCreateTime(Calendar.getInstance());
		}
		goodsInfoBase.setFactoryName(factoryName);
		goodsInfoBase.setGoodsPrice(goodsPrice);
		goodsInfoBase.setGoodsStandard(goodsStandard);
		goodsInfoBase.setName(name);
		goodsInfoBase.setRemark(remark);
		goodsInfoBase.setTypeId(typeId);
		goodsInfoBaseService.save(goodsInfoBase);
		infoId = goodsInfoBase.getId();
		return SUCCESS;
	}
	
	/**
	 * 删除信息
	 * @return
	 */
	public String deleteGoodsInfoBase(){
		if(infoIds!=null){
			goodsInfoBaseService.delete(infoIds);
		}
		return SUCCESS;
	}

	/**
	 * @return the goodsInfoBase
	 */
	public GoodsInfoBase getGoodsInfoBase() {
		return goodsInfoBase;
	}

	/**
	 * @param goodsInfoBase the goodsInfoBase to set
	 */
	public void setGoodsInfoBase(GoodsInfoBase goodsInfoBase) {
		this.goodsInfoBase = goodsInfoBase;
	}

	/**
	 * @return the pagination
	 */
	public Pagination<GoodsInfoBase> getPagination() {
		return pagination;
	}

	/**
	 * @param pagination the pagination to set
	 */
	public void setPagination(Pagination<GoodsInfoBase> pagination) {
		this.pagination = pagination;
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
	 * @return the infoId
	 */
	public String getInfoId() {
		return infoId;
	}

	/**
	 * @param infoId the infoId to set
	 */
	public void setInfoId(String infoId) {
		this.infoId = infoId;
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

	/**
	 * @return the infoIds
	 */
	public String[] getInfoIds() {
		return infoIds;
	}

	/**
	 * @param infoIds the infoIds to set
	 */
	public void setInfoIds(String[] infoIds) {
		this.infoIds = infoIds;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	
	
}

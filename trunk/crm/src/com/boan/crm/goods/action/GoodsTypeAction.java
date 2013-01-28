/**
 * Copyright (c) 2012 Boan Co. Ltd.
 * All right reserved.
 * History
 */

package com.boan.crm.goods.action;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.boan.crm.goods.model.GoodsType;
import com.boan.crm.goods.service.IGoodsTypeService;
import com.boan.crm.utils.action.BaseActionSupport;


/**
 * 商品类别Action类
 * 
 * @author leon
 * @version 1.0.0
 */
@Controller("goodsTypeAction")
@Scope("prototype")
public class GoodsTypeAction extends BaseActionSupport {
	private static final long serialVersionUID = 3303030334845311756L;

	@Resource
	// 商品类别接口类
	private IGoodsTypeService goodsTypeService;
	
	// 商品类别对象
	private GoodsType goodsType = null;
	
	private List<GoodsType> goodsTypes = null;
	
	private String typeId = null;
	private String fatherId = null;
	private String name = null;
	private String remark = null;
	private Integer sortIndex = null;
	
	private String[] typeIds = null;
	
	private String message;
	
	/**
	 * 商品类别树集合
	 * @return
	 */
	public String goodsTypeTree(){
		goodsTypes = goodsTypeService.findAllGoodsType(sessionCompanyId);
		return SUCCESS;
	}
	
	/**
	 * 商品类别树集合
	 * @return
	 */
	public String goodsTypeList(){
		goodsTypes = goodsTypeService.findGoodsTypeByTypeId(sessionCompanyId, fatherId);
		return SUCCESS;
	}
	
	/**
	 * 获得商品类别信息
	 * @return
	 */
	public String goodsTypeInfo(){
		if(StringUtils.trimToNull(typeId)!=null)
			goodsType = goodsTypeService.get(typeId);
		else
			goodsType = new GoodsType();
		return SUCCESS;
	}
	
	/**
	 * 保存信息
	 * @return
	 */
	public String saveGoodsType(){
		if(StringUtils.trimToNull(typeId)!=null){
			goodsType = goodsTypeService.get(typeId);
			this.message = "保存成功！";
		}else{
			goodsType = new GoodsType();
			this.message = "添加成功！";
		}
		goodsType.setCompanyId(sessionCompanyId);
		goodsType.setFatherId(fatherId);
		goodsType.setName(name);
		goodsType.setRemark(remark);
		goodsType.setSortIndex(sortIndex);
		goodsTypeService.save(goodsType);
		typeId = goodsType.getId();
		return SUCCESS;
	}
	
	/**
	 * 删除信息
	 * @return
	 */
	public String deleteGoodsType(){
		if(typeIds!=null){
			goodsTypeService.delete(typeIds);
		}
		return SUCCESS;
	}
	
	/**
	 * 排序
	 * @return
	 */
	public String goodsTypeSort(){
		goodsTypes = goodsTypeService.findGoodsTypeByTypeId(sessionCompanyId, typeId);
		return SUCCESS;
	}
	
	/**
	 * 保存排序
	 * @return
	 */
	public String saveGoodsTypeSort(){
		if(typeIds!=null&&typeIds.length>0){
			GoodsType model = null;
			for(int i=0; i<typeIds.length; i++){
				model = goodsTypeService.get(typeIds[i]);
				model.setSortIndex(i);
				goodsTypeService.save(model);
			}
			this.message = "排序成功！";
		}
		return SUCCESS;
	}

	/**
	 * @return the goodsType
	 */
	public GoodsType getGoodsType() {
		return goodsType;
	}

	/**
	 * @param goodsType the goodsType to set
	 */
	public void setGoodsType(GoodsType goodsType) {
		this.goodsType = goodsType;
	}

	/**
	 * @return the goodsTypes
	 */
	public List<GoodsType> getGoodsTypes() {
		return goodsTypes;
	}

	/**
	 * @param goodsTypes the goodsTypes to set
	 */
	public void setGoodsTypes(List<GoodsType> goodsTypes) {
		this.goodsTypes = goodsTypes;
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
	 * @return the typeIds
	 */
	public String[] getTypeIds() {
		return typeIds;
	}

	/**
	 * @param typeIds the typeIds to set
	 */
	public void setTypeIds(String[] typeIds) {
		this.typeIds = typeIds;
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

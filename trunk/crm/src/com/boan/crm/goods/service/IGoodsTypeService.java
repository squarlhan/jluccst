package com.boan.crm.goods.service;

import java.util.List;
import java.util.Map;

import com.boan.crm.datadictionary.model.DataDictionary;
import com.boan.crm.goods.model.GoodsType;
import com.boan.crm.utils.page.Pagination;

/**
 * 商品服务类接口
 * 
 * @author leon
 * @version 1.0.0
 */
public interface IGoodsTypeService {
	/**
	 * 获得所有商品类别
	 */
	public List<GoodsType> findAllGoodsType(String companyId);
	/**
	 * 获得所有叶子商品类别
	 */
	public List<GoodsType> findAllLeafGoodsType(String companyId);

	/**
	 * 获得指定类别下商品类别
	 */
	public List<GoodsType> findGoodsTypeByTypeId(String companyId, String typeId);

	/**
	 * 根据id获取商品类别
	 */
	public GoodsType get(String id);

	/**
	 * 根据id删除商品类别
	 */
	public void delete(String... ids);

	/**
	 * 保存商品类别
	 */
	public void save(GoodsType goodsType);

	/**
	 * 按分页查询数据字典
	 */
	public Pagination<GoodsType> findGoodsTypeForPage(Map<String, ?> values,
			Pagination<GoodsType> pagination);
	
	
	/**
	 * 获得所有商品类别并且带有类别下的产品信息
	 */
	public List<GoodsType> findAllGoodsTypeHasGoodsInfo(String companyId);
}

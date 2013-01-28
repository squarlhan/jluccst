package com.boan.crm.goods.service;

import java.util.List;
import java.util.Map;

import com.boan.crm.goods.model.GoodsInfoBase;
import com.boan.crm.utils.page.Pagination;

/**
 * 商品服务类接口
 * 
 * @author leon
 * @version 1.0.0
 */
public interface IGoodsInfoBaseService {
	/**
	 * 根据id获取商品信息
	 */
	public GoodsInfoBase get(String id);

	/**
	 * 根据id删除商品类别
	 */
	public void delete(String... ids);

	/**
	 * 保存商品类别
	 */
	public void save(GoodsInfoBase goodsInfoBase);

	/**
	 * 按分页查询数据字典
	 */
	public Pagination<GoodsInfoBase> findGoodsInfoBaseForPage(Map<String, ?> values,
			Pagination<GoodsInfoBase> pagination);
}

/**
 * Copyright (c) 2012 Boan Co. Ltd.
 * All right reserved.
 * History
 */

package com.boan.crm.goods.dao;

import java.util.List;

import com.boan.crm.goods.model.GoodsType;
import com.boan.crm.utils.dao.IBaseDao;

/**
 * @author leon
 * @version 1.0.0
 */
public interface IGoodsTypeDao extends IBaseDao<GoodsType, String> {
	/**
	 * 获得所有叶子商品类别
	 */
	public List<GoodsType> findAllLeafGoodsType(String companyId);
}

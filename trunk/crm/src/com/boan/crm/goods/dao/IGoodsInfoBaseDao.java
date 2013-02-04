/**
 * Copyright (c) 2012 Boan Co. Ltd.
 * All right reserved.
 * History
 */

package com.boan.crm.goods.dao;

import java.util.List;

import com.boan.crm.goods.model.GoodsInfoBase;
import com.boan.crm.utils.dao.IBaseDao;

/**
 * @author leon
 * @version 1.0.0
 */
public interface IGoodsInfoBaseDao extends IBaseDao<GoodsInfoBase, String> {
	public List<GoodsInfoBase> findGoodsInfoBaseByGoodsTypeId(String goodsTypeId) ;
}

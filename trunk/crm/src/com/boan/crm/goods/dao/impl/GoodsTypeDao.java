/**
 * Copyright (c) 2012 Boan Co. Ltd.
 * All right reserved.
 * History
 */

package com.boan.crm.goods.dao.impl;

import org.springframework.stereotype.Repository;

import com.boan.crm.goods.dao.IGoodsTypeDao;
import com.boan.crm.goods.model.GoodsType;
import com.boan.crm.utils.dao.impl.BaseDao;

/**
 * @author leon
 * @version 1.0.0
 */
@Repository("goodsTypeDao")
public class GoodsTypeDao extends BaseDao<GoodsType, String>
		implements IGoodsTypeDao {
}

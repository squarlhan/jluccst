/**
 * Copyright (c) 2012 Boan Co. Ltd.
 * All right reserved.
 * History
 */

package com.boan.crm.goods.dao.impl;

import org.springframework.stereotype.Repository;

import com.boan.crm.goods.dao.IGoodsInfoBaseDao;
import com.boan.crm.goods.model.GoodsInfoBase;
import com.boan.crm.utils.dao.impl.BaseDao;

/**
 * @author leon
 * @version 1.0.0
 */
@Repository("goodsInfoBaseDao")
public class GoodsInfoBaseDao extends BaseDao<GoodsInfoBase, String>
		implements IGoodsInfoBaseDao {
}

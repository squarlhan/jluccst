/**
 * Copyright (c) 2012 Boan Co. Ltd.
 * All right reserved.
 * History
 */

package com.boan.crm.goods.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

	@Override
	public List<GoodsInfoBase> findGoodsInfoBaseByGoodsTypeId(String goodsTypeId) {
		String hql = "from GoodsInfoBase where typeId=:typeId";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("typeId", goodsTypeId);
		return this.find(hql, map);
	}
}

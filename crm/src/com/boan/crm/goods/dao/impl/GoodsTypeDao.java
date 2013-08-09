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

	@Override
	public List<GoodsType> findAllLeafGoodsType(String companyId) {
		Map<String, String> values = new HashMap<String, String>();
		values.put("companyId", companyId);
		String hql = "from GoodsType where companyId=:companyId and id not in( select fatherId from GoodsType where companyId=:companyId ) order by sortIndex";
		return  super.find( hql , values);
	}
}

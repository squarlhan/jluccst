package com.boan.crm.purchase.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.boan.crm.purchase.dao.IPurchaseBatchDao;
import com.boan.crm.purchase.model.PurchaseBatch;
import com.boan.crm.utils.dao.impl.BaseDao;

@Repository("purchaseBatchDao")
public class PurchaseBatchDaoImpl extends BaseDao<PurchaseBatch, String> implements IPurchaseBatchDao {

	@Override
	public List<PurchaseBatch> queryAllList(String companyId) throws Exception {
		String hql = "from PurchaseBatch where companyId = :companyId order by createTime";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("companyId", companyId);
		List<PurchaseBatch> list = super.find(hql, map);
		return list;
	}

}

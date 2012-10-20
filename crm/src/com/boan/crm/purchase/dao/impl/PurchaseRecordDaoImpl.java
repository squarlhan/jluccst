package com.boan.crm.purchase.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.boan.crm.purchase.dao.IPurchaseRecordDao;
import com.boan.crm.purchase.model.PurchaseRecord;
import com.boan.crm.utils.dao.impl.BaseDao;

@Repository("purchaseRecordDao")
public class PurchaseRecordDaoImpl extends BaseDao<PurchaseRecord, String> implements IPurchaseRecordDao {

	@Override
	public List<PurchaseRecord> queryAllList(String companyId) throws Exception {
		String hql = "from PurchaseRecord where companyId = :companyId order by createTime";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("companyId", companyId);
		List<PurchaseRecord> list = super.find(hql, map);
		return list;
	}

}

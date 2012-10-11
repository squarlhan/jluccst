package com.boan.crm.supplier.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.boan.crm.supplier.dao.ISupplierDao;
import com.boan.crm.supplier.model.Supplier;
import com.boan.crm.utils.dao.impl.BaseDao;
@Repository("supplierDao")
public class SupplierDaoImpl extends BaseDao<Supplier, String> implements ISupplierDao {

	@Override
	public List<Supplier> queryAllList(String companyId) throws Exception {
		String hql = "from Supplier where companyId = :companyId order by createTime";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("companyId", companyId);
		List<Supplier> list = super.find(hql, map);
		return list;
	}

}

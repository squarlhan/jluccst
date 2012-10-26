package com.boan.crm.finance.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.boan.crm.finance.dao.IFinanceDao;
import com.boan.crm.finance.model.Finance;
import com.boan.crm.utils.dao.impl.BaseDao;

@Repository("financeDao")
public class FinanceDaoImpl extends BaseDao<Finance, String> implements IFinanceDao {
	@Override
	public List<Finance> queryAllList(String companyId) throws Exception {
		String hql = "from Supplier where companyId = :companyId order by createTime";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("companyId", companyId);
		List<Finance> list = super.find(hql, map);
		return list;
	}

}

package com.boan.crm.finance.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.boan.crm.finance.dao.IFinanceDao;
import com.boan.crm.finance.model.Finance;
import com.boan.crm.finance.service.IFinanceService;
import com.boan.crm.utils.page.Pagination;

@Service("financeService")
public class FinanceServiceImpl implements IFinanceService {
	@Autowired
	@Qualifier("financeDao")
	IFinanceDao dao = null;

	@Override
	public Finance get(String id) {
		return dao.get(id);
	}

	@Override
	public void delete(String... ids) {
		dao.delete(ids);
	}

	@Override
	public void saveOrUpdate(Finance table1) {
		dao.saveOrUpdate(table1);
	}

	@Override
	public List<Finance> queryList(String companyId) throws Exception {
		return dao.queryAllList(companyId);
	}

	@Override
	public Pagination<Finance> findForPage(Map<String, ?> values, Pagination<Finance> pagination) {
		String hql = "from Finance where companyId = :companyId order by  createTime asc";
		List<Finance> data = dao.findForPage(hql, values, pagination.getStartIndex(), pagination.getPageSize());
		hql = "select count(*) from Finance  where companyId = :companyId ";
		int totalRows = dao.findCountForPage(hql, values);
		pagination.setTotalRows(totalRows);
		pagination.setData(data);
		return pagination;
	}

}

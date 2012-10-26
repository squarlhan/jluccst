package com.boan.crm.finance.service;

import java.util.List;
import java.util.Map;

import com.boan.crm.finance.model.Finance;
import com.boan.crm.utils.page.Pagination;

public interface IFinanceService {
	
	public Finance get(String id);

	public void delete(String... ids);

	public void saveOrUpdate(Finance table1);

	public List<Finance> queryList(String companyId) throws Exception;

	public Pagination<Finance> findForPage(Map<String, ?> values, Pagination<Finance> pagination);

}

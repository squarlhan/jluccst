package com.boan.crm.supplier.service;

import java.util.List;
import java.util.Map;

import com.boan.crm.supplier.model.Supplier;
import com.boan.crm.utils.page.Pagination;

public interface ISupplierService {
	
	public Supplier get(String id);

	public void delete(String... ids);

	public void save(Supplier table1);

	public void update(Supplier one);

	public List<Supplier> queryList(String companyId) throws Exception;

	public Pagination<Supplier> findForPage(Map<String, ?> values, Pagination<Supplier> pagination);
}

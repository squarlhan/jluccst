package com.boan.crm.purchase.service;

import java.util.List;
import java.util.Map;

import com.boan.crm.purchase.model.PurchaseBatch;
import com.boan.crm.utils.page.Pagination;

public interface IPurchaseBatchService {

	public PurchaseBatch get(String id);

	public void delete(String... ids);

	public void saveOrUpdate(PurchaseBatch table1);

	public List<PurchaseBatch> queryList(String companyId) throws Exception;

	public Pagination<PurchaseBatch> findForPage(Map<String, ?> values, Pagination<PurchaseBatch> pagination);
}

package com.boan.crm.purchase.service;

import java.util.List;
import java.util.Map;

import com.boan.crm.purchase.model.PurchaseRecord;
import com.boan.crm.utils.page.Pagination;

public interface IPurchaseRecordService {

	public PurchaseRecord get(String id);

	public void delete(String... ids);
	
	public void deleteByBatchIds(String... batchIds) throws Exception;

	public void saveOrUpdate(PurchaseRecord table1);

	public Pagination<PurchaseRecord> findForPage(Map<String, ?> values, Pagination<PurchaseRecord> pagination);
}

package com.boan.crm.purchase.service;

import java.util.Date;
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
	
	public Pagination<PurchaseRecord> findPorductDetailListForPage(Map<String, ?> values, Pagination<PurchaseRecord> pagination);
	
	public Object[] queryRecordSum(String batchId);
	/**
	 * 进货总额
	 * @param companyId
	 * @param beginDate
	 * @param endDate
	 * @return
	 */
	public float queryTotalAmountPurchase(String companyId, String beginDate, String endDate);
}

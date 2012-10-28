package com.boan.crm.purchase.dao;

import java.util.Date;
import java.util.List;

import com.boan.crm.purchase.model.PurchaseRecord;
import com.boan.crm.utils.dao.IBaseDao;

public interface IPurchaseRecordDao extends IBaseDao<PurchaseRecord, String> {

	/**
	 * 根据批次id删除采购记录
	 * 
	 * @param batchIds
	 * @throws Exception
	 */
	public void deleteByBatchIds(String... batchIds) throws Exception;
	/**
	 * 查询总和
	 * @return
	 */
	public Object[] queryRecordSum(String batchId);
	
	/**
	 * 财务清单列表
	 * @param companyId
	 * @param beginDate
	 * @param endDate
	 * @param financeListType
	 * @return
	 */
	public float queryFinanceList(String companyId, String beginDate, String endDate, String financeListType);
}

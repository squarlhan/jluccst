package com.boan.crm.purchase.dao;

import java.util.List;

import com.boan.crm.purchase.model.PurchaseRecord;
import com.boan.crm.utils.dao.IBaseDao;

public interface IPurchaseRecordDao extends IBaseDao<PurchaseRecord,String>{

	/**
	 * 取得所有列表
	 * 
	 * @return 列表
	 * @throws Exception
	 */
	public List<PurchaseRecord> queryAllList(String companyId) throws Exception;
}

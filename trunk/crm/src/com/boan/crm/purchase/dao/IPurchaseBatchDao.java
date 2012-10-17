package com.boan.crm.purchase.dao;

import java.util.List;

import com.boan.crm.purchase.model.PurchaseBatch;
import com.boan.crm.utils.dao.IBaseDao;

public interface IPurchaseBatchDao extends IBaseDao<PurchaseBatch,String>{

	/**
	 * 取得所有列表
	 * 
	 * @return 列表
	 * @throws Exception
	 */
	public List<PurchaseBatch> queryAllList(String companyId) throws Exception;
}

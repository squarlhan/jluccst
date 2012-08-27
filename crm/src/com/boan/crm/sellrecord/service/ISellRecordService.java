package com.boan.crm.sellrecord.service;

import com.boan.crm.sellrecord.model.SellRecord;

public interface ISellRecordService {

	/**
	 * 保存或就改销售记录相关信息
	 * @param record
	 */
	public void saveOrUpdate(SellRecord record);
}

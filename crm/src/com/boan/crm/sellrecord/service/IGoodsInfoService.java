package com.boan.crm.sellrecord.service;

import java.util.List;

import com.boan.crm.sellrecord.model.GoodsInfo;

public interface IGoodsInfoService {

	public void saveOrUpdate(GoodsInfo goodsInfo);
	
	public List<GoodsInfo> queryGoodsInfoByRecordId(String recordId);
}

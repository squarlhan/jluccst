package com.boan.crm.sellrecord.service.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.boan.crm.sellrecord.dao.ISellRecordDao;
import com.boan.crm.sellrecord.model.GoodsInfo;
import com.boan.crm.sellrecord.model.SellRecord;
import com.boan.crm.sellrecord.service.IGoodsInfoService;
import com.boan.crm.sellrecord.service.ISellRecordService;

@Service("sellRecordService")
public class SellRecordServiceImpl implements ISellRecordService {

	@Autowired
	@Qualifier("sellRecordDao")
	private ISellRecordDao sellRecordDao;
	
	@Autowired
	@Qualifier("goodsInfoService")
	private IGoodsInfoService goodsInfoService;
	
	/**
	 * 保存或就改销售记录相关信息
	 * @param record
	 */
	public void saveOrUpdate(SellRecord record){
		//保存或就改销售记录主信息
		sellRecordDao.saveOrUpdate(record);
		Set<GoodsInfo> detials = record.getGoodsDetials();
		for(GoodsInfo goodsInfo : detials){
			goodsInfo.setSellRecordId(record.getId());
			//保存或修改商品明细
			goodsInfoService.saveOrUpdate(goodsInfo);
		}
	}
}

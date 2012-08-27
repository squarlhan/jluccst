package com.boan.crm.sellrecord.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.boan.crm.sellrecord.dao.IGoodsInfoDao;
import com.boan.crm.sellrecord.model.GoodsInfo;
import com.boan.crm.sellrecord.service.IGoodsInfoService;

@Service("goodsInfoService")
public class GoodsInfoServiceImpl implements IGoodsInfoService {

	@Autowired
	@Qualifier("goodsInfoDao")
	private IGoodsInfoDao goodsInfoDao;
	
	public void saveOrUpdate(GoodsInfo goodsInfo){
		goodsInfoDao.saveOrUpdate(goodsInfo);
	}
}

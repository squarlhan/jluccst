package com.boan.crm.sellrecord.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	
	public List<GoodsInfo> queryGoodsInfoByRecordId(String recordId){
		Map<String, String> values = new HashMap<String, String>();
		values.put("sellRecordId", recordId);
		String hql = "from GoodsInfo obj where obj. sellRecordId=:sellRecordId";
		return goodsInfoDao.find( hql , values);
	}
	
	public void deleteGoodsInfoByIds(String... ids){
		goodsInfoDao.delete(ids);
	}
}

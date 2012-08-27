package com.boan.crm.sellrecord.dao.impl;

import org.springframework.stereotype.Repository;

import com.boan.crm.sellrecord.dao.IGoodsInfoDao;
import com.boan.crm.sellrecord.model.GoodsInfo;
import com.boan.crm.utils.dao.impl.BaseDao;

@Repository("goodsInfoDao")
public class GoodsInfoDaoImpl extends BaseDao<GoodsInfo, String> implements IGoodsInfoDao {

}

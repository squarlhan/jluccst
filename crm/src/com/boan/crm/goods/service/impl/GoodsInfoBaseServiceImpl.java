package com.boan.crm.goods.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.boan.crm.goods.dao.IGoodsInfoBaseDao;
import com.boan.crm.goods.model.GoodsInfoBase;
import com.boan.crm.goods.service.IGoodsInfoBaseService;
import com.boan.crm.utils.page.Pagination;

@Service("goodsInfoBaseService")
public class GoodsInfoBaseServiceImpl implements IGoodsInfoBaseService{
	@Autowired
	@Qualifier("goodsInfoBaseDao")
	private IGoodsInfoBaseDao goodsInfoBaseDao;

	@Override
	public GoodsInfoBase get(String id) {
		return goodsInfoBaseDao.get(id);
	}

	@Override
	public void delete(String... ids) {
		goodsInfoBaseDao.delete(ids);
	}

	@Override
	public void save(GoodsInfoBase goodsInfoBase) {
		goodsInfoBaseDao.saveOrUpdate(goodsInfoBase);
	}

	@Override
	public Pagination<GoodsInfoBase> findGoodsInfoBaseForPage(
			Map<String, ?> values, Pagination<GoodsInfoBase> pagination) {
		String hql = "from GoodsInfoBase where typeId=:typeId";
		List<GoodsInfoBase> data = goodsInfoBaseDao.findForPage(hql, values, pagination.getStartIndex(), pagination.getPageSize());
		hql = "select count(*) from GoodsInfoBase where typeId=:typeId";
		int totalRows = goodsInfoBaseDao.findCountForPage(hql, values);
		pagination.setTotalRows(totalRows);
		pagination.setData(data);
		return pagination;
	}

	
}

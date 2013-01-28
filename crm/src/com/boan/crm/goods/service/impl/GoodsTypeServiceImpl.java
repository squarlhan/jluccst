package com.boan.crm.goods.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.boan.crm.goods.dao.IGoodsTypeDao;
import com.boan.crm.goods.model.GoodsType;
import com.boan.crm.goods.service.IGoodsTypeService;
import com.boan.crm.utils.page.Pagination;

@Service("goodsTypeService")
public class GoodsTypeServiceImpl implements IGoodsTypeService{
	@Autowired
	@Qualifier("goodsTypeDao")
	private IGoodsTypeDao goodsTypeDao;

	@Override
	public List<GoodsType> findAllGoodsType(String companyId) {
		Map<String, String> values = new HashMap<String, String>();
		values.put("companyId", companyId);
		String hql = "from GoodsType where companyId=:companyId";
		return goodsTypeDao.find( hql , values);
	}

	@Override
	public List<GoodsType> findGoodsTypeByTypeId(String companyId, String typeId) {
		Map<String, String> values = new HashMap<String, String>();
		values.put("companyId", companyId);
		values.put("typeId", typeId);
		String hql = "from GoodsType where companyId=:companyId and fatherId=:typeId";
		return goodsTypeDao.find( hql , values);
	}

	@Override
	public GoodsType get(String id) {
		return goodsTypeDao.get(id);
	}

	@Override
	public void delete(String... ids) {
		goodsTypeDao.delete(ids);
	}

	@Override
	public void save(GoodsType goodsType) {
		goodsTypeDao.saveOrUpdate(goodsType);
	}

	@Override
	public Pagination<GoodsType> findGoodsTypeForPage(Map<String, ?> values,
			Pagination<GoodsType> pagination) {
		String hql = "from GoodsType";
		List<GoodsType> data = goodsTypeDao.findForPage(hql, values, pagination.getStartIndex(), pagination.getPageSize());
		hql = "select count(*) from GoodsType";
		int totalRows = goodsTypeDao.findCountForPage(hql, values);
		pagination.setTotalRows(totalRows);
		pagination.setData(data);
		return pagination;
	}
	
}

package com.boan.crm.purchase.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.boan.crm.purchase.dao.IPurchaseBatchDao;
import com.boan.crm.purchase.model.PurchaseBatch;
import com.boan.crm.purchase.service.IPurchaseBatchService;
import com.boan.crm.utils.page.Pagination;

@Service("purchaseBatchService")
public class PurchaseBatchServiceImpl implements IPurchaseBatchService {

	@Autowired
	@Qualifier("purchaseBatchDao")
	private IPurchaseBatchDao dao = null;

	@Override
	public PurchaseBatch get(String id) {
		return dao.get(id);
	}

	@Override
	public void delete(String... ids) {
		dao.delete(ids);
	}

	@Override
	public void saveOrUpdate(PurchaseBatch purchaseBatch) {
		dao.saveOrUpdate(purchaseBatch);
	}

	@Override
	public List<PurchaseBatch> queryList(String companyId) throws Exception {
		return dao.queryAllList(companyId);
	}

	@Override
	public Pagination<PurchaseBatch> findForPage(Map<String, ?> values, Pagination<PurchaseBatch> pagination) {
		String hql = "from PurchaseBatch where companyId = :companyId order by  createTime asc";
		List<PurchaseBatch> data = dao.findForPage(hql, values, pagination.getStartIndex(), pagination.getPageSize());
		hql = "select count(*) from PurchaseBatch  where companyId = :companyId ";
		int totalRows = dao.findCountForPage(hql, values);
		pagination.setTotalRows(totalRows);
		pagination.setData(data);
		return pagination;
	}

}

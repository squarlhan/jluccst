package com.boan.crm.purchase.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.boan.crm.purchase.dao.IPurchaseRecordDao;
import com.boan.crm.purchase.model.PurchaseRecord;
import com.boan.crm.purchase.service.IPurchaseRecordService;
import com.boan.crm.utils.page.Pagination;

@Service("purchaseRecordService")
public class PurchaseRecordServiceImpl implements IPurchaseRecordService {

	@Autowired
	@Qualifier("purchaseRecordDao")
	private IPurchaseRecordDao dao = null;

	@Override
	public PurchaseRecord get(String id) {
		return dao.get(id);
	}

	@Override
	public void delete(String... ids) {
		dao.delete(ids);
	}

	@Override
	public void saveOrUpdate(PurchaseRecord purchaseRecord) {
		dao.saveOrUpdate(purchaseRecord);
	}

	@Override
	public List<PurchaseRecord> queryList(String companyId) throws Exception {
		return dao.queryAllList(companyId);
	}

	@Override
	public Pagination<PurchaseRecord> findForPage(Map<String, ?> values, Pagination<PurchaseRecord> pagination) {
		String hql = "from PurchaseRecord where companyId = :companyId order by  createTime asc";
		List<PurchaseRecord> data = dao.findForPage(hql, values, pagination.getStartIndex(), pagination.getPageSize());
		hql = "select count(*) from PurchaseRecord  where companyId = :companyId ";
		int totalRows = dao.findCountForPage(hql, values);
		pagination.setTotalRows(totalRows);
		pagination.setData(data);
		return pagination;
	}

}

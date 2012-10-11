package com.boan.crm.supplier.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.boan.crm.groupmanage.model.Deptment;
import com.boan.crm.supplier.dao.ISupplierDao;
import com.boan.crm.supplier.model.Supplier;
import com.boan.crm.supplier.service.ISupplierService;
import com.boan.crm.utils.page.Pagination;

@Service("supplierService")
public class SupplierServiceImpl implements ISupplierService {

	@Autowired
	@Qualifier("supplierDao")
	private ISupplierDao dao = null;

	@Override
	public Supplier get(String id) {
		return dao.get(id);
	}

	@Override
	public void delete(String... ids) {
		dao.delete(ids);
	}

	@Override
	public void saveOrUpdate(Supplier supplier) {
		dao.saveOrUpdate(supplier);
	}

	@Override
	public List<Supplier> queryList(String companyId) throws Exception {
		return dao.queryAllList(companyId);
	}

	@Override
	public Pagination<Supplier> findForPage(Map<String, ?> values, Pagination<Supplier> pagination) {
		String hql = "from Supplier where companyId = :companyId order by  createTime asc";
		List<Supplier> data = dao.findForPage(hql, values, pagination.getStartIndex(), pagination.getPageSize());
		hql = "select count(*) from Supplier  where companyId = :companyId ";
		int totalRows = dao.findCountForPage(hql, values);
		pagination.setTotalRows(totalRows);
		pagination.setData(data);
		return pagination;
	}

}

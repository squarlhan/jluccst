package com.boan.crm.purchase.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.boan.crm.groupmanage.model.Role;
import com.boan.crm.purchase.dao.IInitRepertoryDao;
import com.boan.crm.purchase.model.InitRepertory;
import com.boan.crm.purchase.service.IInitRepertoryService;
import com.boan.crm.utils.page.Pagination;

@Service("initRepertoryService")
public class InitRepertoryServiceImpl implements IInitRepertoryService {

	@Autowired
	@Qualifier("initRepertoryDao")
	private IInitRepertoryDao dao = null;

	@Override
	public Pagination<InitRepertory> findForPage(Map<String, ?> values, Pagination<InitRepertory> pagination) {
		String hql = "from InitRepertory where companyId = :companyId ";
		List<InitRepertory> data = dao.findForPage(hql, values, pagination.getStartIndex(), pagination.getPageSize());
		hql = "select count(*) from InitRepertory where companyId = :companyId";
		int totalRows = dao.findCountForPage(hql, values);
		pagination.setTotalRows(totalRows);
		pagination.setData(data);
		return pagination;
	}

	@Override
	public InitRepertory get(String id) {
		return dao.get(id);
	}

	@Override
	public void delete(String... ids) {
		dao.delete(ids);
	}

	@Override
	public void save(InitRepertory table1) {
		dao.saveOrUpdate(table1);
	}

}

package com.boan.crm.purchase.service;

import java.util.Map;

import com.boan.crm.purchase.model.Repertory;
import com.boan.crm.utils.page.Pagination;

public interface IRepertoryService {
	/**
	 * 获取产品列表
	 * 
	 * @param values
	 * @param pagination
	 * @return
	 */
	public Pagination<Repertory> findForPage(Map<String, ?> values, Pagination<Repertory> pagination);
}

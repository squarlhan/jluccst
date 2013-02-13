package com.boan.crm.purchase.service;

import java.util.Map;

import com.boan.crm.purchase.model.InitRepertory;
import com.boan.crm.utils.page.Pagination;

public interface IInitRepertoryService {
	/**
	 * 获取产品列表
	 * 
	 * @param values
	 * @param pagination
	 * @return
	 */
	public Pagination<InitRepertory> findForPage(Map<String, ?> values, Pagination<InitRepertory> pagination);

	/**
	 * 获取
	 */
	public InitRepertory get(String id);

	/**
	 * 删除
	 */
	public void delete(String... ids);

	/**
	 * 保存角色
	 */
	public void save(InitRepertory table1);
}

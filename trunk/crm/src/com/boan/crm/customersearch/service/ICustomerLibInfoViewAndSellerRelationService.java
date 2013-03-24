/**
 * Copyright (c) 2013 Changchun CBIT Co. Ltd.
 * All right reserved.
 * History
 */
/*
 * @(#)ICustomerLibInfoViewAndSellerRelationService.java 1.1 2013-3-24
 */

package com.boan.crm.customersearch.service;

import java.util.List;

import com.boan.crm.customersearch.model.CustomerLibInfoViewAndSellerRelation;

/**
 * XXX 类
 * @author XXX
 * @version 1.0.0
 */
public interface ICustomerLibInfoViewAndSellerRelationService {

	/**
	 * 根据id获取客户销售员关系
	 */
	public CustomerLibInfoViewAndSellerRelation get(String id);

	/**
	 * 根据id删除客户销售员关系
	 */
	public void deleteCustomerLibInfoViewAndSellerRelation(String... ids);
	
	/**
	 * 根据客户id删除销售员关系
	 */
	public void deleteCustomerLibInfoViewAndSellerRelationByCustomerLibInfoViewId(String... ids);

	/**
	 * 保存客户销售员关系
	 */
	public void saveOrUpdate(CustomerLibInfoViewAndSellerRelation entity);
	
	/**
	 * 查询指定客户与销售员关系
	 */
	public List<CustomerLibInfoViewAndSellerRelation> queryCustomerLibInfoViewAndSellerRelation(String customerLibInfoViewId);
	
	/**
	 * 修改不再查询字段标识
	 */
	public void updateNoSearch(String sellerId , String customerLibInfoViewId);
}


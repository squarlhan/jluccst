/**
 * Copyright (c) 2013 Changchun CBIT Co. Ltd.
 * All right reserved.
 * History
 */
/*
 * @(#)ICustomerLibInfoViewAndSellerRelationServiceImpl.java 1.1 2013-3-24
 */

package com.boan.crm.customersearch.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.boan.crm.customersearch.dao.ICustomerLibInfoViewAndSellerRelationDAO;
import com.boan.crm.customersearch.model.CustomerLibInfoViewAndSellerRelation;
import com.boan.crm.customersearch.service.ICustomerLibInfoViewAndSellerRelationService;

/**
 * XXX 类
 * @author XXX
 * @version 1.0.0
 */
@Service("customerLibInfoViewAndSellerRelationService")
public class CustomerLibInfoViewAndSellerRelationServiceImpl  implements ICustomerLibInfoViewAndSellerRelationService{

	@Autowired
	@Qualifier("customerLibInfoViewAndSellerRelationDao")
	private ICustomerLibInfoViewAndSellerRelationDAO customerLibInfoViewAndSellerRelationDao;
	
	/**
	 * 根据id获取客户销售员关系
	 */
	public CustomerLibInfoViewAndSellerRelation get(String id){
		return customerLibInfoViewAndSellerRelationDao.get(id);
	}

	/**
	 * 根据id删除客户销售员关系
	 */
	public void deleteCustomerLibInfoViewAndSellerRelation(String... ids){
		customerLibInfoViewAndSellerRelationDao.delete(ids);
	}
	
	/**
	 * 根据客户id删除销售员关系
	 */
	public void deleteCustomerLibInfoViewAndSellerRelationByCustomerLibInfoViewId(String... ids){
		String hql="delete from CustomerLibInfoViewAndSellerRelation where customerLibInfoViewId in (:customerLibInfoViewId)";
		Map<String,String[]> param = new HashMap<String ,String[] >();
		param.put("customerLibInfoViewId", ids);
		customerLibInfoViewAndSellerRelationDao.executeHql(hql, param);
	}

	/**
	 * 保存客户销售员关系
	 */
	public void saveOrUpdate(CustomerLibInfoViewAndSellerRelation entity){
		customerLibInfoViewAndSellerRelationDao.saveOrUpdate(entity);
	}
	
	/**
	 * 查询指定客户与销售员关系
	 */
	public List<CustomerLibInfoViewAndSellerRelation> queryCustomerLibInfoViewAndSellerRelation(String customerLibInfoViewId){
		String hql="from CustomerLibInfoViewAndSellerRelation where customerLibInfoViewId=:customerLibInfoViewId";
		Map<String,String> param = new HashMap<String ,String >();
		param.put("customerLibInfoViewId", customerLibInfoViewId);
		return customerLibInfoViewAndSellerRelationDao.find(hql, param);
	}
	
	/**
	 * 修改不再查询字段标识
	 */
	public void updateNoSearch(String sellerId , String customerLibInfoViewId){
		String hql="update  CustomerLibInfoViewAndSellerRelation set noSearch=1  where customerLibInfoViewId=:customerLibInfoViewId and sellerId=:sellerId ";
		Map<String,String> param = new HashMap<String ,String >();
		param.put("customerLibInfoViewId", customerLibInfoViewId);
		param.put("sellerId", sellerId);
		customerLibInfoViewAndSellerRelationDao.executeHql(hql, param);
	}
}


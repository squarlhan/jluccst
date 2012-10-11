package com.boan.crm.supplier.dao;

import java.util.List;

import com.boan.crm.supplier.model.Supplier;
import com.boan.crm.utils.dao.IBaseDao;

public interface ISupplierDao extends IBaseDao<Supplier,String>{

	/**
	 * 取得所有角色列表
	 * 
	 * @return 角色列表
	 * @throws Exception
	 */
	public List<Supplier> queryAllList(String companyId) throws Exception;
}

package com.boan.crm.finance.dao;

import java.util.List;

import com.boan.crm.finance.model.Finance;
import com.boan.crm.utils.dao.IBaseDao;

public interface IFinanceDao extends IBaseDao<Finance, String> {
	/**
	 * 取得所有角色列表
	 * 
	 * @return 角色列表
	 * @throws Exception
	 */
	public List<Finance> queryAllList(String companyId) throws Exception;
}

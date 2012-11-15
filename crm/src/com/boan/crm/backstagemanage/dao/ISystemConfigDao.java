package com.boan.crm.backstagemanage.dao;

public interface ISystemConfigDao {
	/**
	 * 删除表数据
	 * 
	 * @throws Exception
	 */
	public void deleteAllTableData() throws Exception;

	/**
	 * 录入表数据
	 * 
	 * @param sqls
	 * @throws Exception
	 */
	public void saveInitTableData(String[] sqls) throws Exception;
}

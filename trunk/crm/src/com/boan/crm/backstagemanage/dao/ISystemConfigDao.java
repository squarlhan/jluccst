package com.boan.crm.backstagemanage.dao;

import java.util.List;

public interface ISystemConfigDao {
	/**
	 * 删除表数据
	 * 
	 * @throws Exception
	 */
	public void deleteAllTableData() throws Exception;
	/**
	 * 删除表数据，除了一些表
	 * @param list
	 * @throws Exception
	 */
	public void deleteTableDataExceptTables(List<String> tableList, List<String> preRules) throws Exception;
	/**
	 * 录入表数据
	 * 
	 * @param sqls
	 * @throws Exception
	 */
	public void saveInitTableData(String[] sqls) throws Exception;
}

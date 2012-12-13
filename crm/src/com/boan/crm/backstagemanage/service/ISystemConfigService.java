package com.boan.crm.backstagemanage.service;

import java.util.List;

public interface ISystemConfigService {
	/**
	 * 删除表数据
	 * 
	 * @throws Exception
	 */
	public void deleteAllTableData() throws Exception;
	
	/**
	 * 删除表数据除了一些表
	 * 
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

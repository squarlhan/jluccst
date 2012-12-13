package com.boan.crm.backstagemanage.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.boan.crm.backstagemanage.dao.ISystemConfigDao;
import com.boan.crm.backstagemanage.service.ISystemConfigService;
@Service("systemConfigService")
public class SystemConfigServiceImpl implements ISystemConfigService {
	@Autowired
	@Qualifier("systemConfigDao")
	private ISystemConfigDao dao = null;

	@Override
	public void deleteAllTableData() throws Exception {
		dao.deleteAllTableData();
	}

	@Override
	public void saveInitTableData(String[] sqls) throws Exception {
		dao.saveInitTableData(sqls);
	}

	@Override
	public void deleteTableDataExceptTables(List<String> tableList, List<String> preRules) throws Exception {
		dao.deleteTableDataExceptTables(tableList,preRules);
	}

}

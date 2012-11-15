package com.boan.crm.backstagemanage.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.boan.crm.backstagemanage.dao.ISystemConfigDao;
import com.boan.crm.utils.dao.impl.BaseDao;

@Repository("systemConfigDao")
public class SystemConfigDaoImpl extends BaseDao<Object, String> implements ISystemConfigDao {

	@Override
	public void deleteAllTableData() throws Exception {
		String sql = "show TABLES;";
		List<String> list = super.findAllBySQL(sql, null);
		if (list != null && list.size() > 0) {
			String tableName = null;
			for (int i = 0; i < list.size(); i++) {
				tableName = (String) list.get(i);
				sql = "truncate table " + tableName + ";";
				super.executeSql(sql, null);
			}
		}

	}

	@Override
	public void saveInitTableData(String[] sqls) throws Exception {
		if (sqls != null && sqls.length > 0) {
			for (int i = 0; i < sqls.length; i++) {
				super.executeSql(sqls[i], null);
			}
		}
	}
}

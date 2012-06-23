package com.boan.crm.datadictionary.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.boan.crm.datadictionary.dao.IDataDictionaryDao;
import com.boan.crm.datadictionary.model.DataDictionary;
import com.boan.crm.datadictionary.service.IDataDictionaryService;
import com.boan.crm.utils.page.Pagination;

@Service("dataDictionaryService")
public class DataDictionaryServiceImpl implements IDataDictionaryService{
	
	@Autowired
	@Qualifier("dataDictionaryDao")
	private IDataDictionaryDao dataDictionaryDao;

	@Override
	public void deleteDataDictionary(String... ids) {
		dataDictionaryDao.delete(ids);
	}

	@Override
	public List<DataDictionary> findAllDataDictionary() {
		return dataDictionaryDao.find("from DataDictionary order by sortIndex asc", new Object[0]);
	}

	@Override
	public Pagination<DataDictionary> findDataDictionaryForPage(
			Map<String, ?> values, Pagination<DataDictionary> pagination) {
		String hql = "from DataDictionary order by sortIndex asc";
		List<DataDictionary> data = dataDictionaryDao.findForPage(hql, values, pagination.getStartIndex(), pagination.getPageSize());
		hql = "select count(*) from DataDictionary order by sortIndex asc";
		int totalRows = dataDictionaryDao.findCountForPage(hql, values);
		pagination.setTotalRows(totalRows);
		pagination.setData(data);
		return pagination;
	}

	@Override
	public DataDictionary get(String id) {
		return dataDictionaryDao.get(id);
	}

	@Override
	public void save(DataDictionary table1) {
		dataDictionaryDao.saveOrUpdate(table1);
	}

	@Override
	public List<DataDictionary> findDataDictionaryByType(Integer typeFlag) {
		return dataDictionaryDao.find("from DataDictionary where typeFlag=? order by sortIndex asc", new Object[]{typeFlag});
	}
	
}

package com.boan.crm.datadictionary.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.boan.crm.datadictionary.dao.IAreaInfoDao;
import com.boan.crm.datadictionary.dao.ICityInfoDao;
import com.boan.crm.datadictionary.dao.IDataDictionaryDao;
import com.boan.crm.datadictionary.dao.IProvinceInfoDao;
import com.boan.crm.datadictionary.model.AreaInfo;
import com.boan.crm.datadictionary.model.CityInfo;
import com.boan.crm.datadictionary.model.DataDictionary;
import com.boan.crm.datadictionary.model.ProvinceInfo;
import com.boan.crm.datadictionary.service.IAreaService;
import com.boan.crm.datadictionary.service.IDataDictionaryService;
import com.boan.crm.utils.page.Pagination;

@Service("areaService")
public class AreaServiceImpl implements IAreaService{
	
	@Autowired
	@Qualifier("provinceInfoDao")
	private IProvinceInfoDao provinceInfoDao;
	@Autowired
	@Qualifier("cityInfoDao")
	private ICityInfoDao cityInfoDao;
	@Autowired
	@Qualifier("areaInfoDao")
	private IAreaInfoDao areaInfoDao;
	
	@Override
	public void deleteProvince(String... ids) {
		provinceInfoDao.delete(ids);
	}
	@Override
	public void deleteCity(String... ids) {
		cityInfoDao.delete(ids);
	}
	@Override
	public void deleteArea(String... ids) {
		areaInfoDao.delete(ids);
	}
	@Override
	public ProvinceInfo getProvinceByName(String name)
	{
		Map<String, String> values = new HashMap<String, String>();
		values.put("provinceName", "%"+name+"%");
		List<ProvinceInfo> list =  provinceInfoDao.find("from ProvinceInfo where provinceName like :provinceName", values);
		if(list != null && list.size() > 0)
		{
			return list.get(0);
		}
		return null;
	}
	@Override
	public CityInfo getCityByNameAndProvinceId(String name,String provinceId)
	{
		Map<String, String> values = new HashMap<String, String>();
		values.put("cityName", "%"+name+"%");
		values.put("provinceId", provinceId);
		List<CityInfo> list =  provinceInfoDao.find("from CityInfo where provinceId = :provinceId and cityName like :cityName", values);
		if(list != null && list.size() > 0)
		{
			return list.get(0);
		}
		return null;
	}
	@Override
	public CityInfo getCityByName(String name)
	{
		Map<String, String> values = new HashMap<String, String>();
		values.put("cityName", "%"+name+"%");
		List<CityInfo> list =  provinceInfoDao.find("from CityInfo where cityName like :cityName", values);
		if(list != null && list.size() > 0)
		{
			return list.get(0);
		}
		return null;
	}
	@Override
	public AreaInfo getAreaByName(String name)
	{
		Map<String, String> values = new HashMap<String, String>();
		values.put("areaName", "%"+name+"%");
		List<AreaInfo> list =  provinceInfoDao.find("from AreaInfo where areaName like :areaName", values);
		if(list != null && list.size() > 0)
		{
			return list.get(0);
		}
		return null;
	}
	@Override
	public AreaInfo getAreaByNameAndCityId(String name,String cityId)
	{
		Map<String, String> values = new HashMap<String, String>();
		values.put("areaName", "%"+name+"%");
		values.put("cityId", cityId);
		List<AreaInfo> list =  provinceInfoDao.find("from AreaInfo where cityId = :cityId and areaName like :areaName", values);
		if(list != null && list.size() > 0)
		{
			return list.get(0);
		}
		return null;
	}
	@Override
	public List<ProvinceInfo> findAllProvinceInfo() {
		return provinceInfoDao.find("from ProvinceInfo order by sortIndex asc", new Object[0]);
	}
	
	@Override
	public List<CityInfo> findAllCityInfo() {
		return cityInfoDao.find("from CityInfo order by sortIndex asc", new Object[0]);
	}
	
	@Override
	public List<AreaInfo> findAreaInfoByCityId(String cityId) {
		Map<String, String> values = new HashMap<String, String>();
		values.put("cityId", cityId);
		return areaInfoDao.find("from AreaInfo where cityId = :cityId order by sortIndex asc", values);
	}
	
	@Override
	public List<CityInfo> findCityInfoByProvinceId(String provinceId) {
		Map<String, String> values = new HashMap<String, String>();
		values.put("provinceId", provinceId);
		return cityInfoDao.find("from CityInfo where provinceId = :provinceId order by sortIndex asc", values);
	}

	@Override
	public Pagination<ProvinceInfo> findProvinceInfoForPage(
			Map<String, ?> values, Pagination<ProvinceInfo> pagination) {
		String hql = "from ProvinceInfo order by sortIndex asc";
		List<ProvinceInfo> data = provinceInfoDao.findForPage(hql, values, pagination.getStartIndex(), pagination.getPageSize());
		hql = "select count(*) from ProvinceInfo order by sortIndex asc";
		int totalRows = provinceInfoDao.findCountForPage(hql, values);
		pagination.setTotalRows(totalRows);
		pagination.setData(data);
		return pagination;
	}
	@Override
	public Pagination<CityInfo> findCityInfoForPage(
			Map<String, ?> values, Pagination<CityInfo> pagination) {
		String hql = "from CityInfo where provinceId =:provinceId order by sortIndex asc";
		List<CityInfo> data = cityInfoDao.findForPage(hql, values, pagination.getStartIndex(), pagination.getPageSize());
		hql = "select count(*) from CityInfo where provinceId =:provinceId order by sortIndex asc";
		int totalRows = cityInfoDao.findCountForPage(hql, values);
		pagination.setTotalRows(totalRows);
		pagination.setData(data);
		return pagination;
	}
	@Override
	public Pagination<AreaInfo> findAreaInfoForPage(
			Map<String, ?> values, Pagination<AreaInfo> pagination) {
		String hql = "from AreaInfo where cityId = :cityId order by sortIndex asc";
		List<AreaInfo> data = provinceInfoDao.findForPage(hql, values, pagination.getStartIndex(), pagination.getPageSize());
		hql = "select count(*) from AreaInfo  where cityId = :cityId order by sortIndex asc";
		int totalRows = provinceInfoDao.findCountForPage(hql, values);
		pagination.setTotalRows(totalRows);
		pagination.setData(data);
		return pagination;
	}
	@Override
	public ProvinceInfo getProvince(String id) {
		return provinceInfoDao.get(id);
	}
	@Override
	public CityInfo getCity(String cityId) {
		return cityInfoDao.get(cityId);
	}
	@Override
	public AreaInfo getArea(String id) {
		return areaInfoDao.get(id);
	}

	@Override
	public void save(ProvinceInfo provinceInfo) {
		provinceInfoDao.saveOrUpdate(provinceInfo);
	}
	@Override
	public void save(CityInfo cityInfo) {
		cityInfoDao.saveOrUpdate(cityInfo);
	}
	@Override
	public void save(AreaInfo areaInfo) {
		areaInfoDao.saveOrUpdate(areaInfo);
	}

	
}

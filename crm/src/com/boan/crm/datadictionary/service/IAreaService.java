package com.boan.crm.datadictionary.service;

import java.util.List;
import java.util.Map;

import com.boan.crm.datadictionary.model.AreaInfo;
import com.boan.crm.datadictionary.model.CityInfo;
import com.boan.crm.datadictionary.model.DataDictionary;
import com.boan.crm.datadictionary.model.ProvinceInfo;
import com.boan.crm.utils.page.Pagination;


/**
 * 省市地区服务类接口
 * 
 * @author luojx
 * @version 1.0.0
 */
public interface IAreaService {
	/**
	 * 查找全部省信息
	 */
	public List<ProvinceInfo> findAllProvinceInfo();
	public List<CityInfo>  findAllCityInfo();
	/**
	 * 根据省查找市信息
	 */
	public List<CityInfo> findCityInfoByProvinceId(String provinceId);

	/**
	 * 根据市查找地区信息
	 */
	public List<AreaInfo> findAreaInfoByCityId(String cityId);
	
	public ProvinceInfo getProvince(String id);
	
	public CityInfo getCity(String cityId);
	
	public AreaInfo getArea(String areaId);
	
	public ProvinceInfo getProvinceByName(String name);
	
	public CityInfo getCityByName(String name);
	public CityInfo getCityByNameAndProvinceId(String name,String provinceId);
	
	public AreaInfo getAreaByName(String name);
	public AreaInfo getAreaByNameAndCityId(String name,String cityId);
	/**
	 * 根据id删除数据字典
	 */
	public void deleteProvince(String... ids);
	public void deleteCity(String... ids);
	public void deleteArea(String... ids);
	/**
	 * 保存数据字典
	 */
	public void save(ProvinceInfo provinceInfo);
	public void save(CityInfo cityInfo);
	public void save(AreaInfo areaInfo);
	/**
	 * 按分页查询数据字典
	 */
	public Pagination<ProvinceInfo> findProvinceInfoForPage(
			Map<String, ?> values, Pagination<ProvinceInfo> pagination);
	public Pagination<CityInfo> findCityInfoForPage(
			Map<String, ?> values, Pagination<CityInfo> pagination);
	public Pagination<AreaInfo> findAreaInfoForPage(
			Map<String, ?> values, Pagination<AreaInfo> pagination);
}

/**
 * Copyright (c) 2012 Boan Co. Ltd.
 * All right reserved.
 * History
 */

package com.boan.crm.datadictionary.action;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.boan.crm.datadictionary.model.AreaInfo;
import com.boan.crm.datadictionary.model.CityInfo;
import com.boan.crm.datadictionary.model.ProvinceInfo;
import com.boan.crm.datadictionary.service.IAreaService;
import com.boan.crm.utils.action.BaseActionSupport;


/**
 * 省市地区Action类
 * 
 * @author luojx
 * @version 1.0.0
 */
@Controller("areaAction")
@Scope("prototype")
public class AreaAction extends BaseActionSupport {
	private static final long serialVersionUID = -8330905492715338520L;

	@Resource
	// 客户状态接口类
	private IAreaService areaService;
	
	//客户状态对象
	private ProvinceInfo provinceInfo = null;
	private CityInfo cityInfo = null;
	private AreaInfo areaInfo = null;
	List<ProvinceInfo> provinceList = null;
	List<CityInfo> cityList = null;
	List<AreaInfo> areaList = null;
	
	private String provinceId;
	private String cityId;
	private String areaId;
	private String provinceName;
	private String cityName;
	private String areaName;
	
	private String[] provinceIds;
	private String[] cityIds;
	private String[] areaIds;
	
	/**
	 * 客户类别集合
	 * @return
	 */
	public String provinceList(){
		provinceList = areaService.findAllProvinceInfo();
		return SUCCESS;
	}
	public String provinceCityList()
	{
		provinceList = areaService.findAllProvinceInfo();
		cityList = areaService.findAllCityInfo();
		return SUCCESS;
	}
	public String cityList(){
		cityList = areaService.findCityInfoByProvinceId(provinceId);
		return SUCCESS;
	}
	public String areaList(){
		areaList = areaService.findAreaInfoByCityId(cityId);
		return SUCCESS;
	}
	/**
	 * 获得数据字典信息
	 * @return
	 */
	public String provinceInfo(){
		if(StringUtils.trimToNull(provinceId)!=null)
			provinceInfo = areaService.getProvince(provinceId);
		else
			provinceInfo = new ProvinceInfo();
		return SUCCESS;
	}
	public String cityInfo(){
		if(StringUtils.trimToNull(cityId)!=null)
			cityInfo = areaService.getCity(cityId);
		else
			cityInfo = new CityInfo();
		return SUCCESS;
	}
	public String areaInfo(){
		if(StringUtils.trimToNull(areaId)!=null)
			areaInfo = areaService.getArea(areaId);
		else
			areaInfo = new AreaInfo();
		return SUCCESS;
	}
	/**
	 * 保存信息
	 * @return
	 */
	public String saveProvince(){
		if(StringUtils.trimToNull(provinceId)!=null)
			provinceInfo = areaService.getProvince(provinceId);
		else
			provinceInfo = new ProvinceInfo();
		provinceInfo.setProvinceName(provinceName);
		areaService.save(provinceInfo);
		provinceId = provinceInfo.getId();
		return SUCCESS;
	}
	public String saveCity(){
		if(StringUtils.trimToNull(cityId)!=null)
			cityInfo = areaService.getCity(cityId);
		else
			cityInfo = new CityInfo();
		cityInfo.setCityName(cityName);
		cityInfo.setProvinceId(provinceId);
		areaService.save(cityInfo);
		cityId = cityInfo.getId();
		return SUCCESS;
	}
	public String saveArea(){
		if(StringUtils.trimToNull(areaId)!=null)
			areaInfo = areaService.getArea(areaId);
		else
			areaInfo = new AreaInfo();
		areaInfo.setAreaName(areaName);
		areaInfo.setCityId(cityId);
		areaService.save(areaInfo);
		areaId = areaInfo.getId();
		return SUCCESS;
	}
	/**
	 * 删除数据字典信息
	 * @return
	 */
	public String deleteProvince(){
		if(provinceIds!=null){
			areaService.deleteProvince(provinceIds);
		}
		return SUCCESS;
	}
	public String deleteCity(){
		if(cityIds!=null){
			areaService.deleteCity(cityIds);
		}
		return SUCCESS;
	}
	public String deleteArea(){
		if(areaIds!=null){
			areaService.deleteArea(areaIds);
		}
		return SUCCESS;
	}
	/**
	 * 排序
	 * @return
	 */
	public String provinceSort(){
		provinceList = areaService.findAllProvinceInfo();
		return SUCCESS;
	}
	public String citySort(){
		cityList = areaService.findCityInfoByProvinceId(provinceId);
		return SUCCESS;
	}
	public String areaSort(){
		areaList = areaService.findAreaInfoByCityId(cityId);
		return SUCCESS;
	}
	/**
	 * 保存排序
	 * @return
	 */
	public String saveProvinceSort(){
		if(provinceIds!=null&&provinceIds.length>0){
			ProvinceInfo province = null;
			for(int i=0; i<provinceIds.length; i++){
				province = areaService.getProvince(provinceIds[i]);
				province.setSortIndex(i);
				areaService.save(province);
			}
		}
		return SUCCESS;
	}
	public String saveCitySort(){
		if(cityIds!=null&& cityIds.length>0){
			CityInfo cityInfo = null;
			for(int i=0; i<cityIds.length; i++){
				cityInfo = areaService.getCity(cityIds[i]);
				cityInfo.setSortIndex(i);
				areaService.save(cityInfo);
			}
		}
		return SUCCESS;
	}
	public String saveAreaSort(){
		if(areaIds!=null&& areaIds.length>0){
			AreaInfo areaInfo = null;
			for(int i=0; i<areaIds.length; i++){
				areaInfo = areaService.getArea(areaIds[i]);
				areaInfo.setSortIndex(i);
				areaService.save(areaInfo);
			}
		}
		return SUCCESS;
	}
	public ProvinceInfo getProvinceInfo() {
		return provinceInfo;
	}
	public void setProvinceInfo(ProvinceInfo provinceInfo) {
		this.provinceInfo = provinceInfo;
	}
	public CityInfo getCityInfo() {
		return cityInfo;
	}
	public void setCityInfo(CityInfo cityInfo) {
		this.cityInfo = cityInfo;
	}
	public AreaInfo getAreaInfo() {
		return areaInfo;
	}
	public void setAreaInfo(AreaInfo areaInfo) {
		this.areaInfo = areaInfo;
	}
	public List<ProvinceInfo> getProvinceList() {
		return provinceList;
	}
	public void setProvinceList(List<ProvinceInfo> provinceList) {
		this.provinceList = provinceList;
	}
	public List<CityInfo> getCityList() {
		return cityList;
	}
	public void setCityList(List<CityInfo> cityList) {
		this.cityList = cityList;
	}
	public List<AreaInfo> getAreaList() {
		return areaList;
	}
	public void setAreaList(List<AreaInfo> areaList) {
		this.areaList = areaList;
	}
	public String getProvinceId() {
		return provinceId;
	}
	public void setProvinceId(String provinceId) {
		this.provinceId = provinceId;
	}
	public String getCityId() {
		return cityId;
	}
	public void setCityId(String cityId) {
		this.cityId = cityId;
	}
	public String getAreaId() {
		return areaId;
	}
	public void setAreaId(String areaId) {
		this.areaId = areaId;
	}
	public String getProvinceName() {
		return provinceName;
	}
	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getAreaName() {
		return areaName;
	}
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	public String[] getProvinceIds() {
		return provinceIds;
	}
	public void setProvinceIds(String[] provinceIds) {
		this.provinceIds = provinceIds;
	}
	public String[] getCityIds() {
		return cityIds;
	}
	public void setCityIds(String[] cityIds) {
		this.cityIds = cityIds;
	}
	public String[] getAreaIds() {
		return areaIds;
	}
	public void setAreaIds(String[] areaIds) {
		this.areaIds = areaIds;
	}
	
	
}

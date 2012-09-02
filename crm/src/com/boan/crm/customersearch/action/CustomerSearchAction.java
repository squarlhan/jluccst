package com.boan.crm.customersearch.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.boan.crm.customer.model.ContractPersonInfo;
import com.boan.crm.customer.model.CustomerInfo;
import com.boan.crm.customer.service.IContractPersonService;
import com.boan.crm.customer.service.ICustomerInfoService;
import com.boan.crm.customersearch.model.ContractPersonLibInfo;
import com.boan.crm.customersearch.model.CustomerLibInfo;
import com.boan.crm.customersearch.service.IContractPersonLibService;
import com.boan.crm.customersearch.service.ICustomerLibInfoService;
import com.boan.crm.datadictionary.model.AreaInfo;
import com.boan.crm.datadictionary.model.CityInfo;
import com.boan.crm.datadictionary.model.ProvinceInfo;
import com.boan.crm.datadictionary.service.IAreaService;
import com.boan.crm.utils.action.BaseActionSupport;
import com.boan.crm.utils.page.Pagination;

@Controller("customerSearchAction")
@Scope("prototype")
public class CustomerSearchAction  extends BaseActionSupport{

	@Autowired
	@Qualifier("customerLibInfoService")
	//客户状态接口类
	private ICustomerLibInfoService customerInfoService;
	
	@Autowired
	@Qualifier("customerInfoService")
	//客户状态接口类
	private ICustomerInfoService customerService;
	
	// 客户状态接口类
	@Autowired
	@Qualifier("contractPersonService")
	private IContractPersonService contractpersonInfoService;
	
	// 客户状态接口类
	@Autowired
	@Qualifier("contractPersonLibService")
	private IContractPersonLibService contractpersonService;
		
	@Resource
	// 客户状态接口类
	private IAreaService areaService;
	
	private CustomerLibInfo customerLibInfo;
	
	private Pagination<CustomerLibInfo> pagination = new Pagination<CustomerLibInfo>();
	
	private String message;
	private String mainIndustry;
	List<ProvinceInfo> provinceList   = new ArrayList();
	List<CityInfo> cityList  = new ArrayList();
	List<AreaInfo> areaList   = new ArrayList();
	private String provinceId;
	private String cityId;
	private String areaId;
	
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

	/**
	 * 查询客户
	 * @return
	 */
	public String customerSearch(){
		
		provinceList = areaService.findAllProvinceInfo();
		Map<String,String> values = new HashMap<String,String>();
	
		if(mainIndustry!=null && !mainIndustry.trim().equals("")){
			values.put("mainIndustry", mainIndustry);
		}
		if(provinceId!=null && !provinceId.trim().equals("")){
			values.put("provinceId", provinceId);
		}
		if(cityId!=null && !cityId.trim().equals("")){
			values.put("cityId", cityId);
		}
		
		pagination = customerInfoService.findCustomerLibInfoForPage(values, pagination);
		if(provinceId!=null){
			cityList = areaService.findCityInfoByProvinceId(provinceId);
		}
		if(cityId!=null){
			areaList = areaService.findAreaInfoByCityId(cityId);
		}
		return SUCCESS;
	}
	
	/**
	 * 转为客户
	 * @return
	 */
	public String toCustomer(){
		customerLibInfo = customerInfoService.get(customerLibInfo.getId());
		List<ContractPersonLibInfo> contractPersonInfoList = contractpersonService.findAllContractPersonLibInfoByCustomerId(customerLibInfo.getId());
		
		CustomerInfo customerInfo = new CustomerInfo();
		customerService.save(customerInfo);
		for(ContractPersonLibInfo temp : contractPersonInfoList){
			ContractPersonInfo contractPersonInfo = new ContractPersonInfo();
			contractpersonInfoService.save(contractPersonInfo);
		}
		return SUCCESS;
	}
	
	public String getCity(){
		cityList = areaService.findCityInfoByProvinceId(provinceId);
		return SUCCESS;
	}
	public String getArea(){
		areaList = areaService.findAreaInfoByCityId(cityId);
		return SUCCESS;
	}

	public Pagination<CustomerLibInfo> getPagination() {
		return pagination;
	}

	public void setPagination(Pagination<CustomerLibInfo> pagination) {
		this.pagination = pagination;
	}

	public String getMainIndustry() {
		return mainIndustry;
	}

	public void setMainIndustry(String mainIndustry) {
		this.mainIndustry = mainIndustry;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public CustomerLibInfo getCustomerLibInfo() {
		return customerLibInfo;
	}

	public void setCustomerLibInfo(CustomerLibInfo customerLibInfo) {
		this.customerLibInfo = customerLibInfo;
	}
}

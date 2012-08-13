/**
 * 
 */
package com.boan.crm.customer.action;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.boan.crm.customer.model.ContractPersonInfo;
import com.boan.crm.customer.model.CustomerInfo;
import com.boan.crm.customer.service.IContractPersonService;
import com.boan.crm.customer.service.ICustomerInfoService;
import com.boan.crm.datadictionary.model.AreaInfo;
import com.boan.crm.datadictionary.model.CityInfo;
import com.boan.crm.datadictionary.model.DataDictionary;
import com.boan.crm.datadictionary.model.ProvinceInfo;
import com.boan.crm.datadictionary.service.IAreaService;
import com.boan.crm.datadictionary.service.IDataDictionaryService;
import com.boan.crm.groupmanage.service.IPopedomService;
import com.boan.crm.utils.action.BaseActionSupport;
import com.boan.crm.utils.page.Pagination;

/**
 * @author luojx
 * 客户信息action
 */
@Controller("customerInfoAction")
@Scope("prototype")
public class CustomerInfoAction extends BaseActionSupport{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4140371188076904836L;
	
	@Autowired
	@Qualifier("customerInfoService")
	//客户状态接口类
	private ICustomerInfoService customerInfoService;
	
	/**
	 * 权限接口
	 */
	@Autowired
	@Qualifier("dataDictionaryService")
	private IDataDictionaryService dataDictionaryService = null;
	
	/**
	 * 权限接口
	 */
	@Autowired
	@Qualifier("areaService")
	private IAreaService areaService = null;
	
	// 客户状态接口类
	@Autowired
	@Qualifier("contractPersonService")
	private IContractPersonService contractpersonInfoService;
	//客户信息类
	private CustomerInfo customerInfo ;
	private String id = "";
	private String[] ids = null;
	private Pagination<CustomerInfo> pagination = new Pagination<CustomerInfo>();
	private List<DataDictionary> listCategory = null;
	private List<DataDictionary> listSource = null;
	private List<DataDictionary> listProgress = null;
	private List<DataDictionary> listMaturity = null;
	private List<DataDictionary> listLevel = null;
	private List<ContractPersonInfo> listPerson = null;
	private List<ProvinceInfo> listProvince = null;
	private List<CityInfo> listCity = null;
	private List<AreaInfo> listArea = null;
	
	/**
	 * 客户列表
	 * @return String
	 */
	public String customerList()
	{
		Map<String,CustomerInfo> values = new HashMap<String,CustomerInfo>();
		pagination = customerInfoService.findCustomerInfoForPage(values, pagination);
		return SUCCESS;
	}
	/**
	 * 客户信息
	 * @return String
	 */
	public String customerInfo()
	{
		if(StringUtils.trimToNull(id)!=null)
			customerInfo = customerInfoService.get(id);
		else
			customerInfo = new CustomerInfo();
		//客户来源：传2
		listSource = dataDictionaryService.findDataDictionaryByType(2);
		//客户分类： 传0
		listCategory = dataDictionaryService.findDataDictionaryByType(0);
		//业务进展：传
		listProgress = dataDictionaryService.findDataDictionaryByType(0);
		//成熟度：传4
		listMaturity = dataDictionaryService.findDataDictionaryByType(4);
		//开发程度
		listLevel = dataDictionaryService.findDataDictionaryByType(0);
		
		listProvince = areaService.findAllProvinceInfo();
		
		if(id != null && id.length() > 0)
			listPerson = contractpersonInfoService.findAllContractPersonInfoByCustomerId(id);
		
		return SUCCESS;
	}
	public String customerTabInfo()
	{
		return SUCCESS;
	}
	/**
	 * 保存客户信息
	 * @return String
	 */
	public String saveCustomer()
	{
		customerInfo.setCompanyId(sessionCompanyId);
		customerInfo.setCreatorId(sessionUserId);
		customerInfo.setCreateTime(Calendar.getInstance());
		CustomerInfo obj = null;
		if(id != null && id.length() > 0)
		{
			obj =  customerInfoService.get(id);
		}else
		{
			obj = new CustomerInfo();
		}
		
		obj.setAddress(customerInfo.getAddress());
		obj.setCategoryId(customerInfo.getCategoryId());
		obj.setCity(customerInfo.getCity());
		obj.setCompanyFullName(customerInfo.getCompanyFullName());
		obj.setCompanyId(customerInfo.getCompanyId());
		obj.setCreateTime(customerInfo.getCreateTime());
		obj.setCreatorId(customerInfo.getCreatorId());
		obj.setCustomerName(customerInfo.getCustomerName());
		obj.setDistrict(customerInfo.getDistrict());
		obj.setFax(customerInfo.getFax());
		obj.setLevelId(customerInfo.getLevelId());
		obj.setMaturityId(customerInfo.getMaturityId());
		obj.setOtherSalesmanId(customerInfo.getOtherSalesmanId());
		obj.setProgressId(customerInfo.getProgressId());
		obj.setProvince(customerInfo.getProvince());
		obj.setRegisterTime(customerInfo.getRegisterTime());
		obj.setSalesmanId(customerInfo.getSalesmanId());
		obj.setSourceId(customerInfo.getSourceId());
		obj.setMainIndustry(customerInfo.getMainIndustry());
		
		customerInfoService.save(obj);
		id = obj.getId();
		return SUCCESS;
	}
	/**
	 * 删除客户信息
	 * @return String
	 */
	public String deleteCustomer()
	{
		customerInfoService.deleteCustomerInfo(ids);
		contractpersonInfoService.deleteContractPersonInfo(ids);
		return SUCCESS;
	}
	
	public CustomerInfo getCustomerInfo() {
		return customerInfo;
	}
	public void setCustomerInfo(CustomerInfo customerInfo) {
		this.customerInfo = customerInfo;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String[] getIds() {
		return ids;
	}
	public void setIds(String[] ids) {
		this.ids = ids;
	}
	public Pagination<CustomerInfo> getPagination() {
		return pagination;
	}
	public void setPagination(Pagination<CustomerInfo> pagination) {
		this.pagination = pagination;
	}
	public List<DataDictionary> getListCategory() {
		return listCategory;
	}
	public void setListCategory(List<DataDictionary> listCategory) {
		this.listCategory = listCategory;
	}
	public List<DataDictionary> getListSource() {
		return listSource;
	}
	public void setListSource(List<DataDictionary> listSource) {
		this.listSource = listSource;
	}
	public List<DataDictionary> getListProgress() {
		return listProgress;
	}
	public void setListProgress(List<DataDictionary> listProgress) {
		this.listProgress = listProgress;
	}
	public List<DataDictionary> getListMaturity() {
		return listMaturity;
	}
	public void setListMaturity(List<DataDictionary> listMaturity) {
		this.listMaturity = listMaturity;
	}
	public List<DataDictionary> getListLevel() {
		return listLevel;
	}
	public void setListLevel(List<DataDictionary> listLevel) {
		this.listLevel = listLevel;
	}
	public List<CityInfo> getListCity() {
		return listCity;
	}
	public void setListCity(List<CityInfo> listCity) {
		this.listCity = listCity;
	}
	public List<AreaInfo> getListArea() {
		return listArea;
	}
	public void setListArea(List<AreaInfo> listArea) {
		this.listArea = listArea;
	}
	public List<ContractPersonInfo> getListPerson() {
		return listPerson;
	}
	public void setListPerson(List<ContractPersonInfo> listPerson) {
		this.listPerson = listPerson;
	}
	public List<ProvinceInfo> getListProvince() {
		return listProvince;
	}
	public void setListProvince(List<ProvinceInfo> listProvince) {
		this.listProvince = listProvince;
	}
}

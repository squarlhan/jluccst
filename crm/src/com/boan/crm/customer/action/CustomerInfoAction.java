/**
 * 
 */
package com.boan.crm.customer.action;

import java.util.ArrayList;
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
import com.boan.crm.groupmanage.common.RoleFlag;
import com.boan.crm.groupmanage.model.User;
import com.boan.crm.groupmanage.service.IPopedomService;
import com.boan.crm.groupmanage.service.IUserService;
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
	
	@Autowired
	@Qualifier("userService")
	private IUserService userService;
	
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
	private String customerName = "";
	private String contractorName = "";
	private String customerCategory = "";
	private String salesmanId = "";
	private List<User> userList = null;
	
	
	/**
	 * 客户列表
	 * @return String
	 */
	public String customerList()
	{
		//客户分类： 传0
		listCategory = dataDictionaryService.findDataDictionaryByType(0);
		try
		{
			userList = userService.queryUserListByCompanyIdRoleKey(sessionCompanyId,RoleFlag.YE_WU_YUAN);
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		Map<String,String> values = new HashMap<String,String>();
		
		if(customerName != null && customerName.length() > 0)
		{
			values.put("customerName", "%"+customerName+"%");
		}
		if(contractorName != null && contractorName.length() > 0)
		{
			values.put("contractorName", "%"+contractorName+"%");
		}
		if(customerCategory != null && customerCategory.length() > 0)
		{
			values.put("customerCategory", customerCategory);
		}
		if(salesmanId != null && salesmanId.length() > 0)
		{
			values.put("salesmanId", salesmanId);
		}
		
		values.put("companyId", sessionCompanyId);
		
		
		pagination = customerInfoService.findCustomerInfoForPage(values, pagination);
		return SUCCESS;
	}
	public List<User> getUserList() {
		return userList;
	}
	public void setUserList(List<User> userList) {
		this.userList = userList;
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
		//listProgress = dataDictionaryService.findDataDictionaryByType(0);
		listProgress = new ArrayList<DataDictionary>();
		DataDictionary d = new DataDictionary();
		d.setId("潜在客户");
		d.setName("潜在客户");
		listProgress.add(d);
		DataDictionary d1 = new DataDictionary();
		d1.setId("新建客户");
		d1.setName("新建客户");
		listProgress.add(d1);
		DataDictionary d2 = new DataDictionary();
		d2.setId("成熟客户");
		d2.setName("成熟客户");
		listProgress.add(d2);
		//成熟度：传4
		listMaturity = dataDictionaryService.findDataDictionaryByType(4);
		//开发程度
		//listLevel = dataDictionaryService.findDataDictionaryByType(0);
		listLevel = new ArrayList<DataDictionary>();
		DataDictionary level = new DataDictionary();
		level.setId("10%");
		level.setName("10%");
		listLevel.add(level);
		DataDictionary level1 = new DataDictionary();
		level1.setId("20%");
		level1.setName("20%");
		listLevel.add(level1);
		DataDictionary level2 = new DataDictionary();
		level2.setId("30%");
		level2.setName("30%");
		listLevel.add(level2);
		DataDictionary level3 = new DataDictionary();
		level3.setId("40%");
		level3.setName("40%");
		listLevel.add(level3);
		DataDictionary level4 = new DataDictionary();
		level4.setId("50%");
		level4.setName("50%");
		listLevel.add(level4);
		DataDictionary level5 = new DataDictionary();
		level5.setId("60%");
		level5.setName("60%");
		listLevel.add(level5);
		DataDictionary level6 = new DataDictionary();
		level6.setId("70%");
		level6.setName("70%");
		listLevel.add(level6);
		DataDictionary level7 = new DataDictionary();
		level7.setId("80%");
		level7.setName("80%");
		listLevel.add(level7);
		DataDictionary level8 = new DataDictionary();
		level8.setId("90%");
		level8.setName("90%");
		listLevel.add(level8);
		DataDictionary level9 = new DataDictionary();
		level9.setId("100%");
		level9.setName("100%");
		listLevel.add(level9);
		
		listProvince = areaService.findAllProvinceInfo();
		
		try
		{
			userList = userService.queryUserListByCompanyIdRoleKey(sessionCompanyId,RoleFlag.YE_WU_YUAN);
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
		
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
		customerInfo.setSalesmanId(sessionUserId);
		customerInfo.setSalesman(sessionUserCName);
		customerInfo.setCreateTime(Calendar.getInstance());
		CustomerInfo obj = null;
		if(customerInfo.getId() != null && customerInfo.getId().length() > 0)
		{
			obj =  customerInfoService.get(customerInfo.getId());
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
		obj.setSalesman(customerInfo.getSalesman());
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
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getContractorName() {
		return contractorName;
	}
	public void setContractorName(String contractorName) {
		this.contractorName = contractorName;
	}
	public String getCustomerCategory() {
		return customerCategory;
	}
	public void setCustomerCategory(String customerCategory) {
		this.customerCategory = customerCategory;
	}
	public String getSalesmanId() {
		return salesmanId;
	}
	public void setSalesmanId(String salesmanId) {
		this.salesmanId = salesmanId;
	}
}

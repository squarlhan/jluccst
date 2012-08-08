/**
 * 
 */
package com.boan.crm.customer.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.boan.crm.customer.model.CustomerInfo;
import com.boan.crm.customer.service.IContractPersonService;
import com.boan.crm.customer.service.ICustomerInfoService;
import com.boan.crm.datadictionary.model.DataDictionary;
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
	
	@Resource
	//客户状态接口类
	private ICustomerInfoService customerInfoService;
	
	/**
	 * 权限接口
	 */
	@Autowired
	@Qualifier("dataDictionaryService")
	private IDataDictionaryService dataDictionaryService = null;
	
	// 客户状态接口类
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
		//业务进展：传2
		listProgress = dataDictionaryService.findDataDictionaryByType(0);
		//成熟度：传4
		listMaturity = dataDictionaryService.findDataDictionaryByType(4);
		//开发程度
		listLevel = dataDictionaryService.findDataDictionaryByType(0);
		
		return SUCCESS;
	}
	/**
	 * 保存客户信息
	 * @return String
	 */
	public String saveCustomer()
	{
		customerInfoService.save(customerInfo);
		
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
}

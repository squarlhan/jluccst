/**
 * Copyright (c) 2012 Boan Co. Ltd.
 * All right reserved.
 * History
 */

package com.boan.crm.datadictionary.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.boan.crm.datadictionary.model.CustomerType;
import com.boan.crm.datadictionary.service.ICustomerTypeService;
import com.boan.crm.utils.action.BaseActionSupport;


/**
 * 客户类别Action类
 * 
 * @author leon
 * @version 1.0.0
 */
@Controller("customerTypeAction")
@Scope("prototype")
public class CustomerTypeAction extends BaseActionSupport {
	
	@Resource
	// 客户类别接口类
	private ICustomerTypeService customerTypeService;
	
	//客户类别对象
	private CustomerType customerType = null;
	
	List<CustomerType> customerTypes = null;
	
	private String typeId;
	
	private String[] typeIds;
	
	/**
	 * 客户类别集合
	 * @return
	 */
	public String customerTypeList(){
		customerTypes = customerTypeService.findAllCustomerType();
		return SUCCESS;
	}
	
	/**
	 * 获得客户类别信息
	 * @return
	 */
	public String customerTypeInfo(){
		if(StringUtils.trimToNull(typeId)!=null)
			customerType = customerTypeService.get(typeId);
		else
			customerType = new CustomerType();
		return SUCCESS;
	}
	
	/**
	 * 保存信息
	 * @return
	 */
	public String saveCustomerType(){
		return SUCCESS;
	}
	
	/**
	 * 删除客户类别信息
	 * @return
	 */
	public String deleteCustomerType(){
		if(typeIds!=null){
			customerTypeService.deleteCustomerType(typeIds);
		}
		return SUCCESS;
	}

	public CustomerType getCustomerType() {
		return customerType;
	}

	public void setCustomerType(CustomerType customerType) {
		this.customerType = customerType;
	}

	public List<CustomerType> getCustomerTypes() {
		return customerTypes;
	}

	public void setCustomerTypes(List<CustomerType> customerTypes) {
		this.customerTypes = customerTypes;
	}

	public String getTypeId() {
		return typeId;
	}

	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}

	public String[] getTypeIds() {
		return typeIds;
	}

	public void setTypeIds(String[] typeIds) {
		this.typeIds = typeIds;
	}
	
}

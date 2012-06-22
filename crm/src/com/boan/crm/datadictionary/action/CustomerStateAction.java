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

import com.boan.crm.datadictionary.model.CustomerState;
import com.boan.crm.datadictionary.service.ICustomerStateService;
import com.boan.crm.utils.action.BaseActionSupport;


/**
 * 客户类别Action类
 * 
 * @author leon
 * @version 1.0.0
 */
@Controller("customerStateAction")
@Scope("prototype")
public class CustomerStateAction extends BaseActionSupport {
	
	@Resource
	// 客户状态接口类
	private ICustomerStateService customerStateService;
	
	//客户状态对象
	private CustomerState customerState = null;
	
	List<CustomerState> customerStates = null;
	
	private String stateId;
	private String stateName;
	private String remark;
	
	private String[] stateIds;
	
	/**
	 * 客户类别集合
	 * @return
	 */
	public String customerStateList(){
		customerStates = customerStateService.findAllCustomerState();
		return SUCCESS;
	}
	
	/**
	 * 获得客户类别信息
	 * @return
	 */
	public String customerStateInfo(){
		if(StringUtils.trimToNull(stateId)!=null)
			customerState = customerStateService.get(stateId);
		else
			customerState = new CustomerState();
		return SUCCESS;
	}
	
	/**
	 * 保存信息
	 * @return
	 */
	public String saveCustomerState(){
		if(StringUtils.trimToNull(stateId)!=null)
			customerState = customerStateService.get(stateId);
		else
			customerState = new CustomerState();
		customerState.setStateName(stateName);
		customerState.setRemark(remark);
		customerStateService.save(customerState);
		return SUCCESS;
	}
	
	/**
	 * 删除客户类别信息
	 * @return
	 */
	public String deleteCustomerState(){
		if(stateIds!=null){
			customerStateService.deleteCustomerState(stateIds);
		}
		return SUCCESS;
	}
	
	/**
	 * 排序
	 * @return
	 */
	public String customerStateSort(){
		customerStates = customerStateService.findAllCustomerState();
		return SUCCESS;
	}
	
	/**
	 * 保存排序
	 * @return
	 */
	public String saveCustomerStateSort(){
		if(stateIds!=null&&stateIds.length>0){
			CustomerState ct = null;
			for(int i=0; i<stateIds.length; i++){
				customerState = customerStateService.get(stateIds[i]);
				customerState.setSortIndex(i);
				customerStateService.save(customerState);
			}
		}
		return SUCCESS;
	}

	public CustomerState getCustomerState() {
		return customerState;
	}

	public void setCustomerState(CustomerState customerState) {
		this.customerState = customerState;
	}

	public List<CustomerState> getCustomerStates() {
		return customerStates;
	}

	public void setCustomerStates(List<CustomerState> customerStates) {
		this.customerStates = customerStates;
	}

	public String getStateId() {
		return stateId;
	}

	public void setStateId(String stateId) {
		this.stateId = stateId;
	}

	public String[] getStateIds() {
		return stateIds;
	}

	public void setStateIds(String[] stateIds) {
		this.stateIds = stateIds;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}

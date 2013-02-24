/**
 * Copyright (c) 2013 Changchun CBIT Co. Ltd.
 * All right reserved.
 * History
 */
/*
 * @(#)CustomerSellAmountAction.java 1.1 2013-2-24
 */

package com.boan.crm.sellrecord.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.boan.crm.customer.model.CustomerInfo;
import com.boan.crm.customer.service.ICustomerInfoService;
import com.boan.crm.datadictionary.model.DataDictionary;
import com.boan.crm.datadictionary.service.IDataDictionaryService;
import com.boan.crm.groupmanage.common.RoleFlag;
import com.boan.crm.groupmanage.common.UserSession;
import com.boan.crm.groupmanage.model.Deptment;
import com.boan.crm.groupmanage.model.User;
import com.boan.crm.groupmanage.service.IDeptmentService;
import com.boan.crm.groupmanage.service.IPopedomService;
import com.boan.crm.groupmanage.service.IUserService;
import com.boan.crm.utils.action.BaseActionSupport;
import com.boan.crm.utils.page.Pagination;

/**
 * 客户销售额相关
 * @author XXX
 * @version 1.0.0
 */
@Controller("customerSellAmountAction")
@Scope("prototype")
public class CustomerSellAmountAction extends BaseActionSupport {

	private String companyId = null;

	private String companyName = null;
	
	private List<User> userList = null;
	
	private List<Deptment> deptList = null;
	
	private List<DataDictionary> listCategory = null;
	
	private String deptId = "";
	
	private String customerName = "";
	
	private String contractorName = "";
	
	private String customerCategory = "";
	
	private String salesmanId = "";
	
	private Pagination<CustomerInfo> pagination = new Pagination<CustomerInfo>();
	
	private String queryBeginTime="";
	
	private String queryEndTime="";
	
	private String queryAmountBegin="";
	
	private String queryAmountEnd="";
	
	@Autowired
	@Qualifier("popedomService")
	private IPopedomService popedomService = null;
	
	@Autowired
	@Qualifier("deptService")
	private IDeptmentService deptService = null;
	
	@Autowired
	@Qualifier("userService")
	private IUserService userService = null;
	
	@Autowired
	@Qualifier("dataDictionaryService")
	private IDataDictionaryService dataDictionaryService = null;
	
	@Autowired
	@Qualifier("customerInfoService")
	//客户状态接口类
	private ICustomerInfoService customerInfoService;
	
	/**
	 * 显示组织机构人员树
	 * 
	 * @return
	 */
	public String showGroupTreeForQueryCustomerBySellAmount() throws Exception {
		companyId = sessionCompanyId;
		companyName = sessionCompanyName;
		userList = new ArrayList<User>();
		deptList = new ArrayList<Deptment>();
		boolean flag=true;
		if(sessionDeptId.equals("")){ //总经理
			flag=false;
		}
		UserSession us = this.getSession();
		//判断是否是公司管理员或公司级用户
		boolean popodomFlag = popedomService.isCompanyAdministrator(us.getUserId(), String.valueOf(us.getUserType()) ) 
				||popedomService.isHasCompanyPopedom(us.getRoleKey());
		/**
		 * JHY注 
		if(flag){ //部门经理
			deptList.add(deptService.get(sessionDeptId));
		}else{    //总经理
			deptList = deptService.queryAllDeptmentsByCompanyId(sessionCompanyId);
		}
		*/
		if( popodomFlag ){
			deptList = deptService.queryAllDeptmentsByCompanyId(sessionCompanyId);
		}else{
			deptList.add(deptService.get(sessionDeptId));
		}
		// 获取用户列表
		if (deptList != null && deptList.size() > 0) {
			List<User> tempUserList = new ArrayList<User>();
			for (int i = 0; i < deptList.size(); i++) {
				if(deptList.get(i)!=null){
					List<User> tempList = userService.queryUserList(sessionCompanyId, deptList.get(i).getId());
					if (tempList != null && tempList.size() > 0) {
						tempUserList.addAll(tempList);
					}
				}
			}
			if (tempUserList != null && tempUserList.size() > 0) {
				userList.addAll(tempUserList);
			}
		}
		return SUCCESS;
	}
	
	public String queryCustomerBySellAmount() {
		// 客户分类： 传0
		listCategory = dataDictionaryService.findDataDictionaryByType( sessionCompanyId, 0);
		try {
			if (deptId != null && deptId.length() > 0) {
				userList = userService.queryUserListByCompanyIdRoleKey(sessionCompanyId, deptId, RoleFlag.YE_WU_YUAN);
			} else {
				userList = userService.queryUserListByCompanyIdRoleKey(sessionCompanyId, RoleFlag.YE_WU_YUAN);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		Map<String, String> values = new HashMap<String, String>();

		if (customerName != null && customerName.length() > 0) {
			values.put("customerName", "%" + customerName + "%");
		}
		if (contractorName != null && contractorName.length() > 0) {
			values.put("contractorName", "%" + contractorName + "%");
		}
		if (customerCategory != null && customerCategory.length() > 0) {
			values.put("customerCategory", customerCategory);
		}
		if (salesmanId != null && salesmanId.length() > 0) {
			values.put("salesmanId", salesmanId);
		}
		if (deptId != null && deptId.length() > 0) {
			values.put("deptId", deptId);
		}
		values.put("companyId", sessionCompanyId);
		
		//销售总额相关条件
		if (queryAmountBegin != null && queryAmountBegin.length() > 0) {
			values.put("queryAmountBegin", queryAmountBegin);
		}
		if (queryAmountEnd != null && queryAmountEnd.length() > 0) {
			values.put("queryAmountEnd", queryAmountEnd);
		}
		if (queryBeginTime != null && queryBeginTime.length() > 0) {
			values.put("queryBeginTime", queryBeginTime);
		}
		if (queryEndTime != null && queryEndTime.length() > 0) {
			values.put("queryEndTime", queryEndTime);
		}

		pagination = customerInfoService.findCustomerInfoAndSellAmountForPage(values , pagination);
		return SUCCESS;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	public List<Deptment> getDeptList() {
		return deptList;
	}

	public void setDeptList(List<Deptment> deptList) {
		this.deptList = deptList;
	}

	public List<DataDictionary> getListCategory() {
		return listCategory;
	}

	public void setListCategory(List<DataDictionary> listCategory) {
		this.listCategory = listCategory;
	}

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
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

	public Pagination<CustomerInfo> getPagination() {
		return pagination;
	}

	public void setPagination(Pagination<CustomerInfo> pagination) {
		this.pagination = pagination;
	}

	public String getQueryBeginTime() {
		return queryBeginTime;
	}

	public void setQueryBeginTime(String queryBeginTime) {
		this.queryBeginTime = queryBeginTime;
	}

	public String getQueryEndTime() {
		return queryEndTime;
	}

	public void setQueryEndTime(String queryEndTime) {
		this.queryEndTime = queryEndTime;
	}

	public String getQueryAmountBegin() {
		return queryAmountBegin;
	}

	public void setQueryAmountBegin(String queryAmountBegin) {
		this.queryAmountBegin = queryAmountBegin;
	}

	public String getQueryAmountEnd() {
		return queryAmountEnd;
	}

	public void setQueryAmountEnd(String queryAmountEnd) {
		this.queryAmountEnd = queryAmountEnd;
	}
}


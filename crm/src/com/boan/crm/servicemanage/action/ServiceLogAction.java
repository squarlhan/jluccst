/**
 * Copyright (c) 2012 Boan Co. Ltd.
 * All right reserved.
 * History
 */

package com.boan.crm.servicemanage.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.boan.crm.customer.model.CustomerInfo;
import com.boan.crm.customer.service.ICustomerInfoService;
import com.boan.crm.servicemanage.model.ServiceLog;
import com.boan.crm.servicemanage.service.IServiceLogService;
import com.boan.crm.utils.action.BaseActionSupport;
import com.boan.crm.utils.page.Pagination;


/**
 * 服务记录Action类
 * 
 * @author leon
 * @version 1.0.0
 */
@Controller("serviceLogAction")
@Scope("prototype")
public class ServiceLogAction extends BaseActionSupport {

	private static final long serialVersionUID = 1890924579127721010L;

	//服务记录接口类
	@Resource
	private IServiceLogService serviceLogService;
	//客户状态接口类
	@Resource
	private ICustomerInfoService customerInfoService;
	
	//服务记录对象
	private ServiceLog serviceLog = null;
	
	//服务记录对象集合
	private List<ServiceLog> serviceLogs = null;
	
	//销售员所有的客户
	private List<CustomerInfo> customerInfos = null;
	
	//显示分页
	private Pagination<ServiceLog> pagination = new Pagination<ServiceLog>();
	
	//服务记录ID
	private String logId;
	
	private String[] logIds;
	
	private String companyId;
	private String companyName;
	private String receipt;
	private String degreeSatisfaction;
	
	private String searchCompanyName;
	
	private String message;
	
	/**
	 * 根据电话号码获得服务记录对象集合
	 * @return 结果
	 */
	public String serviceLogListByTel(){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put( "companyId", companyId );
		pagination = serviceLogService.findForPage(map, pagination );
		return SUCCESS;
	}
	
	/**
	 * 服务记录对象集合
	 * @return 结果
	 */
	public String serviceLogList(){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("myCompanyId", sessionCompanyId);
		if(StringUtils.trimToNull(searchCompanyName)!=null)
			map.put("companyName", "%" + searchCompanyName + "%");
		if(StringUtils.trimToNull(companyId)!=null)
			map.put("companyId", companyId);
		pagination = serviceLogService.findForPage(map, pagination );
		return SUCCESS;
	}
	
	/**
	 * 服务记录对象集合
	 * @return 结果
	 */
	public String serviceLogListByCustomer(){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("myCompanyId", sessionCompanyId);
		if(StringUtils.trimToNull(searchCompanyName)!=null)
			map.put("companyName", "%" + searchCompanyName + "%");
		if(StringUtils.trimToNull(companyId)!=null)
			map.put("companyId", companyId);
		pagination = serviceLogService.findForPage(map, pagination );
		return SUCCESS;
	}
	
	/**
	 * 服务记录对象集合
	 * @return 结果
	 */
	public String serviceLogListForLeader(){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("myCompanyId", sessionCompanyId);
		if(StringUtils.trimToNull(searchCompanyName)!=null)
			map.put("companyName", "%" + searchCompanyName + "%");
		if(StringUtils.trimToNull(companyId)!=null)
			map.put("companyId", companyId);
		pagination = serviceLogService.findForPage(map, pagination );
		return SUCCESS;
	}
	
	/**
	 * 获得服务记录对象信息
	 * @return
	 */
	public String serviceLogInfo(){
		customerInfos= customerInfoService.findAllCustomerInfo();
		if(customerInfos==null)
			customerInfos = new ArrayList<CustomerInfo>();
		if(StringUtils.trimToNull(logId)!=null){
			serviceLog = serviceLogService.get(logId);
			companyId = serviceLog.getCompanyId();
			if(StringUtils.trimToNull(companyId)!=null)
				companyName = customerInfoService.get(companyId).getCustomerName();
		}else
			serviceLog = new ServiceLog();
		return SUCCESS;
	}
	
	/**
	 * 获得服务记录对象信息
	 * @return
	 */
	public String serviceLogInfoForLeader(){
		customerInfos= customerInfoService.findAllCustomerInfo();
		if(customerInfos==null)
			customerInfos = new ArrayList<CustomerInfo>();
		if(StringUtils.trimToNull(logId)!=null){
			serviceLog = serviceLogService.get(logId);
			companyId = serviceLog.getCompanyId();
			if(StringUtils.trimToNull(companyId)!=null)
				companyName = customerInfoService.get(companyId).getCustomerName();
		}else
			serviceLog = new ServiceLog();
		return SUCCESS;
	}
	
	/**
	 * 获得服务记录对象信息
	 * @return
	 */
	public String serviceLogInfoByCustomer(){
		customerInfos= customerInfoService.findAllCustomerInfo();
		if(customerInfos==null)
			customerInfos = new ArrayList<CustomerInfo>();
		if(StringUtils.trimToNull(logId)!=null)
			serviceLog = serviceLogService.get(logId);
		else
			serviceLog = new ServiceLog();
		companyName = customerInfoService.get(companyId).getCustomerName();
		return SUCCESS;
	}
	
	/**
	 * 保存信息
	 * @return
	 */
	public String saveServiceLog(){
		customerInfos= customerInfoService.findAllCustomerInfo();
		if(customerInfos==null)
			customerInfos = new ArrayList<CustomerInfo>();
		if(StringUtils.trimToNull(serviceLog.getId())==null)
			serviceLog.setId(null);
		serviceLog.setMyCompanyId(sessionCompanyId);
		serviceLog.setCompanyId(companyId);
		serviceLog.setCompanyName(companyName);
		if(StringUtils.trimToNull(receipt)!=null)
			serviceLog.setReceipt(Integer.valueOf(receipt));
		if(StringUtils.trimToNull(degreeSatisfaction)!=null)
			serviceLog.setDegreeSatisfaction(Integer.valueOf(degreeSatisfaction));
		serviceLogService.saveOrUpdate(serviceLog);
		message = "保存成功！";
		return SUCCESS;
	}
	
	/**
	 * 保存信息
	 * @return
	 */
	public String saveServiceLogByCustomer(){
		if(StringUtils.trimToNull(serviceLog.getId())==null)
			serviceLog.setId(null);
		serviceLog.setMyCompanyId(sessionCompanyId);
		serviceLog.setCompanyId(companyId);
		serviceLog.setCompanyName(companyName);
		if(StringUtils.trimToNull(receipt)!=null)
			serviceLog.setReceipt(Integer.valueOf(receipt));
		if(StringUtils.trimToNull(degreeSatisfaction)!=null)
			serviceLog.setDegreeSatisfaction(Integer.valueOf(degreeSatisfaction));
		serviceLogService.saveOrUpdate(serviceLog);
		message = "保存成功！";
		return SUCCESS;
	}
	
	/**
	 * 删除服务记录信息
	 * @return
	 */
	public String deleteServiceLog(){
		if(logIds!=null){
			serviceLogService.deleteServiceLog(logIds);
		}
		return SUCCESS;
	}

	/**
	 * @return the customerInfos
	 */
	public List<CustomerInfo> getCustomerInfos() {
		return customerInfos;
	}

	/**
	 * @param customerInfos the customerInfos to set
	 */
	public void setCustomerInfos(List<CustomerInfo> customerInfos) {
		this.customerInfos = customerInfos;
	}

	/**
	 * @return the serviceLog
	 */
	public ServiceLog getServiceLog() {
		return serviceLog;
	}

	/**
	 * @param serviceLog the serviceLog to set
	 */
	public void setServiceLog(ServiceLog serviceLog) {
		this.serviceLog = serviceLog;
	}

	/**
	 * @return the serviceLogs
	 */
	public List<ServiceLog> getServiceLogs() {
		return serviceLogs;
	}

	/**
	 * @param serviceLogs the serviceLogs to set
	 */
	public void setServiceLogs(List<ServiceLog> serviceLogs) {
		this.serviceLogs = serviceLogs;
	}

	/**
	 * @return the pagination
	 */
	public Pagination<ServiceLog> getPagination() {
		return pagination;
	}

	/**
	 * @param pagination the pagination to set
	 */
	public void setPagination(Pagination<ServiceLog> pagination) {
		this.pagination = pagination;
	}

	/**
	 * @return the logId
	 */
	public String getLogId() {
		return logId;
	}

	/**
	 * @param logId the logId to set
	 */
	public void setLogId(String logId) {
		this.logId = logId;
	}

	/**
	 * @return the logIds
	 */
	public String[] getLogIds() {
		return logIds;
	}

	/**
	 * @param logIds the logIds to set
	 */
	public void setLogIds(String[] logIds) {
		this.logIds = logIds;
	}

	/**
	 * @return the companyId
	 */
	public String getCompanyId() {
		return companyId;
	}

	/**
	 * @param companyId the companyId to set
	 */
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	/**
	 * @return the companyName
	 */
	public String getCompanyName() {
		return companyName;
	}

	/**
	 * @param companyName the companyName to set
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
	/**
	 * @return the searchCompanyName
	 */
	public String getSearchCompanyName() {
		return searchCompanyName;
	}

	/**
	 * @param searchCompanyName the searchCompanyName to set
	 */
	public void setSearchCompanyName(String searchCompanyName) {
		this.searchCompanyName = searchCompanyName;
	}

	/**
	 * @return the receipt
	 */
	public String getReceipt() {
		return receipt;
	}

	/**
	 * @param receipt the receipt to set
	 */
	public void setReceipt(String receipt) {
		this.receipt = receipt;
	}

	/**
	 * @return the degreeSatisfaction
	 */
	public String getDegreeSatisfaction() {
		return degreeSatisfaction;
	}

	/**
	 * @param degreeSatisfaction the degreeSatisfaction to set
	 */
	public void setDegreeSatisfaction(String degreeSatisfaction) {
		this.degreeSatisfaction = degreeSatisfaction;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
}

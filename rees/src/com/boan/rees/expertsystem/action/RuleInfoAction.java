/*
 * @(#)RuleAdviceInfoAction.java 1.1 2012-4-23
 */

package com.boan.rees.expertsystem.action;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.boan.rees.device.type.model.DeviceType;
import com.boan.rees.device.type.service.IDeviceTypeService;
import com.boan.rees.expertsystem.model.RuleAdviceInfo;
import com.boan.rees.expertsystem.model.RuleInfo;
import com.boan.rees.expertsystem.model.RuleReasonInfo;
import com.boan.rees.expertsystem.model.RuleResultInfo;
import com.boan.rees.expertsystem.model.RuleView;
import com.boan.rees.expertsystem.service.IRuleAdviceInfoService;
import com.boan.rees.expertsystem.service.IRuleInfoService;
import com.boan.rees.expertsystem.service.IRuleReasonInfoService;
import com.boan.rees.expertsystem.service.IRuleResultInfoService;
import com.boan.rees.expertsystem.service.IRuleViewService;
import com.boan.rees.utils.action.BaseActionSupport;
import com.boan.rees.utils.page.Pagination;

/**
 * 建议Action类
 * @author jiangmeidi
 * @version 1.0.0
 */
@Controller("ruleInfoAction")
@Scope("prototype")
public class RuleInfoAction extends BaseActionSupport{
	/**
	 * 用于调用数据库相关操作
	 */
	@Autowired
	@Qualifier("ruleInfoService")
	private IRuleInfoService service;
	@Autowired
	@Qualifier("ruleViewService")
	private IRuleViewService viewservice;
	@Autowired
	@Qualifier("deviceTypeService")
	private IDeviceTypeService deviceTypeService;
	@Autowired
	@Qualifier("ruleAdviceInfoService")
	private IRuleAdviceInfoService ruleAdviceInfoService;
	@Autowired
	@Qualifier("ruleReasonInfoService")
	private IRuleReasonInfoService ruleReasonInfoService;
	@Autowired
	@Qualifier("ruleResultInfoService")
	private IRuleResultInfoService ruleResultInfoService;
	/**
	 * 分页列表
	 */
	Pagination<RuleView> pagination = new Pagination<RuleView>();
	/**
	 * 页面对象
	 */
	private RuleInfo ruleInfo;
	
	private RuleView ruleView;
	private List<DeviceType> deviceTypeList;
	private List<RuleAdviceInfo> adviceList;
	private List<RuleReasonInfo> reasonList;
	private List<RuleResultInfo> resultList;
	
	/**
	 * 下拉设备列表事件传递过来的设备类型Id
	 */
	//private String deviceTypeId;
	
	/**
	 * 页面所选行的id
	 */
	private Integer[] ids;
	
	/**
	 * 操作提示
	 */
	private String message;
	
	
	public List<RuleAdviceInfo> getAdviceList() {
		return adviceList;
	}

	public void setAdviceList(List<RuleAdviceInfo> adviceList) {
		this.adviceList = adviceList;
	}

	public List<RuleReasonInfo> getReasonList() {
		return reasonList;
	}

	public void setReasonList(List<RuleReasonInfo> reasonList) {
		this.reasonList = reasonList;
	}

	public List<RuleResultInfo> getResultList() {
		return resultList;
	}

	public void setResultList(List<RuleResultInfo> resultList) {
		this.resultList = resultList;
	}

	public List<DeviceType> getDeviceTypeList() {
		return deviceTypeList;
	}

	public void setDeviceTypeList(List<DeviceType> deviceTypeList) {
		this.deviceTypeList = deviceTypeList;
	}

	
	public Pagination<RuleView> getPagination() {
		return pagination;
	}

	public void setPagination(Pagination<RuleView> pagination) {
		this.pagination = pagination;
	}

	public RuleInfo getRuleInfo() {
		return ruleInfo;
	}

	public void setRuleInfo(RuleInfo ruleInfo) {
		this.ruleInfo = ruleInfo;
	}

	public RuleView getRuleView() {
		return ruleView;
	}

	public void setRuleView(RuleView ruleView) {
		this.ruleView = ruleView;
	}

	public Integer[] getIds() {
		return ids;
	}

	public void setIds(Integer[] ids) {
		this.ids = ids;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * 分页显示建议列表
	 * @return
	 */
	public String openRuleInfo(){
		pagination = viewservice.findRuleViewForPage(new HashMap(), pagination);
		return this.SUCCESS;
	}

    

	/**
	 * 打开添加新建议页
	 * @return
	 */
	
	public String openAddRuleInfo(){
		deviceTypeList=deviceTypeService.findAllDeviceType();
		adviceList=ruleAdviceInfoService.findAllRuleAdviceInfo();
		reasonList=ruleReasonInfoService.findAllRuleReasonInfo();
		resultList=ruleResultInfoService.findAllRuleResultInfo();
		ruleInfo = new RuleInfo();
		return SUCCESS;
	}
	/**
	 * 添加新建议
	 * @return
	 */
	public String toAddRuleInfo(){
		try {
			deviceTypeList=deviceTypeService.findAllDeviceType();
			adviceList=ruleAdviceInfoService.findAllRuleAdviceInfo();
			reasonList=ruleReasonInfoService.findAllRuleReasonInfo();
			resultList=ruleResultInfoService.findAllRuleResultInfo();
			//保存设备对象
			service.save(ruleInfo);
			message="保存成功！";
		} catch (Exception e) {
			e.printStackTrace();
			message="保存失败！";
		}
		return SUCCESS;
	}

	/**
	 * 删除建议
	 * @return
	 */
	public String deleteRuleInfo(){
		service.deleteRuleInfo(ids);
		return NONE;
	}
	
	/**
	 * 为修改建议做准备
	 * @return
	 */
	public String openModifyRuleInfo(){
		deviceTypeList=deviceTypeService.findAllDeviceType();
		adviceList=ruleAdviceInfoService.findAllRuleAdviceInfo();
		reasonList=ruleReasonInfoService.findAllRuleReasonInfo();
		resultList=ruleResultInfoService.findAllRuleResultInfo();
		int id = ruleInfo.getId();
		ruleInfo = service.get(id);
		return SUCCESS;
	}
	
	/**
	 * 修改建议信息
	 * @return 
	 */
	public String toModifyRuleInfo(){
		try {
			deviceTypeList=deviceTypeService.findAllDeviceType();
			adviceList=ruleAdviceInfoService.findAllRuleAdviceInfo();
			reasonList=ruleReasonInfoService.findAllRuleReasonInfo();
			resultList=ruleResultInfoService.findAllRuleResultInfo();
			service.update(ruleInfo);
			message="保存成功！";
		} catch (Exception e) {
			e.printStackTrace();
			message="保存失败！";
		}
		return SUCCESS;
	}
	
	
	
}


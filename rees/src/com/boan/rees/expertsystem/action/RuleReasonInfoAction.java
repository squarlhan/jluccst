/*
 * @(#)RuleReasonInfoAction.java 1.1 2012-4-23
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
import com.boan.rees.expertsystem.model.ReasonView;
import com.boan.rees.expertsystem.model.ReasonView;
import com.boan.rees.expertsystem.model.RuleReasonInfo;
import com.boan.rees.expertsystem.model.RuleReasonInfo;
import com.boan.rees.expertsystem.service.IReasonViewService;
import com.boan.rees.expertsystem.service.IRuleReasonInfoService;
import com.boan.rees.utils.action.BaseActionSupport;
import com.boan.rees.utils.page.Pagination;

/**
 * 原因Action类
 * @author jiangmeidi
 * @version 1.0.0
 */
@Controller("ruleReasonInfoAction")
@Scope("prototype")
public class RuleReasonInfoAction extends BaseActionSupport{
	/**
	 * 用于调用数据库相关操作
	 */
	@Autowired
	@Qualifier("ruleReasonInfoService")
	private IRuleReasonInfoService service;
	@Autowired
	@Qualifier("reasonViewService")
	private IReasonViewService viewservice;
	@Autowired
	@Qualifier("deviceTypeService")
	private IDeviceTypeService deviceTypeService;
	/**
	 * 分页列表
	 */
	Pagination<ReasonView> pagination = new Pagination<ReasonView>();
	/**
	 * 页面对象
	 */
	private RuleReasonInfo ruleReasonInfo;
	
	private ReasonView reasonView;
	private List<DeviceType> deviceTypeList;
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
	
	
	public List<DeviceType> getDeviceTypeList() {
		return deviceTypeList;
	}

	public void setDeviceTypeList(List<DeviceType> deviceTypeList) {
		this.deviceTypeList = deviceTypeList;
	}

	

	

	public RuleReasonInfo getRuleReasonInfo() {
		return ruleReasonInfo;
	}

	public void setRuleReasonInfo(RuleReasonInfo ruleReasonInfo) {
		this.ruleReasonInfo = ruleReasonInfo;
	}

	public ReasonView getReasonView() {
		return reasonView;
	}

	public void setReasonView(ReasonView reasonView) {
		this.reasonView = reasonView;
	}

	

	public Pagination<ReasonView> getPagination() {
		return pagination;
	}

	public void setPagination(Pagination<ReasonView> pagination) {
		this.pagination = pagination;
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
	 * 分页显示原因列表
	 * @return
	 */
	public String openRuleReasonInfo(){
		pagination = viewservice.findReasonViewForPage(new HashMap(), pagination);
		return this.SUCCESS;
	}

    

	/**
	 * 打开添加新原因页
	 * @return
	 */
	
	public String openAddRuleReasonInfo(){
		deviceTypeList=deviceTypeService.findAllDeviceType();
		ruleReasonInfo = new RuleReasonInfo();
		return SUCCESS;
	}
	/**
	 * 添加新原因
	 * @return
	 */
	public String toAddRuleReasonInfo(){
		try {
			deviceTypeList=deviceTypeService.findAllDeviceType();
			//保存设备对象
			service.save(ruleReasonInfo);
			message="保存成功！";
		} catch (Exception e) {
			e.printStackTrace();
			message="保存失败！";
		}
		return SUCCESS;
	}

	/**
	 * 删除原因
	 * @return
	 */
	public String deleteRuleReasonInfo(){
		service.deleteRuleReasonInfo(ids);
		return NONE;
	}
	
	/**
	 * 为修改原因做准备
	 * @return
	 */
	public String openModifyRuleReasonInfo(){
		deviceTypeList=deviceTypeService.findAllDeviceType();
		int id = ruleReasonInfo.getId();
		ruleReasonInfo = service.get(id);
		return SUCCESS;
	}
	
	/**
	 * 修改原因信息
	 * @return 
	 */
	public String toModifyRuleReasonInfo(){
		try {
			deviceTypeList=deviceTypeService.findAllDeviceType();
			service.update(ruleReasonInfo);
			message="保存成功！";
		} catch (Exception e) {
			e.printStackTrace();
			message="保存失败！";
		}
		return SUCCESS;
	}
	
	
	
}


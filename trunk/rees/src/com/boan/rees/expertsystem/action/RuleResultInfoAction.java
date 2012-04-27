/*
 * @(#)RuleResultInfoAction.java 1.1 2012-4-23
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
import com.boan.rees.expertsystem.model.ResultView;
import com.boan.rees.expertsystem.model.RuleResultInfo;
import com.boan.rees.expertsystem.service.IResultViewService;
import com.boan.rees.expertsystem.service.IRuleResultInfoService;
import com.boan.rees.utils.action.BaseActionSupport;
import com.boan.rees.utils.page.Pagination;

/**
 * 现象Action类
 * @author jiangmeidi
 * @version 1.0.0
 */
@Controller("ruleResultInfoAction")
@Scope("prototype")
public class RuleResultInfoAction extends BaseActionSupport{
	/**
	 * 用于调用数据库相关操作
	 */
	@Autowired
	@Qualifier("ruleResultInfoService")
	private IRuleResultInfoService service;
	@Autowired
	@Qualifier("resultViewService")
	private IResultViewService viewservice;
	@Autowired
	@Qualifier("deviceTypeService")
	private IDeviceTypeService deviceTypeService;
	/**
	 * 分页列表
	 */
	Pagination<ResultView> pagination = new Pagination<ResultView>();
	/**
	 * 页面对象
	 */
	private RuleResultInfo ruleResultInfo;
	
	private ResultView adviceView;
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

	public ResultView getResultView() {
		return adviceView;
	}

	public void setResultView(ResultView adviceView) {
		this.adviceView = adviceView;
	}

	

	public Pagination<ResultView> getPagination() {
		return pagination;
	}

	public void setPagination(Pagination<ResultView> pagination) {
		this.pagination = pagination;
	}

	public RuleResultInfo getRuleResultInfo() {
		return ruleResultInfo;
	}

	public void setRuleResultInfo(RuleResultInfo ruleResultInfo) {
		this.ruleResultInfo = ruleResultInfo;
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
	 * 分页显示现象列表
	 * @return
	 */
	public String openRuleResultInfo(){
		pagination = viewservice.findResultViewForPage(new HashMap(), pagination);
		return this.SUCCESS;
	}

    

	/**
	 * 打开添加新现象页
	 * @return
	 */
	
	public String openAddRuleResultInfo(){
		deviceTypeList=deviceTypeService.findAllDeviceType();
		ruleResultInfo = new RuleResultInfo();
		return SUCCESS;
	}
	/**
	 * 添加新现象
	 * @return
	 */
	public String toAddRuleResultInfo(){
		try {
			deviceTypeList=deviceTypeService.findAllDeviceType();
			//保存设备对象
			service.save(ruleResultInfo);
			message="保存成功！";
		} catch (Exception e) {
			e.printStackTrace();
			message="保存失败！";
		}
		return SUCCESS;
	}

	/**
	 * 删除现象
	 * @return
	 */
	public String deleteRuleResultInfo(){
		service.deleteRuleResultInfo(ids);
		return NONE;
	}
	
	/**
	 * 为修改现象做准备
	 * @return
	 */
	public String openModifyRuleResultInfo(){
		deviceTypeList=deviceTypeService.findAllDeviceType();
		int id = ruleResultInfo.getId();
		ruleResultInfo = service.get(id);
		return SUCCESS;
	}
	
	/**
	 * 修改现象信息
	 * @return 
	 */
	public String toModifyRuleResultInfo(){
		try {
			deviceTypeList=deviceTypeService.findAllDeviceType();
			service.update(ruleResultInfo);
			message="保存成功！";
		} catch (Exception e) {
			e.printStackTrace();
			message="保存失败！";
		}
		return SUCCESS;
	}
	
	
	
}


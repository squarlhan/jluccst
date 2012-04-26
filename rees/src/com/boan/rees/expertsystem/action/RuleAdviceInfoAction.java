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
import com.boan.rees.expertsystem.model.AdviceView;
import com.boan.rees.expertsystem.model.RuleAdviceInfo;
import com.boan.rees.expertsystem.service.IAdviceViewService;
import com.boan.rees.expertsystem.service.IRuleAdviceInfoService;
import com.boan.rees.utils.action.BaseActionSupport;
import com.boan.rees.utils.page.Pagination;

/**
 * 建议Action类
 * @author jiangmeidi
 * @version 1.0.0
 */
@Controller("ruleAdviceInfoAction")
@Scope("prototype")
public class RuleAdviceInfoAction extends BaseActionSupport{
	/**
	 * 用于调用数据库相关操作
	 */
	@Autowired
	@Qualifier("ruleAdviceInfoService")
	private IRuleAdviceInfoService service;
	@Autowired
	@Qualifier("adviceViewService")
	private IAdviceViewService viewservice;
	@Autowired
	@Qualifier("deviceTypeService")
	private IDeviceTypeService deviceTypeService;
	/**
	 * 分页列表
	 */
	Pagination<AdviceView> pagination = new Pagination<AdviceView>();
	/**
	 * 页面对象
	 */
	private RuleAdviceInfo ruleAdviceInfo;
	
	private AdviceView adviceView;
	private List<DeviceType> deviceTypeList;
	/**
	 * 下拉设备列表事件传递过来的设备类型Id
	 */
	//private String deviceTypeId;
	
	/**
	 * 页面所选行的id
	 */
	private String[] ids;
	
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

	public AdviceView getAdviceView() {
		return adviceView;
	}

	public void setAdviceView(AdviceView adviceView) {
		this.adviceView = adviceView;
	}

	

	public Pagination<AdviceView> getPagination() {
		return pagination;
	}

	public void setPagination(Pagination<AdviceView> pagination) {
		this.pagination = pagination;
	}

	public RuleAdviceInfo getRuleAdviceInfo() {
		return ruleAdviceInfo;
	}

	public void setRuleAdviceInfo(RuleAdviceInfo ruleAdviceInfo) {
		this.ruleAdviceInfo = ruleAdviceInfo;
	}

	public String[] getIds() {
		return ids;
	}

	public void setIds(String[] ids) {
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
	public String openRuleAdviceInfo(){
		pagination = viewservice.findAdviceViewForPage(new HashMap(), pagination);
		return this.SUCCESS;
	}

    /**
	 * 添加新建议
	 * @return
	 */
	public String toAddRuleAdviceInfo(){
		try {
			//保存设备对象
			service.save(ruleAdviceInfo);
			message="保存成功！";
		} catch (Exception e) {
			e.printStackTrace();
			message="保存失败！";
		}
		return SUCCESS;
	}

	/**
	 * 打开添加新建议页
	 * @return
	 */
	
	public String openAddRuleAdviceInfo(){
		deviceTypeList=deviceTypeService.findAllDeviceType();
		ruleAdviceInfo = new RuleAdviceInfo();
		return SUCCESS;
	}

	/**
	 * 删除建议
	 * @return
	 */
	public String deleteRuleAdviceInfo(){
		service.deleteRuleAdviceInfo(ids);
		return NONE;
	}
	
	/**
	 * 为修改建议做准备
	 * @return
	 */
	public String openModifyRuleAdviceInfo(){
		int id = ruleAdviceInfo.getId();
		ruleAdviceInfo = service.get(id);
		return SUCCESS;
	}
	
	/**
	 * 修改建议信息
	 * @return 
	 */
	public String toModifyRuleAdviceInfo(){
		try {
			service.update(ruleAdviceInfo);
			message="保存成功！";
		} catch (Exception e) {
			e.printStackTrace();
			message="保存失败！";
		}
		return SUCCESS;
	}
	
	
	
}


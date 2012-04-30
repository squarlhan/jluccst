/*
 * @(#)ThresholdItemAction.java 1.1 2012-4-29
 */

package com.boan.rees.expertsystem.threshold.action;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.boan.rees.expertsystem.model.RuleResultInfo;
import com.boan.rees.expertsystem.service.IRuleResultInfoService;
import com.boan.rees.expertsystem.threshold.model.Threshold;
import com.boan.rees.expertsystem.threshold.model.ThresholdItem;
import com.boan.rees.expertsystem.threshold.service.IThresholdItemService;
import com.boan.rees.expertsystem.threshold.service.IThresholdService;
import com.boan.rees.utils.page.Pagination;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 阈值项Action处理类
 * @author ZhuYF
 * @version 1.0.0
 */

@Controller("thresholdItemAction")
@Scope("prototype")
public class ThresholdItemAction extends ActionSupport{
	
	/**
	 * 阈值项服务接口
	 */
	@Autowired
	@Qualifier("thresholdItemService")
	private IThresholdItemService service;
	
	/**
	 * 阈值服务接口
	 */
	@Autowired
	@Qualifier("thresholdService")
	private IThresholdService thresholdService;
	
	/**
	 * 故障服务接口
	 */
	@Autowired
	@Qualifier("ruleResultInfoService")
	private IRuleResultInfoService ruleResultInfoService;
	
	
	/**
	 * 分页列表
	 */
	Pagination<ThresholdItem> pagination = new Pagination<ThresholdItem>();
	/**
	 * 页面对象
	 */
	private ThresholdItem thresholdItem;
	
	/**
	 * 阈值数组
	 */
	private List<Threshold> thresholdList;
	
	/**
	 * 故障对象数组
	 */
	private List<RuleResultInfo> ruleResultInfoList;
	
	/**
	 * 页面所选行的id
	 */
	private String[] ids;
	
	/**
	 * 操作提示
	 */
	private String message;
	
	/**
	 * 报警标识
	 */
	private String sign;
	
	
	/**
	 * 分页显示报表列表
	 * @return
	 */
	public String openThresholdItem(){
		pagination = service.findThresholdItemForPage(new HashMap(), pagination);
		return this.SUCCESS;
	}

    /**
	 * 添加新阈值项
	 * @return
	 */
	public String toAddThresholdItem(){
		try {
			//保存阈值对象
			thresholdItem.setCreateTime(Calendar.getInstance());
			thresholdItem.setSign(sign.equals("true") ? 1 :0);
			service.saveThresholdItem(thresholdItem);
			message="保存成功！";
		} catch (Exception e) {
			e.printStackTrace();
			message="保存失败！";
		}
		return SUCCESS;
	}
	/**
	 * 保存前验证
	 */
	public void validateToAddThresholdItem(){
		if(thresholdItem.getId()!=null){
			boolean flag =service.isExistThresholdItem(thresholdItem.getId().toString(),"thresholdItemName",thresholdItem.getThresholdItemName());
			if(flag){
				addFieldError("", "系统在已存在相同名称的阈值项！");
			}
		}
	}
	/**
	 * 打开添加新报表页
	 * @return
	 */
	
	public String openAddThresholdItem(){
		ruleResultInfoList = ruleResultInfoService.findRuleResultInfoByDeviceTypeId("001");
		thresholdItem = new ThresholdItem();
		return SUCCESS;
	}

	/**
	 * 删除阈值项数据
	 * @return
	 */
	public String deleteThresholdItem(){
		service.deleteThresholdItemByIds(ids);
		return NONE;
	}
	
	/**
	 * 为修改阈值项页面做准备
	 * @return
	 */
	public String openModifyThresholdItem(){
		String id = thresholdItem.getId().toString();
		thresholdItem = service.getThresholdItemById(id);
		sign = thresholdItem.getSign()==1 ? "true" : "false";
		return SUCCESS;
	}
	
	/**
	 * 修改阈值项信息
	 * @return 
	 */
	public String toModifyThresholdItem(){
		try {
			thresholdItem.setSign(sign.equals("true") ? 1 :0);
			service.updateThresholdItem(thresholdItem);
			message="保存成功！";
		} catch (Exception e) {
			e.printStackTrace();
			message="保存失败！";
		}
		return SUCCESS;
	}
	/**
	 * 保存前验证
	 */
	public void validateToModifyThresholdItem(){
		boolean flag =service.isExistThresholdItem(thresholdItem.getId().toString(),"thresholdItemName",thresholdItem.getThresholdItemName());
		if(flag){
			addFieldError("", "系统在已存在相同名称的阈值项！");
		}
	}

	public Pagination<ThresholdItem> getPagination() {
		return pagination;
	}

	public void setPagination(Pagination<ThresholdItem> pagination) {
		this.pagination = pagination;
	}

	public ThresholdItem getThresholdItem() {
		return thresholdItem;
	}

	public void setThresholdItem(ThresholdItem thresholdItem) {
		this.thresholdItem = thresholdItem;
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

	public List<Threshold> getThresholdList() {
		thresholdList = thresholdService.queryAllThreshold();
		return thresholdList;
	}

	public void setThresholdList(List<Threshold> thresholdList) {
		this.thresholdList = thresholdList;
	}

	public List<RuleResultInfo> getRuleResultInfoList() {
		return ruleResultInfoList;
	}

	public void setRuleResultInfoList(List<RuleResultInfo> ruleResultInfoList) {
		this.ruleResultInfoList = ruleResultInfoList;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}
}


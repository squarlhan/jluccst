/*
 * @(#)ThresholdCategoryAction.java 1.1 2012-4-29
 */

package com.boan.rees.expertsystem.threshold.action;

import java.util.Calendar;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.boan.rees.expertsystem.threshold.model.ThresholdCategory;
import com.boan.rees.expertsystem.threshold.service.IThresholdCategoryService;
import com.boan.rees.utils.page.Pagination;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 阈值类别Action处理类
 * @author ZhuYF
 * @version 1.0.0
 */
 @Controller("thresholdCategoryAction")
 @Scope("prototype")
public class ThresholdCategoryAction extends ActionSupport{

	/**
	 * 阈值类别服务接口
	 */
	@Autowired
	@Qualifier("thresholdCategoryService")
	private IThresholdCategoryService service;
	/**
	 * 分页列表
	 */
	Pagination<ThresholdCategory> pagination = new Pagination<ThresholdCategory>();
	/**
	 * 页面对象
	 */
	private ThresholdCategory thresholdCategory;
	
	/**
	 * 页面所选行的id
	 */
	private String[] ids;
	
	/**
	 * 操作提示
	 */
	private String message;
	
	
	/**
	 * 分页显示阈值类别列表
	 * @return
	 */
	public String openThresholdCategory(){
		pagination = service.findThresholdCategoryForPage(new HashMap(), pagination);
		return this.SUCCESS;
	}

    /**
	 * 添加新阈值类别
	 * @return
	 */
	public String toAddThresholdCategory(){
		try {
			//保存阈值对象
			thresholdCategory.setCreateTime(Calendar.getInstance());
			service.saveThresholdCategory(thresholdCategory);
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
	public void validateToAddThresholdCategory(){
		if(thresholdCategory.getId()!=null){
			boolean flag =service.isExistThresholdCategory(thresholdCategory.getId().toString(),"categoryName",thresholdCategory.getCategoryName());
			if(flag){
				addFieldError("", "系统在已存在相同名称的类别！");
			}
		}
	}
	/**
	 * 打开添加新报表页
	 * @return
	 */
	
	public String openAddThresholdCategory(){
		thresholdCategory = new ThresholdCategory();
		return SUCCESS;
	}

	/**
	 * 删除阈值类别数据
	 * @return
	 */
	public String deleteThresholdCategory(){
		service.deleteThresholdCategoryByIds(ids);
		return NONE;
	}
	
	/**
	 * 为修改阈值类别页面做准备
	 * @return
	 */
	public String openModifyThresholdCategory(){
		String id = thresholdCategory.getId().toString();
		thresholdCategory = service.getThresholdCategoryById(id);
		return SUCCESS;
	}
	
	/**
	 * 修改阈值类别信息
	 * @return 
	 */
	public String toModifyThresholdCategory(){
		try {
			service.updateThresholdCategory(thresholdCategory);
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
	public void validateToModifyThresholdCategory(){
		boolean flag =service.isExistThresholdCategory(thresholdCategory.getId().toString(),"categoryName",thresholdCategory.getCategoryName());
		if(flag){
			addFieldError("", "系统在已存在相同名称的类别！");
		}
	}

	public Pagination<ThresholdCategory> getPagination() {
		return pagination;
	}

	public void setPagination(Pagination<ThresholdCategory> pagination) {
		this.pagination = pagination;
	}

	public ThresholdCategory getThresholdCategory() {
		return thresholdCategory;
	}

	public void setThresholdCategory(ThresholdCategory thresholdCategory) {
		this.thresholdCategory = thresholdCategory;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String[] getIds() {
		return ids;
	}

	public void setIds(String[] ids) {
		this.ids = ids;
	}
}


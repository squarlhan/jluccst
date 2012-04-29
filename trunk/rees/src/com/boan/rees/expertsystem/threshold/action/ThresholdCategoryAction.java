/*
 * @(#)ThresholdCategoryAction.java 1.1 2012-4-29
 */

package com.boan.rees.expertsystem.threshold.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.boan.rees.expertsystem.threshold.ThresholdCategory;
import com.boan.rees.expertsystem.threshold.service.IThresholdCategoryService;
import com.boan.rees.utils.page.Pagination;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 阈值类别Action处理类
 * @author ZhuYF
 * @version 1.0.0
 */
public class ThresholdCategoryAction extends ActionSupport{

	/**
	 * 用于调用数据库相关操作
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
	 * 分页显示报表列表
	 * @return
	 */
	public String openDeviceType(){
//		pagination = service.findDeviceTypeForPage(new HashMap(), pagination);
		return this.SUCCESS;
	}

    /**
	 * 添加新报表
	 * @return
	 */
	public String toAddThresholdCategory(){
		try {
			//保存设备对象
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
		boolean flag =false;//= service.isExistDeviceTypeProperty(thresholdCategory.getId(),"typeName",thresholdCategory.getCategoryName());
		if(flag){
			addFieldError("", "系统在已存在相同名称的设备类型！");
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
	 * 删除报表数据
	 * @return
	 */
	public String deleteDeviceType(){
		service.deleteThresholdCategoryByIds(ids);
		return NONE;
	}
	
	/**
	 * 为修改报表页面做准备
	 * @return
	 */
	public String openModifyThresholdCategory(){
		String id = thresholdCategory.getId().toString();
		thresholdCategory = service.getThresholdCategoryById(id);
		return SUCCESS;
	}
	
	/**
	 * 修改报表信息
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
	public void validateToModifyDeviceType(){
//		boolean flag = service.isExistDeviceTypeProperty(thresholdCategory.getId(),"typeName",thresholdCategory.getTypeName());
//		if(flag){
//			addFieldError("", "系统在已存在相同名称的设备类型！");
//		}
	}
}


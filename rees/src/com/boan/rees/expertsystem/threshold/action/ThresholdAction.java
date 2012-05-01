/*
 * @(#)ThresholdAction.java 1.1 2012-4-29
 */

package com.boan.rees.expertsystem.threshold.action;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.boan.rees.device.model.PointParamInfo;
import com.boan.rees.expertsystem.threshold.model.CenterHeightAndSpeed;
import com.boan.rees.expertsystem.threshold.model.Threshold;
import com.boan.rees.expertsystem.threshold.model.ThresholdCategory;
import com.boan.rees.expertsystem.threshold.service.IThresholdCategoryService;
import com.boan.rees.expertsystem.threshold.service.IThresholdService;
import com.boan.rees.utils.page.Pagination;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 阈值Action处理类
 * @author ZhuYF
 * @version 1.0.0
 */
@Controller("thresholdAction")
@Scope("prototype")
public class ThresholdAction extends ActionSupport{
	/**
	 * 阈值服务接口
	 */
	@Autowired
	@Qualifier("thresholdService")
	private IThresholdService service;
	
	/**
	 * 阈值类别服务接口
	 */
	@Autowired
	@Qualifier("thresholdCategoryService")
	private IThresholdCategoryService thresholdCategoryService;
	
	/**
	 * 分页列表
	 */
	Pagination<Threshold> pagination = new Pagination<Threshold>();
	/**
	 * 页面对象
	 */
	private Threshold threshold;
	
	/**
	 * 页面对象
	 */
	private List<ThresholdCategory> thresholdCategoryList;
	
	/**
	 * 页面所选行的id
	 */
	private String[] ids;
	
	/**
	 * 操作提示
	 */
	private String message;

	/**
	 * 阈值取值范围
	 */
	private List<CenterHeightAndSpeed> centerHeightAndSpeedList;
	
	/**
	 * 中心高转速对象Id
	 */
	private String centerHeightAndSpeedId;
	
	/**
	 * 中心高
	 */
	private String centerHeightExpression;
	
	/**
	 * 转速
	 */
	private String speedExpression;
	
	/**
	 * 分页显示报表列表
	 * @return
	 */
	public String openThreshold(){
		pagination = service.findThresholdForPage(new HashMap(), pagination);
		return this.SUCCESS;
	}

    /**
	 * 添加新阈值
	 * @return
	 */
	public String toAddThreshold(){
		try {
			//保存阈值对象
			List<CenterHeightAndSpeed> list = new ArrayList<CenterHeightAndSpeed>();
			String[] speeds = speedExpression.split(",");
			String[] centerHeights = centerHeightExpression.split(",");
			for(int i=0;i<speeds.length;i++){
				CenterHeightAndSpeed centerHeightAndSpeed = new CenterHeightAndSpeed();
				centerHeightAndSpeed.setCenterHeightExpression(centerHeights[i].trim());
				centerHeightAndSpeed.setSpeedExpression(speeds[i].trim());
				list.add(centerHeightAndSpeed);
			}
			threshold.setCenterHeightAndSpeeds(list);
			threshold.setCreateTime(Calendar.getInstance());
			service.saveThreshold(threshold);
			message="保存成功！";
			centerHeightAndSpeedList = threshold.getCenterHeightAndSpeeds();
		} catch (Exception e) {
			e.printStackTrace();
			message="保存失败！";
		}
		return SUCCESS;
	}
	/**
	 * 保存前验证
	 */
	public void validateToAddThreshold(){
		if(threshold.getId()!=null){
			boolean flag =service.isExistThreshold(threshold.getId().toString(),"thresholdName",threshold.getThresholdName());
			if(flag){
				addFieldError("", "系统在已存在相同名称的阈值！");
			}
		}
	}
	/**
	 * 打开添加新报表页
	 * @return
	 */
	
	public String openAddThreshold(){
		threshold = new Threshold();
		centerHeightAndSpeedList = new ArrayList<CenterHeightAndSpeed>();
		centerHeightAndSpeedList.add(new CenterHeightAndSpeed());
		return SUCCESS;
	}

	/**
	 * 删除阈值数据
	 * @return
	 */
	public String deleteThreshold(){
		service.deleteThresholdByIds(ids);
		return NONE;
	}
	
	/**
	 * 为修改阈值页面做准备
	 * @return
	 */
	public String openModifyThreshold(){
		String id = threshold.getId().toString();
		threshold = service.getThresholdById(id);
		if(threshold!=null){
			centerHeightAndSpeedList = threshold.getCenterHeightAndSpeeds();
		}
		return SUCCESS;
	}
	
	/**
	 * 修改阈值信息
	 * @return 
	 */
	public String toModifyThreshold(){
		try {
			//保存阈值对象
			List<CenterHeightAndSpeed> list = new ArrayList<CenterHeightAndSpeed>();
			String[] speeds = speedExpression.split(",");
			String[] centerHeights = centerHeightExpression.split(",");
			for(int i=0;i<speeds.length;i++){
				CenterHeightAndSpeed centerHeightAndSpeed = new CenterHeightAndSpeed();
				centerHeightAndSpeed.setCenterHeightExpression(centerHeights[i].trim());
				centerHeightAndSpeed.setSpeedExpression(speeds[i].trim());
				list.add(centerHeightAndSpeed);
			}
			threshold.setCenterHeightAndSpeeds(list);
			service.updateThreshold(threshold);
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
	public void validateToModifyThreshold(){
		boolean flag =service.isExistThreshold(threshold.getId().toString(),"thresholdName",threshold.getThresholdName());
		if(flag){
			addFieldError("", "系统在已存在相同名称的阈值！");
		}
	}
	
	/**
	 * 删除阈值数据
	 * @return
	 */
	public String deleteCenterHeightAndSpeed(){
		service.deleteCenterHeightAndSpeedByIds(centerHeightAndSpeedId);
		return NONE;
	}
	

	public Pagination<Threshold> getPagination() {
		return pagination;
	}

	public void setPagination(Pagination<Threshold> pagination) {
		this.pagination = pagination;
	}

	public Threshold getThreshold() {
		return threshold;
	}

	public void setThreshold(Threshold Threshold) {
		this.threshold = Threshold;
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

	public List<ThresholdCategory> getThresholdCategoryList() {
		thresholdCategoryList = thresholdCategoryService.queryAllThresholdCategory();
		return thresholdCategoryList;
	}

	public void setThresholdCategoryList( List<ThresholdCategory> thresholdCategoryList) {
		this.thresholdCategoryList = thresholdCategoryList;
	}

	public List<CenterHeightAndSpeed> getCenterHeightAndSpeedList() {
		return centerHeightAndSpeedList;
	}

	public void setCenterHeightAndSpeedList(
			List<CenterHeightAndSpeed> centerHeightAndSpeedList) {
		this.centerHeightAndSpeedList = centerHeightAndSpeedList;
	}

	public String getCenterHeightAndSpeedId() {
		return centerHeightAndSpeedId;
	}

	public void setCenterHeightAndSpeedId(String centerHeightAndSpeedId) {
		this.centerHeightAndSpeedId = centerHeightAndSpeedId;
	}

	public String getCenterHeightExpression() {
		return centerHeightExpression;
	}

	public void setCenterHeightExpression(String centerHeightExpression) {
		this.centerHeightExpression = centerHeightExpression;
	}

	public String getSpeedExpression() {
		return speedExpression;
	}

	public void setSpeedExpression(String speedExpression) {
		this.speedExpression = speedExpression;
	}
}


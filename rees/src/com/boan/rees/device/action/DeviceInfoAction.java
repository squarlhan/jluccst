package com.boan.rees.device.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.boan.rees.device.model.DeviceInfo;
import com.boan.rees.device.service.IDeviceInfoService;
import com.boan.rees.utils.page.Pagination;
import com.opensymphony.xwork2.ActionSupport;
/**
 * 设备管理Action
 * @author JiangMD
 * @version 1.0.0
 */
@Controller("deviceInfoAction")
@Scope("prototype")
public class DeviceInfoAction extends ActionSupport{

	/**
	 * 用于调用数据库相关操作
	 */
	@Autowired
	@Qualifier("deviceInfoService")
	private IDeviceInfoService service;
	/**
	 * 分页列表
	 */
	Pagination<DeviceInfo> pagination = new Pagination<DeviceInfo>();
	/**
	 * 页面对象
	 */
	private DeviceInfo device;
	
	
	public DeviceInfo getDevice() {
		return device;
	}

	public void setDevice(DeviceInfo device) {
		this.device = device;
	}
	public Pagination<DeviceInfo> getPagination() {
		return pagination;
	}

	public void setPagination(Pagination<DeviceInfo> pagination) {
		this.pagination = pagination;
	}
//*************************************************************************************
	
	/**
	 * 分页显示设备列表
	 * @return
	 */
	public String openDevice(){
		pagination = service.findDeviceInfoForPage(null, pagination);
		return this.SUCCESS;
	}

	
    /**
	 * 添加新设备
	 * @return
	 */
	public String toAddDevice(){
		device.setDeptId("1");
		device.setGroupId("1");
	
		service.save(device);
		return SUCCESS;
	}
	/**
	 * 打开添加新设备页
	 * @return
	 */
	
	public String openAddDevice (){
		return SUCCESS;
	}


}

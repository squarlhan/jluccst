package com.boan.rees.device.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.boan.rees.device.model.DeviceInfo;
import com.boan.rees.device.service.IDeviceInfoService;
import com.boan.rees.utils.action.BaseActionSupport;
import com.boan.rees.utils.page.Pagination;
import com.opensymphony.xwork2.ActionSupport;
/**
 * 设备管理Action
 * @author JiangMD
 * @version 1.0.0
 */
@Controller("deviceInfoAction")
@Scope("prototype")
public class DeviceInfoAction extends BaseActionSupport{

	/**
	 * 用于调用数据库相关操作
	 */
	@Autowired
	@Qualifier("deviceInfoService")
	private IDeviceInfoService service;
	
	/**
	 * 分页列表
	 */
	private Pagination<DeviceInfo> pagination = new Pagination<DeviceInfo>();
	
	/**
	 * 定义一个设备数组，用于排序功能使用
	 */
	private List<DeviceInfo> deviceInfoList = new ArrayList<DeviceInfo>();
	
	/**
	 * 页面对象
	 */
	private DeviceInfo device;
	
	/**
	 * 页面所选行的id
	 */
	private String[] ids;
	
	
	public String[] getIds() {
		return ids;
	}

	public void setIds(String[] ids) {
		this.ids = ids;
	}

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
	
	public List<DeviceInfo> getDeviceInfoList() {
		return deviceInfoList;
	}

	public void setDeviceInfoList(List<DeviceInfo> deviceInfoList) {
		this.deviceInfoList = deviceInfoList;
	}
//*************************************************************************************

	/**
	 * 分页显示设备列表
	 * @return
	 */
	public String openDevice(){
		pagination = service.findDeviceInfoForPage(new HashMap(), pagination);
		return this.SUCCESS;
	}

	
    /**
	 * 添加新设备
	 * @return
	 */
	public String toAddDevice(){
		device.setDeptId(workshopId);
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

	/**
	 * 删除数据
	 * @return
	 */
	public String deleteDevice(){
		service.deleteDeviceInfo(ids);
		return NONE;
	}
	
	/**
	 * 为修改页面做准备
	 * @return
	 */
	public String openModifyDevice(){
		String id = device.getId();
		device = service.get(id);
		return SUCCESS;
	}
	
	/**
	 * 修改设备信息
	 * @return
	 */
	public String toModifyDevice(){
		device.setDeptId("1");
		device.setGroupId("1");
		service.update(device);
		return SUCCESS;
	}

	/**
	 * 打开排序页面
	 * @return
	 */
	public String openSortDevice(){
		deviceInfoList = service.findAllDeviceInfo();
		return SUCCESS;
	}
	
	/**
	 * 执行排序
	 * @return
	 */
	public String toSortDevice(){
		service.sortDeviceInfo(ids);
		return SUCCESS;
	}
}

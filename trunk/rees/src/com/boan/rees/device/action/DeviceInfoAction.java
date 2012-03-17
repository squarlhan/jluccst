package com.boan.rees.device.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.boan.rees.device.model.DeviceInfo;
import com.boan.rees.device.service.IDeviceInfoService;
import com.boan.rees.utils.page.Pagination;
import com.opensymphony.xwork2.ActionSupport;

@Controller("deviceInfoAction")
@Scope("prototype")
public class DeviceInfoAction extends ActionSupport{

	/**
	 * 分页列表
	 */
	Pagination<DeviceInfo> pagination = new Pagination<DeviceInfo>();
	
	@Autowired
	@Qualifier("deviceInfoService")
	private IDeviceInfoService service;
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

	/**
	 * 显示设备列表
	 * @return
	 */
	public String openDevice(){
//		Map<String,String> values =new HashMap<String, String>();
//		values.put("dataInfo","90");
		pagination = service.findDeviceInfoForPage(null, pagination);
		return this.SUCCESS;
	}

	public Pagination<DeviceInfo> getPagination() {
		return pagination;
	}

	public void setPagination(Pagination<DeviceInfo> pagination) {
		this.pagination = pagination;
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
	
	public String openAddDevice (){
		return SUCCESS;
	}


}

package com.boan.rees.device.type.action;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.boan.rees.device.type.model.DeviceType;
import com.boan.rees.device.type.service.IDeviceTypeService;
import com.boan.rees.utils.action.BaseActionSupport;
import com.boan.rees.utils.page.Pagination;



/**
 * 报表Action
 * @author Jiangmeidi
 * @version 1.0.0
 */

@Controller("deviceTypeAction")
@Scope("prototype")
public class DeviceTypeAction extends BaseActionSupport{
	/**
	 * 用于调用数据库相关操作
	 */
	@Autowired
	@Qualifier("deviceTypeService")
	private IDeviceTypeService service;
	/**
	 * 分页列表
	 */
	Pagination<DeviceType> pagination = new Pagination<DeviceType>();
	/**
	 * 页面对象
	 */
	private DeviceType deviceType;
	/**
	 * 页面所选行的id
	 */
	private String[] ids;

	

	
	public DeviceType getDeviceType() {
		return deviceType;
	}

	public void setDeviceType(DeviceType deviceType) {
		this.deviceType = deviceType;
	}


	public String[] getIds() {
		return ids;
	}

	public void setIds(String[] ids) {
		this.ids = ids;
	}
	
	public Pagination<DeviceType> getPagination() {
		return pagination;
	}

	public void setPagination(Pagination<DeviceType> pagination) {
		this.pagination = pagination;
	}


	/**
	 * 分页显示报表列表
	 * @return
	 */
	public String openDeviceType(){
		pagination = service.findDeviceTypeForPage(new HashMap(), pagination);
		return this.SUCCESS;
	}

	
    /**
	 * 添加新报表
	 * @return
	 */
	public String toAddDeviceType(){
		
		service.save(deviceType);
		return SUCCESS;
	}
	/**
	 * 打开添加新报表页
	 * @return
	 */
	
	public String openAddDeviceType(){
		return SUCCESS;
	}

	/**
	 * 删除报表数据
	 * @return
	 */
	public String deleteDeviceType(){
		service.deleteDeviceType(ids);
		return NONE;
	}
	
	/**
	 * 为修改报表页面做准备
	 * @return
	 */
	public String openModifyDeviceType(){
		String id = deviceType.getId();
		deviceType = service.get(id);
		return SUCCESS;
	}
	
	/**
	 * 修改报表信息
	 * @return 
	 */
	public String toModifyDeviceType(){
		
		service.update(deviceType);
		return SUCCESS;
	}
	

	
}




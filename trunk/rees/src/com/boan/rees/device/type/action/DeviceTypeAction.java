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
 * 设备类型Action
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
	 * 下拉设备列表事件传递过来的设备类型Id
	 */
	private String deviceTypeId;
	
	/**
	 * 页面所选行的id
	 */
	private String[] ids;
	
	/**
	 * 操作提示
	 */
	private String message;
	
	public DeviceType getDeviceType() {
		return deviceType;
	}

	public void setDeviceType(DeviceType deviceType) {
		this.deviceType = deviceType;
	}

	public String getDeviceTypeId() {
		return deviceTypeId;
	}

	public void setDeviceTypeId(String deviceTypeId) {
		this.deviceTypeId = deviceTypeId;
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

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * 分页显示设备类型列表
	 * @return
	 */
	public String openDeviceType(){
		pagination = service.findDeviceTypeForPage(new HashMap(), pagination);
		return this.SUCCESS;
	}

    /**
	 * 添加新设备类型
	 * @return
	 */
	public String toAddDeviceType(){
		try {
			//保存设备对象
			service.save(deviceType);
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
	public void validateToAddDeviceType(){
		boolean flag = service.isExistDeviceTypeProperty(deviceType.getId(),"typeName",deviceType.getTypeName());
		if(flag){
			addFieldError("", "系统在已存在相同名称的设备类型！");
		}
	}
	/**
	 * 打开添加新设备类型页
	 * @return
	 */
	
	public String openAddDeviceType(){
		deviceType = new DeviceType();
		return SUCCESS;
	}

	/**
	 * 删除设备类型数据
	 * @return
	 */
	public String deleteDeviceType(){
		service.deleteDeviceType(ids);
		return NONE;
	}
	
	/**
	 * 为修改设备类型页面做准备
	 * @return
	 */
	public String openModifyDeviceType(){
		String id = deviceType.getId();
		deviceType = service.get(id);
		return SUCCESS;
	}
	
	/**
	 * 修改设备类型信息
	 * @return 
	 */
	public String toModifyDeviceType(){
		try {
			service.update(deviceType);
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
		boolean flag = service.isExistDeviceTypeProperty(deviceType.getId(),"typeName",deviceType.getTypeName());
		if(flag){
			addFieldError("", "系统在已存在相同名称的设备类型！");
		}
	}
	
	/**
	 * 查询设备类型信息，用于异步事件
	 * @return
	 */
	public String toGetDeviceTypeInfo(){
		deviceType = this.service.get(deviceTypeId);
		return SUCCESS;
	}
}




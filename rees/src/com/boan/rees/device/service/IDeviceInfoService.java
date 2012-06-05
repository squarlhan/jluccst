package com.boan.rees.device.service;

import java.util.List;
import java.util.Map;

import com.boan.rees.device.model.DeviceInfo;

import com.boan.rees.utils.page.Pagination;
/**
 * 设备服务类接口
 * @author jiangmeidi
 * @version 1.0.0
 */

public interface IDeviceInfoService {
	/**
	 * 查找全部设备
	 */
    public List<DeviceInfo> findAllDeviceInfo();
    /**
	 * 根据id获取设备
	 */
	public DeviceInfo get(String id);
	/**
	 * 删除设备
	 */
	public void deleteDeviceInfo(String... ids );
	/**
	 * 保存设备
	 */
	public void save(DeviceInfo table1);
	
	/**
	 * 修改设备信息
	 * @param deviceInfo 设备对象
	 */
	public void update(DeviceInfo deviceInfo);
	/**
	 * 按分页查找设备
	 */
	public Pagination<DeviceInfo> findDeviceInfoForPage(Map<String, ?> values,Pagination<DeviceInfo> pagination);
	
	/**
	 * 根据组织机构查询组织机构下的设备
	 * @param companyId 公司Id
	 * @param factoryId 工厂Id
	 * @param workshopId 车间Id
	 * @return
	 */
	public List<DeviceInfo> findDeviceInfoByOrgan(String companyId,String factoryId,String workshopId );
	
	/**
	 * 设备排序
	 * @param ids 有顺序的设备Id数组
	 */
	public void sortDeviceInfo(String... ids);
	
	/**
	 * 删除设备图片
	 * @param deviceId 设备Id
	 */
	public void deleteDeviceImage(String deviceId);
	
	/**
	 * 查找根据车间Id查询设备
	 * @param workshopId 车间Id
	 * @return 设备列表
	 */
    public List<DeviceInfo> findDeviceInfoByWorkshopId(String workshopId);
    
    /**
     * 查找根据设备类型Id查询设备
     * @param deviceTypeId 设备类型Id
     * @return 设备列表
     */
    public List<DeviceInfo> findDeviceInfoByDeviceTypeId(String deviceTypeId);
    
    /**
     * 判断指定Id的设备是否存在指定属性和属性值的记录
     * @param id 设备Id
     * @param workshopId 车间Id
     * @param propertyName 设备属性
     * @param propertyValue 设备属性值
     * @return true：存在 false：不存在
     */
    public boolean isExistDeviceInfoProperty(String id,String workshopId ,String propertyName,String propertyValue);
}

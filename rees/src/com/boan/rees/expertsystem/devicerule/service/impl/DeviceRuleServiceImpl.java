/*
 * @(#)DeviceRuleServiceImpl.java 1.1 2012-5-2
 */

package com.boan.rees.expertsystem.devicerule.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.boan.rees.device.type.model.DeviceType;
import com.boan.rees.expertsystem.devicerule.dao.IDeviceRuleDao;
import com.boan.rees.expertsystem.devicerule.model.DeviceRuleInfo;
import com.boan.rees.expertsystem.devicerule.service.IDeviceRuleService;
import com.boan.rees.utils.page.Pagination;

/**
 * XXX 类
 * @author ZhuYF
 * @version 1.0.0
 */
@Service("deviceRuleService")
public class DeviceRuleServiceImpl implements IDeviceRuleService{
	@Autowired
	@Qualifier("deviceRuleDao")
	private IDeviceRuleDao deviceRuleDao;

	/**
	 * 查询设备规则列表
	 * @return
	 */
	public List<DeviceRuleInfo> findAllDeviceRuleInfo(){
		return deviceRuleDao.findAll();
	}

	/**
	 * 根据id获取设备规则
	 */
	public DeviceRuleInfo get(String id){
		return deviceRuleDao.get(Integer.parseInt(id));
	}

	/**
	 * 删除设备规则
	 */
	public void deleteDeviceRuleInfo(String... ids){
		Integer[] temp = new Integer[ids.length];
		for(int i=0;i<ids.length;i++){
			temp[i]= Integer.parseInt(ids[i]);
		}
		deviceRuleDao.delete(temp);
	}

	/**
	 * 保存设备规则
	 */
	public void save(DeviceRuleInfo table1){
		deviceRuleDao.save(table1);
	}

	/**
	 * 修改设备规则信息
	 * @param deviceInfo 设备对象
	 */
	public void update(DeviceRuleInfo deviceInfo){
		deviceRuleDao.update(deviceInfo);
	}

	/**
	 * 按分页查找设备规则
	 */
	public Pagination<DeviceRuleInfo> findDeviceRuleInfoForPage(Map<String, ?> values, Pagination<DeviceRuleInfo> pagination){
		String hql = "from DeviceRuleInfo";
		List<DeviceRuleInfo> data = deviceRuleDao.findForPage(hql, values, pagination.getStartIndex(), pagination.getPageSize());
		hql = "select count(*) from DeviceRuleInfo";
		int totalRows = deviceRuleDao.findCountForPage(hql, values);
		pagination.setTotalRows(totalRows);
		pagination.setData(data);
		return pagination;
	}

	/**
	 * 判断指定Id的设备规则是否存在指定属性和属性值的记录
	 * 
	 * @param id Id
	 * @param propertyName 属性
	 * @param propertyValue 属性值
	 * @return true：存在 false：不存在
	 */
	public boolean isExistDeviceRuleInfoProperty(String id, String propertyName , String propertyValue){
		 String hql = "from DeviceRuleInfo where "+propertyName+"=:"+propertyName+")";
			Map<String, Object> values = new HashMap<String,Object>();
			values.put(propertyName,propertyValue);
			List<DeviceType> list = deviceRuleDao.find(hql,values);
			deviceRuleDao.clearSession();
			if(list!=null && list.size()>0){
				if(list.get(0).getId().equals(id)){
					return false;
				}else{
					return true;
				}
			}else{
				return false;
			}
	}
}


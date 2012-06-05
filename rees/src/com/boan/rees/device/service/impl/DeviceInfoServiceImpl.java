package com.boan.rees.device.service.impl;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.boan.rees.device.dao.IDeviceInfoDao;
import com.boan.rees.device.model.DeviceInfo;
import com.boan.rees.device.service.IDeviceInfoService;
import com.boan.rees.utils.page.Pagination;
@Service("deviceInfoService")
public class DeviceInfoServiceImpl  implements IDeviceInfoService {
	@Autowired
	@Qualifier("deviceInfoDao")
	private IDeviceInfoDao deviceInfoDao;
	
	@Override
	/**
	 * 查找全部设备
	 */
	public List<DeviceInfo> findAllDeviceInfo() {
		String hql = "from DeviceInfo where (isDelete is not null  and isDelete<>1 ) order by sortIndex,createTime";
		return deviceInfoDao.queryAll(hql);
		
	}
	/**
	 * 根据id查找设备
	 */
	@Override
	public DeviceInfo get(String id) {
		
		return deviceInfoDao.get(id);
	}
	/**
	 * 根据id删除设备
	 */

	@Override
	public void deleteDeviceInfo(String... ids) {
		String hql = "update DeviceInfo obj set obj.isDelete=1 where id in (:id)";
		Map<String, String[]> values = new HashMap<String,String[]>();
		values.put("id", ids);
		deviceInfoDao.executeHql(hql, values );
//		deviceInfoDao.delete(ids);
	}
	/**
	 * 保存设备
	 */
	@Override
	public void save(DeviceInfo table1) {
		deviceInfoDao.save(table1);
	}
	
	/**
	 * 修改设备信息
	 * @param deviceInfo 设备对象
	 */
	public void update(DeviceInfo deviceInfo){
		deviceInfoDao.update(deviceInfo);
	}
	
	/**
	 * 按分页查询设备
	 */
	@Override
	public Pagination<DeviceInfo> findDeviceInfoForPage(Map<String, ?> values,Pagination<DeviceInfo> pagination){
		
		String hql = null;
		String hqlCount = null;
		String companyId = (String)values.get( "companyId" );
		String factoryId = (String)values.get( "factoryId" );
		String workshopId = (String)values.get( "workshopId" );
		Map<String, Object > map = new HashMap<String ,Object>();
		//表示公司
		if( StringUtils.isNotBlank( companyId ) && StringUtils.isBlank( factoryId ) && StringUtils.isBlank( workshopId ))
		{
			hql = "from DeviceInfo where (isDelete is null or isDelete=0) and companyId = :companyId and ( factoryId is null or factoryId = '' ) and ( workshopId is null or workshopId = '') order by sortIndex,createTime";
			hqlCount = "select count(*) from DeviceInfo where (isDelete is null or isDelete=0) and companyId = :companyId and ( factoryId is null or factoryId = '' ) and ( workshopId is null or workshopId = '') ";
			map.put( "companyId", companyId );
		}
		//表示工厂
		else if( StringUtils.isNotBlank( companyId ) && StringUtils.isNotBlank( factoryId ) && StringUtils.isBlank( workshopId ))
		{
			hql = "from DeviceInfo where(isDelete is null or isDelete=0) and companyId = :companyId and factoryId = :factoryId and ( workshopId is null or workshopId = '') order by sortIndex,createTime";
			hqlCount = "select count(*) from DeviceInfo where (isDelete is null or isDelete=0) and companyId = :companyId and  factoryId = :factoryId  and ( workshopId is null or workshopId = '') ";
			map.put( "companyId", companyId );
			map.put( "factoryId", factoryId );
		}
		//表示车间
		else if( StringUtils.isNotBlank( companyId ) && StringUtils.isNotBlank( factoryId ) && StringUtils.isNotBlank( workshopId ))
		{
			hql = "from DeviceInfo where (isDelete is null or isDelete=0) and companyId = :companyId and factoryId = :factoryId and workshopId = :workshopId order by sortIndex,createTime";
			hqlCount = "select count(*) from DeviceInfo where (isDelete is null or isDelete=0) and companyId = :companyId and  factoryId = :factoryId  and workshopId = :workshopId ";
			map.put( "companyId", companyId );
			map.put( "factoryId", factoryId );
			map.put( "workshopId", workshopId );
		}
		List<DeviceInfo> data = deviceInfoDao.findForPage(hql, map, pagination.getStartIndex(), pagination.getPageSize());
		int totalRows = deviceInfoDao.findCountForPage(hqlCount, map);
		pagination.setTotalRows(totalRows);
		pagination.setData(data);
		return pagination;
	}
	/**
	 * 根据组织机构查询组织机构下的设备
	 * @param companyId 公司Id
	 * @param factoryId 工厂Id
	 * @param workshopId 车间Id
	 * @return
	 */
	public List<DeviceInfo> findDeviceInfoByOrgan(String companyId,String factoryId,String workshopId ){
		
		String hql = null;
		companyId  = companyId==null ? "" : companyId;
		factoryId  = factoryId==null ? "" : factoryId;
		workshopId = workshopId==null ? "" : workshopId;
		Map<String, Object > map = new HashMap<String ,Object>();
		//表示公司
		if( StringUtils.isNotBlank( companyId ) && StringUtils.isBlank( factoryId ) && StringUtils.isBlank( workshopId ))
		{
			hql = "from DeviceInfo where (isDelete is null or isDelete=0) and companyId = :companyId and ( factoryId is null or factoryId = '' ) and ( workshopId is null or workshopId = '') order by sortIndex,createTime";
			map.put( "companyId", companyId );
		}
		//表示工厂
		else if( StringUtils.isNotBlank( companyId ) && StringUtils.isNotBlank( factoryId ) && StringUtils.isBlank( workshopId ))
		{
			hql = "from DeviceInfo where(isDelete is null or isDelete=0) and companyId = :companyId and factoryId = :factoryId and ( workshopId is null or workshopId = '') order by sortIndex,createTime";
			map.put( "companyId", companyId );
			map.put( "factoryId", factoryId );
		}
		//表示车间
		else if( StringUtils.isNotBlank( companyId ) && StringUtils.isNotBlank( factoryId ) && StringUtils.isNotBlank( workshopId ))
		{
			hql = "from DeviceInfo where (isDelete is null or isDelete=0) and companyId = :companyId and factoryId = :factoryId and workshopId = :workshopId order by sortIndex,createTime";
			map.put( "companyId", companyId );
			map.put( "factoryId", factoryId );
			map.put( "workshopId", workshopId );
		}
		List<DeviceInfo> data = deviceInfoDao.find(hql, map);
		return data;
	}

	/**
	 * 设备排序
	 * @param ids 有顺序的设备Id数组
	 */
	public void sortDeviceInfo(String... ids){
		for(int i=0;i<ids.length;i++){
			String hql = "update DeviceInfo obj set obj.sortIndex="+(i+1)+" where obj.id='"+ids[i]+"'";
			deviceInfoDao.executeHql(hql, null);
		}
	}
	
	/**
	 * 删除设备图片
	 * @param deviceId 设备Id
	 */
	public void deleteDeviceImage(String deviceId){
		String hql = "update DeviceInfo obj set obj.filePath=null where obj.id='"+deviceId+"'";
		deviceInfoDao.executeHql(hql, null);
	}
	
	/**
	 * 查找根据车间Id查询设备
	 * @param workshopId 车间Id
	 * @return 设备列表
	 */
	@Override
	public List<DeviceInfo> findDeviceInfoByWorkshopId(String workshopId) {
		String hql = "from DeviceInfo where (isDelete=0 or isDelete is null) and workshopId=? order by sortIndex,createTime";
		List<DeviceInfo> list = deviceInfoDao.find(hql, new String[]{workshopId});
		return list;
	}
	
    /**
     * 查找根据设备类型Id查询设备
     * @param deviceTypeId 设备类型Id
     * @return 设备列表
     */
    public List<DeviceInfo> findDeviceInfoByDeviceTypeId(String deviceTypeId){
    	String hql = "from DeviceInfo where (isDelete=0 or isDelete is null) and deviceTypeId=? order by sortIndex,createTime";
		List<DeviceInfo> list = deviceInfoDao.find(hql, new String[]{deviceTypeId});
		return list;
    }
	
	/**
     * 判断指定Id的设备是否存在指定属性和属性值的记录
     * @param id 设备Id
     * @param workshopId 车间Id
     * @param propertyName 设备属性
     * @param propertyValue 设备属性值
     * @return true：存在 false：不存在
     */
    public boolean isExistDeviceInfoProperty(String id,String workshopId ,String propertyName,String propertyValue){
		String hql = "from DeviceInfo where "+propertyName+"=:"+propertyName+" and workshopId=:workshopId and (isDelete=0 or isDelete is null)";
		Map<String, Object> values = new HashMap<String,Object>();
		values.put("workshopId",workshopId);
		values.put(propertyName,propertyValue);
		List<DeviceInfo> list = deviceInfoDao.find(hql,values);
		deviceInfoDao.clearSession();
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

/*
 * @(#)SpecialDeviceRuleServiceImpl.java 1.1 2012-9-17
 */

package com.boan.rees.expertsystem.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.boan.rees.device.dao.IDeviceInfoDao;
import com.boan.rees.device.model.DeviceInfo;
import com.boan.rees.expertsystem.dao.ISpecialDeviceRuleDao;
import com.boan.rees.expertsystem.model.SpecialDeviceRuleInfo;
import com.boan.rees.expertsystem.service.ISpecialDeviceRuleService;
import com.boan.rees.utils.page.Pagination;

/**
 * XXX 类
 * @author jiangmeidi
 * @version 1.0.0
 */
@Service("specialDeviceRuleService")
public class SpecialDeviceRuleServiceImpl implements ISpecialDeviceRuleService {

	@Autowired
	@Qualifier("specialDeviceRuleDao")
	private ISpecialDeviceRuleDao specialDeviceRuleDao;
	
	@Autowired
	@Qualifier("deviceInfoDao")
	private IDeviceInfoDao deviceInfoDao;
	
	@Override
	public List<SpecialDeviceRuleInfo> findAllRuleInfo(){
		
//		return specialDeviceRuleDao.findAll();
		String hql = "select new SpecialDeviceRuleInfo (A.id) from DeviceInfo A left join SpecialDeviceRuleInfo  B on A.id = B.deviceId";
		List<SpecialDeviceRuleInfo> data = specialDeviceRuleDao.find(hql, new HashMap());
		return null;
	}
	
	@Override
	public SpecialDeviceRuleInfo get(String id){
		return specialDeviceRuleDao.get(id);
	}

	@Override
	public void deleteRuleInfo(String... ids ){
		specialDeviceRuleDao.delete(ids);
	}
	@Override
	public void save(SpecialDeviceRuleInfo table1){
		specialDeviceRuleDao.save(table1);
	}
	@Override
	public void update(SpecialDeviceRuleInfo ruleInfo){
		specialDeviceRuleDao.update(ruleInfo);
	}
	@Override
	public Pagination<SpecialDeviceRuleInfo> findRuleInfoForPage(Map<String, ?> values,Pagination<SpecialDeviceRuleInfo> pagination){
		
//		String hql = "from SpecialDeviceRuleInfo";
//		List<SpecialDeviceRuleInfo> data = specialDeviceRuleDao.findForPage(hql, values, pagination.getStartIndex(), pagination.getPageSize());
//		hql = "select count(*) from SpecialDeviceRuleInfo";
//		int totalRows = specialDeviceRuleDao.findCountForPage(hql, values);
//		pagination.setTotalRows(totalRows);
//		pagination.setData(data);
//		return pagination;
		 List<SpecialDeviceRuleInfo> list = new ArrayList<SpecialDeviceRuleInfo>();
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
		List<SpecialDeviceRuleInfo> data = deviceInfoDao.findForPage(hql, map, pagination.getStartIndex(), pagination.getPageSize());
		for(Object obj : data){
			DeviceInfo tt = (DeviceInfo)obj;
			 List<SpecialDeviceRuleInfo> temp = findSpecialDeviceRuleByDeviceId( tt.getId());
			 if(temp!=null && temp.size()>0 && temp.get(0)!=null){
				 list.addAll(temp);
			 }else{
				 SpecialDeviceRuleInfo info = new SpecialDeviceRuleInfo();
				 info.setDeviceId( tt.getId());
				 info.setDeviceName( tt.getDeviceName());
				 info.setFactoryId( tt.getFactoryId());
				 info.setWorkshopId( tt.getWorkshopId());
				 info.setCompanyId( tt.getCompanyId());
				 info.setDeviceTypeId( tt.getDeviceTypeId());
				 info.setDeviceTypeName(tt.getDeviceTypeName());
				 list.add(info);
			 }
		}
		int totalRows = deviceInfoDao.findCountForPage(hqlCount, map);
		pagination.setTotalRows(totalRows);
		pagination.setData(list);
		return pagination;
	}
	//public RuleInfo findbyDeviceTypeId(String id){
		
	//}
	
	public List<SpecialDeviceRuleInfo> findbyProperties(String propertyName,String value){
	return	specialDeviceRuleDao.findByProperty(propertyName, value);
	}
	public List<SpecialDeviceRuleInfo> findbyProperties(String propertyName,int value){
		return	specialDeviceRuleDao.findByProperty(propertyName, value);
		}

	public List<String> findSpecialDeviceRuleStrByDeviceId(String deviceId){
		String hql = "Select pointStr from SpecialDeviceRuleInfo where deviceId=:deviceId";
		Map values = new HashMap();
		values.put("deviceId", deviceId);
		List<String> list = specialDeviceRuleDao.find(hql, values );
		return list;
	}
	
	public List<SpecialDeviceRuleInfo> findSpecialDeviceRuleByDeviceId(String deviceId){
		String hql = " from SpecialDeviceRuleInfo where deviceId=:deviceId";
		Map values = new HashMap();
		values.put("deviceId", deviceId);
		List<SpecialDeviceRuleInfo> list = specialDeviceRuleDao.find(hql, values );
		return list;
	}
}


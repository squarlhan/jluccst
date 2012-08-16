package com.boan.crm.servicemanage.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.boan.crm.servicemanage.dao.IPointInfoDao;
import com.boan.crm.servicemanage.model.PointInfo;
import com.boan.crm.utils.dao.impl.BaseDao;

/**
* 积分管理Dao接口实现
* @author XXX
* @version 1.0.0
*/

@Repository("pointInfoDao")
public class PointInfoDaoImpl extends BaseDao<PointInfo,String> implements IPointInfoDao{

	@Override
	public PointInfo getByConsumptionId(String consumptionId) {
		String hql = "from PointInfo where consumptionId = :consumptionId";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put( "consumptionId", consumptionId );
		List<PointInfo> objList  = super.find( hql, map );
		PointInfo obj = null; 
		if( objList != null && objList.size() > 0 )
		{
			obj = objList.get( 0 );
		}
		return obj;
	}

	@Override
	public int getTotalPoint(String companyId) {
		int result=0;
		String hql = "from PointInfo where companyId = :companyId";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put( "companyId", companyId );
		List<PointInfo> objList  = super.find( hql, map );
		PointInfo obj = null; 
		if( objList != null && objList.size() > 0 )
		{
			for (PointInfo pointInfo : objList) {
				result = result + pointInfo.getPoint();
			}
		}
		return result;
	}

	@Override
	public float getConsumptionAmount(String companyId) {
		float result=0;
		String hql = "from PointInfo where companyId = :companyId";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put( "companyId", companyId );
		List<PointInfo> objList  = super.find( hql, map );
		PointInfo obj = null; 
		if( objList != null && objList.size() > 0 )
		{
			for (PointInfo pointInfo : objList) {
				result = result + pointInfo.getConsumptionMoney();
			}
		}
		return result;
	}
}

package com.boan.crm.servicemanage.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import com.boan.crm.groupmanage.model.User;
import com.boan.crm.servicemanage.dao.IMemberInfoDao;
import com.boan.crm.servicemanage.model.MemberInfo;
import com.boan.crm.utils.dao.impl.BaseDao;

/**
* 会员管理Dao接口实现
* @author XXX
* @version 1.0.0
*/

@Repository("memberInfoDao")
public class MemberInfoDaoImpl extends BaseDao<MemberInfo,String> implements IMemberInfoDao{

	@Override
	public boolean isMember(String companyId) {
		boolean b = false;
		int rowCount = 0;
		String hql = null;
		Map<String, Object> map = new HashMap<String, Object>();
		map.put( "companyId", companyId );
		hql = "select count(id) from MemberInfo where companyId = :companyId";
		rowCount = super.findCountForPage( hql, map );			
		if( rowCount > 0 )
		{
			b = true;
		}
		return b;
	}

	@Override
	public MemberInfo getByCompanyId(String companyId) {
		String hql = "from MemberInfo where companyId = :companyId";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put( "companyId", companyId );
		List<MemberInfo> objList  = super.find( hql, map );
		MemberInfo obj = null; 
		if( objList != null && objList.size() > 0 )
		{
			obj = objList.get( 0 );
		}
		return obj;
	}
}

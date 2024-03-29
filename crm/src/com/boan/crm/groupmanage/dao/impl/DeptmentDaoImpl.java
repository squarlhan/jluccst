package com.boan.crm.groupmanage.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import com.boan.crm.groupmanage.dao.IDeptmentDao;
import com.boan.crm.groupmanage.model.Deptment;
import com.boan.crm.utils.dao.impl.BaseDao;

/**
* 部门Dao接口实现
* @author XXX
* @version 1.0.0
*/

@Repository("deptDao")
public class DeptmentDaoImpl extends BaseDao<Deptment,String> implements IDeptmentDao{

	@Override
	public boolean isExistSameName( String id, String name, String companyId )
	{
		id = StringUtils.trimToEmpty( id );
		name = StringUtils.trimToEmpty( name );
		boolean b = false;
		int rowCount = 0;
		String hql = null;
		Map<String, Object> map = new HashMap<String, Object>();
		map.put( "deptName", name );
		map.put( "companyId", companyId );
		if( StringUtils.isNotBlank( id ) )
		{
			hql = "select count(id) from Deptment where id <> :deptId and deptName= :deptName and companyId = :companyId";
			map.put( "deptId", id );
		}
		else
		{
			hql = "select count(id) from Deptment where deptName = :deptName and companyId = :companyId";
		}
		rowCount = super.findCountForPage( hql, map );			
		if( rowCount > 0 )
		{
			b = true;
		}
		return b;
	}

	@Override
	public List<Deptment> queryAllDeptmentsByCompanyId( String companyId )
	{
		String hql = "from Deptment where companyId = :companyId order by sortIndex asc, createTime asc";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put( "companyId", companyId );
		return super.find( hql, map );
	}

}

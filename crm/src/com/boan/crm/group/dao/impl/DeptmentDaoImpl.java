package com.boan.crm.group.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import com.boan.crm.group.dao.IDeptmentDao;
import com.boan.crm.group.model.Deptment;
import com.boan.crm.utils.dao.impl.BaseDao;

/**
* 公司Dao接口实现
* @author Guiyun Yang
* @version 1.0.0
*/

@Repository("deptDao")
public class DeptmentDaoImpl extends BaseDao<Deptment,String> implements IDeptmentDao{

	@Override
	public boolean isExistSameName( String id, String name )
	{
		id = StringUtils.trimToEmpty( id );
		name = StringUtils.trimToEmpty( name );
		boolean b = false;
		int rowCount = 0;
		String hql = null;
		Map<String, Object> map = new HashMap<String, Object>();
		map.put( "deptName", name );
		if( StringUtils.isNotBlank( id ) )
		{
			hql = "select count(id) from Deptment where id <> :deptId and deptName= :deptName";
			map.put( "deptId", id );
		}
		else
		{
			hql = "select count(id) from Deptment where deptName = :deptName";
		}
		rowCount = super.findCountForPage( hql, map );			
		if( rowCount > 0 )
		{
			b = true;
		}
		return b;
	}

	@Override
	public List<Deptment> queryAllDeptmentsByRootId( String rootId )
	{
		String hql = "from Deptment where rootId = :rootId order by sortIndex asc, createTime asc";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put( "rootId", rootId );
		return super.find( hql, map );
	}

}

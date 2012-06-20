package com.boan.crm.group.dao.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.boan.crm.group.dao.ICompanyDao;
import com.boan.crm.group.model.Company;
import com.boan.crm.utils.dao.impl.BaseDao;

/**
* 公司Dao接口实现
* @author Guiyun Yang
* @version 1.0.0
*/

@Repository("companyDao")
public class CompanyDaoImpl extends BaseDao<Company,String> implements ICompanyDao{

	@Override
	public boolean isExistSameName( String id, String name )
	{
		id = StringUtils.trimToEmpty( id );
		name = StringUtils.trimToEmpty( name );
		boolean b = false;
		int rowCount = 0;
		String hql = null;
		Map<String, Object> map = new HashMap<String, Object>();
		map.put( "companyName", name );
		if( StringUtils.isNotBlank( id ) )
		{
			hql = "select count(id) from Company where id <> :companyId and companyName= :companyName";
			map.put( "companyId", id );
		}
		else
		{
			hql = "select count(id) from Company where companyName = :companyName";
		}
		rowCount = super.findCountForPage( hql, map );			
		if( rowCount > 0 )
		{
			b = true;
		}
		return b;
	}

	@Override
	public List<Company> queryAllCompanysByRootId( String rootId )
	{
		String hql = "from Company where rootId = :rootId order by sortIndex asc, createTime asc";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put( "rootId", rootId );
		return super.find( hql, map );
	}

}

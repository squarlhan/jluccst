/*
 * @(#)GroupFactoryDaoImpl.java 1.1 2012-3-8
 */

package com.boan.rees.group.dao.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.boan.rees.group.dao.IFactoryDao;
import com.boan.rees.group.model.Factory;
import com.boan.rees.utils.dao.impl.BaseDao;

/**
 * 工厂dao接口实现
 * 
 * @author Guiyun Yang
 * @version 1.0.0
 */

@Repository( "groupFactoryDao" )
public class FactoryDaoImpl extends BaseDao<Factory, String> implements
		IFactoryDao
{

	@Override
	public boolean isExistSameName( String id, String name )
	{
		id = StringUtils.trimToEmpty( id );
		name = StringUtils.trimToEmpty( name );
		boolean b = false;
		int rowCount = 0;
		String hql = null;
		Map<String, Object> map = new HashMap<String, Object>();
		map.put( "factoryName", name );
		if( StringUtils.isNotBlank( id ) )
		{
			hql = "select count(id) from Factory where id <> :factoryId and factoryName= :factoryName";
			map.put( "factoryId", id );
		}
		else
		{
			hql = "select count(id) from Factory where factoryName = :factoryName";
		}
		rowCount = super.findCountForPage( hql, map );			
		if( rowCount > 0 )
		{
			b = true;
		}
		return b;
	}

}

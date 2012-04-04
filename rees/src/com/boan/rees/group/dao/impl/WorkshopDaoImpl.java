/*
 * @(#)GroupWorkshopDaoImpl.java 1.1 2012-3-8
 */

package com.boan.rees.group.dao.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.boan.rees.group.dao.IWorkshopDao;
import com.boan.rees.group.model.Workshop;
import com.boan.rees.utils.dao.impl.BaseDao;

/**
 * 车间dao接口实现
 * 
 * @author Guiyun Yang
 * @version 1.0.0
 */

@Repository( "workshopDao" )
public class WorkshopDaoImpl extends BaseDao<Workshop, String> implements
		IWorkshopDao
{

	@Override
	public void deleteWorkshopById( String id )
	{
		super.delete( id );

	}

	@Override
	public boolean isExistSameName( String factoryId, String id, String name )
	{
		factoryId = StringUtils.trimToEmpty( factoryId );
		id = StringUtils.trimToEmpty( id );
		name = StringUtils.trimToEmpty( name );
		boolean b = false;
		int rowCount = 0;
		String hql = null;
		Map<String, Object> map = new HashMap<String, Object>();
		map.put( "factoryId", factoryId );
		map.put( "workshopName", name );
		if( StringUtils.isNotBlank( id ) )
		{
			hql = "select count(id) from Workshop where factoryId = :factoryId and id <> :workshopId and workshopName = :workshopName";
			map.put( "workshopId", id );
		}
		else
		{
			hql = "select count(id) from Workshop where factoryId = :factoryId and workshopName = :workshopName";
		}
		rowCount = super.findCountForPage( hql, map );			
		if( rowCount > 0 )
		{
			b = true;
		}
		return b;
	}

	@Override
	public List<Workshop> queryAllWorkshopsByFactoryId( String factoryId )
	{
		String hql = "from Workshop where factoryId = :factoryId order by sortIndex asc, createTime asc";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put( "factoryId", factoryId );
		return super.find( hql, map );
	}

}

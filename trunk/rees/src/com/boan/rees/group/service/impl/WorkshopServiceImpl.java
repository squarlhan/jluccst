/*
 * @(#)GroupWorkshopServiceImpl.java 1.1 2012-3-9
 */

package com.boan.rees.group.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.boan.rees.group.dao.IWorkshopDao;
import com.boan.rees.group.model.Workshop;
import com.boan.rees.group.service.IWorkshopService;
import com.boan.rees.utils.page.Pagination;

/**
 * 车间服务类接口实现
 * 
 * @author Guiyun Yang
 * @version 1.0.0
 */

@Service( "workshopService" )
public class WorkshopServiceImpl implements IWorkshopService
{

	@Autowired
	@Qualifier( "workshopDao" )
	private IWorkshopDao groupWorkshopDao;

	/**
	 * 查找所有车间
	 */
	@Override
	public List<Workshop> findAllGroupCompany()
	{

		return groupWorkshopDao.findAll();
	}

	/**
	 * 根据id查找车间
	 */
	@Override
	public Workshop get( String id )
	{

		return groupWorkshopDao.get( id );
	}

	@Override
	public void deleteWorkshopById( String id )
	{
		groupWorkshopDao.deleteWorkshopById( id );
	}

	/**
	 * 删除车间
	 */
	@Override
	public void deleteGroupWorkshop( String... ids )
	{

		groupWorkshopDao.delete( ids );
	}

	/**
	 * 保存车间
	 */
	@Override
	public void save( Workshop table1 )
	{

		groupWorkshopDao.save( table1 );
	}

	/**
	 * 分页查找车间
	 */
	@Override
	public Pagination<Workshop> findWorkshopForPage( Map<String, ?> values, Pagination<Workshop> pagination )
	{

		String hql = "from Workshop where factoryId = :factoryId order by sortIndex asc, createTime asc";
		List<Workshop> data = groupWorkshopDao.findForPage( hql, values,
				pagination.getStartIndex(), pagination.getPageSize() );
		hql = "select count(*) from Workshop where factoryId = :factoryId";
		int totalRows = groupWorkshopDao.findCountForPage( hql, values );
		pagination.setTotalRows( totalRows );
		pagination.setData( data );
		return pagination;
	}

	/**
	 * 更新数据
	 */
	@Override
	public void update( Workshop workshop )
	{
		groupWorkshopDao.update( workshop );

	}

	@Override
	public boolean isExistSameName( String factoryId, String id, String name )
	{
		return groupWorkshopDao.isExistSameName( factoryId, id, name );
	}

	@Override
	public List<Workshop> queryAllWorkshopsByFactoryId( String factoryId )
	{
		return groupWorkshopDao.queryAllWorkshopsByFactoryId( factoryId );
	}
}

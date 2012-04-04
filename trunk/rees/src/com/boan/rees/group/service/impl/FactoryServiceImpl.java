/*
 * @(#)IGroupFactoryServiceImpl.java 1.1 2012-3-9
 */

package com.boan.rees.group.service.impl;

import com.boan.rees.group.dao.IFactoryDao;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.boan.rees.group.model.Company;
import com.boan.rees.group.model.Factory;
import com.boan.rees.group.service.IFactoryService;
import com.boan.rees.utils.page.Pagination;

/**
 * 工厂服务类接口实现
 * 
 * @author Guiyun Yang
 * @version 1.0.0
 */

@Service( "factoryService" )
public class FactoryServiceImpl implements IFactoryService
{

	@Autowired
	@Qualifier( "groupFactoryDao" )
	private IFactoryDao groupFactoryDao;

	@Override
	/**
	 * 根据工厂编号取得工厂信息
	 */
	public Factory get( String id )
	{
		return groupFactoryDao.get( id );
	}

	@Override
	/**
	 * 根据工厂编号删除工厂
	 */
	public void deleteGroupFactory( String... ids )
	{

		groupFactoryDao.delete( ids );

	}

	@Override
	/**
	 * 保存工厂
	 */
	public void save( Factory table1 )
	{

		groupFactoryDao.save( table1 );

	}

	/**
	 * 修改信息
	 */
	@Override
	public void update( Factory factory )
	{
		groupFactoryDao.update( factory );

	}

	@Override
	/**
	 * 分页查找工厂
	 */
	public Pagination<Factory> findFactoryForPage( Map<String, ?> values,
			Pagination<Factory> pagination )
	{

		String hql = "from Factory where companyId = :companyId order by sortIndex asc, createTime asc";
		List<Factory> data = groupFactoryDao.findForPage( hql, values,
				pagination.getStartIndex(), pagination.getPageSize() );
		hql = "select count(*) from Factory where companyId = :companyId";
		int totalRows = groupFactoryDao.findCountForPage( hql, values );
		pagination.setTotalRows( totalRows );
		pagination.setData( data );
		return pagination;
	}

	@Override
	public boolean isExistSameName( String id, String name )
	{
		return groupFactoryDao.isExistSameName( id, name );
	}

	@Override
	public List<Factory> queryFactoriesByCompanyId( String companyId )
	{
		return groupFactoryDao.queryFactoriesByCompanyId( companyId );
	}

}

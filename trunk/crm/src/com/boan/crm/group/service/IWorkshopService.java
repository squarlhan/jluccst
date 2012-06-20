/*
 * @(#)IGroupWorkshopService.java 1.1 2012-3-8
 */

package com.boan.crm.group.service;

import java.util.List;
import java.util.Map;

import com.boan.crm.group.model.Workshop;
import com.boan.crm.utils.page.Pagination;

/**
 * 车间服务类接口
 * 
 * @author Guiyun Yang
 * @version 1.0.0
 */
public interface IWorkshopService
{

	public List<Workshop> findAllGroupCompany();

	public Workshop get( String id );

	public void deleteGroupWorkshop( String... ids );

	public void deleteWorkshopById( String id );

	public void save( Workshop table1 );

	public Pagination<Workshop> findWorkshopForPage( Map<String, ?> values, Pagination<Workshop> pagination );

	public void update( Workshop workshop );
	
	/**
	 * 判断是否重名
	 * @param factoryId
	 * @param id
	 * @param name
	 * @return
	 */
	public boolean isExistSameName( String factoryId, String id, String name );
	
	/**
	 * 根据工厂id取车间
	 * @param factoryId
	 * @return
	 */
	public List<Workshop> queryAllWorkshopsByFactoryId( String factoryId );
}

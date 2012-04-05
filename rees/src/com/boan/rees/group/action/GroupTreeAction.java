/**
 * Copyright (c) 2012 Changchun Boan Co. Ltd.
 * All right reserved.
 * History
 */
/*
 * @(#)GroupTreeAction.java 1.1 Apr 4, 2012
 */
package com.boan.rees.group.action;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.boan.rees.common.GroupConfig;
import com.boan.rees.group.model.Company;
import com.boan.rees.group.model.Factory;
import com.boan.rees.group.model.Workshop;
import com.boan.rees.group.service.ICompanyService;
import com.boan.rees.group.service.IFactoryService;
import com.boan.rees.group.service.IWorkshopService;
import com.boan.rees.utils.action.BaseActionSupport;

/**
 * 类
 * @author XXX
 * @version 1.1, Apr 4, 2012
 */
@Controller("groupTreeAction")
@Scope( "prototype" )
public class GroupTreeAction extends BaseActionSupport
{
	@Autowired
	@Qualifier("companyService")
	private ICompanyService companyService = null;
	
	private List<Company> companyList = null;
	
	@Autowired
	@Qualifier("factoryService")
	private IFactoryService factoryService = null;
	
	private List<Factory> factoryList = null;
	
	@Autowired
	@Qualifier("workshopService")
	private IWorkshopService workshopService = null;
	
	private List<Workshop> workshopList = null;
	/**
	 * 显示组织机构树为工厂
	 * @return
	 */
	public String showGroupTreeForFactory()
	{
		companyList = companyService.queryAllCompanysByRootId( GroupConfig.ROOT_ID );
		return "group-tree-for-factory";
	}

	/**
	 * 显示组织机构树为车间
	 * @return
	 */
	public String showGroupTreeForWorkshop()
	{
		companyList = companyService.queryAllCompanysByRootId( GroupConfig.ROOT_ID );
		List<Factory> list = null;
		if( companyList != null && companyList.size() > 0 )
		{
			factoryList = new ArrayList<Factory>();
			for( int i = 0; i < companyList.size(); i++ )
			{
				list = factoryService.queryFactoriesByCompanyId( companyList.get( i ).getId() );
				if( list != null )
				{
					factoryList.addAll( list );
				}
			}
		}
		return "group-tree-for-workshop";
	}
	/**
	 * 显示组织机构树,带公司、工厂、车间
	 * @return
	 */
	public String showGroupTreeForDevice()
	{
		companyList = companyService.queryAllCompanysByRootId( GroupConfig.ROOT_ID );
		List<Factory> list = null;
		List<Workshop> lt = null;
		if( companyList != null && companyList.size() > 0 )
		{
			factoryList = new ArrayList<Factory>();
			workshopList = new ArrayList<Workshop>();
			for( int i = 0; i < companyList.size(); i++ )
			{
				list = factoryService.queryFactoriesByCompanyId( companyList.get( i ).getId() );
				if( list != null && list.size() > 0)
				{
					factoryList.addAll( list );
					
					for( int k = 0; k < factoryList.size(); k++ )
					{
						lt = workshopService.queryAllWorkshopsByFactoryId( factoryList.get( k ).getId() );
						if( lt != null && lt.size() > 0 )
						{
							workshopList.addAll( lt );
						}
					}
					
				}
			}
		}
		return "group-tree-for-device";
	}
	
	/**
	 * 显示组织机构树,带公司、工厂、车间
	 * @return
	 */
	public String showGroupTreeForPointData()
	{
		companyList = companyService.queryAllCompanysByRootId( GroupConfig.ROOT_ID );
		List<Factory> list = null;
		List<Workshop> lt = null;
		if( companyList != null && companyList.size() > 0 )
		{
			factoryList = new ArrayList<Factory>();
			workshopList = new ArrayList<Workshop>();
			for( int i = 0; i < companyList.size(); i++ )
			{
				list = factoryService.queryFactoriesByCompanyId( companyList.get( i ).getId() );
				if( list != null && list.size() > 0)
				{
					factoryList.addAll( list );
					
					for( int k = 0; k < factoryList.size(); k++ )
					{
						lt = workshopService.queryAllWorkshopsByFactoryId( factoryList.get( k ).getId() );
						if( lt != null && lt.size() > 0 )
						{
							workshopList.addAll( lt );
						}
					}
					
				}
			}
		}
		return "group-tree-for-pointdata";
	}
	
	public List<Company> getCompanyList()
	{
		return companyList;
	}

	public void setCompanyList( List<Company> companyList )
	{
		this.companyList = companyList;
	}

	public List<Factory> getFactoryList()
	{
		return factoryList;
	}

	public void setFactoryList( List<Factory> factoryList )
	{
		this.factoryList = factoryList;
	}

	public List<Workshop> getWorkshopList()
	{
		return workshopList;
	}

	public void setWorkshopList( List<Workshop> workshopList )
	{
		this.workshopList = workshopList;
	}
}


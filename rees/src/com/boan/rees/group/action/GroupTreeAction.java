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
import com.boan.rees.group.service.ICompanyService;
import com.boan.rees.group.service.IFactoryService;
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
}


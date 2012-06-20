/**
 * Copyright (c) 2012 Changchun Boan Co. Ltd.
 * All right reserved.
 * History
 */
/*
 * @(#)GroupServiceImpl.java 1.1 May 14, 2012
 */
package com.boan.crm.group.service.impl;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.boan.crm.group.model.Company;
import com.boan.crm.group.model.Factory;
import com.boan.crm.group.model.Workshop;
import com.boan.crm.group.service.ICompanyService;
import com.boan.crm.group.service.IFactoryService;
import com.boan.crm.group.service.IGroupService;
import com.boan.crm.group.service.IWorkshopService;

/**
 * 类
 * 
 * @author XXX
 * @version 1.1, May 14, 2012
 */
@Service( "groupService" )
public class GroupServiceImpl implements IGroupService
{
	@Autowired
	@Qualifier( "companyService" )
	private ICompanyService companyService = null;

	@Autowired
	@Qualifier( "factoryService" )
	private IFactoryService factoryService = null;

	@Autowired
	@Qualifier( "workshopService" )
	private IWorkshopService workshopService = null;

	@Override
	public String getGroupFullName( String companyId, String factoryId, String workshopId )
	{
		StringBuffer sb = new StringBuffer();
		// 表示车间
		if( StringUtils.isNotBlank( companyId ) && StringUtils.isNotBlank( factoryId ) && StringUtils.isNotBlank( workshopId ) )
		{
			Company company = companyService.get( companyId );
			if( company != null )
			{
				sb.append( company.getCompanyName() );
			}
			Factory factory = factoryService.get( factoryId );
			if( factory != null )
			{
				sb.append( "→" + factory.getFactoryName() );
			}
			Workshop workshop = workshopService.get( workshopId );
			if( workshop != null )
			{
				sb.append( "→" + workshop.getWorkshopName() );
			}
			return sb.toString();
		}
		// 表示工厂
		else if( StringUtils.isNotBlank( companyId ) && StringUtils.isNotBlank( factoryId ) && StringUtils.isBlank( workshopId ) )
		{
			Company company = companyService.get( companyId );
			if( company != null )
			{
				sb.append( company.getCompanyName() );
			}
			Factory factory = factoryService.get( factoryId );
			if( factory != null )
			{
				sb.append( "→" + factory.getFactoryName() );
			}
			return sb.toString();
		}
		// 表示公司
		else if( StringUtils.isNotBlank( companyId ) && StringUtils.isBlank( factoryId ) && StringUtils.isBlank( workshopId ) )
		{
			Company company = companyService.get( companyId );
			if( company != null )
			{
				sb.append( company.getCompanyName() );
			}
			return sb.toString();
		}
		else
		{
			return "";
		}
	}

}

/**
 * Copyright (c) 2012 Changchun Boan Co. Ltd.
 * All right reserved.
 * History
 */
/*
 * @(#)GroupServiceImpl.java 1.1 May 14, 2012
 */
package com.boan.crm.groupmanage.service.impl;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.boan.crm.groupmanage.model.Deptment;
import com.boan.crm.groupmanage.service.IDeptmentService;
import com.boan.crm.groupmanage.service.IGroupService;

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
	@Qualifier( "deptService" )
	private IDeptmentService deptService = null;

	@Override
	public String getGroupFullName( String companyId, String factoryId, String workshopId )
	{
		StringBuffer sb = new StringBuffer();
		 if( StringUtils.isNotBlank( companyId ) && StringUtils.isBlank( factoryId ) && StringUtils.isBlank( workshopId ) )
		{
			Deptment dept = deptService.get( companyId );
			if( dept != null )
			{
				sb.append( dept.getDeptName() );
			}
			return sb.toString();
		}
		else
		{
			return "";
		}
	}

}

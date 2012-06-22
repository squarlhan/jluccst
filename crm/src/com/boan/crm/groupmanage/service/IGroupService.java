/**
 * Copyright (c) 2012 Changchun Boan Co. Ltd.
 * All right reserved.
 * History
 */
/*
 * @(#)IGroupService.java 1.1 May 14, 2012
 */
package com.boan.crm.groupmanage.service;

/**
 * 组织机构类
 * @author XXX
 * @version 1.1, May 14, 2012
 */
public interface IGroupService
{
	/**
	 * 根据级别（公司）id，工厂id，车间id获取全组织机构名称
	 * @param companyId
	 * @param factoryId
	 * @param workshopId
	 * @return
	 * @throws Exception
	 */
	public String getGroupFullName(String companyId, String factoryId, String workshopId );
}


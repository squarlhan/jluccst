/**
 * Copyright (c) 2012 Changchun Boan Co. Ltd.
 * All right reserved.
 * History
 */
/*
 * @(#)GroupTreeAction.java 1.1 Apr 4, 2012
 */
package com.boan.rees.group.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.boan.rees.common.GroupConfig;
import com.boan.rees.group.model.Company;
import com.boan.rees.group.service.ICompanyService;
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
	
	/**
	 * 显示组织机构树为工厂
	 * @return
	 */
	public String showGroupTreeForFactory()
	{
		companyList = companyService.queryAllCompanysByRootId( GroupConfig.ROOT_ID );
		return "group-tree-for-factory";
	}

	public List<Company> getCompanyList()
	{
		return companyList;
	}

	public void setCompanyList( List<Company> companyList )
	{
		this.companyList = companyList;
	}
}


/**
 * Copyright (c) 2012 Changchun Boan Co. Ltd.
 * All right reserved.
 * History
 */
/*
 * @(#)GroupTreeAction.java 1.1 Apr 4, 2012
 */
package com.boan.crm.groupmanage.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.boan.crm.groupmanage.model.Deptment;
import com.boan.crm.groupmanage.service.IDeptmentService;
import com.boan.crm.utils.action.BaseActionSupport;

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
	@Qualifier("deptService")
	private IDeptmentService deptService = null;
	
	private List<Deptment> deptList = null;
	
	private String companyId = null;
	
	/**
	 * 显示组织机构树,带公司、工厂、车间
	 * @return
	 */
	public String showGroupTreeForUser() throws Exception
	{
		deptList = deptService.queryAllDeptmentsByCompanyId( companyId );
		return "group-tree-for-user";
	}
	
	public List<Deptment> getDeptList ()
	{
		return deptList ;
	}

	public void setDeptList ( List<Deptment> deptList  )
	{
		this.deptList  = deptList ;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
}


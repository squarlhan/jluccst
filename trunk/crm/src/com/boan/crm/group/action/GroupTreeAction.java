/**
 * Copyright (c) 2012 Changchun Boan Co. Ltd.
 * All right reserved.
 * History
 */
/*
 * @(#)GroupTreeAction.java 1.1 Apr 4, 2012
 */
package com.boan.crm.group.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.boan.crm.common.GroupConfig;
import com.boan.crm.group.common.GroupCategory;
import com.boan.crm.group.common.MenuKey;
import com.boan.crm.group.common.UserSession;
import com.boan.crm.group.model.Deptment;
import com.boan.crm.group.service.IDeptmentService;
import com.boan.crm.group.service.IPopedomService;
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
	
	@Autowired
	@Qualifier("popedomService")
	private IPopedomService popedomService = null;
	
	/**
	 * 显示组织机构树为工厂
	 * @return
	 */
	public String showGroupTreeForFactory()
	{
		deptList = deptService.queryAllDeptmentsByRootId( GroupConfig.ROOT_ID );
		return "group-tree-for-factory";
	}

	/**
	 * 显示组织机构树,带公司、工厂、车间
	 * @return
	 */
	public String showGroupTreeForDevice() throws Exception
	{
		this.showTreeAllNodes();
		return "group-tree-for-device";
	}
	/**
	 * 显示组织机构树,带公司、工厂、车间
	 * @return
	 */
	public String showGroupTreeForUser() throws Exception
	{
		this.showTreeAllNodes();
		return "group-tree-for-user";
	}
	
	
	/**
	 * 显示组织机构树,带公司、工厂、车间
	 * @return
	 */
	public String showGroupTreeForPointData() throws Exception
	{
		this.showTreeAllNodes();
		return "group-tree-for-pointdata";
	}
	
	/**
	 * 显示组织机构树,带公司、工厂、车间
	 * @return
	 */
	public String showGroupTreeForReport() throws Exception
	{
		this.showTreeAllNodes();
		return "group-tree-for-report";
	}
	public List<Deptment> getDeptList ()
	{
		return deptList ;
	}

	public void setDeptList ( List<Deptment> deptList  )
	{
		this.deptList  = deptList ;
	}

	/**
	 * 显示带有公司、工厂、机构节点的完整树型
	 */
	private void showTreeAllNodes() throws Exception
	{
		//判断当前是否显示所有
		boolean showAllTreeFlag = this.isHavePopedom( MenuKey.SHOW_ALL_GROUP );
		boolean showCurrentAndSubTreeFlag = this.isHavePopedom( MenuKey.SHOW_CURRENT_AND_SUB_GROUP );
		boolean showCurrentTreeFlag = this.isHavePopedom( MenuKey.SHOW_CURRENT_GROUP );
		
		//（3）显示当前节点及子节点
		if( !showAllTreeFlag && !showCurrentTreeFlag && showCurrentAndSubTreeFlag )
		{
			HttpSession session = ServletActionContext.getRequest().getSession();
			UserSession userSession = ( UserSession ) session.getAttribute( "userSession" );
			if(userSession != null)
			{
				String cId = userSession.getDeptId();
				
				//表示公司级
				if( GroupCategory.COMPANY.equals( this.getGroupCategory() ) )
				{
					deptList  = new ArrayList<Deptment>(); 
					deptList .add( deptService.get( cId ) );
				}
			}
		}
	}
	
	/**
	 * 判断指定的权限是否具备，具备返回true，否则返回false，超级管理员具有所有权限
	 * @param popedomKey
	 * @return
	 */
	private boolean isHavePopedom( String popedomKey ) throws Exception
	{
		boolean b = false;
		HttpSession session = ServletActionContext.getRequest().getSession();
		UserSession userSession = ( UserSession ) session.getAttribute( "userSession" );
		if(userSession != null)
		{
			b = popedomService.isHasPopedom(userSession.getUserId(), String.valueOf(userSession.getUserType()),
					popedomKey, userSession.getPopedomKeys() );
		}
		return b;
	}
	/**
	 * 判断当前用户所在组织机构类型，是公司、工厂还是车间
	 * @return
	 * @throws Exception
	 */
	private String getGroupCategory( ) throws Exception
	{
		HttpSession session = ServletActionContext.getRequest().getSession();
		UserSession userSession = ( UserSession ) session.getAttribute( "userSession" );
		if(userSession != null)
		{
			String cId = userSession.getDeptId();
			
			if( StringUtils.isNotBlank( cId )  )
			{
				//表示车间级
				return GroupCategory.WORKSHOP;
			}
			else
			{
				//存在问题
				return "";
			}
		}
		return "";
	}
}


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

import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.boan.rees.common.GroupConfig;
import com.boan.rees.group.common.GroupCategory;
import com.boan.rees.group.common.MenuKey;
import com.boan.rees.group.common.UserSession;
import com.boan.rees.group.model.Company;
import com.boan.rees.group.model.Factory;
import com.boan.rees.group.model.Workshop;
import com.boan.rees.group.service.ICompanyService;
import com.boan.rees.group.service.IFactoryService;
import com.boan.rees.group.service.IPopedomService;
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
	
	@Autowired
	@Qualifier("popedomService")
	private IPopedomService popedomService = null;
	
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
	public String showGroupTreeForDevice() throws Exception
	{
		this.showTreeAllNodes();
		return "group-tree-for-device";
	}
	
	/**
	 * 显示组织机构树,带公司、工厂、车间
	 * @return
	 */
	public String showGroupTreeForSpecialDeviceRule() throws Exception
	{
		this.showTreeAllNodes();
		return "group-tree-for-special-device-rule";
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
	public String showGroupTreeForPointDataView() throws Exception
	{
		this.showTreeAllNodes();
		return "group-tree-for-pointdata-view";
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
	
	/**
	 * 显示带有公司、工厂、机构节点的完整树型
	 */
	private void showTreeAllNodes() throws Exception
	{
		//判断当前是否显示所有
		boolean showAllTreeFlag = this.isHavePopedom( MenuKey.SHOW_ALL_GROUP );
		boolean showCurrentAndSubTreeFlag = this.isHavePopedom( MenuKey.SHOW_CURRENT_AND_SUB_GROUP );
		boolean showCurrentTreeFlag = this.isHavePopedom( MenuKey.SHOW_CURRENT_GROUP );
		
		//（1）显示树所有节点
		if(showAllTreeFlag)
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
								
								//由于原来的这句缺少公司Id所以注释掉了，用下面的for循环处理
								//workshopList.addAll( lt );
								for( Workshop temp :lt ){
									temp.setCompanyId(factoryList.get( k ).getCompanyId());
									workshopList.add(temp);
								}
							}
						}
						
					}
				}
			}
		}
		//（2）显示树当前节点
		if( !showAllTreeFlag && showCurrentTreeFlag )
		{
			HttpSession session = ServletActionContext.getRequest().getSession();
			UserSession userSession = ( UserSession ) session.getAttribute( "userSession" );
			if(userSession != null)
			{
				String cId = userSession.getCompanyId();
				String fId = userSession.getFactoryId();
				String wId = userSession.getWorkshopId();
				
				if( StringUtils.isNotBlank( cId ))
				{
					//表示公司级
					companyList = new ArrayList<Company>(); 
					companyList.add( companyService.get( cId ) );
				}
				if( StringUtils.isNotBlank( fId ) )
				{
					//表示是工厂级
					factoryList = new ArrayList<Factory>();
					factoryList.add( factoryService.get( fId ) );
				}
				if( StringUtils.isNotBlank( wId ))
				{
					//表示车间级
					workshopList = new ArrayList<Workshop>(); 
					//workshopList.add( workshopService.get( wId ) );
					Workshop obj =workshopService.get( wId );
					if(  StringUtils.isBlank( obj.getCompanyId() )){
						obj.setCompanyId(cId);
					}
					workshopList.add(obj);
				}
			}
		}
		//（3）显示当前节点及子节点
		if( !showAllTreeFlag && !showCurrentTreeFlag && showCurrentAndSubTreeFlag )
		{
			HttpSession session = ServletActionContext.getRequest().getSession();
			UserSession userSession = ( UserSession ) session.getAttribute( "userSession" );
			if(userSession != null)
			{
				String cId = userSession.getCompanyId();
				String fId = userSession.getFactoryId();
				String wId = userSession.getWorkshopId();
				
				//表示公司级
				if( GroupCategory.COMPANY.equals( this.getGroupCategory() ) )
				{
					List<Factory> list = null;
					List<Workshop> lt = null;
					companyList = new ArrayList<Company>(); 
					companyList.add( companyService.get( cId ) );
					list = factoryService.queryFactoriesByCompanyId( cId );
					if( list != null && list.size() > 0)
					{
						factoryList = new ArrayList<Factory>();
						factoryList.addAll( list );
						workshopList = new ArrayList<Workshop>();
						for( int k = 0; k < factoryList.size(); k++ )
						{
							lt = workshopService.queryAllWorkshopsByFactoryId( factoryList.get( k ).getId() );
							if( lt != null && lt.size() > 0 )
							{
								//workshopList.addAll( lt );
								for(Workshop obj : lt){
									if(  StringUtils.isBlank( obj.getCompanyId() )){
										obj.setCompanyId(cId);
									}
									workshopList.add(obj);
								}
							}
						}
					}
				}
				//表示是工厂级
				if( GroupCategory.FACTORY.equals( this.getGroupCategory() ) )
				{
					companyList = new ArrayList<Company>(); 
					companyList.add( companyService.get( cId ) );
					factoryList = new ArrayList<Factory>();
					factoryList.add( factoryService.get( fId ) );
					List<Workshop> lt = workshopService.queryAllWorkshopsByFactoryId( fId );
					if( lt != null && lt.size() > 0 )
					{
						workshopList = new ArrayList<Workshop>();
						//workshopList.addAll( lt );
						for(Workshop obj : lt){
							if(  StringUtils.isBlank( obj.getCompanyId() )){
								obj.setCompanyId(cId);
							}
							workshopList.add(obj);
						}
					}
				}
				//表示车间级
				if( GroupCategory.WORKSHOP.equals( this.getGroupCategory() ) )
				{
					companyList = new ArrayList<Company>(); 
					companyList.add( companyService.get( cId ) );
					
					factoryList = new ArrayList<Factory>();
					factoryList.add( factoryService.get( fId ) );
					
					workshopList = new ArrayList<Workshop>(); 
					//workshopList.add( workshopService.get( wId ) );
					Workshop obj =workshopService.get( wId );
					if(  StringUtils.isBlank( obj.getCompanyId() )){
						obj.setCompanyId(cId);
					}
					workshopList.add(obj);
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
			String cId = userSession.getCompanyId();
			String fId = userSession.getFactoryId();
			String wId = userSession.getWorkshopId();
			
			if( StringUtils.isNotBlank( cId ) &&  StringUtils.isNotBlank( fId ) && StringUtils.isNotBlank( wId ))
			{
				//表示车间级
				return GroupCategory.WORKSHOP;
			}
			else if( StringUtils.isNotBlank( cId ) &&  StringUtils.isNotBlank( fId ) && StringUtils.isBlank( wId ))
			{
				//表示是工厂级
				return GroupCategory.FACTORY;
			}
			else if( StringUtils.isNotBlank( cId ) &&  StringUtils.isBlank( fId ) && StringUtils.isBlank( wId ))
			{
				//表示公司级
				return GroupCategory.COMPANY;
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


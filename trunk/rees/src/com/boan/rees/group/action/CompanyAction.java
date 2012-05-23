/**
 * Copyright (c) 2012 Changchun Boan Co. Ltd.
 * All right reserved.
 * History
 */
/*
 * @(#)PointDataInfo.java 1.1 2012-3-6
 */
package com.boan.rees.group.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.boan.rees.common.GroupConfig;
import com.boan.rees.common.Message;
import com.boan.rees.group.model.Company;
import com.boan.rees.group.service.ICompanyService;
import com.boan.rees.utils.action.BaseActionSupport;
import com.boan.rees.utils.page.Pagination;

/**
 * 公司管理Action
 * 
 * @author YangGY
 * @version 1.0.0
 */
@Controller( "companyAction" )
@Scope( "prototype" )
public class CompanyAction extends BaseActionSupport
{
	/**
	 * 公司Service
	 */
	@Autowired
	@Qualifier( "companyService" )
	private ICompanyService service = null;

	/**
	 * 显示分页
	 */
	private Pagination<Company> pagination = new Pagination<Company>();

	/**
	 * 页面对象
	 */
	private Company company = null;

	/**
	 * 所选对象的id
	 */
	private String[] ids = null;
	
	/**
	 * 提示
	 */
	private Message message = new Message();

	/**
	 * 显示公司列表
	 * 
	 * @return
	 */
	public String openCompany()
	{
		pagination = service.findCompanyForPage( null, pagination );
		return SUCCESS;
	}

	/**
	 * 打开添加页面
	 * 
	 * @return
	 */
	public String openAddCompany()
	{
		return SUCCESS;
	}

	/**
	 * 添加一个新公司
	 * 
	 * @return
	 */
	public String toAddCompany()
	{
		// 验证用户名是否重复
		boolean b = service.isExistSameName( company.getId(), company.getCompanyName() );
		// 如果存在，则提示
		if( b )
		{
			message.setContent( "相同级别名称已存在，请重新输入！" );
			return ERROR;
		}
		else
		{
			company.setRootId( GroupConfig.ROOT_ID );
			service.save( company );
			message.setContent( "级别信息保存成功！" );
			return SUCCESS;
		}
	}

	/**
	 * 打开修改公司信息页面
	 * 
	 * @return
	 */
	public String openModifyCompany()
	{
		String id = company.getId();
		company = service.get( id );
		return SUCCESS;
	}

	/**
	 * 修改公司信息
	 * 
	 * @return
	 */
	public String toModifyCompany()
	{
		// 验证用户名是否重复
		boolean b = service.isExistSameName( company.getId(), company.getCompanyName() );
		// 如果存在，则提示
		if( b )
		{
			message.setContent( "相同级别名称已存在，请重新输入！" );
			return ERROR;
		}
		else
		{
			company.setRootId( GroupConfig.ROOT_ID );
			service.update( company );
			message.setContent( "级别信息保存成功！" );
			return SUCCESS;
		}
	}

	/**
	 * 删除公司
	 * 
	 * @return
	 */
	public String deleteCompany()
	{
		service.deleteGroupCompany( ids );
		return NONE;
	}

	public Company getCompany()
	{
		return company;
	}

	public void setCompany( Company company )
	{
		this.company = company;
	}

	public Pagination<Company> getPagination()
	{
		return pagination;
	}

	public void setPagination( Pagination<Company> pagination )
	{
		this.pagination = pagination;
	}

	public String[] getIds()
	{
		return ids;
	}

	public void setIds( String[] ids )
	{
		this.ids = ids;
	}

	public Message getMessage()
	{
		return message;
	}

	public void setMessage( Message message )
	{
		this.message = message;
	}
}

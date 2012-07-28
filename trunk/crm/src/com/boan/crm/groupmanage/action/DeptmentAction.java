/**
 * Copyright (c) 2012 Changchun Boan Co. Ltd.
 * All right reserved.
 * History
 */
/*
 * @(#)PointDataInfo.java 1.1 2012-3-6
 */
package com.boan.crm.groupmanage.action;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.boan.crm.common.Message;
import com.boan.crm.groupmanage.model.Deptment;
import com.boan.crm.groupmanage.service.IDeptmentService;
import com.boan.crm.utils.action.BaseActionSupport;
import com.boan.crm.utils.page.Pagination;

/**
 * 部门管理Action
 * 
 * @author XXX
 * @version 1.0.0
 */
@Controller( "deptmentAction" )
@Scope( "prototype" )
public class DeptmentAction extends BaseActionSupport
{
	/**
	 * 部门Service
	 */
	@Autowired
	@Qualifier( "deptService" )
	private IDeptmentService service = null;

	/**
	 * 显示分页
	 */
	private Pagination<Deptment> pagination = new Pagination<Deptment>();

	/**
	 * 页面对象
	 */
	private Deptment deptment = null;

	/**
	 * 所选对象的id
	 */
	private String[] ids = null;
	
	/**
	 * 提示
	 */
	private Message message = new Message();
	
	/**
	 * 公司id
	 */
	private String companyId = null;
	/**
	 * 维护人标识，是超级管理员还是公司内部人员维护的
	 */
	private String who = null;

	/**
	 * 显示公司列表
	 * 
	 * @return
	 */
	public String openDeptment()
	{
		//表示是公司里的管理员维护的用户,此时companyId要从session中获取
		if( "session".equals(who) ){
			companyId = sessionCompanyId;
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put( "companyId", companyId );
		pagination = service.findDeptmentForPage( map, pagination );
		return SUCCESS;
	}

	/**
	 * 打开添加页面
	 * 
	 * @return
	 */
	public String openAddDeptment()
	{
		return SUCCESS;
	}

	/**
	 * 添加一个新公司
	 * 
	 * @return
	 */
	public String toAddDeptment()
	{
		// 验证用户名是否重复
		boolean b = service.isExistSameName( deptment.getId(), deptment.getDeptName() );
		// 如果存在，则提示
		if( b )
		{
			message.setContent( "相同部门名称已存在，请重新输入！" );
			return ERROR;
		}
		else
		{
			deptment.setCompanyId( companyId );
			service.save( deptment );
			message.setContent( "部门信息保存成功！" );
			return SUCCESS;
		}
	}

	/**
	 * 打开修改公司信息页面
	 * 
	 * @return
	 */
	public String openModifyDeptment()
	{
		String id = deptment.getId();
		deptment = service.get( id );
		return SUCCESS;
	}

	/**
	 * 修改公司信息
	 * 
	 * @return
	 */
	public String toModifyDeptment()
	{
		// 验证用户名是否重复
		boolean b = service.isExistSameName( deptment.getId(), deptment.getDeptName() );
		// 如果存在，则提示
		if( b )
		{
			message.setContent( "相同部门名称已存在，请重新输入！" );
			return ERROR;
		}
		else
		{
			deptment.setCompanyId( companyId );
			service.update( deptment );
			message.setContent( "部门信息保存成功！" );
			return SUCCESS;
		}
	}

	/**
	 * 删除公司
	 * 
	 * @return
	 */
	public String deleteDeptment()
	{
		service.deleteGroupDeptment( ids );
		return NONE;
	}

	public Deptment getDeptment()
	{
		return deptment;
	}

	public void setDeptment( Deptment deptment )
	{
		this.deptment = deptment;
	}

	public Pagination<Deptment> getPagination()
	{
		return pagination;
	}

	public void setPagination( Pagination<Deptment> pagination )
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

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public String getWho() {
		return who;
	}

	public void setWho(String who) {
		this.who = who;
	}
}

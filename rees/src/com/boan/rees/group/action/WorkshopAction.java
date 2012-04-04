package com.boan.rees.group.action;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.boan.rees.group.model.Workshop;
import com.boan.rees.group.service.IWorkshopService;
import com.boan.rees.utils.action.BaseActionSupport;
import com.boan.rees.utils.page.Pagination;

@Controller( "workshopAction" )
@Scope( "prototype" )
public class WorkshopAction extends BaseActionSupport
{
	@Autowired
	@Qualifier( "workshopService" )
	private IWorkshopService service = null;

	private Pagination<Workshop> pagination = new Pagination<Workshop>();

	private Workshop workshop = null;

	private String[] ids = null;

	private String factoryId = null;

	/**
	 * 显示车间列表
	 * 
	 * @return
	 */
	public String openWorkshop()
	{
		Map<String, Object> map = new HashMap<String, Object>();
		map.put( "factoryId", factoryId );
		pagination = service.findWorkshopForPage( map, pagination );
		return SUCCESS;
	}

	/**
	 * 打开添加页面
	 * 
	 * @return
	 */
	public String openAddWorkshop()
	{
		return SUCCESS;
	}

	/**
	 * 添加
	 * 
	 * @return
	 */
	public String toAddWorkshop()
	{
		workshop.setFactoryId( factoryId );
		service.save( workshop );
		return SUCCESS;
	}

	/**
	 * 打开修改页面
	 * 
	 * @return
	 */
	public String openModifyWorkshop()
	{
		return SUCCESS;
	}

	/**
	 * 修改
	 * 
	 * @return
	 */
	public String toModifyWorkshop()
	{
		service.update( workshop );
		return SUCCESS;
	}

	/**
	 * 删除信息
	 * 
	 * @return
	 */
	public String deleteWorkshop()
	{
		service.deleteGroupWorkshop( ids );
		return NONE;
	}

	public Pagination<Workshop> getPagination()
	{
		return pagination;
	}

	public void setPagination( Pagination<Workshop> pagination )
	{
		this.pagination = pagination;
	}

	public Workshop getWorkshop()
	{
		return workshop;
	}

	public void setWorkshop( Workshop workshop )
	{
		this.workshop = workshop;
	}

	public String[] getId()
	{
		return ids;
	}

	public void setId( String[] ids )
	{
		this.ids = ids;
	}

	public String getFactoryId()
	{
		return factoryId;
	}

	public void setFactoryId( String factoryId )
	{
		this.factoryId = factoryId;
	}

	public String[] getIds()
	{
		return ids;
	}

	public void setIds( String[] ids )
	{
		this.ids = ids;
	}
}

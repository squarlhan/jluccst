package com.boan.rees.group.action;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.boan.rees.common.Message;
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
	
	private Message message = new Message();

	/**
	 * 显示车间列表
	 * 
	 * @return
	 */
	public String openWorkshop()
	{
		Map<String, Object> map = new HashMap<String, Object>();
		if( factoryId==null){
			System.out.println("工厂id没有传递 ！");
		}else{
			map.put( "factoryId", factoryId );
			pagination = service.findWorkshopForPage( map, pagination );
		}
		
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
		// 验证用户名是否重复
		boolean b = service.isExistSameName( factoryId, workshop.getId(), workshop.getWorkshopName() );
		// 如果存在，则提示
		if( b )
		{
			message.setContent( "相同车间名称已存在，请重新输入！" );
			return ERROR;
		}
		else
		{
			workshop.setFactoryId( factoryId );
			service.save( workshop );
			message.setContent( "车间信息保存成功！" );
			return SUCCESS;
		}
	}

	/**
	 * 打开修改页面
	 * 
	 * @return
	 */
	public String openModifyWorkshop()
	{
		String id = workshop.getId();
		workshop = service.get( id );
		return SUCCESS;
	}

	/**
	 * 修改
	 * 
	 * @return
	 */
	public String toModifyWorkshop()
	{
		// 验证用户名是否重复
		boolean b = service.isExistSameName(factoryId, workshop.getId(), workshop.getWorkshopName() );
		// 如果存在，则提示
		if( b )
		{
			message.setContent( "相同车间名称已存在，请重新输入！" );
			return ERROR;
		}
		else
		{
			workshop.setFactoryId( factoryId );
			service.update( workshop );
			message.setContent( "车间信息保存成功！" );
			return SUCCESS;
		}
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

	public Message getMessage()
	{
		return message;
	}

	public void setMessage( Message message )
	{
		this.message = message;
	}
}

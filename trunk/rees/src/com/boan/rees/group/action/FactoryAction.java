package com.boan.rees.group.action;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.boan.rees.common.Message;
import com.boan.rees.group.model.Factory;
import com.boan.rees.group.service.IFactoryService;
import com.boan.rees.utils.action.BaseActionSupport;
import com.boan.rees.utils.page.Pagination;

@Controller( "factoryAction" )
@Scope( "prototype" )
public class FactoryAction extends BaseActionSupport
{
	@Autowired
	@Qualifier( "factoryService" )
	private IFactoryService service = null;

	/**
	 * 显示分页
	 */
	private Pagination<Factory> pagination = new Pagination<Factory>();

	/**
	 * 页面对象
	 */
	private Factory factory = null;

	/**
	 * 所选对象的id
	 */
	private String[] ids = null;
	
	/**
	 * 公司ID
	 */
	private String companyId = null;
	
	/**
	 * 提示
	 */
	private Message message = new Message();

	/**
	 * 显示工厂列表
	 * 
	 * @return
	 */
	public String openFactory()
	{
		Map<String, Object> map = new HashMap<String, Object>();
		map.put( "companyId", companyId );
		pagination = service.findFactoryForPage( map, pagination );
		return SUCCESS;
	}

	/**
	 * 打开添加工厂页面
	 * 
	 * @return
	 */
	public String openAddFactory()
	{
		return SUCCESS;
	}

	/**
	 * 添加工厂信息
	 * 
	 * @return
	 */
	public String toAddFactory()
	{
		// 验证用户名是否重复
		boolean b = service.isExistSameName( factory.getId(), factory.getFactoryName() );
		// 如果存在，则提示
		if( b )
		{
			message.setContent( "相同公司名称已存在，请重新输入！" );
			return ERROR;
		}
		else
		{
			factory.setCompanyId( companyId );
			service.save( factory );
			message.setContent( "工厂信息保存成功！" );
			return SUCCESS;
		}
	}

	/**
	 * 打开修改信息页面
	 * 
	 * @return
	 */
	public String openModifyFactory()
	{
		String id = factory.getId();
		factory = service.get( id );
		return SUCCESS;
	}

	/**
	 * 修改
	 * 
	 * @return
	 */
	public String toModifyFactory()
	{
		// 验证用户名是否重复
		boolean b = service.isExistSameName( factory.getId(), factory.getFactoryName() );
		// 如果存在，则提示
		if( b )
		{
			message.setContent( "相同工厂名称已存在，请重新输入！" );
			return ERROR;
		}
		else
		{
			factory.setCompanyId( companyId );
			service.update( factory );
			message.setContent( "工厂信息保存成功！" );
			return SUCCESS;
		}
	}

	/**
	 * 删除
	 */
	public String deleteFactory()
	{
		service.deleteGroupFactory( ids );
		return NONE;
	}

	public String[] getIds()
	{
		return ids;
	}

	public void setIds( String[] ids )
	{
		this.ids = ids;
	}

	public Pagination<Factory> getPagination()
	{
		return pagination;
	}

	public void setPagination( Pagination<Factory> pagination )
	{
		this.pagination = pagination;
	}

	public Factory getFactory()
	{
		return factory;
	}

	public void setFactory( Factory factory )
	{
		this.factory = factory;
	}

	public String getCompanyId()
	{
		return companyId;
	}

	public void setCompanyId( String companyId )
	{
		this.companyId = companyId;
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

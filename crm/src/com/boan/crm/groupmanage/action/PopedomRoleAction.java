package com.boan.crm.groupmanage.action;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.boan.crm.common.Message;
import com.boan.crm.groupmanage.model.Popedom;
import com.boan.crm.groupmanage.model.Role;
import com.boan.crm.groupmanage.service.IPopedomService;
import com.boan.crm.groupmanage.service.IRoleService;
import com.boan.crm.utils.action.BaseActionSupport;

@Controller( "popedomAction" )
@Scope( "prototype" )
public class PopedomRoleAction extends BaseActionSupport
{
	@Autowired
	@Qualifier( "popedomService" )
	private IPopedomService popedomService = null;

	@Autowired
	@Qualifier( "roleService" )
	private IRoleService roleService = null;

	private List<Role> roleList = null;

	private Message message = new Message();

	private String menuKey = null;

	private String[] roleIds = null;

	private List<Popedom> popedomList = null;
	
	private String companyId = null;

	/**
	 * 保存权限
	 * 
	 * @return
	 * @throws Exception
	 */
	public String saveOrUpdatePopedom() throws Exception
	{
		popedomService.saveOrUpdatePopedom( menuKey, roleIds );
		message.setContent( "权限设置成功！" );
		return SUCCESS;
	}

	/**
	 * 根据主键串删除权限
	 * 
	 * @return
	 * @throws Exception
	 */
	public String deletePopedom() throws Exception
	{
		popedomService.deletePopedomByIds( menuKey, roleIds );
		showAllPopedomList();
		return SUCCESS;
	}

	/**
	 * 显示角色列表
	 * 
	 * @return
	 * @throws Exception
	 */
	public String showAllRoleList() throws Exception
	{
		roleList = roleService.queryAllRoleList(companyId);
		if( roleList == null )
		{
			roleList = new ArrayList<Role>();
		}
		return SUCCESS;
	}

	/**
	 * 取得已生成的权限列表
	 * 
	 * @return
	 * @throws Exception
	 */
	public String showAllPopedomList() throws Exception
	{
		roleList = popedomService.queryPopedomRoleList( menuKey );
		if( roleList == null )
		{
			roleList = new ArrayList<Role>();
		}
		return SUCCESS;
	}

	public List<Popedom> getPopedomList()
	{
		return popedomList;
	}

	public IPopedomService getPopedomService()
	{
		return popedomService;
	}

	public void setPopedomService( IPopedomService popedomService )
	{
		this.popedomService = popedomService;
	}

	public Message getMessage()
	{
		return message;
	}

	public void setMessage( Message message )
	{
		this.message = message;
	}

	public String getMenuKey()
	{
		return menuKey;
	}

	public void setMenuKey( String menuKey )
	{
		this.menuKey = menuKey;
	}

	public String[] getRoleIds()
	{
		return roleIds;
	}

	public void setRoleIds( String[] roleIds )
	{
		this.roleIds = roleIds;
	}

	public void setPopedomList( List<Popedom> popedomList )
	{
		this.popedomList = popedomList;
	}

	public IRoleService getRoleService()
	{
		return roleService;
	}

	public void setRoleService( IRoleService roleService )
	{
		this.roleService = roleService;
	}

	public List<Role> getRoleList()
	{
		return roleList;
	}

	public void setRoleList( List<Role> roleList )
	{
		this.roleList = roleList;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
}

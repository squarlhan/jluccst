package com.boan.crm.group.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.boan.crm.common.Message;
import com.boan.crm.group.model.Role;
import com.boan.crm.group.service.IRoleService;
import com.boan.crm.utils.action.BaseActionSupport;
import com.boan.crm.utils.page.Pagination;

/**
 * 角色管理Action
 * 
 * @author YangGY
 * @version 1.0.0
 */
@Controller( "roleAction" )
@Scope( "prototype" )
public class RoleAction extends BaseActionSupport
{
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 944641051926536918L;
	/**
	 * 角色Service
	 */
	@Autowired
	@Qualifier( "roleService" )
	private IRoleService service=null;
	/**
	 * 显示分页
	 */
	private Pagination<Role> pagination = new Pagination<Role>();
	/**
	 * 页面对象
	 */
	private Role role=null;
	/**
	 * 所选对象的id
	 */
	private String[] ids = null;
	
	/**
	 * 提示
	 */
	private Message message = new Message();
	
	/**
	 * 显示角色列表
	 * 
	 * @return
	 */
	public String openRole(){
		pagination =service.findRoleForPage(null, pagination);
		return SUCCESS;
	}
	/**
	 * 打开添加页面
	 * 
	 * @return
	 */
	public String openAddRole(){
		return SUCCESS;
	}
	/**
	 * 添加角色
	 * 
	 * @return
	 */
	public String toAddRole(){
		// 验证用户名是否重复
		boolean b = service.isExistSameName( role.getId(), role.getRoleName() );
		// 如果存在，则提示
		if( b )
		{
			message.setContent( "相同角色名称已存在，请重新输入！" );
			return ERROR;
		}
		else
		{
			service.save( role );
			message.setContent( "角色信息保存成功！" );
			return SUCCESS;
		}
	}
	/**
	 * 打开修改角色页面
	 * 
	 * @return
	 */
	public String openModifyRole(){
		String id=role.getId();
		role=service.get(id);
		return SUCCESS;
	}
	
	/**
	 * 修改角色
	 * 
	 * @return
	 */
	public String toModifyRole(){
		boolean b = service.isExistSameName( role.getId(), role.getRoleName() );
		// 如果存在，则提示
		if( b )
		{
			message.setContent( "相同角色名称已存在，请重新输入！" );
			return ERROR;
		}
		else
		{
			service.update(role);
			message.setContent( "角色信息保存成功！" );
			return SUCCESS;
		}
	}
	
	/**
	 * 删除角色
	 * 
	 * @return
	 */
	public String deleteRole(){
		service.deleteGroupRole(ids);
		return NONE;
	}
	public Pagination<Role> getPagination() {
		return pagination;
	}
	public void setPagination(Pagination<Role> pagination) {
		this.pagination = pagination;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public String[] getIds() {
		return ids;
	}
	public void setIds(String[] ids) {
		this.ids = ids;
	}
	public Message getMessage() {
		return message;
	}
	public void setMessage(Message message) {
		this.message = message;
	}	
}

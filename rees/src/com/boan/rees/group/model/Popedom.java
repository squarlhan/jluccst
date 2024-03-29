package com.boan.rees.group.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * 权限实体类
 * 
 * @author Guiyun Yang
 * @version 1.0.0
 */
@Entity
@Table( name = "GROUP_POPEDOM_ROLE" )
public class Popedom
{

	@Id
	@GenericGenerator( name = "system-uuid", strategy = "uuid" )
	@GeneratedValue( generator = "system-uuid" )
	/**
	 * 权限实体主键
	 */
	private String id;

	/**
	 * 角色号
	 */
	@Column( name = "ROLE_ID" )
	private String roleId;

	/**
	 * 资源KEY标识
	 */
	@Column( name = "KEYWORD" )
	private String keyword;

	public String getId()
	{
		return id;
	}

	public void setId( String id )
	{
		this.id = id;
	}

	public String getRoleId()
	{
		return roleId;
	}

	public void setRoleId( String roleId )
	{
		this.roleId = roleId;
	}

	public String getKeyword()
	{
		return keyword;
	}

	public void setKeyword( String keyword )
	{
		this.keyword = keyword;
	}

}

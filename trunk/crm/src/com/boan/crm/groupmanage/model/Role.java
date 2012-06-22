package com.boan.crm.groupmanage.model;

import java.util.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * 角色实体类
 * 
 * @author Guiyun Yang
 * @version 1.0.0
 */
@Entity
@Table( name = "GROUP_ROLE" )
public class Role
{

	@Id
	@GenericGenerator( name = "system-uuid", strategy = "uuid" )
	@GeneratedValue( generator = "system-uuid" )
	/**
	 * 角色实体主键
	 */
	private String id;
	public Role()
	{
		this.id="";
	}

	/**
	 * 角色名称
	 */
	@Column( name = "ROLE_NAME" )
	private String roleName;

	/**
	 * 角色创建时间
	 */
	@Column( name = "CREATE_TIME" )
	private Calendar createTime;

	/**
	 * 角色排序号
	 */
	@Column( name = "SORT_INDEX" )
	private int sortIndex;

	public String getId()
	{
		return id;
	}

	public void setId( String id )
	{
		this.id = id;
	}

	public String getRoleName()
	{
		return roleName;
	}

	public void setRoleName( String roleName )
	{
		this.roleName = roleName;
	}

	public Calendar getCreateTime()
	{
		return createTime;
	}

	public void setCreateTime( Calendar createTime )
	{
		this.createTime = createTime;
	}

	public int getSortIndex()
	{
		return sortIndex;
	}

	public void setSortIndex( int sortIndex )
	{
		this.sortIndex = sortIndex;
	}

}

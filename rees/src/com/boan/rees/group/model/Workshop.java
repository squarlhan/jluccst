package com.boan.rees.group.model;

import java.util.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * 车间实体类
 * 
 * @author Guiyun Yang
 * @version 1.0.0
 */
@Entity
@Table( name = "GROUP_WORKSHOP" )
public class Workshop
{

	@Id
	@GenericGenerator( name = "system-uuid", strategy = "uuid" )
	@GeneratedValue( generator = "system-uuid" )
	/**
	 * 车间实体主键
	 */
	private String id;

	/**
	 * 工厂编号
	 */
	@Column( name = "FACTORY_ID" )
	private String factoryId;

	/**
	 * 车间名称
	 */
	@Column( name = "WORKSHOP_NAME" )
	private String workshopName;

	/**
	 * 车间电话
	 */
	@Column( name = "PHONE" )
	private String phone;

	/**
	 * 车间负责人
	 */
	@Column( name = "PRINCIPAL" )
	private String principal;

	/**
	 * 排序号
	 */
	@Column( name = "SORT_INDEX" )
	private int sortIndex;

	/**
	 * 创建时间
	 */
	@Column( name = "CREATE_TIME" )
	private Calendar createTime = Calendar.getInstance();

	public String getId()
	{
		return id;
	}

	public void setId( String id )
	{
		this.id = id;
	}

	public String getFactoryId()
	{
		return factoryId;
	}

	public void setFactoryId( String factoryId )
	{
		this.factoryId = factoryId;
	}

	public String getWorkshopName()
	{
		return workshopName;
	}

	public void setWorkshopName( String workshopName )
	{
		this.workshopName = workshopName;
	}

	public String getPhone()
	{
		return phone;
	}

	public void setPhone( String phone )
	{
		this.phone = phone;
	}

	public int getSortIndex()
	{
		return sortIndex;
	}

	public void setSortIndex( int sortIndex )
	{
		this.sortIndex = sortIndex;
	}

	public Calendar getCreateTime()
	{
		return createTime;
	}

	public void setCreateTime( Calendar createTime )
	{
		this.createTime = createTime;
	}

	public String getPrincipal()
	{
		return principal;
	}

	public void setPrincipal( String principal )
	{
		this.principal = principal;
	}

}

/**
 * Copyright (c) 2012 Changchun CBIT Co. Ltd.
 * All right reserved.
 * History
 */
/*
 * @(#)IBaseDao.java 1.1 2012-3-5
 */

package com.boan.rees.utils.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * 基本Dao接口
 * @author ZhuYF
 * @version 1.0.0
 */
public interface IBaseDao<T, ID extends Serializable> {
	
	/**
	 * 保持实体
	 * @param entiy 待保存的对象
	 */
	public void save(final T entity);
	
	/**
	 * 保存或修改对象
	 * @param entity 待保存的对象
	 */
	public void saveOrUpdate(final T entity);
	
	/**
	 * 修改对象
	 * @param entity 待修改的对象
	 */
	public void update(final T entity);
	
	/**
	 * 执行hql语句
	 * @param hql
	 * @param values
	 */
	public void executeHql( String hql,Map<String, ?> values );
	
	/**
	 * 删除实体对象
	 * @param entity 待删除的对象
	 * @return
	 */
	public void delete(final T entity);
	
	/**
	 * 删除指定Id的对象
	 * @param id 指定的Id
	 */
	public void delete(final ID id);
	
//	/**
//	 * 指定多个Id，批量删除对象
//	 * @param ids  指定的Id
//	 */
//	public void delete(final Collection<ID> ids);
	
	/**
	 * 指定多个Id，批量删除对象
	 * @param ids  指定的Id
	 */
	public void delete( ID[] ids);
	
	/**
	 * 通过Id查询对象
	 * @param id 指定的Id
	 * @return 获取的对象
	 */
	public T get(final ID id);
	
	/**
	 * 指定多个Id，查询多个对象
	 * @param ids 指定的Id
	 * @return 对象数组
	 */
	public List<T> get(final Collection<ID> ids);
	
	/**
	 * 查询所有对象
	 * @return 对象数组
	 */
	public List<T> findAll();
	
	/**
	 * 查询所有对象并指定排序字段
	 * @param orderByProperty 排序字段
	 * @param isAsc 是否是降序排列
	 * @return 对象数组
	 */
	public List<T> findAll(String orderByProperty, boolean isAsc);
	
	/**
	 * 指定单个属性，查询符合条件的对象
	 * @param propertyName 指定属性
	 * @param value 属性值
	 * @return 对象数组
	 */
	public List<T> findByProperty(final String propertyName, final Object value);
	
	/**
	 * 通过Hql语句查询对象
	 * @param <X> 返回的数组类型
	 * @param hql hql语句
	 * @param values hql参数
	 * @return 数组对象
	 */
	public <X> List<X> find(final String hql, final Object... values);
	
	/**
	 * 通过Hql语句查询对象
	 * @param <X> 返回的数组类型
	 * @param hql hql语句
	 * @param values hql参数
	 * @return 数组对象
	 */
	public <X> List<X> find(final String hql, final Map<String, ?> values);
	
	/**
	 * 查询列表，用于分页
	 * @param <X> 返回的数组类型
	 * @param hql hql语句
	 * @param values hql参数
	 * @param pageNo 当前页码
	 * @param pageSize 每页行数
	 * @return
	 */
	public <X> List<X> findForPage(String hql, Map<String, ?> values,int pageNo, int pageSize);
	
	/**
	 * 查询列表，用于分页
	 * @param <X> 返回的数组类型
	 * @param hql hql语句
	 * @param values hql参数
	 * @return
	 */
	public int findCountForPage(String hql, Map<String, ?> values);
}



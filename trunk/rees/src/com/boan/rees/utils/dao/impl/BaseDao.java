/**
 * Copyright (c) 2012 Changchun CBIT Co. Ltd.
 * All right reserved.
 * History
 */
/*
 * @(#)BaseDao.java 1.1 2012-3-5
 */

package com.boan.rees.utils.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.stat.Statistics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.boan.rees.utils.dao.IBaseDao;

/**
 * 基本Dao实现
 * @author ZhuYF
 * @version 1.0.0
 */
@Repository("baseDao")
public class BaseDao<T, ID extends Serializable> implements IBaseDao<T, ID> {

	@Autowired
	protected SessionFactory sessionFactory;

	protected Class<T> entityClass;

	public BaseDao() {
		entityClass = getEntityClass();
	}

	@SuppressWarnings("unchecked")
	protected Class<T> getEntityClass() {
		Type type = getClass().getGenericSuperclass();
		Class<T> result = null;
		if (type instanceof ParameterizedType) {
			ParameterizedType pType = (ParameterizedType) type;
			result = (Class<T>) pType.getActualTypeArguments()[0];
		}
		return result;
	}

	/**
	 * 取得当前Session.
	 */
	public Session getSession() {
		Statistics statistics = sessionFactory.getStatistics();
//		System.out.println("Hibernate Session:"); 
//		System.out.println("A:"+statistics.getSessionOpenCount()); 
//		System.out.println("B:"+statistics.getSessionCloseCount()); 
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void save(T entity) {
		getSession().save(entity);
	}

	@Override
	public void saveOrUpdate(T entity) {
		getSession().saveOrUpdate(entity);
	}

	@Override
	public void update(T entity) {
		getSession().update(entity);
	}

	@Override
	public void delete(T entity) {
		getSession().delete(entity);
	}

	@Override
	public void delete(ID id) {
		Query query = getSession().createQuery("delete from " + entityClass.getName() + " where id=:id");
		query.setParameter("id", id);
		query.executeUpdate();
	}

//	/**
//	 * 指定多个Id，批量删除对象
//	 * @param ids  指定的Id
//	 */
//	public void delete(final Collection<ID> ids){
//		Query query = getSession().createQuery("delete from " + entityClass.getName() + " where id in (:id)");
//		query.setParameterList("id", ids);
//		query.executeUpdate();
//	}
	
	@Override
	public void delete( ID[] ids) {
		Query query = getSession().createQuery("delete from " + entityClass.getName() + " where id in (:id)");
		query.setParameterList("id", ids);
		query.executeUpdate();
	}

	@SuppressWarnings("unchecked")
	@Override
	public T get(ID id) {
		return (T) getSession().get(entityClass, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> get(Collection<ID> ids) {
		Query query = getSession().createQuery("from " + entityClass.getName() + " where id in (:id)");
		query.setParameterList("id", ids);
		return query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAll() {
		Query query = getSession().createQuery("from " + entityClass.getName());
		return query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAll(String orderByProperty, boolean isAsc) {
		Criteria criteria = getSession().createCriteria(entityClass);
		if (isAsc) {
			criteria.addOrder(Order.asc(orderByProperty));
		} else {
			criteria.addOrder(Order.desc(orderByProperty));
		}
		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findByProperty(String propertyName, Object value) {
		Query query = getSession().createQuery("from " + entityClass.getName() + " where "+propertyName+" =:propertyName)");
		query.setParameter("propertyName", value);
		return query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public <X> List<X> find(String hql, Object... values) {
		Query query = getSession().createQuery(hql);
		for(int i=0 ;i<values.length;i++){
			query.setParameter(i, values[i]);
		}
		return query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public <X> List<X> find(String hql, Map<String, ?> values) {
		Query query = getSession().createQuery(hql);
		if (values != null) {
			query.setProperties(values);
		}
		return query.list();
	}
}


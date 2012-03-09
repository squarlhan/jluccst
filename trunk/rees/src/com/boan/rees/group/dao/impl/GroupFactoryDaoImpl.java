/*
 * @(#)GroupFactoryDaoImpl.java 1.1 2012-3-8
 */

package com.boan.rees.group.dao.impl;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.boan.rees.group.dao.IGroupFactoryDao;
import com.boan.rees.group.model.GroupFactory;
import com.boan.rees.utils.dao.impl.BaseDao;

/**
 * 工厂dao接口实现
 * @author Guiyun Yang
 * @version 1.0.0
 */

@Repository("groupFactoryDao")
public class GroupFactoryDaoImpl extends BaseDao<GroupFactory,String> implements IGroupFactoryDao{

	@Override
	protected Class<GroupFactory> getEntityClass() {
		// TODO Auto-generated method stub
		return super.getEntityClass();
	}

	@Override
	public Session getSession() {
		// TODO Auto-generated method stub
		return super.getSession();
	}

	@Override
	public void save(GroupFactory entity) {
		// TODO Auto-generated method stub
		super.save(entity);
	}

	@Override
	public void saveOrUpdate(GroupFactory entity) {
		// TODO Auto-generated method stub
		super.saveOrUpdate(entity);
	}

	@Override
	public void update(GroupFactory entity) {
		// TODO Auto-generated method stub
		super.update(entity);
	}

	@Override
	public void delete(GroupFactory entity) {
		// TODO Auto-generated method stub
		super.delete(entity);
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		super.delete(id);
	}

	@Override
	public void delete(String[] ids) {
		// TODO Auto-generated method stub
		super.delete(ids);
	}

	@Override
	public GroupFactory get(String id) {
		// TODO Auto-generated method stub
		return super.get(id);
	}

	@Override
	public List<GroupFactory> get(Collection<String> ids) {
		// TODO Auto-generated method stub
		return super.get(ids);
	}

	@Override
	public List<GroupFactory> findAll() {
		// TODO Auto-generated method stub
		return super.findAll();
	}

	@Override
	public List<GroupFactory> findAll(String orderByProperty, boolean isAsc) {
		// TODO Auto-generated method stub
		return super.findAll(orderByProperty, isAsc);
	}

	@Override
	public List<GroupFactory> findByProperty(String propertyName, Object value) {
		// TODO Auto-generated method stub
		return super.findByProperty(propertyName, value);
	}

	@Override
	public <X> List<X> find(String hql, Object... values) {
		// TODO Auto-generated method stub
		return super.find(hql, values);
	}

	@Override
	public <X> List<X> find(String hql, Map<String, ?> values) {
		// TODO Auto-generated method stub
		return super.find(hql, values);
	}

}


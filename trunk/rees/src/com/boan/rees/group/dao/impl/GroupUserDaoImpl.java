/*
 * @(#)GroupUserDaoImpl.java 1.1 2012-3-8
 */

package com.boan.rees.group.dao.impl;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.boan.rees.utils.dao.impl.BaseDao;
import com.boan.rees.group.model.GroupUser;
import com.boan.rees.group.dao.IGroupUserDao;
/**
 * 用户dao接口实现
 * @author Guiyun Yang
 * @version 1.0.0
 */

@Repository("groupUserDao")
public class GroupUserDaoImpl extends BaseDao<GroupUser,String> implements IGroupUserDao{

	@Override
	protected Class<GroupUser> getEntityClass() {
		// TODO Auto-generated method stub
		return super.getEntityClass();
	}

	@Override
	public Session getSession() {
		// TODO Auto-generated method stub
		return super.getSession();
	}

	@Override
	public void save(GroupUser entity) {
		// TODO Auto-generated method stub
		super.save(entity);
	}

	@Override
	public void saveOrUpdate(GroupUser entity) {
		// TODO Auto-generated method stub
		super.saveOrUpdate(entity);
	}

	@Override
	public void update(GroupUser entity) {
		// TODO Auto-generated method stub
		super.update(entity);
	}

	@Override
	public void delete(GroupUser entity) {
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
	public GroupUser get(String id) {
		// TODO Auto-generated method stub
		return super.get(id);
	}

	@Override
	public List<GroupUser> get(Collection<String> ids) {
		// TODO Auto-generated method stub
		return super.get(ids);
	}

	@Override
	public List<GroupUser> findAll() {
		// TODO Auto-generated method stub
		return super.findAll();
	}

	@Override
	public List<GroupUser> findAll(String orderByProperty, boolean isAsc) {
		// TODO Auto-generated method stub
		return super.findAll(orderByProperty, isAsc);
	}

	@Override
	public List<GroupUser> findByProperty(String propertyName, Object value) {
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


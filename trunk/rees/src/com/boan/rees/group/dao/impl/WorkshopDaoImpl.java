/*
 * @(#)GroupWorkshopDaoImpl.java 1.1 2012-3-8
 */

package com.boan.rees.group.dao.impl;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.boan.rees.group.dao.IWorkshopDao;
import com.boan.rees.group.model.Workshop;
import com.boan.rees.utils.dao.impl.BaseDao;

/**
 * 车间dao接口实现
 * @author Guiyun Yang
 * @version 1.0.0
 */

@Repository("groupWorkshopDao")
public class WorkshopDaoImpl extends BaseDao<Workshop,String> implements IWorkshopDao{

	
	@Override
	public void update(Workshop entity) {
		// TODO Auto-generated method stub
		super.update(entity);
	}

	@Override
	public void delete(Workshop entity) {
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
	public Workshop get(String id) {
		// TODO Auto-generated method stub
		return super.get(id);
	}

	@Override
	public List<Workshop> get(Collection<String> ids) {
		// TODO Auto-generated method stub
		return super.get(ids);
	}

	@Override
	public List<Workshop> findAll() {
		// TODO Auto-generated method stub
		return super.findAll();
	}

	@Override
	public List<Workshop> findAll(String orderByProperty, boolean isAsc) {
		// TODO Auto-generated method stub
		return super.findAll(orderByProperty, isAsc);
	}

	@Override
	public List<Workshop> findByProperty(String propertyName, Object value) {
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


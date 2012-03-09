package com.boan.rees.group.dao.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.boan.rees.utils.dao.impl.BaseDao;
import com.boan.rees.group.dao.IGroupCompanyDao;
import com.boan.rees.group.model.GroupCompany;
/**
* 公司Dao接口实现
* @author Guiyun Yang
* @version 1.0.0
*/

@Repository("groupCompanyDao")
public class GroupCompanyDaoImpl extends BaseDao<GroupCompany,String> implements IGroupCompanyDao{

	@Override
	protected Class<GroupCompany> getEntityClass() {
		// TODO Auto-generated method stub
		return super.getEntityClass();
	}

	@Override
	public Session getSession() {
		// TODO Auto-generated method stub
		return super.getSession();
	}

	@Override
	public void save(GroupCompany entity) {
		// TODO Auto-generated method stub
		super.save(entity);
	}

	@Override
	public void saveOrUpdate(GroupCompany entity) {
		// TODO Auto-generated method stub
		super.saveOrUpdate(entity);
	}

	@Override
	public void update(GroupCompany entity) {
		// TODO Auto-generated method stub
		super.update(entity);
	}

	@Override
	public void delete(GroupCompany entity) {
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
	public GroupCompany get(String id) {
		// TODO Auto-generated method stub
		return super.get(id);
	}

	@Override
	public List<GroupCompany> get(Collection<String> ids) {
		// TODO Auto-generated method stub
		return super.get(ids);
	}

	@Override
	public List<GroupCompany> findAll() {
		// TODO Auto-generated method stub
		return super.findAll();
	}

	@Override
	public List<GroupCompany> findAll(String orderByProperty, boolean isAsc) {
		// TODO Auto-generated method stub
		return super.findAll(orderByProperty, isAsc);
	}

	@Override
	public List<GroupCompany> findByProperty(String propertyName, Object value) {
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

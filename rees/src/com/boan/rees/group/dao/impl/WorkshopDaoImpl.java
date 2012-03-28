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

@Repository("workshopDao")
public class WorkshopDaoImpl extends BaseDao<Workshop,String> implements IWorkshopDao{

	@Override
	public void deleteWorkshopById(String id) {
		super.delete(id);
		
	}

	
	
}


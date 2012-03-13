/*
 * @(#)GroupFactoryDaoImpl.java 1.1 2012-3-8
 */

package com.boan.rees.group.dao.impl;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.boan.rees.group.dao.IFactoryDao;
import com.boan.rees.group.model.Factory;
import com.boan.rees.utils.dao.impl.BaseDao;

/**
 * 工厂dao接口实现
 * @author Guiyun Yang
 * @version 1.0.0
 */

@Repository("groupFactoryDao")
public class FactoryDaoImpl extends BaseDao<Factory,String> implements IFactoryDao{

	
	
}


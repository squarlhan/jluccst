/*
 * @(#)GoupRoleDaoImpl.java 1.1 2012-3-8
 */

package com.boan.rees.group.dao.impl;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.boan.rees.group.model.Role;
import com.boan.rees.group.dao.IRoleDao;
import com.boan.rees.utils.dao.impl.BaseDao;
/**
 * 角色Dao接口实现
 * @author Guiyun Yang
 * @version 1.0.0
 */
@Repository("roleDao")
public class RoleDaoImpl extends BaseDao<Role,String> implements IRoleDao{

	
	

}


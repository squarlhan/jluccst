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
import com.boan.rees.group.model.User;
import com.boan.rees.group.dao.IUserDao;
/**
 * 用户dao接口实现
 * @author Guiyun Yang
 * @version 1.0.0
 */

@Repository("userDao")
public class UserDaoImpl extends BaseDao<User,String> implements IUserDao{

	
	
}


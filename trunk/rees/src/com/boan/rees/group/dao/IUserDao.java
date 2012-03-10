package com.boan.rees.group.dao;

import org.springframework.stereotype.Repository;

import com.boan.rees.group.model.User;
import com.boan.rees.utils.dao.IBaseDao;


/**
 * 用户Dao接口
 * @author Guiyun Yang
 * @version 1.0.0
 */

@Repository("groupUserDao")
public interface IUserDao extends IBaseDao<User,String>{

}

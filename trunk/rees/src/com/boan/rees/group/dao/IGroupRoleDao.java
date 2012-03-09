package com.boan.rees.group.dao;

import org.springframework.stereotype.Repository;

import com.boan.rees.group.model.GroupRole;
import com.boan.rees.utils.dao.IBaseDao;


/**
 * 角色Dao接口
 * @author Guiyun Yang
 * @version 1.0.0
 */

@Repository("groupRoleDao")
public interface IGroupRoleDao extends IBaseDao<GroupRole,String>{

}

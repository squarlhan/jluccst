package com.boan.rees.group.dao;

import org.springframework.stereotype.Repository;

import com.boan.rees.group.model.GroupPopedomRole;
import com.boan.rees.utils.dao.IBaseDao;


/**
 * 权限Dao接口
 * @author Guiyun Yang
 * @version 1.0.0
 */

@Repository("groupPopeRoleDao")
public interface IGroupPopedomRoleDao extends IBaseDao<GroupPopedomRole,String>{

}

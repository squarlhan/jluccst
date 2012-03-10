package com.boan.rees.group.dao;

import org.springframework.stereotype.Repository;

import com.boan.rees.group.model.PopedomRole;
import com.boan.rees.utils.dao.IBaseDao;


/**
 * 权限Dao接口
 * @author Guiyun Yang
 * @version 1.0.0
 */

@Repository("groupPopeRoleDao")
public interface IPopedomRoleDao extends IBaseDao<PopedomRole,String>{

}

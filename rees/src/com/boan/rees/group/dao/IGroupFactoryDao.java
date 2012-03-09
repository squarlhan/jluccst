package com.boan.rees.group.dao;

import org.springframework.stereotype.Repository;

import com.boan.rees.group.model.GroupFactory;
import com.boan.rees.utils.dao.IBaseDao;


/**
 * 工厂Dao接口
 * @author Guiyun Yang
 * @version 1.0.0
 */

@Repository("groupFactoryDao")
public interface IGroupFactoryDao extends IBaseDao<GroupFactory,String>{

}

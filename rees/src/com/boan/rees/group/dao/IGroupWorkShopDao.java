package com.boan.rees.group.dao;

import org.springframework.stereotype.Repository;

import com.boan.rees.group.model.GroupWorkshop;
import com.boan.rees.utils.dao.IBaseDao;


/**
 * 车间Dao接口
 * @author Guiyun Yang
 * @version 1.0.0
 */

@Repository("groupWorkShopDao")
public interface IGroupWorkShopDao extends IBaseDao<GroupWorkshop,String>{

}

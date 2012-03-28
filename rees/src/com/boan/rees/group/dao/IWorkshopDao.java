package com.boan.rees.group.dao;

import org.springframework.stereotype.Repository;

import com.boan.rees.group.model.Workshop;
import com.boan.rees.utils.dao.IBaseDao;


/**
 * 车间Dao接口
 * @author Guiyun Yang
 * @version 1.0.0
 */

public interface IWorkshopDao extends IBaseDao<Workshop,String>{

	public void deleteWorkshopById(String id);
}

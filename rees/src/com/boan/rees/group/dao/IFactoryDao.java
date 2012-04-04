package com.boan.rees.group.dao;


import com.boan.rees.group.model.Factory;
import com.boan.rees.utils.dao.IBaseDao;

/**
 * 工厂Dao接口
 * 
 * @author Guiyun Yang
 * @version 1.0.0
 */

public interface IFactoryDao extends IBaseDao<Factory, String>
{
	/**
	 * 判断是否重名
	 * 
	 * @param id
	 * @param name
	 * @return
	 */
	public boolean isExistSameName( String id, String name );
}

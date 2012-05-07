package com.boan.rees.group.dao;


import java.util.List;

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
	 * @param companyId
	 * @param name
	 * @return
	 */
	public boolean isExistSameName( String id,String companyId, String name );
	
	/**
	 * 公司id
	 * @param companyId
	 * @return
	 */
	public List<Factory> queryFactoriesByCompanyId( String companyId );
}

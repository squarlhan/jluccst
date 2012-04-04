package com.boan.rees.group.dao;

import java.util.List;

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
	
	/**
	 * 判断是否重名
	 * @param factoryId
	 * @param id
	 * @param name
	 * @return
	 */
	public boolean isExistSameName( String factoryId, String id, String name );
	
	/**
	 * 根据工厂id取车间
	 * @param factoryId
	 * @return
	 */
	public List<Workshop> queryAllWorkshopsByFactoryId( String factoryId );
}

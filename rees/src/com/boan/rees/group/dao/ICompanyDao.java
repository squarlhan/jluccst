package com.boan.rees.group.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.boan.rees.utils.dao.IBaseDao;
import com.boan.rees.group.model.*;


/**
 * 公司Dao接口
 * @author Guiyun Yang
 * @version 1.0.0
 */
public interface ICompanyDao extends IBaseDao<Company,String>{
	
	/**
	 * 判断是否重名
	 * @param id
	 * @param name
	 * @return
	 */
	public boolean isExistSameName( String id, String name );
	
	/**
	 * 查找所有公司列表
	 * @param rootId
	 * @return
	 */
	public List<Company> queryAllCompanysByRootId( String rootId );
}

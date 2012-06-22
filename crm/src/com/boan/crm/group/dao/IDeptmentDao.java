package com.boan.crm.group.dao;

import java.util.List;

import com.boan.crm.group.model.Deptment;
import com.boan.crm.utils.dao.IBaseDao;


/**
 * 公司Dao接口
 * @author XXX
 * @version 1.0.0
 */
public interface IDeptmentDao extends IBaseDao<Deptment,String>{
	
	/**
	 * 判断是否重名
	 * @param id
	 * @param name
	 * @return
	 */
	public boolean isExistSameName( String id, String name );
	
	/**
	 * 查找所有部门列表
	 * @param rootId
	 * @return
	 */
	public List<Deptment> queryAllDeptmentsByRootId( String rootId );
}

package com.boan.crm.groupmanage.dao;

import java.util.List;

import com.boan.crm.groupmanage.model.Deptment;
import com.boan.crm.utils.dao.IBaseDao;


/**
 * 部门Dao接口
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
	public boolean isExistSameName( String id, String name, String companyId );
	
	/**
	 * 查找所有部门列表
	 * @param rootId
	 * @return
	 */
	public List<Deptment> queryAllDeptmentsByCompanyId( String companyId );
}

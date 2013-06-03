package com.boan.crm.backstagemanage.dao;

import java.util.List;

import com.boan.crm.backstagemanage.model.Company;
import com.boan.crm.utils.dao.IBaseDao;

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
	 * @return
	 */
	public List<Company> queryAllCompanys( );
}

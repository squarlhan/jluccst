package com.boan.crm.group.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.boan.crm.group.model.Role;
import com.boan.crm.utils.dao.IBaseDao;


/**
 * 角色Dao接口
 * @author Guiyun Yang
 * @version 1.0.0
 */

public interface IRoleDao extends IBaseDao<Role,String>{

	boolean isExistSameName(String id, String roleName);
	/**
	 * 取得所有角色列表
	 * 
	 * @return 角色列表
	 * @throws Exception
	 */
	public List<Role> queryAllRoleList() throws Exception;
}

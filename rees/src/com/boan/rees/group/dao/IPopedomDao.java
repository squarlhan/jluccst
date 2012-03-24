package com.boan.rees.group.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.boan.rees.group.model.Popedom;
import com.boan.rees.group.model.Role;
import com.boan.rees.utils.dao.IBaseDao;


/**
 * 权限Dao接口
 * @author Guiyun Yang
 * @version 1.0.0
 */


public interface IPopedomDao extends IBaseDao<Popedom,String>{
	/**
	 * 存储权限
	 * 
	 * @param keyword
	 *            关键字
	 * @param roleIds
	 *            角色id串
	 * @throws Exception
	 */
	public void saveOrUpdatePopedom( String keyword, String[] roleIds ) throws Exception;

	/**
	 * 根据权限主键串，删除权限
	 * 
	 * @param keyword
	 *            关键字
	 * @param roleIds
	 *            角色id串
	 * @throws Exception
	 */
	public void deletePopedomByIds(  String keyword,String[] roleIds ) throws Exception;

	/**
	 * 根据关键字，取得权限列表
	 * 
	 * @param keyword
	 *            关键字
	 * @return 权限列表
	 * @throws Exception
	 */
	public List<Role> queryPopedomRoleList( String keyword ) throws Exception;

	/**
	 * 根据角色id，获取这个角色所有的权限Key
	 * @param roleId
	 * @return
	 * @throws Exception
	 */
	public String[] queryPopedomsByRoleId( String roleId ) throws Exception;
	/**
	 * 当角色删除的时候，权限记录也要删除
	 * @param roleIds
	 * 角色id
	 * @throws Excepiton
	 */
	public void deletePopedomByRoleIds( String[] roleIds ) throws Exception;
}

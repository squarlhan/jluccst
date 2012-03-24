/*
 * @(#)IPopedomService 1.1 2012-3-8
 */

package com.boan.rees.group.service;

import java.util.List;
import java.util.Map;

import com.boan.rees.group.model.Popedom;
import com.boan.rees.group.model.Role;
import com.boan.rees.utils.page.Pagination;

/**
 * 权限服务类接口
 * @author Guiyun Yang
 * @version 1.0.0
 */
public interface IPopedomService {
	
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
 * 
 * @param roleId
 * @return
 * @throws Exception
 */
public String[] queryPopedomsByRoleId( String roleId ) throws Exception;

/**
 * 对于一个指定keyword的功能，判断当前登录人是否有权限操作
 * @param userId
 * 			    登录人ID
 * @param userType
 *            登录人用户类型
 * @param keyword
 *            功能的关键字
 * @param popedomKeys
 *            当前登录人的权限串
 * @return 判断是否有权限，有则返回true,没有权限返回false
 * @throws Exception
 */
public boolean isHasPopedom( String userId, String userType, String keyword, String[] popedomKeys ) throws Exception;
/**
 * 当角色删除的时候，权限记录也要删除
 * @param roleIds
 * 角色id
 * @throws Excepiton
 */
public void deletePopedomByRoleIds( String[] roleIds ) throws Exception;
}


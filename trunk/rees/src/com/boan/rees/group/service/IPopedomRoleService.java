/*
 * @(#)IGroupPopedomRoleService.java 1.1 2012-3-8
 */

package com.boan.rees.group.service;

import java.util.List;
import java.util.Map;

import com.boan.rees.group.model.PopedomRole;
import com.boan.rees.utils.page.Pagination;

/**
 * 权限服务类接口
 * @author Guiyun Yang
 * @version 1.0.0
 */
public interface IPopedomRoleService {
	
public List<PopedomRole> findAllGroupPopedomRole();
	
	public PopedomRole get(String id);
	
	public void deleteGroupPopedomRole(String... ids );
	
	public void save(PopedomRole table1);

	Pagination<PopedomRole> findPopedomRoleForPage(Map<String, ?> values,
			Pagination<PopedomRole> pagination);

}


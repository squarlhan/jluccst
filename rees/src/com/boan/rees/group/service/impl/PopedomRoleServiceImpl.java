/*
 * @(#)GroupPopedomRoleServiceImpl.java 1.1 2012-3-9
 */

package com.boan.rees.group.service.impl;

import com.boan.rees.group.dao.IPopedomRoleDao;
import com.boan.rees.group.dao.IRoleDao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.boan.rees.group.model.Factory;
import com.boan.rees.group.model.PopedomRole;
import com.boan.rees.group.service.IPopedomRoleService;
import com.boan.rees.utils.page.Pagination;
/**
 * 权限服务类接口实现
 * @author Guiyun Yang
 * @version 1.0.0
 */

@Service("groupPopedomRoleService")
public class PopedomRoleServiceImpl implements IPopedomRoleService{

	@Autowired
	@Qualifier("groupPopeRoleDao")
	private IPopedomRoleDao groupPopeRoleDao;
	@Override
	/**
	 * 查找全部权限
	 */
	public List<PopedomRole> findAllGroupPopedomRole() {
		return groupPopeRoleDao.findAll();
	}

	@Override
	/**
	 * 取得权限编号
	 */
	public PopedomRole get(String id) {
		return groupPopeRoleDao.get(id);
	}

	@Override
	/**
	 * 根据编号删除权限信息
	 */
	public void deleteGroupPopedomRole(String... ids) {
		groupPopeRoleDao.delete(ids);
	}

	@Override
	/**
	 * 保存权限
	 */
	public void save(PopedomRole table1) {
		groupPopeRoleDao.save(table1);
	}
	
	@Override
	/**
	 * 分页查找权限
	 */
	public Pagination<PopedomRole> findPopedomRoleForPage(Map<String, ?> values,Pagination<PopedomRole> pagination){
		
		String hql = "from Factory";
		List<PopedomRole> data = groupPopeRoleDao.findForPage(hql, values, pagination.getStartIndex(), pagination.getPageSize());
		hql = "select count(*) from Company";
		int totalRows = groupPopeRoleDao.findCountForPage(hql, values);
		pagination.setTotalRows(totalRows);
		pagination.setData(data);
		return pagination;
	}


}


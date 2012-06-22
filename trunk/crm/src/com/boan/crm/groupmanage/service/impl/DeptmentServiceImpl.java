/*
 * @(#)GroupDeptmentServiceImpl.java 1.1 2012-3-9
 */

package com.boan.crm.groupmanage.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.boan.crm.groupmanage.dao.IDeptmentDao;
import com.boan.crm.groupmanage.model.Deptment;
import com.boan.crm.groupmanage.service.IDeptmentService;
import com.boan.crm.utils.page.Pagination;

/**
 * 部门服务类接口实现
 * @author XXX
 * @version 1.0.0
 */
@Service("deptService")
public class DeptmentServiceImpl implements IDeptmentService{

	
	@Autowired
	@Qualifier("deptDao")
	private IDeptmentDao deptDao;

	@Override
	
	/**
	 * 取得部门编号
	 */
	public Deptment get(String id) {
		
		return deptDao.get(id);
	}

	@Override
	
	/**
	 * 根据部门编号删除部门
	 */
	public void deleteGroupDeptment(String... ids) {
		
		deptDao.delete(ids);
	}

	@Override
	
	/**
	 * 保存部门
	 */
	public void save(Deptment table1) {
	
		deptDao.save(table1);
	}
	/**
	 * 修改部门信息
	 */
	public void update(Deptment deptment){
		deptDao.update(deptment);
	}
	
	@Override
	/**
	 * 分页查询部门
	 */
	public Pagination<Deptment> findDeptmentForPage(Map<String, ?> values,Pagination<Deptment> pagination){
		
		String hql = "from Deptment order by sortIndex asc, createTime asc";
		List<Deptment> data = deptDao.findForPage(hql, values, pagination.getStartIndex(), pagination.getPageSize());
		hql = "select count(*) from Deptment";
		int totalRows = deptDao.findCountForPage(hql, values);
		pagination.setTotalRows(totalRows);
		pagination.setData(data);
		return pagination;
	}

	@Override
	public boolean isExistSameName( String id, String name )
	{
		return deptDao.isExistSameName( id, name );
	}

	@Override
	public List<Deptment> queryAllDeptmentsByRootId( String rootId )
	{
		return deptDao.queryAllDeptmentsByRootId( rootId );
	}

}


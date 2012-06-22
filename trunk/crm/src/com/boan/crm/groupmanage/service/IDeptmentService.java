/*
 * @(#)IGroupDeptmentService.java 1.1 2012-3-8
 */

package com.boan.crm.groupmanage.service;

import java.util.List;
import java.util.Map;

import com.boan.crm.groupmanage.model.Deptment;
import com.boan.crm.utils.page.Pagination;

   /**
   * 部门服务接口类
   * @author XXX
   * @version 1.0.0
   */
   public interface IDeptmentService {
   /**
   * 获得某个部门的编号
   * @return
   */
	public Deptment get(String id);
	/**
	   * 删除
	   * @return
	   */
	public void deleteGroupDeptment(String... ids );
	/**
	   * 保存信息
	   * @return
	   */
	public void save(Deptment table1);
	/**
	   * 更新信息
	   * @return
	   */
    public void update(Deptment deptment);
    /**
     * 实现分页
     * @return
     */
	public Pagination<Deptment> findDeptmentForPage(Map<String, ?> values, Pagination<Deptment> pagination);

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


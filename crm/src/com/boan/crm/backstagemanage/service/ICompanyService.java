/*
 * @(#)IGroupCompanyService.java 1.1 2012-3-8
 */

package com.boan.crm.backstagemanage.service;

import java.util.List;
import java.util.Map;

import com.boan.crm.backstagemanage.model.Company;
import com.boan.crm.utils.page.Pagination;

   /**
   * 公司服务接口类
   * @author XXX
   * @version 1.0.0
   */
   public interface ICompanyService {
   /**
   * 获得某个公司的编号
   * @return
   */
	public Company get(String id);
	/**
	   * 删除
	   * @return
	   */
	public void deleteGroupCompany(String... ids );
	/**
	   * 保存信息
	   * @return
	   */
	public void save(Company table1);
	/**
	   * 更新信息
	   * @return
	   */
    public void update(Company company);
    /**
     * 实现分页
     * @return
     */
	public Pagination<Company> findCompanyForPage(Map<String, ?> values, Pagination<Company> pagination);

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


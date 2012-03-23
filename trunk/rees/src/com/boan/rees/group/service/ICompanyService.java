/*
 * @(#)IGroupCompanyService.java 1.1 2012-3-8
 */

package com.boan.rees.group.service;

import java.util.List;
import java.util.Map;

import com.boan.rees.group.model.Company;
import com.boan.rees.utils.page.Pagination;

   /**
   * 公司服务接口类
   * @author Guiyun Yang
   * @version 1.0.0
   */
   public interface ICompanyService {
	/**
	 * 查找所有的公司信息
	 * @return
	 */
   public List<Company> findAllGroupCompany();
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
	Pagination<Company> findCompanyForPage(Map<String, ?> values,
			Pagination<Company> pagination);

}


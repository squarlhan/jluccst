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
	
public List<Company> findAllGroupCompany();
	
	public Company get(String id);
	
	public void deleteGroupCompany(String... ids );
	
	public void save(Company table1);

	Pagination<Company> findCompanyForPage(Map<String, ?> values,
			Pagination<Company> pagination);

}


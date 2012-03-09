/*
 * @(#)IGroupCompanyService.java 1.1 2012-3-8
 */

package com.boan.rees.group.service;

import java.util.List;

import com.boan.rees.group.model.GroupCompany;

/**
 * 公司服务接口类
 * @author Guiyun Yang
 * @version 1.0.0
 */
public interface IGroupCompanyService {
	
public List<GroupCompany> findAllGroupCompany();
	
	public GroupCompany get(String id);
	
	public void deleteGroupCompany(String... ids );
	
	public void save(GroupCompany table1);

}


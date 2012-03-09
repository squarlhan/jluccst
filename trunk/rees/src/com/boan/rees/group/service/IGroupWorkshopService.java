/*
 * @(#)IGroupWorkshopService.java 1.1 2012-3-8
 */

package com.boan.rees.group.service;

import java.util.List;

import com.boan.rees.group.model.GroupWorkshop;

/**
 * 车间服务类接口
 * @author Guiyun Yang
 * @version 1.0.0
 */
public interface IGroupWorkshopService {
	
public List<GroupWorkshop> findAllGroupCompany();
	
	public GroupWorkshop get(String id);
	
	public void deleteGroupCompany(String... ids );
	
	public void save(GroupWorkshop table1);

}


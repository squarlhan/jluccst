/*
 * @(#)IGroupFactoryService.java 1.1 2012-3-8
 */

package com.boan.rees.group.service;

import java.util.List;

import com.boan.rees.group.model.GroupFactory;

/**
 * 工厂服务类接口
 * @author Guiyun Yang
 * @version 1.0.0
 */
public interface IGroupFactoryService {
	
public List<GroupFactory> findAllGroupFactory();
	
	public GroupFactory get(String id);
	
	public void deleteGroupFactory(String... ids );
	
	public void save(GroupFactory table1);

}


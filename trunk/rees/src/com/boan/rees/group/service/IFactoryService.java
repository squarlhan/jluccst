/*
 * @(#)IGroupFactoryService.java 1.1 2012-3-8
 */

package com.boan.rees.group.service;

import java.util.List;

import com.boan.rees.group.model.Factory;

/**
 * 工厂服务类接口
 * @author Guiyun Yang
 * @version 1.0.0
 */
public interface IFactoryService {
	
public List<Factory> findAllGroupFactory();
	
	public Factory get(String id);
	
	public void deleteGroupFactory(String... ids );
	
	public void save(Factory table1);

}


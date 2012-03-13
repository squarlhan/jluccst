/*
 * @(#)IGroupWorkshopService.java 1.1 2012-3-8
 */

package com.boan.rees.group.service;

import java.util.List;
import java.util.Map;

import com.boan.rees.group.model.Workshop;
import com.boan.rees.utils.page.Pagination;

/**
 * 车间服务类接口
 * @author Guiyun Yang
 * @version 1.0.0
 */
public interface IWorkshopService {
	
public List<Workshop> findAllGroupCompany();
	
	public Workshop get(String id);
	
	public void deleteGroupCompany(String... ids );
	
	public void save(Workshop table1);
	public Pagination<Workshop> findWorkshopForPage(Map<String, ?> values,Pagination<Workshop> pagination);
}


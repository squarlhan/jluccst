/**
 * Copyright (c) 2012 Changchun CBIT Co. Ltd.
 * All right reserved.
 * History
 */
/*
 * @(#)IDemoService.java 1.1 2012-3-5
 */

package com.boan.rees.demo.service;

import java.util.List;

import com.boan.rees.demo.model.DemoModel;

/**
 * 例子服务类接口
 * @author ZhuYF
 * @version 1.0.0
 */
public interface IDemoService {
	
	public List<DemoModel> findAllDemoModel();
	
	public DemoModel get(String id);
	
	public void deleteDemoModel(String... ids );
	
	public void save(DemoModel table1);
}


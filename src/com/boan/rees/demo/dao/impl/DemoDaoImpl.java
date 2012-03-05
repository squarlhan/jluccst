/**
 * Copyright (c) 2012 Changchun CBIT Co. Ltd.
 * All right reserved.
 * History
 */
/*
 * @(#)DemoDaoImpl.java 1.1 2012-3-5
 */

package com.boan.rees.demo.dao.impl;

import org.springframework.stereotype.Repository;

import com.boan.rees.demo.dao.IDemoDao;
import com.boan.rees.demo.model.DemoModel;
import com.boan.rees.utils.dao.impl.BaseDao;

/**
 * 例子Dao接口实现
 * @author ZhuYF
 * @version 1.0.0
 */
@Repository("demoDao")
public class DemoDaoImpl extends BaseDao<DemoModel, String> implements IDemoDao{

}


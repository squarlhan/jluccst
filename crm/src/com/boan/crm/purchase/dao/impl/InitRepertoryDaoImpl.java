package com.boan.crm.purchase.dao.impl;

import org.springframework.stereotype.Repository;

import com.boan.crm.purchase.dao.IInitRepertoryDao;
import com.boan.crm.purchase.model.InitRepertory;
import com.boan.crm.utils.dao.impl.BaseDao;

@Repository("initRepertoryDao")
public class InitRepertoryDaoImpl extends BaseDao<InitRepertory, String> implements IInitRepertoryDao {

}

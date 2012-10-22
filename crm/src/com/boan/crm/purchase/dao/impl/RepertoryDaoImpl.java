package com.boan.crm.purchase.dao.impl;

import org.springframework.stereotype.Repository;

import com.boan.crm.purchase.dao.IRepertoryDao;
import com.boan.crm.purchase.model.Repertory;
import com.boan.crm.utils.dao.impl.BaseDao;

@Repository("repertoryDao")
public class RepertoryDaoImpl extends BaseDao<Repertory, String> implements IRepertoryDao {

}

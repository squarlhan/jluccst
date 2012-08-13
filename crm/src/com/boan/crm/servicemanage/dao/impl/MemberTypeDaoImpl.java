package com.boan.crm.servicemanage.dao.impl;

import org.springframework.stereotype.Repository;

import com.boan.crm.servicemanage.dao.IMemberTypeDao;
import com.boan.crm.servicemanage.model.MemberType;
import com.boan.crm.utils.dao.impl.BaseDao;

/**
* 会员类别Dao接口实现
* @author XXX
* @version 1.0.0
*/

@Repository("memberTypeDao")
public class MemberTypeDaoImpl extends BaseDao<MemberType,String> implements IMemberTypeDao{
}

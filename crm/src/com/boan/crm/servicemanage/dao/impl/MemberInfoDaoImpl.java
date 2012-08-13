package com.boan.crm.servicemanage.dao.impl;

import org.springframework.stereotype.Repository;

import com.boan.crm.servicemanage.dao.IMemberInfoDao;
import com.boan.crm.servicemanage.model.MemberInfo;
import com.boan.crm.utils.dao.impl.BaseDao;

/**
* 会员管理Dao接口实现
* @author XXX
* @version 1.0.0
*/

@Repository("memberInfoDao")
public class MemberInfoDaoImpl extends BaseDao<MemberInfo,String> implements IMemberInfoDao{
}

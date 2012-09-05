package com.boan.crm.servicemanage.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.boan.crm.servicemanage.dao.IMemberTypeDao;
import com.boan.crm.servicemanage.model.MemberType;
import com.boan.crm.servicemanage.service.IMemberTypeService;
import com.boan.crm.utils.dao.impl.BaseDao;

/**
 * 会员类别接口实现
 * @author XXX
 * @version 1.0.0
 */
@Service("memberTypeService")
public class MemberTypeServiceImpl extends BaseDao<MemberType,String> implements IMemberTypeService{
	
	@Autowired
	@Qualifier("memberTypeDao")
	private IMemberTypeDao memberTypeDao;

	@Override
	public void deleteMemberType(String... ids) {
		memberTypeDao.delete(ids);
	}

	@Override
	public void saveOrUpdate(MemberType obj) {
		memberTypeDao.saveOrUpdate(obj);
	}

	@Override
	public List<MemberType> memberTypeList(String myCompanyId) {
		//return memberTypeDao.find("from MemberType where myCompanyId=? order by sortIndex asc", new Object[]{myCompanyId});
		return memberTypeDao.find("from MemberType order by sortIndex asc", new Object[0]);
	}

}

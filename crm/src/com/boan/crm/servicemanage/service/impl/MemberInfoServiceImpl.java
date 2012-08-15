package com.boan.crm.servicemanage.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.boan.crm.servicemanage.dao.IMemberInfoDao;
import com.boan.crm.servicemanage.model.MemberInfo;
import com.boan.crm.servicemanage.service.IMemberInfoService;
import com.boan.crm.utils.dao.impl.BaseDao;
import com.boan.crm.utils.page.Pagination;

/**
 * 服务管理类接口实现
 * @author XXX
 * @version 1.0.0
 */
@Service("memberInfoService")
public class MemberInfoServiceImpl extends BaseDao<MemberInfo,String> implements IMemberInfoService{
	
	@Autowired
	@Qualifier("memberInfoDao")
	private IMemberInfoDao memberInfoDao;

	@Override
	public Pagination<MemberInfo> findForPage(Map<String, ?> values,
			Pagination<MemberInfo> pagination) {
		String hql = "from MemberInfo where 1=1";
		if(values!=null){
			if(values.containsKey("companyName")){
				hql= hql + " and companyName like :companyName";
			}
		}
		hql= hql + " order by createTime asc";
		List<MemberInfo> data = memberInfoDao.findForPage(hql, values, pagination.getStartIndex(), pagination.getPageSize());
		hql = "select count(*) from MemberInfo where 1=1";
		if(values!=null){
			if(values.containsKey("companyName")){
				hql= hql + " and companyName like :companyName";
			}
		}
		int totalRows = memberInfoDao.findCountForPage(hql, values);
		pagination.setTotalRows(totalRows);
		pagination.setData(data);
		return pagination;
	}

	@Override
	public boolean isMember(String companyId) {
		return memberInfoDao.isMember(companyId);
	}

	@Override
	public MemberInfo getByCompanyId(String companyId) {
		return memberInfoDao.getByCompanyId(companyId);
	}

	@Override
	public void toMemberInfo(MemberInfo obj) {
		obj.setId(null);
		memberInfoDao.saveOrUpdate(obj);
	}

	@Override
	public MemberInfo getById(String id) {
		return memberInfoDao.get(id);
	}

	@Override
	public void cancelInfo(String... ids) {
		memberInfoDao.delete(ids);
	}

	@Override
	public void updateInfo(MemberInfo obj) {
		memberInfoDao.saveOrUpdate(obj);
	}

}

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
	public void deleteMemberInfo(String... ids) {
		memberInfoDao.delete(ids);
	}

	@Override
	public void saveOrUpdate(MemberInfo obj) {
		memberInfoDao.saveOrUpdate(obj);
	}

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

}

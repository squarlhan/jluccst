package com.boan.crm.servicemanage.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.boan.crm.servicemanage.dao.IServiceLogDao;
import com.boan.crm.servicemanage.model.ServiceLog;
import com.boan.crm.servicemanage.service.IServiceLogService;
import com.boan.crm.utils.dao.impl.BaseDao;
import com.boan.crm.utils.page.Pagination;

/**
 * 服务管理类接口实现
 * @author XXX
 * @version 1.0.0
 */
@Service("serviceLogService")
public class ServiceLogServiceImpl extends BaseDao<ServiceLog,String> implements IServiceLogService{
	
	@Autowired
	@Qualifier("serviceLogDao")
	private IServiceLogDao serviceLogDao;

	@Override
	public void deleteServiceLog(String... ids) {
		serviceLogDao.delete(ids);
	}

	@Override
	public void saveOrUpdate(ServiceLog obj) {
		serviceLogDao.saveOrUpdate(obj);
	}

	@Override
	public Pagination<ServiceLog> findForPage(Map<String, ?> values,
			Pagination<ServiceLog> pagination) {
		String hql = "from ServiceLog where 1=1";
		if(values!=null){
			if(values.containsKey("myCompanyId")){
				hql= hql + " and myCompanyId =:myCompanyId";
			}
			if(values.containsKey("companyName")){
				hql= hql + " and companyName like :companyName";
			}
			if(values.containsKey("companyId")){
				hql= hql + " and companyId =:companyId";
			}
		}
		hql= hql + " order by arriveTime asc";
		List<ServiceLog> data = serviceLogDao.findForPage(hql, values, pagination.getStartIndex(), pagination.getPageSize());
		hql = "select count(*) from ServiceLog where 1=1";
		if(values!=null){
			if(values.containsKey("myCompanyId")){
				hql= hql + " and myCompanyId =:myCompanyId";
			}
			if(values.containsKey("companyName")){
				hql= hql + " and companyName like :companyName";
			}
			if(values.containsKey("companyId")){
				hql= hql + " and companyId = :companyId";
			}
		}
		int totalRows = serviceLogDao.findCountForPage(hql, values);
		pagination.setTotalRows(totalRows);
		pagination.setData(data);
		return pagination;
	}

}

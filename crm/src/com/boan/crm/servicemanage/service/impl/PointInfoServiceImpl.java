package com.boan.crm.servicemanage.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.boan.crm.servicemanage.dao.IPointInfoDao;
import com.boan.crm.servicemanage.dao.IServiceLogDao;
import com.boan.crm.servicemanage.model.PointInfo;
import com.boan.crm.servicemanage.service.IPointInfoService;
import com.boan.crm.servicemanage.service.IServiceLogService;
import com.boan.crm.utils.dao.impl.BaseDao;
import com.boan.crm.utils.page.Pagination;

/**
 * 积分管理类接口实现
 * @author XXX
 * @version 1.0.0
 */
@Service("pointInfoService")
public class PointInfoServiceImpl extends BaseDao<PointInfo,String> implements IPointInfoService{
	
	@Autowired
	@Qualifier("pointInfoDao")
	private IPointInfoDao pointInfoDao;

	@Override
	public void deletePointInfo(String... ids) {
		pointInfoDao.delete(ids);
	}

	@Override
	public void saveOrUpdate(PointInfo obj) {
		pointInfoDao.saveOrUpdate(obj);
	}

	@Override
	public Pagination<PointInfo> findForPage(Map<String, ?> values,
			Pagination<PointInfo> pagination) {
		String hql = "from PointInfo where companyId = :companyId order by consumptionTime asc";
		List<PointInfo> data = pointInfoDao.findForPage(hql, values, pagination.getStartIndex(), pagination.getPageSize());
		hql = "select count(*) from PointInfo  where companyId = :companyId ";
		int totalRows = pointInfoDao.findCountForPage(hql, values);
		pagination.setTotalRows(totalRows);
		pagination.setData(data);
		return pagination;
	}

	@Override
	public PointInfo getByConsumptionId(String consumptionId) {
		return pointInfoDao.getByConsumptionId(consumptionId);
	}

	@Override
	public int getTotalPoint(String companyId) {
		return pointInfoDao.getTotalPoint(companyId);
	}

	@Override
	public float getConsumptionAmount(String companyId) {
		return pointInfoDao.getConsumptionAmount(companyId);
	}

}

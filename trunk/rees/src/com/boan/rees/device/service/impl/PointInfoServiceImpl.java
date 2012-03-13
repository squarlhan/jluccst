package com.boan.rees.device.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.boan.rees.demo.dao.IDemoDao;
import com.boan.rees.device.dao.IPointInfoDao;
import com.boan.rees.device.model.PointDataInfo;
import com.boan.rees.device.model.PointInfo;
import com.boan.rees.device.service.IPointInfoService;
import com.boan.rees.utils.page.Pagination;
@Service("pointInfoService")
public class PointInfoServiceImpl implements IPointInfoService{

	@Autowired
	@Qualifier("pointInfoDao")
	private IPointInfoDao pointInfoDao;
	/**
	 * 查找全部监控点
	 */
	@Override
	public List<PointInfo> findAllPointInfo() {
		
		return pointInfoDao.findAll();
	}
	/**
	 * 根据id查找监控点
	 */

	@Override
	public PointInfo get(String id) {
		
		return pointInfoDao.get(id);
	}
	/**
	 * 根据id删除监控点
	 */

	@Override
	public void deletePointInfo(String... ids) {
		pointInfoDao.delete(ids);
		
	}
	/**
	 * 保存监控点
	 */

	@Override
	public void save(PointInfo table1) {
		pointInfoDao.saveOrUpdate(table1);
		
	}
	/**
	 * 分页查找监控点
	 */
	@Override
	  public Pagination<PointInfo> findPointInfoForPage(Map<String, ?> values,Pagination<PointInfo> pagination){
			
			String hql = "from PointInfo";
			List<PointInfo> data = pointInfoDao.findForPage(hql, values, pagination.getStartIndex(), pagination.getPageSize());
			hql = "select count(*) from PointInfo";
			int totalRows = pointInfoDao.findCountForPage(hql, values);
			pagination.setTotalRows(totalRows);
			pagination.setData(data);
			return pagination;
		}
}

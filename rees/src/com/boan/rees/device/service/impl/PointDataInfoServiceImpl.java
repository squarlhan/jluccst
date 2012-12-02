package com.boan.rees.device.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.boan.rees.device.dao.IPointDataInfoDao;
import com.boan.rees.device.model.PointDataInfo;
import com.boan.rees.device.service.IPointDataInfoService;
import com.boan.rees.utils.page.Pagination;
@Service("pointDataInfoService")
public class PointDataInfoServiceImpl implements IPointDataInfoService{
	
	@Autowired
	@Qualifier("pointDataInfoDao")
	private IPointDataInfoDao pointDataInfoDao;
	/**
	 * 查找全部监控点参数
	 */
	@Override
	public List<PointDataInfo> findAllPointDataInfo() {
		
		return pointDataInfoDao.findAll();
	}
	/**
	 * 根据id查询监控点参数
	 */
	@Override
	public PointDataInfo get(String id) {
		
		return pointDataInfoDao.get(id);
	}
	/**
	 * 根据id删除监控点参数
	 */

	@Override
	public void deletePointDataInfo(String... ids) {
		pointDataInfoDao.delete(ids);
		
	}
	/**
	 * 保存监控点参数
	 */
	@Override
	public void save(PointDataInfo table1) {
		pointDataInfoDao.saveOrUpdate(table1);
		
	}
	/**
	 * 按分页查询监控点参数
	 */
	@Override
  public Pagination<PointDataInfo> findPointDataInfoForPage(Map<String, ?> values,Pagination<PointDataInfo> pagination){
		
		String hql = "from PointDataInfo where deviceId=:deviceId and creatTime>=:beginTime and creatTime<=:endTime order by creatTime desc";
		List<PointDataInfo> data = pointDataInfoDao.findForPage(hql, values, pagination.getStartIndex(), pagination.getPageSize());
		hql = "select count(*) from PointDataInfo where deviceId=:deviceId and creatTime>=:beginTime and creatTime<=:endTime order by creatTime desc";
		int totalRows = pointDataInfoDao.findCountForPage(hql, values);
		pagination.setTotalRows(totalRows);
		pagination.setData(data);
		return pagination;
	}
	@Override
	public PointDataInfo get(String year, String week, String paramId) {
		return pointDataInfoDao.get(year, week, paramId);
	}
	@Override
	public void delete(String deviceId, String year, String week) {
		pointDataInfoDao.delete(deviceId, year, week);
	}
	@Override
	public List<PointDataInfo> listByDeviceId(String year, String week,
			String deviceId) {
		return pointDataInfoDao.listByDeviceId(year, week, deviceId);
	}
	@Override
	public List<PointDataInfo> listByMap(Map<String, ?> values) {
		String hql = "from PointDataInfo where deviceId=:deviceId and creatTime>=:beginTime and creatTime<=:endTime order by creatTime asc";
		List<PointDataInfo> data = pointDataInfoDao.find(hql, values);
		return data;
	}

}

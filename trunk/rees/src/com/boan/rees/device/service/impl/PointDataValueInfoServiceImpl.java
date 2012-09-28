package com.boan.rees.device.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.boan.rees.device.dao.IPointDataValueInfoDao;
import com.boan.rees.device.model.PointDataValueInfo;
import com.boan.rees.device.service.IPointDataValueInfoService;
import com.boan.rees.utils.page.Pagination;
@Service("pointDataValueInfoService")
public class PointDataValueInfoServiceImpl implements IPointDataValueInfoService{
	
	@Autowired
	@Qualifier("pointDataValueInfoDao")
	private IPointDataValueInfoDao dao;
	/**
	 * 查找全部监控点参数
	 */
	@Override
	public List<PointDataValueInfo> findAllPointDataValueInfo() {
		
		return dao.findAll();
	}
	/**
	 * 根据id查询监控点参数
	 */
	@Override
	public PointDataValueInfo get(String id) {
		
		return dao.get(id);
	}
	/**
	 * 根据id删除监控点参数
	 */

	@Override
	public void deletePointDataValueInfo(String... ids) {
		dao.delete(ids);
		
	}
	/**
	 * 保存监控点参数
	 */
	@Override
	public void save(PointDataValueInfo table1) {
		dao.save(table1);
		
	}
	@Override
	public PointDataValueInfo get(String pointDataId, String paramId) {
		return dao.get(pointDataId, paramId);
	}
	@Override
	public void deleteByDataId(String dataId) {
		dao.deleteByDataId(dataId);
	}
	

}

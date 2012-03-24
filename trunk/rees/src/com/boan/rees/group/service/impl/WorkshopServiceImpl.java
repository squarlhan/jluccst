/*
 * @(#)GroupWorkshopServiceImpl.java 1.1 2012-3-9
 */

package com.boan.rees.group.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.boan.rees.device.model.PointInfo;
import com.boan.rees.group.dao.IPopedomDao;
import com.boan.rees.group.model.Workshop;
import com.boan.rees.group.service.IWorkshopService;
import com.boan.rees.group.dao.IWorkshopDao;
import com.boan.rees.utils.page.Pagination;
/**
 * 车间服务类接口实现
 * @author Guiyun Yang
 * @version 1.0.0
 */

@Service("workshopService")
public class WorkshopServiceImpl implements IWorkshopService {

	@Autowired
	@Qualifier("workshopDao")
	private IWorkshopDao groupWorkshopDao;
	/**
	 * 查找所有车间
	 */
	@Override
	public List<Workshop> findAllGroupCompany() {
		
		return groupWorkshopDao.findAll();
	}
	/**
	 * 根据id查找车间
	 */
	@Override
	public Workshop get(String id) {
		
		return groupWorkshopDao.get(id);
	}
	/**
	 * 删除车间
	 */
	@Override
	public void deleteGroupCompany(String... ids) {
		
        groupWorkshopDao.delete(ids);
	}
	/**
	 * 保存车间
	 */
	@Override
	public void save(Workshop table1) {
		
        groupWorkshopDao.save(table1);
	}

	/**
	 * 分页查找车间
	 */
	@Override
	  public Pagination<Workshop> findWorkshopForPage(Map<String, ?> values,Pagination<Workshop> pagination){
			
			String hql = "from Workshop";
			List<Workshop> data = groupWorkshopDao.findForPage(hql, values, pagination.getStartIndex(), pagination.getPageSize());
			hql = "select count(*) from PointInfo";
			int totalRows = groupWorkshopDao.findCountForPage(hql, values);
			pagination.setTotalRows(totalRows);
			pagination.setData(data);
			return pagination;
		}
}

